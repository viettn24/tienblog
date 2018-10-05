package com.tien.blog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tien.blog.dao.PostDAO;
import com.tien.blog.entity.Post;

@Controller
public class AppController {
	
	@Autowired
	private PostDAO postDAO;
	
	@GetMapping("/")
	public String showHome(Model theModel) {
		
		List<Post> newPost = postDAO.getPost();
		
		theModel.addAttribute("resultPost", newPost);
		
		return "home";
	}
	
	@PostMapping("/searchHome")
	public String search(@RequestParam("theSearchName") String theSearch, Model theModel) {
		List<Post> theSearchPost = postDAO.searchPost(theSearch);
		
		theModel.addAttribute("resultPost", theSearchPost);

		
		return "home";
	}
	
}
