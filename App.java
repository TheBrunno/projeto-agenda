import java.util.Arrays;

public class App{
    public static void main(String[] args) {
        Armazena armazena = new Armazena();
        Gui gui = new Gui();
        String[] options = {"Tarefa", "Notas", "Eventos", "Provas"};
        String[] func = {"Criar", "Listar", "Editar", "Excluir"};

        while(true){
            String res = gui.painel(options, "Escolha um item");
            if(res.equals("Tarefa")){
                String funk = gui.painel(func, "Escolha o que fazer com uma tarefa");
                Tarefa taf = new Tarefa(armazena);

                if(funk.equals("Criar")){
                    taf.criar();
                }else if(funk.equals("Listar")){
                    String[] tarefas = taf.exibir();
                    String value = gui.painel(tarefas, "Escolha uma tarefa para ser VISUALIZADA");
                    
                    int index = Arrays.asList(tarefas).indexOf(value);

                    if(index != -1){
                        Tarefa escolhida = taf.exibir(index);
                        String acao = gui.output(escolhida);
                        if(acao.equals("Concluir")){
                            taf.concluir(index);
                        }
                    }
                }else if(funk.equals("Excluir")){
                    String[] tarefas = taf.exibir();
                    String value = gui.painel(tarefas, "Escolha uma tarefa para ser EXCLUÍDA");
                    
                    int index = Arrays.asList(tarefas).indexOf(value);

                    if(index != -1){
                        Object[] deleteOptions = {"Excluir", "Voltar"};
                        String resultadoDelete = gui.messageDelete("essa tarefa?", deleteOptions, 0);
                        if(resultadoDelete.equals("Excluir")){
                            taf.excluir(index);
                        }
                    }
                }else if(funk.equals("Editar")){
                    String[] tarefas = taf.exibir();
                    String value = gui.painel(tarefas, "Escolha uma tarefa para ser EDITADA");
                    
                    int index = Arrays.asList(tarefas).indexOf(value);

                    if(index != -1){
                        taf.editar(index);
                    }
                }
            }else if(res.equals("Notas")){
                String funk = gui.painel(func, "Escolha o que fazer com uma nota");
                Nota nota = new Nota(armazena);

                if(funk.equals("Criar")){
                    nota.criar();
                }else if(funk.equals("Listar")){
                    String[] notas = nota.exibir();
                    String value = gui.painel(notas, "Escolha uma nota para ser VISUALIZADA");
                    
                    int index = Arrays.asList(notas).indexOf(value);

                    if(index != -1){
                        Nota escolhida = nota.exibir(index);
                        gui.output(escolhida);
                    }
                }else if(funk.equals("Excluir")){
                    String[] notas = nota.exibir();
                    String value = gui.painel(notas, "Escolha uma nota para ser EXCLUÍDA");
                    
                    int index = Arrays.asList(notas).indexOf(value);

                    if(index != -1){
                        Object[] deleteOptions = {"Excluir", "Voltar"};
                        String resultadoDelete = gui.messageDelete("essa nota?", deleteOptions, 0);
                        if(resultadoDelete.equals("Excluir")){
                            nota.excluir(index);
                        }
                    }
                }else if(funk.equals("Editar")){
                    String[] notas = nota.exibir();
                    String value = gui.painel(notas, "Escolha uma nota para ser EDITADA");
                    
                    int index = Arrays.asList(notas).indexOf(value);

                    if(index != -1){
                        nota.editar(index);
                    }
                }
            }else if(res.equals("Eventos")){
                String funk = gui.painel(func, "Escolha o que fazer com um evento");
                Evento evento = new Evento(armazena);

                if(funk.equals("Criar")){
                    evento.criar();
                }else if(funk.equals("Listar")){
                    String[] eventos = evento.exibir();
                    String value = gui.painel(eventos, "Escolha um evento para ser VISUALIZADO");
                    
                    int index = Arrays.asList(eventos).indexOf(value);

                    if(index != -1){
                        Evento escolhida = evento.exibir(index);
                        gui.output(escolhida);
                    }
                }else if(funk.equals("Excluir")){
                    String[] eventos = evento.exibir();
                    String value = gui.painel(eventos, "Escolha um evento para ser EXCLUÍDO");
                    
                    int index = Arrays.asList(eventos).indexOf(value);

                    if(index != -1){
                        Object[] deleteOptions = {"Excluir", "Voltar"};
                        String resultadoDelete = gui.messageDelete("esse evento?", deleteOptions, 0);
                        if(resultadoDelete.equals("Excluir")){
                            evento.excluir(index);
                        }
                    }
                }else if(funk.equals("Editar")){
                    String[] eventos = evento.exibir();
                    String value = gui.painel(eventos, "Escolha um evento para ser EDITADO");
                    
                    int index = Arrays.asList(eventos).indexOf(value);

                    if(index != -1){
                        evento.editar(index);
                    }
                }
            }else if(res.equals("Provas")){
                String prof = gui.painel(func, "Escolha o que fazer com uma prova");
                Prova prov = new Prova(armazena);

                if(prof.equals("Criar")){
                    prov.criar();
                }else if(prof.equals("Listar")){
                    String[] tarefas = prov.exibir();
                    String value = gui.painel(tarefas, "Escolha uma prova para ser VISUALIZADA");
                    
                    int index = Arrays.asList(tarefas).indexOf(value);

                    if(index != -1){
                        Prova escolhida = prov.exibir(index);
                        String acao = gui.output(escolhida);
                        if(acao.equals("Definir menção")){
                            String nota = gui.input("Digite a menção recebida")+"";
                            prov.concluir(index, nota);
                        }
                    }
                }else if(prof.equals("Excluir")){
                    String[] provas = prov.exibir();
                    String value = gui.painel(provas, "Escolha uma prova para ser EXCLUÍDA");
                    
                    int index = Arrays.asList(provas).indexOf(value);

                    if(index != -1){
                        Object[] deleteOptions = {"Excluir", "Voltar"};
                        String resultadoDelete = gui.messageDelete("essa prova?", deleteOptions, 0);
                        if(resultadoDelete.equals("Excluir")){
                            prov.excluir(index);
                        }
                    }
                }else if(prof.equals("Editar")){
                    String[] prova = prov.exibir();
                    String value = gui.painel(prova, "Escolha uma prova para ser EDITADA");
                    
                    int index = Arrays.asList(prova).indexOf(value);

                    if(index != -1){
                        prov.editar(index);
                    }
                }
            }
            else{
                System.exit(0);
            }
        }
    }
}