package dev.emanuel.cadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Mensagem de boas vindas",
            description = "Essa rota da uma mensagem de boas " +
                    "vindas para quem acessa ela")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja",
    description = "Rota cria um novo ninja e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
            description = "ninja criado com sucesso"),
            @ApiResponse(responseCode = "400",
            description = "erro na criação do ninja")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja =  ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Criada com sucesso! " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    }

    // Mostrar Ninja por ID(READ)
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista um ninja por id",
            description = "Rota lista um ninja pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "400",
                    description = "Ninja não encontrado")
    })
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
    @Operation(summary = "Listar todos os ninjas",
            description = "Rota lista todos os ninjas que estão no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "ninjas listados com sucesso"),
            @ApiResponse(responseCode = "400",
                    description = "erro ao mostrar ninja")
    })
    public ResponseEntity<List<NinjaDTO>> mostrarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.mostrarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // Alterar dados dos Ninjas(UPDATE)
    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera o ninja por id",
            description = "Rota altera um ninja pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "ninja alterado com sucesso"),
            @ApiResponse(responseCode = "400",
                    description = "Ninja não encontrado")
    })
    public ResponseEntity<?> editarNinja(
            @Parameter(description = "Usuario manda o id no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuario manda os dados do ninja a ser atualizado no corpo da requisição")
            @RequestBody NinjaDTO ninjaAtualizado) {
        NinjaDTO ninja = ninjaService.editarNinja(id, ninjaAtualizado);
        if(ninja != null){
            return ResponseEntity.ok(ninja);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja com o id: " + id + " não encontrado no banco de dados !");
    }

    // Deletar Ninja(DELETE)
    @DeleteMapping("/apagar/{id}")
    @Operation(summary = "Deleta um ninja",
            description = "Rota deleta um ninja e exclui no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "ninja apagado com sucesso"),
            @ApiResponse(responseCode = "400",
                    description = "erro na deleção do ninja")
    })
    public ResponseEntity<String> apagarNinjaPorId(@PathVariable Long id){
        if(ninjaService.listarNinjaPorId(id) != null){
            ninjaService.apagarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com id: " + id + " apagado com sucesso!");
        }
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o id " + id + " não foi encontrado!");
    }




}
