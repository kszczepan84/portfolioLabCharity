package pl.coderslab.charity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.Entity.Status;

public interface DonationStatusRepository extends JpaRepository<Status,Long> {

//    @Modifying
//    @Transactional
//    @Query(value="INSERT INTO status_donations (status_id, donations_id) VALUES (:statusId,:donationId)",nativeQuery=true)
//    void insertStatusDonationById(Long statusId,Long donationId);
}
