package pe.edu.i202221115.cl1_jpa_data_pillco_david.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.i202221115.cl1_jpa_data_pillco_david.entity.CountryLanguageId;

public interface CountryRepository extends JpaRepository<CountryLanguageId, String> {
}
