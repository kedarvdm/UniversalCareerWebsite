package com.me.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.hibernate.validator.cfg.defs.EmailDef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.dao.HRDao;
import com.me.dao.UserDao;
import com.me.model.Applicant;
import com.me.model.Employee;
import com.me.model.JobDetails;
import com.me.model.User;
import com.me.utils.ChangePassword;
import com.me.utils.EmailDetails;
import com.me.utils.EmailUtils;

@Controller
public class HRController {
	
	@Autowired
	private HRDao hrDao;
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value = "/hrpostJob", method = RequestMethod.GET)
	public String hrpostJob(Model model) {
		JobDetails job= new JobDetails();
		model.addAttribute("job",job);
		return "hr_layout.PostJob";
	}
	
	@RequestMapping(value = "/hrpostJobSubmit", method = RequestMethod.POST)
	public String hrpostJobSubmit(Model model,JobDetails job, HttpSession session) throws Exception {
		Employee hr=(Employee) session.getAttribute("hr");
		int id= hr.getId();
		job.setUser(hr);
		job.setEmployer(hr.getEmployer());
		boolean success= hrDao.saveJobDetail(job);
		hr=(Employee)userDao.queryUserById(id);
		session.setAttribute("hr", hr);
		if(success)
		{
			model.addAttribute("messageType","success");
			model.addAttribute("message","Job Added Successfully");
			return "hr_layout.Message";
		}
		else
		{
			model.addAttribute("messageType","failure");
			model.addAttribute("message","Job Addition Failed");
			return "hr_layout.Message";
		}
	}
	
	@RequestMapping(value = "/hrprofile", method = RequestMethod.GET)
	public String hrprofile(Model model,HttpSession session) throws Exception {
		Employee hr=(Employee) session.getAttribute("hr");
		model.addAttribute("employee",hr);
		return "hr_layout.HRProfile";
	}
	
	@RequestMapping(value = "/updatehrsubmit", method = RequestMethod.POST)
	public String hrProfileSubmit(Model model,HttpSession session, Employee employee) throws Exception {
		Employee hr=(Employee) session.getAttribute("hr");
		employee.setEmployer(hr.getEmployer());
		int id= hr.getId();
		User u=(User)employee;
		boolean success=userDao.saveUser(u);
		hr=(Employee)userDao.queryUserById(id);
		session.setAttribute("hr", hr);
		if(success)
		{
			model.addAttribute("messageType","success");
			model.addAttribute("message","Profile Updated Successfully");
			return "hr_layout.Message";
		}
		else
		{
			model.addAttribute("messageType","failure");
			model.addAttribute("message","Profile Updation Failed");
			return "hr_layout.Message";
		}
	}
	
	@RequestMapping(value = "/hrviewJobs", method = RequestMethod.GET)
	public String hrviewJobs(Model model,HttpSession session) throws Exception {
		Employee hr=(Employee) session.getAttribute("hr");
		ArrayList<JobDetails> jobs=hrDao.getAllJobs(hr);
		model.addAttribute("jobs",jobs);
		return "hr_layout.ViewJobs";
	}
	
	@RequestMapping(value = "/updatejob", method = RequestMethod.GET)
	public String hrupdateJob(Model model,HttpServletRequest request) throws Exception
	{
		int id=Integer.parseInt(request.getParameter("id"));
		JobDetails job= hrDao.getJob(id);
		model.addAttribute("job",job);
		return "hr_layout.UpdateJob";
	}
	
	@RequestMapping(value = "/updateJobSubmit", method = RequestMethod.POST)
	public String updateJobSubmit(Model model,JobDetails job,HttpSession session) throws Exception
	{
		Employee hr=(Employee) session.getAttribute("hr");
		int id= hr.getId();
		job.setUser(hr);
		job.setEmployer(hr.getEmployer());
		boolean success= hrDao.saveJobDetail(job);
		hr=(Employee)userDao.queryUserById(id);
		session.setAttribute("hr", hr);
		if(success)
		{
			model.addAttribute("messageType","success");
			model.addAttribute("message","Job Updated Successfully");
			return "hr_layout.Message";
		}
		else
		{
			model.addAttribute("messageType","failure");
			model.addAttribute("message","Job Updation Failed");
			return "hr_layout.Message";
		}
	}
	
	@RequestMapping(value = "/hrchangepassword", method = RequestMethod.GET)
	public String hrChangePassword(Model model,HttpServletRequest request) throws Exception {
	
		ChangePassword ch= new ChangePassword();
		model.addAttribute("changePassword",ch);
		return "hr_layout.ChangePassword";
	}
	
	@RequestMapping(value = "/hrChangePasswordSubmit", method = RequestMethod.POST)
	public String hrChangePasswordSubmit(Model model,ChangePassword ch,HttpServletRequest request) throws Exception {
	
		User user= (User) request.getSession().getAttribute("hr");
		if(user.getPassword().equals(ch.getOldPassword()))
		{
			if(ch.getNewPassword1().equals(ch.getNewPassword2()))
			{
				int id=user.getId();
				user.setPassword(ch.getNewPassword2());
				boolean success=userDao.changeUserPassword(id, ch.getNewPassword2());
				if(success)
				{
					Employee hr= (Employee) userDao.queryUserById(id);
					request.getSession().setAttribute("hr", hr);
					model.addAttribute("messageType","success");
					model.addAttribute("message","Password Changed Successfully");
					return "hr_layout.Message";
				}
				else
				{					
					model.addAttribute("messageType","failure");
					model.addAttribute("message","Failed To Change Password");
					return "hr_layout.Message";
				}
			}
			else
			{
				model.addAttribute("messageType","failure");
				model.addAttribute("message","New Password Doesn't Match Confirm Password.");
				return "hr_layout.Message";
			}
		}
		else
		{
			model.addAttribute("messageType","failure");
			model.addAttribute("message","Old Password Missmatch.");
			return "hr_layout.Message";
		}
	}
	@RequestMapping(value = "/viewApplicantResume", method = RequestMethod.GET)
	public void downloadOldResume(Model model,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		int id=Integer.parseInt(request.getParameter("applicantId"));
		Applicant applicant= (Applicant) userDao.queryUserById(id);
		File f= new File(applicant.getResumePath());
		FileInputStream fis= new FileInputStream(f);
		response.setHeader("Expires", "0");
        response.setHeader("Cache-Control","must-revalidate, post-check=0,precheck=0");
        response.setHeader("Pragma", "public");
        response.setContentType("application/pdf");
        response.setContentLength((int) f.length());
        OutputStream os = response.getOutputStream();
        IOUtils.copy(fis, os);
        os.flush();
        os.close(); 
	}
	
	@RequestMapping(value = "/viewApplications", method = RequestMethod.GET)
	public String viewApplications(Model model,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		int jobId=Integer.parseInt(request.getParameter("jobId"));
		JobDetails job= hrDao.getJob(jobId);
		model.addAttribute("applications",job.getApplications());
		return "hr_layout.ViewApplications";
	}
	
	@RequestMapping(value = "/viewApplicantDetails", method = RequestMethod.GET)
	public String viewApplicantDetails(Model model,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		int applicantId=Integer.parseInt(request.getParameter("applicantId"));
		Applicant applicant=(Applicant) userDao.queryUserById(applicantId);
		model.addAttribute("applicant",applicant);
		return "hrviewapplicantdetailsFreemarker";
	}
	@RequestMapping(value = "/sendEmail", method = RequestMethod.GET)
	public String sendEmail(Model model,HttpServletRequest request) throws Exception
	{
		int applicantId=Integer.parseInt(request.getParameter("applicantId"));
		Applicant applicant=(Applicant) userDao.queryUserById(applicantId);
		User user= (User) request.getSession().getAttribute("hr");
		
		EmailDetails emailDetails= new EmailDetails();
		emailDetails.setFrom(user.getFirstName()+" "+user.getLastName());
		emailDetails.setToName(applicant.getFirstName()+" "+applicant.getLastName());
		emailDetails.setTo(applicant.getEmailId());
		model.addAttribute("emailDetails",emailDetails);
		return "hr_layout.SendEmail";
	}
	
	@RequestMapping(value = "sendEmailSubmit", method = RequestMethod.POST)
	public String sendEmailSubmit(Model model,EmailDetails emailDetails,HttpServletRequest request) throws Exception
	{
		if(emailDetails.getBody().length()<=0)
		{
			model.addAttribute("messageType","failure");
			model.addAttribute("message","No Data in email body");
			return "hr_layout.Message";
		}
		boolean success=EmailUtils.sendApplicantMail(emailDetails);
		if(success)
		{
			model.addAttribute("messageType","success");
			model.addAttribute("message","Email Sent Successfully");
			return "hr_layout.Message";
		}
		else
		{					
			model.addAttribute("messageType","failure");
			model.addAttribute("message","Problem Sending Email, Please try some time later.");
			return "hr_layout.Message";
		}
	}
}
