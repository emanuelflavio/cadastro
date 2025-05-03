package dev.emanuel.cadastroDeNinjas.Missoes;

import dev.emanuel.cadastroDeNinjas.Ninjas.NinjaDTO;
import dev.emanuel.cadastroDeNinjas.Ninjas.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private final MissoesService missaoService;

    public MissoesController(MissoesService missaoService) {
        this.missaoService = missaoService;
    }

    // POST -- Mandar uma requisição para CRIAR uma missão
    // Criar uma missão
    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missoesDTO) {
        MissoesDTO novaMissao = missaoService.criarMissao(missoesDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missao criada com sucesso!" + novaMissao.getNomeDaMissao());

    }

    // PUT -- Mandar uma requisição para editar uma missão
    // Atualiza uma missao
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissao(@PathVariable long id, @RequestBody MissoesDTO missoesDTO) {
        MissoesDTO missoes = missaoService.editarMissao(missoesDTO, id);
        if(missoes != null){
            return ResponseEntity.ok(missoes);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Missão com o id " + id + " não encontrado!");
    }

    // GET -- Mandar uma requisição para mostrar as missoes
    // Busca todas as missões
    @GetMapping("/todos")
    public ResponseEntity<List<MissoesDTO>> mostrarTodasMissoes() {
        List<MissoesDTO> missoes = missaoService.mostrarMissoes();
        return ResponseEntity.ok(missoes);
    }

    // GET -- Mandar uma requisição para mostrar as missoes por id
    //Buscar uma missao por id
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> mostrarPorId(@PathVariable long id) {
        MissoesDTO missao = missaoService.mostrarMissaoPorId(id);
        if(missao != null){
            return ResponseEntity.ok(missao);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja com o id " + id + " não existe!");
    }

    // DELETE -- Mandar uma requisição para apagar uma missão
    // Apaga uma missão
    @DeleteMapping("/apagar")
    public ResponseEntity<String> deletarMissao(@PathVariable long id) {
        if(missaoService.mostrarMissaoPorId(id) != null){
            missaoService.apagarMissaoPorId(id);
            return ResponseEntity.ok("Ninja com o id "+id+" apagado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("O ninja com o id "+id+" não foi encontrado!");
    }

}
