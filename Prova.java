import java.time.LocalDateTime;

public class Prova extends Registro{
    private String nota = "";
    private Armazena armazena;

    public Prova(){}
    public Prova(Armazena armazena){
        this.armazena = armazena;
    }

    public void criar(){
        Gui gui = new Gui();
        LocalDateTime now = LocalDateTime.now();
        String[] labels = {"Insira a materia", "Insira a data (deixe vazio para a data atual)", "Insira a descrição"};

        for(int i=0; i<labels.length; i++){
            Object res = gui.input(labels[i]);
            if(res == null) return;
            if(i==0) setNome(""+res);
            if(i==1){
                String resS = res+"";
                if(resS.isEmpty()){
                    String dia = now.getDayOfMonth()+"";
                    String mes = now.getMonthValue()+"";
                    String ano = now.getYear()+"";

                    if(Integer.parseInt(dia) < 10) dia = "0"+dia;
                    if(Integer.parseInt(mes) < 10) mes = "0"+mes; 
                    res = dia+"/"+mes+"/"+ano;
                }if (!verifyDate(""+res)){
                    i=0;
                    continue;
                }
                setData(""+res);
            }
            if(i==2) setDesc(""+res);
        }

        armazena.armazenar(this);
    }
    public void editar(int index){
        Gui gui = new Gui();
        LocalDateTime now = LocalDateTime.now();
        String[] labels = {"Insira a matéria (pressione enter para não editar)", "Insira a data (deixe vazio para a data atual)", "Insira a descrição (pressione enter para não editar)"};

        Prova pro = armazena.getOneProva(index);

        Object res = gui.input(labels[0], pro.getNome());
        if(res == null) return;
        setNome(""+res);
        while(true){
            res = gui.input(labels[1], pro.getData());
            if(res == null) return;
            String resS = res+"";
            if(resS.isEmpty()){
                String dia = now.getDayOfMonth()+"";
                String mes = now.getMonthValue()+"";
                String ano = now.getYear()+"";

                if(Integer.parseInt(dia) < 10) dia = "0"+dia;
                if(Integer.parseInt(mes) < 10) mes = "0"+mes; 
                res = dia+"/"+mes+"/"+ano;
            }if (!verifyDate(""+res)){
                continue;
            }
            setData(""+res);
            break;
        }
        res = gui.input(labels[2], pro.getDesc());
        if(res == null) return;
        setDesc(""+res);
        armazena.editar(this, index);
    }
    public void excluir(int index){
        armazena.deletar(index, "prova");
    }
    public String[] exibir(){
        Prova[] provaP = armazena.getAllProvas();
        String[] provaS = new String[provaP.length];
        for(int i=0; i<provaP.length; i++){
            if(provaP[i].getNota().isEmpty()) provaS[i] = provaP[i].getNome() + " ("+provaP[i].getData()+")";
            else provaS[i] = provaP[i].getNome() + " ("+provaP[i].getNota()+")";
            
        }
        return provaS;
    }
    public Prova exibir(int index){
        return armazena.getOneProva(index);
    }

    public void concluir(int index, String nota){
        Prova proConcluida = armazena.getOneProva(index);
        proConcluida.setNota(nota);
        armazena.atualizar(index, proConcluida);
    }
    
    public Armazena getArmazena() {
        return armazena;
    }

    public void setArmazena(Armazena armazena) {
        this.armazena = armazena;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
    
}
