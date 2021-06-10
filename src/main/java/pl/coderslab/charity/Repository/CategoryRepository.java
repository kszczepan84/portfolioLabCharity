package pl.coderslab.charity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {


}
