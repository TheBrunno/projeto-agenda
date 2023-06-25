public class Evento extends Registro {
    private Armazena armazena;

    public Evento(){}
    public Evento(Armazena armazena){
        this.armazena = armazena;
    }

    public void criar(){
        
        Gui gui = new Gui();
        String[] labels = {"Insira o nome", "Insira a data", "Insira a descrição"};

        for(int i=0; i<labels.length; i++){
            Object res = gui.input(labels[i]);
            if(res == null) return;
            if(i==0) setNome(""+res);
            if(i==1) {
                if (!verifyDate(""+res)){
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
        String[] labels = {"Insira o nome (pressione enter para não editar)", "Insira a data (pressione enter para não editar)", "Insira a descrição (pressione enter para não editar)"};
        Evento eve = armazena.getOneEvento(index);

        Object res = gui.input(labels[0], eve.getNome());
        if(res == null) return;
        setNome(""+res);
        while(true){
            res = gui.input(labels[1], eve.getData());
            if(res == null) return;
            if (!verifyDate(""+res)){
                continue;
            }
            setData(""+res);
            break;
        }
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
