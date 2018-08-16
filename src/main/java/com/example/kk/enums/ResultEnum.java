// 返回结果的枚举类，注意新建的时候选择Enum
package com.example.kk.enums;

public enum ResultEnum {
    UNKONW_ERROR(-1,"未知错误"),
    SUCCESS(0, "成功"),
    MIDDLE_SCHOOL(101,"可能上初中"),
    PRIMARY_SCHOOL(102,"可能上小学")
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
