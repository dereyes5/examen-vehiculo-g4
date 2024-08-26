package ec.edu.espe.examenvehiculo.vehiculo;

import ec.edu.espe.examenvehiculo.Modelo.Vehiculo;
import org.springframework.data.repository.CrudRepository;

public interface VehiculoRepository extends CrudRepository<Vehiculo, Integer> {
    public Long countById(Integer id);
}
