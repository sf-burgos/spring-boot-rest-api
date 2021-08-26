
package java.escuelaing.edu.co.controller;

import java.escuelaing.edu.co.data.Task;
import java.escuelaing.edu.co.dto.TaskDto;
import java.escuelaing.edu.co.service.TaskService;
import java.util.Collection;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/v1/task")
public class TaskController {
    
    @Autowired
    TaskService taskService;
    
    @GetMapping
     public ResponseEntity<Collection<Task>> all() {

        return new ResponseEntity<>(taskService.all(), HttpStatus.ACCEPTED);

    }
     
    @GetMapping("/{id}")
    public ResponseEntity<Task> findByid(@PathVariable UUID id) {
        return new ResponseEntity<>(taskService.findById(id), HttpStatus.ACCEPTED);
    }
    
    @PostMapping()
    public ResponseEntity<String> create(@RequestBody TaskDto taskDto) {
        taskService.create(taskDto);
        return new ResponseEntity<>("Task " + taskDto.getName() + " Create", HttpStatus.CREATED);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable("{id}") UUID id, @RequestBody TaskDto taskDto) {
        try {
            taskService.update(taskDto, id);
            return new ResponseEntity<>("Task " + taskDto.getName() + " Update", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return (ResponseEntity<String>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Task> deleteById (@PathVariable UUID id){
       
        return new ResponseEntity<> (taskService.deleteById(id) , HttpStatus.ACCEPTED);
    }
    
    
    
    
    

}
