package com.yzd.baiduai.bean;

import lombok.Builder;
import lombok.Data;

/***
 *
 * @author : yanzhidong
 * @date : 2019/10/31 
 * @version : V1.0
 *
 * 对应云数据库orcReturnMessage集合
 */
@Builder
@Data
public class BaiDuOrcReturnMessage {

    /**
     * 用户z
     */
    private String _openid;
    /**
     * 文件名
     */
    private String fileName;
    /**
     * 翻译结果
     */
    private String message;
}
