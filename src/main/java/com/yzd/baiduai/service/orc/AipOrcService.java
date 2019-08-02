package com.yzd.baiduai.service.orc;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;

import java.util.HashMap;

/***
 *百度文字识别服务
 *   http://ai.baidu.com/docs#/OCR-Java-SDK/top
 * @author : yanzhidong
 * @date : 2019/6/24 
 * @version : V1.0
 *
 */
public class AipOrcService {

    private static AipOcr client = new AipOcr(AuthService.APP_ID, AuthService.API_KEY, AuthService.SECRET_KEY);

    /**
     * 通用文字识别
     *
     * @param bytes
     * @return
     */
    public static JSONObject basicGeneral(byte[] bytes) {
        JSONObject res = client.basicGeneral(bytes, new HashMap<String, String>());
        System.out.println(res.toString(2));
        return res;
    }

    /**
     * 通用文字识别（高精度版）
     *
     * @param bytes
     * @return
     */
    public static JSONObject basicAccurateGeneral(byte[] bytes) {
        JSONObject res = client.basicAccurateGeneral(bytes, new HashMap<String, String>());
        System.out.println(res.toString(2));
        return res;
    }


    /**
     * 通用文字识别（含位置信息版）
     *
     * @param bytes
     * @return
     */
    public static JSONObject general(byte[] bytes) {
        JSONObject res = client.general(bytes, new HashMap<String, String>());
        System.out.println(res.toString(2));
        return res;
    }

    /**
     * 通通用文字识别（含位置高精度版）
     *
     * @param bytes
     * @return
     */
    public static JSONObject accurateGeneral(byte[] bytes) {
        JSONObject res = client.accurateGeneral(bytes, new HashMap<String, String>());
        System.out.println(res.toString(2));
        return res;
    }

    /**
     * 通用文字识别（含生僻字版）
     *
     * @param bytes
     * @return
     */
    public static JSONObject enhancedGeneral(byte[] bytes) {
        JSONObject res = client.enhancedGeneral(bytes, new HashMap<String, String>());
        System.out.println(res.toString(2));
        return res;
    }

    /**
     * 网络图片文字识别
     *
     * @param bytes
     * @return
     */
    public static JSONObject webImage(byte[] bytes) {
        JSONObject res = client.webImage(bytes, new HashMap<String, String>());
        System.out.println(res.toString(2));
        return res;
    }


}
