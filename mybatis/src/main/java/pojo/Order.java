/** 
 * Project Name:mybatis 
 * File Name:Order.java 
 * Package Name:pojo 
 * Date:2019年3月25日上午11:01:46 
 * Copyright (c) 2019, chenzhou1025@126.com All Rights Reserved. 
 * 
 */

package pojo;

import java.util.Date;

import lombok.Data;

/**
 * ClassName:Order <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月25日 上午11:01:46 <br/>
 * 
 * @author Shilh
 * @version
 * @since JDK 1.8
 * @see
 */
@Data
public class Order {

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

	private User user;

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", payment=" + payment + ", paymentType=" + paymentType + ", postFee="
				+ postFee + ", status=" + status + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", paymentTime=" + paymentTime + ", consignTime=" + consignTime + ", endTime=" + endTime
				+ ", closeTime=" + closeTime + ", shippingName=" + shippingName + ", shippingCode=" + shippingCode
				+ ", userId=" + userId + ", buyerMessage=" + buyerMessage + ", buyerNick=" + buyerNick + ", buyerRate="
				+ buyerRate + ", user=" + user + "]";
	}

}
