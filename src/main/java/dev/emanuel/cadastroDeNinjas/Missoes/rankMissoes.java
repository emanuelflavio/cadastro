package dev.emanuel.cadastroDeNinjas.Missoes;

public enum rankMissoes {
    D("Baixo", 2),
    C("Moderado", 3),
    B("Confortavel", 4),
    A("Dificil", 5),
    S("Altissimo", 12);

    private String descricao;
    private int dificuldade;

    rankMissoes(String descricao, int dificuldade) {
        this.descricao = descricao;
        this.dificuldade = dificuldade;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getDificuldade() {
        return dificuldade;
    }
}
