package main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Controller.TarefaController;

import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.FlowLayout;


public class AppTarefas extends JFrame{  
    private JTextArea outputArea;
    private JButton NovaTarefa;
    private JButton MarcarConcluida;
    private JButton MarcarNaoConcluida;
    private JButton ExcluirTarefa;
    private JButton VerLista;
    private JButton Sair;
    private TarefaController controller = new TarefaController(); 

    public AppTarefas(){
        super( "Lista" );
        setLayout(new BorderLayout());

        //text area
        outputArea = new JTextArea(10, 20);
        outputArea.setEditable(false);
        add(outputArea, BorderLayout.CENTER);
        att_view();


        JPanel botoes = new JPanel();
        botoes.setLayout(new FlowLayout());

        NovaTarefa = new JButton("Nova Tarefa");
        botoes.add(NovaTarefa);
        //active listiner
        NovaTarefa.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String novaTarefa = JOptionPane.showInputDialog(null, "Digite a nova tarefa: ", "Nova Tarefa", JOptionPane.QUESTION_MESSAGE);
                controller.adicionarTarefa(novaTarefa);
                //controller.atualizarView();
                att_view();
            }
        });

        MarcarConcluida = new JButton("Marcar Concluida");
        botoes.add(MarcarConcluida);
        //active listiner
        MarcarConcluida.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String indice = JOptionPane.showInputDialog(null, "Digite o indice da tarefa: ", "Marcar Concluido", JOptionPane.QUESTION_MESSAGE);
                int indicetransformado = Integer.parseInt(indice);
                controller.marcarTarefaComoConcluida(indicetransformado);
                att_view();
                //controller.atualizarView();
            }
        });

        MarcarNaoConcluida = new JButton("Marcar Não Concluida");
        botoes.add(MarcarNaoConcluida);
        //active listiner
        MarcarNaoConcluida.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String indice = JOptionPane.showInputDialog(null, "Digite o indice da tarefa: ", "Marcar Nao Concluido", JOptionPane.QUESTION_MESSAGE);
                int indicetransformado = Integer.parseInt(indice);
                controller.marcarTarefaComoNaoConcluida(indicetransformado);
                att_view();
                //controller.atualizarView();
            }
        });

        ExcluirTarefa = new JButton("Excluir Tarefa");
        botoes.add(ExcluirTarefa);
        //active listiner
        ExcluirTarefa.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String indice = JOptionPane.showInputDialog(null, "Digite o indice da tarefa: ", "Excluir Tarefa", JOptionPane.QUESTION_MESSAGE);
                int indicetransformado = Integer.parseInt(indice);
                controller.removertarefa(indicetransformado);
                att_view();
                //controller.atualizarView();
            }
        });

        VerLista = new JButton("Ver Lista");
        botoes.add(VerLista);
        //active listiner
        VerLista.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                att_view();
            }
        });

        Sair = new JButton("Sair");
        botoes.add(Sair);
        //active listiner
        Sair.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        add(botoes, BorderLayout.SOUTH);
    }

    private void att_view(){
        outputArea.setText(controller.atualizarViewInterface());
    }

   public static void main( String args[] ){
      AppTarefas app = new AppTarefas();
      app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        app.setSize( 700, 200 ); // set frame size
      app.setVisible( true ); // display frame
   }
}
