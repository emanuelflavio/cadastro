package dev.emanuel.cadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {


    private final NinjaService ninjaService;

    public NinjaControllerUi(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // Mostrar todos os ninjas(READ)
    @GetMapping("/listar")
    public String mostrarNinjas(Model model){
        List<NinjaDTO> ninjas = ninjaService.mostrarNinjas();
        model.addAttribute("ninjas", ninjas);
        return "listarNinjas";  // tem que retornar o nome da pagina que renderiza
    }

    @GetMapping("/apagar/{id}")
    public String apagarNinjaPorId(@PathVariable Long id){
      ninjaService.apagarNinjaPorId(id);
      return "redirect:/ninjas/ui/listar";
    }


    @GetMapping("/listar/{id}")
    public String listarNinjaPorId(@PathVariable Long id, Model model){
        NinjaDTO ninja = ninjaService.listarNinjaPorId(id);
        if(ninja != null){
            model.addAttribute("ninja", ninja);
            return "detalhesNinja";
        }
        model.addAttribute("mensagem", "Ninja não encontrado!");
        return "listarNinjas";
    }

    @GetMapping("/adicionar")
    public String mostrarFormularioNinja(Model model){
        model.addAttribute("ninja", new NinjaDTO());
        return "adicionarNinja";
    }

    @PostMapping("/salvar")
    public String salvarNinja(@ModelAttribute NinjaDTO ninjaDTO, RedirectAttributes redirect){
        ninjaService.criarNinja(ninjaDTO);
        redirect.addFlashAttribute("mensagem", "Ninja adicionado com sucesso!");
        return "redirect:/ninjas/ui/listar";
    }


}
