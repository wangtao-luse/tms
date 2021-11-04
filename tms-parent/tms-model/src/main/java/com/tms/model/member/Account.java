package com.tms.model.member;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author wangtao
 * @since 2021-11-02
 */
@TableName("t_a_account")
@ApiModel(value="Account对象", description="用户表")
public class Account extends Model<Account> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户唯一号	唯一(从10000开始)")
    @TableField("UID")
    private String uid;

    @ApiModelProperty(value = "性别(0：女；1：男)")
    @TableField("SEX")
    private String sex;

    @ApiModelProperty(value = "注册时间")
    @TableField("CREATEDATE")
    private Long createdate;

    @ApiModelProperty(value = "注册IP")
    @TableField("CREATEIP")
    private String createip;

    @ApiModelProperty(value = "上次登录时间")
    @TableField("LASTTIME")
    private Long lasttime;

    @ApiModelProperty(value = "状态(0：禁用；1：正常)")
    @TableField("STATUS")
    private String status;

    @ApiModelProperty(value = "用户类型(0:普通用户;1:管理员)")
    @TableField("UTYPE")
    private String utype;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Long getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Long createdate) {
        this.createdate = createdate;
    }

    public String getCreateip() {
        return createip;
    }

    public void setCreateip(String createip) {
        this.createip = createip;
    }

    public Long getLasttime() {
        return lasttime;
    }

    public void setLasttime(Long lasttime) {
        this.lasttime = lasttime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUtype() {
        return utype;
    }

    public void setUtype(String utype) {
        this.utype = utype;
    }

    @Override
	public Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Account{" +
        "id=" + id +
        ", uid=" + uid +
        ", sex=" + sex +
        ", createdate=" + createdate +
        ", createip=" + createip +
        ", lasttime=" + lasttime +
        ", status=" + status +
        ", utype=" + utype +
        "}";
    }
}
