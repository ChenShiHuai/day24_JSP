package com.qf;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@WebServlet("/uploadServlet")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        try {
//            upload(request,response);
//        } catch (FileUploadException e) {
//            e.printStackTrace();
//        }
        //上传到本地服务器
        try {
            upload2(request,response);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    /**
     * 上传文件到本地服务器
     * @param request
     * @param response
     */
    public void upload2(HttpServletRequest request, HttpServletResponse response) throws FileUploadException, IOException {
        //1,获取磁盘工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //2,根据工厂获取上传对象
        ServletFileUpload upload = new ServletFileUpload(factory);
        //3,用上传对象解析请求
        List<FileItem> list = upload.parseRequest(request);
        //4,遍历
        for(FileItem fileItem:list){
            //5,判断是否是上传文件
            if(!fileItem.isFormField()){
                //6,获取文件的输入流
                InputStream is = fileItem.getInputStream();

                
                //7,在服务器的部署目录创建相应的路径
                ServletContext servletContext = request.getServletContext();
                String uploadPath = servletContext.getRealPath("/uploadFiles");
                System.out.println("uploadPath:"+uploadPath);
                File file =  new File(uploadPath);
                //如果目录不存在，那么创建目录
                if(!file.exists()){
                    file.mkdir();//创建目录
                }

                //8,解决文件重名问题
                UUID uuid = UUID.randomUUID();
                System.out.println("打印一下随机码："+uuid);
                String fileName = uuid.toString()+"_"+fileItem.getName();

                //最终的保存路径
                String filePath = uploadPath+File.separator+fileName;

                //9,创建输出流
                FileOutputStream fos = new FileOutputStream(filePath);

                //10,文件读写操作
//                byte[] buff = new byte[1024];
//                int len=0;
//                while ((len=is.read(buff))!=-1){
//                    fos.write(buff,0,len);
//                }
                IOUtils.copy(is,fos);

                //关闭资源
                fos.close();
                is.close();

            }
            
            
            
        }
        
    }
    
    

    /**
     * 上传文件到本地磁盘
     * @param request
     * @param response
     */
    public void upload(HttpServletRequest request, HttpServletResponse response) throws FileUploadException, IOException {
        //1,获取磁盘的工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //2,根据工厂获取上传对象
        ServletFileUpload upload = new ServletFileUpload(factory);
        //3,解析请求
        List<FileItem> list = upload.parseRequest(request);
        for(FileItem fileItem:list){
            //System.out.println(fileItem);
            //4,根据isFormField()判断是否是上传文件
            if(!fileItem.isFormField()){
                //5,获取对象的输入流
                InputStream is = fileItem.getInputStream();

                //6,设置一下上传路径
                String uploadPath = "D:\\QF\\uploadFiles\\"+fileItem.getName();
                System.out.println("uploadPath:"+uploadPath);

                //7,创建输出流
                FileOutputStream fos = new FileOutputStream(uploadPath);
                //8,文件的读写操作

                byte[] buff = new byte[1024];
                int len=0;
                while((len=is.read(buff))!=-1){
                    fos.write(buff,0,len);
                }


                //9,关闭资源
                fos.close();
                is.close();


          }
        }
    }
}
