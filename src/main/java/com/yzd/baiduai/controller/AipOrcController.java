package com.yzd.baiduai.controller;

import com.yzd.baiduai.service.AipOrcService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/***
 *
 * @author : yanzhidong
 * @date : 2019/6/24 
 * @version : V1.0
 *
 */
@Api(tags = "百度文字识别")
@RestController
@RequestMapping("/AipOrc")
public class AipOrcController {

    @ApiOperation("通用文字识别")
    @PostMapping("/basicGeneral")
    public String basicGeneral(@RequestParam(value = "file") MultipartFile file) {
        return jsonObject2String(AipOrcService.basicGeneral(file2byte(file)));
    }


    @ApiOperation("通用文字识别（高精度版）")
    @PostMapping("/basicAccurateGeneral")
    public String basicAccurateGeneral(@RequestParam(value = "file") MultipartFile file) {
        return jsonObject2String(AipOrcService.basicAccurateGeneral(file2byte(file)));
    }


    @ApiOperation("通用文字识别（含位置信息版）")
    @PostMapping("/general")
    public String general(@RequestParam(value = "file") MultipartFile file) {
        return jsonObject2String(AipOrcService.general(file2byte(file)));
    }


    @ApiOperation("通通用文字识别（含位置高精度版）")
    @PostMapping("/accurateGeneral")
    public String accurateGeneral(@RequestParam(value = "file") MultipartFile file) {
        return jsonObject2String(AipOrcService.accurateGeneral(file2byte(file)));
    }


    @ApiOperation("通用文字识别（含生僻字版）")
    @PostMapping("/enhancedGeneral")
    public String enhancedGeneral(@RequestParam(value = "file") MultipartFile file) {
        return jsonObject2String(AipOrcService.enhancedGeneral(file2byte(file)));
    }


    @ApiOperation("网络图片文字识别")
    @PostMapping("/webImage")
    public String webImage(@RequestParam(value = "file") MultipartFile file) {
        return jsonObject2String(AipOrcService.webImage(file2byte(file)));
    }


    private byte[] file2byte(MultipartFile file) {
        try {
            return file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String jsonObject2String(JSONObject jsonObject) {
        JSONArray wordsList = (JSONArray) jsonObject.get("words_result");
        StringBuffer sb = new StringBuffer();
        for (Object o : wordsList) {
            sb.append(((JSONObject) o).get("words").toString()).append("\n");
        }
        return sb.toString();
    }


}
