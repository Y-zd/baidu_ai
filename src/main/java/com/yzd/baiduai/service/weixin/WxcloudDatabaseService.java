package com.yzd.baiduai.service.weixin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.yzd.baiduai.bean.BaiDuOrcReturnMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/***
 *
 * @author : yanzhidong
 * @date : 2019/10/31 
 * @version : V1.0
 *
 */
@Service
@Slf4j
public class WxcloudDatabaseService {

    private String URL = "https://api.weixin.qq.com/tcb/databaseadd?access_token=";
    private String COLLECTION = "orcReturnMessage";


    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    protected WeiXinTokenService weiXinTokenService;

    public void save(BaiDuOrcReturnMessage data) {
        HashMap<String, String> map = Maps.newHashMap();
        map.put("env", "demo-qlzyg");
        map.put("query", "db.collection('" + COLLECTION + "').add({data:" + JSONObject.toJSONString(data) + "})");
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL + weiXinTokenService.getToken(), map, String.class);
        if (HttpStatus.OK.equals(responseEntity.getStatusCode())) {
            log.info("【操作云数据库】,结果:{}", responseEntity.toString());
        } else {
            log.info("【操作云数据库】,请求异常:{}", responseEntity.toString());
        }

    }

}
