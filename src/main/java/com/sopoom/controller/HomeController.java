package com.sopoom.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	String url ="jdbc:mariadb://localhost:3306/sw_miniproject?user=root&password=0000";
	
	@RequestMapping(value = "/NewFile", method = RequestMethod.GET)
	   public void localPath() {}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		try {
	         // Class.forName("org.mariadb.jdbc.Driver"); 주석처리 가능 
	         // 자동으로 JDBC드라이버를 호출함(현재 버전2.6.2, 최소 지원 버전은 잘 모르겠음)
	         Connection connection = DriverManager.getConnection(url);
	         System.out.println("### connection : " +  connection + " - 연결 성공 ####");
	      }catch (SQLException e) {
	         e.printStackTrace();
	      }

		return "home";
	}

}
