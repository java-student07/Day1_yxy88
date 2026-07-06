package day1;
//3. 라벨과 텍스트 필드 (JLabel + JTextField)
import javax.swing.*;
public class LabelTextField03 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("입력 예제");
        JPanel panel = new JPanel();
        panel.add(new JLabel("이름:"));
        panel.add(new JTextField(15));
        frame.add(panel);
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}