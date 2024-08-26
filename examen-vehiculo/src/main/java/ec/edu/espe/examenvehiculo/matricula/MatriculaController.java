package ec.edu.espe.examenvehiculo.matricula;
import ec.edu.espe.examenvehiculo.Modelo.Matricula;
import ec.edu.espe.examenvehiculo.agencia.AgenciaRepository;
import ec.edu.espe.examenvehiculo.vehiculo.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
public class MatriculaController {
    @Autowired private MatriculaService service;
    @Autowired
    private MatriculaRepository matriculaRepository;
    @Autowired
    private AgenciaRepository agenciaRepository;
    @Autowired
    private VehiculoRepository vehiculoRepository;

    @GetMapping("/matriculas")
    public String showMatriculaList(Model model) {
        List<Matricula> listMatriculas = service.listAll();
        model.addAttribute("listMatriculas", listMatriculas);

        return "matriculas";
    }
    @GetMapping("/matriculas/new")
    public String showNewForm(Model model) {
        model.addAttribute("matricula", new Matricula());
        model.addAttribute("vehiculos_get", vehiculoRepository.findAll());
        model.addAttribute("agencias", agenciaRepository.findAll());
        model.addAttribute("pageTitle", "Add New Matricula");
        return "matricula_form";
    }
    @PostMapping("/matriculas/save")
    public String saveMatricula(Matricula matricula, RedirectAttributes ra) {
        service.save(matricula);
        ra.addFlashAttribute("message", "The matricula has been saved successfully.");
        return "redirect:/matriculas";
    }
    @GetMapping("/matriculas/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Matricula matricula = service.get(id);
            model.addAttribute("matricula", matricula);
            model.addAttribute("vehiculos_get", vehiculoRepository.findAll());
            model.addAttribute("agencias", agenciaRepository.findAll());
            model.addAttribute("pageTitle", "Edit Matricula (ID: " + id + ")");

            return "matricula_form";
        } catch (RuntimeException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/matriculas";
        } catch (MatriculaNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/matriculas/delete/{id}")
    public String deleteMatricula(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "The matricula ID " + id + " has been deleted.");
        } catch (RuntimeException | MatriculaNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());

        }
        return "redirect:/matriculas";
    }
}
