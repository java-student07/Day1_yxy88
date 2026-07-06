package day1;
//2. 버튼 클릭 이벤트 (JButton + ActionListener)
import javax.swing.*;
import java.awt.event.*;
public class ButtonClick02 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("버튼 예제");
        JButton btn = new JButton("클릭하세요");
        btn.addActionListener(e -> JOptionPane.showMessageDialog(frame, "안녕!"));
        frame.add(btn);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}