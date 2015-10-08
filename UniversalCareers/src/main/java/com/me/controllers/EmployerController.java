package com.me.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.dao.EmployeeDao;
import com.me.dao.EmployerDao;
import com.me.dao.UserDao;
import com.me.model.Employee;
import com.me.model.Employer;
import com.me.model.User;
import com.me.utils.ChangePassword;
import com.me.utils.UDate;

@Controller
public class EmployerController {
	private static final Logger logger = LoggerFactory.getLogger(EmployerController.class);
	
	@Autowired
	private EmployerDao employerDao;
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value = "/employersignup", method = RequestMethod.GET)
	public String employerSignUp(Model model)
	{
		Employer employer= new Employer();
		model.addAttribute("employer",employer);
		return "employer_layout_signup";
	}
	
	@RequestMapping(value = "/employersignupsubmit", method = RequestMethod.POST)
	public String employerSignUpSubmit(Model model,HttpSession session,Employer employer) throws Exception
	{
		//Check if user already exists
		boolean success=false;
		if(!userDao.queryDuplicateUser(employer.getEmailId()))
		{
			employer.setRole("Employer");
			success=userDao.saveUser(employer);
		}
		else
		{
			model.addAttribute("messageType","failure");
			model.addAttribute("message","Employeer Email Already Present");
			return "base.definition.RegFailed";
		}
		if(success)
		{
			session.setAttribute("employer", employer);
			model.addAttribute("messageType","success");
			model.addAttribute("message","Employee Added Successfully");
			return "employer_layout.Message";
		}
		else
		{
			model.addAttribute("messageType","failure");
			model.addAttribute("message","Employer Addition Failed");
			return "base.definition.RegFailed";
		}
	}
	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public String addemployee(Model model) throws Exception
	{
		Employee employee= new Employee();
		model.addAttribute("employee",employee);
		return "employer_layout.AddEmployee";
	}
	
	@RequestMapping(value = "/addEmployeeSubmit", method = RequestMethod.POST)
	public String addEmployeeSubmit(Model model,Employee employee,HttpSession session) throws Exception
	{
		boolean success=false;
		if(!userDao.queryDuplicateUser(employee.getEmailId()))
		{
			Employer employer=(Employer)session.getAttribute("employer");
			employee.setRole("Employee");
			employee.setDateCreated(new UDate().toString());
			employee.setEmployer(employer);
			employer.setRole("Employer");
			success=userDao.saveUser(employee);
			session.setAttribute("employer",employer);
			if(success)
			{
				model.addAttribute("messageType","success");
				model.addAttribute("message","Employee Added Successfully");
				return "employer_layout.Message";
			}
			else
			{
				model.addAttribute("messageType","failure");
				model.addAttribute("message","Employee Addition Failed");
				return "employer_layout.Message";
			}
		}
		else
		{
			model.addAttribute("messageType","info");
			model.addAttribute("message","User Account Already Present.");
			return "employer_layout.Message";
		}
		
	}
	@RequestMapping(value = "/manageEmployees", method = RequestMethod.GET)
	public String manageEmployees(Model model,Employee employee,HttpSession session) throws Exception
	{
		Employer employer=(Employer)session.getAttribute("employer");
		int id= employer.getId();
		employer=(Employer) userDao.queryUserById(id);
		model.addAttribute("employer",employer);
		return "employer_layout.ManageEmployees";
	}
	
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
	public String manageEmployees(Model model,HttpServletRequest request) throws Exception
	{
		String deleteemployees[]= request.getParameterValues("deleteselected");
		
		if(deleteemployees.length>0)
		{
			boolean success=employerDao.deleteEmployees(deleteemployees);
			if(!success)
			{
				model.addAttribute("messageType","failure");
				model.addAttribute("message","Employee Deletion Failed");
				return "employer_layout.Message";
			}
		}
		Employer employer=(Employer)request.getSession().getAttribute("employer");
		model.addAttribute("employer",employer);
		return "employer_layout.ManageEmployees";
	}
	
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.GET)
	public String updateEmployeeProfile(Model model,HttpServletRequest request)
	{
		String employeeId= request.getParameter("id");
		Employee e=null;
		try
		{
			e= employeeDao.queryEmployeeById(Integer.parseInt(employeeId));
		}
		catch(Exception ex)
		{
			model.addAttribute("messageType","failure");
			model.addAttribute("message","Error Fetching Employee.");
			return "employer_layout.Message";
		}
		
		if(e==null)
		{
			model.addAttribute("messageType","failure");
			model.addAttribute("message","Error Fetching Employee.");
			return "employer_layout.Message";
		}
		model.addAttribute("employee",e);
		return "employer_layout.UpdateEmployee";
	}
	
	@RequestMapping(value = "/updateEmployeeSubmit", method = RequestMethod.POST)
	public String updateEmployeeSubmit(Model model,Employee employee,HttpServletRequest request)
	{
		Employer employer=(Employer) request.getSession().getAttribute("employer");
		employee.setEmployer(employer);
		boolean success=userDao.saveUser(employee);
		if(success)
		{
			model.addAttribute("messageType","success");
			model.addAttribute("message","Employee Updated Successfully");
			return "employer_layout.Message";
		}
		else
		{
			model.addAttribute("messageType","failure");
			model.addAttribute("message","Employee Updation Failed");
			return "employer_layout.Message";
		}
	}
	
	@RequestMapping(value = "/updateEmployerProfile", method = RequestMethod.GET)
	public String updateEmployerProfile(Model model,HttpSession session)
	{	
		
		Employer employer=(Employer)session.getAttribute("employer");
		if(employer==null)
		{
			model.addAttribute("messageType","failure");
			model.addAttribute("message","Employer Not Found!");
			return "employer_layout.Message";	
		}
		model.addAttribute("employer",employer);
		return "employer_layout.UpdateEmployerProfile";
	}
	
	@RequestMapping(value = "/updateEmployerProfileSubmit", method = RequestMethod.POST)
	public String updateEmployerProfileSubmit(Model model,@ModelAttribute("employer") Employer employer,HttpServletRequest request)
	{
		User u=(User)employer;
		boolean success=userDao.saveUser(u);
		if(success)
		{
			model.addAttribute("messageType","success");
			model.addAttribute("message","Employer Updated Successfully");
			return "employer_layout.Message";
		}
		else
		{
			model.addAttribute("messageType","failure");
			model.addAttribute("message","Employee Updation Failed");
			return "employer_layout.Message";
		}
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutEmployer(Model model,HttpServletRequest request)
	{
		request.getSession().invalidate();
		return "base.definition";
	}
	
	@RequestMapping(value = "/employerchangepassword", method = RequestMethod.GET)
	public String employerChangePassword(Model model,HttpServletRequest request) throws Exception {
	
		Employer employer=(Employer)request.getSession().getAttribute("employer");
		int id= employer.getId();
		employer=(Employer) userDao.queryUserById(id);
		request.getSession().setAttribute("employer", "employer");
		ChangePassword ch= new ChangePassword();
		model.addAttribute("changePassword",ch);
		return "employer_layout.ChangePassword";
	}
	
	@RequestMapping(value = "/employerChangePasswordSubmit", method = RequestMethod.POST)
	public String employerChangePasswordSubmit(Model model,ChangePassword ch,HttpServletRequest request) throws Exception {
	
		User user= (User) request.getSession().getAttribute("employer");
		if(user.getPassword().equals(ch.getOldPassword()))
		{
			if(ch.getNewPassword1().equals(ch.getNewPassword2()))
			{
				int id=user.getId();
				user.setPassword(ch.getNewPassword2());
				boolean success=userDao.changeUserPassword(id, ch.getNewPassword2());
				if(success)
				{
					Employer employer= (Employer) userDao.queryUserById(id);
					request.getSession().setAttribute("employer", employer);
					model.addAttribute("messageType","success");
					model.addAttribute("message","Password Changed Successfully");
					return "employer_layout.Message";
				}
				else
				{					
					model.addAttribute("messageType","failure");
					model.addAttribute("message","Failed To Change Password");
					return "employer_layout.Message";
				}
			}
			else
			{
				model.addAttribute("messageType","failure");
				model.addAttribute("message","New Password Doesn't Match Confirm Password.");
				return "employer_layout.Message";
			}
		}
		else
		{
			model.addAttribute("messageType","failure");
			model.addAttribute("message","Old Password Missmatch.");
			return "employer_layout.Message";
		}
	}
}
