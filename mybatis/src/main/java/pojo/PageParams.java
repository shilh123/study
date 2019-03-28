/** 
 * Project Name:mybatis 
 * File Name:PageParams.java 
 * Package Name:pojo 
 * Date:2019年3月27日下午1:57:39 
 * Copyright (c) 2019, chenzhou1025@126.com All Rights Reserved. 
 * 
 */

package pojo;

import lombok.Data;

/**
 * ClassName:PageParams <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月27日 下午1:57:39 <br/>
 * 
 * @author Shilh
 * @version
 * @since JDK 1.8
 * @see
 */
@Data
public class PageParams {
	private Integer page;
	private Integer pageSize;
	private Boolean useFlag;
	private Boolean checkFlag;
	private Integer total;
	private Integer totalPage;

}
