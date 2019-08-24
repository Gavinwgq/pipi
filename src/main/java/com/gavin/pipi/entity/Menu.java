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
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("menuId")
    private Long menuId;
    /**
     * 菜单名称
     */
    @TableField("menuName")
    private String menuName;
    /**
     * 菜单类型
     */
    @TableField("menuType")
    private String menuType;
    /**
     * 父菜单id
     */
    @TableField("menuParent")
    private Long menuParent;
    /**
     * 权限标识
     */
    @TableField("menuPerm")
    private String menuPerm;
    /**
     * 创建时间
     */
    @TableField("createTime")
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField("updateTime")
    private Date updateTime;


    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public Long getMenuParent() {
        return menuParent;
    }

    public void setMenuParent(Long menuParent) {
        this.menuParent = menuParent;
    }

    public String getMenuPerm() {
        return menuPerm;
    }

    public void setMenuPerm(String menuPerm) {
        this.menuPerm = menuPerm;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Menu{" +
        "menuId=" + menuId +
        ", menuName=" + menuName +
        ", menuType=" + menuType +
        ", menuParent=" + menuParent +
        ", menuPerm=" + menuPerm +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
