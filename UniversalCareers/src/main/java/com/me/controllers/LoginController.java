package com.me.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.dao.EmployerDao;
import com.me.dao.HibernateUtil;
import com.me.dao.UserDao;
import com.me.model.Applicant;
import com.me.model.Employee;
import com.me.model.Employer;
import com.me.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private EmployerDao employerDao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "base.definition";
	}
	@RequestMapping(value = "/loginsubmit", method = RequestMethod.POST)
	public String loginsubmit(Model model,HttpServletRequest request) throws Exception {
		String userType=request.getParameter("userType");
		String emailid=request.getParameter("emailid");
		String password=request.getParameter("password");
		if(userType.equalsIgnoreCase("employer"))
		{
			Employer employer=employerDao.queryEmployerByNameAndPassword(emailid, password);
			if(employer==null)
			{
				return "base.definition.Logout";
			}
			model.addAttribute("employer",employer);
			request.getSession().setAttribute("employer", employer);
			return "employer_layout.ManageEmployees";
		}
		else if(userType.equalsIgnoreCase("applicant"))
		{
			Applicant applicant=(Applicant)userDao.queryUserByNameAndPassword(emailid, password);
			if(applicant==null)
			{
				return "base.definition.Logout";
			}
			model.addAttribute("applicant",applicant);
			request.getSession().setAttribute("applicant", applicant);
			return "applicant_layout";
		}
		else if(userType.equalsIgnoreCase("employee"))
		{
			Employee employee=(Employee)userDao.queryUserByNameAndPassword(emailid, password);
			if(employee!=null)
			{
				if(employee.getDepartment().equalsIgnoreCase("hr"))
				{
					model.addAttribute("hr",employee);
					request.getSession().setAttribute("hr", employee);
					return "hr_layout";
				}
			}
			else
			{
				return "base.definition.Logout";	
			}
		}
		return "base.definition";
	}
	@RequestMapping(value = "/invalidLogin", method = RequestMethod.GET)
	public String invalidLogin(Model model,HttpServletRequest request) throws Exception {
		return "base.definition.Logout";
	}
}
