package com.trelloclone.Controller;

import com.trelloclone.Model.Project;
import com.trelloclone.Model.Task;
import com.trelloclone.Service.ProjectService;
import com.trelloclone.Service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<Project> createProject(@Valid @RequestBody Project project) {
        Project savedProject = projectService.save(project);
        return ResponseEntity.ok(savedProject);
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.findAll();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        Project project = projectService.findById(id);
        if (project == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(project);
    }

    @GetMapping("/{id}/tasks")
    public ResponseEntity<List<Task>> getTasksByProjectId(@PathVariable Long id) {
        List<Task> tasks = projectService.findById(id).getTasks();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping("/{id}/tasks/create")
    public ResponseEntity<Task> createTask(@PathVariable Long id, @Valid @RequestBody Task task) {
        Project project = projectService.findById(id);
        if (project == null) {
            return ResponseEntity.notFound().build();
        }
        task.setProject(project);
        Task savedTask = taskService.save(task);
        return ResponseEntity.ok(savedTask);
    }
}