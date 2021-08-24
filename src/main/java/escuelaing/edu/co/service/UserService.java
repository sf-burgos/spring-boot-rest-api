package escuelaing.edu.co.service;

import escuelaing.edu.co.data.User;
import java.util.List;

public interface UserService {
    User create( User user);

    User findById( String id );
        
    List<User> all();

    void deleteById( String id );

    User update( User user, Long userId );
}
