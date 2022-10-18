package com.xd.pre.modules.sys.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Classname UserDTO
 * @Description 应用Dto
 * @Author 李号东 lihaodongmail@163.com
 * @Date 2019-04-23 21:26
 * @Version 1.0
 */
@Data
public class AppDTO {

    private static final long serialVersionUID = 1L;

    private Integer appId;
    private String appName;
    private String appCode;
    private String appDesc;
    private String delFlag;



}
