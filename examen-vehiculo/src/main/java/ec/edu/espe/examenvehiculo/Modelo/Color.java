package ec.edu.espe.examenvehiculo.Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "color", schema = "matriculacionfinal")
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "smallint UNSIGNED not null")
    private Integer id;

    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}