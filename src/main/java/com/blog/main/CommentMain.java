package com.blog.main;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.blog.dao.CommentDao;
import com.blog.dao.PostDao;
import com.blog.entity.Comment;
import com.blog.entity.Post;

public class CommentMain {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("com/blog/conn/hibernate.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Boolean f = true;

		CommentDao dao = new CommentDao(factory);

		Comment cm = new Comment();

		PostDao pdao = new PostDao(factory);
		Post po = new Post();

		while (f) {

			Scanner sc = new Scanner(System.in);
			System.out.println("------------------------------------------------");
			System.out.println("1. Add Comment");
			System.out.println("2. view All Comment");
			System.out.println("3. view Comment By Id");
			System.out.println("4. Edit Comment");
			System.out.println("5. Delete Comment");
			System.out.println("6. Exit");
			System.out.println("------------------------------------------------");
			System.out.println("Enter Number");

			int i = sc.nextInt();
			int id;
			String name, email, text;
			switch (i) {
			case 1:

				System.out.println("Enter Post Id ");
				id = sc.nextInt();

				po = pdao.getPostById(id);
				if (po != null) {

					System.out.println("Enter name ");
					name = sc.next();
					System.out.println("Enter Email ");
					email = sc.next();
					System.out.println("Enter text ");
					text = sc.next();

					cm.setName(name);
					cm.setEmail(email);
					cm.setText(text);
					cm.setPost(po);

					dao.saveComment(cm);
					System.out.println("Comment Sucess");
				} else {
					System.out.println("Invalid Post Id");
				}
				break;
			case 2:
				List<Comment> list = dao.getAllComment();
				list.forEach((e) -> System.out.println(e));
				break;
			case 3:
				System.out.println("Enter Comment ID");
				id = sc.nextInt();
				cm = dao.getCommentById(id);
				if (cm != null) {
					System.out.println(cm);
				} else {
					System.out.println("Invalid Id");
				}

				break;

			case 4:
				System.out.println("Enter Comment ID");
				id = sc.nextInt();
				cm = dao.getCommentById(id);
				if (cm != null) {

					System.out.println("Enter name ");
					name = sc.next();
					System.out.println("Enter Email ");
					email = sc.next();
					System.out.println("Enter text ");
					text = sc.next();
					
					cm.setName(name);
					cm.setEmail(email);
					cm.setText(text);
					
					dao.updateComment(cm);
					System.out.println("Update Success");
				} else {
					System.out.println("Invalid Tag");
				}
				break;
			case 5:
				System.out.println("Enter Comment ID");
				id = sc.nextInt();
				cm = dao.getCommentById(id);
				if (cm != null) {
					dao.deleteComment(cm);
					System.out.println("Delete Sucess");
				} else {
					System.out.println("Invalid Id");
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
