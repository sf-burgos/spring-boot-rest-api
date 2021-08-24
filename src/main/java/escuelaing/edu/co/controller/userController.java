package escuelaing.edu.co.controller;

import escuelaing.edu.co.data.User;
import escuelaing.edu.co.dto.UserDto;
import escuelaing.edu.co.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/v1/user")
public class userController {
    private final UserService userService;

    @Autowired
    public userController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping
    public ResponseEntity<List<User>> all(){
        
        return null;
        
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<User> findByid (@PathVariable Long id){
        return null;
    }
    
    @PostMapping()
    public ResponseEntity<User> create (@RequestBody UserDto userDto){
        try {
            return (ResponseEntity<User>) ResponseEntity.status(HttpStatus.OK);
        }
        catch (Exception e){
            return (ResponseEntity<User>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<User> update (@RequestBody UserDto userDto, @PathVariable Long id){
        try {
            return (ResponseEntity<User>) ResponseEntity.status(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return (ResponseEntity<User>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
}
