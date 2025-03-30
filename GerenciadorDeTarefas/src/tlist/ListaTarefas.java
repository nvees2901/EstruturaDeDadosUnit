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
        System.out.println("Tarefa adicionada com sucesso! ID: " + (contador - 1));
    }


    public void editarTarefa(int id, String novaDescricao) {
        Tarefa atual = head;
        while (atual != null) {
            if (atual.id == id) {
                String descricaoAntiga = atual.descricao; // Guardar a descrição antiga
                atual.descricao = novaDescricao;
                System.out.println("Tarefa editada com sucesso!");
                System.out.println("Antes: [" + id + "] " + descricaoAntiga);
                System.out.println("Agora: [" + id + "] " + novaDescricao);
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
        boolean encontrada = false;
        String idsDisponiveis = "";

        while (atual != null) {
            idsDisponiveis += atual.id + " ";
            if (atual.id == id) {
                System.out.println("Tarefa encontrada: [" + atual.id + "] " + atual.descricao);
                encontrada = true;
                break;
            }
            atual = atual.proxima;
        }

        if (!encontrada) {
            System.out.println("Tarefa não encontrada! IDs disponíveis: " + (idsDisponiveis.isEmpty() ? "Nenhum" : idsDisponiveis));
        }
    }

}