package cn.comtom.tools.enums;


/**
 * 自定义枚举接口服务类
 * @author guomao
 */
public interface ErrorCode {

    /**
     * 错误码前缀
     */
    String BASE_PREFIX = "EB-";

    /**
     *  获取错误码
     * @return
     */
    String getCode();


    String getMsg();

}
