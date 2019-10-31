package com.yzd.baiduai.controller;

import com.yzd.baiduai.service.weixin.WeiXinTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *
 * @author : yanzhidong
 * @date : 2019/10/29 
 * @version : V1.0
 *
 */
@RestController
public class IndexController {

    @Autowired
    WeiXinTokenService weiXinTokenService;

    @GetMapping("/index")
    public String index() {
        return "success";
    }

    @GetMapping("/clearToken")
    public String clearToken() {
        weiXinTokenService.clearTokenCache();
        return "success";
    }



}
