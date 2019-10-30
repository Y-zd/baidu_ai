package com.yzd.baiduai.controller;

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

    @GetMapping("/index")
    public String index() {
        return "success";
    }

}
