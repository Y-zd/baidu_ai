package com.yzd.baiduai.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 每六位描述一个字节
 */
public class UnicodeUtil {

    /**
     * 字符串编码成Unicode编码
     */
    public static String encode(String src) throws Exception {
        char c;
        StringBuilder str = new StringBuilder();
        int intAsc;
        String strHex;
        for (int i = 0; i < src.length(); i++) {
            c = src.charAt(i);
            intAsc = (int) c;
            strHex = Integer.toHexString(intAsc);
            if (intAsc > 128)
                str.append("\\u" + strHex);
            else
                str.append("\\u00" + strHex); // 低位在前面补00
        }
        return str.toString();
    }

    /**
     * Unicode解码成字符串
     *
     * @param unicode
     * @return
     */
    public static String decode(String unicode) {
        List<String> list = new ArrayList<String>();
        String reg= "\\\\u[0-9,a-f,A-F]{4}";
        Pattern p = Pattern.compile(reg);
        Matcher m=p.matcher(unicode);
        while (m.find()){
            list.add(m.group());
        }
        for (int i = 0, j = 2; i < list.size(); i++) {
            String code = list.get(i).substring(j, j + 4);
            char ch = (char) Integer.parseInt(code, 16);
            unicode = unicode.replace(list.get(i),String.valueOf(ch));
        }
        return unicode;

    }
}