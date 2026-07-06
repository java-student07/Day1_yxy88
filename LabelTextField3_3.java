package day1;
//3. 라벨과 텍스트 필드 (JLabel + JTextField) + 회원가입 폼
//3. 标签和文本字段 (JLabel + JTextField) + 注册表单

import javax.swing.*;
import java.awt.*;

public class LabelTextField3_3 {
    public static void main(String[] args) {
        // 메인 프레임 생성 (회원가입 창)
        // 创建主框架 (注册窗口)
        JFrame frame = new JFrame("회원가입");
        
        // 패널 생성 - GridLayout 사용 (4행 2열)
        // 创建面板 - 使用 GridLayout (4行 2列)
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        // GridLayout(rows, cols, hgap, vgap)
        // rows=4 (라벨+입력창 3쌍 + 버튼 1개)
        // cols=2 (라벨 열, 입력창 열)
        // hgap=10 (가로 간격), vgap=10 (세로 간격)
        
        // ----- 1. 이름 입력 -----
        // ----- 1. 姓名输入 -----
        panel.add(new JLabel("이름:"));                    // 이름 라벨
        JTextField nameField = new JTextField(15);        // 이름 입력창
        panel.add(nameField);
        
        // ----- 2. 비밀번호 입력 -----
        // ----- 2. 密码输入 -----
        panel.add(new JLabel("비밀번호:"));               // 비밀번호 라벨
        JPasswordField passwordField = new JPasswordField(15); // 비밀번호 입력창 (입력값이 ●로 표시됨)
        panel.add(passwordField);
        // JPasswordField는 입력 시 문자가 표시되지 않고 ● 또는 *로 표시됨 (보안용)
        // JPasswordField 输入时字符不显示，显示为 ● 或 * (用于安全)
        
        // ----- 3. 이메일 입력 -----
        // ----- 3. 邮箱输入 -----
        panel.add(new JLabel("이메일:"));                 // 이메일 라벨
        JTextField emailField = new JTextField(15);       // 이메일 입력창
        panel.add(emailField);
        
        // ----- 4. 회원가입 버튼 (2열 병합) -----
        // ----- 4. 注册按钮 (合并2列) -----
        JButton btn = new JButton("회원가입");
        // 버튼을 2열로 병합하기 위해 패널에 직접 추가하지 않고 별도 처리
        // 为了合并2列，不直接添加到面板，而是单独处理
        
        // 버튼 클릭 이벤트 처리 (람다식 사용)
        // 处理按钮点击事件 (使用 Lambda 表达式)
        btn.addActionListener(e -> {
            // 입력값 가져오기
            // 获取输入值
            String name = nameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();
            String email = emailField.getText().trim();
            
            // ----- 유효성 검사 (Validation) -----
            // ----- 有效性验证 -----
            
            // 1) 이름 확인
            // 1) 姓名验证
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(frame, 
                    "이름을 입력해주세요!", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                nameField.requestFocus(); // 이름 입력창으로 커서 이동
                return;
            }
            
            // 2) 비밀번호 확인 (최소 4자 이상)
            // 2) 密码验证 (最少4位以上)
            if (password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, 
                    "비밀번호를 입력해주세요!", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                passwordField.requestFocus();
                return;
            }
            if (password.length() < 4) {
                JOptionPane.showMessageDialog(frame, 
                    "비밀번호는 최소 4자 이상이어야 합니다!", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                passwordField.requestFocus();
                return;
            }
            
            // 3) 이메일 확인 (간단한 이메일 형식 체크 - @ 포함 여부)
            // 3) 邮箱验证 (简单检查 - 是否包含 @)
            if (email.isEmpty()) {
                JOptionPane.showMessageDialog(frame, 
                    "이메일을 입력해주세요!", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                emailField.requestFocus();
                return;
            }
            if (!email.contains("@")) {
                JOptionPane.showMessageDialog(frame, 
                    "올바른 이메일 형식이 아닙니다! (예: user@email.com)", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                emailField.requestFocus();
                return;
            }
            
            // ----- 모든 입력이 정상인 경우 회원 정보 출력 -----
            // ----- 所有输入正常时显示会员信息 -----
            
            // 회원 정보를 표시할 메시지 생성
            // 创建显示会员信息的消息
            String message = "🎉 회원가입 완료! 🎉\n\n"
                           + "━━━━━━━━━━━━━━━━━━━━\n"
                           + "📝 회원 정보\n"
                           + "━━━━━━━━━━━━━━━━━━━━\n"
                           + "이름   : " + name + "\n"
                           + "비밀번호 : " + "*".repeat(password.length()) + "\n"  // 보안을 위해 ●로 표시
                           + "이메일  : " + email + "\n"
                           + "━━━━━━━━━━━━━━━━━━━━\n"
                           + "환영합니다! 😊";
            
            // 메시지 다이얼로그로 회원 정보 표시
            // 用消息对话框显示会员信息
            JOptionPane.showMessageDialog(frame, 
                message, 
                "회원가입 성공", 
                JOptionPane.INFORMATION_MESSAGE);
            
            // (선택사항) 입력 필드 초기화
            // (可选) 清空输入字段
            // nameField.setText("");
            // passwordField.setText("");
            // emailField.setText("");
        });
        
        // 버튼을 패널에 추가 (4행 2열에서 마지막 행에 2열 병합)
        // 将按钮添加到面板 (在4行2列的最后一行合并2列)
        panel.add(btn);
        
        // 빈 공간 채우기 (버튼이 2열을 차지하도록)
        // 填充空白 (使按钮占据2列)
        // GridLayout은 4행 2열이므로 8개 셀이 필요함
        // 지금까지: 이름(라벨+필드) 2개 + 비번(라벨+필드) 2개 + 이메일(라벨+필드) 2개 + 버튼 1개 = 총 7개
        // 따라서 빈 셀 1개를 추가하여 8개(4행×2열)를 맞춤
        // GridLayout 是 4行 2列，需要 8 个单元格
        // 目前：姓名(标签+字段)2个 + 密码(标签+字段)2个 + 邮箱(标签+字段)2个 + 按钮1个 = 共7个
        // 因此添加1个空单元格以匹配8个(4行×2列)
        panel.add(new JLabel(""));  // 빈 라벨로 자리 채움 / 用空标签填充位置
        
        // 메인 프레임에 패널 추가
        // 将面板添加到主框架
        frame.add(panel);
        
        // 메인 프레임 크기 설정
        // 设置主框架大小
        frame.setSize(400, 200);
        
        // 프레임을 화면 중앙에 배치
        // 将窗口置于屏幕中央
        frame.setLocationRelativeTo(null);
        
        // 메인 프레임 닫기 버튼 동작 설정 (프로그램 종료)
        // 设置主框架关闭按钮行为 (程序终止)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 메인 프레임 표시
        // 显示主框架
        frame.setVisible(true);
    }
}