import java.util.ArrayList;

public class Armazena {
    private ArrayList<Tarefa> tarefas = new ArrayList<>();
    private ArrayList<Nota> notas = new ArrayList<>();
    private ArrayList<Evento> eventos = new ArrayList<>();
    private ArrayList<Prova> provas = new ArrayList<>();

    //armazenar
    public void armazenar(Tarefa tarefa){
        tarefas.add(tarefa);
    }
    public void armazenar(Nota nota){
        notas.add(nota);
    }
    public void armazenar(Evento evento){
        eventos.add(evento);
    }
    public void armazenar(Prova prova){
        provas.add(prova);
    }

    public void atualizar(int index, Tarefa obj){ // usado em concluir tarefa
        tarefas.set(index, obj);
    }
    public void atualizar(int index, Prova obj){ // usado em definir menção prova
        provas.set(index, obj);
    }

    //editar
    public void editar(Tarefa obj, int index){
        Tarefa taf = tarefas.get(index);

        if(!obj.getNome().isEmpty()) taf.setNome(obj.getNome());
        if(!obj.getData().isEmpty()) taf.setData(obj.getData());
        if(!obj.getDataLimite().isEmpty()) taf.setDataLimite(obj.getDataLimite());
        if(!obj.getDesc().isEmpty()) taf.setDesc(obj.getDesc());

        tarefas.set(index, taf);
    }
    public void editar(Nota obj, int index){
        Nota not = notas.get(index);

        if(!obj.getNome().isEmpty()) not.setNome(obj.getNome());
        if(!obj.getData().isEmpty()) not.setData(obj.getData());
        if(!obj.getDesc().isEmpty()) not.setDesc(obj.getDesc());

        notas.set(index, not);
    }
    public void editar(Evento obj, int index){
        Evento eve = eventos.get(index);

        if(!obj.getNome().isEmpty()) eve.setNome(obj.getNome());
        if(!obj.getData().isEmpty()) eve.setData(obj.getData());
        if(!obj.getDesc().isEmpty()) eve.setDesc(obj.getDesc());

        eventos.set(index, eve);
    }
    public void editar(Prova obj, int index){
        Prova pro = provas.get(index);

        if(!obj.getNome().isEmpty()) pro.setNome(obj.getNome());
        if(!obj.getData().isEmpty()) pro.setData(obj.getData());
        if(!obj.getDesc().isEmpty()) pro.setDesc(obj.getDesc());

        provas.set(index, pro);
    }

    public void deletar(int index, String type){
        if(type.equals("tarefa")) tarefas.remove(index);
        if(type.equals("nota")) notas.remove(index);
        if(type.equals("evento")) eventos.remove(index);
        if(type.equals("prova")) provas.remove(index);
    }

    // obter tarefas
    public Tarefa[] getAllTarefas() {
        Tarefa[] tarefasT = new Tarefa[tarefas.size()];
        for(int i=0; i<tarefas.size(); i++){
            tarefasT[i] = tarefas.get(i);
        }
        return tarefasT;
    }
    public Tarefa getOneTarefa(int index){
        return tarefas.get(index);
    }

    //obter notas
    public Nota[] getAllNotas() {
        Nota[] notasN = new Nota[notas.size()];
        for(int i=0; i<notas.size(); i++){
            notasN[i] = notas.get(i);
        }
        return notasN;
    }
    public Nota getOneNota(int index){
        return notas.get(index);
    }

    //obter eventos
    public Evento[] getAllEventos(){
        Evento[] eventosE = new Evento[eventos.size()];
        for(int i=0; i<eventos.size(); i++){
            eventosE[i] = eventos.get(i);
        }
        return eventosE;
    }
    public Evento getOneEvento(int index){
        return eventos.get(index);
    }

    //obter provas
    public Prova[] getAllProvas() {
        Prova[] provaP = new Prova[provas.size()];
        for(int i=0; i<provas.size(); i++){
            provaP[i] = provas.get(i);
        }
        return provaP;
    }
    public Prova getOneProva(int index){
        return provas.get(index);
    }

    public void setTarefas(ArrayList<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }
}
