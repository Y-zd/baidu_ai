package com.yzd.baiduai.controller;

import com.yzd.baiduai.bean.BaiDuOrcReturnMessage;
import com.yzd.baiduai.service.orc.AipOrcAsyncService;
import com.yzd.baiduai.service.weixin.WeiXinAuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/***
 *
 * @author : yanzhidong
 * @date : 2019/10/31 
 * @version : V1.0
 *
 */
@Api(tags = "百度文字识别异步返回到数据库中")
@RestController
@RequestMapping("/AipOrc/Async")
@CrossOrigin
@Slf4j
public class AipOrcAsyncController {

    @Autowired
    private AipOrcAsyncService aipOrcAsyncService;

    @Autowired
    private WeiXinAuthService weiXinAuthService;

    @ApiOperation("通用文字识别（高精度版）")
    @PostMapping("/basicAccurateGeneral")
    public String basicAccurateGeneral(@RequestParam(value = "file") MultipartFile file, String jsCode, String fileName) {
        log.info("fileName:{},jsCode:{},fileName:{}", file.getOriginalFilename(), jsCode, fileName);
        String openId = weiXinAuthService.getOpenId(jsCode);
        aipOrcAsyncService.asyncRun(file,
                BaiDuOrcReturnMessage.builder().fileName(fileName)._openid(openId).build());
        return openId;
    }


}
