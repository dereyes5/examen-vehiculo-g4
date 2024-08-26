package ec.edu.espe.examenvehiculo.vehiculo;
import ec.edu.espe.examenvehiculo.Modelo.Vehiculo;
import ec.edu.espe.examenvehiculo.color.ColorRepository;
import ec.edu.espe.examenvehiculo.marca.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
@Controller
public class VehiculoController {
    @Autowired private VehiculoService service;
    @Autowired private ColorRepository colorRepository;
    @Autowired
    private MarcaRepository marcaRepository;

    @GetMapping("/vehiculos")
    public String showVehiculoList(Model model) {
        List<Vehiculo> listVehiculos = service.listAll();
        model.addAttribute("listVehiculos", listVehiculos);
        return "vehiculos";
    }
    @GetMapping("/vehiculos/new")
    public String showNewForm(Model model) {
        model.addAttribute("vehiculo", new Vehiculo());
        model.addAttribute("colores", colorRepository.findAll());
        model.addAttribute("marcas", marcaRepository.findAll());

        model.addAttribute("pageTitle", "Add New Vehiculo");
        return "vehiculo_form";
    }
    @PostMapping("/vehiculos/save")
    public String saveVehiculo(Vehiculo vehiculo, RedirectAttributes ra) {
        service.save(vehiculo);
        ra.addFlashAttribute("message", "The vehiculo has been saved successfully.");
        return "redirect:/vehiculos";
    }
    @GetMapping("/vehiculos/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Vehiculo vehiculo = service.get(id);
            model.addAttribute("vehiculo", vehiculo);
            model.addAttribute("colores", colorRepository.findAll());
            model.addAttribute("marcas", marcaRepository.findAll());
            model.addAttribute("pageTitle", "Edit Vehiculo (ID: " + id + ")");
            return "vehiculo_form";
        } catch (RuntimeException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/vehiculos";
        } catch (VehiculoNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/vehiculos/delete/{id}")
    public String deleteVehiculo(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "The vehiculo ID " + id + " has been deleted.");
        } catch (RuntimeException e) {
            ra.addFlashAttribute("message", e.getMessage());
        } catch (VehiculoNotFoundException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/vehiculos";
    }
}
