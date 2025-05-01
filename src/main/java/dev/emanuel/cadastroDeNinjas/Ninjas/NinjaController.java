package dev.emanuel.cadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja =  ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Criada com sucesso! " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    }

    // Mostrar Ninja por ID(READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjaPorId(@PathVariable Long id){
        NinjaDTO ninja = ninjaService.listarNinjaPorId(id);
        if(ninja != null){
            return ResponseEntity.ok(ninja);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja com o " + id + " não existe no banco de dados !");
    }

    // Mostrar todos os ninjas(READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> mostrarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.mostrarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // Alterar dados dos Ninjas(UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> editarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        NinjaDTO ninja = ninjaService.editarNinja(id, ninjaAtualizado);
        if(ninja != null){
            return ResponseEntity.ok(ninja);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja com o id: " + id + " não encontrado no banco de dados !");
    }

    // Deletar Ninja(DELETE)
    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<String> apagarNinjaPorId(@PathVariable Long id){
        if(ninjaService.listarNinjaPorId(id) != null){
            ninjaService.apagarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com id: " + id + " apagado com sucesso!");
        }
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o id " + id + " não foi encontrado!");
    }




}
