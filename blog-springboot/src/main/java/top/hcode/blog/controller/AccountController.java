package top.hcode.blog.controller;

import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.hcode.blog.common.dto.LoginDto;
import top.hcode.blog.common.results.CommonResult;
import top.hcode.blog.entity.MUser;
import top.hcode.blog.service.MUserService;
import top.hcode.blog.util.JwtUtils;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Himit_ZH
 * @Date: 2020/7/20 00:25
 * @Description:
 */
@RestController
public class AccountController {

    @Autowired
    MUserService userService;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public CommonResult login(@Validated @RequestBody LoginDto loginDto, HttpServletResponse response){
        QueryWrapper<MUser> wrapper = new QueryWrapper<MUser>().eq("username", loginDto.getUsername());
        MUser user = userService.getOne(wrapper);
        Assert.notNull(user,"用户不存在");
        if (user.getPassword().equals(SecureUtil.md5(loginDto.getPassword()))){
            return CommonResult.errorResponse("密码不正确");
        }
        String jwt = jwtUtils.generateToken(user.getId());
        response.setHeader("Authorization", jwt); //放到信息头部
        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        // 用户可以另一个接口
        return CommonResult.successResponse(MapUtil.builder()
                .put("id", user.getId())
                .put("username", user.getUsername())
                .put("avatar", user.getAvatar())
                .put("email", user.getEmail())
                .map(),"登录成功"
        );
    }

    // 退出
    @GetMapping("/logout")
    @RequiresAuthentication
    public CommonResult logout() {
        SecurityUtils.getSubject().logout();
        return CommonResult.successResponse(null,"退出成功");

    }

}