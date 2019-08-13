package com.yzd.baiduai.controller;

import com.yzd.baiduai.service.orc.AipOrcService;
import com.yzd.baiduai.service.trans.TransApi;
import com.yzd.baiduai.utils.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/***
 *
 * @author : yanzhidong
 * @date : 2019/8/2 
 * @version : V1.0
 *
 */
@Api(tags = "百度翻译")
@RestController
@RequestMapping("/Trans")
public class TransController {

    @ApiOperation("通用文字识别（高精度版）")
    @PostMapping("/basicAccurateGeneral")
    public String basicAccurateGeneral(@RequestParam(value = "file") MultipartFile file) {
        String string = AipOrcService.basicAccurateGeneral(FileUtil.file2byte(file));
        String transResult = TransApi.getTransResult(string, "auto", "zh");
        JSONObject jsonObject = new JSONObject(transResult);
        return jsonObject2String(jsonObject);
    }





    private String jsonObject2String(JSONObject jsonObject) {
        JSONArray wordsList = (JSONArray) jsonObject.get("trans_result");
        StringBuffer sb = new StringBuffer();
        for (Object o : wordsList) {
            sb.append(((JSONObject) o).get("dst").toString()).append("\n");
        }
        return sb.toString();
    }
}
