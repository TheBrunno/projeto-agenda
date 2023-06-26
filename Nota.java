import java.time.LocalDateTime;

public class Nota extends Registro {
    private Armazena armazena;

    public Nota(){}
    public Nota(Armazena armazena){
        this.armazena = armazena;
    }

    public void criar(){
        Gui gui = new Gui();
        LocalDateTime now = LocalDateTime.now();
        String[] labels = {"Insira o nome", "Insira a data (deixe vazio para a data atual)", "Insira a descrição"};

        for(int i=0; i<labels.length; i++){
            Object res = gui.input(labels[i]);
            if(res == null) return;
            if(i==0) setNome(""+res);
            if(i==1) {
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
        LocalDateTime now = LocalDateTime.now();
        Gui gui = new Gui();
        String[] labels = {"Insira o nome (pressione enter para não editar)", "Insira a data (deixe vazio para a data atual)", "Insira a descrição (pressione enter para não editar)"};
        Nota not = armazena.getOneNota(index);

        Object res = gui.input(labels[0], not.getNome());
        if(res == null) return;
        setNome(""+res);
        while(true){
            res = gui.input(labels[1], not.getData());
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
        setData(""+res);
        res = gui.input(labels[2], not.getDesc());
        if(res == null) return;
        setDesc(""+res);

        armazena.editar(this, index);
    }
    public void excluir(int index){
        armazena.deletar(index, "nota");
    }
    public String[] exibir(){
        Nota[] notasN = armazena.getAllNotas();
        String[] notasS = new String[notasN.length];
        for(int i=0; i<notasN.length; i++){
            notasS[i] = notasN[i].getNome();
        }
        return notasS;
    }
    public Nota exibir(int index){
        return armazena.getOneNota(index);
    }
    public boolean verifyDate(String dataInput){
        Gui gui = new Gui();
        try{
            String dataString[] = new String[3];
            dataString = dataInput.split("/");
            int[] data = new int[3];
            for(int j=0; j<3; j++){
                data[j] = Integer.valueOf(dataString[j]); 
            }
        } catch(Exception NumberFormatException){
            gui.errorMessage("Input incorreto! \nFormato de data correto: DD/MM/YYYY", "Input incorreto!");
            return false;
        }
        return true;
    }
}
