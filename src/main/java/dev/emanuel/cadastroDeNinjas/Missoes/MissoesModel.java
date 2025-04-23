package dev.emanuel.cadastroDeNinjas.Missoes;

import dev.emanuel.cadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeDaMissao;
    private rankMissoes rankMissoes;
    private NinjaModel ninja;

    public MissoesModel() {
    }

    public MissoesModel(Long id, String nomeDaMissao, rankMissoes rankMissoes) {
        this.id = id;
        this.nomeDaMissao = nomeDaMissao;
        this.rankMissoes = rankMissoes;
    }

    public String getNomeDaMissao() {
        return nomeDaMissao;
    }

    public void setNomeDaMissao(String nomeDaMissao) {
        this.nomeDaMissao = nomeDaMissao;
    }

    public rankMissoes getRankMissoes() {
        return rankMissoes;
    }

    public void setRankMissoes(rankMissoes rankMissoes) {
        this.rankMissoes = rankMissoes;
    }
}
