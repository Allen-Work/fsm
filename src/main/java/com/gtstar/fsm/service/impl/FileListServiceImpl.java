package com.gtstar.fsm.service.impl;

import com.gtstar.fsm.entity.FileList;
import com.gtstar.fsm.mapper.FileListMapper;
import com.gtstar.fsm.service.FileListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName FileListServiceImpl
 * @Description
 * @Author yuxiang
 * @Date 2019/12/16 15:11
 **/
@Service
public class FileListServiceImpl extends BaseService<FileList> implements FileListService {
    @Autowired
    private FileListMapper fileListMapper;

    @Override
    public List<FileList> selectByFileList(FileList fileList) {
        Example example = new Example(FileList.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(fileList.getDirectory())) {
            criteria.andEqualTo("directory", fileList.getDirectory());
        }
        if (null != fileList.getFileId()) {
            criteria.andEqualTo("fileId", fileList.getFileId());
        }
        if (null != fileList.getParentId()) {
            criteria.andEqualTo("parentId", fileList.getParentId());
        }
        Optional<List<FileList>> fileLists = Optional.of(selectByExample(example));
        return fileLists.isPresent() ? fileLists.get() : Collections.EMPTY_LIST;
    }

    @Override
    public FileList selectByFileId(Long fileId) {
        FileList fileList = selectByKey(fileId);
        return fileList;
    }

    @Override
    public List<FileList> selectByFileIds(List<Long> fileIds) {
        Example example = new Example(FileList.class);
        Example.Criteria criteria = example.createCriteria();
        if (!CollectionUtils.isEmpty(fileIds)){
            criteria.andIn("fileId",fileIds);
        }
        Optional<List<FileList>> fileLists = Optional.of(selectByExample(example));
        return fileLists.isPresent() ? fileLists.get() : Collections.EMPTY_LIST;
    }

    @Override
    public int insertFileList(List<FileList> fileLists) {
        return fileListMapper.insertList(fileLists);
    }
}
