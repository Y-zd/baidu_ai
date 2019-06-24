package com.yzd.baiduai.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Base64;

/***
 *
 * @author : yanzhidong
 * @date : 2019/6/24 
 * @version : V1.0
 *
 */
public class ImageUtil {


    public static String getImageCode(byte[] bytes) {
        return urlEncoder(base64Encoder(bytes));
    }

    /**
     * Base64 编码
     *
     * @param bytes
     * @return
     */
    public static String base64Encoder(byte[] bytes) {
        final Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(bytes);

    }

    public static String urlEncoder(String string) {
        try {
            return URLEncoder.encode(string, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) throws Exception {
        final Base64.Decoder decoder = Base64.getDecoder();
        final Base64.Encoder encoder = Base64.getEncoder();
        final String text = "字串文字";
        final byte[] textByte = text.getBytes("UTF-8");
//编码
        final String encodedText = encoder.encodeToString(textByte);
        System.out.println(encodedText);
//解码
        System.out.println(new String(decoder.decode(encodedText), "UTF-8"));

        URLEncoder.encode(encodedText, "UTF-8");
    }
}
