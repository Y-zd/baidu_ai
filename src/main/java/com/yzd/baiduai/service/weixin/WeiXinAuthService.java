package com.yzd.baiduai.service.weixin;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/***
 *
 * @author : yanzhidong
 * @date : 2019/10/31 
 * @version : V1.0
 *
 */
@Slf4j
@Service
public class WeiXinAuthService {

    private String URL = "https://api.weixin.qq.com/sns/jscode2session?appid=wx77bb97914c9538d7&secret=785b38af958bb80f7662a90c9e0780f3&grant_type=authorization_code&js_code=";

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 获取用户openid
     * @param jsCode
     * @return
     */
    public String getOpenId(String jsCode) {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL + jsCode, String.class);
        if (HttpStatus.OK.equals(responseEntity.getStatusCode())) {
            JSONObject jsonObject = JSONObject.parseObject(responseEntity.getBody());
            Object openid = jsonObject.get("openid");
            if (openid == null) {
                log.info("[get openid],success:{}", responseEntity.toString());
                return null;
            }
            return openid.toString();
        } else {
            log.info("[get openid],error:{}", responseEntity.toString());
            return null;
        }
    }


}
