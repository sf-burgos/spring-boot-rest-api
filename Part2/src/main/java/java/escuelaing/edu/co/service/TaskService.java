package java.escuelaing.edu.co.service;

import java.escuelaing.edu.co.data.Task;
import java.escuelaing.edu.co.dto.TaskDto;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface TaskService {

    Task create(TaskDto taskDto);

    Task findById(UUID id);

    Collection<Task> all();

    Task deleteById(UUID id);

    Task update(TaskDto taskDto, UUID id);
}

