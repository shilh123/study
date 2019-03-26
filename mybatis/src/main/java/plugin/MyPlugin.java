package plugin;

import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

@Intercepts({ @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }) })
public class MyPlugin implements Interceptor {
	Properties props = null;
	/**
	 * 代理拦截对象方法的内容
	 * @param invocation责任链对象
	 */
	public Object intercept(Invocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		System.err.println("before......");
		// 如果当前代理是一个非代理对象,那么他就回调真是拦截对象的方法,如果不是它,会调用下个插件代理对象的invoke方法
		Object obj = invocation.proceed();
		System.err.println("after......");
		return obj;
	}

	/**
	 * 生成对象的代理,这里常用mybatis 提供的plugin类的wrap方法
	 * @param target 被代理的对象
	 */
	public Object plugin(Object target) {
		// TODO Auto-generated method stub
		System.err.println("调用生成代理对象......");

		return Plugin.wrap(target, this);
	}

	/**
	 * 获取插件配置属性,在mybatis配置文件中配置
	 * @param properties 是mybaits配置参数
	 */
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub
		System.err.println(properties.get("dbType"));
		this.props = properties;
	}

}
