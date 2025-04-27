package dev.emanuel.cadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    // POST -- Mandar uma requisição para CRIAR uma missão
    // Criar uma missão
    @PostMapping("/criar")
    public String criarMissao(){
        return "Criado com sucesso!";
    }

    // PUT -- Mandar uma requisição para editar uma missão
    // Atualiza uma missao
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Alterado com sucesso!";
    }

    // GET -- Mandar uma requisição para mostrar as missoes
    // Busca todas as missões
    @GetMapping("/todos")
    public String mostrarTodasMissoes(){
        return "Lista de missoes";
    }

    // GET -- Mandar uma requisição para mostrar as missoes por id
    //Buscar uma missao por id
    @GetMapping("/mostrarPorId")
    public String mostrarPorId(){
        return "Missao por ID";
    }

    // DELETE -- Mandar uma requisição para apagar uma missão
    // Apaga uma missão
    @DeleteMapping("/apagar")
    public String deletarMissao(){
        return "Apagado com sucesso!";
    }

}
