package com.gtstar.fsm.controller;

import com.github.pagehelper.PageInfo;
import com.gtstar.fsm.entity.FileList;
import com.gtstar.fsm.service.FileListService;
import com.gtstar.fsm.util.result.Ecode;
import com.gtstar.fsm.util.result.Result;
import com.gtstar.fsm.util.result.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FileListController
 * @Description TODO
 * @Author yuxiang
 * @Date 2019/12/16 15:01
 **/
@CrossOrigin("*")
@RestController
@RequestMapping("/show")
@Slf4j
public class FileListController {
    @Autowired
    private FileListService fileListService;

    @GetMapping("/getFileList")
    public Result getFileList(@RequestParam("currentPage") int currentPage,
                              @RequestParam("pageSize") int pageSize,
                              FileList fileList) {
        PageInfo<FileList> fileLists = new PageInfo<>();
        boolean isFolder = true;
        //判断是否是文件夹
        FileList file = new FileList();
        if (null != fileList.getFileId()) {
            file = fileListService.selectByFileId(fileList.getFileId());
            isFolder = file.getIsFolder() == 1 ? true : false;
        }
        if (isFolder) {
            //查询子文件
            fileLists = fileListService.pageInfo(new FileList().setParentId(fileList.getFileId() == null ? 0L : fileList.getFileId()),currentPage,pageSize);
            return ResultUtil.success(Ecode.SUCCESS, fileLists);
        } else {
            return ResultUtil.success("不是文件夹");
        }
    }

    @GetMapping("/pdfPreview")
    public void pdfPreview(String fullfilename, Long fileId, HttpServletResponse response) {
        try {
            //根据fileId查找路径
            String path = "";
            if (null != fileId) {
                FileList fileList = fileListService.selectByFileId(fileId);
                path = fileList.getDirectory();
            }
            //跨域请求
            response.setHeader("Access-Control-Allow-Origin", "*");
            File file = new File(path);
            response.setCharacterEncoding("UTF-8");
            response.setContentLength((int) file.length());
            // 设置在下载框默认显示的文件名
            response.setHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode(fullfilename, "UTF-8"));
            // 指明response的返回对象是文件流
            response.setContentType("text/html; charset=utf-8");
            // 读出文件到response
            // 这里是先需要把要把文件内容先读到缓冲区
            // 再把缓冲区的内容写到response的输出流供用户下载
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            OutputStream outputStream = response.getOutputStream();
            byte buffer[] = new byte[1024];
            int len = 0;
            while ((len = bufferedInputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, len);
            }
            // 人走带门
            bufferedInputStream.close();
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            log.error("Method 'pdfPreview' get an error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        String filePath = System.getProperty("user.dir") + "/" + "files" + "/";
        System.out.println(filePath);
    }
}
