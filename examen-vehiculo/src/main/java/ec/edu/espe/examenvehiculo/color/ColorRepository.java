package ec.edu.espe.examenvehiculo.color;

import ec.edu.espe.examenvehiculo.Modelo.Color;
import org.springframework.data.repository.CrudRepository;

public interface ColorRepository extends CrudRepository<Color, Integer> {
    public Long countById(Integer id);
}
