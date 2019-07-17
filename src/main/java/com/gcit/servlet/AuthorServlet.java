package com.gcit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gcit.dao.AuthorDao;
import com.gcit.dto.Author;
import com.gcit.service.AuthorService;
import com.google.gson.Gson;
import java.util.Random;

@WebServlet({ "/author", "/author/id/*", "/author/remove/id/*", "/author/retrieve/id/*" })

public class AuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AuthorService authorService = new AuthorService();

	public AuthorServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getRequestURI().substring(request.getContextPath().length());
		Gson gson = new Gson();
		if ("/author".equals(path) || "/author/".equals(path)) {
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			System.out.println(authorService.getAllAuthors());
			out.print(gson.toJson(authorService.getAllAuthors()));
			out.flush();
		}

		if (path.contains("/author/remove/id")) {
			String pathInfo = request.getPathInfo();

			if (pathInfo == null) {
				System.out.println("hi");
				response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			} else {
				Integer id = Integer.parseInt(pathInfo.replaceAll("/", ""));
				authorService.deleteAuthor(id);
				PrintWriter out = response.getWriter();
				out.print("Your author got deleted");
			}
		}
		if (path.contains("/author/retrieve/id")) {
			System.out.println("3");

			String pathInfo = request.getPathInfo();
			if (pathInfo == null) {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			} else {
				try {
					Integer id = Integer.parseInt(pathInfo.replaceAll("/", ""));

					response.setContentType("application/json");

					PrintWriter out = response.getWriter();

					out.print(gson.toJson(authorService.getAllAuthors().stream()
							.filter(author -> author.getAuthId() == id).collect(Collectors.toList())));

					out.flush();
				} catch (Exception e) {
					response.sendError(HttpServletResponse.SC_BAD_REQUEST);
				}

			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String strID = request.getParameter("id");
		Gson gson = new Gson();
		System.out.println(strID);
		if (strID.equals("")) {
			authorService.createAuthor(name);
			PrintWriter out = response.getWriter();
			out.print(gson.toJson(name));
			out.flush();
		} else {
			int id = Integer.parseInt(strID);
			authorService.updateAuthor(name, id);
			PrintWriter out = response.getWriter();
			out.print(gson.toJson(name));
			out.flush();

		}
	}

}
