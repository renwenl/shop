package com.fh.shop.backend.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class WebUtil {

	private static  ThreadLocal<HttpServletRequest> requestContainer = new ThreadLocal<HttpServletRequest>();
	private static  ThreadLocal<HttpServletResponse> responseContainer = new ThreadLocal<>();
	
	public static void put(HttpServletRequest req, HttpServletResponse res) {
		requestContainer.set(req);
		responseContainer.set(res);
	}
	
	public static HttpServletRequest getRequest() {
		return requestContainer.get();
	}
	
	public static HttpServletResponse getResponse() {
		return responseContainer.get();
	}
	
	public static void remove() {
		requestContainer.remove();
		responseContainer.remove();
	}
	
}
