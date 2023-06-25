public class Nota extends Registro {
    private Armazena armazena;

    public Nota(){}
    public Nota(Armazena armazena){
        this.armazena = armazena;
    }

    public void criar(){
        Gui gui = new Gui();
        String[] labels = {"Insira o nome", "Insira a data", "Insira a descrição"};

        for(int i=0; i<labels.length; i++){
            Object res = gui.input(labels[i]);
            if(res == null) return;
            if(i==0) setNome(""+res);
            if(i==1) setData(""+res);
            if(i==2) setDesc(""+res);
        }
        armazena.armazenar(this);
    }
    public void editar(int index){
        Gui gui = new Gui();
        String[] labels = {"Insira o nome (pressione enter para não editar)", "Insira a data (pressione enter para não editar)", "Insira a descrição (pressione enter para não editar)"};
        Nota not = armazena.getOneNota(index);

        Object res = gui.input(labels[0], not.getNome());
        if(res == null) return;
        setNome(""+res);
        res = gui.input(labels[1], not.getData());
        if(res == null) return;
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
}
