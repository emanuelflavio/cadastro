package dev.emanuel.cadastroDeNinjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja) {
        return ninjaService.criarNinja(ninja);
    }

    // Mostrar Ninja por ID(READ)
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjaPorId(@PathVariable Long id){
        return ninjaService.listarNinjaPorId(id);
    }

    // Mostrar todos os ninjas(READ)
    @GetMapping("/listar")
    public List<NinjaModel> mostrarNinjas(){
        return ninjaService.mostrarNinjas();
    }

    // Alterar dados dos Ninjas(UPDATE)
    @PutMapping("/alterar/{id}")
    public NinjaModel editarNinja(@PathVariable Long id, @RequestBody NinjaModel ninjaAtualizado) {
        return ninjaService.editarNinja(id, ninjaAtualizado);
    }

    // Deletar Ninja(DELETE)
    @DeleteMapping("/apagar/{id}")
    public void apagarNinjaPorId(@PathVariable Long id){
        ninjaService.apagarNinjaPorId(id);
    }




}
