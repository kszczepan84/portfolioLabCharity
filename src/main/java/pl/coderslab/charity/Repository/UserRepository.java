package pl.coderslab.charity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.Entity.Category;
import pl.coderslab.charity.Entity.User;

public interface UserRepository extends JpaRepository<User,Long> {


}
