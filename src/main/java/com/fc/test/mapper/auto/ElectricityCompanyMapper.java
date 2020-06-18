package com.fc.test.mapper.auto;

import com.fc.test.model.auto.ElectricityCompany;
import com.fc.test.model.auto.ElectricityCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 售电公司用户表 ElectricityCompanyMapper
 * @author xumingming_自动生成
 * @email 201979731@qq.com
 * @date 2020-06-17 18:27:51
 */
public interface ElectricityCompanyMapper {
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      
    long countByExample(ElectricityCompanyExample example);

    int deleteByExample(ElectricityCompanyExample example);
		
    int deleteByPrimaryKey(String id);
		
    int insert(ElectricityCompany record);

    int insertSelective(ElectricityCompany record);

    List<ElectricityCompany> selectByExample(ElectricityCompanyExample example);
		
    ElectricityCompany selectByPrimaryKey(String id);
		
    int updateByExampleSelective(@Param("record") ElectricityCompany record, @Param("example") ElectricityCompanyExample example);

    int updateByExample(@Param("record") ElectricityCompany record, @Param("example") ElectricityCompanyExample example); 
		
    int updateByPrimaryKeySelective(ElectricityCompany record);

    int updateByPrimaryKey(ElectricityCompany record);
  	  	
}