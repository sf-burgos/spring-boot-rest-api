package java.escuelaing.edu.co.data;

import java.escuelaing.edu.co.dto.TaskDto;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private TaskDto TaskDto;
    private Date createdAt;

    public Task() {
    }

    public Task(TaskDto TaskDto) {
        this.id = UUID.randomUUID();
        this.TaskDto = TaskDto;
        this.createdAt = new Date();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public TaskDto getTaskDto() {
        return TaskDto;
    }

    public void setTaskDto(TaskDto TaskDto) {
        this.TaskDto = TaskDto;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Task other = (Task) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id
                + ", TaskDto=" + TaskDto
                + ", createdAt=" + createdAt + '}';
    }

}
