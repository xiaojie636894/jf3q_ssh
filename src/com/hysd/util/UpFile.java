package com.hysd.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.hysd.cons.Sys;

public class UpFile {
	 public static String uploadFile(File file) throws Exception {   
         try {   
             InputStream in = new FileInputStream(file);   
             ServletContext servletContext=ServletActionContext.getServletContext();  
             String dir=servletContext.getRealPath(Sys.Common.FILEPATH);//文件最终要上传到的路径  
           
             File fileLocation = new File(dir);  
             //此处也可以在应用根目录手动建立目标上传目录  
             if(!fileLocation.exists()){  
                 boolean isCreated  = fileLocation.mkdir();  
                 if(!isCreated) {  
                     //目标上传目录创建失败,可做其他处理,例如抛出自定义异常等,一般应该不会出现这种情况。  
                     return "";  
                 }  
             }  
             String fileName="face_"+(UUID.randomUUID()+"").replace("-", "").substring(3, 15)+".jpg";  
             File uploadFile = new File(dir, fileName);   
             OutputStream out = new FileOutputStream(uploadFile);   
             byte[] buffer = new byte[1024 * 1024];   
             int length;   
             while ((length = in.read(buffer)) > 0) {   
                 out.write(buffer, 0, length);   
             }   
             in.close();   
             out.close();
             return  Sys.Common.FILEPATH+"/"+fileName;
         } catch (Exception ex) {   
             System.out.println("上传失败!");  
             ex.printStackTrace();   
         } 
         return "";
     }   
 
	 public static void deleteFile(String path){   
		 String abPath= ServletActionContext.getRequest().getRealPath("")+path;
		 File f=new File(abPath);
		 if(f.exists())f.delete();
     }  
}
