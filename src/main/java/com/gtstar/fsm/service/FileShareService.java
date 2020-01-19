package com.gtstar.fsm.service;


import com.gtstar.fsm.entity.FileShare;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface FileShareService extends IService<FileShare> {
    String generateLink(String path);

    List<FileShare> getFileShare(FileShare fileShare);

    void download(String randomUrl, HttpServletResponse response) throws IOException;
}
