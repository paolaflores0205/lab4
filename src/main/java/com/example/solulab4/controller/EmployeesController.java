package com.example.solulab4.controller;

import com.example.solulab4.entity.Employees;
import com.example.solulab4.entity.Jobs;
import com.example.solulab4.repository.DepartmentsRepository;
import com.example.solulab4.repository.EmployeesRepository;
import com.example.solulab4.repository.JobsRepository;
import com.example.solulab4.repository.LocationsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/empleados")
public class EmployeesController {

    final DepartmentsRepository departmentsRepository;
    final JobsRepository jobsRepository;
    final EmployeesRepository employeesRepository;
    final LocationsRepository locationsRepository;

    public EmployeesController(DepartmentsRepository departmentsRepository,
                               JobsRepository jobsRepository,
                               EmployeesRepository employeesRepository,
                               LocationsRepository locationsRepository) {
        this.departmentsRepository = departmentsRepository;
        this.jobsRepository = jobsRepository;
        this.employeesRepository = employeesRepository;
        this.locationsRepository = locationsRepository;
    }

    @GetMapping("/lista")
    public String listarEmpleados(Model model,
                                  @RequestParam(name = "buscar", required=false) String buscar){
        List<Employees> listaEmpleados;

        if(buscar != null && !buscar.isEmpty()){
            listaEmpleados = employeesRepository.listaFiltros(buscar);
        }else{
            listaEmpleados = employeesRepository.findAll();
        }
        model.addAttribute("listaEmpleados", listaEmpleados);
        model.addAttribute("busquedaAnterior", buscar);
        return "empleados/lista";
    }

    @GetMapping("/editar")
    public String editarEm(Model model, @RequestParam("id") int id){

        Optional<Employees> optEm = employeesRepository.findById(id);


        if(optEm.isPresent()){
            Employees obj = optEm.get();
            model.addAttribute("employee", obj);
            model.addAttribute("listaJobs",jobsRepository.findAll());
            model.addAttribute("listaDepartments",departmentsRepository.findAll());
            model.addAttribute("listaLocations",locationsRepository.findAll());
            return "empleados/editFrm";
        } else {
            return "redirect:/empleados/lista";
        }

    }
    @PostMapping("/guardarCambios")
    public String guardarNuevoEmployee(@RequestParam("depId") Integer depId,
                                       @RequestParam("employeeId") Integer employeeId,
                                       @RequestParam("jobId") String jobId){
        employeesRepository.actualizarEmployee(depId,jobId,employeeId);
        return "redirect:/empleados/lista";
        /*
        Luego de guardar, redireccionamos a la lista de transportistas
        con redirect
        */
    }



    @GetMapping("/nuevo")
    public String nuevoEmFrm(Model model){

        model.addAttribute("listaJobs",jobsRepository.findAll());
        model.addAttribute("listaDepartments",departmentsRepository.findAll());
        model.addAttribute("listaEmployees",employeesRepository.findAll());
        model.addAttribute("fechaHoy", LocalDate.now());

        return  "empleados/newFrm";
    }

    @PostMapping("/guardarNuevo")
    public String guardarEm(Employees employee){
        employeesRepository.save(employee);
        return "redirect:/empleados/lista";
    }

    @GetMapping("/borrar")
    public String borrarEmployee(Model model, @RequestParam("id") int id){

        Optional<Employees> opt = employeesRepository.findById(id);

        if(opt.isPresent()){
            employeesRepository.deleteById(id);
        }
        return "redirect:/empleados/lista";
    }









}
