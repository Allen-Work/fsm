package com.gtstar.fsm.controller;

import com.gtstar.fsm.service.FileShareService;
import com.gtstar.fsm.util.result.Ecode;
import com.gtstar.fsm.util.result.Result;
import com.gtstar.fsm.util.result.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @ClassName FileShareController
 * @Description TODO
 * @Author yuxiang
 * @Date 2019/12/16 16:20
 **/
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
@RestController
@RequestMapping("/share")
@Slf4j
public class FileShareController {
    @Autowired
    private FileShareService fileShareService;

    /**
     * @param fileIds
     * @return
     */
    @PostMapping("/generateLink")
    public Result generateLink(String fileIds) {
        String urlLink = fileShareService.generateLink(fileIds);
        return ResultUtil.success(Ecode.SUCCESS, urlLink);
    }

    /**
     * 下载
     * @param randomUrl
     */
    @RequestMapping(value = "/download/{ramdom}")
    public void testDownloads(@PathVariable("ramdom") String randomUrl, HttpServletResponse response) throws IOException {
        if (!StringUtils.isEmpty(randomUrl)){
            fileShareService.download(randomUrl,response);
        }

    }

}
