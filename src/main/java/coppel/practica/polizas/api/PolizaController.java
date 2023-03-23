package coppel.practica.polizas.api;

import coppel.practica.polizas.entities.Poliza;
import coppel.practica.polizas.models.ApiResponse;
import coppel.practica.polizas.models.PolizaDetalle;
import coppel.practica.polizas.models.responses.Message;
import coppel.practica.polizas.models.responses.Meta;
import coppel.practica.polizas.services.PolizaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestController
@RequestMapping("/api/poliza")
public class PolizaController {

    private static final Logger logger = LoggerFactory.getLogger(PolizaController.class);
    private final PolizaService polizaService;

    public PolizaController(PolizaService polizaService) { this.polizaService = polizaService; }

    /*@GetMapping
    public List<Poliza> findAll(){
        return polizaService.findAll();
    }*/
    @GetMapping
    public List<PolizaDetalle> findAll(){
        return polizaService.findAllWithDetail();
    }

    @GetMapping("/{id}")
    public ApiResponse find(@PathVariable Integer id){
        //return polizaService.findById(id);
        try {
            return new ApiResponse<PolizaDetalle>(new Meta("OK"), polizaService.findDetailedById(id).get());
        }
        catch(Exception e) {
            return new ApiResponse<Message>(new Meta("FAILURE"), new Message("Ha ocurrido un error al buscar de póliza: " + e.getMessage()));
        }
    }
    @PostMapping
    public ApiResponse save(@RequestBody Poliza poliza) throws Exception {
        try {
            return new ApiResponse<PolizaDetalle>(new Meta("OK"), polizaService.savePoliza(poliza));
        }
        catch(Exception e) {
            logger.info(e.getMessage());
            return new ApiResponse<Message>(new Meta("FAILURE"), new Message("Ha ocurrido un error al grabar de póliza: " + e.getMessage()));
        }
    }
    @PutMapping
    public Poliza update(@RequestBody Poliza poliza){ return polizaService.updatePoliza(poliza); }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        polizaService.deletePoliza(id);
    }
}
