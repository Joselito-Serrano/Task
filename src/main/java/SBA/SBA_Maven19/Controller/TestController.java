package SBA.SBA_Maven19.Controller;

import SBA.SBA_Maven19.Repository.Task;
import SBA.SBA_Maven19.Service.TaskService;
import SBA.SBA_Maven19.Service.TaskServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class TestController {
    private final TaskService taskService;

    @Autowired
    public TestController(TaskServiceImple taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/home")
    public String view_default(Model model) {
        model.addAttribute("Task", taskService.getAllTasks());
        return "index";
    }

    @GetMapping("/new-task")
    public String view_newtask() {
        return "new-task";
    }

    @PostMapping("/home")
    public String save_newtask(@ModelAttribute Task task, Model model) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        task.setId(Long.parseLong(dtf.format(now)));
        task.setCompleted(false);
        taskService.createTask(task);

        return "redirect:/home";
    }

    @GetMapping("/show-task/{id}")
    public String edit_task(@PathVariable Long id, Model model) {
        model.addAttribute("Task", taskService.getTaskById(id));
        return "edit-task";
    }

    @PutMapping("/home")
    public String save_editedtask(@ModelAttribute Task task, Model model) {
        taskService.updateTask(task.getId(), task);
        return "redirect:/home";
    }

    @DeleteMapping("/delete-task/{id}")
    public String delete_task(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/home";
    }

}