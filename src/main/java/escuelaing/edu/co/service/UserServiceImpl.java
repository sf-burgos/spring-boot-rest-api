 package escuelaing.edu.co.service;

import escuelaing.edu.co.data.User;
import escuelaing.edu.co.dto.UserDto;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
public class UserServiceImpl implements UserService {

    private final HashMap<Long, User> users = new HashMap<>();

    @Override
    public User create(User user) {
        return users.put(user.getId(), user);
    }

    @Override
    public User findById(String id) {
        if (users.containsKey(id)){
            return users.get(id);
        }
        return null;
    }

    @Override
    public List<User> all() {
        return (List)users;
    }

    @Override
    public void deleteById(String id) {
        users.remove(id);
    }

    @Override
    public User update(User user, Long userId) {
        return users.put(userId, user);
    }
    
    
    
    
    
}
