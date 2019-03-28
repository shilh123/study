/** 
 * Project Name:mybatis 
 * File Name:Pagination.java 
 * Package Name:plugin 
 * Date:2019年3月27日下午1:57:21 
 * Copyright (c) 2019, chenzhou1025@126.com All Rights Reserved. 
 * 
 */

package plugin;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

/**
 * ClassName:Pagination <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月27日 下午1:57:21 <br/>
 * 
 * @author Shilh
 * @version
 * @since JDK 1.8
 * @see
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class Pagination implements Interceptor {
	Properties props = null;
	private Integer defalutPage;
	private Integer defalutPageSize;
	private Boolean defalutUseFlag;
	private Boolean defalutEcheckFlag;

	public Object intercept(Invocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		System.err.println("before......");
		// 如果当前代理是一个非代理对象,那么他就回调真是拦截对象的方法,如果不是它,会调用下个插件代理对象的invoke方法
		Object obj = invocation.proceed();
		System.err.println("after......");
		return obj;
	}

	public Object plugin(Object target) {
		// TODO Auto-generated method stub
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub
//		System.err.println(properties.get("TestPage"));
//		this.props = properties;
		String strDefaultPage = properties.getProperty("default.page", "1");
		String strDefalutPageSize = properties.getProperty("default.pageSize", "50");
		String strDefalutUseFlag = properties.getProperty("default.useFlag", "false");
		String strDefalutEcheckFlag = properties.getProperty("default.checkFlag", "false");
		this.defalutEcheckFlag = Boolean.parseBoolean(strDefalutUseFlag);
		this.defalutPage = Integer.parseInt(strDefaultPage);
		this.defalutPageSize = Integer.parseInt(strDefalutPageSize);
		this.defalutUseFlag = Boolean.parseBoolean(strDefaultPage);
	}

}
