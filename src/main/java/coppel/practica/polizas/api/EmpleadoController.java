package coppel.practica.polizas.api;

import coppel.practica.polizas.entities.Empleado;
import coppel.practica.polizas.models.ApiResponse;
import coppel.practica.polizas.models.responses.Meta;
import coppel.practica.polizas.services.EmpleadoService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoController {

    private final EmpleadoService empleadoService;
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public ApiResponse<List<Empleado>> findAllEmpleados(){
        return new ApiResponse<List<Empleado>>(new Meta("Ok"), empleadoService.findAll());
    }
    @GetMapping("/{id}")
    public Optional<Empleado> find(@PathVariable Integer id){
        return empleadoService.findById(id);
    }
    @PostMapping
    public Empleado save(@RequestBody Empleado empleado){
        return empleadoService.saveEmpleado(empleado);
    }
    @PutMapping
    public Empleado update(@RequestBody Empleado empleado){
        return empleadoService.saveEmpleado(empleado);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){ empleadoService.deleteEmpleado(id); }
}
