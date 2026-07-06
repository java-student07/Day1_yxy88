package day1;
//3. 라벨과 텍스트 필드 (JLabel + JTextField) + 버튼 추가 및 새 창 표시
//3. 标签和文本字段 (JLabel + JTextField) + 添加按钮并在新窗口显示

import javax.swing.*;
import java.awt.event.*;

public class LabelTextField3_2 {
    public static void main(String[] args) {
        // 메인 프레임 생성 (입력창)
        // 创建主框架 (输入窗口)
        JFrame frame = new JFrame("입력 예제");
        
        // 패널 생성 - 컴포넌트들을 배치하기 위한 컨테이너
        // 创建面板 - 用于放置组件的容器
        JPanel panel = new JPanel();
        
        // 이름 라벨 추가
        // 添加姓名标签
        panel.add(new JLabel("이름:"));
        
        // 텍스트 필드 추가 (입력 가능, 15열 크기)
        // 添加文本字段 (可输入，15列大小)
        JTextField textField = new JTextField(15);
        panel.add(textField);
        
        // 확인 버튼 추가
        // 添加确认按钮
        JButton btn = new JButton("확인");
        panel.add(btn);
        
        // 버튼 클릭 이벤트 처리 (람다식 사용)
        // 处理按钮点击事件 (使用 Lambda 表达式)
        btn.addActionListener(e -> {
            // 텍스트 필드에서 입력된 이름을 가져옴
            // 从文本字段获取输入的姓名
            String name = textField.getText();
            
            // 이름이 비어있으면 경고 메시지 표시
            // 如果姓名为空，显示警告消息
            if (name.trim().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "이름을 입력해주세요!", "경고", JOptionPane.WARNING_MESSAGE);
                // "이름을 입력해주세요!" → "请输入姓名！"
                // "경고" → "警告"
                return;
            }
            
            // 새로운 창(프레임) 생성 - 입력받은 이름을 표시
            // 创建新窗口(框架) - 显示输入的姓名
            JFrame newFrame = new JFrame("환영합니다!");
            // "환영합니다!" → "欢迎！"
            
            // 새 창에 표시할 라벨 생성 (이름 표시)
            // 创建要在新窗口中显示的标签 (显示姓名)
            JLabel label = new JLabel(name + "님, 환영합니다! 🎉");
            // name + "님, 환영합니다! 🎉" → name + "님, 欢迎！🎉"
            
            // 라벨을 새 창에 추가
            // 将标签添加到新窗口
            newFrame.add(label);
            
            // 새 창 크기 설정
            // 设置新窗口大小
            newFrame.setSize(300, 150);
            
            // 새 창 닫기 버튼 동작 설정 (현재 창만 닫음)
            // 设置新窗口关闭按钮行为 (仅关闭当前窗口)
            newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
            // 새 창을 화면 중앙에 배치
            // 将新窗口置于屏幕中央
            newFrame.setLocationRelativeTo(null);
            
            // 새 창 표시
            // 显示新窗口
            newFrame.setVisible(true);
            
            // (선택사항) 입력 필드 초기화
            // (可选) 清空输入字段
            // textField.setText("");
        });
        
        // 메인 프레임에 패널 추가
        // 将面板添加到主框架
        frame.add(panel);
        
        // 메인 프레임 크기 설정
        // 设置主框架大小
        frame.setSize(350, 150);
        
        // 메인 프레임 닫기 버튼 동작 설정 (프로그램 종료)
        // 设置主框架关闭按钮行为 (程序终止)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 메인 프레임 표시
        // 显示主框架
        frame.setVisible(true);
    }
}