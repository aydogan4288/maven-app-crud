package com.gcit.service;

import java.util.List;

import com.gcit.dao.AuthorDao;
import com.gcit.dto.Author;

public class AuthorService {
	
	AuthorDao authorDao;
	
	public AuthorService() {
	}
	
	public AuthorService(AuthorDao authorDao) {
		this.authorDao = authorDao;
	}
	
	public List<Author> getAllAuthors(){
		return authorDao.viewAllAuthors();
	}
	
	public void createAuthor(String name) {
		authorDao.createAuthor(name);
	}
	
	public void updateAuthor(String name, int id) {
		authorDao.updateAuthor(name, id);
	}
	
	public void deleteAuthor(int id) {
		authorDao.deleteAuthor(id);
	}
}
