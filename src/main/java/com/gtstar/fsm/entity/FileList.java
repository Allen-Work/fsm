package com.gtstar.fsm.entity;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import javax.persistence.*;

@Table(name = "file_list")
@Data
@Accessors(chain = true)
@ToString
public class FileList {
    /**
     * 主键
     */
    @Id
    @Column(name = "file_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileId;

    /**
     * 目录层级
     */
    private Integer level;

    /**
     * 文件名称
     */
    @Column(name = "file_name")
    private String fileName;

    /**
     * 文件目录
     */
    private String directory;

    /**
     * 文件大小
     */
    private String size;

    /**
     * 文件类型：0.文件夹 1.doc 2.txt......
     */
    @Column(name = "file_type")
    private Integer fileType;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private String createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private String updateTime;

    /**
     * 删除时间
     */
    @Column(name = "delete_time")
    private LocalDateTime deleteTime;

    /**
     * 删除标记
     */
    @Column(name = "delete_flag")
    private Integer deleteFlag;

    /**
     * 是否是文件夹,1是;0否
     */
    @Column(name = "is_folder")
    private Integer isFolder;

    /**
     * 所属上一级目录id
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 备注
     */
    private String remark;
    @Transient
    private Boolean checked = false;
}