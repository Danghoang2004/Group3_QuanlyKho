package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import lienketdata.ConnectionDB_User;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField_tendn;
    private JPasswordField passwordField_matkhau;
    private ConnectionDB_User dbUser;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Login() {
        dbUser = new ConnectionDB_User();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 805, 460);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JLabel lblNewLabel_1 = new JLabel("ĐĂNG NHẬP TÀI KHOẢN");
        lblNewLabel_1.setForeground(Color.GREEN);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel_1.setBounds(249, 25, 301, 41);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Tên Tài Khoản");
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_2.setBounds(179, 132, 154, 27);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Mật Khẩu");
        lblNewLabel_3.setForeground(Color.WHITE);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_3.setBounds(179, 203, 121, 27);
        contentPane.add(lblNewLabel_3);

        textField_tendn = new JTextField();
        textField_tendn.setFont(new Font("Tahoma", Font.BOLD, 16));
        textField_tendn.setBounds(397, 135, 216, 25);
        contentPane.add(textField_tendn);
        textField_tendn.setColumns(10);
        this.setVisible(true);

        JButton btnNewButton = new JButton("Đăng Ký");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               Dangkytaikhoan d = new Dangkytaikhoan();
               d.setVisible(true);
               Login.this.setVisible(false); 
               
               
            }
        });
        btnNewButton.setBackground(Color.WHITE);
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnNewButton.setBounds(179, 293, 163, 41);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Đăng Nhập");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                int dn = JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng nhập không?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (dn != JOptionPane.YES_OPTION) {
                    return;
                }

                String ten = textField_tendn.getText();
                String pass = new String(passwordField_matkhau.getPassword());

                if (ten.equals("") || pass.equals("")) {
                    JOptionPane.showInternalMessageDialog(null, "Vui lòng điền đầy đủ thông tin");
                    return;
                }

                boolean isValid = dbUser.validateUser(ten, pass);
                if (isValid) {
                    JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
                    QLHHView q= new QLHHView();
                    q.setVisible(true);
                    Login.this.setVisible(false);
                   
                } else {
                    JOptionPane.showMessageDialog(null, "Tên tài khoản hoặc mật khẩu không đúng");
                }
            }
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnNewButton_1.setBounds(450, 293, 163, 41);
        contentPane.add(btnNewButton_1);

        passwordField_matkhau = new JPasswordField();
        passwordField_matkhau.setFont(new Font("Tahoma", Font.PLAIN, 12));
        passwordField_matkhau.setBounds(397, 206, 216, 25);
        contentPane.add(passwordField_matkhau);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\APP_quanlykhohang (2)\\APP_quanlykhohang\\src\\main\\java\\image\\pngtree-milky-way-and-universe-3d-illustration-stunning-night-sky-and-luminous-image_3723980.jpg"));
        lblNewLabel.setBounds(0, 0, 791, 425);
        contentPane.add(lblNewLabel);
    }
}
