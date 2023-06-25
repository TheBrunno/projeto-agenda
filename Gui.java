import javax.swing.JOptionPane;

public class Gui {
    public String painel(String[] options, String texto){
        Object res = JOptionPane.showInputDialog(null, texto, "Escolha uma opção:",
				JOptionPane.PLAIN_MESSAGE , null ,options,"");
        return res+"";
    }

    public Object input(String texto){
        Object res = JOptionPane.showInputDialog(null, texto);
        return res;
    }
    public Object input(String texto, String placeholder){
        Object res = JOptionPane.showInputDialog(null, texto, placeholder);
        return res;
    }

    public String output(Tarefa object){
        String completado = "";
        if(object.isCompletado()){
            Object[] options = {"Voltar"};
            completado = "Sim";
            String desc = "Nome da tarefa: "+object.getNome()+"\nData de início: "+object.getData()+"\nData de término: "+object.getDataLimite()+"\nDescrição: "+object.getDesc()+"\nFeito: "+completado; 
            int option = JOptionPane.showOptionDialog(null, desc, object.getNome(), JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if(option == -1) return null;
            else return options[option]+"";
        }else{
            Object[] options = {"Concluir", "Voltar"};
            completado = "Não";
            String desc = "Nome da tarefa: "+object.getNome()+"\nData de início: "+object.getData()+"\nData de término: "+object.getDataLimite()+"\nDescrição: "+object.getDesc()+"\nFeito: "+completado; 
            int option = JOptionPane.showOptionDialog(null, desc, object.getNome(), JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);
            if(option == -1) return "";
            else return options[option]+"";
        }
    }
    public String output(Nota object){
        Object[] options = {"Voltar"};
        String desc = "Nome da anotação: "+object.getNome()+"\nData da anotação: "+object.getData()+"\nDescrição: "+object.getDesc(); 
        int option = JOptionPane.showOptionDialog(null, desc, object.getNome(), JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if(option == -1) return "";
        else return options[option]+"";
    }
    public String output(Evento object){
        Object[] options = {"Voltar"};
        String desc = "Nome do evento: "+object.getNome()+"\nData do evento: "+object.getData()+"\nDescrição: "+object.getDesc(); 
        int option = JOptionPane.showOptionDialog(null, desc, object.getNome(), JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if(option == -1) return "";
        else return options[option]+"";
    }
    public String output(Prova object){
        Object[] options = {"Definir menção", "Voltar"};
        String desc = "Materia: "+object.getNome()+"\nData da prova: "+object.getData()+"\nDescrição: "+object.getDesc()+"\nMenção: "+object.getNota(); 
        int option = JOptionPane.showOptionDialog(null, desc, object.getNome(), JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if(option == -1) return "";
        else return options[option]+"";
    }

    public String messageDelete(String desc, Object[] options, int padrao){
        int option = JOptionPane.showOptionDialog(null, "Deseja realmente excluir "+desc, "Excluir "+desc, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[padrao]);
        if(option == -1) return "";
        else return options[option]+"";
    }

    public void errorMessage(String desc, String title){
        JOptionPane.showMessageDialog(null, desc, title, 0, null);
    }
}
