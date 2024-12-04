package MinistryToolsSpring.MinistryToolsSpring.Controller;

import MinistryToolsSpring.MinistryToolsSpring.Model.User;
import MinistryToolsSpring.MinistryToolsSpring.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity< List<User> > findAll(){
        try {
            List<User> listUsers = userService.findAll();
            return ResponseEntity.ok(listUsers);
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity< User > findUserById(@PathVariable Long id){
        try{
            User user = userService.findUserById(id);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
           return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("create")
    public ResponseEntity< User > createUser(@RequestBody User user){
        try {
            User createuser = userService.createUser(user);
            return ResponseEntity.ok(createuser);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        try {
            String delete = userService.deleteById(id);
            return ResponseEntity.ok(delete);
        } catch (Exception e) {
          return ResponseEntity.notFound().build();
        }
    }
    @PutMapping
    public  ResponseEntity<User> updateUserById(@RequestBody User user){
        try {
            User update = userService.updateUserById(user);
            return ResponseEntity.ok(update);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
