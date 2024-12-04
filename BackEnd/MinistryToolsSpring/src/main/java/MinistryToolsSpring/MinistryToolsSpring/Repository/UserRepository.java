package MinistryToolsSpring.MinistryToolsSpring.Repository;

import MinistryToolsSpring.MinistryToolsSpring.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByUser(String user);
}
