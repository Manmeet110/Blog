package com.blog.main;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.blog.dao.AuthorDao;
import com.blog.dao.PostDao;
import com.blog.dao.TagDao;
import com.blog.entity.Author;
import com.blog.entity.Post;
import com.blog.entity.Tag;

public class AuthorMain {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("com/blog/conn/hibernate.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Boolean f = true;

		AuthorDao dao = new AuthorDao(factory);
		Author au = new Author();
		
		PostDao pdao = new PostDao(factory);
		Post po = new Post();
		
		

		while (f) {

			Scanner sc = new Scanner(System.in);
			System.out.println("------------------------------------------------");
			System.out.println("1. Add Author");
			System.out.println("2. view All Author");
			System.out.println("3. view Author By Id");
			System.out.println("4. Edit Author");
			System.out.println("5. Delete Author");
			System.out.println("6. Exit");
			System.out.println("------------------------------------------------");
			System.out.println("Enter Number");

			int i = sc.nextInt();
			int id;
			String name, email, password;
			switch (i) {
			case 1:

				System.out.println("Enter Post Id ");
				id = sc.nextInt();

				po = pdao.getPostById(id);
				if (po != null) {
					System.out.println("Enter Author Name");
					name = sc.next();
					System.out.println("Enter Email ");
					email = sc.next();
					System.out.println("Enter Password ");
					password = sc.next();
					au.setName(name);
					au.setEmail(email);
					au.setPassword(password);
					au.setPost(po);
					dao.saveAuthor(au);
					System.out.println("Saved Sucess");

				} else {
					System.out.println("Invalid Post ID");
				}

				break;
			case 2:
				List<Author> list = dao.getAllAuthor();
				list.forEach((e) -> System.out.println(e));
				break;
			case 3:
				System.out.println("Enter Author ID");
				id = sc.nextInt();
				au = dao.getAuthorById(id);
				if (au != null) {
					System.out.println(au);
				} else {
					System.out.println("Invalid Author ID");
				}

				break;
			case 4:

				System.out.println("Enter Author ID");
				id = sc.nextInt();

				System.out.println("Enter Author Name");
				name = sc.next();
				System.out.println("Enter Email ");
				email = sc.next();
				System.out.println("Enter Password ");
				password = sc.next();

				au = dao.getAuthorById(id);

				if (au != null) {
					au.setName(name);
					au.setEmail(email);
					au.setPassword(password);
					dao.updateAuthor(au);
					System.out.println("Update Success");
				} else {
					System.out.println("Invalid Author ID");
				}

				break;
			case 5:
				System.out.println("Enter Author ID");
				id = sc.nextInt();
				au = dao.getAuthorById(id);

				if (au != null) {
					dao.deleteAuthor(au);
					System.out.println("Delete Success");
				} else {
					System.out.println("Invalid Author ID");
				}

				break;
			default:
				f = false;
				System.out.println("Thank u");
				break;
			}

		}
	}
}
