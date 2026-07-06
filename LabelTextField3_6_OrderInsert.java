package day1;
//3. 라벨과 텍스트 필드 (JLabel + JTextField) + 주문 등록 폼 (10개 필드)
//3. 标签和文本字段 (JLabel + JTextField) + 订单注册表单 (10个字段)

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LabelTextField3_6_OrderInsert {
    public static void main(String[] args) {
        // 메인 프레임 생성 (주문 등록 창)
        // 创建主框架 (订单注册窗口)
        JFrame frame = new JFrame("주문 등록");
        
        // 패널 생성 - GridLayout 사용 (11행 2열)
        // 创建面板 - 使用 GridLayout (11行 2列)
        // 10개 필드 + 버튼 1개 = 11행
        JPanel panel = new JPanel(new GridLayout(11, 2, 10, 5));
        // GridLayout(rows, cols, hgap, vgap)
        // rows=11 (라벨+입력창 10쌍 + 버튼 1개)
        // cols=2 (라벨 열, 입력창 열)
        // hgap=10 (가로 간격), vgap=5 (세로 간격)
        
        // ----- 1. 주문번호 입력 (자동 생성 제안) -----
        // ----- 1. 订单编号输入 (建议自动生成) -----
        panel.add(new JLabel("주문번호:"));                   // 주문번호 라벨
        // 현재 날짜와 시간 기반 주문번호 자동 생성 제안
        // 基于当前日期和时间自动生成订单编号建议
        String orderId = "ORD-" + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")) + "-" + System.currentTimeMillis() % 10000;
        JTextField orderIdField = new JTextField(orderId, 15); // 주문번호 입력창 (자동 입력 제안)
        orderIdField.setToolTipText("자동 생성된 주문번호입니다. 수정 가능합니다.");
        panel.add(orderIdField);
        
        // ----- 2. 회원 ID / 고객명 입력 -----
        // ----- 2. 会员ID / 客户姓名输入 -----
        panel.add(new JLabel("회원 ID / 고객명:"));           // 회원 ID 라벨
        JTextField customerField = new JTextField(15);       // 회원 ID 입력창
        customerField.setToolTipText("회원 ID 또는 고객명을 입력하세요.");
        panel.add(customerField);
        
        // ----- 3. 상품명 입력 -----
        // ----- 3. 商品名称输入 -----
        panel.add(new JLabel("상품명:"));                     // 상품명 라벨
        JTextField productNameField = new JTextField(15);    // 상품명 입력창
        panel.add(productNameField);
        
        // ----- 4. 상품 코드 입력 -----
        // ----- 4. 商品编号输入 -----
        panel.add(new JLabel("상품 코드:"));                  // 상품 코드 라벨
        JTextField productCodeField = new JTextField(15);    // 상품 코드 입력창
        productCodeField.setToolTipText("예: P-2026-0001");
        panel.add(productCodeField);
        
        // ----- 5. 주문 수량 입력 -----
        // ----- 5. 订购数量输入 -----
        panel.add(new JLabel("주문 수량:"));                  // 주문 수량 라벨
        JTextField quantityField = new JTextField(15);       // 주문 수량 입력창
        quantityField.setToolTipText("예: 2");
        panel.add(quantityField);
        
        // ----- 6. 단가 입력 -----
        // ----- 6. 单价输入 -----
        panel.add(new JLabel("단가 (원):"));                  // 단가 라벨
        JTextField unitPriceField = new JTextField(15);      // 단가 입력창
        unitPriceField.setToolTipText("예: 50000");
        panel.add(unitPriceField);
        
        // ----- 7. 총 금액 (자동 계산 - 읽기 전용) -----
        // ----- 7. 总金额 (自动计算 - 只读) -----
        panel.add(new JLabel("총 금액 (원):"));               // 총 금액 라벨
        JTextField totalField = new JTextField("0", 15);     // 총 금액 입력창 (자동 계산)
        totalField.setEditable(false);                       // 수정 불가능 (읽기 전용)
        totalField.setBackground(new Color(240, 240, 240)); // 배경색 회색으로 변경
        totalField.setHorizontalAlignment(JTextField.RIGHT); // 오른쪽 정렬
        panel.add(totalField);
        
        // ----- 8. 배송지 주소 입력 -----
        // ----- 8. 配送地址输入 -----
        panel.add(new JLabel("배송지 주소:"));                // 배송지 주소 라벨
        JTextField addressField = new JTextField(15);        // 배송지 주소 입력창
        panel.add(addressField);
        
        // ----- 9. 연락처 입력 -----
        // ----- 9. 联系方式输入 -----
        panel.add(new JLabel("연락처:"));                     // 연락처 라벨
        JTextField phoneField = new JTextField(15);          // 연락처 입력창
        phoneField.setToolTipText("예: 010-1234-5678");
        panel.add(phoneField);
        
        // ----- 10. 주문일자 (자동 생성 - 읽기 전용) -----
        // ----- 10. 订单日期 (自动生成 - 只读) -----
        panel.add(new JLabel("주문일자:"));                   // 주문일자 라벨
        
        // 현재 날짜 자동 생성 (YYYY-MM-DD HH:mm:ss 형식)
        // 自动生成当前日期 (YYYY-MM-DD HH:mm:ss 格式)
        String now = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + " " + 
                     java.time.LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        JTextField dateField = new JTextField(now, 15);      // 주문일자 입력창 (자동 입력)
        dateField.setEditable(false);                        // 수정 불가능 (읽기 전용)
        dateField.setBackground(new Color(240, 240, 240));  // 배경색 회색으로 변경
        panel.add(dateField);
        
        // ----- 11. 주문 등록 버튼 (2열 병합) -----
        // ----- 11. 订单注册按钮 (合并2列) -----
        JButton btn = new JButton("주문 등록");
        
        // 버튼 클릭 이벤트 처리 (람다식 사용)
        // 处理按钮点击事件 (使用 Lambda 表达式)
        btn.addActionListener(e -> {
            // 입력값 가져오기
            // 获取输入值
            String orderIdVal = orderIdField.getText().trim();
            String customer = customerField.getText().trim();
            String productName = productNameField.getText().trim();
            String productCode = productCodeField.getText().trim();
            String quantity = quantityField.getText().trim();
            String unitPrice = unitPriceField.getText().trim();
            // ★★★ 수정: 쉼표 제거 후 파싱 ★★★
            // ★★★ 修改: 移除逗号后解析 ★★★
            String total = totalField.getText().trim().replaceAll(",", "");
            String address = addressField.getText().trim();
            String phone = phoneField.getText().trim();
            String orderDate = dateField.getText().trim();
            
            // ----- 유효성 검사 (Validation) -----
            // ----- 有效性验证 -----
            
            // 1) 주문번호 확인
            // 1) 订单编号验证
            if (orderIdVal.isEmpty()) {
                JOptionPane.showMessageDialog(frame, 
                    "주문번호를 입력해주세요!", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                orderIdField.requestFocus();
                return;
            }
            
            // 2) 회원 ID / 고객명 확인
            // 2) 会员ID / 客户姓名验证
            if (customer.isEmpty()) {
                JOptionPane.showMessageDialog(frame, 
                    "회원 ID 또는 고객명을 입력해주세요!", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                customerField.requestFocus();
                return;
            }
            
            // 3) 상품명 확인
            // 3) 商品名称验证
            if (productName.isEmpty()) {
                JOptionPane.showMessageDialog(frame, 
                    "상품명을 입력해주세요!", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                productNameField.requestFocus();
                return;
            }
            
            // 4) 상품 코드 확인
            // 4) 商品编号验证
            if (productCode.isEmpty()) {
                JOptionPane.showMessageDialog(frame, 
                    "상품 코드를 입력해주세요!", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                productCodeField.requestFocus();
                return;
            }
            
            // 5) 주문 수량 확인 (숫자만 입력 가능, 1 이상)
            // 5) 订购数量验证 (只能输入数字, 1以上)
            if (quantity.isEmpty()) {
                JOptionPane.showMessageDialog(frame, 
                    "주문 수량을 입력해주세요!", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                quantityField.requestFocus();
                return;
            }
            try {
                int qty = Integer.parseInt(quantity);
                if (qty <= 0) {
                    JOptionPane.showMessageDialog(frame, 
                        "주문 수량은 1개 이상이어야 합니다!", 
                        "입력 오류", 
                        JOptionPane.WARNING_MESSAGE);
                    quantityField.requestFocus();
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, 
                    "올바른 수량을 입력해주세요! (숫자만 가능)", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                quantityField.requestFocus();
                return;
            }
            
            // 6) 단가 확인 (숫자만 입력 가능, 0 이상)
            // 6) 单价验证 (只能输入数字, 0以上)
            if (unitPrice.isEmpty()) {
                JOptionPane.showMessageDialog(frame, 
                    "단가를 입력해주세요!", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                unitPriceField.requestFocus();
                return;
            }
            try {
                int price = Integer.parseInt(unitPrice);
                if (price < 0) {
                    JOptionPane.showMessageDialog(frame, 
                        "단가는 0 이상이어야 합니다!", 
                        "입력 오류", 
                        JOptionPane.WARNING_MESSAGE);
                    unitPriceField.requestFocus();
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, 
                    "올바른 단가를 입력해주세요! (숫자만 가능)", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                unitPriceField.requestFocus();
                return;
            }
            
            // 7) 총 금액이 자동 계산되었는지 확인
            // 7) 总金额是否自动计算验证
            // ★★★ 수정: total 변수는 이미 쉼표가 제거된 상태 ★★★
            // ★★★ 修改: total 变量已移除逗号 ★★★
            if (total.equals("0") || total.isEmpty()) {
                JOptionPane.showMessageDialog(frame, 
                    "수량과 단가를 입력하면 총 금액이 자동 계산됩니다.\n수량과 단가를 다시 확인해주세요!", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                quantityField.requestFocus();
                return;
            }
            
            // 8) 배송지 주소 확인
            // 8) 配送地址验证
            if (address.isEmpty()) {
                JOptionPane.showMessageDialog(frame, 
                    "배송지 주소를 입력해주세요!", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                addressField.requestFocus();
                return;
            }
            
            // 9) 연락처 확인 (간단한 형식 체크)
            // 9) 联系方式验证 (简单格式检查)
            if (phone.isEmpty()) {
                JOptionPane.showMessageDialog(frame, 
                    "연락처를 입력해주세요! (예: 010-1234-5678)", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                phoneField.requestFocus();
                return;
            }
            // 숫자, 하이픈(-), 공백만 허용 (간단한 검사)
            if (!phone.matches("[0-9\\-\\s]+")) {
                JOptionPane.showMessageDialog(frame, 
                    "올바른 연락처 형식이 아닙니다! (예: 010-1234-5678)", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                phoneField.requestFocus();
                return;
            }
            
            // ----- 모든 입력이 정상인 경우 주문 정보 출력 -----
            // ----- 所有输入正常时显示订单信息 -----
            
            // ★★★ 수정: total을 정수로 변환할 때 쉼표 제거된 값 사용 ★★★
            // ★★★ 修改: 将total转换为整数时使用已移除逗号的值 ★★★
            int totalAmount = Integer.parseInt(total);
            
            // 주문 정보를 표시할 메시지 생성
            // 创建显示订单信息的消息
            String message = "🎉 주문 등록 완료! 🎉\n\n"
                           + "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n"
                           + "📦 주문 정보\n"
                           + "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n"
                           + "주문번호    : " + orderIdVal + "\n"
                           + "회원 ID     : " + customer + "\n"
                           + "상품명      : " + productName + "\n"
                           + "상품 코드   : " + productCode + "\n"
                           + "주문 수량   : " + String.format("%,d", Integer.parseInt(quantity)) + "개\n"
                           + "단가        : " + String.format("%,d", Integer.parseInt(unitPrice)) + "원\n"
                           + "총 금액     : " + String.format("%,d", totalAmount) + "원\n"
                           + "배송지 주소 : " + address + "\n"
                           + "연락처      : " + phone + "\n"
                           + "주문일자    : " + orderDate + "\n"
                           + "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n"
                           + "😊 주문이 성공적으로 등록되었습니다!";
            
            // 메시지 다이얼로그로 주문 정보 표시
            // 用消息对话框显示订单信息
            JOptionPane.showMessageDialog(frame, 
                message, 
                "주문 등록 성공", 
                JOptionPane.INFORMATION_MESSAGE);
            
            // (선택사항) 입력 필드 초기화
            // (可选) 清空输入字段
            // orderIdField.setText("ORD-" + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")) + "-" + System.currentTimeMillis() % 10000);
            // customerField.setText("");
            // productNameField.setText("");
            // productCodeField.setText("");
            // quantityField.setText("");
            // unitPriceField.setText("");
            // totalField.setText("0");
            // addressField.setText("");
            // phoneField.setText("");
        });
        
        // ----- 수량 또는 단가 변경 시 총 금액 자동 계산 (이벤트 추가) -----
        // ----- 数量或单价变更时自动计算总金额 (添加事件) -----
        
        // 수량 변경 시 총 금액 재계산
        // 数量变更时重新计算总金额
        quantityField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                calculateTotal(quantityField, unitPriceField, totalField);
            }
        });
        
        // 단가 변경 시 총 금액 재계산
        // 单价变更时重新计算总金额
        unitPriceField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                calculateTotal(quantityField, unitPriceField, totalField);
            }
        });
        
        // 버튼을 패널에 추가 (마지막 행에 2열 병합)
        // 将按钮添加到面板 (最后一行合并2列)
        panel.add(btn);
        
        // 빈 공간 채우기 (버튼이 2열을 차지하도록)
        // 填充空白 (使按钮占据2列)
        // GridLayout은 11행 2열이므로 22개 셀이 필요함
        // 지금까지: 10개 필드(라벨+입력창) = 20개 + 버튼 1개 = 총 21개
        // 따라서 빈 셀 1개를 추가하여 22개(11행×2열)를 맞춤
        panel.add(new JLabel(""));  // 빈 라벨로 자리 채움
        
        // 메인 프레임에 패널 추가
        // 将面板添加到主框架
        frame.add(panel);
        
        // 메인 프레임 크기 설정
        // 设置主框架大小
        frame.setSize(500, 550);
        
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
    
    // ----- 총 금액 자동 계산 메서드 -----
    // ----- 总金额自动计算方法 -----
    private static void calculateTotal(JTextField quantityField, JTextField unitPriceField, JTextField totalField) {
        try {
            String qtyText = quantityField.getText().trim();
            String priceText = unitPriceField.getText().trim();
            
            if (!qtyText.isEmpty() && !priceText.isEmpty()) {
                int qty = Integer.parseInt(qtyText);
                int price = Integer.parseInt(priceText);
                int total = qty * price;
                
                // 천 단위 쉼표 표시
                // 显示千位分隔符
                totalField.setText(String.format("%,d", total));
            } else {
                totalField.setText("0");
            }
        } catch (NumberFormatException ex) {
            // 숫자가 아닌 값이 입력되면 총 금액을 0으로 설정
            // 如果输入了非数字值，将总金额设为0
            totalField.setText("0");
        }
    }
}