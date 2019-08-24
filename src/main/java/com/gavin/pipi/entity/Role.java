package com.gavin.pipi.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangguoqiang
 * @since 2019-08-24
 */
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("roleId")
    private Long roleId;
    /**
     * 角色名称
     */
    @TableField("roleName")
    private String roleName;
    /**
     * 角色标识
     */
    @TableField("roleMark")
    private String roleMark;
    /**
     * 创建时间
     */
    @TableField("createTime")
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField("udpateTime")
    private Date udpateTime;


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleMark() {
        return roleMark;
    }

    public void setRoleMark(String roleMark) {
        this.roleMark = roleMark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUdpateTime() {
        return udpateTime;
    }

    public void setUdpateTime(Date udpateTime) {
        this.udpateTime = udpateTime;
    }

    @Override
    public String toString() {
        return "Role{" +
        "roleId=" + roleId +
        ", roleName=" + roleName +
        ", roleMark=" + roleMark +
        ", createTime=" + createTime +
        ", udpateTime=" + udpateTime +
        "}";
    }
}
