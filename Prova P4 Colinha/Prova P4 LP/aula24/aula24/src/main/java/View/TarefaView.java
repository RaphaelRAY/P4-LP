package View;

import java.util.List;

import model.TarefaModel;

public class TarefaView {
    public void exibirTarefas(List<TarefaModel> tarefas) {
        System.out.println("Lista de Tarefas:");
        for (TarefaModel tarefa : tarefas) {
            String status = tarefa.isConcluida() ? "[X]" : "[ ]";
            System.out.println(status + " " + tarefa.getDescricao());
        }
        System.out.println();
    }
    
    public String exibirTarefasInterface(List<TarefaModel> tarefas) {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Tarefas:\n");
        for (TarefaModel tarefa : tarefas) {
            String status = tarefa.isConcluida() ? "[X]" : "[ ]";
            sb.append(status + " " + tarefa.getDescricao()+"\n");
        }
        sb.append("\n");
        return sb.toString();
    }
}
