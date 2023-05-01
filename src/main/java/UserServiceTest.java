import Dao.UserDaoImpl;
import Model.User;
import Service.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserDaoImpl userDaoImpl;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    private User user1ForTest = new User("Паша", 94);
    private User user2ForTest = new User("Слава", 58);
    private List <User> userList = Arrays.asList(
            user1ForTest,
            new User("Петя", 23));

    @Test
    void checkUserExistShouldReturnTrue() {
        when(userDaoImpl.getUserList()).thenReturn(userList);
        Assertions.assertTrue(userServiceImpl.checkUserExist(user1ForTest));
    }
    @Test
    void checkUserExistShouldReturnFalse() {
        when(userDaoImpl.getUserList()).thenReturn(userList);
        Assertions.assertTrue(userServiceImpl.checkUserExist(user2ForTest));
    }
}
