/** 
 * Project Name:mybatis 
 * File Name:User.java 
 * Package Name:pojo 
 * Date:2019年3月23日上午11:38:38 
 * Copyright (c) 2019, chenzhou1025@126.com All Rights Reserved. 
 * 
 */

package pojo;

import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * ClassName:User <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月23日 上午11:38:38 <br/>
 * 
 * @author Shilh
 * @version
 * @since JDK 1.8
 * @see
 */
@Data
public class User {
	private Long id;
	private String userName;
	private String password;
	private String phone;
	private String email;
	private Date created;
	private Date updated;
	private List<Orders> orders;

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", phone=" + phone + ", email="
				+ email + ", created=" + created + ", updated=" + updated + ", orders=" + orders + "]";
	}

}
