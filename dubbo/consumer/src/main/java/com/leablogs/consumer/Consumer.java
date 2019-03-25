/** 
 * Project Name:consumer 
 * File Name:Consumer.java 
 * Package Name:com.leablogs.consumer 
 * Date:2019年3月23日上午10:42:52 
 * Copyright (c) 2019, chenzhou1025@126.com All Rights Reserved. 
 * 
 */

package com.leablogs.consumer;

import org.springframework.core.io.Resource;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.leablogs.api.ServiceApi;

/**
 * ClassName:Consumer <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月23日 上午10:42:52 <br/>
 * 
 * @author Shilh
 * @version
 * @since JDK 1.8
 * @see
 */

public class Consumer {
	public static void main(String[] args) {
		//
		ApplicationConfig applicationConfig = new ApplicationConfig();
		applicationConfig.setName("consumer");
		// 链接注册中心
		RegistryConfig registryConfig = new RegistryConfig();
		registryConfig.setAddress("");
		registryConfig.setUsername("");
		registryConfig.setPassword("");

		// 引用远程服务
		ReferenceConfig<ServiceApi> referenceConfig = new ReferenceConfig<ServiceApi>();
		referenceConfig.setApplication(applicationConfig);
		referenceConfig.setRegistry(registryConfig);
		referenceConfig.setInterface(ServiceApi.class);
		referenceConfig.setVersion("1.0.0");

		ServiceApi service = referenceConfig.get();

	}
}
