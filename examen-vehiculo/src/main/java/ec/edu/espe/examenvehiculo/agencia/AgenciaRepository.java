package ec.edu.espe.examenvehiculo.agencia;

import ec.edu.espe.examenvehiculo.Modelo.Agencia;
import org.springframework.data.repository.CrudRepository;

public interface AgenciaRepository extends CrudRepository<Agencia, Long> {
    public Long countById(Long id);
}
