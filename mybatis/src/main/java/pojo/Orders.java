/** 
 * Project Name:mybatis 
 * File Name:Orders.java 
 * Package Name:pojo 
 * Date:2019年3月25日下午4:49:59 
 * Copyright (c) 2019, chenzhou1025@126.com All Rights Reserved. 
 * 
 */

package pojo;

import java.util.Date;

import lombok.Data;

/**
 * ClassName:Orders <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月25日 下午4:49:59 <br/>
 * 
 * @author Shilh
 * @version
 * @since JDK 1.8
 * @see
 */
@Data
public class Orders {
	private String orderId;
	private String payment;
	private int paymentType;
	private char postFee;
	private int status;
	private Date createTime;
	private Date updateTime;
	private Date paymentTime;
	private Date consignTime;
	private Date endTime;
	private Date closeTime;
	private String shippingName;
	private String shippingCode;
	private long userId;
	private String buyerMessage;
	private String buyerNick;
	private int buyerRate;

}
