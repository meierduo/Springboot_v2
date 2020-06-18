package com.fc.test.controller.gen;

import com.fc.test.model.auto.TsysUser;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageInfo;
import com.fc.test.common.base.BaseController;
import com.fc.test.common.domain.AjaxResult;
import com.fc.test.model.auto.ElectricityCompany;
import com.fc.test.model.custom.TableSplitResult;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.model.custom.TitleVo;
import com.fc.test.service.ElectricityCompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "售电公司用户表")
@Controller
@RequestMapping("/ElectricityCompanyController")
public class ElectricityCompanyController extends BaseController{
	
	private String prefix = "gen/electricityCompany";
	@Autowired
	private ElectricityCompanyService electricityCompanyService;
	
	/**
	 * 分页跳转
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:electricityCompany:view")
    public String view(ModelMap model)
    {	
		String str="售电公司用户表";
		setTitle(model, new TitleVo("列表", str+"管理", true,"欢迎进入"+str+"页面", true, false));
        return prefix + "/list";
    }
	
	/**
	 * 分页查询
	 */
	//@Log(title = "售电公司用户表集合查询", action = "111")
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@PostMapping("/list")
	@RequiresPermissions("gen:electricityCompany:list")
	@ResponseBody
	public Object list(Tablepar tablepar,String searchText){
		PageInfo<ElectricityCompany> page=electricityCompanyService.list(tablepar,searchText) ; 
		TableSplitResult<ElectricityCompany> result=new TableSplitResult<ElectricityCompany>(page.getPageNum(), page.getTotal(), page.getList()); 
		return  result;
	}
	
	/**
     * 新增跳转
     */
    @ApiOperation(value = "新增跳转", notes = "新增跳转")
    @GetMapping("/add")
    public String add(ModelMap modelMap)
    {
        return prefix + "/add";
    }
	
	/**
     * 新增
     */
	//@Log(title = "售电公司用户表新增", action = "111")
   	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:electricityCompany:add")
	@ResponseBody
	public AjaxResult add(ElectricityCompany electricityCompany){
		int b=electricityCompanyService.insertSelective(electricityCompany);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "售电公司用户表删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@PostMapping("/remove")
	@RequiresPermissions("gen:electricityCompany:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=electricityCompanyService.deleteByPrimaryKey(ids);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * 检查Name
	 * @param electricityCompany
	 * @return
	 */
	@ApiOperation(value = "检查Name唯一", notes = "检查Name唯一")
	@PostMapping("/checkNameUnique")
	@ResponseBody
	public int checkNameUnique(ElectricityCompany electricityCompany){
		int b=electricityCompanyService.checkNameUnique(electricityCompany);
		if(b>0){
			return 1;
		}else{
			return 0;
		}
	}
	
	
	/**
	 * 修改跳转
	 * @param id
	 * @param mmap
	 * @return
	 */
	@ApiOperation(value = "修改跳转", notes = "修改跳转")
	@GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        mmap.put("ElectricityCompany", electricityCompanyService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "售电公司用户表修改", action = "111")
    @ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:electricityCompany:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ElectricityCompany record)
    {
        return toAjax(electricityCompanyService.updateByPrimaryKeySelective(record));
    }

	/**
	 * 审核跳转
	 * @param id
	 * @param mmap
	 * @return
	 */
	@ApiOperation(value = "审核跳转", notes = "审核跳转")
	@GetMapping("/check/{id}")
	public String check(@PathVariable("id") String id, ModelMap mmap)
	{
		mmap.put("ElectricityCompany", electricityCompanyService.selectByPrimaryKey(id));

		return prefix + "/check";
	}

	/**
	 * 审核保存
	 */
	//@Log(title = "售电公司用户审核", action = "111")
	@ApiOperation(value = "审核保存", notes = "审核保存")
	@PostMapping("/check")
	@ResponseBody
	public AjaxResult checkSave(ElectricityCompany record)
	{
		return toAjax(electricityCompanyService.updateByPrimaryKeySelective(record));
	}
	
    /**
   	 * 根据主键查询
   	 * 
   	 * @param id
   	 * @return
   	 */
   	@ApiOperation(value = "根据id查询唯一", notes = "根据id查询唯一")
   	@PostMapping("/get/{id}")
   	public ElectricityCompany edit(@PathVariable("id") String id) {
   		return electricityCompanyService.selectByPrimaryKey(id);
   	}


	/**
	 * 修改售电公司用户密码跳转
	 * @param id
	 * @param mmap
	 * @return
	 */
	//@Log(title = "修改售电公司用户密码", action = "1")
	@ApiOperation(value = "修改售电公司用户密码跳转", notes = "修改售电公司用户密码跳转")
	@GetMapping("/editPwd/{id}")
	public String editPwd(@PathVariable("id") String id, ModelMap mmap)
	{
		mmap.put("ElectricityCompany", electricityCompanyService.selectByPrimaryKey(id));
		return prefix + "/editPwd";
	}

	/**
	 * 修改保存售电公司用户
	 */
	//@Log(title = "修改售电公司用户密码", action = "1")
	@ApiOperation(value = "修改售电公司用户密码", notes = "修改售电公司用户密码")
	@PostMapping("/editPwd")
	@ResponseBody
	public AjaxResult editPwdSave(ElectricityCompany electricityCompany)
	{
		return toAjax(electricityCompanyService.updateElectricityCompanyPassword(electricityCompany));
	}
}
