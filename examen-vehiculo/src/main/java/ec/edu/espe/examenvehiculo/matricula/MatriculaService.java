package ec.edu.espe.examenvehiculo.matricula;
import ec.edu.espe.examenvehiculo.Modelo.Matricula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MatriculaService {
    @Autowired private MatriculaRepository repo;
    public List<Matricula> listAll() {
        return (List<Matricula>) repo.findAll();
    }
    public void save(Matricula matricula) {
        repo.save(matricula);
    }
    public Matricula get(Integer id) throws MatriculaNotFoundException {
        Optional<Matricula> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new MatriculaNotFoundException("Could not find any matriculas with ID " + id);
    }
    public void delete(Integer id) throws MatriculaNotFoundException {
        if (repo.countById(id) == 0) {
            throw new MatriculaNotFoundException("Could not find any matriculas with ID " + id);
        }
        repo.deleteById(id);
    }
}
