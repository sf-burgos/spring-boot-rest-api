package escuelaing.edu.co.controller;

import escuelaing.edu.co.data.User;
import escuelaing.edu.co.dto.UserDto;
import escuelaing.edu.co.service.UserService;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
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
@RequestMapping("/v1/user")
public class userController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<Collection<User>> all() {

        return new ResponseEntity<>(userService.all(), HttpStatus.ACCEPTED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findByid(@PathVariable UUID id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.ACCEPTED);
    }

    @PostMapping()
    public ResponseEntity<String> create(@RequestBody UserDto userDto) {
        userService.create(userDto);
        return new ResponseEntity<>("User " + userDto.getName() + " Create", HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable("{id}") UUID id, @RequestBody UserDto userDto) {
        try {
            userService.update(userDto, id);
            return new ResponseEntity<>("User " + userDto.getName() + " Update", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return (ResponseEntity<String>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
