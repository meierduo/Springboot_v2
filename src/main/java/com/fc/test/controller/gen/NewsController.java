package com.fc.test.controller.gen;

import com.fc.test.model.auto.TsysFileData;
import com.fc.test.util.DateUtils;
import com.fc.test.util.HtmlText;
import com.fc.test.util.SnowflakeIdWorker;
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
import com.fc.test.model.auto.News;
import com.fc.test.model.custom.TableSplitResult;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.model.custom.TitleVo;
import com.fc.test.service.NewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "新闻列表")
@Controller
@RequestMapping("/NewsController")
public class NewsController extends BaseController{
	
	private String prefix = "gen/news";
	@Autowired
	private NewsService newsService;
	
	/**
	 * 分页跳转
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:news:view")
    public String view(ModelMap model)
    {	
		String str="新闻列表";
		setTitle(model, new TitleVo("列表", str+"管理", true,"欢迎进入"+str+"页面", true, false));
        return prefix + "/list";
    }
	
	/**
	 * 分页查询
	 */
	//@Log(title = "新闻列表集合查询", action = "111")
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@PostMapping("/list")
	@RequiresPermissions("gen:news:list")
	@ResponseBody
	public Object list(Tablepar tablepar,String searchText){
		PageInfo<News> page=newsService.list(tablepar,searchText) ; 
		TableSplitResult<News> result=new TableSplitResult<News>(page.getPageNum(), page.getTotal(), page.getList()); 
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
	//@Log(title = "新闻列表新增", action = "111")
   	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:news:add")
	@ResponseBody
	public AjaxResult add(News news){
		news.setIsshow("1");
		news.setIstop("1");
		news.setIsdelete("0");
		news.setIsindex("1");
		news.setTextinfo(HtmlText.delHTMLTag(news.getContent()));
   		news.setCreateTime(DateUtils.getNowDate());
   		news.setUpdateTime(DateUtils.getNowDate());
		
   		int b=newsService.insertSelective(news);
		 
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
	//@Log(title = "新闻列表删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@PostMapping("/remove")
	@RequiresPermissions("gen:news:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=newsService.deleteByPrimaryKey(ids);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * 检查Name
	 * @param news
	 * @return
	 */
	@ApiOperation(value = "检查Name唯一", notes = "检查Name唯一")
	@PostMapping("/checkNameUnique")
	@ResponseBody
	public int checkNameUnique(News news){
		int b=newsService.checkNameUnique(news);
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
        mmap.put("News", newsService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }

	/**
	 * 修改状态
	 * @param id
	 * @param state
	 * @return
	 */
	//@Log(title = "新闻列表状态修改", action = "111")
	@ApiOperation(value = "修改状态", notes = "修改状态")
	@PostMapping("/updateState")
	@ResponseBody
	public AjaxResult updateState(Integer id, boolean state)
	{
		int b=newsService.updateStateByPrimaryKey(id, state);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}

	/**
	 * 修改是否置顶
	 * @param id
	 * @param state
	 * @return
	 */
	//@Log(title = "新闻是否置顶", action = "111")
	@ApiOperation(value = "修改是否置顶", notes = "修改是否置顶")
	@PostMapping("/updateTop")
	@ResponseBody
	public AjaxResult updateTop(Integer id, boolean state)
	{
		int b=newsService.updateTopByPrimaryKey(id, state);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}

	/**
	 * 修改是否在首页
	 * @param id
	 * @param state
	 * @return
	 */
	//@Log(title = "新闻修改是否在首页", action = "111")
	@ApiOperation(value = "修改是否在首页", notes = "修改是否在首页")
	@PostMapping("/updateIndex")
	@ResponseBody
	public AjaxResult updateIndex(Integer id, boolean state)
	{
		int b=newsService.updateIndexByPrimaryKey(id, state);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
     * 修改保存
     */
    //@Log(title = "新闻列表修改", action = "111")
    @ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:news:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(News record)
    {
        return toAjax(newsService.updateByPrimaryKeySelective(record));
    }

    
    /**
   	 * 根据主键查询
   	 * 
   	 * @param id
   	 * @return
   	 */
   	@ApiOperation(value = "根据id查询唯一", notes = "根据id查询唯一")
   	@PostMapping("/get/{id}")
   	public News edit(@PathVariable("id") String id) {
   		return newsService.selectByPrimaryKey(id);
   	}
    

	
}
