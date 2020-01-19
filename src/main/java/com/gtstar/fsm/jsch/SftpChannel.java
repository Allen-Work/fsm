package com.gtstar.fsm.jsch;

import com.jcraft.jsch.*;
import org.springframework.util.StringUtils;

import java.util.Properties;

/**
 * @ClassName SftpChannel
 * @Description TODO
 * @Author yuxiang
 * @Date 2020/1/17 15:03
 **/

public class SftpChannel {
    Session session = null;
    Channel channel = null;

    //端口默认为22
    public static final int SFTP_DEFAULT_PORT = 22;

    /**
     * 利用 JSch 包实现SFTP下载、上传文件(密钥方式登录)
     */

    public ChannelSftp connectByIdentity(SftpConfig sftpConfig) throws JSchException {
        JSch jSch = new JSch();
        int port = SFTP_DEFAULT_PORT;
        //设置密钥和密码
        //支持密钥的登录方式,只需在 jsch.getSession之前设置一下密钥的相关信息就好了
        if (!StringUtils.isEmpty(sftpConfig.getPrivateKeyPath())) {
            if (!StringUtils.isEmpty(sftpConfig.getPassphrase())) {
                //设置带口令的密钥
                jSch.addIdentity(sftpConfig.getPrivateKeyPath(), sftpConfig.getPassphrase());
            } else {
                //设置不带口令的密钥
                jSch.addIdentity(sftpConfig.getPrivateKeyPath());
            }
        }

        if (sftpConfig.getPort() != null) {
            port = Integer.valueOf(sftpConfig.getPort());
        }

        if (port > 0) {
            //采用指定的端口连接服务器
            session = jSch.getSession(sftpConfig.getUsername(), sftpConfig.getIp(), sftpConfig.getPort());
        } else {
            //连接服务器采用默认端口
            session = jSch.getSession(sftpConfig.getUsername(), sftpConfig.getIp());
        }

        if (session == null) {
            throw new JSchException("session为空,连接失败");
        }
        Properties sshConfig = new Properties();
        sshConfig.put("StrictHostKeyChecking", "no");
        session.setConfig(sshConfig);
        session.setTimeout(30000);
        session.connect();
        //创建sftp通道
        channel = session.openChannel("sftp");
        channel.connect();
        return (ChannelSftp) channel;
    }


    /**
     * 利用JSch 包实现SFTP下载、上传文件(用户密码方式登录)
     */


    public ChannelSftp connectByPwd(SftpConfig sftpConfig) throws JSchException {
        JSch jSch = new JSch();
        int port = SFTP_DEFAULT_PORT;
        if (sftpConfig.getPort() != null) {
            port = Integer.valueOf(sftpConfig.getPort());
        }
        if (port > 0) {
            //采用指定的端口连接服务器
            session = jSch.getSession(sftpConfig.getUsername(), sftpConfig.getIp(), port);
        } else {
            //连接服务器，采用默认端口
            session = jSch.getSession(sftpConfig.getUsername(), sftpConfig.getIp());
        }
        if (session == null) {
            throw new JSchException("session为空，连接失败");
        }
        //设置登录主机密码
        session.setPassword(sftpConfig.getPwd());
        Properties sshConfig = new Properties();
        sshConfig.put("StrictHostKeyChecking", "no");
        session.setConfig(sshConfig);
        session.setTimeout(30000);
        session.connect();
        //创建sftp通信通道
        channel = session.openChannel("sftp");
        channel.connect();
        return (ChannelSftp) channel;
    }

    public void closeChannel() {
        if (channel != null) {
            channel.disconnect();
        }
        if (session != null) {
            session.disconnect();
        }
    }
}
