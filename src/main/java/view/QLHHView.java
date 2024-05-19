package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.HangHoa;
import model.QLHHModel;
import model.Tinh;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.Action;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.QLHHController;

import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.event.ActionListener;

public class QLHHView extends JFrame {

	private JPanel contentPane;
	public QLHHModel model;
	public JTextField textField_MaID_TimKiem;
	public JTable table;
	public JTextField textField_maID;
	public JTextField textField_TenSanpham;
	public JTextField textField_NgayNhap;
	public JTextField textField_SoTienNhap;
	public JTextField textField_SoTienBan;
	public JTextField textField_SoLuong;
	public ButtonGroup btn_loaiSanPham;
	public JComboBox comboBox_noiSanXuat;
	public JRadioButton rdbtnThng;
	public JRadioButton rdbtnVip;
	public JComboBox comboBox_noiSanXuat_timKiem;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLHHView frame = new QLHHView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public QLHHView() {
		this.model = new QLHHModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 751);
		this.setTitle("App Quản Lý Hàng Hóa ");		
		Action action = new QLHHController(this);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuFile = new JMenu("File");
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menuFile);

		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(action);
		menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(menuOpen);

		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(action);
		menuSave.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(menuSave);

		JSeparator separator = new JSeparator();
		menuFile.add(separator);

		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(action);
		menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(menuExit);

		JMenu menuAbout = new JMenu("About");
		menuAbout.addActionListener(action);
		menuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menuAbout);

		JMenuItem menuAboutMe = new JMenuItem("About Me");
		menuAboutMe.addActionListener(action);
		menuAboutMe.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuAbout.add(menuAboutMe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBounds(44, 144, -28, -35);
		contentPane.add(verticalBox_1);

		JLabel lblNiSnXut_1 = new JLabel("Nơi sản Xuất");
		lblNiSnXut_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNiSnXut_1.setBounds(10, 13, 92, 54);
		contentPane.add(lblNiSnXut_1);

		JLabel lblMSnPhm_1 = new JLabel("Mã Sản Phẩm");
		lblMSnPhm_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMSnPhm_1.setBounds(285, 13, 102, 52);
		contentPane.add(lblMSnPhm_1);

		textField_MaID_TimKiem = new JTextField();
		textField_MaID_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_MaID_TimKiem.setColumns(10);
		textField_MaID_TimKiem.setBounds(388, 21, 123, 42);
		contentPane.add(textField_MaID_TimKiem);

		JButton btnTim = new JButton("T\u00ECm");
		btnTim.addActionListener(action);
		btnTim.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTim.setBounds(532, 21, 89, 42);
		contentPane.add(btnTim);

		comboBox_noiSanXuat_timKiem = new JComboBox();
		ArrayList listTinh = Tinh.getDSTinh();
		comboBox_noiSanXuat_timKiem.addItem("");
		for (Object item : listTinh) {
		    Tinh tinh = (Tinh) item;
		    comboBox_noiSanXuat_timKiem.addItem(tinh.getTenTinh());
		}

		comboBox_noiSanXuat_timKiem.setBounds(112, 21, 155, 42);
		contentPane.add(comboBox_noiSanXuat_timKiem);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 92, 738, 2);
		contentPane.add(separator_1);

		JLabel lblDanhSchHng = new JLabel("Danh sách hàng hóa");
		lblDanhSchHng.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDanhSchHng.setBounds(10, 97, 251, 54);
		contentPane.add(lblDanhSchHng);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã sản phẩm ", "Tên sản phẩm", "Nơi sản xuất", "Ngày Nhập",
						"Loại hàng hóa", "Số tiền nhập ", "Số tiền bán", "Số lượng" }));

		table.setRowHeight(25);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 144, 738, 214);
		contentPane.add(scrollPane);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 369, 738, 2);
		contentPane.add(separator_1_1);

		JLabel lblThngTinHng = new JLabel("Thông tin hàng hóa");
		lblThngTinHng.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblThngTinHng.setBounds(10, 369, 233, 54);
		contentPane.add(lblThngTinHng);

		JLabel lblMSnPhm = new JLabel("Mã Sản Phẩm");
		lblMSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMSnPhm.setBounds(10, 412, 102, 54);
		contentPane.add(lblMSnPhm);

		textField_maID = new JTextField();
		textField_maID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_maID.setColumns(10);
		textField_maID.setBounds(127, 425, 166, 29);
		contentPane.add(textField_maID);

		JLabel lblTnSnPhm = new JLabel("Tên sản phẩm");
		lblTnSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnSnPhm.setBounds(10, 457, 102, 54);
		contentPane.add(lblTnSnPhm);

		textField_TenSanpham = new JTextField();
		textField_TenSanpham.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_TenSanpham.setColumns(10);
		textField_TenSanpham.setBounds(127, 470, 166, 29);
		contentPane.add(textField_TenSanpham);

		JLabel lblNiSnXut = new JLabel("Nơi sản xuất");
		lblNiSnXut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNiSnXut.setBounds(10, 510, 102, 54);
		contentPane.add(lblNiSnXut);

		comboBox_noiSanXuat = new JComboBox();
		comboBox_noiSanXuat.addItem("");
		for (Object item : listTinh) {
		    Tinh tinh = (Tinh) item;
		    comboBox_noiSanXuat.addItem(tinh.getTenTinh());
		}

		comboBox_noiSanXuat.setBounds(127, 522, 166, 35);
		contentPane.add(comboBox_noiSanXuat);

		JLabel lblNgyNhp = new JLabel("Ngày Nhập");
		lblNgyNhp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgyNhp.setBounds(10, 563, 155, 54);
		contentPane.add(lblNgyNhp);

		textField_NgayNhap = new JTextField();
		textField_NgayNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_NgayNhap.setColumns(10);
		textField_NgayNhap.setBounds(127, 576, 166, 29);
		contentPane.add(textField_NgayNhap);

		JLabel lblLoiSnPhm = new JLabel("Loại sản phẩm");
		lblLoiSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLoiSnPhm.setBounds(324, 412, 100, 54);
		contentPane.add(lblLoiSnPhm);

		rdbtnThng = new JRadioButton("Thường");
		rdbtnThng.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnThng.setBounds(450, 429, 85, 23);
		contentPane.add(rdbtnThng);

		rdbtnVip = new JRadioButton("Vip");
		rdbtnVip.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnVip.setBounds(540, 429, 50, 23);
		contentPane.add(rdbtnVip);

		btn_loaiSanPham = new ButtonGroup();
		btn_loaiSanPham.add(rdbtnThng);
		btn_loaiSanPham.add(rdbtnVip);

		JLabel lblSTinNhp = new JLabel("Số tiền nhập");
		lblSTinNhp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSTinNhp.setBounds(324, 473, 100, 23);
		contentPane.add(lblSTinNhp);

		textField_SoTienNhap = new JTextField();
		textField_SoTienNhap.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_SoTienNhap.setColumns(10);
		textField_SoTienNhap.setBounds(450, 470, 166, 29);
		contentPane.add(textField_SoTienNhap);

		JLabel lblSTinBn = new JLabel("Số tiền bán");
		lblSTinBn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSTinBn.setBounds(324, 513, 100, 23);
		contentPane.add(lblSTinBn);

		textField_SoTienBan = new JTextField();
		textField_SoTienBan.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_SoTienBan.setColumns(10);
		textField_SoTienBan.setBounds(450, 510, 166, 29);
		contentPane.add(textField_SoTienBan);

		JLabel lblSLng = new JLabel("Số lượng");
		lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSLng.setBounds(324, 557, 100, 23);
		contentPane.add(lblSLng);

		textField_SoLuong = new JTextField();
		textField_SoLuong.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_SoLuong.setColumns(10);
		textField_SoLuong.setBounds(450, 554, 166, 29);
		contentPane.add(textField_SoLuong);

		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.addActionListener(action);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThem.setBounds(31, 628, 89, 42);
		contentPane.add(btnThem);

		JButton btnXoa = new JButton("X\u00F3a");
		btnXoa.addActionListener(action);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnXoa.setBounds(151, 628, 89, 42);
		contentPane.add(btnXoa);

		JButton btnCapNhat = new JButton("C\u1EADp nh\u1EADt");
		btnCapNhat.addActionListener(action);
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCapNhat.setBounds(264, 628, 135, 42);
		contentPane.add(btnCapNhat);

		JButton btnLuu = new JButton("L\u01B0u");
		btnLuu.addActionListener(action);
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLuu.setBounds(421, 628, 135, 42);
		contentPane.add(btnLuu);

		JButton btnHuyBo = new JButton("H\u1EE7y b\u1ECF");
		btnHuyBo.addActionListener(action);
		btnHuyBo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHuyBo.setBounds(585, 628, 135, 42);
		contentPane.add(btnHuyBo);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(15, 628, 733, -22);
		contentPane.add(separator_2);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(10, 616, 738, 2);
		contentPane.add(separator_1_1_1);

		JButton btnHuyTim = new JButton("Hủy tìm");
		btnHuyTim.addActionListener(action);
		btnHuyTim.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHuyTim.setBounds(631, 21, 117, 42);
		contentPane.add(btnHuyTim);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void xoaForm() {
		textField_maID.setText("");
		textField_TenSanpham.setText("");
		textField_MaID_TimKiem.setText("");
		textField_NgayNhap.setText("");
		textField_SoTienNhap.setText("");
		textField_SoTienBan.setText("");
		textField_SoLuong.setText("");
		comboBox_noiSanXuat.setSelectedIndex(-1);
		btn_loaiSanPham.clearSelection();
	}

	public void themHangHoaVaoTable(HangHoa ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] { ts.getMaSanPham() + "", ts.getTenSanPham(), ts.getNoiSanXuat().getTenTinh(),
				ts.getNgayNhap().getDate() + "/" + (ts.getNgayNhap().getMonth() + 1) + "/"
						+ (ts.getNgayNhap().getYear() + 1900),
				(ts.isLoaiSP() ? "Thường" : "Vip"), ts.getSoTienNhap() + "", ts.getSoTienBan() + "",
				ts.getSoLuong() + "", });
	}

	public void themHoacCapNhatHangHoa(HangHoa ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if (!this.model.kiemTraTonTai(ts)) {
			this.model.insert(ts);
			this.themHangHoaVaoTable(ts);
		} else {
			this.model.update(ts);
			int soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (id.equals(ts.getMaSanPham() + "")) {
					model_table.setValueAt(ts.getMaSanPham() + "", i, 0);
					model_table.setValueAt(ts.getTenSanPham() + "", i, 1);
					model_table.setValueAt(ts.getNoiSanXuat().getTenTinh() + "", i, 2);
					model_table.setValueAt(ts.getNgayNhap().getDate() + "/" + (ts.getNgayNhap().getMonth() + 1) + "/"
							+ (ts.getNgayNhap().getYear() + 1900) + "", i, 3);
					model_table.setValueAt((ts.isLoaiSP() ? "Thường" : "Vip"), i, 4);
					model_table.setValueAt(ts.getSoTienNhap() + "", i, 5);
					model_table.setValueAt(ts.getSoTienBan() + "", i, 6);
					model_table.setValueAt(ts.getSoLuong() + "", i, 7);
				}
			}
		}
	}

	public HangHoa getHangHoaDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();

		int maThiSinh = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
		String tenThiSinh = model_table.getValueAt(i_row, 1) + "";
		Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row, 2) + "");
		String s_ngaySinh = model_table.getValueAt(i_row, 3) + "";
		Date ngaySinh = new Date(s_ngaySinh);
		String textGioiTinh = model_table.getValueAt(i_row, 4) + "";
		boolean gioiTinh = textGioiTinh.equals("Nam");
		float diemMon1 = Float.valueOf(model_table.getValueAt(i_row, 5) + "");
		float diemMon2 = Float.valueOf(model_table.getValueAt(i_row, 6) + "");
		float diemMon3 = Float.valueOf(model_table.getValueAt(i_row, 7) + "");

		HangHoa ts = new HangHoa(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		return ts;
	}

	public void hienThiThongTinHangHoaDaChon() {
		HangHoa ts = getHangHoaDangChon();

		this.textField_maID.setText(ts.getMaSanPham() + "");
		this.textField_TenSanpham.setText(ts.getTenSanPham() + "");
		this.comboBox_noiSanXuat.setSelectedItem(ts.getNoiSanXuat().getTenTinh());
		String s_ngaySinh = ts.getNgayNhap().getDate() + "/" + (ts.getNgayNhap().getMonth() + 1) + "/"
				+ (ts.getNgayNhap().getYear() + 1900);
		this.textField_NgayNhap.setText(s_ngaySinh + "");
		if (ts.isLoaiSP()) {
			rdbtnThng.setSelected(true);
		} else {
			rdbtnVip.setSelected(true);
		}
		this.textField_SoTienNhap.setText(ts.getSoTienNhap() + "");
		this.textField_SoTienBan.setText(ts.getSoTienBan() + "");
		this.textField_SoLuong.setText(ts.getSoLuong() + "");
	}

	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắn chắn xóa dòng đã chọn?");
		if (luaChon == JOptionPane.YES_OPTION) {
			HangHoa ts = getHangHoaDangChon();
			this.model.delete(ts);
			model_table.removeRow(i_row);
		}

	}

	public void thucHienThemHangHoa() {
		// Get du lieu
		int maSP = Integer.valueOf(this.textField_maID.getText());
		String tenSP = this.textField_TenSanpham.getText();
		int Noisanxuat = this.comboBox_noiSanXuat.getSelectedIndex() - 1;
		Tinh tinh = Tinh.getTinhById(Noisanxuat);
		Date ngayNhap = new Date(this.textField_NgayNhap.getText());
		boolean Loaisp = true;
		if (this.rdbtnThng.isSelected()) {
			Loaisp = true;
		} else if (this.rdbtnVip.isSelected()) {
			Loaisp = false;
		}
		float sotiennhap = Float.valueOf(this.textField_SoTienNhap.getText());
		float sotienban = Float.valueOf(this.textField_SoTienBan.getText());
		float soluong = Float.valueOf(this.textField_SoLuong.getText());

		HangHoa ts = new HangHoa(maSP, tenSP, tinh, ngayNhap, Loaisp, sotiennhap, sotienban, soluong);
		this.themHoacCapNhatHangHoa(ts);
	}

	public void thucHienTim() {
    // Gọi hàm hủy tìm kiếm
    this.thucHienTaiLaiDuLieu();
    
    // Thực hiện tìm kiếm
    int queQuan = this.comboBox_noiSanXuat_timKiem.getSelectedIndex() - 1;
    String maThiSinhTimKiem = this.textField_MaID_TimKiem.getText();
    DefaultTableModel model_table = (DefaultTableModel) table.getModel();
    int soLuongDong = model_table.getRowCount();

    Set<Integer> idCuaThiSinhCanXoa = new TreeSet<>(); // Sửa tại đây, sử dụng Set<Integer>

    if (queQuan >= 0) {
        Tinh tinhDaChon = Tinh.getTinhById(queQuan);
        for (int i = 0; i < soLuongDong; i++) {
            String tenTinh = model_table.getValueAt(i, 2) + "";
            String id = model_table.getValueAt(i, 0) + "";
            if (!tenTinh.equals(tinhDaChon.getTenTinh())) {
                idCuaThiSinhCanXoa.add(Integer.valueOf(id));
            }
        }
    }

    if (maThiSinhTimKiem.length() > 0) {
        for (int i = 0; i < soLuongDong; i++) {
            String id = model_table.getValueAt(i, 0) + "";
            if (!id.equals(maThiSinhTimKiem)) {
                idCuaThiSinhCanXoa.add(Integer.valueOf(id));
            }
        }
    }

    for (Integer idCanXoa : idCuaThiSinhCanXoa) {
        soLuongDong = model_table.getRowCount();
        for (int i = 0; i < soLuongDong; i++) {
            String idTrongTable = model_table.getValueAt(i, 0) + "";
            System.out.println("idTrongTable: " + idTrongTable);
            if (idTrongTable.equals(idCanXoa.toString())) {
                System.out.println("Đã xóa: " + i);
                try {
                    model_table.removeRow(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
	public void thucHienTaiLaiDuLieu() {
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if(soLuongDong==0)
				break;
			else
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		for (HangHoa ts : this.model.getDsHangHoa()) {
			this.themHangHoaVaoTable(ts);
		}
	}

	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this, "Phần mềm quản lý hàng hóa 1.0!");
	}

	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(
			    this,
			    "Bạn có muốn thoải khỏi chương trình?",
			    "Exit",
			    JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (HangHoa ts : this.model.getDsHangHoa()) {
				oos.writeObject(ts);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void thucHienSaveFile() {
		if(this.model.getTenFile().length()>0) {
			saveFile(this.model.getTenFile());
		}else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			} 
		}
	}
	public void openFile(File file) {
		ArrayList ds = new ArrayList();
		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			HangHoa ts = null;
			while((ts = (HangHoa) ois.readObject())!=null) {
				ds.add(ts);
			}
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.model.setDsHangHoa(ds);
	}
	public void thucHienOpenFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			thucHienTaiLaiDuLieu();
		} 
	}

}
