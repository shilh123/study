/** 
 * Project Name:mybatis 
 * File Name:MainApp.java 
 * Package Name:mybatis 
 * Date:2019年3月23日上午11:38:04 
 * Copyright (c) 2019, chenzhou1025@126.com All Rights Reserved. 
 * 
 */

package mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dao.OrderMapper;
import dao.UserMapper;

/**
 * ClassName:MainApp <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月23日 上午11:38:04 <br/>
 * 
 * @author Shilh
 * @version
 * @since JDK 1.8
 * @see
 */

public class MainApp {
	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession(true);

		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		System.out.println(System.currentTimeMillis());
		System.out.println(userMapper.getUserOrders(7l));
		System.out.println(System.currentTimeMillis());

		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

//		System.out.println(orderMapper.getOrderById(1l));

	}

	public void name() {
		
	}

}
