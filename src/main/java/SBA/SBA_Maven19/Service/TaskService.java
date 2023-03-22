package SBA.SBA_Maven19.Service;

import SBA.SBA_Maven19.Repository.Task;

import java.util.List;

public interface TaskService {
    Task createTask(Task task);

    Task getTaskById(Long id);

    List<Task> getAllTasks();

    Task updateTask(Long id, Task task);

    void deleteTask(Long id);
}
