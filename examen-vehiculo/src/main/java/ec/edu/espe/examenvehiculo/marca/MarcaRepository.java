package ec.edu.espe.examenvehiculo.marca;

import ec.edu.espe.examenvehiculo.Modelo.Marca;
import org.springframework.data.repository.CrudRepository;

public interface MarcaRepository extends CrudRepository<Marca, Integer> {
    public Long countById(Integer id);
}
