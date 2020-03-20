package cn.comtom.domain.core.omd.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Data
public class OmdRequestUpdateRequest implements Serializable {

	/**
	 * 运维数据请求编号
	 */
	@NotEmpty(message = "omdRequestId 不能为空")
	private String omdRequestId;

	/**
	 * 运维数据类型
	 */
	private String omdType;

	/**
	 * 记录开始时间
	 */
	private Date rptStartTime;

	/**
	 * 记录结束时间
	 */
	private Date rptEndTime;

	/**
	 * 数据包操作类型
	 */
	private String rptType;

	/**
	 * 关联业务数据包编号（发送）
	 */
	private String relatedEbdId;

	/**
	 * 关联运维数据请求资源编号（发送）
	 */
	private String relatedEbrId;

}