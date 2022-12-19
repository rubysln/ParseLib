import habr.HabrHtmlLoader;
import habr.HabrParser;
import habr.HabrSettings;
import settings.OnCompleted;
import settings.OnNewDataHandler;
import settings.ParserWorker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GUI extends JFrame implements OnCompleted, OnNewDataHandler<HashMap<String, ArrayList<String>>>, ActionListener {
    private JTextField textStart = new JTextField(10);
    private JTextField textEnd = new JTextField(10);
    private JButton startButton = new JButton("Start");
    private JButton abortButton = new JButton("Abort");
    private JTextArea jTextArea = new JTextArea(8,10);
    public GUI() throws HeadlessException {
        JFrame.setDefaultLookAndFeelDecorated(true);
        setTitle("Habr");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(0, 1, 5, 12));
        rightPanel.add(new JLabel("Первая страница"));
        this.add(rightPanel, BorderLayout.EAST);
        jTextArea.setFont(new Font("Dialog", Font.PLAIN, 14));
        jTextArea.setTabSize(10);
        this.add(new JScrollPane(jTextArea));

        rightPanel.add(textStart);
        rightPanel.add(textEnd);
        startButton.addActionListener(this);
        rightPanel.add(startButton);
        rightPanel.add(abortButton);
        this.setBounds(100, 100, 750, 500);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            int start = Integer.parseInt(textStart.getText());
            int end = Integer.parseInt(textEnd.getText());
        }
        catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Ошибка ввода!");
        }
        int start = Integer.parseInt(textStart.getText());
        int end = Integer.parseInt(textEnd.getText());
        HabrSettings habrSettings = new HabrSettings(start, end);
        ParserWorker<ArrayList<String>> habrParser = new ParserWorker<>(habrSettings);
        habrParser.setParser(new HabrParser());
        habrParser.setLoader(new HabrHtmlLoader(habrSettings));
        habrParser.getOnCompletedList().add(this);
        habrParser.getOnNewDataList().add(this);
        try {
            habrParser.Start();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    @Override
    public void onCompleted(Object sender) {
        JOptionPane.showMessageDialog(this, "Загрузка окончена!");
    }

    @Override
    public void onNewData(Object sender, HashMap<String, ArrayList<String>> e) {
        JOptionPane.showMessageDialog(this, "Картинки загружены в локальную папку!");
        jTextArea.setText(null);
        for(Map.Entry<String, ArrayList<String>> pair: e.entrySet()){
            jTextArea.append("Название статьи: " + pair.getKey() + "\n");
            for(var j: e.get(pair.getKey())){
                if(j != null) jTextArea.append(j + "\n");
            }
        }
    }
}
