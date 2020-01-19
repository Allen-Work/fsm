package com.gtstar.fsm.mapper;

import com.gtstar.fsm.entity.FileList;
import com.gtstar.util.MyMapper;

import java.util.List;

public interface FileListMapper extends MyMapper<FileList> {
    int updateBatchFileList(List<FileList> fileLists);
}