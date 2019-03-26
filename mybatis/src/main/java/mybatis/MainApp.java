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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import bean.UserBean;
import dao.OrderMapper;
import dao.UserMapper;
import pojo.User;
import util.Md5Owner;

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
//		System.out.println(userMapper.getUserOrders(7l));
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		UserBean userBean = new UserBean();
//		user.setCreated(ft.format(date));
		Random random = new Random();
		int nextInt = random.nextInt();
		userBean.setEmail("shilh123@sina.cn" + nextInt);
//		user.setOrders(orders);
		userBean.setPassword(Md5Owner.md5("123456"));
		userBean.setPhone("18932900682" + nextInt);
		userBean.setUserName("shilh" + nextInt);
		userBean.setCreated(date);
		userBean.setUpdated(date);
		System.out.println(userBean);
		userMapper.addUser(userBean);
//		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

//		System.out.println(orderMapper.getOrderById(1l));

	}

	public void name() {

	}

}
