package pl.coderslab.charity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.Entity.Donation;

public interface DonationRepository extends JpaRepository<Donation,Long> {


}