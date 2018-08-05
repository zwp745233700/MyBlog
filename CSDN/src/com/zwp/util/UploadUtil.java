package com.zwp.util;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.persistence.Entity;

import org.apache.commons.io.FileUtils;

public class UploadUtil {
	
	//保存图片到服务器：
	public String uploadFile(File upload,String uploadFileName,String FileName,int id){
		//接收图片
        if(upload!=null && upload.length()>0 && uploadFileName!=null && uploadFileName.length()>0){	
        	//写上传代码
        	
        	Calendar cal=Calendar.getInstance();//获得一个截取时间的实例    
        	
            //如果保存上传文件的根目录不存在，创建根目录  
            String fileName="D:\\CSDNimg\\"+FileName+"\\"+id;  
            //为了设置photo属性，定义一个变量url获取相对路径  
            String url=FileName+"\\"+id;
            
            File file=new File(fileName);  
            if(!file.exists()){  
            	//创建根目录  
                file.mkdirs();  
            }  
            
            //如果年的目录不存在，创建年的目录  
            int year= cal.get(Calendar.YEAR);//获得年  
            fileName=fileName+"\\"+year;  
            url=url+"\\"+year;  
            file=new File(fileName);  
            if(!file.exists()){   
            	//创建年目录  
                file.mkdirs();  
            }  
              
            //如果月的目录不存在，创建月份的目录  
            int month=cal.get(Calendar.MONTH)+1;//这里获得月记住要加1  
            fileName=fileName+"\\";  //这是最后一次加反斜杠，后边不创建目录  
            url=url+"\\";  
            //这里月份小于10的时候设置(例如5月)成 05  
            if(month<10)  {  
                fileName=fileName+"0";  
                url=url+"0";  
            }  
            fileName=fileName+month;  
            url=url+month;  
            file=new File(fileName);  
            if(!file.exists()){  
                //创建月目录  
                file.mkdirs();  
            }  
              
            //从这里开始就是照片文件名字中的命名，不涉及到创建目录，生成文件名的日部分  
            int day=cal.get(Calendar.DAY_OF_MONTH);
            fileName=fileName+"\\";  
            url=url+"\\";  
            //这里日数小于10的时候设置(例如5日)成 05  
            if(day<10){  
                fileName=fileName+"0";  
                url=url+"0";  
            }  
            fileName=fileName+day;  
            url=url+day;  
              
            //生成文件名的小时部分  
            int hour=cal.get(Calendar.HOUR_OF_DAY);  
            //如果小时数是个位，就加0  
            if(hour<10){  
                fileName=fileName+"0";  
                url=url+"0";  
            }  
            fileName=fileName+hour;  
            url=url+hour;  
              
            //生成文件名的分钟部分  
            int mintue=cal.get(Calendar.MINUTE);  
            if(mintue<10){  
                fileName=fileName+"0";  
                url=url+"0";  
            }  
            fileName=fileName+mintue;  
            url=url+mintue;  
              
            //生成文件名的秒部分  
            int second=cal.get(Calendar.SECOND);  
            if(second<10){  
                fileName=fileName+"0";  
                url=url+"0";  
            }  
            fileName=fileName+second;  
            url=url+second;  
              
            //生成文件名的毫秒部分  
            int millisecond=cal.get(Calendar.MILLISECOND);  
            //毫秒应该加两个零  
            if(millisecond<10){  
                fileName=fileName+"0";  
                url=url+"0";  
            }  
            if(millisecond<100){  
                fileName=fileName+"0";  
                url=url+"0";  
            }  
            fileName=fileName+millisecond;  
            url=url+millisecond;  
              
            
            //生成文件名的拓展名部分  
            String extension=uploadFileName.substring(uploadFileName.indexOf("."));//获取上传文件的拓展名  
            fileName=fileName+extension;  
            url=url+extension;  
            
            File myfile=new File(fileName);  
            try {  
                FileUtils.copyFile(upload,myfile);//上传到客户端  
            } catch (IOException e) {  
                e.printStackTrace();  
        }  
            
            return url;
	}
        return null;
}
}
