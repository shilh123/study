/** 
 * Project Name:mybatis 
 * File Name:Demo1.java 
 * Package Name:reflect 
 * Date:2019年3月26日上午10:54:54 
 * Copyright (c) 2019, chenzhou1025@126.com All Rights Reserved. 
 * 
 */

package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ClassName:Demo1 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月26日 上午10:54:54 <br/>
 * 
 * @author Shilh
 * @version
 * @since JDK 1.8
 * @see
 */

public class ReflectDemo {
	public void sayHello(String name) {
		System.out.println("hello" + name);
	}

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Object serviceObject = Class.forName(ReflectDemo.class.getName());
		Method method = serviceObject.getClass().getMethod("sayHello", String.class);
		method.invoke(serviceObject, "zhangsan");
	}

}
