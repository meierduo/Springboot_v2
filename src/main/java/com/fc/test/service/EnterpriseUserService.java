package com.fc.test.service;

import java.util.Date;
import java.util.List;
import java.util.Arrays;

import com.fc.test.shiro.util.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.core.util.StrUtil;
import com.fc.test.common.base.BaseService;
import com.fc.test.common.support.ConvertUtil;
import com.fc.test.mapper.auto.EnterpriseUserMapper;
import com.fc.test.model.auto.EnterpriseUser;
import com.fc.test.model.auto.EnterpriseUserExample;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.util.SnowflakeIdWorker;
import com.fc.test.util.StringUtils;

/**
 * 企业用户表 EnterpriseUserService
 * @Title: EnterpriseUserService.java 
 * @Package com.fc.test.service 
 * @author xumingming_自动生成
 * @email 201979731@qq.com
 * @date 2020-06-17 18:27:05  
 **/
@Service
public class EnterpriseUserService implements BaseService<EnterpriseUser, EnterpriseUserExample>{
	@Autowired
	private EnterpriseUserMapper enterpriseUserMapper;
	
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<EnterpriseUser> list(Tablepar tablepar,String searchText){
	        EnterpriseUserExample testExample=new EnterpriseUserExample();
	        testExample.setOrderByClause("id ASC");
	        if(StrUtil.isNotEmpty(searchText)){
	        	testExample.createCriteria().andUsernameLike("%"+searchText+"%");
	        }
			if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        }
	        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
	        List<EnterpriseUser> list= enterpriseUserMapper.selectByExample(testExample);
	        PageInfo<EnterpriseUser> pageInfo = new PageInfo<EnterpriseUser>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
				
			List<String> lista=ConvertUtil.toListStrArray(ids);
			EnterpriseUserExample example=new EnterpriseUserExample();
			example.createCriteria().andIdIn(lista);
			return enterpriseUserMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public EnterpriseUser selectByPrimaryKey(String id) {
				
			return enterpriseUserMapper.selectByPrimaryKey(id);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(EnterpriseUser record) {
		return enterpriseUserMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(EnterpriseUser record) {
				
		//添加雪花主键id
		record.setId(SnowflakeIdWorker.getUUID());
			
				
		return enterpriseUserMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(EnterpriseUser record, EnterpriseUserExample example) {
		
		return enterpriseUserMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(EnterpriseUser record, EnterpriseUserExample example) {
		
		return enterpriseUserMapper.updateByExample(record, example);
	}

	@Override
	public List<EnterpriseUser> selectByExample(EnterpriseUserExample example) {
		
		return enterpriseUserMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(EnterpriseUserExample example) {
		
		return enterpriseUserMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(EnterpriseUserExample example) {
		
		return enterpriseUserMapper.deleteByExample(example);
	}
	
	/**
	 * 检查name
	 * @param enterpriseUser
	 * @return
	 */
	public int checkNameUnique(EnterpriseUser enterpriseUser){
		EnterpriseUserExample example=new EnterpriseUserExample();
		example.createCriteria().andUsernameEqualTo(enterpriseUser.getUsername());
		List<EnterpriseUser> list=enterpriseUserMapper.selectByExample(example);
		return list.size();
	}

	/*
	* @Description 修改用户账号状态
	* @PARAM [id, status]
	* @RETURN int
	**/
	public int updateStateByPrimaryKey(String id, boolean status) {

		String isused = "0";
		if (status) {
			isused = "1";
		}
		String updateUserId = ShiroUtils.getUserId();
		String updateUserName = ShiroUtils.getLoginName();
		
		return enterpriseUserMapper.updateStateByPrimaryKey(id, isused, new Date(), updateUserId, updateUserName);
	}
}
