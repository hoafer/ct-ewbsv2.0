package cn.comtom.domain.core.ebm.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class EbmDispatchInfoAuditRequest {

    @ApiModelProperty(value = "主键")
    @NotEmpty(message = "ebmId 不能为空")
    private String ebmId;

    @ApiModelProperty(value = "审核结果")
    @NotEmpty(message = "auditResult 不能为空")
    private String auditResult;

    @ApiModelProperty(value = "审核意见")
    private String auditOpinion;

}
