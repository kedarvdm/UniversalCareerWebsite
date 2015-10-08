package com.me.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.me.model.Applicant;
import com.me.model.Employee;
import com.me.model.Employer;
import com.me.model.User;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter
{
 @Override
 public boolean preHandle(HttpServletRequest request,
   HttpServletResponse response, Object handler) throws Exception
 {
  String uri = request.getRequestURI();
  if(!uri.endsWith("/controllers/") && !uri.endsWith("logout") 
		  &&!uri.endsWith("loginsubmit") && !uri.endsWith("invalidLogin")
		  &&!uri.endsWith("applicantsignup") && !uri.endsWith("employersignup")
		  &&!uri.endsWith("applicantSignUpSubmit") && !uri.endsWith("employersignupsubmit"))
  {
	  Employer employer;
	  Applicant applicant;
	  Employee hr;
	   try
	   {
		   employer = (Employer) request.getSession().getAttribute("employer"); 
	   }
	   catch(Exception ex)
	   {
		   employer=null;
	   }
	   try
	   {
		   applicant=(Applicant) request.getSession().getAttribute("applicant"); 
	   }
	   catch(Exception ex)
	   {
		   applicant=null;
	   }
	   try
	   {
		   hr=(Employee) request.getSession().getAttribute("hr"); 
	   }
	   catch(Exception ex)
	   {
		   hr=null;
	   }
	   if(employer == null && applicant==null && hr==null)
	   {
	    response.sendRedirect("/controllers/invalidLogin");
	    return false;
	   }   
  }
  return true;
 }
}
