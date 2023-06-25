

import javax.swing.JOptionPane;

import java.time.LocalDateTime; 
public class Tarefa extends Registro{
    private String dataLimite;
    private boolean completado;
    private Armazena armazena;

    public Tarefa(){}
    public Tarefa(Armazena armazena){
        this.armazena = armazena;
    }

    public void criar(){
        LocalDateTime now = LocalDateTime.now();
        Gui gui = new Gui();
        String[] labels = {"Insira o nome", "Insira a data", "Insira a data do término", "Insira a descrição"};

        int[] dataUni = new int[3];
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
                        dataUni[j] = Integer.valueOf(dataString[j]);
                    }
                    if(data[2]<now.getYear() || data[1]<now.getMonthValue() && data[2]==now.getYear() || data[0]<now.getDayOfMonth() && data[1]==now.getMonthValue() && data[2]==now.getYear()){
                        JOptionPane.showMessageDialog(null, "Você não pode criar tarefas com data anterior da atual!", "Data Incorreta", 0, null);
                        i = 0;
                    }
                } catch(Exception NumberFormatException){
                    JOptionPane.showMessageDialog(null, "Input incorreto! \n" + //
                            "Formato de data correto: DD/MM/YYYY", "Input incorreto!", 0, null);
                            i = 0;
                }
                
            }
            if(i==2){
                setDataLimite(""+res);
                try{
                    String dataInput = ""+res;
                    String dataString[] = new String[3];
                    dataString = dataInput.split("/");
                    int[] data = new int[3];
                    for(int j=0; j<3; j++){
                        data[j] = Integer.valueOf(dataString[j]);
                    }
                    if(data[2]<now.getYear() || data[1]<now.getMonthValue() && data[2]==now.getYear() || data[0]<now.getDayOfMonth() && data[1]==now.getMonthValue() && data[2]==now.getYear()){
                        JOptionPane.showMessageDialog(null, "A data de término não pode ser antes da atual!", "Data Incorreta", 0, null);
                        i = 1;
                    } else if(data[2]<dataUni[2] || data[1]<dataUni[1] && data[2]==dataUni[2] || data[0]<dataUni[0] && data[1]==dataUni[1] && data[2]==dataUni[2]){
                        JOptionPane.showMessageDialog(null, "A data de término não pode ser antes da data de início!", "Data Incorreta", 0, null);
                        i = 1;
                    }
                } catch(Exception NumberFormatException){
                    JOptionPane.showMessageDialog(null, "Input incorreto! \n" + //
                            "Formato de data correto: DD/MM/YYYY", "Input incorreto!", 0, null);
                            i = 1;
                }
            }
            if(i==3) setDesc(""+res);
        }
        completado = false;
        armazena.armazenar(this);
    }
    public void editar(int index){
        Gui gui = new Gui();
        String[] labels = {"Insira o nome (pressione enter para não editar)", "Insira a data (pressione enter para não editar)", "Insira a data do término (pressione enter para não editar)", "Insira a descrição (pressione enter para não editar)"};

        Tarefa taf = armazena.getOneTarefa(index);

        Object res = gui.input(labels[0], taf.getNome());
        if(res == null) return;
        setNome(""+res);
        res = gui.input(labels[1], taf.getData());
        if(res == null) return;
        setData(""+res);
        res = gui.input(labels[2], taf.getDataLimite());
        if(res == null) return;
        setDataLimite(""+res);
        res = gui.input(labels[3], taf.getDesc());
        if(res == null) return;
        setDesc(""+res);
        armazena.editar(this, index);
    }
    public void excluir(int index){
        armazena.deletar(index, "tarefa");
    }
    public String[] exibir(){
        Tarefa[] tarefasT = armazena.getAllTarefas();
        String[] tarefasS = new String[tarefasT.length];
        for(int i=0; i<tarefasT.length; i++){
            if(tarefasT[i].isCompletado() == true){
               tarefasS[i] = tarefasT[i].getNome()+" (\u2713)"; 
            } else{
                tarefasS[i] = tarefasT[i].getNome();
            }
            
        }
        return tarefasS;
    }
    public Tarefa exibir(int index){
        return armazena.getOneTarefa(index);
    }

    public void concluir(int index){
        Tarefa tafConcluida = armazena.getOneTarefa(index);
        tafConcluida.setCompletado(true);
        armazena.atualizar(index, tafConcluida);
    }

    public String getDataLimite() {
        return dataLimite;
    }
    public void setDataLimite(String dataLimite) {
        this.dataLimite = dataLimite;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    public Armazena getArmazena() {
        return armazena;
    }

    public void setArmazena(Armazena armazena) {
        this.armazena = armazena;
    }
    
}
