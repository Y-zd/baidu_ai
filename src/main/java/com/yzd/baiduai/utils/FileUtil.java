package com.yzd.baiduai.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/***
 *
 * @author : yanzhidong
 * @date : 2019/8/13 
 * @version : V1.0
 *
 */
public class FileUtil {

    public static byte[] file2byte(MultipartFile file) {
        try {
            return file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
