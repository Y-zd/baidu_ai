package com.yzd.weixin;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.sun.glass.ui.Application;
import com.yzd.baiduai.bean.BaiDuOrcReturnMessage;
import com.yzd.baiduai.service.weixin.WeiXinAuthService;
import com.yzd.baiduai.service.weixin.WxcloudDatabaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/***
 *
 * @author : yanzhidong
 * @date : 2019/10/31 
 * @version : V1.0
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ComponentScan(basePackages = "com.yzd")
@EnableAutoConfiguration
public class WeiXin {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WxcloudDatabaseService databaseService;


    @Autowired
    private WeiXinAuthService weiXinAuthService;

    @Test
    public void auth() {
        System.out.println(weiXinAuthService.getOpenId("0813YF2D0NT3al2C742D0GpV2D03YF2j"));

    }

    @Test
    public void testDataBase() {

        String message = "[ Base URL:118.89.118.83:808/\n" +
                " http: //118.89.118.83/v2/api-docs\n" +
                "百度A的简单使用\n" +
                "百度文字识别 Aip Orc Controller\n" +
                "post/Aiporc/accurateGenera通通用文字识别(含位置高精度版)\n" +
                " Parameters\n" +
                " Name\n" +
                " Description\n";
        String s = message.replaceAll("\r|\n", "   ");
        databaseService.save(BaiDuOrcReturnMessage.builder()._openid("user").fileName("123").message(s).build());

    }


    @Test
    public void testGetToken() {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx77b97914c9538d7&secret=785b38af958bb80f7662a90c9e0780f3";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        if (HttpStatus.OK.equals(responseEntity.getStatusCode())) {
            JSONObject jsonObject = JSONObject.parseObject(responseEntity.getBody());
            System.out.println(jsonObject.get("access_token"));
            System.out.println(jsonObject.get("errcode"));
            System.out.println(jsonObject.get("errmsg"));
        }
    }


    @Test
    public void testSave() {
        String url = "https://api.weixin.qq.com/tcb/databaseadd?access_token=26_q31cYH_ZWQJtPA0-kaGEqWewkGwjerX9RKVHWZz53o-fNWhX-cql_0Q5IaycEEShJKj8AWXaQbsLfKAeR0F2N13T_L_6gdXrb9hv3YKX36WZnJGID7dRbGGIaGsHIHiAEAQRQ";

        HashMap<String, String> map = Maps.newHashMap();
        map.put("env", "demo-qlzyg");
        map.put("query", "db.collection('todos')\n" +
                "  .add({\n" +
                "    data: [\n" +
                "      {\n" +
                "        name: 'apple',\n" +
                "        category: 'fruit',\n" +
                "        price: 10,\n" +
                "      },\n" +
                "      {\n" +
                "        name: 'orange',\n" +
                "        category: 'fruit',\n" +
                "        price: 15,\n" +
                "      },\n" +
                "      {\n" +
                "        name: 'watermelon',\n" +
                "        category: 'fruit',\n" +
                "        price: 20,\n" +
                "      },\n" +
                "      {\n" +
                "        name: 'yaourt',\n" +
                "        category: 'dairy',\n" +
                "        price: 8,\n" +
                "      },\n" +
                "      {\n" +
                "        name: 'milk',\n" +
                "        category: 'dairy',\n" +
                "        price: 12,\n" +
                "      },\n" +
                "      {\n" +
                "        name: 'Lindt chocolate',\n" +
                "        category: 'chocolate',\n" +
                "        price: 16,\n" +
                "      },\n" +
                "    ]\n" +
                "  })\n");

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, map, String.class);
        System.out.println(responseEntity);
    }


}
