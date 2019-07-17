package com.gcit.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.gcit.dto.Author;

public class AuthorDao {

	private Connection conn = null;

	public List<Author> viewAllAuthors() {
		conn = DBDao.getConnection();
		String sql = "SELECT * FROM author";
		List<Author> authorList = new ArrayList<Author>();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Author author = new Author(resultSet.getInt("authId"), resultSet.getString("authName"));
				authorList.add(author);
			}
			return authorList;
		} catch (Exception e) {
			e.printStackTrace();
			return authorList;
		}
	}

	public void createAuthor(String name) {
		
		conn = DBDao.getConnection();
		String sql = "INSERT INTO author (name) VALUES (?)";
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.execute();
			System.out.println("Author Added");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Execution failed");
		}
	}
	
	public void deleteAuthor(int id) {
		
		conn = DBDao.getConnection();
		String sql = "DELETE FROM author WHERE id = ?";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			System.out.println("Successfully deleted");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Execution failed");
		}
	}
	
	public void updateAuthor(String name, int id) {
		
		conn = DBDao.getConnection();
		String sql = "UPDATE tbl_author SET authorName = ? WHERE authorId = ?";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, id);
			preparedStatement.execute();
			System.out.println("Successfully updated");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Execution Failed");
		}
	}
	
}
