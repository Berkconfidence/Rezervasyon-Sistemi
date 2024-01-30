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
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

public class CompanyPanel extends JFrame {

	private JPanel contentPane;
	private JTextField seferKacıncıText;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompanyPanel frame = new CompanyPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public CompanyPanel()
	{
		
		Company firmaislem = new Company();
		Bus busislem = new Bus(null);
		Train trenislem = new Train(null);
		Airplane ucakislem = new Airplane(null);
		Transport ulasımislem = new Transport();
		
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
		
		JLabel lblNewLabel = new JLabel("Firma");
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
		
		JPanel araçEklemePanel = new JPanel();
		layeredPane.add(araçEklemePanel, "name_12574149614100");
		araçEklemePanel.setLayout(null);
		
		JButton araçEklemeButton = new JButton("Araç Ekleme");
		araçEklemeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				layeredPane.removeAll();
				layeredPane.add(araçEklemePanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		araçEklemeButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		araçEklemeButton.setBounds(31, 150, 164, 27);
		panel.add(araçEklemeButton);
		
		
		JPanel aracÇıkarmaPanel = new JPanel();
		layeredPane.add(aracÇıkarmaPanel, "name_12612421418800");
		aracÇıkarmaPanel.setLayout(null);
		
		JButton araçÇıkarmaButton = new JButton("Araç Çıkarma");
		araçÇıkarmaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				layeredPane.removeAll();
				layeredPane.add(aracÇıkarmaPanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		araçÇıkarmaButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		araçÇıkarmaButton.setBounds(31, 225, 164, 27);
		panel.add(araçÇıkarmaButton);
		
		JLabel varOlanFirmalarLabel = new JLabel("Araç Ekleme Ekranı");
		varOlanFirmalarLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		varOlanFirmalarLabel.setBounds(30, 21, 294, 57);
		araçEklemePanel.add(varOlanFirmalarLabel);
		
		JLabel araçEkleLabel = new JLabel("Araç Eklenecek Firma");
		araçEkleLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		araçEkleLabel.setBounds(25, 150, 172, 28);
		araçEklemePanel.add(araçEkleLabel);
		
		JComboBox<String> araçEklenecekFirmaBox = new JComboBox<String>();
		araçEklenecekFirmaBox.setBounds(25, 188, 115, 20);
		araçEklemePanel.add(araçEklenecekFirmaBox);
		
		JButton firmalarıListeleButton = new JButton("Göster");
		firmalarıListeleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				araçEklenecekFirmaBox.removeAllItems();
				for (int i = 0; i < firmaislem.firmadeti(); i++)
				{
					String firma = firmaislem.listele(i);
					araçEklenecekFirmaBox.addItem(firma);
				}	
			}
		});
		firmalarıListeleButton.setBounds(25, 220, 76, 21);
		araçEklemePanel.add(firmalarıListeleButton);
		
		JLabel AracKa_1_1 = new JLabel("Eklenecek Araç Türü");
		AracKa_1_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		AracKa_1_1.setBounds(25, 270, 172, 28);
		araçEklemePanel.add(AracKa_1_1);
		
		JComboBox<String> araçTürüBox = new JComboBox<String>();
		araçTürüBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Otobüs", "Tren", "Uçak"}));
		araçTürüBox.setBounds(25, 309, 115, 20);
		araçEklemePanel.add(araçTürüBox);
		
		JComboBox<String> araçYakitTürüBox = new JComboBox<String>();
		araçYakitTürüBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Motorin", "Benzin", "Gaz", "Elektrik"}));
		araçYakitTürüBox.setBounds(25, 391, 115, 20);
		araçEklemePanel.add(araçYakitTürüBox);
		
		JButton aracEkleButton = new JButton("Ekle");
		aracEkleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String firma = araçEklenecekFirmaBox.getSelectedItem().toString();
				String vehicle = araçTürüBox.getSelectedItem().toString();
				String tür = araçYakitTürüBox.getSelectedItem().toString();
				
				if(vehicle.equals("Otobüs"))
				{	
					if(tür.equals("Motorin") || tür.equals("Benzin"))
					{
						Bus aracekle = new Bus("Otobüs");
				        aracekle.aracEkleme(firma);
				        Personel.PersonelEkleOtobus(firma);
				        busislem.yakitTürü(firma, vehicle, "Mazot");
				        JOptionPane.showMessageDialog(null, "Ekleme Başarılı!");
					}
					else
						JOptionPane.showMessageDialog(null, "Hatalı yakıt türü!");	
					
				}
				else if(vehicle.equals("Tren"))
				{
					if(tür.equals("Elektrik"))
					{
						Train aracekle = new Train("Tren");
				        aracekle.aracEkleme(firma);
				        Personel.PersonelEkleTren(firma);
				        trenislem.koltukSayisi(firma, vehicle, 50);
				        trenislem.yakitTürü(firma, vehicle, "Elektrik");
				        JOptionPane.showMessageDialog(null, "Ekleme Başarılı!");
					}
					else
						JOptionPane.showMessageDialog(null, "Hatalı yakıt türü!");	
			        
				}
				else if(vehicle.equals("Uçak"))
				{
					if(tür.equals("Gaz"))
					{
						 Airplane aracekle = new Airplane("Uçak");
					     aracekle.aracEkleme(firma);
					     Personel.PersonelEkleUcak(firma);
					     ucakislem.koltukSayisi(firma, vehicle, 60);
					     ucakislem.yakitTürü(firma, vehicle, "Gaz");
					     JOptionPane.showMessageDialog(null, "Ekleme Başarılı!");
					}
					else
						JOptionPane.showMessageDialog(null, "Hatalı yakıt türü!");	
			       
				}
			}
		});
		aracEkleButton.setBounds(25, 425, 76, 21);
		araçEklemePanel.add(aracEkleButton);
		
		JLabel aracYakıtLabel = new JLabel("Eklenecek Yakıt Türü");
		aracYakıtLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		aracYakıtLabel.setBounds(25, 353, 172, 28);
		araçEklemePanel.add(aracYakıtLabel);
		
				
		JLabel çıkarılacakFirmaLabel = new JLabel("Araç Çıkarma Ekranı");
		çıkarılacakFirmaLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		çıkarılacakFirmaLabel.setBounds(30, 21, 258, 57);
		aracÇıkarmaPanel.add(çıkarılacakFirmaLabel);
		
		JLabel araçÇıkarmaLabel = new JLabel("Araç Çıkarılacak Firma");
		araçÇıkarmaLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		araçÇıkarmaLabel.setBounds(25, 149, 172, 28);
		aracÇıkarmaPanel.add(araçÇıkarmaLabel);
		
		JComboBox<String> araçÇıkarılacakFirmaBox = new JComboBox<String>();
		araçÇıkarılacakFirmaBox.setBounds(25, 187, 115, 20);
		aracÇıkarmaPanel.add(araçÇıkarılacakFirmaBox);
		
		JButton çıkarılacakFirmalarıListeleButton = new JButton("Göster");
		çıkarılacakFirmalarıListeleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				araçÇıkarılacakFirmaBox.removeAllItems();
				for (int i = 0; i < firmaislem.firmadeti(); i++)
				{
					String firma = firmaislem.listele(i);
					araçÇıkarılacakFirmaBox.addItem(firma);
				}
			}
		});
		çıkarılacakFirmalarıListeleButton.setBounds(25, 221, 76, 21);
		aracÇıkarmaPanel.add(çıkarılacakFirmalarıListeleButton);
		
		JLabel çıkarılacakAraçLabel = new JLabel("Çıkarılacak Araç");
		çıkarılacakAraçLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		çıkarılacakAraçLabel.setBounds(25, 272, 172, 28);
		aracÇıkarmaPanel.add(çıkarılacakAraçLabel);
		
		JComboBox<String> çıkarılacakAraçBox = new JComboBox<String>();
		çıkarılacakAraçBox.setBounds(25, 312, 115, 20);
		aracÇıkarmaPanel.add(çıkarılacakAraçBox);
		
		JButton çıkarılacakAraçGösterButton = new JButton("Göster");
		çıkarılacakAraçGösterButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				çıkarılacakAraçBox.removeAllItems();
				String firma = araçÇıkarılacakFirmaBox.getSelectedItem().toString();   
				
				if(Bus.firmaOtobus.get(firma)!=null || Train.firmaTren.get(firma)!=null)
				{
					Bus[] mevcutotobusler = Bus.firmaOtobus.get(firma);
					Train[] mevcutTrenler = Train.firmaTren.get(firma);
					Airplane[] mevcutUcaklar = Airplane.firmaUcak.get(firma);
					
					if(mevcutotobusler!=null)
					{
						for (Bus otobusler : mevcutotobusler)
				        {
				        	çıkarılacakAraçBox.addItem(otobusler.getBusName());
				        }
					}
				    if(mevcutTrenler!=null)
				    {
				    	for (Train trenler : mevcutTrenler)
				        {
				        	çıkarılacakAraçBox.addItem(trenler.getTrainName());
				        }
				    }
				    if(mevcutUcaklar!=null)
				    {
				    	for (Airplane trenler : mevcutUcaklar)
				        {
				        	çıkarılacakAraçBox.addItem(trenler.getAirplaneName());
				        }
				    }
				    
				}
	
			}
		});
		çıkarılacakAraçGösterButton.setBounds(25, 347, 76, 21);
		aracÇıkarmaPanel.add(çıkarılacakAraçGösterButton);
		
		JButton araçÇıkarButton = new JButton("Çıkar");
		araçÇıkarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String firmacıkar = araçÇıkarılacakFirmaBox.getSelectedItem().toString();
				
				if(Bus.firmaOtobus.get(firmacıkar)!=null || Train.firmaTren.get(firmacıkar)!=null)
				{
					String vehicle = çıkarılacakAraçBox.getSelectedItem().toString();
					if(vehicle.startsWith("Otobüs"))
					{
						String firma = araçÇıkarılacakFirmaBox.getSelectedItem().toString();
						String otobus = çıkarılacakAraçBox.getSelectedItem().toString();
						
						Bus aracCıkar = new Bus("otobus");
						aracCıkar.aracSilme(firma, otobus);
						JOptionPane.showMessageDialog(null, "Çıkarma Başarılı!");
					}
					else if(vehicle.startsWith("Tren"))
					{
						String firma = araçÇıkarılacakFirmaBox.getSelectedItem().toString();
						String tren = çıkarılacakAraçBox.getSelectedItem().toString();
						
						Train aracCıkar = new Train("Tren");
						aracCıkar.aracSilme(firma, tren);
						JOptionPane.showMessageDialog(null, "Çıkarma Başarılı!");
					}
					else if(vehicle.startsWith("Uçak"))
					{
						String firma = araçÇıkarılacakFirmaBox.getSelectedItem().toString();
						String ucak = çıkarılacakAraçBox.getSelectedItem().toString();
						
						Airplane aracCıkar = new Airplane("Uçak");
						aracCıkar.aracSilme(firma, ucak);
						JOptionPane.showMessageDialog(null, "Çıkarma Başarılı!");
					}
				}								
			}
		});
		araçÇıkarButton.setBounds(111, 347, 76, 21);
		aracÇıkarmaPanel.add(araçÇıkarButton);
		
		
		JPanel seferEklemePanel = new JPanel();
		layeredPane.add(seferEklemePanel, "name_12855283924700");
		seferEklemePanel.setLayout(null);
		
		JButton seferEklemeButton = new JButton("Sefer Ekleme");
		seferEklemeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				layeredPane.removeAll();
				layeredPane.add(seferEklemePanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		seferEklemeButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		seferEklemeButton.setBounds(31, 300, 164, 27);
		panel.add(seferEklemeButton);
		
		JLabel seferEklemeLabel = new JLabel("Sefer Ekleme Ekranı");
		seferEklemeLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		seferEklemeLabel.setBounds(30, 21, 268, 57);
		seferEklemePanel.add(seferEklemeLabel);
		
		JLabel firmaSeferEklemeLabel = new JLabel("Sefer Eklenecek Firma");
		firmaSeferEklemeLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		firmaSeferEklemeLabel.setBounds(25, 150, 172, 28);
		seferEklemePanel.add(firmaSeferEklemeLabel);
		
		JComboBox<String> seferEklenecekFirmaBox = new JComboBox<String>();
		seferEklenecekFirmaBox.setBounds(25, 187, 115, 20);
		seferEklemePanel.add(seferEklenecekFirmaBox);
		
		JButton seferFirmaListeleButton = new JButton("Göster");
		seferFirmaListeleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				seferEklenecekFirmaBox.removeAllItems();
				for (int i = 0; i < firmaislem.firmadeti(); i++)
				{
					String firma = firmaislem.listele(i);
					seferEklenecekFirmaBox.addItem(firma);
				}
			}
		});
		seferFirmaListeleButton.setBounds(25, 221, 76, 21);
		seferEklemePanel.add(seferFirmaListeleButton);
		
		JLabel seferAraçLabel = new JLabel("Sefer Eklenecek Araç");
		seferAraçLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		seferAraçLabel.setBounds(25, 272, 172, 28);
		seferEklemePanel.add(seferAraçLabel);
		
		JComboBox<String> seferEklenecekAraçBox = new JComboBox<String>();
		seferEklenecekAraçBox.setBounds(25, 312, 115, 20);
		seferEklemePanel.add(seferEklenecekAraçBox);
		
		JButton seferEklencekAraçGösterButton = new JButton("Göster");
		seferEklencekAraçGösterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				seferEklenecekAraçBox.removeAllItems();
				String firma = seferEklenecekFirmaBox.getSelectedItem().toString();   
				
				if(Bus.firmaOtobus.get(firma)!=null || Train.firmaTren.get(firma)!=null || Airplane.firmaUcak.get(firma)!=null)
				{
					Bus[] mevcutotobusler = Bus.firmaOtobus.get(firma);
					Train[] mevcutTrenler = Train.firmaTren.get(firma);
					Airplane[] mevcutUcaklar = Airplane.firmaUcak.get(firma);
					
					if(mevcutotobusler!=null)
					{
						for (Bus otobusler : mevcutotobusler)
				        {
					    	seferEklenecekAraçBox.addItem(otobusler.getBusName());
				        }
					}				    
				    if(mevcutTrenler!=null)
				    {
				    	for (Train trenler : mevcutTrenler)
				        {
				        	seferEklenecekAraçBox.addItem(trenler.getTrainName());
				        }
				    }
				    if(mevcutUcaklar!=null)
				    {
				    	for (Airplane trenler : mevcutUcaklar)
				        {
				        	seferEklenecekAraçBox.addItem(trenler.getAirplaneName());
				        }
				    }
				}
				
			}
		});
		seferEklencekAraçGösterButton.setBounds(25, 347, 76, 21);
		seferEklemePanel.add(seferEklencekAraçGösterButton);
		
		JLabel seferEkleLabel = new JLabel("Eklenecek Sefer");
		seferEkleLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		seferEkleLabel.setBounds(25, 400, 172, 28);
		seferEklemePanel.add(seferEkleLabel);
		
		seferKacıncıText = new JTextField();
		seferKacıncıText.setBounds(25, 438, 96, 19);
		seferEklemePanel.add(seferKacıncıText);
		seferKacıncıText.setColumns(10);
		
		JButton seferEkleButton = new JButton("Ekle");
		seferEkleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String firmaseferekle = seferEklenecekFirmaBox.getSelectedItem().toString();
				
				if(Bus.firmaOtobus.get(firmaseferekle)!=null || Train.firmaTren.get(firmaseferekle)!=null || Airplane.firmaUcak.get(firmaseferekle)!=null)
				{
					String vehicle = seferEklenecekAraçBox.getSelectedItem().toString();
					String sefernumarasıtext = seferKacıncıText.getText();
					
					if(!sefernumarasıtext.isBlank())
					{
						int seferNumarası = Integer.parseInt(sefernumarasıtext);
						
						if(vehicle.startsWith("Otobüs"))
						{
							if(seferNumarası==3 || seferNumarası==4)
							{
								Bus[] mevcutotobusler = Bus.firmaOtobus.get(firmaseferekle);
								for (Bus otobus : mevcutotobusler)
								{
					                if(otobus.getBusName().equals(vehicle))
					                {					                  
					                    Trip.seferEkleOtobus(otobus, seferNumarası);
					                    busislem.koltukSayisi(firmaseferekle, vehicle, 40);
					                    ulasımislem.koltukDurumOtobus(otobus, 40);
					                    
					                }
					            }
							}
							else
								JOptionPane.showMessageDialog(null, "Girilen sefer numarası hatalı!");
						}
						
						else if(vehicle.startsWith("Tren"))
						{
							if(seferNumarası==1 || seferNumarası==2)
							{
								Train[] mevcutTrenler = Train.firmaTren.get(firmaseferekle);
								for(Train tren : mevcutTrenler)
								{
									if(tren.getTrainName().equals(vehicle))
									{
										Trip.seferEkleTren(tren, seferNumarası);
										trenislem.koltukSayisi(firmaseferekle, vehicle, 50);
										ulasımislem.koltukDurumuTren(tren, 50);
										
									}
								}								
							}
							else
								JOptionPane.showMessageDialog(null, "Girilen sefer numarası hatalı!");
						}
						
						else if(vehicle.startsWith("Uçak"))
						{
							if(seferNumarası==5 || seferNumarası==6)
							{
								Airplane[] mevcutUcaklar = Airplane.firmaUcak.get(firmaseferekle);
								for(Airplane ucak : mevcutUcaklar)
								{
									if(ucak.getAirplaneName().equals(vehicle))
									{
										Trip.seferEkleUcak(ucak, seferNumarası);
										ucakislem.koltukSayisi(firmaseferekle, vehicle, 60);
										ulasımislem.koltukDurumUcak(ucak, 60);
										
									}
								}								
							}
							else
								JOptionPane.showMessageDialog(null, "Girilen sefer numarası hatalı!");
						}
						
					}
					else
						JOptionPane.showMessageDialog(null, "Girilen sefer numarası hatalı!");
					
				}
			}
		});
		seferEkleButton.setBounds(25, 470, 76, 21);
		seferEklemePanel.add(seferEkleButton);
		
		
		JPanel seferÇıkarmaPanel = new JPanel();
		layeredPane.add(seferÇıkarmaPanel, "name_12857112249200");
		seferÇıkarmaPanel.setLayout(null);
		
		JButton seferÇıkarmaButton = new JButton("Sefer Çıkarma");
		seferÇıkarmaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				layeredPane.removeAll();
				layeredPane.add(seferÇıkarmaPanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		seferÇıkarmaButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		seferÇıkarmaButton.setBounds(31, 375, 164, 27);
		panel.add(seferÇıkarmaButton);
		
		JLabel seferÇıkarmaLabel = new JLabel("Sefer Çıkarma Ekranı");
		seferÇıkarmaLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		seferÇıkarmaLabel.setBounds(30, 21, 268, 57);
		seferÇıkarmaPanel.add(seferÇıkarmaLabel);
		
		JLabel firmaSeferÇıkarmaLabel = new JLabel("Sefer Çıkarılacak Firma");
		firmaSeferÇıkarmaLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		firmaSeferÇıkarmaLabel.setBounds(25, 150, 172, 28);
		seferÇıkarmaPanel.add(firmaSeferÇıkarmaLabel);
		
		JComboBox<String> seferÇıkarılacakFirmaBox = new JComboBox<String>();
		seferÇıkarılacakFirmaBox.setBounds(25, 188, 115, 20);
		seferÇıkarmaPanel.add(seferÇıkarılacakFirmaBox);
		
		JButton seferFirmaListeleButton2 = new JButton("Göster");
		seferFirmaListeleButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				seferÇıkarılacakFirmaBox.removeAllItems();
				for (int i = 0; i < firmaislem.firmadeti(); i++)
				{
					String firma = firmaislem.listele(i);
					seferÇıkarılacakFirmaBox.addItem(firma);
				}
			}
		});
		seferFirmaListeleButton2.setBounds(25, 218, 76, 21);
		seferÇıkarmaPanel.add(seferFirmaListeleButton2);
		
		JLabel seferAraçLabel2 = new JLabel("Sefer Çıkarılacak Araç");
		seferAraçLabel2.setFont(new Font("Tahoma", Font.ITALIC, 15));
		seferAraçLabel2.setBounds(25, 272, 172, 28);
		seferÇıkarmaPanel.add(seferAraçLabel2);
		
		JComboBox<String> seferÇıkarılacakAraçBox = new JComboBox<String>();
		seferÇıkarılacakAraçBox.setBounds(25, 310, 115, 20);
		seferÇıkarmaPanel.add(seferÇıkarılacakAraçBox);
		
		JButton seferÇıkarılacakAraçGösterButton = new JButton("Göster");
		seferÇıkarılacakAraçGösterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				seferÇıkarılacakAraçBox.removeAllItems();
				String firma = seferÇıkarılacakFirmaBox.getSelectedItem().toString();   
				
				if(Bus.firmaOtobus.get(firma)!=null)
				{
					Bus[] mevcutotobusler = Bus.firmaOtobus.get(firma);
				    Train[] mevcutTrenler = Train.firmaTren.get(firma);
				    Airplane[] mevcutUcaklar = Airplane.firmaUcak.get(firma);
				    
				    if(mevcutotobusler!=null)
					{
						for (Bus otobusler : mevcutotobusler)
				        {
							seferÇıkarılacakAraçBox.addItem(otobusler.getBusName());
				        }
					}				    
				    if(mevcutTrenler!=null)
				    {
				    	for (Train trenler : mevcutTrenler)
				        {
				    		seferÇıkarılacakAraçBox.addItem(trenler.getTrainName());
				        }
				    }
				    if(mevcutUcaklar!=null)
				    {
				    	for (Airplane trenler : mevcutUcaklar)
				        {
				        	seferÇıkarılacakAraçBox.addItem(trenler.getAirplaneName());
				        }
				    }
				}
				
			}
		});
		seferÇıkarılacakAraçGösterButton.setBounds(25, 343, 76, 21);
		seferÇıkarmaPanel.add(seferÇıkarılacakAraçGösterButton);
		
		JButton seferÇıkarButton = new JButton("Çıkar");
		seferÇıkarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			
				String firma = seferÇıkarılacakFirmaBox.getSelectedItem().toString();
				String vehicle = seferÇıkarılacakAraçBox.getSelectedItem().toString();
				
				if(vehicle.startsWith("Otobüs"))
				{
					if(Bus.firmaOtobus.get(firma)!=null)
					{					
						Bus[] mevcutotobusler = Bus.firmaOtobus.get(firma);
					    for(Bus otobus : mevcutotobusler)
				        {
					    	if(otobus.getBusName().equals(vehicle))
					    	{
					    		Trip.seferÇıkarOtobus(otobus);
					    	}
					    	
				        }
					}					
				}
				
				else if(vehicle.startsWith("Tren"))
				{
					if(Train.firmaTren.get(firma)!=null)
					{
						Train[] mevcutTrenler = Train.firmaTren.get(firma);
						for(Train tren : mevcutTrenler)
						{
							if(tren.getTrainName().equals(vehicle))
							{
								Trip.seferÇıkarTren(tren);
							}
						}
					}
				}
				
				else if(vehicle.startsWith("Uçak"))
				{
					if(Airplane.firmaUcak.get(firma)!=null)
					{
						Airplane[] mevcutUcaklar = Airplane.firmaUcak.get(firma);
						for(Airplane ucak : mevcutUcaklar)
						{
							if(ucak.getAirplaneName().equals(vehicle))
							{
								Trip.seferÇıkarUcak(ucak);
							}
						}
					}
				}
				
			}
		});
		seferÇıkarButton.setBounds(111, 343, 76, 21);
		seferÇıkarmaPanel.add(seferÇıkarButton);
		
		
		JPanel karHesaplaPanel = new JPanel();
		layeredPane.add(karHesaplaPanel, "name_25222834792200");
		karHesaplaPanel.setLayout(null);	
		
		JButton btnNewButton = new JButton("Geri");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				UserSelection window = new UserSelection();
                window.frame.setVisible(true);
                dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(31, 518, 67, 21);
		panel.add(btnNewButton);
		
		JLabel karHesaplamaLabel = new JLabel("Kar Hesaplama Ekranı");
		karHesaplamaLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		karHesaplamaLabel.setBounds(30, 21, 339, 57);
		karHesaplaPanel.add(karHesaplamaLabel);
		
		JLabel firmaHesaplanacakLabel = new JLabel("Kar Zarar Hesaplanacak Firma");
		firmaHesaplanacakLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		firmaHesaplanacakLabel.setBounds(25, 120, 210, 28);
		karHesaplaPanel.add(firmaHesaplanacakLabel);
		
		JLabel hesaplanacakGünLabel = new JLabel("Hesaplanması İstenilen Gün");
		hesaplanacakGünLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		hesaplanacakGünLabel.setBounds(25, 175, 200, 28);
		karHesaplaPanel.add(hesaplanacakGünLabel);
		
		JLabel yolcuUcretLabel = new JLabel("Yolcu Ücret Toplamı");
		yolcuUcretLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		yolcuUcretLabel.setBounds(25, 230, 170, 28);
		karHesaplaPanel.add(yolcuUcretLabel);
		
		JLabel hizmetBedeliLabel = new JLabel("Hizmet Bedeli");
		hizmetBedeliLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		hizmetBedeliLabel.setBounds(25, 285, 120, 28);
		karHesaplaPanel.add(hizmetBedeliLabel);
		
		JLabel personelMaliyetiLabel = new JLabel("Personel Maliyeti");
		personelMaliyetiLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		personelMaliyetiLabel.setBounds(25, 340, 120, 28);
		karHesaplaPanel.add(personelMaliyetiLabel);
		
		JLabel yakıtMaliyetiLabel = new JLabel("Yakıt Maliyeti");
		yakıtMaliyetiLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		yakıtMaliyetiLabel.setBounds(25, 395, 120, 28);
		karHesaplaPanel.add(yakıtMaliyetiLabel);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(25, 205, 100, 19);
		karHesaplaPanel.add(dateChooser);
		
		JComboBox<Integer> sonuccomboBox = new JComboBox<Integer>();
		sonuccomboBox.setBounds(25, 499, 100, 21);
		karHesaplaPanel.add(sonuccomboBox);
		
		JComboBox<String> firmaHesaplamacomboBox = new JComboBox<String>();
		firmaHesaplamacomboBox.setBounds(25, 151, 100, 21);
		karHesaplaPanel.add(firmaHesaplamacomboBox);
		
		JComboBox<Integer> yolcuUcreticomboBox = new JComboBox<Integer>();
		yolcuUcreticomboBox.setBounds(25, 259, 100, 21);
		karHesaplaPanel.add(yolcuUcreticomboBox);
		
		JComboBox<Integer> hizmetBedelicomboBox = new JComboBox<Integer>();
		hizmetBedelicomboBox.setBounds(25, 314, 100, 21);
		karHesaplaPanel.add(hizmetBedelicomboBox);
		
		JComboBox<Integer> personelMaliyeticomboBox = new JComboBox<Integer>();
		personelMaliyeticomboBox.setBounds(25, 369, 100, 21);
		karHesaplaPanel.add(personelMaliyeticomboBox);
		
		JComboBox<Integer> yakıtMaliyeticomboBox = new JComboBox<Integer>();
		yakıtMaliyeticomboBox.setBounds(25, 425, 100, 21);
		karHesaplaPanel.add(yakıtMaliyeticomboBox);
		
		JButton karHesaplaButton = new JButton("Günlük Kar Hesapla");
		karHesaplaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				layeredPane.removeAll();
				layeredPane.add(karHesaplaPanel);
				layeredPane.repaint();
				layeredPane.revalidate();
				
				firmaHesaplamacomboBox.removeAllItems();
				yolcuUcreticomboBox.removeAllItems();
				hizmetBedelicomboBox.removeAllItems();
				personelMaliyeticomboBox.removeAllItems();
				yakıtMaliyeticomboBox.removeAllItems();
				sonuccomboBox.removeAllItems();
				dateChooser.setDate(null);
				
				for (int i = 0; i < firmaislem.firmadeti(); i++)
				{
					String firma = firmaislem.listele(i);
					firmaHesaplamacomboBox.addItem(firma);
				}
			}
		});
		karHesaplaButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		karHesaplaButton.setBounds(31, 450, 164, 27);
		panel.add(karHesaplaButton);
		
		JButton hesaplaButton = new JButton("Hesapla");
		hesaplaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				yolcuUcreticomboBox.removeAllItems();
				hizmetBedelicomboBox.removeAllItems();
				personelMaliyeticomboBox.removeAllItems();
				yakıtMaliyeticomboBox.removeAllItems();
				sonuccomboBox.removeAllItems();

				
				String firma = firmaHesaplamacomboBox.getSelectedItem().toString();
				Date tarihsec = dateChooser.getDate();
				Instant anlık = tarihsec.toInstant();
				LocalDate tarih = anlık.atZone(ZoneId.systemDefault()).toLocalDate();
								
				int hizmetBedeli=1000;
				int personelMaliyeti;
				int yolcuUcreti;
				int yakıtMaliyeti;
				int sonuc;
				
				hizmetBedelicomboBox.addItem(hizmetBedeli);
				
				personelMaliyeti = firmaislem.firmaPersonelKarZarar(firma);
				personelMaliyeticomboBox.addItem(personelMaliyeti);
				
				yolcuUcreti=firmaislem.firmaBiletKarZarar(firma, tarih);
				yolcuUcreticomboBox.addItem(yolcuUcreti);
				
				yakıtMaliyeti = firmaislem.firmaMesafeKarZarar(firma);
				yakıtMaliyeticomboBox.addItem(yakıtMaliyeti);
				
				sonuc=yolcuUcreti-hizmetBedeli-personelMaliyeti-yakıtMaliyeti;
				sonuccomboBox.addItem(sonuc);				
				
			}
		});
		hesaplaButton.setBounds(25, 461, 85, 21);
		karHesaplaPanel.add(hesaplaButton);
		
		
		

	}
}
