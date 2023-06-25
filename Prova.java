import java.time.LocalDateTime;

import javax.swing.JOptionPane;

public class Prova extends Registro{
    private String nota = "";
    private Armazena armazena;

    public Prova(){}
    public Prova(Armazena armazena){
        this.armazena = armazena;
    }

    public void criar(){
        LocalDateTime now = LocalDateTime.now();
        Gui gui = new Gui();
        String[] labels = {"Insira a materia", "Insira a data", "Insira a descrição"};

        for(int i=0; i<labels.length; i++){
            Object res = gui.input(labels[i]);
            if(res == null) return;
            if(i==0) setNome(""+res);
            if(i==1){
                setData(""+res);
                try{
                    String dataInput = ""+res;
                    String dataString[] = new String[3];
                    dataString = dataInput.split("/");
                    int[] data = new int[3];
                    for(int j=0; j<3; j++){
                        data[j] = Integer.valueOf(dataString[j]); 
                    }
                    if(data[2]<now.getYear() || data[1]<now.getMonthValue() && data[2]==now.getYear() || data[0]<now.getDayOfMonth() && data[1]==now.getMonthValue() && data[2]==now.getYear()){
                        JOptionPane.showMessageDialog(null, "Você não pode criar provas com data anterior da atual!", "Data Incorreta", 0, null);
                        i = 0;
                    }
                } catch(Exception NumberFormatException){
                    JOptionPane.showMessageDialog(null, "Input incorreto! \n" + //
                            "Formato de data correto: DD/MM/YYYY", "Input incorreto!", 0, null);
                            i = 0;
                }
            }
            if(i==2) setDesc(""+res);
        }

        armazena.armazenar(this);
    }
    public void editar(int index){
        Gui gui = new Gui();
        String[] labels = {"Insira a materia (pressione enter para não editar)", "Insira a data (pressione enter para não editar)", "Insira a descrição (pressione enter para não editar)"};

        Prova pro = armazena.getOneProva(index);

        Object res = gui.input(labels[0], pro.getNome());
        if(res == null) return;
        setNome(""+res);
        res = gui.input(labels[1], pro.getData());
        if(res == null) return;
        setData(""+res);
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
            provaS[i] = provaP[i].getNome();
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
