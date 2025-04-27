package dev.emanuel.cadastroDeNinjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Criado com sucesso!";
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
    @PutMapping("/alterar")
    public String editarNinja(){
        return "Editado com sucesso!";
    }

    // Deletar Ninja(DELETE)
    @DeleteMapping("/apagar")
    public String apagarNinjaPorId(){
        return "Apagado com sucesso!";
    }




}
