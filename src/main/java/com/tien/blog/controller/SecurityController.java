package com.tien.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tien.blog.dao.PostDAO;
import com.tien.blog.entity.Post;


@Controller
@RequestMapping("/user")
public class SecurityController {

	@Autowired
	private PostDAO postDAO;
	
	@GetMapping("/login")
	private String showFormLogin() {
		
		return "login";
	}
	
	@GetMapping("/adminpanel")
	public String showAdminPanel(Model theModel) {
		
		List<Post> list = postDAO.getPostAdmin();
		
		theModel.addAttribute("postResult", list);
		
		return "admin-panel";
	}
	
	@GetMapping("/addNewPost")
	public String addNewPost(Model theModel) {
		Post newPost = new Post();
		
		theModel.addAttribute("newPost", newPost);
		
		
		return "form-for-add";
	}
	
	@PostMapping("/savePost")
	public String savePost(@ModelAttribute("savePost") Post thePost) {
		
		postDAO.savePost(thePost);
		
		return "redirect:/user/adminpanel";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("postId") int theId, Model theModel) {
		
		Post newPost = postDAO.updatePost(theId);
		
		theModel.addAttribute("newPost", newPost);
		
		
		
		return "form-for-add";
	}
	
	@RequestMapping("/deletePost")
	public String deletePost(@RequestParam("deleteId") int theId){
		
		postDAO.deletePost(theId);
		
		return "redirect:/user/adminpanel";
	}
	
	
}
