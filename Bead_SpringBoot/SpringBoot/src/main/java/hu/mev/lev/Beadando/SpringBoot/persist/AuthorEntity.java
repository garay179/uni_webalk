package hu.mev.lev.Beadando.SpringBoot.persist;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@ToString
@Table(name = "authors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorEntity {
    @Min(1)
    @Id
    private Long ID;
    @NotBlank
    private String name;
    private Integer age;
    @JsonIgnore
    @OneToMany(mappedBy = "authorEntity")
    private List<BookEntity> books;
}
