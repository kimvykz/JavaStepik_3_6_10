import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.*;


public class Quiz extends JFrame{
    JButton buttonA= new JButton("A");
    JButton buttonB = new JButton("B");
    JButton buttonC = new JButton("C");
    JButton buttonD = new JButton("D");

    JTextArea textArea = new JTextArea();


    JLabel label = new JLabel("Quiestion - ");

    String[] questions = {"Which animal was Tom?", "Which animal was Mickey?",
            "Which animal was Winnie?", "Which animal was Pororo?"};
    String[] answers = {"Cat", "Mouse", "Bear", "Penguin"};

    String[] optAnsw = {"Cat", "Mouse" , "Bear", "Penguin"};

    int cnt = 0, allCnt = questions.length;
    int cntAnswers = 0;

    Quiz(String frameName){
        super(frameName);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        textArea.setEditable(false);

        JPanel panel = new JPanel(new GridBagLayout());


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

        this.add(panel);
    }

    String getAnswer(String que_) {
        for (int i = 0; i < questions.length; i++){
            if (questions[i].equals(que_)) {
                return answers[i];
            }
        }
        return "";
    }

    void nextQuestion(){

        if (cnt >= allCnt) {
            JOptionPane.showMessageDialog(null, "Correct answers - " + cntAnswers
            + " of " + allCnt);

            restartGame();
            wannaPlay();


        }
        else {
            label.setText("Question - " + (cnt + 1) + " of " + allCnt);
            Collections.shuffle(Arrays.asList(optAnsw));

            textArea.setText(questions[cnt]);

            buttonA.setText(optAnsw[0]);
            buttonB.setText(optAnsw[1]);
            buttonC.setText(optAnsw[2]);
            buttonD.setText(optAnsw[3]);
            cnt++;
        }
    }

    void restartGame(){
        cnt =0;
        cntAnswers = 0;

    }

    void wannaPlay(){
        int playQuestion = JOptionPane.showConfirmDialog(null, "Do you want to play?", "Quiz game",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);


        if (playQuestion == JOptionPane.YES_NO_OPTION) {
            this.setVisible(true);
            this.nextQuestion();

        }
        else {
            System.exit(0);
        }
    }

    public static void main(String[] args) {




        Quiz frame = new Quiz("quiz");


        frame.wannaPlay();


        frame.buttonA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (frame.buttonA.getText().equals(frame.getAnswer(frame.textArea.getText()))) {
                    frame.cntAnswers++;
                }

                frame.nextQuestion();
            }
        });

        frame.buttonB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (frame.buttonB.getText().equals(frame.getAnswer(frame.textArea.getText()))) {
                    frame.cntAnswers++;

                }
                frame.nextQuestion();
            }
        });

        frame.buttonC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (frame.buttonC.getText().equals(frame.getAnswer(frame.textArea.getText()))) {
                    frame.cntAnswers++;

                }
                frame.nextQuestion();
            }
        });

        frame.buttonD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (frame.buttonD.getText().equals(frame.getAnswer(frame.textArea.getText()))) {
                    frame.cntAnswers++;

                }
                frame.nextQuestion();
            }
        });

    }



}
