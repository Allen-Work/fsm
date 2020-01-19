package com.gtstar.fsm.util.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Result
 * @Description TODO
 * @Author yuxiang
 * @Date 2018/9/19 9:19
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private Integer code;  //状态码
    private String msg;   //提示信息
    private T data;       //具体内容
}
