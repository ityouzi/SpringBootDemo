package com.example.springbootdemo.util;

import com.example.springbootdemo.service.UploadService;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 压缩图片
 * @version
 * @author lizhen created on 2021-10-28 11:17
 */
public class uploadFileAndCreateThumbnail {
    /**
     * 判断目录是否存在
     */
    private void createDir(String tempPath){
        File file = new File(tempPath);
        if (!file.exists()){
            file.mkdirs();
        }
    }
    
    /**
     * 获取链接的后缀名
     */
    public static String getSuffix(String httpUrl){
        try {
            URL url = new URL(httpUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedInputStream bis;
            urlConnection.getContent();
            bis = new BufferedInputStream(urlConnection.getInputStream());
            String result = HttpURLConnection.guessContentTypeFromStream(bis);
            return result.split("/")[1];
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }
    
    public static void main(String[] args) throws Exception {
        String url = "http://youcaibaby.oss-cn-beijing.aliyuncs.com/ueditor/DAC63257E7AC4956AD09A5DCE32D7682.jpeg";
        InputStream imageFromNetByUrl = NetImageUtil.getImageStreamFromNetByUrl("http://youcaibaby.oss-cn-beijing.aliyuncs.com/ueditor/DAC63257E7AC4956AD09A5DCE32D7682.jpeg");
//        byte[] imageFromNetByUrl = NetImageUtil.getImageFromNetByUrl(url);
        UploadService uploadService = new UploadService();
        uploadService.uploadFile(imageFromNetByUrl, url,"00", "TK20211028113051803duAMy8nf");
//        String suffix = getSuffix("http://youcaibaby.oss-cn-beijing.aliyuncs.com/ueditor/DAC63257E7AC4956AD09A5DCE32D7682.jpeg");
//        System.out.println(suffix);


    }
}
