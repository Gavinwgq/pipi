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
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("userId")
    private Long userId;
    /**
     * 用户名
     */
    @TableField("userName")
    private String userName;
    /**
     * 昵称
     */
    @TableField("userNickName")
    private String userNickName;
    /**
     * 密码
     */
    @TableField("userPassword")
    private String userPassword;
    /**
     * 加密盐值
     */
    @TableField("userSalt")
    private String userSalt;
    /**
     * 用户状态0、正常1、冻结
     */
    @TableField("userState")
    private String userState;
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


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserSalt() {
        return userSalt;
    }

    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
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
        return "User{" +
        "userId=" + userId +
        ", userName=" + userName +
        ", userNickName=" + userNickName +
        ", userPassword=" + userPassword +
        ", userSalt=" + userSalt +
        ", userState=" + userState +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
