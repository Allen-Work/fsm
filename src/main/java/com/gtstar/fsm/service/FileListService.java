package com.gtstar.fsm.service;

import com.gtstar.fsm.entity.FileList;

import java.util.List;

public interface FileListService {
    List<FileList> selectByFileList(FileList fileList);

    FileList selectByFileId(Long fileId);

    List<FileList> selectByFileIds(List<Long> fileIds);

    int insertFileList(List<FileList> fileLists);
}
