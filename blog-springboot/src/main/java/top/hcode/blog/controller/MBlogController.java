package top.hcode.blog.controller;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.hcode.blog.common.results.CommonResult;
import top.hcode.blog.entity.MBlog;
import top.hcode.blog.service.MBlogService;
import top.hcode.blog.util.ShiroUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Himit_ZH
 * @since 2020-07-19
 */
@RestController
@RequestMapping
public class MBlogController {
    @Autowired
    MBlogService blogService;
    @GetMapping("/blogs")
    public CommonResult blogs(Integer currentPage) {
        if(currentPage == null || currentPage < 1) currentPage = 1;
        Page page = new Page(currentPage, 5);
        IPage pageData = blogService.page(page, new QueryWrapper<MBlog>().orderByDesc("gmt_create"));
        return CommonResult.successResponse(pageData,"获取成功");
    }

    @GetMapping("/blog/{id}")
    public CommonResult detail(@PathVariable(name = "id") Long id) {
        MBlog blog = blogService.getById(id);
        Assert.notNull(blog, "该博文已删除！");
        return CommonResult.successResponse(blog,"查询成功");
    }

    @RequiresAuthentication
    @PostMapping("/blog/edit")
    public CommonResult edit(@Validated @RequestBody MBlog blog) {
        MBlog temp = null;
        if(blog.getId() != null) {
            temp = blogService.getById(blog.getId());
            Assert.isTrue(temp.getUserId().longValue() == ShiroUtil.getProfile().getId().longValue(), "没有权限编辑");
        } else {
            temp = new MBlog();
            temp.setUserId(ShiroUtil.getProfile().getId());
            temp.setGmtCreate(LocalDateTime.now());
            temp.setStatus(0);
        }
        BeanUtil.copyProperties(blog, temp, "id", "userId", "gmtCreate", "status");
        blogService.saveOrUpdate(temp);
        return CommonResult.successResponse( null,"操作成功");
    }

    @RequiresAuthentication
    @GetMapping("/blog/delete/{id}")
    public CommonResult delete(@PathVariable(name = "id") Long id) {
        boolean result = blogService.removeById(id);
        Assert.isTrue(result, "删除失败！该博文不存在！");
        return CommonResult.successResponse( null,"删除成功");
    }
}