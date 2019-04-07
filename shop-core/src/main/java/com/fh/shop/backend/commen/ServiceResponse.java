/** 
 * <pre>项目名称:shop-admin-rwl 
 * 文件名称:ServiceResponse.java 
 * 包名:com.fh.shop.backend.common 
 * 创建日期:2019年1月15日上午8:59:51 
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre> 
 */  
package com.fh.shop.backend.commen;

import java.io.Serializable;

/** 
 * <pre>项目名称：shop-admin-rwl    
 * 类名称：ServiceResponse    
 * 类描述：    
 * 创建人：任文龙     
 * 创建时间：2019年1月15日 上午8:59:51    
 * 修改人：任文龙      
 * 修改时间：2019年1月15日 上午8:59:51    
 * 修改备注：       
 * @version </pre>    
 */
public class ServiceResponse implements Serializable{

	private static final long serialVersionUID = 4639975393092300317L;
	
	private Integer code;
	
	private String message;
	
	private Object data;

	
	
	public static ServiceResponse success(){
		return new ServiceResponse(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMessage(),null);
	}

	public static ServiceResponse success (Object data) {
		return new ServiceResponse(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMessage(),data);
	}
	
	public static ServiceResponse error(ResponseEnum responseEnum){
		return new ServiceResponse(responseEnum.getCode(),responseEnum.getMessage(),null);
	}
	
	public static ServiceResponse error(){
		return new ServiceResponse(ResponseEnum.ERROR_SYSTEM_IS_WRONG.getCode(),ResponseEnum.ERROR_SYSTEM_IS_WRONG.getMessage(),null);
	}
	
	private ServiceResponse(){}
	
	private ServiceResponse(Integer code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}
	

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public Object getData() {
		return data;
	}

	
	
	
	
	
	
}
