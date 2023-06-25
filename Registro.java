import java.time.LocalDateTime;

public abstract class Registro {
    private String nome;
    private String data;
    private String desc;
    private boolean cadastrado;

    abstract public void criar();
    abstract public void editar(int index);
    abstract public void excluir(int index);
    abstract public String[] exibir();
    
    public boolean verifyDate(String dataInput){
        LocalDateTime now = LocalDateTime.now();
        Gui gui = new Gui();
        try{
            String dataString[] = new String[3];
            dataString = dataInput.split("/");
            int[] data = new int[3];
            for(int j=0; j<3; j++){
                data[j] = Integer.valueOf(dataString[j]); 
            }
            if(data[2]<now.getYear() || data[1]<now.getMonthValue() && data[2]==now.getYear() || data[0]<now.getDayOfMonth() && data[1]==now.getMonthValue() && data[2]==now.getYear()){
                gui.errorMessage("Você não pode criar eventos com data anterior da atual!", "Data Incorreta");
                return false;
            }
        } catch(Exception NumberFormatException){
            gui.errorMessage("Input incorreto! \nFormato de data correto: DD/MM/YYYY", "Input incorreto!");
            return false;
        }
        return true;
    }
    
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
