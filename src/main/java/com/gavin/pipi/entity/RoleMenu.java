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
public class RoleMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("roleMenuId")
    private Long roleMenuId;
    /**
     * 角色id
     */
    @TableField("roleId")
    private Long roleId;
    /**
     * 菜单id
     */
    @TableField("menuId")
    private Long menuId;


    public Long getRoleMenuId() {
        return roleMenuId;
    }

    public void setRoleMenuId(Long roleMenuId) {
        this.roleMenuId = roleMenuId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "RoleMenu{" +
        "roleMenuId=" + roleMenuId +
        ", roleId=" + roleId +
        ", menuId=" + menuId +
        "}";
    }
}
