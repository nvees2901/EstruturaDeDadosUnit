package tlist;

class Tarefa {
    int id;
    String descricao;
    Tarefa proxima;

    public Tarefa(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        this.proxima = null;
    }
}
