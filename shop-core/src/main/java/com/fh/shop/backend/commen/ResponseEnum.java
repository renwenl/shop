/** 
 * <pre>项目名称:shop-admin-rwl 
 * 文件名称:ResponseEnum.java 
 * 包名:com.fh.shop.backend.common 
 * 创建日期:2019年1月15日上午10:30:44 
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre> 
 */  
package com.fh.shop.backend.commen;

/** 
 * <pre>项目名称：shop-admin-rwl    
 * 类名称：ResponseEnum    
 * 类描述：    
 * 创建人：任文龙     
 * 创建时间：2019年1月15日 上午10:30:44    
 * 修改人：任文龙      
 * 修改时间：2019年1月15日 上午10:30:44    
 * 修改备注：       
 * @version </pre>    
 */
public enum ResponseEnum {

	ERROR_UPLOAD_FILE(6000,"上传文件失败"),

	ERROR_ACCOUNT_IS_LOCK(1004,"账号已被锁定"),

	ERROR_IMGCODE_IS_WONG(1003,"验证码错误"),

	ERROR_PASSWORD_IS_WRONG(1002,"密码错误"),
	
	ERROR_USERNAME_IS_WRONG(1001,"账号错误"),
	
	ERROR_USERNAME_OR_PASSWORD_OR_IMGCODE_IS_EMPTY(1000,"账号或密码或验证码为空"),
	
	ERROR_SYSTEM_IS_WRONG(-1,"系统错误"),
	
	SUCCESS(200,"成功"),

	ERROR_USERNAME_IS_NOT_EXSITS(204,"账号已存在");

	
	private Integer code;
	
	private String message;
	

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	   
	/**    
	 * <pre>创建一个新的实例 ResponseEnum.    
	 *    
	 * @param code
	 * @param message
	 */
	private ResponseEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	
	
}
