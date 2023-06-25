public abstract class Registro {
    private String nome;
    private String data;
    private String desc;
    private boolean cadastrado;

    abstract public void criar();
    abstract public void editar(int index);
    abstract public void excluir(int index);
    abstract public String[] exibir();
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public boolean isCadastrado() {
        return cadastrado;
    }
    public void setCadastrado(boolean cadastrado) {
        this.cadastrado = cadastrado;
    }
}
