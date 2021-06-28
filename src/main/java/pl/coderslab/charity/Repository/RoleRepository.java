package pl.coderslab.charity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.Entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
