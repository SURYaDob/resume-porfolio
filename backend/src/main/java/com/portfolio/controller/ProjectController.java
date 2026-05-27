package com.portfolio.controller;

import com.portfolio.model.Project;
import com.portfolio.model.Skill;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProjectController {

    private final List<Project> projects = new ArrayList<>();
    private final List<Skill> skills = new ArrayList<>();

    @PostConstruct
    public void init() {
        // Seed projects
        projects.add(new Project("Task Manager Web Application",
                "A full-stack task management system with user authentication, role-based access control, and CRUD operations for tasks and projects. Built with Spring Boot MVC architecture, JPA repositories, and MySQL.",
                "📋", "https://github.com/SURYaDob/task-manager-springboot",
                "Java, Spring Boot, MySQL, Thymeleaf, MVC, JPA", 1));

        projects.add(new Project("CDAC Website & Application",
                "A responsive institutional website with backend logic, MySQL database integration, and modular MVC architecture for efficient workflow management and data persistence.",
                "🌐", "https://github.com/SURYaDob",
                "Java, Spring Boot, MySQL, HTML, CSS, MVC", 2));

        projects.add(new Project("Laundry Management System",
                "A web-based operational workflow system for managing laundry orders, customer records, billing, and order tracking with full CRUD functionality and JDBC integration.",
                "🏠", "https://github.com/SURYaDob",
                "Java, JDBC, MySQL, HTML, CSS, Servlets", 3));

        projects.add(new Project("Student Management System",
                "A console-based application for student data management using JPA repositories with custom JPQL queries and a normalized MySQL relational database schema.",
                "🎓", "https://github.com/SURYaDob/student-management-system",
                "Java, JPA, Hibernate, MySQL, JPQL", 4));

        // Seed skills
        skills.add(new Skill("Java", "Languages", 90, true, 1));
        skills.add(new Skill("Spring Boot", "Backend", 90, true, 2));
        skills.add(new Skill("Spring MVC", "Backend", 85, true, 3));
        skills.add(new Skill("Spring Data JPA", "Backend", 85, true, 4));
        skills.add(new Skill("Hibernate", "Backend", 80, false, 5));
        skills.add(new Skill("MySQL", "Databases", 85, true, 6));
        skills.add(new Skill("HTML5 / CSS3", "Frontend", 85, false, 7));
        skills.add(new Skill("JavaScript", "Frontend", 70, false, 8));
        skills.add(new Skill("Thymeleaf", "Frontend", 75, false, 9));
        skills.add(new Skill("Git / Maven", "Tools", 75, false, 10));
        skills.add(new Skill("JDBC / Servlets", "Backend", 75, false, 11));
        skills.add(new Skill("Oracle SQL", "Databases", 70, false, 12));
    }

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getProjects() {
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/skills")
    public ResponseEntity<List<Skill>> getSkills() {
        return ResponseEntity.ok(skills);
    }

    @GetMapping("/info")
    public ResponseEntity<Map<String, Object>> getInfo() {
        return ResponseEntity.ok(Map.of(
                "name", "Suraj Dobale",
                "title", "Full Stack Java Developer",
                "email", "surajdobale29@gmail.com",
                "phone", "+91 9172567835",
                "location", "Nagpur, Maharashtra, India",
                "github", "https://github.com/SURYaDob",
                "linkedin", "https://www.linkedin.com/in/suraj-dobale-b713b91a6/",
                "certification", "PG-DAC (CDAC) — IACSD Akurdi"
        ));
    }
}
