package top.hcode.blog;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;

/**
 * @Author: Himit_ZH
 * @Date: 2020/7/19 21:07
 * @Description:
 */
public class HcodeAutoCode {


    public static void main(String[] args) {
        // 需要构建一个 代码自动生成器 对象
        AutoGenerator mpg = new AutoGenerator();
        // 配置策略
        // 1、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");

        gc.setOutputDir(projectPath + "/src/main/java"); //设置生成路径
        gc.setAuthor("Himit_ZH");
        gc.setOpen(false); //一般false，就是打开一下文件夹而已
        gc.setFileOverride(false); // 是否覆盖
        gc.setServiceName("%sService"); // 去Service的I前缀
        gc.setIdType(IdType.ID_WORKER); //设置主键策略
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        //2、设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://129.204.177.72:3306/blog?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("Hzh&hy2020");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);
        //3、包的配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("blog");  //最后会在/src/main/java/blog 开始创建对应层的文件夹
        pc.setParent("top.hcode");
        pc.setEntity("entity"); //生成实体类pojo
        pc.setMapper("mapper"); //生成mapper dao层
        pc.setService("service"); //生成service
        pc.setController("controller"); //生成controller层
        mpg.setPackageInfo(pc);
        //4、策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 设置要映射的表名 会自动生成pojo和mapper
        strategy.setInclude("m_blog", "m_user");
        strategy.setNaming(NamingStrategy.underline_to_camel); //设置命名格式
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true); // 自动lombok；

        strategy.setLogicDeleteFieldName("deleted"); //配置逻辑删除的字段名

        // 自动填充配置 自动填充创建时间和更新时间
        TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
        TableFill gmtModified = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);

        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);
        strategy.setTableFillList(tableFills);


        //增加控制层的路径
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);
        // localhost:8080/hello_id_2
        mpg.setStrategy(strategy);
        mpg.execute(); //执行
    }
}