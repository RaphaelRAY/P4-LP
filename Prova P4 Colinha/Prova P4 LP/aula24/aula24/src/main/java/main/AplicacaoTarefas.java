package main;

import Controller.TarefaController;

public class AplicacaoTarefas {
    public static void main(String[] args) {
        TarefaController controller = new TarefaController();
        controller.atualizarView();
        controller.adicionarTarefa("Fazer compras");
        controller.atualizarView();
        controller.adicionarTarefa("Estudar Java");
        controller.atualizarView();
        controller.adicionarTarefa("Exemplo de MVC");
        controller.atualizarView();
        controller.marcarTarefaComoConcluida(0);
        controller.atualizarView();
        controller.marcarTarefaComoConcluida(1);
        controller.atualizarView();
        controller.marcarTarefaComoConcluida(2);
        controller.atualizarView();
        controller.marcarTarefaComoNaoConcluida(0);
        controller.atualizarView();
        controller.marcarTarefaComoNaoConcluida(1);
        controller.atualizarView();
        controller.marcarTarefaComoNaoConcluida(2);
        controller.atualizarView();
        controller.removertarefa(0);
        controller.atualizarView();
        controller.removertarefa(0);
        controller.atualizarView();
        controller.removertarefa(0);
        controller.atualizarView();
    }
}
