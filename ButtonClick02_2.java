package day1;
//2. 버튼 클릭 이벤트 (JButton + ActionListener)
//2. 按钮点击事件 (JButton + ActionListener)

import javax.swing.*;
import java.awt.event.*;

public class ButtonClick02_2 {
    public static void main(String[] args) {
        // JFrame 객체 생성 - 윈도우 창을 만듦
        // 创建 JFrame 对象 - 创建窗口
        JFrame frame = new JFrame("버튼 예제");
        // "버튼 예제"는 창 제목 / "버튼 예제" 是窗口标题

        // JButton 객체 생성 - 버튼 위젯을 만듦
        // 创建 JButton 对象 - 创建按钮组件
        JButton btn = new JButton("클릭하세요");
        // "클릭하세요"는 버튼에 표시될 텍스트 / "클릭하세요" 是按钮上显示的文本

        // 버튼에 ActionListener 추가 (람다식 사용)
        // 给按钮添加 ActionListener (使用 Lambda 表达式)
        // 버튼 클릭 시 실행될 동작을 정의함
        // 定义按钮点击时执行的动作
        btn.addActionListener(e -> JOptionPane.showMessageDialog(frame, "안녕!"));
        // e -> 는 람다식으로, 버튼 클릭 이벤트를 처리함
        // e -> 是 Lambda 表达式，用于处理按钮点击事件
        // JOptionPane.showMessageDialog() 는 메시지 다이얼로그를 띄움
        // JOptionPane.showMessageDialog() 是弹出消息对话框
        // "안녕!" 은 다이얼로그에 표시될 메시지 / "안녕!" 是对话框中显示的消息

        // 프레임에 버튼 추가 (기본 배치관리자 - BorderLayout의 CENTER에 배치됨)
        // 将按钮添加到框架中 (默认布局管理器 - 放在 BorderLayout 的 CENTER 位置)
        frame.add(btn);

        // 프레임 크기 설정 (가로 300px, 세로 200px)
        // 设置窗口大小 (宽度 300px, 高度 200px)
        frame.setSize(300, 200);

        // 창 닫기 버튼 클릭 시 프로그램 종료 설정
        // 设置点击窗口关闭按钮时终止程序
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 프레임을 화면에 표시 (기본적으로 숨겨져 있음)
        // 将窗口显示在屏幕上 (默认是隐藏状态)
        frame.setVisible(true);
    }
}