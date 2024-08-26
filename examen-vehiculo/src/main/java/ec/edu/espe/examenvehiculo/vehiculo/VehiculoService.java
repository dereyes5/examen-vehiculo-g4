package ec.edu.espe.examenvehiculo.vehiculo;

import ec.edu.espe.examenvehiculo.Modelo.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoService {
    @Autowired private VehiculoRepository repo;

    public List<Vehiculo> listAll() {
        return (List<Vehiculo>) repo.findAll();
    }

    public void save(Vehiculo vehiculo) {
        repo.save(vehiculo);
    }

    public Vehiculo get(Integer id) throws VehiculoNotFoundException {
        Optional<Vehiculo> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new VehiculoNotFoundException("Could not find any vehiculos with ID " + id);
    }
    public void delete(Integer id) throws VehiculoNotFoundException {
        if (repo.countById(id) == 0) {
            throw new VehiculoNotFoundException("Could not find any vehiculos with ID " + id);
        }
        repo.deleteById(id);
    }
}
