/** 
 * Project Name:consumer 
 * File Name:TestConsumer.java 
 * Package Name:consumer 
 * Date:2019年3月23日上午10:51:15 
 * Copyright (c) 2019, chenzhou1025@126.com All Rights Reserved. 
 * 
 */

package consumer;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.leablogs.api.ServiceApi;

/**
 * ClassName:TestConsumer <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月23日 上午10:51:15 <br/>
 * 
 * @author Shilh
 * @version
 * @since JDK 1.8
 * @see
 */

public class TestConsumer {

	@Test
	public void test() {
//		fail("Not yet implemented");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:springmvc.xml" });
		context.start();
		ServiceApi service = (ServiceApi) context.getBean("Service");

		System.out.println(service.sayHello("hello , my frist dubbo demo"));
		try {
			System.in.read();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
