package com.fc.test.service;

import java.util.Date;
import java.util.List;
import java.util.Arrays;

import com.fc.test.mapper.auto.TsysFileDataMapper;
import com.fc.test.mapper.auto.TsysFileMapper;
import com.fc.test.model.auto.*;
import com.fc.test.shiro.util.ShiroUtils;
import com.fc.test.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.core.util.StrUtil;
import com.fc.test.common.base.BaseService;
import com.fc.test.common.support.ConvertUtil;
import com.fc.test.mapper.auto.ElectricityCompanyMapper;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.util.SnowflakeIdWorker;
import com.fc.test.util.StringUtils;

/**
 * 售电公司用户表 ElectricityCompanyService
 *
 * @author xumingming_自动生成
 * @Title: ElectricityCompanyService.java 
 * @Package com.fc.test.service 
 * @email 201979731@qq.com
 * @date 2020-06-17 18:27:51  
 **/
@Service
public class ElectricityCompanyService implements BaseService<ElectricityCompany, ElectricityCompanyExample> {
    @Autowired
    private ElectricityCompanyMapper electricityCompanyMapper;

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
    public PageInfo<ElectricityCompany> list(Tablepar tablepar, String searchText) {
        ElectricityCompanyExample testExample = new ElectricityCompanyExample();
        if (StrUtil.isNotEmpty(searchText)) {
            testExample.createCriteria().andUsernameLike("%" + searchText + "%").andIsusedEqualTo("1");
        }
        if (StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
            testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) + " " + tablepar.getIsAsc());
        }
        testExample.createCriteria().andIsusedEqualTo("1");
        testExample.setOrderByClause("id ASC");
        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        List<ElectricityCompany> list = electricityCompanyMapper.selectByExample(testExample);
        PageInfo<ElectricityCompany> pageInfo = new PageInfo<ElectricityCompany>(list);
        return pageInfo;
    }

    @Override
    public int deleteByPrimaryKey(String ids) {

        List<String> lista = ConvertUtil.toListStrArray(ids);
        ElectricityCompanyExample example = new ElectricityCompanyExample();
        example.createCriteria().andIdIn(lista);
        return electricityCompanyMapper.deleteByExample(example);


    }


    @Override
    public ElectricityCompany selectByPrimaryKey(String id) {

        return electricityCompanyMapper.selectByPrimaryKey(id);

    }


    @Override
    public int updateByPrimaryKeySelective(ElectricityCompany record) {
        ElectricityCompany electricityCompany = electricityCompanyMapper.selectByPrimaryKey(record.getId());

        if (!electricityCompany.getBusinessLicense().equals(record.getBusinessLicense()) && StrUtil.isNotEmpty(record.getBusinessLicense())) {
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
            tsysFileData.setDataId(record.getBusinessLicense());
            tsysFileDataMapper.insert(tsysFileData);

            //营业执照
            record.setBusinessLicense(tsysFile.getId());
        }

        //修改时间
        record.setUpdateTime(new Date());
        //修改人ID
        record.setUpdateUserId(ShiroUtils.getUserId());
        //修改人姓名
        record.setUpdateUserName(ShiroUtils.getLoginName());

        return electricityCompanyMapper.updateByPrimaryKeySelective(record);
    }


    /**
     * 添加
     */
    @Override
    public int insertSelective(ElectricityCompany record) {

        //添加雪花主键id
        record.setId(SnowflakeIdWorker.getUUID());

        if (!StrUtil.isEmpty(record.getBusinessLicense())) {
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
            tsysFileData.setDataId(record.getBusinessLicense());
            tsysFileDataMapper.insert(tsysFileData);

            //图片地址
            record.setBusinessLicense(tsysFile.getId());
        }

        return electricityCompanyMapper.insertSelective(record);
    }


    @Override
    public int updateByExampleSelective(ElectricityCompany record, ElectricityCompanyExample example) {

        return electricityCompanyMapper.updateByExampleSelective(record, example);
    }


    @Override
    public int updateByExample(ElectricityCompany record, ElectricityCompanyExample example) {

        return electricityCompanyMapper.updateByExample(record, example);
    }

    @Override
    public List<ElectricityCompany> selectByExample(ElectricityCompanyExample example) {

        return electricityCompanyMapper.selectByExample(example);
    }


    @Override
    public long countByExample(ElectricityCompanyExample example) {

        return electricityCompanyMapper.countByExample(example);
    }


    @Override
    public int deleteByExample(ElectricityCompanyExample example) {

        return electricityCompanyMapper.deleteByExample(example);
    }

    /**
     * 检查name
     *
     * @param electricityCompany
     * @return
     */
    public int checkNameUnique(ElectricityCompany electricityCompany) {
        ElectricityCompanyExample example = new ElectricityCompanyExample();
        example.createCriteria().andUsernameEqualTo(electricityCompany.getUsername());
        List<ElectricityCompany> list = electricityCompanyMapper.selectByExample(example);
        return list.size();
    }

    /**
     * 修改用户密码
     *
     * @param record
     * @return
     */
    public int updateElectricityCompanyPassword(ElectricityCompany record) {
        record.setPassword(MD5Util.encode(record.getPassword()));
        //修改用户信息
        return electricityCompanyMapper.updateByPrimaryKeySelective(record);
    }

}
