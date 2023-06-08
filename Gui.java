import javax.swing.JFrame;

abstract public class Gui {
    private boolean visible = false;
    private JFrame jframe;

    public Gui(String title, int width, int height){
        JFrame jframe = new JFrame(title);
        jframe.setSize(width, height);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(visible);

        this.jframe = jframe;
    }

    public void changeVisible(){
        this.jframe.setVisible(visible);
    }

    public void show(){
        this.visible = true;
        changeVisible();
    }

    public void hidden(){
        this.visible = false;
        changeVisible();
    }

    abstract public void render();


    // getters and setters
    public JFrame getJFrame(){
        return jframe;
    }
    public void setJFrame(JFrame jframe){
        this.jframe = jframe;
    }

    public boolean getVisible() {
        return visible;
    }
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

}
