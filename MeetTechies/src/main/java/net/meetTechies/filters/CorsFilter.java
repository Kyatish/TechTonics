/*package net.meetTechies.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
//import org.springframework.stereotype.Component;


@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter extends OncePerRequestFilter  {

	private static final Logger LOGGER = LoggerFactory.getLogger(CorsFilter.class);
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doFilterInternal(ServletRequest rqst, ServletResponse rsp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest requestToUse = (HttpServletRequest) rqst;
		HttpServletResponse responseToUse = (HttpServletResponse) rsp;
		String method = requestToUse.getMethod();
		System.out.println("User Requests: "+method);
		//System.out.println("User Requests: "+requestToUse.getContentType());
		
		responseToUse.addHeader("Access-Control-Allow-Origin", requestToUse.getHeader("Origin"));
		chain.doFilter(requestToUse, responseToUse);
		responseToUse.setHeader("Access-Control-Allow-Origin", requestToUse.getHeader("Origin"));
		responseToUse.setHeader("Access-Control-Allow-Methods",
				"POST,GET,OPTIONS,DELETE");
		responseToUse.setHeader("Access-Control-Max-Age", Long.toString(60 * 60));
		responseToUse.setHeader("Access-Control-Allow-Credentials", "true");
		responseToUse.setHeader(
				"Access-Control-Allow-Headers",
				"Origin,Accept,X-Requested-With,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization");
		if ("OPTIONS".equals(method)) {
			responseToUse.setStatus(HttpStatus.OK.value());
		}
		else {
			chain.doFilter(rqst, rsp);
		}

	}

	@Override
	public void doInit(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	LOGGER.info("Initializing CorsFilter object");
	}

	@Override
	protected void doFilterInternal(HttpServletRequest rqst,
			HttpServletResponse rsp, FilterChain chain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpServletRequest requestToUse = (HttpServletRequest) rqst;
		HttpServletResponse responseToUse = (HttpServletResponse) rsp;
		String method = requestToUse.getMethod();
		System.out.println("User Requests: "+method);
		//System.out.println("User Requests: "+requestToUse.getContentType());
		
		responseToUse.addHeader("Access-Control-Allow-Origin", requestToUse.getHeader("Origin"));
		chain.doFilter(requestToUse, responseToUse);
		responseToUse.setHeader("Access-Control-Allow-Origin", requestToUse.getHeader("Origin"));
		responseToUse.setHeader("Access-Control-Allow-Methods",
				"POST,GET,OPTIONS,DELETE");
		responseToUse.setHeader("Access-Control-Max-Age", Long.toString(60 * 60));
		responseToUse.setHeader("Access-Control-Allow-Credentials", "true");
		responseToUse.setHeader(
				"Access-Control-Allow-Headers",
				"Origin,Accept,X-Requested-With,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization");
		if ("OPTIONS".equals(method)) {
			responseToUse.setStatus(HttpStatus.OK.value());
		}
		else {
			chain.doFilter(rqst, rsp);
		}
	}
}*/