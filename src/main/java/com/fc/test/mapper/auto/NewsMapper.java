package com.fc.test.mapper.auto;

import com.fc.test.model.auto.News;
import com.fc.test.model.auto.NewsExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 新闻列表 NewsMapper
 * @author xumingming_自动生成
 * @email 201979731@qq.com
 * @date 2020-06-16 13:01:17
 */
public interface NewsMapper {
      	   	      	      	      	      	      	      	      	      	      	      	      
    long countByExample(NewsExample example);

    int deleteByExample(NewsExample example);
		
    int deleteByPrimaryKey(Integer id);
		
    int insert(News record);

    int insertSelective(News record);

    List<News> selectByExample(NewsExample example);
		
    News selectByPrimaryKey(Integer id);
		
    int updateByExampleSelective(@Param("record") News record, @Param("example") NewsExample example);

    int updateByExample(@Param("record") News record, @Param("example") NewsExample example); 
		
    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);

    int updateStateByPrimaryKey(Integer id, String state, Date updateTime);

    int updateTopByPrimaryKey(Integer id, String state, Date updateTime);

    int updateIndexByPrimaryKey(Integer id, String state, Date updateTime);
}