package dev.emanuel.cadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

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
    @GetMapping("/ninjaID")
    public String ninjaID(){
        return "Ninja ID";
    }

    // Mostrar todos os ninjas(READ)
    @GetMapping("/todos")
    public String mostrarNinjas(){
        return "Lista de ninjas";
    }

    // Alterar dados dos Ninjas(UPDATE)
    @PutMapping("/editarNinja")
    public String editarNinja(){
        return "Editado com sucesso!";
    }

    // Deletar Ninja(DELETE)
    @DeleteMapping("/deletarID")
    public String apagarNinjaPorId(){
        return "Apagado com sucesso!";
    }




}
