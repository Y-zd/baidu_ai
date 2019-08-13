package com.yzd.baiduai.controller;

import com.yzd.baiduai.service.orc.AipOrcService;
import com.yzd.baiduai.utils.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
        return AipOrcService.basicGeneral(FileUtil.file2byte(file));
    }


    @ApiOperation("通用文字识别（高精度版）")
    @PostMapping("/basicAccurateGeneral")
    public String basicAccurateGeneral(@RequestParam(value = "file") MultipartFile file) {
        return AipOrcService.basicAccurateGeneral(FileUtil.file2byte(file));
    }


    @ApiOperation("通用文字识别（含位置信息版）")
    @PostMapping("/general")
    public String general(@RequestParam(value = "file") MultipartFile file) {
        return AipOrcService.general(FileUtil.file2byte(file));
    }


    @ApiOperation("通通用文字识别（含位置高精度版）")
    @PostMapping("/accurateGeneral")
    public String accurateGeneral(@RequestParam(value = "file") MultipartFile file) {
        return AipOrcService.accurateGeneral(FileUtil.file2byte(file));
    }


    @ApiOperation("网络图片文字识别")
    @PostMapping("/webImage")
    public String webImage(@RequestParam(value = "file") MultipartFile file) {
        return AipOrcService.webImage(FileUtil.file2byte(file));
    }

    @ApiOperation("通用文字识别（含生僻字版）")
    @PostMapping("/enhancedGeneral")
    public String enhancedGeneral(@RequestParam(value = "file") MultipartFile file) {
        return AipOrcService.enhancedGeneral(FileUtil.file2byte(file));
    }


}
