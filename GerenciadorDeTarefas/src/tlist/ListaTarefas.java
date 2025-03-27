package tlist;

class ListaTarefas {
    private Tarefa head;
    private int contador;

    public ListaTarefas() {
        this.head = null;
        this.contador = 1;
    }

    public void adicionarTarefa(String descricao) {
        Tarefa novaTarefa = new Tarefa(contador++, descricao);
        if (head == null) {
            head = novaTarefa;
        } else {
            Tarefa atual = head;
            while (atual.proxima != null) {
                atual = atual.proxima;
            }
            atual.proxima = novaTarefa;
        }
        System.out.println("Tarefa adicionada com sucesso!");
    }

    public void editarTarefa(int id, String novaDescricao) {
        Tarefa atual = head;
        while (atual != null) {
            if (atual.id == id) {
                atual.descricao = novaDescricao;
                System.out.println("Tarefa editada com sucesso!");
                return;
            }
            atual = atual.proxima;
        }
        System.out.println("Tarefa não encontrada!");
    }

    public void removerTarefa(int id) {
        if (head == null) {
            System.out.println("Lista vazia!");
            return;
        }
        if (head.id == id) {
            head = head.proxima;
            System.out.println("Tarefa removida com sucesso!");
            return;
        }
        Tarefa atual = head;
        while (atual.proxima != null && atual.proxima.id != id) {
            atual = atual.proxima;
        }
        if (atual.proxima != null) {
            atual.proxima = atual.proxima.proxima;
            System.out.println("Tarefa removida com sucesso!");
        } else {
            System.out.println("Tarefa não encontrada!");
        }
    }

    public void listarTarefas() {
        if (head == null) {
            System.out.println("Nenhuma tarefa pendente.");
            return;
        }
        Tarefa atual = head;
        while (atual != null) {
            System.out.println("[" + atual.id + "] " + atual.descricao);
            atual = atual.proxima;
        }
    }

    public void buscarTarefa(int id) {
        Tarefa atual = head;
        while (atual != null) {
            if (atual.id == id) {
                System.out.println("Tarefa encontrada: [" + atual.id + "] " + atual.descricao);
                return;
            }
            atual = atual.proxima;
        }
        System.out.println("Tarefa não encontrada!");
    }
}