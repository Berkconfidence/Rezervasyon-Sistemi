package proje;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

public class AdminPanel extends JFrame {

	private JPanel contentPane;
	private JTextField firmauser;
	private JPasswordField firmapassword;
	private JTextField firmausersil;
	private JPasswordField firmapasswordsil;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel frame = new AdminPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AdminPanel()
	{
		Company firmaislem = new Company();
		Admin adminislem = new Admin();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 229, 573);
		panel.setBackground(SystemColor.desktop);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(228, 0, 558, 573);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Admin");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(70, 10, 132, 57);
		panel.add(lblNewLabel);
		
		JLabel lblPaneli = new JLabel("Paneli");
		lblPaneli.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblPaneli.setBounds(70, 40, 132, 57);
		panel.add(lblPaneli);
		
		JPanel karsılamaEkranı = new JPanel();
		layeredPane.add(karsılamaEkranı, "name_21031961201900");
		karsılamaEkranı.setLayout(null);
		
		JPanel firmaGörüntülePanel = new JPanel();
		layeredPane.add(firmaGörüntülePanel, "name_12574149614100");
		firmaGörüntülePanel.setLayout(null);
		
		JButton firmaGörüntüleButton = new JButton("Firmaları Görüntüle");
		firmaGörüntüleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				firmaGörüntülePanel.removeAll();
		        layeredPane.removeAll();
		        layeredPane.add(firmaGörüntülePanel);
		        layeredPane.repaint();
		        layeredPane.revalidate();
		        
		        JLabel varOlanFirmalarLabel = new JLabel("Firmalar");
				varOlanFirmalarLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
				varOlanFirmalarLabel.setBounds(25, 15, 217, 57);
				firmaGörüntülePanel.add(varOlanFirmalarLabel);
				
				for(int i=0; i<firmaislem.firmadeti(); i++)
				{
					JLabel firmaLabel = new JLabel(firmaislem.listele(i));
		            firmaLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		            firmaLabel.setBounds(27 , 100 + i * 40, 107, 19);
		            firmaGörüntülePanel.add(firmaLabel);
				}
				firmaGörüntülePanel.revalidate();
		        firmaGörüntülePanel.repaint();
			}
		});
		firmaGörüntüleButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		firmaGörüntüleButton.setBounds(31, 150, 164, 27);
		panel.add(firmaGörüntüleButton);
		
		
		JPanel firmaKaydıPanel = new JPanel();
		layeredPane.add(firmaKaydıPanel, "name_12612421418800");
		firmaKaydıPanel.setLayout(null);
		
		JButton firmaKaydıYapButton = new JButton("Yeni Firma Kaydı");
		firmaKaydıYapButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				layeredPane.removeAll();
				layeredPane.add(firmaKaydıPanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		firmaKaydıYapButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		firmaKaydıYapButton.setBounds(31, 225, 164, 27);
		panel.add(firmaKaydıYapButton);
		
		JLabel firmaKayıtLabel = new JLabel("Firma Kayıt Ekranı");
		firmaKayıtLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		firmaKayıtLabel.setBounds(25, 15, 258, 57);
		firmaKaydıPanel.add(firmaKayıtLabel);
		
		JLabel FirmaKaText = new JLabel("Firma Kullanıcı Adı");
		FirmaKaText.setFont(new Font("Tahoma", Font.ITALIC, 15));
		FirmaKaText.setBounds(25, 149, 135, 28);
		firmaKaydıPanel.add(FirmaKaText);
		
		firmauser = new JTextField();
		firmauser.setColumns(10);
		firmauser.setBounds(25, 183, 115, 20);
		firmaKaydıPanel.add(firmauser);
		
		firmapassword = new JPasswordField();
		firmapassword.setBounds(25, 244, 115, 19);
		firmaKaydıPanel.add(firmapassword);
		
		JLabel FirmaSifreText = new JLabel("Firma Şifre");
		FirmaSifreText.setFont(new Font("Tahoma", Font.ITALIC, 15));
		FirmaSifreText.setBounds(25, 213, 135, 28);
		firmaKaydıPanel.add(FirmaSifreText);
		
		JCheckBox sifreGöster = new JCheckBox("Şifreyi Göster");
		sifreGöster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(sifreGöster.isSelected())
				{
					firmapassword.setEchoChar((char)0);
				}
				else
				{
					firmapassword.setEchoChar('*');
				}
			}
		});
		sifreGöster.setBounds(156, 243, 127, 21);
		firmaKaydıPanel.add(sifreGöster);
		
		JButton firmaKaydetButton = new JButton("Kaydet");
		firmaKaydetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String AdminKa = firmauser.getText();
				String AdminSifre = firmapassword.getText();
				boolean devam=true;
				
				if(AdminKa.isBlank() || AdminSifre.isBlank())
				{
					JOptionPane.showMessageDialog(null, "Kullanıcı adı veya şifre boş kalamaz!");
				}
				else
				{
					for(int i=0; i<firmaislem.firmadeti(); i++)
					{
						if(AdminKa.equalsIgnoreCase(firmaislem.listele(i)))
							devam=false;										
					}
					if(devam)
					{
						adminislem.kullanıcıEkle(AdminKa, AdminSifre);
						JOptionPane.showMessageDialog(null, "Firma Eklendi!");
					}
					else
						JOptionPane.showMessageDialog(null, "Bu Firma Zaten Mevcut");
				}
				
			}
		});
		firmaKaydetButton.setBounds(25, 290, 115, 21);
		firmaKaydıPanel.add(firmaKaydetButton);
		
		
		JPanel firmaSilPanel = new JPanel();
		layeredPane.add(firmaSilPanel, "name_12855283924700");
		firmaSilPanel.setLayout(null);
		
		JLabel firmaSilLabel = new JLabel("Firma Silme Ekranı");
		firmaSilLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		firmaSilLabel.setBounds(25, 15, 258, 57);
		firmaSilPanel.add(firmaSilLabel);
		
		JLabel FirmaKaSilText = new JLabel("Firma Kullanıcı Adı");
		FirmaKaSilText.setFont(new Font("Tahoma", Font.ITALIC, 15));
		FirmaKaSilText.setBounds(25, 149, 135, 28);
		firmaSilPanel.add(FirmaKaSilText);
		
		firmausersil = new JTextField();
		firmausersil.setColumns(10);
		firmausersil.setBounds(25, 183, 115, 20);
		firmaSilPanel.add(firmausersil);
		
		JLabel FimraSilSifreText = new JLabel("Firma Şifre");
		FimraSilSifreText.setFont(new Font("Tahoma", Font.ITALIC, 15));
		FimraSilSifreText.setBounds(25, 213, 135, 28);
		firmaSilPanel.add(FimraSilSifreText);
		
		firmapasswordsil = new JPasswordField();
		firmapasswordsil.setBounds(25, 244, 115, 19);
		firmaSilPanel.add(firmapasswordsil);
		
		JCheckBox sifreGöster2 = new JCheckBox("Şifreyi Göster");
		sifreGöster2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(sifreGöster2.isSelected())
				{
					firmapassword.setEchoChar((char)0);
				}
				else
				{
					firmapassword.setEchoChar('*');
				}
			}
		});
		sifreGöster2.setBounds(156, 243, 127, 21);
		firmaSilPanel.add(sifreGöster2);
		
		JButton firmaSilButton = new JButton("Sil");
		firmaSilButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String AdminKa = firmausersil.getText();
				String AdminSifre = firmapasswordsil.getText();
				
				if(AdminKa.isBlank() || AdminSifre.isBlank())
				{
					JOptionPane.showMessageDialog(null, "Kullanıcı adı veya şifre boş kalamaz!");
				}
				else
				{
					for(int i=0; i<firmaislem.firmadeti(); i++)
					{
						if(AdminKa.equalsIgnoreCase(firmaislem.listele(i)) && AdminSifre.equals(firmaislem.listeleSifre(i)))
						{
							adminislem.firmaSil(AdminKa, AdminSifre, i);
							JOptionPane.showMessageDialog(null, "Firma Silindi!");
							break;
						}
						else if(i+1==firmaislem.firmadeti())
						{
							JOptionPane.showMessageDialog(null, "Kullanıcı Adı veya Şifre Hatalı!");
						}
					}
				}
			}
		});
		firmaSilButton.setBounds(25, 288, 115, 21);
		firmaSilPanel.add(firmaSilButton);
		
		JButton firmaKaydıSilButton = new JButton("Firma Kaydı Sil");
		firmaKaydıSilButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				layeredPane.removeAll();
				layeredPane.add(firmaSilPanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		firmaKaydıSilButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		firmaKaydıSilButton.setBounds(31, 300, 164, 27);
		panel.add(firmaKaydıSilButton);
		
		
		JPanel hizmetBedeliPanel = new JPanel();
		layeredPane.add(hizmetBedeliPanel, "name_12857112249200");
		hizmetBedeliPanel.setLayout(null);
		
		JLabel hizmetBedeliEkranıLabel = new JLabel("Hizmet Bedeli Ekranı");
		hizmetBedeliEkranıLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		hizmetBedeliEkranıLabel.setBounds(25, 15, 275, 57);
		hizmetBedeliPanel.add(hizmetBedeliEkranıLabel);
		
		JLabel hizmetHesaplaLabel = new JLabel("Hizmet Bedelini Hesapla");
		hizmetHesaplaLabel.setFont(new Font("Tahoma", Font.ITALIC, 17));
		hizmetHesaplaLabel.setBounds(25, 149, 185, 28);
		hizmetBedeliPanel.add(hizmetHesaplaLabel);
		
		JLabel firmaSayısıLabel = new JLabel("Firma Sayısı");
		firmaSayısıLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		firmaSayısıLabel.setBounds(25, 180, 170, 28);
		hizmetBedeliPanel.add(firmaSayısıLabel);
		
		JComboBox<Integer> firmaSayısıcomboBox = new JComboBox<Integer>();
		firmaSayısıcomboBox.setBounds(25, 210, 85, 21);
		hizmetBedeliPanel.add(firmaSayısıcomboBox);
		
		JLabel hizmetBedeliLabel = new JLabel("Hizmet Bedeli Günlük");
		hizmetBedeliLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		hizmetBedeliLabel.setBounds(25, 236, 170, 28);
		hizmetBedeliPanel.add(hizmetBedeliLabel);
		
		JComboBox<Integer> hizmetBedelicomboBox = new JComboBox<Integer>();
		hizmetBedelicomboBox.setBounds(25, 267, 85, 21);
		hizmetBedeliPanel.add(hizmetBedelicomboBox);
		
		JButton hesaplaButton = new JButton("Hesapla");
		hesaplaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				firmaSayısıcomboBox.removeAllItems();
				hizmetBedelicomboBox.removeAllItems();
				int adet=0;
				int kar;
				for(int i=0; i<firmaislem.firmadeti(); i++)
				{
					adet++;
				}
				firmaSayısıcomboBox.addItem(adet);
				
				kar=firmaislem.adminKarZarar(adet, 1);
				hizmetBedelicomboBox.addItem(kar);
			}
		});
		hesaplaButton.setBounds(25, 297, 85, 21);
		hizmetBedeliPanel.add(hesaplaButton);
		
		
		JButton hizmetBedeliButton = new JButton("Hizmet Bedeli");
		hizmetBedeliButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				layeredPane.removeAll();
				layeredPane.add(hizmetBedeliPanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		hizmetBedeliButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		hizmetBedeliButton.setBounds(31, 375, 164, 27);
		panel.add(hizmetBedeliButton);
		
		JButton geriButton = new JButton("Geri");
		geriButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				UserSelection window = new UserSelection();
                window.frame.setVisible(true);
                dispose();			
			}
		});
		geriButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		geriButton.setBounds(30, 515, 67, 21);
		panel.add(geriButton);
	}
}
