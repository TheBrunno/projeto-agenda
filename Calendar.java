import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;

public class Calendar extends Gui{
    private JFrame jframe;
    private int width;
    private DayOfWeek initialWeekDayOnMonth;
    private LocalDate currentDate;


    public Calendar(int width, int height){
        super("Calendário", width, height);
        this.jframe = getJFrame();
        this.render();

        this.width = width;
    }

    public void render() {
        int monthNumber = getNumberDays();
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel topPanel = createWeekMenu();

        int numberWeekDay = getNumberWeekDay();

        for(int i=1; i<=monthNumber; i++){
            if(numberWeekDay == 0){
                createDayOnFrame(i, panel);
            }else{
                numberWeekDay--;
                i--;
                createDayOnFrame(panel);
            }
        }

        jframe.add(topPanel, BorderLayout.NORTH);
        jframe.add(panel, BorderLayout.CENTER);
    }

    public JPanel createWeekMenu() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label;
        
        panel.setPreferredSize(new Dimension(this.width, 30));

        String days[] = {"DOM", "SEG", "TER", "QUA", "QUI", "SEX", "SAB"};
        for (int i = 0; i < 7; i++) {
            label = new JLabel(days[i], SwingConstants.CENTER);
            label.setPreferredSize(new Dimension(100, 30));
            panel.add(label);
        }

        return panel;
    }
    public int getNumberDays(){
        int feb = 0;
        currentDate = LocalDate.now();
        
        int month = currentDate.getMonthValue();
        int year = currentDate.getYear();

        if((year % 4 == 0 && year % 100 != 0) || (year % 4 == 0 && year % 100 == 0 && year % 400 == 0)) feb = 29;
        else feb = 28;

        int numberDays[] = {31, feb, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        return numberDays[month-1];
    }

    public JPanel createDayOnFrame(int day, JPanel panel){
        JPanel dayBox = new JPanel(new GridBagLayout());
        JLabel dayLabel;
        if(day != 0){
            dayLabel = new JLabel(day + "");
        }else{
            dayLabel = new JLabel("");
        }

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.CENTER;

        Border border = BorderFactory.createLineBorder(Color.BLACK);
        dayBox.setPreferredSize(new Dimension(100, 100));
        dayBox.setBorder(border);

        dayBox.add(dayLabel, gbc);

        panel.add(dayBox);

        return panel;
    }

    public int getNumberWeekDay(){
        int day = currentDate.getDayOfMonth();

        DayOfWeek weekDayInit = currentDate.minusDays(day-1).getDayOfWeek();
        String weekDay = weekDayInit+"";

        String daysOfWeek[] = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};

        return Arrays.asList(daysOfWeek).indexOf(weekDay);
    }

    public JPanel createDayOnFrame(JPanel panel){
        return createDayOnFrame(0, panel);
    }
}
