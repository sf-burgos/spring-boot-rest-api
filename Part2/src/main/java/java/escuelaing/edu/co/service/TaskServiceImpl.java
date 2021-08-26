package java.escuelaing.edu.co.service;

import java.escuelaing.edu.co.data.Task;
import java.escuelaing.edu.co.dto.TaskDto;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;


public class TaskServiceImpl implements TaskService {
    
    private final HashMap<UUID, Task> tasks = new HashMap<>();

    @Override
    public Task create(TaskDto taskDto) {
        Task taskCreate = new Task (taskDto);
        return tasks.put(taskCreate.getId(), taskCreate);
    }

    @Override
    public Task findById(UUID id) {
        return tasks.get(id);
    }

    @Override
    public Collection<Task> all() {
        return tasks.values();
    }

    @Override
    public Task deleteById(UUID id) {
        return tasks.remove(id);
        
    }

    @Override
    public Task update(TaskDto taskDto, UUID id) {
        Task taskToChance = tasks.get(id);
        taskToChance.setTaskDto(taskDto);
        tasks.remove(id);
        tasks.put(id, taskToChance);
        return taskToChance;
    }


  
       
}
