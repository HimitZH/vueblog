package top.hcode.blog.controller;


import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import top.hcode.blog.common.results.CommonResult;
import top.hcode.blog.entity.MUser;
import top.hcode.blog.service.MUserService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Himit_ZH
 * @since 2020-07-19
 */
@RestController
@RequestMapping("/blog/user")
public class MUserController {

    @Autowired
    private MUserService mUserService;

    @RequiresAuthentication //需要登录认证才能访问
    @GetMapping("/index")
    public Object test(){
        MUser user = mUserService.getById(1L);
        return CommonResult.successResponse(user, "操作成功");
    }


}
