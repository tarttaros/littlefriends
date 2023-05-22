package proyecto.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Category implements Serializable
{
    //Atributo id mascota
    @JsonIgnore
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Integer id;

    //Atributo Descripcion de la categoria
    @Column(nullable = false,length = 45)
    @Length(min = 6, max = 45, message = "La descripcio de la categoria debe tener minimo 6 caracteres")
    @NotBlank(message = "El campo está vacío, debe ingresar una descripcion")
    private String description;

    public Category(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    //Relaciones

    //lista de categorias producto
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category",cascade = CascadeType.ALL)
    List<ProductCategory> productCategories;
}
