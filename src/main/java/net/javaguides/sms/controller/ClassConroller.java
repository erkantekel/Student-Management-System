package net.javaguides.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.javaguides.sms.entity.Class;
import net.javaguides.sms.service.ClassService;
import net.javaguides.sms.service.StudentService;

@Controller
public class ClassConroller {
	@Autowired
	private ClassService classService;
	
	@Autowired
	private StudentService studentService;


	public ClassConroller(ClassService classService) {
		super();
		this.classService = classService;
		
	}
	
	@GetMapping("/classes")
	public String listClasss(Model model) {
		model.addAttribute("classes", classService.getAllClasses());
//		if(btn) {
//			model.addAttribute("students", studentService.getAllStudents());
//		}else {
//			model.addAttribute("students", null);
//		}
		return "classes";
	}
	
	@GetMapping("/classes/new")
	public String createClassForm(Model model) {
		
		Class class_ = new Class();
		model.addAttribute("class_", class_);
		return "create_class";
		
	}
	
	@PostMapping("/classes")
	public String saveClass(@ModelAttribute("class_") Class class_) {
		classService.saveClass(class_);
		return "redirect:/classes";
	}
	
	@GetMapping("/classes/edit/{cid}")
	public String editClassForm(@PathVariable Long cid, Model model) {
		model.addAttribute("class_", classService.getClassById(cid));
		return "edit_class";
	}

	@PostMapping("/classes/{cid}")
	public String updateClass(@PathVariable Long cid,
			@ModelAttribute("class_") Class class_,
			Model model) {
		
		Class existingClass = classService.getClassById(cid);
		existingClass.setCid(cid);
		existingClass.setClassName(class_.getClassName());
		classService.updateClass(existingClass);
		return "redirect:/classes";		
	}
		
	@GetMapping("/classes/delete/{cid}")
	public String deleteClass(@PathVariable Long cid) {
		classService.deleteClassById(cid);
		return "redirect:/classes";
	}
	private boolean btn =false;
	@ResponseBody
	@GetMapping("/classes/students/{className}")
	public String classStudents(@PathVariable String className, Model model) {
		btn = !btn;
		if(btn) {
			model.addAttribute("students", studentService.getStudentByClassName(className));
		}else {
			model.addAttribute("students", null);
		}
		return "redirect:/classes";
	}
}

