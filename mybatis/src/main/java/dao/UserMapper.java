/** 
 * Project Name:mybatis 
 * File Name:UserMapper.java 
 * Package Name:dao 
 * Date:2019年3月23日上午11:37:15 
 * Copyright (c) 2019, chenzhou1025@126.com All Rights Reserved. 
 * 
 */

package dao;

import java.util.List;

import pojo.User;

/**
 * ClassName:UserMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月23日 上午11:37:15 <br/>
 * 
 * @author Shilh
 * @version
 * @since JDK 1.8
 * @see
 */

public interface UserMapper {
	public User getUser(Long id);
	
	public List<User> getUserOrders(Long id);
}
