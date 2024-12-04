package MinistryToolsSpring.MinistryToolsSpring.Repository;

import MinistryToolsSpring.MinistryToolsSpring.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<User, Long> {

    // método para buscar usuario por nombre
    List<User> findByUserAndPassword(String user, String password);

    /*
     * Opcional: Búsqueda por nombre que ignore mayúsculas/minúsculas
     * List<User> findByUserIgnoreCase(String user);
     * 
     * // O usando "contiene" en lugar de "igual"
     * List<User> findByUserContaining(String keyword);
     */
}
