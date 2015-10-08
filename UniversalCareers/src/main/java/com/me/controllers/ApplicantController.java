package com.me.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.me.dao.ApplicantDao;
import com.me.dao.UserDao;
import com.me.model.Applicant;
import com.me.model.Application;
import com.me.model.Education;
import com.me.model.JobDetails;
import com.me.model.User;
import com.me.model.WorkExperience;
import com.me.utils.ChangePassword;
import com.me.utils.SearchingCriteria;
import com.me.utils.UDate;

@Controller
public class ApplicantController {

	@Autowired
	ServletContext servletContext;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ApplicantDao applicantDao;
	
	@RequestMapping(value = "/applicantsignup", method = RequestMethod.GET)
	public String applicantSignUp(Model model)
	{
		Applicant applicant= new Applicant();
		model.addAttribute("applicant",applicant);
		return "applicant_layout_signup";
	}
	
	@RequestMapping(value = "/applicantSignUpSubmit", method = RequestMethod.POST)
	public String applicantSignUpSubmit(Model model,Applicant applicant,HttpSession session) throws Exception
	{
		if(!userDao.queryDuplicateUser(applicant.getEmailId()))
		{
			applicant.setRole("Applicant");
			boolean success=userDao.saveUser(applicant);
			session.setAttribute("applicant", applicant);
			if(success)
			{
				model.addAttribute("messageType","success");
				model.addAttribute("message","Account Created, Please login");
				return "applicant_layout.Message";
			}
			else
			{
				model.addAttribute("messageType","failure");
				model.addAttribute("message","Account Creation Failed");
				return "base.definition.RegFailed";
			}
		}
		else
		{
			model.addAttribute("messageType","failure");
			model.addAttribute("message","Applicant Allready Present");
			return "base.definition.RegFailed";
		}
	}
	
	@RequestMapping(value = "/myProfile", method = RequestMethod.GET)
	public String applicantProfile(Model model,HttpSession session) throws Exception
	{
		Applicant applicant= (Applicant) session.getAttribute("applicant");
		WorkExperience workEx=applicantDao.getWorkExDetails(applicant);
		if(workEx==null)
		{
			workEx= new WorkExperience();
		}
		Education educationdetails=applicantDao.getEducationDetails(applicant);
		if(educationdetails==null)
		{
			educationdetails= new Education();
		}
		model.addAttribute("applicant",applicant);
		model.addAttribute("workEx",workEx);
		model.addAttribute("educationdetails",educationdetails);
		return "applicant_layout.myProfile";
	}
	
	@RequestMapping(value = "/updatePersonalInfo", method = RequestMethod.POST)
	public String applicantPersonalInfo(Model model, Applicant applicant, HttpSession session) throws Exception
	{
		Applicant a=(Applicant)session.getAttribute("applicant");
		applicant.setPassword(a.getPassword());
		applicant.setRole("Applicant");
		int id= applicant.getId();
		userDao.saveUser(applicant);
		applicant=(Applicant)userDao.queryUserById(id);
		session.setAttribute("applicant", applicant);
		WorkExperience workEx=applicantDao.getWorkExDetails(applicant);
		if(workEx==null)
		{
			workEx= new WorkExperience();
		}
		Education educationdetails=applicantDao.getEducationDetails(applicant);
		if(educationdetails==null)
		{
			educationdetails= new Education();
		}
		model.addAttribute("applicant",applicant);
		model.addAttribute("workEx",workEx);
		model.addAttribute("educationdetails",educationdetails);
		return "applicant_layout.myProfile";
	}
	
	@RequestMapping(value = "/updateEducationalDetails", method = RequestMethod.POST)
	public String applicantEducationalDetails(Model model, Education education, HttpSession session) throws Exception
	{
		Applicant applicant= (Applicant) session.getAttribute("applicant");
		int id= applicant.getId();
		education.setUser(applicant);
		applicant.setRole("Applicant");
		applicantDao.saveEducationalDetails(education);
		applicant=(Applicant)userDao.queryUserById(id);
		session.setAttribute("applicant", applicant);
		WorkExperience workEx=applicantDao.getWorkExDetails(applicant);
		if(workEx==null)
		{
			workEx= new WorkExperience();
		}
		Education educationdetails=applicantDao.getEducationDetails(applicant);
		if(educationdetails==null)
		{
			educationdetails= new Education();
		}
		model.addAttribute("applicant",applicant);
		model.addAttribute("workEx",workEx);
		model.addAttribute("educationdetails",educationdetails);
		return "applicant_layout.myProfile";
	}
	
	@RequestMapping(value = "/updateWorkExDetails", method = RequestMethod.POST)
	public String applicantWorkExDetails(Model model, WorkExperience workEx, HttpSession session) throws Exception
	{
		Applicant applicant= (Applicant) session.getAttribute("applicant");
		int id= applicant.getId();
		applicant.setRole("Applicant");
		workEx.setUser(applicant);
		workEx.setDateCreated(new UDate().toString());
		applicantDao.saveWork(workEx);
		applicant=(Applicant)userDao.queryUserById(id);
		session.setAttribute("applicant", applicant);
		workEx=applicantDao.getWorkExDetails(applicant);
		if(workEx==null)
		{
			workEx= new WorkExperience();
		}
		Education educationdetails=applicantDao.getEducationDetails(applicant);
		if(educationdetails==null)
		{
			educationdetails= new Education();
		}
		model.addAttribute("applicant",applicant);
		model.addAttribute("workEx",workEx);
		model.addAttribute("educationdetails",educationdetails);
		return "applicant_layout.myProfile";
	}
	
	
	@RequestMapping(value = "/viewJobs", method = RequestMethod.GET)
	public String applicantViewJobs(Model model,HttpServletRequest request) throws Exception
	{	
		Applicant applicant=(Applicant) request.getSession().getAttribute("applicant");
		int id= applicant.getId();
		applicant= (Applicant) userDao.queryUserById(id);
		request.getSession().setAttribute("applicant", applicant);
		SearchingCriteria sc= new SearchingCriteria();
		model.addAttribute("searchCriteria",sc);
		return "applicant_layout.ViewJobs";
	}
	@RequestMapping(value = "/searchJobSubmit", method = RequestMethod.POST)
	public String applicantViewJobsSubmit(Model model,SearchingCriteria sc,HttpServletRequest request) throws Exception
	{
		Applicant applicant=(Applicant) request.getSession().getAttribute("applicant");
		int id= applicant.getId();
		applicant= (Applicant) userDao.queryUserById(id);
		applicant.setRole("Applicant");
		request.getSession().setAttribute("applicant", applicant);
		model.addAttribute("searchCriteria",sc);
		ArrayList<JobDetails> jobDetails= applicantDao.searchJobsByCriteria(sc);
		model.addAttribute("searchResults",jobDetails);
		return "applicant_layout.ViewJobs";
	}
	
	@RequestMapping(value = "/viewjobdetails", method = RequestMethod.GET)
	public String applicantViewJobsDetails(Model model,HttpServletRequest request) throws Exception
	{
		int jobid=Integer.parseInt(request.getParameter("id"));
		JobDetails job= applicantDao.searchJobsById(jobid);
		model.addAttribute("job", job);
		String noShow=request.getParameter("noShow");
		if(noShow!=null && noShow.equalsIgnoreCase("yes"))
		{
			model.addAttribute("noShow",noShow);
		}
		else
		{
			model.addAttribute("noShow", "no");
		}
		Applicant applicant=(Applicant) request.getSession().getAttribute("applicant");
		int id= applicant.getId();
		applicant= (Applicant) userDao.queryUserById(id);
		request.getSession().setAttribute("applicant", applicant);
		return "viewjobdetailsVelocity";
	}

	@RequestMapping(value = "/applyToJob", method = RequestMethod.GET)
	public String applicantApplyToJob(Model model,HttpServletRequest request) throws Exception
	{
		HttpSession session=request.getSession();
		Applicant applicant=(Applicant) session.getAttribute("applicant");
		int id= applicant.getId();
		int jobid= Integer.parseInt(request.getParameter("id"));
		JobDetails job= applicantDao.searchJobsById(jobid);
		Application application= new Application();
		application.setUser(applicant);
		application.setDateCreated(new UDate().toString());
		application.setJob(job);
		application.setDateAppStatus(new UDate().toString());
		application.setDateIntStatus(new UDate().toString());
		application.setAppStatus("Applied");
		application.setInternalAppStatus("Applied");
		
		if(!applicantDao.checkIfAlreadyApplied((User)applicant, job))
		{
			boolean success=applicantDao.submitApplication(application);
			applicant= (Applicant) userDao.queryUserById(id);
			session.setAttribute("applicant", applicant);
			if(success)
			{
				model.addAttribute("messageType","success");
				model.addAttribute("message","You Have Successfully Applied To This Job");
				return "applicant_layout.Message";
			}
			else
			{
				model.addAttribute("messageType","failure");
				model.addAttribute("message","Error Applying Job.");
				return "applicant_layout.Message";
			}
		}
		else
		{
			model.addAttribute("messageType","failure");
			model.addAttribute("message","Application Already Present, Please Be Patient For Our Reply.");
			return "applicant_layout.Message";
		}
	}
	
	@RequestMapping(value = "/uploadResume", method = RequestMethod.GET)
	public String applicantResume(Model model,HttpServletRequest request) throws Exception
	{
		Applicant applicant= (Applicant) request.getSession().getAttribute("applicant");
		if(applicant.getResumePath()!=null && !applicant.getResumePath().equalsIgnoreCase(""))
		{
			model.addAttribute("id","Yes");
		}
		else
		{
			model.addAttribute("id","NA");
		}
		return "applicant_layout.UploadResume";
	}
	
	@RequestMapping(value = "/uploadResumeSubmit", method = RequestMethod.POST)
	public String applicantResumeSubmit(Model model,HttpServletRequest request, @RequestParam("file") CommonsMultipartFile resume) throws Exception
	{
		Applicant applicant= (Applicant) request.getSession().getAttribute("applicant");
		int id=applicant.getId();
		boolean success=false;
		File localFile=null;
		try{
			System.out.println(request.getSession().getServletContext().getRealPath("/webapps/"));
			String rootPath = System.getProperty("catalina.home");
            File dir = new File(rootPath + File.separator + "UniversalCareers"+File.separator+"Applicants"+File.separator+"Resumes"+File.separator+applicant.getId()+File.separator);
            if (!dir.exists())
                dir.mkdirs();
			localFile = new File(dir.getAbsoluteFile(), String.valueOf(applicant.getId())+".pdf");
			resume.transferTo(localFile);
			success=true;
		}
		catch(Exception ex)
		{
			success=false;
		}
		if(success)
		{
			applicant=(Applicant) userDao.queryUserById(id);
			applicant.setResumePath(localFile.getPath());
			userDao.saveUser(applicant);
			request.getSession().setAttribute("applicant", applicant);
			model.addAttribute("messageType","success");
			model.addAttribute("message","Resume Uploaded");
			return "applicant_layout.Message";
		}
		else
		{
			model.addAttribute("messageType","failure");
			model.addAttribute("message","Upload failed.");
			return "applicant_layout.Message";
		}
	}
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void downloadOldResume(Model model,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		Applicant applicant= (Applicant) request.getSession().getAttribute("applicant");
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
	
	@RequestMapping(value = "/applicantchangepassword", method = RequestMethod.GET)
	public String applicantChangePassword(Model model,HttpServletRequest request) throws Exception {
	
		ChangePassword ch= new ChangePassword();
		model.addAttribute("changePassword",ch);
		return "applicant_layout.ChangePassword";
	}
	
	@RequestMapping(value = "/applicantChangePasswordSubmit", method = RequestMethod.POST)
	public String applicantChangePasswordSubmit(Model model,ChangePassword ch,HttpServletRequest request) throws Exception {
	
		User user= (User) request.getSession().getAttribute("applicant");
		if(user.getPassword().equals(ch.getOldPassword()))
		{
			if(ch.getNewPassword1().equals(ch.getNewPassword2()))
			{
				int id=user.getId();
				user.setPassword(ch.getNewPassword2());
				boolean success=userDao.changeUserPassword(id, ch.getNewPassword2());
				if(success)
				{
					Applicant applicant= (Applicant) userDao.queryUserById(id);
					request.getSession().setAttribute("applicant", applicant);
					model.addAttribute("messageType","success");
					model.addAttribute("message","Password Changed Successfully");
					return "applicant_layout.Message";
				}
				else
				{					
					model.addAttribute("messageType","failure");
					model.addAttribute("message","Failed To Change Password");
					return "applicant_layout.Message";
				}
			}
			else
			{
				model.addAttribute("messageType","failure");
				model.addAttribute("message","New Password Doesn't Match Confirm Password.");
				return "applicant_layout.Message";
			}
		}
		else
		{
			model.addAttribute("messageType","failure");
			model.addAttribute("message","Old Password Missmatch.");
			return "applicant_layout.Message";
		}
	}
	@RequestMapping(value = "/myapplications", method = RequestMethod.GET)
	public String myapplications(Model model,HttpServletRequest request) throws Exception {
		
		Applicant applicant= (Applicant) request.getSession().getAttribute("applicant");
		model.addAttribute("applications",applicant.getApplications());
		return "applicant_layout.MyApplications";
	}
}
