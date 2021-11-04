package com.tms.common.tool;


import java.io.File;
import java.util.HashMap;
import java.util.Map;


import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;



public class TmsMpGenerator{
  public static void main(String[] args) throws ClassNotFoundException {
	 /**
	  * 待解决问题
	  * 1.生成实体类中pkVal()的修饰符为编译报错;
	  * 2.service层添加了默认实现了对应的接口;
	  */
	create();
	                 
  }

private static void create() {
	/**
	 * 表名
	 */
	String[] tab_name = new String[] {"t_a_account"};
	/**
	 * 表前缀
	 */
	String[] tab_prefix = new String[] {"t_a_"};
	/**
	 * 模块名称
	 */
	String mod =Model.MEMBER.getMod();
	/**
	 * 是否为视图
	 */
	boolean isView = false;
	/**
	 * 是否覆盖service文件
	 */
	boolean fileOverride =true;
	Generator(tab_name, tab_prefix, mod, isView, fileOverride,"wangtao");
	
}
/**
 * 自动生成代码
 * @param tab_name 表名
 * @param tab_prefix 表前缀
 * @param model  模块名称
 * @param isView 是否是视图
 * @param fileOverride 是否覆盖service文件
 * @param author 作者
 */
private static void Generator(String[] tab_name, String[] tab_prefix, String model, boolean isView,
		boolean fileOverride,String author) {
	//1.代码生成器
	AutoGenerator generator = new AutoGenerator();
	//全局配置
	GlobalConfig globalConfig = globalConfig(author);
	generator.setGlobalConfig(globalConfig);
	//2.数据源配置
	DataSourceConfig dataSource = dataSourceConfig();
	generator.setDataSource(dataSource);
	//3.包配置
	PackageConfig packageInfo = packageConfig(model,isView,fileOverride);
	generator.setPackageInfo(packageInfo);
	//4.策略配置
	
	StrategyConfig strategy = strategyConfig(tab_name,tab_prefix);
	generator.setStrategy(strategy);
	generator.execute();
}
/**
 * 全局配置
 * @param author  作者
 * @return
 */
private static GlobalConfig globalConfig(String author) {
	GlobalConfig  globalConfig  = new GlobalConfig();
	globalConfig.setAuthor(author);
	globalConfig.setBaseResultMap(true);
	globalConfig.setFileOverride(true);
	globalConfig.setActiveRecord(true);
	globalConfig.setBaseColumnList(true);
	globalConfig.setSwagger2(true);
	globalConfig.setOutputDir("");
	return globalConfig;
}
/**
 * 数据源配置
 * @return
 */
private static DataSourceConfig dataSourceConfig() {
	DataSourceConfig dsc = new DataSourceConfig();
	dsc.setDriverName("com.mysql.cj.jdbc.Driver");
	dsc.setUrl("jdbc:mysql://106.54.162.159:3308/itour?serverTimezone=UTC");
	dsc.setUsername("root");
	dsc.setPassword("root");
	return dsc;
}
/**
 * 包配置
 * @param model  模块名称
 * @param isView 是否视图
 * @param overflowService 是否覆盖service文件
 * @return
 */
private static PackageConfig packageConfig(String model,boolean isView,boolean overflowService) {
	PackageConfig pc = new PackageConfig();
	String middleName = middleName(model);
	pc.setParent("com.tms");
	pc.setEntity("model."+middleName+(isView==true?"vo":""));
	pc.setMapper(middleName+".persist");
	pc.setServiceImpl(middleName+".service");
	 Map<String, String> pathInfo = new HashMap<>();
	    String java_path ="/src/main/java";
	    String resources_path ="/src/main/resources";
	    String parent="/com/tms/";
	    String entity_path = location()+"/"+prefix(model)+"-model"+java_path+parent+"model/"+middleName+(isView==true?"vo":"");
	    String mapper_path = location()+"/"+mod(model)+"-persist"+java_path+parent+middleName+"/persist";
	    String mapper_xml_path =location()+"/"+mod(model)+"-persist"+resources_path+"/mapping";
	    String serviceImpl_path =location()+"/"+mod(model)+"-service"+java_path+parent+middleName+"/service";
		pathInfo.put(ConstVal.ENTITY_PATH, entity_path );
		pathInfo.put(ConstVal.MAPPER_PATH, mapper_path);
		pathInfo.put(ConstVal.XML_PATH, mapper_xml_path);
		pathInfo.put(ConstVal.SERVICE_PATH, "");
     pathInfo.put(ConstVal.SERVICE_IMPL_PATH, overflowService==true?serviceImpl_path:"");
     pc.setPathInfo(pathInfo);
	return pc;
}
/**
 * 策略配置
 * @param include 表名
 * @param tablePrefix 表前缀
 * @return
 */
private static StrategyConfig strategyConfig(String[]include,String []tablePrefix) {
	StrategyConfig strategy = new StrategyConfig();
	strategy.setInclude(include);//需要生成的表
	strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
	strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库列映射到实体类的命名策略(下划线转驼峰命名)
	strategy.setTablePrefix(tablePrefix);
	
	return strategy;
}
/**
 * 获取项目的路径     
 * @param model 模块名称
 * @return
 */
private static String location() {
	  String outputDir = System.getProperty("user.dir");
	  String location = new File(outputDir).getParent();
	return location;
}
/**
 * 获取模块名前部分(tms-member-service中的tms-member)
 * @param model 模块名称
 * @return
 */
private static String mod(String model) {
	String mod = model.substring(0,model.lastIndexOf("-"));
	return mod;
}
/**
 * 获取模块中间名(tms-member-service中的member)
 * @param model
 * @return
 */
private static String middleName(String model) {
	String suffix = model.substring(model.indexOf("-")+1, model.lastIndexOf("-"));
	return suffix;
}
/**
 * 获取前缀 例如：tms-member-service 返回tms
 * @param model 模块名称
 * @return 
 */
private static String prefix(String model) {
	String prefix = model.substring(0, model.indexOf("-"));
	return prefix;
}


}
enum Model{
MEMBER("tms-member-serice"),
DICTIONARY("tms-dictionary-service");
private String mod;

private Model(String mod) {
	this.mod = mod;
}

public String getMod() {
	return mod;
}

public void setMod(String mod) {
	this.mod = mod;
}
	
}
