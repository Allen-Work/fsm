package com.gtstar.fsm.mapper;

import com.gtstar.fsm.entity.FileShare;
import com.gtstar.util.MyMapper;

public interface FileShareMapper extends MyMapper<FileShare> {
    int insertFileShare(FileShare fileShare);
}