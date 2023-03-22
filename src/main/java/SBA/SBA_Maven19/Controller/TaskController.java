package SBA.SBA_Maven19.Controller;

import SBA.SBA_Maven19.Repository.Task;
import SBA.SBA_Maven19.Service.TaskService;
import SBA.SBA_Maven19.Service.TaskServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskServiceImple taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/")
    public Task create(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping("/{id}")
    public Task findById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @GetMapping("/task")
    public List<Task> getAll() {
        return taskService.getAllTasks();
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}