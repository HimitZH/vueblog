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

### 截图
#### 注册
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201105233304550.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80Mzg1MzA5Nw==,size_16,color_FFFFFF,t_70#pic_center)

#### 登录
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201105233224426.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80Mzg1MzA5Nw==,size_16,color_FFFFFF,t_70#pic_center)

#### 个人博文页
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201105233136259.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80Mzg1MzA5Nw==,size_16,color_FFFFFF,t_70#pic_center)

#### 博客主页
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201105232808241.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80Mzg1MzA5Nw==,size_16,color_FFFFFF,t_70#pic_center)

#### 文章内容
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020110523291389.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80Mzg1MzA5Nw==,size_16,color_FFFFFF,t_70#pic_center)

#### 编辑或发表
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020110523291389.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80Mzg1MzA5Nw==,size_16,color_FFFFFF,t_70#pic_center)



### 功能
* [x] 登录验证
* [x] 注册验证
* [x] 文章展示
* [x] 文章添加
* [x] 文章删除
* [x] 文章修改



#### 本地运行该项目
1. 前端 : 进入blog-vue，打开cmd窗口，使用npm运行该项目 `npm run serve`

2. 后端 : 
- 使用sql脚本生成对应的数据库
- 用java的idea打开blog-springboot
- 配置`application.yml`，
- 修改对应的数据库连接参数，redis的端口号
```
