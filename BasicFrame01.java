//1. 기본 프레임 (JFrame)

package day1;

import javax.swing.*;
public class BasicFrame01 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing 예제");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
