package dev.emanuel.cadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private final MissoesRepository missoesRepository;
    private final MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    //Listar todas as minhas missoes
    public List<MissoesDTO> mostrarMissoes(){
        List<MissoesModel> missoesModels = missoesRepository.findAll();
        return missoesModels.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    //Listar Ninja por id
    public MissoesDTO mostrarMissaoPorId(Long id){
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);
        return missoesModel.map(missoesMapper::map).orElse(null);
    }

    //Criar uma nova missão
    public MissoesDTO criarMissao(MissoesDTO missoesDTO){
        MissoesModel missao = missoesMapper.map(missoesDTO);
        missao = missoesRepository.save(missao);
        return missoesMapper.map(missao);
    }

    //Deletar uma missão
    public void apagarMissaoPorId(Long id){
        missoesRepository.deleteById(id);
    }

    // Atualizar as informações da missao
    public MissoesDTO editarMissao(MissoesDTO missoesDTO, Long id){
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);
        if(missoesModel.isPresent()){
            MissoesModel missao = missoesMapper.map(missoesDTO);
            missao.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missao);
            return missoesMapper.map(missaoSalva);
        }
        return null;
    }
}
