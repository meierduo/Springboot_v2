package com.fc.test.mapper.auto;

import com.fc.test.model.auto.EnterpriseUser;
import com.fc.test.model.auto.EnterpriseUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 企业用户表 EnterpriseUserMapper
 * @author xumingming_自动生成
 * @email 201979731@qq.com
 * @date 2020-06-17 18:27:05
 */
public interface EnterpriseUserMapper {
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	      
    long countByExample(EnterpriseUserExample example);

    int deleteByExample(EnterpriseUserExample example);
		
    int deleteByPrimaryKey(String id);
		
    int insert(EnterpriseUser record);

    int insertSelective(EnterpriseUser record);

    List<EnterpriseUser> selectByExample(EnterpriseUserExample example);
		
    EnterpriseUser selectByPrimaryKey(String id);
		
    int updateByExampleSelective(@Param("record") EnterpriseUser record, @Param("example") EnterpriseUserExample example);

    int updateByExample(@Param("record") EnterpriseUser record, @Param("example") EnterpriseUserExample example); 
		
    int updateByPrimaryKeySelective(EnterpriseUser record);

    int updateByPrimaryKey(EnterpriseUser record);
  	  	
}