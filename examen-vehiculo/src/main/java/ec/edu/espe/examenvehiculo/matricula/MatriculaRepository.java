package ec.edu.espe.examenvehiculo.matricula;
import ec.edu.espe.examenvehiculo.Modelo.Matricula;
import org.springframework.data.repository.CrudRepository;
public interface MatriculaRepository extends CrudRepository<Matricula, Integer> {
    public Long countById(Integer id);
}
