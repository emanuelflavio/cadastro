package dev.emanuel.cadastroDeNinjas.Missoes;


import dev.emanuel.cadastroDeNinjas.Ninjas.NinjaDTO;
import dev.emanuel.cadastroDeNinjas.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissoesDTO {


    private long id;
    private String nomeDaMissao;
    private rankMissoes rankMissoes;
    private List<NinjaModel> ninjas;
}
