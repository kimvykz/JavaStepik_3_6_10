import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;


public class Quiz {

    static String[] questions = {"Which animal was Tom?", "Which animal was Mickey?",
            "Which animal was Winnie?", "Which animal was Pororo?"};
    static String[] answers = {"Cat", "Mouse", "Bear", "Penguin"};

    static String getAnswer(String que_) {
        for (int i = 0; i < questions.length; i++){
            if (questions[i].equals(que_)) {
                return answers[i];
            }
            else {
                return "";
            }
        }
        return "";
    }

    public static void main(String[] args) {

        String[] optAnsw = {"Cat", "Mouse" , "Bear", "Penguin"};


        JFrame frame = new JFrame("quiz");
        JPanel panel = new JPanel(new GridBagLayout());
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JButton buttonA = new JButton("A");
        JButton buttonB = new JButton("B");
        JButton buttonC = new JButton("C");
        JButton buttonD = new JButton("D");
        JLabel label = new JLabel("Quiestion - ");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        panel.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
        panel.setSize(400, 400);
        GridBagConstraints gbc = new GridBagConstraints();


        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(4,4,8,4);
        panel.add(label, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3,3,3,3);
        gbc.ipady = 70;
        gbc.weightx = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(textArea, gbc);




        gbc.gridwidth = 1;
        gbc.ipady = 30;
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(buttonA, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(buttonC, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(buttonB, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(buttonD, gbc);

        frame.add(panel);


        int playQuestion = JOptionPane.showConfirmDialog(null, "Do you want to play?", "Quiz game",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (playQuestion == JOptionPane.YES_NO_OPTION) {
            frame.setVisible(true);
            int cnt = 0, allCnt = questions.length;

            label.setText("Question - " + questions[cnt] + " of " + allCnt);
            Collections.shuffle(Arrays.asList(optAnsw));

            textArea.setText(questions[cnt]);
            buttonA.setText(optAnsw[0]);
            buttonB.setText(optAnsw[1]);
            buttonC.setText(optAnsw[2]);
            buttonD.setText(optAnsw[3]);


        }
        else {
            System.exit(0);
        }

    }



}
