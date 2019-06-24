package com.yzd.baiduai.controller;

import com.google.common.collect.Maps;
import com.yzd.baiduai.service.AipOrcService;
import com.yzd.baiduai.service.AuthService;
import com.yzd.baiduai.utils.ImageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/***
 *
 * @author : yanzhidong
 * @date : 2019/6/24 
 * @version : V1.0
 *
 */
@Api(tags = "百度图片识别")
@RestController
@RequestMapping("/baidu")
public class WebController {
    @Autowired
    private RestTemplate restTemplate;

    @ApiOperation("上传图片")
    @PostMapping("/import")
    public String importExcel(@RequestParam(value = "file") MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            JSONObject jsonObject = AipOrcService.basicGeneral(bytes);
            JSONArray wordsList = (JSONArray) jsonObject.get("words_result");
            StringBuffer sb = new StringBuffer();
            for (Object o : wordsList) {
                sb.append(((JSONObject) o).get("words").toString()).append("\n");
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

//
//    private void getResponse(byte[] bytes) {
//        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/general" + "?access_token=" + AuthService.getAuth();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        MultiValueMap<String, String> param = new LinkedMultiValueMap<String, String>();
//        //将请求参数放入map中
//        param.add("image", ImageUtil.getImageCode(bytes));
//        //将参数和header组成一个请求
//        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(param, headers);
//        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
//        System.out.println(response);
//    }
}
