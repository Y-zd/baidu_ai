package com.yzd.baiduai.service.weixin;

import com.alibaba.fastjson.JSONObject;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/***
 *
 * @author : yanzhidong
 * @date : 2019/10/31 
 * @version : V1.0
 *   获取小程序全局唯一后台接口调用凭据
 */
@Service
@Slf4j
public class WeiXinTokenService {

    @Autowired
    private RestTemplate restTemplate;
    /**
     * 本地缓存120分支
     */
    private Cache<String, String> tokenCache = CacheBuilder.newBuilder().maximumSize(1)
            .expireAfterWrite(120, TimeUnit.MINUTES).build();

    private String CHACHE_KEY = "accessToken";

    /**
     * 获取token
     *
     * @return
     */
    public String getToken() {
        try {
            return tokenCache.get(CHACHE_KEY, this::getTokenFromWeiXin);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 清除token缓存
     *
     * @return
     */
    public void clearTokenCache() {
        tokenCache.invalidate(CHACHE_KEY);
    }

    private String getTokenFromWeiXin() {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx77bb97914c9538d7&secret=785b38af958bb80f7662a90c9e0780f3";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        if (HttpStatus.OK.equals(responseEntity.getStatusCode())) {
            JSONObject jsonObject = JSONObject.parseObject(responseEntity.getBody());
            Object accessToken = jsonObject.get("access_token");
            if (accessToken == null) {
                log.info("[get WeiXin token],error:{}", jsonObject.toString());
                return null;
            }
            return accessToken.toString();
        } else {
            log.info("[get WeiXin token],error:{}", responseEntity.toString());
            return null;
        }
    }

}
