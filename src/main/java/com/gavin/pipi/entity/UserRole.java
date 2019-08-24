package com.gavin.pipi.entity;

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
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("userRoleId")
    private Long userRoleId;
    /**
     * 用户id
     */
    @TableField("userId")
    private Long userId;
    /**
     * 角色id
     */
    @TableField("roleId")
    private Long roleId;


    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRole{" +
        "userRoleId=" + userRoleId +
        ", userId=" + userId +
        ", roleId=" + roleId +
        "}";
    }
}
