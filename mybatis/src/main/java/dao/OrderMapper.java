/** 
 * Project Name:mybatis 
 * File Name:OrderMapper.java 
 * Package Name:dao 
 * Date:2019年3月25日下午3:39:34 
 * Copyright (c) 2019, chenzhou1025@126.com All Rights Reserved. 
 * 
 */

package dao;

import pojo.Order;

/**
 * ClassName:OrderMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月25日 下午3:39:34 <br/>
 * 
 * @author Shilh
 * @version
 * @since JDK 1.8
 * @see
 */

public interface OrderMapper {
	public Order getOrderById(Long id);
}
