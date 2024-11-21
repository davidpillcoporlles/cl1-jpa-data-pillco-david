package pe.edu.i202221115.cl1_jpa_data_pillco_david.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class CountryLanguageId implements Serializable {

    private String country;
    private String language;

    public CountryLanguageId(String country, String language) {
        this.country = country;
        this.language = language;
    }

    public CountryLanguageId() {

    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryLanguageId that = (CountryLanguageId) o;
        return Objects.equals(country, that.country) &&
                Objects.equals(language, that.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, language);
    }
}