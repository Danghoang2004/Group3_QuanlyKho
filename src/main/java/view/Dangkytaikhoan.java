package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import lienketdata.ConnectionDB_User;
import java.awt.event.ActionEvent;

public class Dangkytaikhoan extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField_tennd;
    private JTextField textField_gmail;
    private JPasswordField passwordField_pass;
    private JPasswordField passwordField_confirmpass;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Dangkytaikhoan frame = new Dangkytaikhoan();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Dangkytaikhoan() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 815, 460);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblNewLabel_1 = new JLabel("ĐĂNG KÝ TÀI KHOẢN");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblNewLabel_1.setForeground(Color.GREEN);
        lblNewLabel_1.setBounds(277, 22, 267, 45);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Tên Người Dùng");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setBounds(157, 111, 150, 19);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Gmail");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_3.setForeground(Color.WHITE);
        lblNewLabel_3.setBounds(157, 154, 85, 24);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Mật Khẩu");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_4.setForeground(Color.white);
                lblNewLabel_4.setBounds(157, 203, 111, 21);
                contentPane.add(lblNewLabel_4);

                JLabel lblNewLabel_5 = new JLabel("Nhập Lại Mật Khẩu");
                lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
                lblNewLabel_5.setForeground(Color.WHITE);
                lblNewLabel_5.setBounds(157, 248, 164, 18);
                contentPane.add(lblNewLabel_5);

                textField_tennd = new JTextField();
                textField_tennd.setFont(new Font("Tahoma", Font.BOLD, 12));
                textField_tennd.setBounds(424, 108, 221, 24);
                contentPane.add(textField_tennd);
                textField_tennd.setColumns(10);

                textField_gmail = new JTextField();
                textField_gmail.setFont(new Font("Tahoma", Font.BOLD, 12));
                textField_gmail.setBounds(424, 154, 221, 24);
                contentPane.add(textField_gmail);
                textField_gmail.setColumns(10);

                passwordField_pass = new JPasswordField();
                passwordField_pass.setFont(new Font("Tahoma", Font.BOLD, 12));
                passwordField_pass.setBounds(424, 201, 221, 24);
                contentPane.add(passwordField_pass);

                passwordField_confirmpass = new JPasswordField();
                passwordField_confirmpass.setFont(new Font("Tahoma", Font.BOLD, 12));
                passwordField_confirmpass.setBounds(424, 246, 221, 24);
                contentPane.add(passwordField_confirmpass);

                JButton btnNewButton_dangnhap = new JButton("Đăng Nhập");
                btnNewButton_dangnhap.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		Login l= new Login();
                		l.setVisible(true);
                		Dangkytaikhoan.this.setVisible(false);
                		
                	}
                });
                btnNewButton_dangnhap.setFont(new Font("Tahoma", Font.BOLD, 16));
                btnNewButton_dangnhap.setBounds(157, 314, 140, 45);
                contentPane.add(btnNewButton_dangnhap);

                JButton btnNewButton_dangky = new JButton("Đăng Ký");
                btnNewButton_dangky.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int dk = JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng ký", "Confirm", JOptionPane.YES_NO_OPTION);
                        if (dk != JOptionPane.YES_OPTION) {
                            return;
                        }

                        String tennd = textField_tennd.getText();
                        String gmail = textField_gmail.getText();
                        String pass = new String(passwordField_pass.getPassword());
                        String confirmPass = new String(passwordField_confirmpass.getPassword());

                        if (tennd.equals("") || gmail.equals("") || pass.equals("") || confirmPass.equals("")) {
                            JOptionPane.showMessageDialog(null, "Không để trống thông tin");
                            return;
                        }

                        if (!pass.equals(confirmPass)) {
                            JOptionPane.showMessageDialog(null, "Mật khẩu không khớp");
                            return;
                        }

                        ConnectionDB_User connectionDB = new ConnectionDB_User();
                        if (connectionDB.insertUser(tennd, gmail, pass)) {
                            JOptionPane.showMessageDialog(null, "Tạo tài khoản thành công");
                            Login l = new Login();
                            l.setVisible(true);
                            Dangkytaikhoan.this.setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(null, "Tạo tài khoản thất bại");
                        }
                    }
                });
                btnNewButton_dangky.setFont(new Font("Tahoma", Font.BOLD, 16));
                btnNewButton_dangky.setBounds(488, 314, 157, 45); 
                contentPane.add(btnNewButton_dangky);

                JLabel lblNewLabel = new JLabel("");
                lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\APP_quanlykhohang (2)\\APP_quanlykhohang\\src\\main\\java\\image\\pngtree-beautiful-space-background-with-stars-and-nebula-image_15614004.jpg"));
                lblNewLabel.setBounds(0, 0, 801, 423);
                contentPane.add(lblNewLabel);
            }
        }

