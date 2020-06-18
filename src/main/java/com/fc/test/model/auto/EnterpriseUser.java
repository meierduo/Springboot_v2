package com.fc.test.model.auto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 企业用户表 EnterpriseUser 
 * @author xumingming_自动生成
 * @email 201979731@qq.com
 * @date 2020-06-17 18:27:05
 */
 @ApiModel(value="EnterpriseUser", description="企业用户表")
public class EnterpriseUser implements Serializable {

	private static final long serialVersionUID = 1L;
	
		
	/** 主键 **/
	@ApiModelProperty(value = "主键")
	private String id;
		
	/** 用户名 **/
	@ApiModelProperty(value = "用户名")
	private String username;
		
	/** 密码 **/
	@ApiModelProperty(value = "密码")
	private String password;
		
	/** 企业名称 **/
	@ApiModelProperty(value = "企业名称")
	private String enterpriseName;
		
	/** 企业地址 **/
	@ApiModelProperty(value = "企业地址")
	private String enterpriseAdress;
		
	/** 手机号 **/
	@ApiModelProperty(value = "手机号")
	private String phoneNumber;
		
	/** 联系人姓名 **/
	@ApiModelProperty(value = "联系人姓名")
	private String contactName;
		
	/** 联系人职务 **/
	@ApiModelProperty(value = "联系人职务")
	private String contactJob;
		
	/** 创建时间 **/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
		
	/** 修改时间 **/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "修改时间")
	private Date updateTime;
		
	/** 修改人ID **/
	@ApiModelProperty(value = "修改人ID")
	private String updateUserId;
		
	/** 修改人名字 **/
	@ApiModelProperty(value = "修改人名字")
	private String updateUserName;
		
	/** 0冻结 1正常 **/
	@ApiModelProperty(value = "0冻结 1正常")
	private String isused;
		
	/** 0审核失败 1审核中 2审核通过 **/
	@ApiModelProperty(value = "0审核失败 1审核中 2审核通过")
	private String ischeck;
		
		
	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
	 
			
	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
	 
			
	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
	 
			
	public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }
	 
			
	public String getEnterpriseAdress() {
        return enterpriseAdress;
    }

    public void setEnterpriseAdress(String enterpriseAdress) {
        this.enterpriseAdress = enterpriseAdress;
    }
	 
			
	public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
	 
			
	public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
	 
			
	public String getContactJob() {
        return contactJob;
    }

    public void setContactJob(String contactJob) {
        this.contactJob = contactJob;
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
	 
			
	public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }
	 
			
	public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }
	 
			
	public String getIsused() {
        return isused;
    }

    public void setIsused(String isused) {
        this.isused = isused;
    }
	 
			
	public String getIscheck() {
        return ischeck;
    }

    public void setIscheck(String ischeck) {
        this.ischeck = ischeck;
    }
	 
			
	public EnterpriseUser() {
        super();
    }
    
																																																																								
	public EnterpriseUser(String id,String username,String password,String enterpriseName,String enterpriseAdress,String phoneNumber,String contactName,String contactJob,Date createTime,Date updateTime,String updateUserId,String updateUserName,String isused,String ischeck) {
	
		this.id = id;
		this.username = username;
		this.password = password;
		this.enterpriseName = enterpriseName;
		this.enterpriseAdress = enterpriseAdress;
		this.phoneNumber = phoneNumber;
		this.contactName = contactName;
		this.contactJob = contactJob;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.updateUserId = updateUserId;
		this.updateUserName = updateUserName;
		this.isused = isused;
		this.ischeck = ischeck;
		
	}
	
}