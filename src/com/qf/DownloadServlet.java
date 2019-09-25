package com.qf;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //1,根据参数获取文件名
        String filename = request.getParameter("filename");
        //2,获取文件所在的真实路径
        String path = request.getServletContext().getRealPath("/img/" + filename);
        System.out.println("path:"+path);
        //3,获取文件输入流
        FileInputStream fis = new FileInputStream(path);

        //解决一下中文名的问题
        //获取一下浏览器的版本信息
        String userAgent = request.getHeader("user-agent");
        String fileName_new = DownLoadUtils.getFileName(userAgent, filename);
        System.out.println("fileName_new="+fileName_new);

        //4,设置一下相应头
        response.setHeader("content-disposition","attachment;filename="+fileName_new);

        //5获取输出流
        ServletOutputStream outputStream = response.getOutputStream();

        //6,从输入流拷贝到输出流
        byte[] buff = new byte[1024];
        int len=0;
        while ((len=fis.read(buff))!=-1){
            outputStream.write(buff,0,len);
        }

        //7关闭资源
        outputStream.close();
        fis.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
