// 自定义的一个异常类，继承自Exception，因为Exception传参方式单一，不能满足需求（好像只能传一个string）
package com.example.kk.exception;


import com.example.kk.enums.ResultEnum;

public class GirlException extends Exception{

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

}
