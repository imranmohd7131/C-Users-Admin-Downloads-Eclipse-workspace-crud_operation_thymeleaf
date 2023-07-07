package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Entity;
import com.repo.Entity_repos;
import com.repo.LoginRepo;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class Control {
		
		@Autowired
		private LoginRepo repo;
		@Autowired
		private Entity_repos repo2;
	
		@GetMapping("/home")
		public String home(){
			return "home";	
		}
		
		@PostMapping("/login")
		public String login(@RequestParam String email,String pswd,HttpSession session,Model model,HttpServletResponse resp){
			if(repo.findByEmail(email,pswd) !=null) {
				session.setAttribute("email", email);
			
				return "redirect:check";
			}else
			{
				model.addAttribute("msg","Invalid Credentials....!!");
				return "home";
			}
		}
		
		@GetMapping("/check")
		public String check(Model model){
			List<Entity> li=repo2.findAll();
			model.addAttribute("read", li);
			return "main";	
		}
		
		@GetMapping("/insert")
		public String insert(Model model){
			return "insert";	
		}
		
		@PostMapping("/save")
		public String save(@RequestParam String name,String loc,Model model){
			Entity entity=new Entity(name,loc);
			repo2.save(entity);
			List<Entity> li=repo2.findAll();
			model.addAttribute("read", li);
			model.addAttribute("msg","Data Insert successfully....(:");
			return "main";
		}
		
		@GetMapping("/delete/{id}")
		public String delete(@PathVariable String id,Model model){
			repo2.deleteById(id);
			List<Entity> li=repo2.findAll();
			model.addAttribute("read", li);
			model.addAttribute("msgg","Data Deleted successfully....):");
			return "main";	
		}
		@GetMapping("/edit/{id}")
		public String edit(@PathVariable String id,Model model){
			model.addAttribute("data", 	repo2.findById(id));
			return "edit";	
		}
		@PostMapping("/update")
		public String update(@RequestParam int id,String name,String loc,Model model){
			Entity entity=new Entity(id,name,loc);
			repo2.save(entity);
			List<Entity> li=repo2.findAll();
			model.addAttribute("read", li);
			model.addAttribute("msg","Your Data is updated....):");
			return "main";	
		}
		@GetMapping("/logout")
		public String logout(HttpSession session,Model model) {
			session.removeAttribute("email");
			session.invalidate();
			return "home";
		}
}