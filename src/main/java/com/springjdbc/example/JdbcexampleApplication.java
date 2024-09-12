package com.springjdbc.example;

import com.springjdbc.example.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@SpringBootApplication
public class JdbcexampleApplication implements CommandLineRunner {

	@Autowired
	private UserDao userDao;

	public static void main(String[] args) {
		SpringApplication.run(JdbcexampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.userDao.createTable());
		this.createUser();
	}

	public void createUser()throws  Exception{
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter user id:");
		Integer userId=Integer.parseInt(bufferedReader.readLine());

		System.out.println("Enter user name:");
		String name=bufferedReader.readLine();

		System.out.println("Enter user age:");
		Integer age=Integer.parseInt(bufferedReader.readLine());

		System.out.println("Enter user city:");
		String city=bufferedReader.readLine();

		int i = this.userDao.insertRecord(userId, name, age, city);

		System.out.println(i+" user added");

	}
}
