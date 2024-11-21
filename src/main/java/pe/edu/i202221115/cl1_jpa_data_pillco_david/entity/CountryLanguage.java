package pe.edu.i202221115.cl1_jpa_data_pillco_david.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class CountryLanguage {
    @EmbeddedId
    private CountryLanguageId id;
    @Id
    @ManyToOne
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code")
    private Country country;
    @Id
    private String language;
    public String isOfficial ;
    private Double percentage;


}
