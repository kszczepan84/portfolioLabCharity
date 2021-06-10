package pl.coderslab.charity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.Entity.Institution;

import java.util.ArrayList;
import java.util.List;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {


    default List<Institution> showInstitutions() {
        List<Institution> institutionsList = new ArrayList<>();
        institutionsList.add(new Institution(1L, "Fundacja \"Dbam o Zdrowie\"", "Cel i misja: Pomoc dzieciom z ubogich rodzin."));
        institutionsList.add(new Institution(2L, "Fundacja \"A kogo\"", "Cel i misja: Pomoc wybudzaniu dzieci ze śpiączki."));
        institutionsList.add(new Institution(3L, "Fundacja “Dla dzieci\"", "Cel i misja: Pomoc osobom znajdującym się w trudnej sytuacji życiowej."));
        institutionsList.add(new Institution(4L, "Fundacja \"Bez domu\"", "Cel i misja: Pomoc dla osób nie posiadających miejsca zamieszkania"));
        return institutionsList;
    }

}
