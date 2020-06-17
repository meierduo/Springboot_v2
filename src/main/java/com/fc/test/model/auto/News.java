package com.fc.test.model.auto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.lang.Integer;

/**
 * 新闻列表 News 
 * @author xumingming_自动生成
 * @email 201979731@qq.com
 * @date 2020-06-16 13:01:17
 */
 @ApiModel(value="News", description="新闻列表")
public class News implements Serializable {

	private static final long serialVersionUID = 1L;
	
		
	/** 主键 **/
	@ApiModelProperty(value = "主键")
	private Integer id;
		
	/** 文章标题 **/
	@ApiModelProperty(value = "文章标题")
	private String title;
		
	/** 文章内容（带html标签） **/
	@ApiModelProperty(value = "文章内容（带html标签）")
	private String content;
		
	/** 0不显示 1显示 **/
	@ApiModelProperty(value = "0不显示 1显示")
	private String isshow;
		
	/** 0不置顶 1置顶 **/
	@ApiModelProperty(value = "0不置顶 1置顶")
	private String istop;
		
	/** 0不删除 1删除 **/
	@ApiModelProperty(value = "0不删除 1删除")
	private String isdelete;
		
	/** 0不在首页 1在首页 **/
	@ApiModelProperty(value = "0不在首页 1在首页")
	private String isindex;
		
	/** 图片地址 **/
	@ApiModelProperty(value = "图片地址")
	private String imgUrl;
		
	/** 文章内容 **/
	@ApiModelProperty(value = "文章内容")
	private String textinfo;
		
	/** 创建时间 **/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
		
	/** 修改时间 **/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "修改时间")
	private Date updateTime;
		
		
	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
	 
			
	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
	 
			
	public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
	 
			
	public String getIsshow() {
        return isshow;
    }

    public void setIsshow(String isshow) {
        this.isshow = isshow;
    }
	 
			
	public String getIstop() {
        return istop;
    }

    public void setIstop(String istop) {
        this.istop = istop;
    }
	 
			
	public String getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete;
    }
	 
			
	public String getIsindex() {
        return isindex;
    }

    public void setIsindex(String isindex) {
        this.isindex = isindex;
    }
	 
			
	public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
	 
			
	public String getTextinfo() {
        return textinfo;
    }

    public void setTextinfo(String textinfo) {
        this.textinfo = textinfo;
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
	 
			
	public News() {
        super();
    }
    
																																																									
	public News(Integer id,String title,String content,String isshow,String istop,String isdelete,String isindex,String imgUrl,String textinfo,Date createTime,Date updateTime) {
	
		this.id = id;
		this.title = title;
		this.content = content;
		this.isshow = isshow;
		this.istop = istop;
		this.isdelete = isdelete;
		this.isindex = isindex;
		this.imgUrl = imgUrl;
		this.textinfo = textinfo;
		this.createTime = createTime;
		this.updateTime = updateTime;
		
	}
	
}