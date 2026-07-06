package day1;
//3. 라벨과 텍스트 필드 (JLabel + JTextField) + 상품 등록 폼 (10개 필드)
//3. 标签和文本字段 (JLabel + JTextField) + 商品注册表单 (10个字段)

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LabelTextField3_5_GoodsInsert {
    public static void main(String[] args) {
        // 메인 프레임 생성 (상품 등록 창)
        // 创建主框架 (商品注册窗口)
        JFrame frame = new JFrame("상품 등록");
        
        // 패널 생성 - GridLayout 사용 (11행 2열)
        // 创建面板 - 使用 GridLayout (11行 2列)
        // 10개 필드 + 버튼 1개 = 11행
        JPanel panel = new JPanel(new GridLayout(11, 2, 10, 5));
        // GridLayout(rows, cols, hgap, vgap)
        // rows=11 (라벨+입력창 10쌍 + 버튼 1개)
        // cols=2 (라벨 열, 입력창 열)
        // hgap=10 (가로 간격), vgap=5 (세로 간격)
        
        // ----- 1. 상품명 입력 -----
        // ----- 1. 商品名称输入 -----
        panel.add(new JLabel("상품명:"));                     // 상품명 라벨
        JTextField nameField = new JTextField(15);           // 상품명 입력창
        panel.add(nameField);
        
        // ----- 2. 상품 코드 입력 -----
        // ----- 2. 商品编号输入 -----
        panel.add(new JLabel("상품 코드:"));                  // 상품 코드 라벨
        JTextField codeField = new JTextField(15);           // 상품 코드 입력창
        codeField.setToolTipText("예: P-2026-0001");
        panel.add(codeField);
        
        // ----- 3. 카테고리 / 분류 입력 (콤보박스 사용) -----
        // ----- 3. 商品分类输入 (使用下拉列表) -----
        panel.add(new JLabel("카테고리 / 분류:"));            // 카테고리 라벨
        String[] categories = {"선택하세요", "전자제품", "의류", "식품", "도서", "가구", "뷰티", "스포츠", "완구", "기타"};
        JComboBox<String> categoryCombo = new JComboBox<>(categories);
        panel.add(categoryCombo);
        
        // ----- 4. 가격 입력 -----
        // ----- 4. 价格输入 -----
        panel.add(new JLabel("가격 (원):"));                  // 가격 라벨
        JTextField priceField = new JTextField(15);          // 가격 입력창
        priceField.setToolTipText("예: 50000");
        panel.add(priceField);
        
        // ----- 5. 할인가 / 판매가 입력 -----
        // ----- 5. 折扣价 / 销售价输入 -----
        panel.add(new JLabel("할인가 / 판매가 (원):"));       // 할인가 라벨
        JTextField salePriceField = new JTextField(15);      // 할인가 입력창
        salePriceField.setToolTipText("예: 45000 (할인 적용 시)");
        panel.add(salePriceField);
        
        // ----- 6. 재고 수량 입력 -----
        // ----- 6. 库存数量输入 -----
        panel.add(new JLabel("재고 수량:"));                  // 재고 수량 라벨
        JTextField stockField = new JTextField(15);          // 재고 수량 입력창
        stockField.setToolTipText("예: 100");
        panel.add(stockField);
        
        // ----- 7. 상품 설명 입력 (텍스트 영역 사용) -----
        // ----- 7. 商品描述输入 (使用文本区域) -----
        panel.add(new JLabel("상품 설명:"));                  // 상품 설명 라벨
        
        // JTextArea는 여러 줄 입력 가능 (JTextField는 한 줄)
        // JTextArea 可以输入多行 (JTextField 只能输入一行)
        JTextArea descArea = new JTextArea(3, 15);           // 3행 15열 텍스트 영역
        descArea.setLineWrap(true);                          // 자동 줄바꿈
        descArea.setWrapStyleWord(true);                     // 단어 단위 줄바꿈
        JScrollPane scrollPane = new JScrollPane(descArea);  // 스크롤 가능하도록 추가
        panel.add(scrollPane);
        
        // ----- 8. 제조사 / 브랜드 입력 -----
        // ----- 8. 制造商 / 品牌输入 -----
        panel.add(new JLabel("제조사 / 브랜드:"));            // 제조사 라벨
        JTextField brandField = new JTextField(15);          // 제조사 입력창
        panel.add(brandField);
        
        // ----- 9. 원산지 입력 (콤보박스 사용) -----
        // ----- 9. 产地输入 (使用下拉列表) -----
        panel.add(new JLabel("원산지:"));                     // 원산지 라벨
        String[] origins = {"선택하세요", "한국", "중국", "일본", "미국", "유럽", "동남아", "기타"};
        JComboBox<String> originCombo = new JComboBox<>(origins);
        panel.add(originCombo);
        
        // ----- 10. 등록일 (자동 생성 - 읽기 전용) -----
        // ----- 10. 登记日期 (自动生成 - 只读) -----
        panel.add(new JLabel("등록일:"));                     // 등록일 라벨
        
        // 현재 날짜 자동 생성 (YYYY-MM-DD 형식)
        // 自动生成当前日期 (YYYY-MM-DD 格式)
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        JTextField dateField = new JTextField(today, 15);    // 등록일 입력창 (자동 입력)
        dateField.setEditable(false);                        // 수정 불가능 (읽기 전용)
        dateField.setBackground(new Color(240, 240, 240));  // 배경색 회색으로 변경
        panel.add(dateField);
        
        // ----- 11. 상품 등록 버튼 (2열 병합) -----
        // ----- 11. 商品注册按钮 (合并2列) -----
        JButton btn = new JButton("상품 등록");
        
        // 버튼 클릭 이벤트 처리 (람다식 사용)
        // 处理按钮点击事件 (使用 Lambda 表达式)
        btn.addActionListener(e -> {
            // 입력값 가져오기
            // 获取输入值
            String name = nameField.getText().trim();
            String code = codeField.getText().trim();
            String category = (String) categoryCombo.getSelectedItem();
            String price = priceField.getText().trim();
            String salePrice = salePriceField.getText().trim();
            String stock = stockField.getText().trim();
            String description = descArea.getText().trim();
            String brand = brandField.getText().trim();
            String origin = (String) originCombo.getSelectedItem();
            String regDate = dateField.getText().trim();
            
            // ----- 유효성 검사 (Validation) -----
            // ----- 有效性验证 -----
            
            // 1) 상품명 확인
            // 1) 商品名称验证
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(frame, 
                    "상품명을 입력해주세요!", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                nameField.requestFocus();
                return;
            }
            
            // 2) 상품 코드 확인 (최소 3자 이상)
            // 2) 商品编号验证 (最少3位以上)
            if (code.isEmpty()) {
                JOptionPane.showMessageDialog(frame, 
                    "상품 코드를 입력해주세요!", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                codeField.requestFocus();
                return;
            }
            if (code.length() < 3) {
                JOptionPane.showMessageDialog(frame, 
                    "상품 코드는 최소 3자 이상이어야 합니다!", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                codeField.requestFocus();
                return;
            }
            
            // 3) 카테고리 확인
            // 3) 商品分类验证
            if (category.equals("선택하세요")) {
                JOptionPane.showMessageDialog(frame, 
                    "카테고리를 선택해주세요!", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                categoryCombo.requestFocus();
                return;
            }
            
            // 4) 가격 확인 (숫자만 입력 가능)
            // 4) 价格验证 (只能输入数字)
            if (price.isEmpty()) {
                JOptionPane.showMessageDialog(frame, 
                    "가격을 입력해주세요!", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                priceField.requestFocus();
                return;
            }
            try {
                int priceNum = Integer.parseInt(price);
                if (priceNum <= 0) {
                    JOptionPane.showMessageDialog(frame, 
                        "가격은 0보다 커야 합니다!", 
                        "입력 오류", 
                        JOptionPane.WARNING_MESSAGE);
                    priceField.requestFocus();
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, 
                    "올바른 가격을 입력해주세요! (숫자만 가능)", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                priceField.requestFocus();
                return;
            }
            
            // 5) 할인가 확인 (선택사항 - 입력된 경우에만 검증)
            // 5) 折扣价验证 (可选 - 仅当输入时验证)
            if (!salePrice.isEmpty()) {
                try {
                    int saleNum = Integer.parseInt(salePrice);
                    int priceNum = Integer.parseInt(price);
                    if (saleNum >= priceNum) {
                        JOptionPane.showMessageDialog(frame, 
                            "할인가는 원래 가격보다 낮아야 합니다!", 
                            "입력 오류", 
                            JOptionPane.WARNING_MESSAGE);
                        salePriceField.requestFocus();
                        return;
                    }
                    if (saleNum < 0) {
                        JOptionPane.showMessageDialog(frame, 
                            "할인가는 0 이상이어야 합니다!", 
                            "입력 오류", 
                            JOptionPane.WARNING_MESSAGE);
                        salePriceField.requestFocus();
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, 
                        "올바른 할인가를 입력해주세요! (숫자만 가능)", 
                        "입력 오류", 
                        JOptionPane.WARNING_MESSAGE);
                    salePriceField.requestFocus();
                    return;
                }
            }
            
            // 6) 재고 수량 확인 (숫자만 입력 가능)
            // 6) 库存数量验证 (只能输入数字)
            if (stock.isEmpty()) {
                JOptionPane.showMessageDialog(frame, 
                    "재고 수량을 입력해주세요!", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                stockField.requestFocus();
                return;
            }
            try {
                int stockNum = Integer.parseInt(stock);
                if (stockNum < 0) {
                    JOptionPane.showMessageDialog(frame, 
                        "재고 수량은 0 이상이어야 합니다!", 
                        "입력 오류", 
                        JOptionPane.WARNING_MESSAGE);
                    stockField.requestFocus();
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, 
                    "올바른 재고 수량을 입력해주세요! (숫자만 가능)", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                stockField.requestFocus();
                return;
            }
            
            // 7) 상품 설명 확인 (선택사항 - 10자 이상 권장)
            // 7) 商品描述验证 (可选 - 建议10字以上)
            if (!description.isEmpty() && description.length() < 10) {
                int confirm = JOptionPane.showConfirmDialog(frame, 
                    "상품 설명이 너무 짧습니다 (현재 " + description.length() + "자).\n그래도 계속하시겠습니까?", 
                    "확인", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.WARNING_MESSAGE);
                if (confirm != JOptionPane.YES_OPTION) {
                    return;
                }
            }
            
            // 8) 제조사 / 브랜드 확인
            // 8) 制造商 / 品牌验证
            if (brand.isEmpty()) {
                JOptionPane.showMessageDialog(frame, 
                    "제조사 또는 브랜드를 입력해주세요!", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                brandField.requestFocus();
                return;
            }
            
            // 9) 원산지 확인
            // 9) 产地验证
            if (origin.equals("선택하세요")) {
                JOptionPane.showMessageDialog(frame, 
                    "원산지를 선택해주세요!", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                originCombo.requestFocus();
                return;
            }
            
            // ----- 모든 입력이 정상인 경우 상품 정보 출력 -----
            // ----- 所有输入正常时显示商品信息 -----
            
            // 상품 정보를 표시할 메시지 생성
            // 创建显示商品信息的消息
            String message = "🎉 상품 등록 완료! 🎉\n\n"
                           + "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n"
                           + "📦 상품 정보\n"
                           + "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n"
                           + "상품명      : " + name + "\n"
                           + "상품 코드   : " + code + "\n"
                           + "카테고리    : " + category + "\n"
                           + "가격        : " + String.format("%,d", Integer.parseInt(price)) + "원\n"
                           + "할인가      : " + (salePrice.isEmpty() ? "없음" : String.format("%,d", Integer.parseInt(salePrice)) + "원") + "\n"
                           + "재고 수량   : " + String.format("%,d", Integer.parseInt(stock)) + "개\n"
                           + "상품 설명   : " + (description.isEmpty() ? "없음" : description) + "\n"
                           + "제조사      : " + brand + "\n"
                           + "원산지      : " + origin + "\n"
                           + "등록일      : " + regDate + "\n"
                           + "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n"
                           + "😊 상품이 성공적으로 등록되었습니다!";
            
            // 메시지 다이얼로그로 상품 정보 표시
            // 用消息对话框显示商品信息
            JOptionPane.showMessageDialog(frame, 
                message, 
                "상품 등록 성공", 
                JOptionPane.INFORMATION_MESSAGE);
            
            // (선택사항) 입력 필드 초기화
            // (可选) 清空输入字段
            // nameField.setText("");
            // codeField.setText("");
            // categoryCombo.setSelectedIndex(0);
            // priceField.setText("");
            // salePriceField.setText("");
            // stockField.setText("");
            // descArea.setText("");
            // brandField.setText("");
            // originCombo.setSelectedIndex(0);
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
        frame.setSize(500, 600);
        
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