package com.gtstar.fsm.jsch;

import lombok.Data;

/**
 * @ClassName SftpConfig
 * @Description TODO
 * @Author yuxiang
 * @Date 2020/1/17 13:56
 **/

@Data
public class SftpConfig {
    /**
     * 密钥地址
     */

    private String privateKeyPath;
    /**
     * 口令
     */

    private String passphrase;

    private String ip;

    private Integer port;

    private String username;

    private String pwd;

    private String path;

    private String baseDir;
}
