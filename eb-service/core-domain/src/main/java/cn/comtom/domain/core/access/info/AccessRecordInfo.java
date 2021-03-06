package cn.comtom.domain.core.access.info;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AccessRecordInfo implements Serializable {

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "接入节点")
    private String nodeId;

    @ApiModelProperty(value = "接入时间")
    private String receiveTime;

    @ApiModelProperty(value = "接入状态")
    private String status;

    @ApiModelProperty(value = "关联文件ID")
    private String fileId;

    @ApiModelProperty(value = "信息类型")
    private String type;

    @ApiModelProperty(value = "请求IP")
    private String reqIp;

    @ApiModelProperty(value = "ebdId")
    private String ebdId;

    @ApiModelProperty(value = "来源单位")
    private String psEbrName;

    @ApiModelProperty(value = "文件大小")
    private Integer fileSize;

    @ApiModelProperty(value = "ftp地址")
    private String ftpUrl;

    @ApiModelProperty(value = "接入状态名称")
    private String statusName;
    
}
