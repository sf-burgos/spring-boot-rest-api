package escuelaing.edu.co.service;

import escuelaing.edu.co.data.User;
import escuelaing.edu.co.dto.UserDto;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface UserService {
    User create( UserDto userDto);

    User findById(UUID id );
        
    Collection<User> all();

    void deleteById(String id );

    User update( UserDto userDto, UUID userId );



  
}
