package SBA.SBA_Maven19;


import SBA.SBA_Maven19.Repository.Task;
import SBA.SBA_Maven19.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class defaultTaskContent implements CommandLineRunner {

    private TaskRepository taskRepository;

    public defaultTaskContent(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Task> tasks = Arrays.asList(
                new Task(1L, "Learn Spring", "To have a decent understanding of Springboot", false),
                new Task(2L, "Learn Driving", "To learn with someone somewhere", false),
                new Task(3L, "Go for a Walk", "To walk instead of using public transportation", false),
                new Task(4L, "Cook Food", "To cook some basic food", false),
                new Task(5L, "Get Hired", "To get hired by the year-end 2022", true)
        );
        taskRepository.saveAll(tasks);
    }
}