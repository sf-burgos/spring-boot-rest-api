package escuelaing.edu.co.service;

import static com.sun.java.accessibility.util.EventID.KEY;
import escuelaing.edu.co.data.User;
import escuelaing.edu.co.dto.UserDto;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
public class UserServiceImpl implements UserService {

    private final HashMap<UUID, User> users = new HashMap<>();

    @Override
    public User findById(UUID id) {
        return users.get(id);
    }

    @Override
    public void deleteById(String id) {
        users.remove(id);
    }



    @Override
    public User create(UserDto userDto) {
        User userCreate = new User(userDto);
        return users.put(userCreate.getId(), userCreate);
    }

    @Override
    public Collection<User> all() {
        return users.values();
    }

    @Override
    public User update(UserDto userDto, UUID userId) {
        User userToChance = users.get(userId);
        userToChance.setUserDto(userDto);
        users.remove(userId);
        users.put(userId, userToChance);
        return userToChance;
    }



  



 

}
