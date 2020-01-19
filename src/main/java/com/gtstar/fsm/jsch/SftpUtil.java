package com.gtstar.fsm.jsch;


import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.util.StringUtils;

/**
 * @ClassName SftpUtil
 * @Description
 * @Author yuxiang
 * @Date 2020/1/17 13:59
 **/

@Slf4j
public class SftpUtil {

    /**
     * 获取 Sftp 对象
     *
     * @param param
     * @return
     */

    public static SftpConfig getSftpConfig(String param) {
        SftpConfig sftpConfig = new SftpConfig();
        if (!StringUtils.isEmpty(param)) {
            JSONObject jsonObject = JSONObject.fromObject(param);
            sftpConfig = (SftpConfig) JSONObject.toBean(jsonObject, SftpConfig.class);
        }
        return sftpConfig;
    }

    /**
     * sftp 上传
     *
     * @param config
     * @param baseDir
     * @param fileName
     * @param filePath
     * @return
     */

    public static boolean upload(SftpConfig config, String baseDir, String fileName, String filePath) {
        log.info("路径: baseDir=" + baseDir);
        SftpChannel sftpChannel = new SftpChannel();
        ChannelSftp sftp = null;
        try {
            if (!StringUtils.isEmpty(config.getPrivateKeyPath())) {
                sftp = sftpChannel.connectByIdentity(config);
            } else {
                sftp = sftpChannel.connectByPwd(config);
            }
            if (sftp.isConnected()) {
                log.info("连接服务器成功了!");
            } else {
                log.info("连接服务器失败!");
                return false;
            }
            //检查路径
            if (!isExist(sftp, baseDir)) {
                log.error("创建sftp服务器路径失败:" + baseDir);
            }
            String dst = baseDir + "/" + fileName;
            String src = filePath + "/" + fileName;
            log.info("开始上传,本地服务器路径: [" + src + "] 目标服务器路径: [" + dst + "]");
            sftp.put(src, dst);
            return true;
        } catch (Exception e) {
            log.error("下载失败", e);
            return false;
        } finally {
            sftpChannel.closeChannel();
        }
    }

    public static boolean down(SftpConfig config, String baseDir, String fileName1, String filePath, String fileName2) {
        SftpChannel sftpChannel = null;
        ChannelSftp sftp = null;
        try {
            if (!StringUtils.isEmpty(config.getPrivateKeyPath())) {
                sftp = sftpChannel.connectByIdentity(config);
            } else {
                sftp = sftpChannel.connectByPwd(config);
            }
            if (sftp.isConnected()) {
                log.info("连接服务器成功");
            } else {
                log.error("连接服务器失败");
                return false;
            }
            String dst = "";
            if (!StringUtils.isEmpty(fileName2)) {
                dst = filePath + fileName1;
            } else {
                dst = filePath + fileName2;
            }
            String src = baseDir + "/" + fileName1;
            log.info("开始下载，sftp服务器路径：[" + src + "]目标服务器路径：[" + dst + "]");
            sftp.get(src, dst);
            log.info("下载成功");
            return true;
        } catch (Exception e) {
            log.error("下载失败", e);
            return false;
        } finally {
            sftpChannel.closeChannel();
        }
    }

    /**
     * 判断文件夹是否存在
     * true 目录创建成功，false 目录创建失败
     *
     * @param sftp
     * @param filePath 文件夹路径
     * @return
     */

    public static boolean isExist(ChannelSftp sftp, String filePath) {
        String paths[] = filePath.split("\\/");
        String dir = paths[0];
        for (int i = 0; i < paths.length - 1; i++) {
            dir = dir + "/" + paths[i + 1];
            try {
                sftp.cd(dir);
            } catch (SftpException sException) {
                if (sftp.SSH_FX_NO_SUCH_FILE == sException.id) {
                    try {
                        sftp.mkdir(dir);
                    } catch (SftpException e) {
                        e.printStackTrace();
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
