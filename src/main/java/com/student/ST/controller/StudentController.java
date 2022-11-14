package com.student.ST.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.student.ST.domain.Student;
import com.student.ST.repository.StudentRepository;
import com.student.ST.service.StudentService;

import ch.qos.logback.classic.Logger;

@Controller
public class StudentController {
	  private StudentService service;
	  @Autowired
	  private StudentRepository studentrepository;
	    @GetMapping("/H")
	    public String viewHomePage(Model model) {
	        List<Student> liststudent = service.listAll();
	        model.addAttribute("liststudent", liststudent);
	        System.out.print("Get / ");
	        return "/H";
	    }
	 
	    @GetMapping("/new")
	    public String add(Model model) {
	        model.addAttribute("student", new Student());
	        return "new";
	    }
		
		/*
		 * @Autowired private StudentRepository stRepository;
		 * 
		 * @GetMapping("/save")
		 * 
		 * @ResponseBody() public String saveStudent(@ModelAttribute("student") Student
		 * std) {
		 * 
		 * Student student = new Student(); //student.setId();
		 * student.setStudentname("Mohit Saini"); student.setCourse("Java Devlo");
		 * stRepository.save(student); return "redirect:/H"; }
		 */
		 
		
		  @RequestMapping(value = "/save", method = RequestMethod.POST) 
		  public String  saveStudent(@ModelAttribute("student") Student std , Model model) { 
			//  service.save(std);
				/*
				 * std.setStudentname("Mohit"); std.setCourse("Jaa devloper");
				 * std.setFee(10000);
				 */
			  

			//	System.out.println("t" +agreement);
				System.out.println("student" +std);
				Student result =	this.studentrepository.save(std);
				model.addAttribute("user", result);
		
		     return "new"; 
		  }
		 
	
	  //  System.out.println("My Service >>>> "  +service.save(std));
	 
	    @RequestMapping("/edit/{id}")
	    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
	        ModelAndView mav = new ModelAndView("new");
	        Student std = service.get(id);
	        mav.addObject("student", std);
	        return mav;
	        
	    }
	    @RequestMapping("/delete/{id}")
	    public String deletestudent(@PathVariable(name = "id") int id) {
	        service.delete(id);
	        return "redirect:/H";
	    }
}
