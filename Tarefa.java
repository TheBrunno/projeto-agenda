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
        String[] labels = {"Insira o nome", "Insira a data (deixe vazio para a data atual)", "Insira a data do término (deixe vazio para a data atual)", "Insira a descrição"};

        int dataUni[] = new int[3];
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

                String dataString[] = new String[3];
                String dataInput = res+"";
                dataString = dataInput.split("/");
                for(int j=0; j<3; j++){
                    dataUni[j] = Integer.parseInt(dataString[j]);
                }
                setData(""+res);
            }
            if(i==2){
                String resS = res+"";
                if(resS.isEmpty()){
                    String dia = now.getDayOfMonth()+"";
                    String mes = now.getMonthValue()+"";
                    String ano = now.getYear()+"";

                    if(Integer.parseInt(dia) < 10) dia = "0"+dia;
                    if(Integer.parseInt(mes) < 10) mes = "0"+mes; 
                    res = dia+"/"+mes+"/"+ano;
                }if (!verificarDataLimite(""+res, dataUni)){
                    i=1;
                    continue;
                }
                setDataLimite(""+res);
            }
            if(i==3) setDesc(""+res);
        }
        completado = false;
        armazena.armazenar(this);
    }
    public void editar(int index){
        LocalDateTime now = LocalDateTime.now();
        Gui gui = new Gui();
        String[] labels = {"Insira o nome (pressione enter para não editar)", "Insira a data (deixe vazio para a data atual)", "Insira a data do término (pressione enter para não editar)", "Insira a descrição (pressione enter para não editar)"};

        Tarefa taf = armazena.getOneTarefa(index);
        int dataUni[] = new int[3];

        Object res = gui.input(labels[0], taf.getNome());
        if(res == null) return;
        setNome(""+res);
        while(true){
            res = gui.input(labels[1], taf.getData());
            String resS = res+"";
            if(res == null) return;
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

            String dataString[] = new String[3];
            String dataInput = res+"";
            dataString = dataInput.split("/");
            for(int j=0; j<3; j++){
                dataUni[j] = Integer.parseInt(dataString[j]);
            }

            setData(""+res);
            break;
        }
        while(true){
            res = gui.input(labels[2], taf.getDataLimite());
            String resS = res+"";
            if(res == null) return;
            if(resS.isEmpty()){
                String dia = now.getDayOfMonth()+"";
                String mes = now.getMonthValue()+"";
                String ano = now.getYear()+"";

                if(Integer.parseInt(dia) < 10) dia = "0"+dia;
                if(Integer.parseInt(mes) < 10) mes = "0"+mes; 
                res = dia+"/"+mes+"/"+ano;
            }if (!verificarDataLimite(""+res, dataUni)){
                continue;
            }
            setDataLimite(""+res);
            break;
        }
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
                tarefasS[i] = tarefasT[i].getNome()+" ("+tarefasT[i].getDataLimite()+")";
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

    public boolean verificarDataLimite(String dataInput, int dataUni[]){
        LocalDateTime now = LocalDateTime.now();
        Gui gui = new Gui();
        try{
            String dataString[] = new String[3];
            dataString = dataInput.split("/");
            int[] data = new int[3];
            for(int j=0; j<3; j++){
                data[j] = Integer.parseInt(dataString[j]);
            }
            if(data[2]<now.getYear() || data[1]<now.getMonthValue() && data[2]==now.getYear() || data[0]<now.getDayOfMonth() && data[1]==now.getMonthValue() && data[2]==now.getYear()){
                gui.errorMessage("A data de término não pode ser antes da atual!", "Data Incorreta");
                return false;
            } else if(data[2]<dataUni[2] || data[1]<dataUni[1] && data[2]==dataUni[2] || data[0]<dataUni[0] && data[1]==dataUni[1] && data[2]==dataUni[2]){
                gui.errorMessage("A data de término não pode ser antes da data de início!", "Data Incorreta");
                return false;
            }
        } catch(Exception NumberFormatException){
            gui.errorMessage("Input incorreto! \nFormato de data correto: DD/MM/YYYY", "Input incorreto!");
            return false;
        }
        return true;
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
