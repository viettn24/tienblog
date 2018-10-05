package com.tien.blog.dao;

import java.util.List;

import com.tien.blog.entity.Post;

public interface PostDAO {
	public List<Post> getPost();

	public void savePost(Post thePost);

	public Post updatePost(int theId);

	public void deletePost(int theId);

	public List<Post> searchPost(String theSearch);
	public List<Post> getPostAdmin();
}
