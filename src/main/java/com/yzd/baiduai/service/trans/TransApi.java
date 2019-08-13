package com.yzd.baiduai.service.trans;

import com.yzd.baiduai.utils.UnicodeUtil;

import java.util.HashMap;
import java.util.Map;

public class TransApi {
    private static final String TRANS_API_HOST = "http://api.fanyi.baidu.com/api/trans/vip/translate";

    private static final String appid = "20190724000320940";
    private static final String securityKey = "uipqv9oxFGSPonwadU1q";


    public static String getTransResult(String query, String from, String to) {
        Map<String, String> params = buildParams(query, from, to);
        String s = HttpGet.get(TRANS_API_HOST, params);
        String decode = UnicodeUtil.decode(s);
        System.out.println(decode);
        return decode;
    }

    private static Map<String, String> buildParams(String query, String from, String to) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("q", query);
        params.put("from", from);
        params.put("to", to);

        params.put("appid", appid);

        // 随机数
        String salt = String.valueOf(System.currentTimeMillis());
        params.put("salt", salt);

        // 签名
        String src = appid + query + salt + securityKey; // 加密前的原文
        params.put("sign", MD5.md5(src));

        return params;
    }

}
