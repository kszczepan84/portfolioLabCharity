package pl.coderslab.charity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.Entity.Category;
import pl.coderslab.charity.Entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);

    @Query(value="SELECT user_id FROM users_roles INNER JOIN role r on users_roles.role_id = r.id WHERE r.name='ROLE_ADMIN'",nativeQuery = true)
    List<Long> selectUserByRoleAdmin();

    @Query(value="SELECT user_id FROM users_roles INNER JOIN role r on users_roles.role_id = r.id WHERE r.name='ROLE_USER'",nativeQuery = true)
    List<Long> selectUserByRoleUser();
}
