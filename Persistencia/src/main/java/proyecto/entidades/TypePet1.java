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
public class TypePet1 implements Serializable
{
    //llave primaria de tipomascota
    @JsonIgnore
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_pet")
    private Integer id;

    //Atributo descripcion
    @Column(nullable = false,length = 100)
    @Length(min = 2, max = 100, message = "la descripcion debe tener mínimo 2 caracteres y máximo 80")
    @NotBlank(message = "El campo está vacío, debe ingresar una descripcion")
    private String descripcion;

    public TypePet1(String descripcion) {
        this.descripcion = descripcion;
    }

    public TypePet1(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    //Relaciones

    //lista mascotas
    @OneToMany(fetch =FetchType.LAZY,mappedBy = "typePet",cascade = CascadeType.ALL )
    private List<Pet> pets;

}
