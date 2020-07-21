package top.hcode.blog.util;

import org.apache.shiro.SecurityUtils;
import top.hcode.blog.shiro.AccountProfile;

/**
 * @Author: Himit_ZH
 * @Date: 2020/7/20 14:13
 * @Description:
 */
public class ShiroUtil {
    public static AccountProfile getProfile(){
        return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
    }
}