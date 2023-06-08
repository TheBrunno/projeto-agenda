import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class MenuPrincipal extends Gui {
    private JFrame jframe;

    public MenuPrincipal(int width, int height){
        super("Menu principal", width, height);
        this.jframe = getJFrame();
        this.render();
    }

    public void render(){
        JButton calendar = new Button("Calendario", 200, 100).getButton();
        JButton seeRegister = new Button("Ver registros", 200, 100).getButton();
        JButton trash = new Button("images/trash.png", 40, 50, 70, 70, "").getButton();
        JButton settings = new Button("images/config.png", 50, 50, 70, 70, "").getButton();
        JButton add = new Button("images/add.png", 50, 50, 70, 70, "").getButton();

        JPanel panel = new JPanel();

        panel.add(calendar);
        panel.add(seeRegister);
        
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        this.jframe.add(panel, BorderLayout.NORTH);
        
        JPanel settingsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        settingsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        settingsPanel.add(add);
        settingsPanel.add(trash);
        settingsPanel.add(settings);

        this.jframe.add(settingsPanel, BorderLayout.SOUTH);

        setJFrame(this.jframe);

        calendar.addActionListener(e -> JOptionPane.showMessageDialog(this.jframe, "Botão 1 pressionado!"));
        seeRegister.addActionListener(e -> JOptionPane.showMessageDialog(this.jframe, "Botão 2 pressionado!"));
        add.addActionListener(e -> JOptionPane.showMessageDialog(this.jframe, "Botão 4 pressionado!"));
        trash.addActionListener(e -> JOptionPane.showMessageDialog(this.jframe, "Botão 3 pressionado!"));
        settings.addActionListener(e -> JOptionPane.showMessageDialog(this.jframe, "Botão 5 pressionado!"));
    }
}
