package com.trelloclone.Controller;

import com.trelloclone.Model.User;
import com.trelloclone.Service.ProjectService;
import com.trelloclone.Service.TaskService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<?> getDashboard(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User is not logged in");
        }
        Map<String, Object> dashboardData = new HashMap<>();
        dashboardData.put("projects", projectService.findAll());
        dashboardData.put("tasks", taskService.findAll());
        return ResponseEntity.ok(dashboardData);
    }
}