package com.xd.pre.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.util.List;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 部门管理
 * </p>
 *
 * @author lihaodong
 * @since 2019-04-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_dept")
public class SysDept extends Model<SysDept> {

    private static final long serialVersionUID = 1L;

    /**
     * 部门主键ID
     */
    @TableId(value = "dept_id", type = IdType.AUTO)
    private Integer deptId;

    /**
     * 部门名称
     */
    private String name;


    /**
     * 上级部门
     */
    private Integer parentId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除  -1：已删除  0：正常
     */
    private String delFlag;

    /**
     * 非数据库字段
     */
    @TableField(exist = false)
    private String parentName;
    /**
     * 非数据库字段
     */
    @TableField(exist = false)
    private Integer level;

    @TableField(exist = false)
    private List<SysDept> children;




}
