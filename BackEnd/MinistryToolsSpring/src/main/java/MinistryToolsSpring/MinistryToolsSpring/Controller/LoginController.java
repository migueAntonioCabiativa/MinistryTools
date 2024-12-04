package MinistryToolsSpring.MinistryToolsSpring.Controller;

import MinistryToolsSpring.MinistryToolsSpring.Model.User;
import MinistryToolsSpring.MinistryToolsSpring.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    @Autowired
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login/search")
    public ResponseEntity<?> searchUser(@RequestParam String user, @RequestParam String password) {

        List<User> users = loginService.searchByNameAndPassword(user, password);

        if (!users.isEmpty()) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.status(404).body("Usuario: " + users + ", No Encontrado");
        }

    }

}
