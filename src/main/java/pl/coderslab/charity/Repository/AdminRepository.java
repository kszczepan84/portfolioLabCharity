package pl.coderslab.charity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.Entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    Admin findByEmail(String email);
}
