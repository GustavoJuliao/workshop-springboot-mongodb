package com.projectweb.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectweb.workshopmongo.domain.Post;
import com.projectweb.workshopmongo.repository.PostRepository;
import com.projectweb.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> post = repo.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));
	}

	public List<Post> findByTitle(String title) {
		return repo.searchTitle(title);	
		}
}
