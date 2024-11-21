package pe.edu.i202221115.cl1_jpa_data_pillco_david.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Country {
    @Id
    private String code;
    private String name;
    public String continent ;
    private String region;
    private Double surfaceArea;
    private Integer indepyear;
    private Integer population;
    private Double lifeExpectancy;
    private Double gnp;
    private Double gnpOld;
    private String localName;
    private String governmentForm;
    private String headOfState;
    private Integer capital;
    private String code2;

    @OneToMany(mappedBy = "country", cascade = {CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval=true)
    public List<City> cities;

    @OneToMany(mappedBy = "country", cascade = {CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval=true)
    public List<CountryLanguage> languages;


}
