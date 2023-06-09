import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Add extends Gui{
        private JFrame jframe;

    public Add(int width, int height){
        super("Adicionar", width, height);
        this.jframe = getJFrame();
        this.render();
    }

    public void render(){
        JButton tasks = new Button("Tarefa", 200, 100).getButton();
        JButton events = new Button("Eventos", 200, 100).getButton();
        JButton notes = new Button("Notas", 200, 100).getButton();
        JButton back = new Button("images/back.png", 50, 50, 70, 70, "").getButton();
        JButton trash = new Button("images/trash.png", 40, 50, 70, 70, "").getButton();
        JButton settings = new Button("images/config.png", 50, 50, 70, 70, "").getButton();

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel choicesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JLabel label = new JLabel("Escolha uma ação:");

        labelPanel.add(label, BorderLayout.NORTH);

        choicesPanel.add(tasks);
        choicesPanel.add(events);
        choicesPanel.add(notes);

        panel.setLayout(new BorderLayout());
        panel.add(labelPanel, BorderLayout.NORTH);
        panel.add(choicesPanel, BorderLayout.SOUTH);

        bottomPanel.add(back);
        bottomPanel.add(trash);
        bottomPanel.add(settings);

        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        this.jframe.add(panel, BorderLayout.CENTER);
        this.jframe.add(bottomPanel, BorderLayout.SOUTH);

        setJFrame(this.jframe);

    }
}
