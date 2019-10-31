package com.yzd.baiduai.service.orc;

import com.yzd.baiduai.bean.BaiDuOrcReturnMessage;
import com.yzd.baiduai.service.weixin.WxcloudDatabaseService;
import com.yzd.baiduai.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/***
 *
 * @author : yanzhidong
 * @date : 2019/10/31 
 * @version : V1.0
 *
 */
@Service
public class AipOrcAsyncService {


    @Autowired
    private WxcloudDatabaseService databaseService;

    @Async
    public void asyncRun(MultipartFile file, BaiDuOrcReturnMessage data) {
        String message = AipOrcService.basicAccurateGeneral(FileUtil.file2byte(file)).replaceAll("\r|\n", "  ");
        data.setMessage(message);
        databaseService.save(data);
    }


}
