package com.yzd.baiduai.service;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;

import java.util.HashMap;

/***
 *
 * @author : yanzhidong
 * @date : 2019/6/24 
 * @version : V1.0
 *
 */
public class AipOrcService {

    public static final String APP_ID = "10029165";
    public static final String API_KEY = "VxXzxNwSQOORpgaWlGG04GhK";
    public static final String SECRET_KEY = "VoLkO2GXlpcB6aQCv8wr1st95WPidxCS";


    public static JSONObject basicGeneral(byte[] bytes) {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        JSONObject res = client.basicGeneral(bytes, new HashMap<String, String>());
        System.out.println(res.toString(2));
        return res;
    }

}
