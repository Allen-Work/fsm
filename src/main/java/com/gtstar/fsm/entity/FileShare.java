package com.gtstar.fsm.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import javax.persistence.*;

@Table(name = "file_share")
@Data
@Accessors(chain = true)
public class FileShare{
    @Id
    @Column(name = "share_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shareId;

    @Column(name = "file_ids")
    private String fileIds;
    /**
     * 分享链接
     */
    @Column(name = "link_address")
    private String linkAddress;

    /**
     * 浏览次数
     */
    @Column(name = "view_count")
    private Integer viewCount;

    /**
     * 下载次数
     */
    @Column(name = "download_count")
    private Integer downloadCount;

    /**
     * 分享时间
     */
    @Column(name = "share_time")
    private LocalDate shareTime;

    /**
     * 失效时间
     */
    @Column(name = "inactive_time")
    private LocalDate inactiveTime;
}