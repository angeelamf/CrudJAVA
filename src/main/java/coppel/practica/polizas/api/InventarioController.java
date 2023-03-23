package coppel.practica.polizas.api;

import coppel.practica.polizas.entities.Empleado;
import coppel.practica.polizas.entities.Inventario;
import coppel.practica.polizas.models.ApiResponse;
import coppel.practica.polizas.models.responses.Message;
import coppel.practica.polizas.models.responses.Meta;
import coppel.practica.polizas.services.InventarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inventario")
public class InventarioController {

    private final InventarioService inventarioService;
    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @GetMapping
    public List<Inventario> findAll(){
        return inventarioService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Inventario> find(@PathVariable Integer id){
        return inventarioService.findById(id);
    }
    @PostMapping
    public ApiResponse save(@RequestBody Inventario inventario){
        try {
            return new ApiResponse<Inventario>(new Meta("OK"), inventarioService.saveInventario(inventario));
        }
        catch(Exception e) {
            return new ApiResponse<Message>(new Meta("FAILURE"), new Message("Ha ocurrido un error en al guardar el sku"));
        }
    }
    @PutMapping
    public ApiResponse update(@RequestBody Inventario inventario){
        try {
            return new ApiResponse<Inventario>(new Meta("OK"), inventarioService.saveInventario(inventario));
        }
        catch(Exception e) {
            return new ApiResponse<Message>(new Meta("FAILURE"), new Message("Ha ocurrido un error al intentar actualizar el sku"));
        }
    }
    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable Integer id){
        try {
            inventarioService.deleteInventario(id);
            return new ApiResponse<Message>(new Meta("OK"), new Message("Se eliminó correctamente el sku #" + id) );
        }
        catch(Exception e) {
            return new ApiResponse<Message>(new Meta("FAILURE"), new Message("Ha ocurrido un error al intentar eliminar el sku" + id));
        }

    }
}
