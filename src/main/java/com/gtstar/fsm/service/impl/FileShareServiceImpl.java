package com.gtstar.fsm.service.impl;

import com.gtstar.fsm.entity.FileList;
import com.gtstar.fsm.entity.FileShare;
import com.gtstar.fsm.mapper.FileListMapper;
import com.gtstar.fsm.mapper.FileShareMapper;
import com.gtstar.fsm.service.FileListService;
import com.gtstar.fsm.service.FileShareService;
import com.gtstar.fsm.util.DateUtil;
import com.gtstar.fsm.util.FileUtil;
import com.gtstar.fsm.util.UrlUtil;
import com.gtstar.fsm.util.ZipUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.stream.Collectors;
import java.util.zip.ZipOutputStream;

/**
 * @ClassName FileShareServiceImpl
 * @Description
 * @Author yuxiang
 * @Date 2019/12/17 11:07
 **/
@Service
@Slf4j
public class FileShareServiceImpl extends BaseService<FileShare> implements FileShareService {
    private static final String ORIGINAL_URL = "http://127.0.0.1:8081/share/download/";

    @Value("${}")
    String originalUrl;
    @Value("${download.temp.path}")
    private String tempPath;

    @Autowired
    private FileShareMapper fileShareMapper;
    @Autowired
    private FileListMapper fileListMapper;
    @Autowired
    private FileListService fileListService;

    /**
     * 生成链接
     *
     * @param fileIds
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public String generateLink(String fileIds) {
        //生成链接
        String[] aResult = UrlUtil.shortUrl(ORIGINAL_URL);//将产生4组6位字符串
        Random random = new Random();
        int j = random.nextInt(4);//产成4以内随机数
        log.info("短链接:" + aResult[j]);//随机取一个作为短链
        String finalUrl = ORIGINAL_URL + aResult[j];
        log.info("最终链接:" + finalUrl);

        FileShare fileShare = new FileShare();
        LocalDate localDate = LocalDate.now();
        fileShare.setLinkAddress(aResult[j]).
                setShareTime(localDate).
                setInactiveTime(DateUtil.plusCountWeek(localDate, 1)).
                setFileIds(fileIds);
        fileShareMapper.insertFileShare(fileShare);
        return finalUrl;
    }

    @Override
    public List<FileShare> getFileShare(FileShare fileShare) {
        Example example = new Example(FileShare.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(fileShare.getLinkAddress())) {
            criteria.andEqualTo("linkAddress", fileShare.getLinkAddress());
        }
        Optional<List<FileShare>> fileLists = Optional.of(selectByExample(example));
        return fileLists.isPresent() ? fileLists.get() : Collections.EMPTY_LIST;
    }

    @Override
    public void download(String randomUrl, HttpServletResponse response) throws IOException {
        if (!StringUtils.isEmpty(randomUrl)) {
            FileShare fileShare = new FileShare();
            List<FileShare> fileShareList = getFileShare(new FileShare().setLinkAddress(randomUrl));
            if (!CollectionUtils.isEmpty(fileShareList)) {
                fileShare = fileShareList.get(0);
            }
            String fileIds = fileShare.getFileIds();

            List<Long> fileIdList = new ArrayList<>();
            if (!StringUtils.isEmpty(fileIds)) {
                String[] fileIdArr = fileIds.split(",");
                fileIdList = Arrays.stream(fileIdArr).map((x) -> Long.parseLong(x)).collect(Collectors.toList());
            }
            //要下载的文件集合
            List<FileList> fileLists = fileListService.selectByFileIds(fileIdList);
            List<File> files = new ArrayList<>();
            fileLists.forEach((x) -> {
                File file = new File(x.getDirectory());
                files.add(file);
            });
            //单个文件直接下载 不需要压缩
            FileList fileList = fileLists.get(0);
            if (fileLists.size() == 1 && fileList.getIsFolder() == 0) {
                FileUtil.download(response, fileList.getDirectory(), fileList.getFileName());
            } else if (fileLists.size() == 1 && fileList.getIsFolder() == 1) {
                //下载单个文件夹直接用文件夹名字命名
                downLoadFolderZip(response, files, fileList.getFileName()+".zip");
            } else {
                String ran = UUID.randomUUID().toString();
                String zipName = ran.substring(ran.lastIndexOf("-") + 1, ran.length()) + ".zip";
                downLoadFolderZip(response, files, zipName);
            }
        }
    }

    public void downLoadFolderZip(HttpServletResponse response, List<File> files, String zipName) {
        String tempPath = this.tempPath;
        File tempFile = new File(tempPath);
        if (!tempFile.exists()) {
            tempFile.mkdirs();
        }
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        OutputStream out = null;
        try {
            fos = new FileOutputStream(new File(tempPath + zipName));
            File file = new File(zipName);
            ZipUtils.toZip(files, fos, true);
            FileUtil.download(response, tempPath + zipName, zipName);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }

    }


    public void downLoadFolderZip(HttpServletResponse response) {
        String zipName = "";// 定义压缩包名称
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        OutputStream out = null;
        try {
            zipName = "test2" + ".zip";//下载的zip名称
            File zipFile = new File(zipName);

            try {
                File files = new File("F:\\preview");
                fos = new FileOutputStream(zipName);
                zos = new ZipOutputStream(fos);

                ZipUtils.writeZip(files, "", zos);

            } catch (FileNotFoundException e) {
                log.error(e.getMessage(), e);
            } finally {
                if (zos != null) {
                    zos.close();//这里关闭ZipOutputStream，不会出现解压文件文件末端出错的问题
                }
            }
            String zipName1 = "3.zip";
            FileOutputStream fos1 = new FileOutputStream(new File("C:\\Users\\gtstar\\Desktop\\test\\" + zipName1));
            File file = new File(zipName1);
//            ZipUtils.toZip("F:\\preview", fos1, true);
            FileUtil.download(response, file.getPath(), "0.zip");
                /*try {
                    out = response.getOutputStream();
                    response.reset();
                    response.setHeader("Content-Disposition", "attachment;filename="
                            + new String(zipName.getBytes("GB2312"), "ISO-8859-1"));
                    response.setContentType("application/octet-stream; charset=utf-8");
                    response.setCharacterEncoding("UTF-8");
                    out.write(FileUtils.readFileToByteArray(file));
                    out.flush();

                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                } finally {
                    if (fos != null) {
                        fos.close();
                    }
                    if (out != null) {
                        out.close();
                    }
                }*/
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
