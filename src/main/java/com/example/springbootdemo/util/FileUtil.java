package com.example.springbootdemo.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.util.UUID;

/**
 * @author lizhen created on 2021-10-28 13:28
 */
@Slf4j
public class FileUtil {
    /**
     * MultipartFile 转 File
     *
     * @param file
     * @throws Exception
     */
    public static File multipartFileToFile(MultipartFile file) throws Exception {

        File toFile = null;
        if (file.equals("") || file.getSize() <= 0) {
            file = null;
        } else {
            InputStream ins = null;
            ins = file.getInputStream();
            toFile = new File(file.getOriginalFilename());
            inputStreamToFile(ins, toFile);
            ins.close();
        }
        return toFile;
    }
    //获取流文件
    private static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取封装得MultipartFile
     *
     * @param inputStream inputStream
     * @param fileName    fileName
     * @return MultipartFile
     */
    public static MultipartFile getMultipartFile(InputStream inputStream, String fileName) {
        FileItem fileItem = createFileItem(inputStream, fileName);
        //CommonsMultipartFile是feign对multipartFile的封装，但是要FileItem类对象
//        return new CommonsMultipartFile(fileItem);
        return null;
    }



    /**
     * FileItem类对象创建
     *
     * @param inputStream inputStream
     * @param fileName    fileName
     * @return FileItem
     */
    public static FileItem createFileItem(InputStream inputStream, String fileName) {
        FileItemFactory factory = new DiskFileItemFactory(16, null);
        String textFieldName = "file";
        FileItem item = factory.createItem(textFieldName, MediaType.MULTIPART_FORM_DATA_VALUE, true, fileName);
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        OutputStream os = null;
        //使用输出流输出输入流的字节
        try {
            os = item.getOutputStream();
            while ((bytesRead = inputStream.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            inputStream.close();
        } catch (IOException e) {
            log.error("Stream copy exception", e);
            throw new IllegalArgumentException("文件上传失败");
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    log.error("Stream close exception", e);

                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.error("Stream close exception", e);
                }
            }
        }

        return item;
    }


    public static File createTmpFile(InputStream inputStream, String name, String ext, File tmpDirFile) throws IOException {
        File resultFile = File.createTempFile(name, '.' + ext, tmpDirFile);
        resultFile.deleteOnExit();
        FileUtils.copyToFile(inputStream, resultFile);
        return resultFile;
    }

    public static File bytesToFile(byte[] bytes, String fileType) throws IOException {
        return createTmpFile(new ByteArrayInputStream(bytes),
                UUID.randomUUID().toString(),
                fileType,
                Files.createTempDirectory("tempFile").toFile())
                ;
    }

    public static File InputToFile(InputStream inputStream, String fileType) throws IOException {
        File resultFile = File.createTempFile( UUID.randomUUID().toString(), '.' + fileType, Files.createTempDirectory("tempFile").toFile());
        resultFile.deleteOnExit();
        FileUtils.copyToFile(inputStream, resultFile);
        return resultFile;    }

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



}
