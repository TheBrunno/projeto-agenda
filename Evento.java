import java.time.LocalDateTime;

import javax.swing.JOptionPane;

public class Evento extends Registro {
    private Armazena armazena;

    public Evento(){}
    public Evento(Armazena armazena){
        this.armazena = armazena;
    }

    public void criar(){
        LocalDateTime now = LocalDateTime.now();
        Gui gui = new Gui();
        String[] labels = {"Insira o nome", "Insira a data", "Insira a descrição"};

        for(int i=0; i<labels.length; i++){
            Object res = gui.input(labels[i]);
            if(res == null) return;
            if(i==0) setNome(""+res);
            if(i==1) {
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
                        JOptionPane.showMessageDialog(null, "Você não pode criar eventos com data anterior da atual!", "Data Incorreta", 0, null);
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
        String[] labels = {"Insira o nome (pressione enter para não editar)", "Insira a data (pressione enter para não editar)", "Insira a descrição (pressione enter para não editar)"};
        Evento eve = armazena.getOneEvento(index);

        Object res = gui.input(labels[0], eve.getNome());
        if(res == null) return;
        setNome(""+res);
        res = gui.input(labels[1], eve.getData());
        if(res == null) return;
        setData(""+res);
        res = gui.input(labels[2], eve.getDesc());
        if(res == null) return;
        setDesc(""+res);

        armazena.editar(this, index);
    }
    public void excluir(int index){
        armazena.deletar(index, "evento");
    }
    public String[] exibir(){
        Evento[] eventoE = armazena.getAllEventos();
        String[] eventoS = new String[eventoE.length];
        for(int i=0; i<eventoE.length; i++){
            eventoS[i] = eventoE[i].getNome();
        }
        return eventoS;
    }
    public Evento exibir(int index){
        return armazena.getOneEvento(index);
    }
}
