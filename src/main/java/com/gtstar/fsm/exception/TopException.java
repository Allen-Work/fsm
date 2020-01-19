package com.gtstar.fsm.exception;

import com.gtstar.fsm.util.result.Result;
import com.gtstar.fsm.util.result.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName TopException
 * @Description TODO
 * @Author yuxiang
 * @Date 2020/1/16 15:12
 **/
@ControllerAdvice
@Slf4j
public class TopException {
    @ExceptionHandler(value = Exception.class)
    public Result handle(HttpServletRequest request,Exception e) {
        if (e instanceof MyException) {
            log.error("业务日志",e);
            MyException myException = (MyException) e;
            return ResultUtil.error(myException.getCode(),myException.getMsg()+"。请求路径："+request.getRequestURL().toString());
        }
        log.error("系统日志",e);
        return ResultUtil.error(1000,"业务繁忙");
    }
}
