package com.fc.test.service;

import java.sql.Struct;
import java.util.Date;
import java.util.List;
import java.util.Arrays;

import com.fc.test.mapper.auto.TsysFileDataMapper;
import com.fc.test.mapper.auto.TsysFileMapper;
import com.fc.test.model.auto.TsysFile;
import com.fc.test.model.auto.TsysFileData;
import com.fc.test.shiro.util.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.core.util.StrUtil;
import com.fc.test.common.base.BaseService;
import com.fc.test.common.support.ConvertUtil;
import com.fc.test.mapper.auto.NewsMapper;
import com.fc.test.model.auto.News;
import com.fc.test.model.auto.NewsExample;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.util.SnowflakeIdWorker;
import com.fc.test.util.StringUtils;

/**
 * 新闻列表 NewsService
 *
 * @author xumingming_自动生成
 * @Title: NewsService.java 
 * @Package com.fc.test.service 
 * @email 201979731@qq.com
 * @date 2020-06-16 13:01:17  
 **/
@Service
public class NewsService implements BaseService<News, NewsExample> {
    @Autowired
    private NewsMapper newsMapper;

    //文件存储关联mapper
    @Autowired
    private TsysFileDataMapper tsysFileDataMapper;

    //文件信息mapper
    @Autowired
    private TsysFileMapper tsysFileMapper;

    /**
     * 分页查询
     *
     * @param tablepar
     * @param searchText
     * @return
     */
    public PageInfo<News> list(Tablepar tablepar, String searchText) {
        NewsExample testExample = new NewsExample();
        if (StrUtil.isNotEmpty(searchText)) {
			testExample.createCriteria().andTitleLike("%" + searchText + "%").andIsdeleteEqualTo("0");
		}
		if (StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
			testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) + " " + tablepar.getIsAsc());
		}
		testExample.createCriteria().andIsdeleteEqualTo("0");
		testExample.setOrderByClause("id ASC");
		PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        List<News> list = newsMapper.selectByExample(testExample);
        PageInfo<News> pageInfo = new PageInfo<News>(list);
        return pageInfo;
    }

    @Override
    public int deleteByPrimaryKey(String ids) {

        Integer[] integers = ConvertUtil.toIntArray(",", ids);
        List<Integer> stringB = Arrays.asList(integers);
        NewsExample example = new NewsExample();
        example.createCriteria().andIdIn(stringB);

        //先查出fileid
        List<News> list = newsMapper.selectByExample(example);

        int result = newsMapper.deleteByExample(example);

        //删除成功
        if (result > 0) {
            //删除对应文件及关联表数据
            list.forEach(news -> {
                tsysFileMapper.deleteByPrimaryKey(news.getImgUrl());
                tsysFileDataMapper.deleteByFileId(news.getImgUrl());
            });

        }
        return result;


    }

    public int updateStateByPrimaryKey(Integer id, boolean status) {

        String state = "0";
        if (status) {
            state = "1";
        }
        return newsMapper.updateStateByPrimaryKey(id, state, new Date());
    }

    public int updateTopByPrimaryKey(Integer id, boolean status) {

        String state = "0";
        if (status) {
            state = "1";
        }
        return newsMapper.updateTopByPrimaryKey(id, state, new Date());
    }

    public int updateIndexByPrimaryKey(Integer id, boolean status) {

        String state = "0";
        if (status) {
            state = "1";
        }
        return newsMapper.updateIndexByPrimaryKey(id, state, new Date());
    }

    @Override
    public News selectByPrimaryKey(String id) {

        Integer id1 = Integer.valueOf(id);
        return newsMapper.selectByPrimaryKey(id1);

    }


    @Override
    public int updateByPrimaryKeySelective(News record) {

        News news = newsMapper.selectByPrimaryKey(record.getId());
        if (!news.getImgUrl().equals(record.getImgUrl()) && StrUtil.isNotEmpty(record.getImgUrl())) {
            TsysFile tsysFile = new TsysFile();

            //图片单独处理
            //插入创建人id
            tsysFile.setCreateUserId(ShiroUtils.getUserId());
            //插入创建人name
            tsysFile.setCreateUserName(ShiroUtils.getLoginName());
            //插入创建时间
            tsysFile.setCreateTime(new Date());
            //添加雪花主键id
            tsysFile.setId(SnowflakeIdWorker.getUUID());

            tsysFileMapper.insertSelective(tsysFile);

            //图片插入关联表
            TsysFileData tsysFileData = new TsysFileData();
            tsysFileData.setId(SnowflakeIdWorker.getUUID());
            tsysFileData.setFileId(tsysFile.getId());
            tsysFileData.setDataId(record.getImgUrl());
            tsysFileDataMapper.insert(tsysFileData);

            //图片地址
            record.setImgUrl(tsysFile.getId());
        }

        //修改时间
        record.setUpdateTime(new Date());
        return newsMapper.updateByPrimaryKeySelective(record);
    }


    /**
     * 添加
     */
    @Override
    public int insertSelective(News record) {

        record.setId(null);

        if(!StrUtil.isEmpty(record.getImgUrl())){
            TsysFile tsysFile = new TsysFile();

            //图片单独处理
            //插入创建人id
            tsysFile.setCreateUserId(ShiroUtils.getUserId());
            //插入创建人name
            tsysFile.setCreateUserName(ShiroUtils.getLoginName());
            //插入创建时间
            tsysFile.setCreateTime(new Date());
            //添加雪花主键id
            tsysFile.setId(SnowflakeIdWorker.getUUID());

            tsysFileMapper.insertSelective(tsysFile);

            //图片插入关联表
            TsysFileData tsysFileData = new TsysFileData();
            tsysFileData.setId(SnowflakeIdWorker.getUUID());
            tsysFileData.setFileId(tsysFile.getId());
            tsysFileData.setDataId(record.getImgUrl());
            tsysFileDataMapper.insert(tsysFileData);

            //图片地址
            record.setImgUrl(tsysFile.getId());
        }
        return newsMapper.insertSelective(record);
    }


    @Override
    public int updateByExampleSelective(News record, NewsExample example) {

        return newsMapper.updateByExampleSelective(record, example);
    }


    @Override
    public int updateByExample(News record, NewsExample example) {

        return newsMapper.updateByExample(record, example);
    }

    @Override
    public List<News> selectByExample(NewsExample example) {
        example.createCriteria().andIsdeleteEqualTo("0");
        return newsMapper.selectByExample(example);
    }


    @Override
    public long countByExample(NewsExample example) {

        return newsMapper.countByExample(example);
    }


    @Override
    public int deleteByExample(NewsExample example) {

        return newsMapper.deleteByExample(example);
    }

    /**
     * 检查name
     *
     * @param news
     * @return
     */
    public int checkNameUnique(News news) {
        NewsExample example = new NewsExample();
        example.createCriteria().andTitleEqualTo(news.getTitle());
        example.createCriteria().andIsdeleteEqualTo("0");
        List<News> list = newsMapper.selectByExample(example);
        return list.size();
    }


}
