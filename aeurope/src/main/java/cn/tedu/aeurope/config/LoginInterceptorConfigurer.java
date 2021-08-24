package cn.tedu.aeurope.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import cn.tedu.aeurope.interceptor.LoginInterceptor;

@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		HandlerInterceptor interceptor = new LoginInterceptor();
		List<String> excludePath = new ArrayList<>();
		excludePath.add("/images/**");
		excludePath.add("/dist/**");
		excludePath.add("/plugins/**");
		excludePath.add("/webs/head.js");
		excludePath.add("/webs/foot.js");
		
		excludePath.add("/webs/europe-homepage.html");
		excludePath.add("/webs/europe-map.html");
		excludePath.add("/webs/login.html");
		excludePath.add("/webs/reg.html");
		excludePath.add("/webs/about-faq.html");
		excludePath.add("/webs/contact.html");
		excludePath.add("/webs/route.html");
		excludePath.add("/webs/forgot-password.html");

		excludePath.add("/clients/regist");
		excludePath.add("/clients/login");
		excludePath.add("/about_faq/**");
		excludePath.add("/routes/**");
		excludePath.add("/send_mail/**");
		excludePath.add("/forgotps/**");
		excludePath.add("/auth/**");

		
		registry.addInterceptor(interceptor)
				.addPathPatterns("/**")  //黑名單
				.excludePathPatterns(excludePath);//白名單列表
		
	}
}
