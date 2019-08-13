package com.yzd.baiduai.service.orc;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
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
    public static String basicGeneral(byte[] bytes) {
        JSONObject res = client.basicGeneral(bytes, new HashMap<String, String>());
        return jsonResult2String(res);

    }

    /**
     * 通用文字识别（高精度版）
     *
     * @param bytes
     * @return
     */
    public static String basicAccurateGeneral(byte[] bytes) {
        JSONObject res = client.basicAccurateGeneral(bytes, new HashMap<String, String>());
        return jsonResult2String(res);
    }


    /**
     * 通用文字识别（含位置信息版）
     *
     * @param bytes
     * @return
     */
    public static String general(byte[] bytes) {
        JSONObject res = client.general(bytes, new HashMap<String, String>());
        return jsonResult2String(res);
    }

    /**
     * 通通用文字识别（含位置高精度版）
     *
     * @param bytes
     * @return
     */
    public static String accurateGeneral(byte[] bytes) {
        JSONObject res = client.accurateGeneral(bytes, new HashMap<String, String>());
        return jsonResult2String(res);
    }

    /**
     * 通用文字识别（含生僻字版）
     *
     * @param bytes
     * @return
     */
    public static String enhancedGeneral(byte[] bytes) {
        JSONObject res = client.enhancedGeneral(bytes, new HashMap<String, String>());
        return jsonResult2String(res);
    }

    /**
     * 网络图片文字识别
     *
     * @param bytes
     * @return
     */
    public static String webImage(byte[] bytes) {
        JSONObject res = client.webImage(bytes, new HashMap<String, String>());
        return jsonResult2String(res);
    }


    public static String jsonResult2String(JSONObject jsonObject) {
        JSONArray wordsList = (JSONArray) jsonObject.get("words_result");
        StringBuffer sb = new StringBuffer();
        for (Object o : wordsList) {
            sb.append(((JSONObject) o).get("words").toString()).append("\n");
        }
        return sb.toString();
    }

}
