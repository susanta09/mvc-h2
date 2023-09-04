package com.example.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.entity.Employee;
import com.example.service.EmpService;

@Controller
public class EmpController {
	@Autowired
	private EmpService empService;
	@GetMapping("/")
	public String showForm( Model model)
	{
		Employee e=new Employee();
		model.addAttribute("employee",e);
		System.out.println(e);
		return "form";
	}
	@PostMapping("/emp")
	public String getUiData(Employee employee,Model m)
	{
		System.out.println(employee);
		Boolean b=empService.saveData(employee);
		
		if(b)
		{
			m.addAttribute("msg", "Data inserted successfully....");
			return "form";
		}else {
			m.addAttribute("msg", "Data  insert operation is fail");
			return "form";
		}
	}
	@GetMapping("/employees")
	public ModelAndView showRecord()
	{
		List<Employee> el=empService.getAllData();
		System.out.println(el);
		ModelAndView mv=new ModelAndView();
	    	mv.addObject("empList",el);
	    	mv.setViewName("showdata");
	    	return mv;
	}
	@GetMapping("/updateForm/{id}")
	public String updateForm(@PathVariable("id")Integer id,Model model)
	{
		System.out.println("empId"+id);
		Employee e=empService.getEmpById(id);
		model.addAttribute("employee", e);
		return "edit";
	}
	@PostMapping("/updateEmpData")
	public String updateEmpData (Employee employee,RedirectAttributes redirectAttrs)
	{
		System.out.println(employee);
		empService.saveData(employee);
		redirectAttrs.addFlashAttribute("msg", "Data Updated successfully....");
		//m.addAttribute("msg", "Data Updated successfully....");
		return "redirect:/employees";
	}
	@GetMapping("/deleteEmp/{id}")
	public String deleteEmp(@PathVariable("id") Integer id,RedirectAttributes redirectAttrs)
	{
		System.out.println("delete id "+id);
		empService.deleteEmpById(id);
		redirectAttrs.addFlashAttribute("msg", "Data Deleted successfully....");
		return "redirect:/employees";
		
	}
}
