package dev.emanuel.cadastroDeNinjas.Missoes;

import dev.emanuel.cadastroDeNinjas.Ninjas.NinjaDTO;
import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesModel map(MissoesDTO missoesDTO) {
        MissoesModel missoesModel = new MissoesModel();
        missoesModel.setId(missoesDTO.getId());
        missoesModel.setNomeDaMissao(missoesDTO.getNomeDaMissao());
        missoesModel.setRankMissoes(missoesDTO.getRankMissoes());
        missoesModel.setNinja(missoesDTO.getNinjas());

        return missoesModel;
    }

    public MissoesDTO map(MissoesModel missoesModel) {
        MissoesDTO missoesDTO = new MissoesDTO();
        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setNomeDaMissao(missoesModel.getNomeDaMissao());
        missoesDTO.setRankMissoes(missoesModel.getRankMissoes());
        missoesDTO.setNinjas(missoesModel.getNinja());
        return missoesDTO;
    }
}
