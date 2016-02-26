package com.jwd.listeners;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestListener implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		List<Integer> files = new ArrayList<Integer>();
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent event) {
		System.out.println("Request session: " + ((HttpServletRequest) event.getServletRequest()).getSession().getId());
		System.out.println("IP is: " + (event.getServletRequest().getRemoteAddr()));
		System.out.println("Requested type is: " + ((HttpServletRequest) event.getServletRequest()).getMethod());
		System.out.println("Date of creation is: " + new Date().toString());
	}

}
