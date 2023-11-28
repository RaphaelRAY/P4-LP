package Controller;

import java.util.ArrayList;
import java.util.List;

import View.TarefaView;
import model.TarefaModel;

public class TarefaController {
    private List<TarefaModel> tarefas = new ArrayList<>();
    private TarefaView view = new TarefaView();

    public void adicionarTarefa(String descricao) {
        TarefaModel tarefa = new TarefaModel(descricao);
        tarefas.add(tarefa);
    }
    public void removertarefa(int indice) {
        tarefas.remove(indice);
    }
    public void marcarTarefaComoConcluida(int indice) {
        if(indice >= 0 && indice < tarefas.size()) {
            tarefas.get(indice).marcarComoConcluida();
        }
    }
    public void marcarTarefaComoNaoConcluida(int indice) {
        if(indice >= 0 && indice < tarefas.size()) {
            tarefas.get(indice).marcarComoNaoConcluida();
        }
    }
    public void atualizarView() {
        view.exibirTarefas(tarefas);
    }
    public String atualizarViewInterface() {
        return view.exibirTarefasInterface(tarefas);
    }
}
