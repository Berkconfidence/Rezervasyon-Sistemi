package proje;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class UserSelection {

	JFrame frame;
	private final JPanel panel = new JPanel();
	private JTextField adminuser;
	private JPasswordField adminpassword;
	private JTextField firmauser;
	private JPasswordField firmapassword;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserSelection window = new UserSelection();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UserSelection() {
		initialize();
	}

	private void initialize()
	{
		Company firmaislem = new Company();
		frame = new JFrame();
		frame.setBounds(400, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 786, 563);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		//ADMİN PANELİ
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(50, 75, 330, 264);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel AdminPaneliText = new JLabel("Admin Paneli");
		AdminPaneliText.setFont(new Font("Modern No. 20", Font.PLAIN, 22));
		AdminPaneliText.setBounds(107, 10, 135, 25);
		panel_1.add(AdminPaneliText);
		
		JLabel AdminKaText = new JLabel("Kullanıcı Adı");
		AdminKaText.setFont(new Font("Tahoma", Font.ITALIC, 15));
		AdminKaText.setBounds(33, 68, 94, 13);
		panel_1.add(AdminKaText);
		
		JLabel AdminPassText = new JLabel("Şifre");
		AdminPassText.setFont(new Font("Tahoma", Font.ITALIC, 15));
		AdminPassText.setBounds(33, 108, 80, 19);
		panel_1.add(AdminPassText);
		
		adminuser = new JTextField();
		adminuser.setBounds(157, 64, 115, 19);
		panel_1.add(adminuser);
		adminuser.setColumns(10);
		
		adminpassword = new JPasswordField();
		adminpassword.setBounds(157, 110, 115, 19);
		panel_1.add(adminpassword);
		
		JCheckBox AdminSifreGöster = new JCheckBox("Şifreyi göster");
		AdminSifreGöster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(AdminSifreGöster.isSelected())
				{
					adminpassword.setEchoChar((char)0);
				}
				else
				{
					adminpassword.setEchoChar('*');
				}
			}
		});
		AdminSifreGöster.setBounds(157, 138, 128, 21);
		panel_1.add(AdminSifreGöster);
		
		JButton AdminGiris = new JButton("Giriş");
		AdminGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String AdminKa = adminuser.getText();
				String AdminSifre = adminpassword.getText();
				
				if(AdminKa.equals(Admin.isim) && AdminSifre.equals(Admin.şifre))
				{
					JOptionPane.showMessageDialog(null, "Giriş Başarılı!");
					AdminPanel adminpaneli = new AdminPanel();
					adminpaneli.setVisible(true);
					frame.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Kullanıcı Adı veya Şifre Hatalı!");
				}
			}
		});
		
		AdminGiris.setFont(new Font("Tahoma", Font.BOLD, 15));
		AdminGiris.setBounds(157, 184, 115, 25);
		panel_1.add(AdminGiris);
		
		
		//FİRMA PANELİ
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(408, 75, 330, 264);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel FirmaPaneliText = new JLabel("Firma Paneli");
		FirmaPaneliText.setFont(new Font("Modern No. 20", Font.PLAIN, 22));
		FirmaPaneliText.setBounds(100, 10, 135, 25);
		panel_2.add(FirmaPaneliText);
		
		JLabel FirmaKaText = new JLabel("Kullanıcı Adı");
		FirmaKaText.setFont(new Font("Tahoma", Font.ITALIC, 15));
		FirmaKaText.setBounds(33, 68, 100, 13);
		panel_2.add(FirmaKaText);
		
		JLabel FirmaPassText = new JLabel("Şifre");
		FirmaPassText.setFont(new Font("Tahoma", Font.ITALIC, 15));
		FirmaPassText.setBounds(33, 108, 80, 19);
		panel_2.add(FirmaPassText);
		
		firmauser = new JTextField();
		firmauser.setColumns(10);
		firmauser.setBounds(157, 64, 115, 19);
		panel_2.add(firmauser);
		
		firmapassword = new JPasswordField();
		firmapassword.setBounds(157, 110, 115, 19);
		panel_2.add(firmapassword);
		
		JCheckBox FirmaSifreGöster = new JCheckBox("Şifreyi göster");
		FirmaSifreGöster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(FirmaSifreGöster.isSelected())
				{
					firmapassword.setEchoChar((char)0);
				}
				else
				{
					firmapassword.setEchoChar('*');
				}
			}
		});
		FirmaSifreGöster.setBounds(157, 138, 128, 21);
		panel_2.add(FirmaSifreGöster);
		
		JButton FirmaGiris = new JButton("Giriş");
		FirmaGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String FirmaKa = firmauser.getText();
				String FirmaSifre = firmapassword.getText();
				
				for(int i=0; i<firmaislem.firmadeti(); i++)
				{
					if(FirmaKa.equalsIgnoreCase(firmaislem.listele(i)) && FirmaSifre.equals(firmaislem.listeleSifre(i)))
					{
						i=50;
						JOptionPane.showMessageDialog(null, "Giriş Başarılı!");
						CompanyPanel firmapaneli = new CompanyPanel();
						firmapaneli.setVisible(true);
						frame.dispose();
						
					}
					else if(i+1==firmaislem.firmadeti())
					{
						JOptionPane.showMessageDialog(null, "Kullanıcı Adı veya Şifre Hatalı!");
					}
				}

				
			}
		});
		FirmaGiris.setFont(new Font("Tahoma", Font.BOLD, 15));
		FirmaGiris.setBounds(157, 184, 115, 25);
		panel_2.add(FirmaGiris);
		
		
		//KULLANICI PANELİ
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(50, 363, 690, 167);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel KullanıcıPaneliText = new JLabel("Kullanıcı Paneli");
		KullanıcıPaneliText.setFont(new Font("Modern No. 20", Font.PLAIN, 22));
		KullanıcıPaneliText.setBounds(266, 10, 172, 25);
		panel_3.add(KullanıcıPaneliText);
		
		JButton BiletAra = new JButton("Bilet Ara");
		BiletAra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(null, "Yönlendiriliyorsunuz!");
				UserPanel kullanıcıpaneli = new UserPanel();
				kullanıcıpaneli.setVisible(true);
				frame.dispose();
			}
		});
		BiletAra.setFont(new Font("Tahoma", Font.BOLD, 15));
		BiletAra.setBounds(278, 65, 139, 48);
		panel_3.add(BiletAra);
		
		JLabel lblNewLabel_2 = new JLabel("REZERVASYON SİSTEMİ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 30));
		lblNewLabel_2.setBounds(228, 10, 458, 44);
		panel.add(lblNewLabel_2);
	}
}
