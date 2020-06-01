package com.mobileShop;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Mybatis 逆向工程
 */
public class GeneratorSqlUsermap
{
	public void generator() throws Exception
	{
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;

		// 指定配置文件
		File configFile = new File("C:\\code_new\\mobileShop\\mybatis-generator\\src\\main\\resources\\generatorConfigUser.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
	}

	// 执行main方法以生成代码
	public static void main(String[] args)
	{
		try
		{
			GeneratorSqlUsermap generatorSqlmap = new GeneratorSqlUsermap();
			generatorSqlmap.generator();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
