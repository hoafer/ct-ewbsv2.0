package cn.comtom.reso.fw;

import lombok.Data;

@Data
public class FieldValidError {

    private String fieldId;

    private String errorMessage;

    private Object value;
}
