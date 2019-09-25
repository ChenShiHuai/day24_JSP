package com.qf.zuoye;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 记住上一次的访问时间
 *
 * 1. 可以采用Cookie来完成
 * 2. 在服务器中的Servlet判断是否有一个名为lastTime的cookie
 * 1. 有：不是第一次访问
 *      1. 响应数据：欢迎回来，您上次访问时间为:2018年6月10日11:50:20
 *      2. 写回Cookie：lastTime=2018年6月10日11:50:01
 * 2. 没有：是第一次访问
 *      1. 响应数据：您好，欢迎您首次访问
 *      2. 写回Cookie：lastTime=2018年6月10日11:50:01
 */

@WebServlet("/CookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //获取当前时间，然后格式化
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        //编码前
        System.out.println("编码前："+format);
        String encode = URLEncoder.encode(format, "utf-8");
        System.out.println("编码后："+encode);

        boolean flag = true;//表示是第一次访问
        //遍历所有的cookie
        Cookie[] cookies = request.getCookies();
        if(cookies!=null&&cookies.length>0){
            for(Cookie cookie:cookies){
                String name = cookie.getName();
                if("lastTime".equals(name)){//有：不是第一次访问
                    //1,响应数据
                    String value = cookie.getValue();
                    //解码前：
                    System.out.println("解码前："+value);
                    String decode = URLDecoder.decode(value, "utf-8");
                    System.out.println("解码后："+decode);
                    response.getWriter().println("欢迎回来，您上次访问时间为:"+decode);

                    //2，重写写回Cookie;
                    Cookie c1 = new Cookie("lastTime",encode);
                    response.addCookie(c1);
                    flag=false;//表示不是第一次访问

                    //request.getContextPath();
                }
            }
        }else{

        }

        //第一次访问
        if(flag){
            //1,响应数据
            response.getWriter().println("您好，欢迎您首次访问");

            //2，重写写回Cookie;
            Cookie c1 = new Cookie("lastTime",encode);
            response.addCookie(c1);
        }






    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
