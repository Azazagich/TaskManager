package org.example.taskmanager;

import org.example.taskmanager.domain.Role;
import org.example.taskmanager.domain.User;
import org.example.taskmanager.repository.RoleRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class TaskManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
	}


}
