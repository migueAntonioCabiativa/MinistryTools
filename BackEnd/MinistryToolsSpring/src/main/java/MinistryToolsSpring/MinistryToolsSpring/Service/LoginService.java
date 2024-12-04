package MinistryToolsSpring.MinistryToolsSpring.Service;


import MinistryToolsSpring.MinistryToolsSpring.Model.User;
import MinistryToolsSpring.MinistryToolsSpring.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public List<User> searchByNameAndPassword(String user, String password){
       return loginRepository.findByUserAndPassword(user, password);
    }


}
