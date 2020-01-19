package com.gtstar.fsm.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;




/**
 * @ClassName MyException
 * @Description TODO
 * @Author yuxiang
 * @Date 2020/1/16 14:44
 **/
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class MyException extends RuntimeException {
    private Integer code;
    private String msg;
}
