package com.fc.test.model.auto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 售电公司用户表 ElectricityCompany 
 * @author xumingming_自动生成
 * @email 201979731@qq.com
 * @date 2020-06-17 18:27:51
 */
 @ApiModel(value="ElectricityCompany", description="售电公司用户表")
public class ElectricityCompany implements Serializable {

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
	private String companyName;
		
	/** 企业地址 **/
	@ApiModelProperty(value = "企业地址")
	private String companyAdress;
		
	/** 手机号 **/
	@ApiModelProperty(value = "手机号")
	private String phoneNumber;
		
	/** 联系人姓名 **/
	@ApiModelProperty(value = "联系人姓名")
	private String contactName;
		
	/** 联系人职务 **/
	@ApiModelProperty(value = "联系人职务")
	private String contactJob;
		
	/** 企业法人 **/
	@ApiModelProperty(value = "企业法人")
	private String legalPerson;
		
	/** 法人电话 **/
	@ApiModelProperty(value = "法人电话")
	private String legalPersonPhone;
		
	/** 营业执照 **/
	@ApiModelProperty(value = "营业执照")
	private String businessLicense;
		
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
	 
			
	public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
	 
			
	public String getCompanyAdress() {
        return companyAdress;
    }

    public void setCompanyAdress(String companyAdress) {
        this.companyAdress = companyAdress;
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
	 
			
	public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }
	 
			
	public String getLegalPersonPhone() {
        return legalPersonPhone;
    }

    public void setLegalPersonPhone(String legalPersonPhone) {
        this.legalPersonPhone = legalPersonPhone;
    }
	 
			
	public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
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
	 
			
	public ElectricityCompany() {
        super();
    }
    
																																																																																							
	public ElectricityCompany(String id,String username,String password,String companyName,String companyAdress,String phoneNumber,String contactName,String contactJob,String legalPerson,String legalPersonPhone,String businessLicense,Date createTime,Date updateTime,String updateUserId,String updateUserName,String isused,String ischeck) {
	
		this.id = id;
		this.username = username;
		this.password = password;
		this.companyName = companyName;
		this.companyAdress = companyAdress;
		this.phoneNumber = phoneNumber;
		this.contactName = contactName;
		this.contactJob = contactJob;
		this.legalPerson = legalPerson;
		this.legalPersonPhone = legalPersonPhone;
		this.businessLicense = businessLicense;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.updateUserId = updateUserId;
		this.updateUserName = updateUserName;
		this.isused = isused;
		this.ischeck = ischeck;
		
	}
	
}