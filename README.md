# vueblog
前后端分离的简易博客项目（vue+springboot）
## 一个超简洁的个人博客系统

> 账号: `admin`，密码: `123456` 


### 技术

`前端` : 
* element-ui
* axios
* vue

`后端` : 
* hibernate validatior
* mybatis plus
* springboot
* mysql
* shiro
* redis
* jwt


### 功能
* [x] 登录验证
* [x] 文章展示
* [x] 文章添加
* [x] 文章删除
* [x] 文章修改



#### 本地运行该项目
1. 前端 : 使用npm运行该项目 `npm run serve`

2. 后端 : 
- 使用sql脚本生成对应的数据库
- 配置`application.yml`，
- 修改对应的数据库连接参数，redis的端口号
```
