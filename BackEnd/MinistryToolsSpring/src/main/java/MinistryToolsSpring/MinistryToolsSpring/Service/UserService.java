package MinistryToolsSpring.MinistryToolsSpring.Service;

import MinistryToolsSpring.MinistryToolsSpring.Model.User;
import MinistryToolsSpring.MinistryToolsSpring.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User findUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }
    public User createUser(User user){
        return userRepository.save(user);
    }
    public String deleteById(Long id){
        try {
            userRepository.deleteById(id);
            return "ELIMINADO Usuario: "+id;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public User updateUserById(User user){
        User userBD = userRepository.findById(user.getId()).orElse(null);
        if (userBD != null){
            userBD.setUser(user.getUser());
            userBD.setName(user.getName());
            userBD.setPassword(user.getPassword());
            return userRepository.save(userBD);
        }
        return null;
    }

}
