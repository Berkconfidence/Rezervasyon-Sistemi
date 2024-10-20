package proje;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JComboBox;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class UserPanel extends JFrame {

	private JPanel contentPane;
	private final JLayeredPane layeredPane = new JLayeredPane();
	private JTextField biletAdetText;
	private JTextField isimSoyisimText;
	private JTextField tcKimlikText;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel() {
	    @Override
	    public boolean isCellEditable(int row, int column) {
	        return false;
	    }
	};
	private JTextField tcNoSorguText;
	private JTextField isimSorguText;
	private JTextField dogumTarihiSorguText;
	private JTextField seferSorguText;
	private JTextField seferTarihiText;
	private JTextField biletNoText;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPanel frame = new UserPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/* Belirli bir güundeki ulaşım araçların listelenmesi yapılabilir.
	 * Rezervasyon yapılabilir (Bir kullanıcı aynı anda birden fazla rezervasyon yapabilir)
	 * Rezervasyon görüntüle
	 * 
	 * 
	 */
	public UserPanel()
	{
		Transport koltukislem = new Transport();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 786, 563);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));;		
						
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 786, 563);
		layeredPane.add(panel, "name_21031961201900");
		panel.setLayout(null);
		
		JPanel panel2 = new JPanel();
		panel2.setToolTipText("");
		panel2.setBackground(SystemColor.activeCaption);
		panel2.setBounds(0, 0, 786, 563);
		layeredPane.add(panel2, "name_12574149614100");
		panel2.setLayout(null);
		
		JPanel panelSorgu = new JPanel();
		panelSorgu.setBounds(350, 120, 375, 265);
		panel.add(panelSorgu);
		
		JLabel baslikLabel_1 = new JLabel("BİLET ALMA EKRANI");
		baslikLabel_1.setForeground(new Color(32, 32, 32));
		baslikLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 30));
		baslikLabel_1.setBounds(245, 10, 448, 44);
		panel2.add(baslikLabel_1);
		
		JPanel panelMusteri = new JPanel();
		panelMusteri.setBounds(24, 121, 251, 313);
		panel2.add(panelMusteri);
		panelMusteri.setLayout(null);
		
		JLabel isimSoyisimLabel = new JLabel("İsim Soyisim Giriniz");
		isimSoyisimLabel.setBounds(10, 20, 172, 28);
		panelMusteri.add(isimSoyisimLabel);
		isimSoyisimLabel.setForeground(Color.BLACK);
		isimSoyisimLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		
		isimSoyisimText = new JTextField();
		isimSoyisimText.setBounds(10, 55, 124, 19);
		panelMusteri.add(isimSoyisimText);
		isimSoyisimText.setColumns(10);
		
		JLabel tcKimlikLabel = new JLabel("T.C Kimlik No Giriniz");
		tcKimlikLabel.setBounds(10, 90, 172, 28);
		panelMusteri.add(tcKimlikLabel);
		tcKimlikLabel.setForeground(Color.BLACK);
		tcKimlikLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		
		tcKimlikText = new JTextField();
		tcKimlikText.setBounds(10, 120, 125, 19);
		panelMusteri.add(tcKimlikText);
		tcKimlikText.setColumns(10);
		
		JLabel dogumTarihiLabel = new JLabel("Doğum Tarihini Seçiniz");
		dogumTarihiLabel.setBounds(10, 160, 172, 28);
		panelMusteri.add(dogumTarihiLabel);
		dogumTarihiLabel.setForeground(Color.BLACK);
		dogumTarihiLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		
		JDateChooser dogumDateChooser = new JDateChooser();
		dogumDateChooser.setBounds(10, 195, 124, 19);
		panelMusteri.add(dogumDateChooser);
		
		JButton vazgecButton = new JButton("Vazgeç");
		vazgecButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				model.setRowCount(0);
				isimSoyisimText.setText("");
				tcKimlikText.setText("");
				Passenger.yolcuAktarma.clear();
				dogumDateChooser.setDate(null);
				layeredPane.removeAll();
				layeredPane.add(panel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		vazgecButton.setBounds(91, 224, 75, 21);
		panelMusteri.add(vazgecButton);		
		
		JPanel panelSefer = new JPanel();
		panelSefer.setBounds(300, 121, 475, 313);
		panel2.add(panelSefer);
		panelSefer.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 475, 313);
		panelSefer.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(176, 196, 222));
		model = new DefaultTableModel();
		Object[] column = {"Koltuk Numarası","Durum","İsim Soyisim","T.C Kimlik No","Doğum Tarihi"};
		final Object[] row = new Object[60];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);

		
		JLabel baslikLabel = new JLabel("BİLET ALMA EKRANI");
		baslikLabel.setBounds(245, 10, 458, 44);
		baslikLabel.setForeground(new Color(32, 32, 32));
		baslikLabel.setFont(new Font("Tahoma", Font.ITALIC, 30));
		panel.add(baslikLabel);
		
		biletAdetText = new JTextField();
		biletAdetText.setBounds(35, 101, 96, 19);
		panel.add(biletAdetText);
		biletAdetText.setColumns(10);
		
		JLabel biletAdetLabel = new JLabel("Alınacak Bilet Sayısı");
		biletAdetLabel.setBounds(35, 69, 172, 28);
		biletAdetLabel.setForeground(new Color(0, 0, 0));
		biletAdetLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		panel.add(biletAdetLabel);
		
		JLabel biletKalkışVarışLabel = new JLabel("Kalkış ve Varış Yeri Seçiniz");
		biletKalkışVarışLabel.setBounds(35, 129, 200, 28);
		biletKalkışVarışLabel.setForeground(Color.BLACK);
		biletKalkışVarışLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		panel.add(biletKalkışVarışLabel);
		
		JComboBox<String> kalkışcomboBox = new JComboBox<String>();
		kalkışcomboBox.setBounds(35, 164, 107, 21);
		kalkışcomboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"İstanbul", "Kocaeli", "Bilecik", "Ankara", "Eskişehir", "Konya"}));
		kalkışcomboBox.setToolTipText("İstanbul\r\n");
		panel.add(kalkışcomboBox);
		
		JComboBox<String> varışcomboBox = new JComboBox<String>();
		varışcomboBox.setBounds(35, 194, 107, 21);
		varışcomboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"İstanbul", "Kocaeli", "Bilecik", "Ankara", "Eskişehir", "Konya"}));
		panel.add(varışcomboBox);
			
		JComboBox<String> bosKoltukcomboBox = new JComboBox<String>();
		bosKoltukcomboBox.setBounds(35, 416, 107, 21);
		bosKoltukcomboBox.setToolTipText("İstanbul\r\n");
		panel.add(bosKoltukcomboBox);
		
		JComboBox<String> seferlercomboBox = new JComboBox<String>();
		seferlercomboBox.setBounds(35, 362, 175, 21);
		panel.add(seferlercomboBox);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(35, 259, 107, 21);
		Calendar minDate = Calendar.getInstance();
        minDate.set(2023, Calendar.DECEMBER, 4);
        Calendar maxDate = Calendar.getInstance();
        maxDate.set(2023, Calendar.DECEMBER, 10, 23, 59, 59);
        dateChooser.getJCalendar().setSelectableDateRange(minDate.getTime(), maxDate.getTime());
		panel.add(dateChooser);
		
		JLabel biletTarihiLabel = new JLabel("Bilet Tarihini Seçiniz");
		biletTarihiLabel.setBounds(35, 229, 200, 28);
		biletTarihiLabel.setForeground(Color.BLACK);
		biletTarihiLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		panel.add(biletTarihiLabel);
		
		JButton seferBulButton = new JButton("Sefer Bul ");
		seferBulButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{			
				try
				{
					seferlercomboBox.removeAllItems();
					String biletSayisitext = biletAdetText.getText();
					int biletSayisi = Integer.parseInt(biletSayisitext);
					String kalkıs = kalkışcomboBox.getSelectedItem().toString();
					String varıs = varışcomboBox.getSelectedItem().toString();
					if(!kalkıs.equals(varıs))
					{
						Date tarih = dateChooser.getDate();
						Instant anlık = tarih.toInstant();
						LocalDate localDate = anlık.atZone(ZoneId.systemDefault()).toLocalDate();
						Reservation seferler = new Reservation();
						
						seferler.seferBul(biletSayisi, kalkıs, varıs, localDate);
												
						for (Map.Entry<String, ArrayList<String>> entry : Reservation.listeleSeferOtobus.entrySet())
						{
							String firma = entry.getKey();
						    ArrayList<String> aracListesi = entry.getValue();
						    for (String arac : aracListesi)
						    {
						    	String birlesik = firma + "'nın " + arac+" Aracı";
						    	seferlercomboBox.addItem(birlesik);
						    }
				        }
						for (Map.Entry<String, ArrayList<String>> entry : Reservation.listeleSeferTren.entrySet())
						{
							String firma = entry.getKey();
						    ArrayList<String> aracListesi = entry.getValue();
						    for (String arac : aracListesi)
						    {
						    	String birlesik = firma + "'nın " + arac+" Aracı";
						    	seferlercomboBox.addItem(birlesik);
						    }
				        }
						for (Map.Entry<String, ArrayList<String>> entry : Reservation.listeleSeferUcak.entrySet())
						{
							String firma = entry.getKey();
						    ArrayList<String> aracListesi = entry.getValue();
						    for (String arac : aracListesi)
						    {
						    	String birlesik = firma + "'nın " + arac+" Aracı";
						    	seferlercomboBox.addItem(birlesik);
						    }
				        }
					}
					else
						JOptionPane.showMessageDialog(null, "Kalkış ve Varış Yeri Aynı Olamaz!");					    
				} 
				catch (NumberFormatException e1) {				
					JOptionPane.showMessageDialog(null, "Hatalı Müşteri Sayısı!");
				}											
			}
		});
		seferBulButton.setBounds(35, 289, 107, 21);
		seferBulButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(seferBulButton);
		
		JLabel biletSeferlerLabel = new JLabel("Bulunan Seferler");
		biletSeferlerLabel.setBounds(35, 334, 200, 28);
		biletSeferlerLabel.setForeground(Color.BLACK);
		biletSeferlerLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		panel.add(biletSeferlerLabel);
			
		JLabel koltukSayisiLabel = new JLabel("Boş Koltuk Sayısı");
		koltukSayisiLabel.setBounds(35, 385, 200, 28);
		koltukSayisiLabel.setForeground(Color.BLACK);
		koltukSayisiLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		panel.add(koltukSayisiLabel);
		
		JButton bosKoltukGosterButton = new JButton("Göster ");
		bosKoltukGosterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				bosKoltukcomboBox.removeAllItems();
				String secilenSefer = seferlercomboBox.getSelectedItem().toString();
				String[] parcalar1 = secilenSefer.split("'nın");
				String firmaAdi = parcalar1[0].trim();
				String[] parcalar = secilenSefer.split(" ");
				String aracAdı = parcalar[parcalar.length - 2];
				
				Date tarih = dateChooser.getDate();
				Instant anlık = tarih.toInstant();
				LocalDate localDate = anlık.atZone(ZoneId.systemDefault()).toLocalDate();
				
				if(aracAdı.startsWith("Otobüs"))
				{
					Bus[] mevcutotobusler = Bus.firmaOtobus.get(firmaAdi);
					for (Bus otobus : mevcutotobusler)
					{
		                if(otobus.getBusName().equals(aracAdı))
		                {					                  
		                   int bosKoltuk = koltukislem.bosKoltukOtobus(otobus, localDate);
		                   String bosKoltukSayisi = Integer.toString(bosKoltuk);
		                   bosKoltukcomboBox.addItem(bosKoltukSayisi);		                   
		                }
		            }					
				}
				else if(aracAdı.startsWith("Tren"))
				{
					Train[] mevcuttrenler = Train.firmaTren.get(firmaAdi);
					for (Train tren : mevcuttrenler)
					{
		                if(tren.getTrainName().equals(aracAdı))
		                {					                  
		                   int bosKoltuk = koltukislem.bosKoltukTren(tren, localDate);
		                   String bosKoltukSayisi = Integer.toString(bosKoltuk);
		                   bosKoltukcomboBox.addItem(bosKoltukSayisi);		                   
		                }
		            }					
				}
				else if(aracAdı.startsWith("Uçak"))
				{
					Airplane[] mevcutUcaklar = Airplane.firmaUcak.get(firmaAdi);
					for(Airplane ucak : mevcutUcaklar)
					{
						if(ucak.getAirplaneName().equals(aracAdı))
						{
							int bosKoltuk = koltukislem.bosKoltukUcak(ucak, localDate);
			                String bosKoltukSayisi = Integer.toString(bosKoltuk);
			                bosKoltukcomboBox.addItem(bosKoltukSayisi);	
						}
					}
				}
			}
		});
		bosKoltukGosterButton.setBounds(35, 444, 75, 21);
		bosKoltukGosterButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(bosKoltukGosterButton);
		
		JButton onaylaButton = new JButton("Onayla");
		onaylaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String secilenSefer = seferlercomboBox.getSelectedItem().toString();
				String[] parcalar1 = secilenSefer.split("'nın");
				String firmaAdi = parcalar1[0].trim();
				String[] parcalar = secilenSefer.split(" ");
				String aracAdı = parcalar[parcalar.length - 2];
				
				Date tarih = dateChooser.getDate();
				Instant anlık = tarih.toInstant();
				LocalDate localDate = anlık.atZone(ZoneId.systemDefault()).toLocalDate();
				
				if(aracAdı.startsWith("Otobüs"))
				{
					Bus[] mevcutotobusler = Bus.firmaOtobus.get(firmaAdi);
					for (Bus otobus : mevcutotobusler)
					{
		                if(otobus.getBusName().equals(aracAdı))
		                {					                  
		                	boolean[] koltuklar = Transport.firmaKoltukOtobus.get(otobus).get(localDate);
						    for (int i = 1; i <= koltuklar.length; i++)
					    	{
					        	if(koltuklar[i-1])
					        	{
					        		row[0]=i;
									row[1]="Dolu";									
									model.addRow(row);
					        	}
					        	else
					        	{
					        		row[0]=i;
									row[1]="Boş";									
									model.addRow(row);
					        	}
						            
						    }               
		                }
		            }					
				}
				else if(aracAdı.startsWith("Tren"))
				{
					Train[] mevcuttrenler = Train.firmaTren.get(firmaAdi);
					for (Train tren : mevcuttrenler)
					{
		                if(tren.getTrainName().equals(aracAdı))
		                {					                  
		                  	boolean[] koltuklar = Transport.firmaKoltukTren.get(tren).get(localDate);
						    for (int i = 1; i <= koltuklar.length; i++)
					    	{
						    	if(koltuklar[i-1])
					        	{
					        		row[0]=i;
									row[1]="Dolu";									
									model.addRow(row);
					        	}
					        	else
					        	{
					        		row[0]=i;
									row[1]="Boş";									
									model.addRow(row);
					        	}
						            
						    }                    
		                }
		            }					
				}
				else if(aracAdı.startsWith("Uçak"))
				{
					Airplane[] mevcutUcaklar = Airplane.firmaUcak.get(firmaAdi);
					for(Airplane ucak : mevcutUcaklar)
					{
						if(ucak.getAirplaneName().equals(aracAdı))
						{
							boolean[] koltuklar = Transport.firmaKoltukUcak.get(ucak).get(localDate);
						    for (int i = 1; i <= koltuklar.length; i++)
					    	{
					        	if(koltuklar[i-1])
					        	{
					        		row[0]=i;
									row[1]="Dolu";									
									model.addRow(row);
					        	}
					        	else
					        	{
					        		row[0]=i;
									row[1]="Boş";									
									model.addRow(row);
					        	}
						            
						    }  
						}
					}
				}
				
				layeredPane.removeAll();
				layeredPane.add(panel2);
				layeredPane.repaint();
				layeredPane.revalidate();
								
			}
		});
		onaylaButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		onaylaButton.setBounds(118, 445, 75, 21);
		panel.add(onaylaButton);
		
		JButton geriButton = new JButton("Geri ");
		geriButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				UserSelection window = new UserSelection();
                window.frame.setVisible(true);
                dispose();
			}
		});
		geriButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		geriButton.setBounds(35, 520, 75, 21);
		panel.add(geriButton);
		panelSorgu.setLayout(null);
		
		JLabel biletSorgularLabel = new JLabel("Bilet Sorgula");
		biletSorgularLabel.setForeground(Color.BLACK);
		biletSorgularLabel.setFont(new Font("Tahoma", Font.ITALIC, 17));
		biletSorgularLabel.setBounds(200, 20, 105, 21);
		panelSorgu.add(biletSorgularLabel);
		
		JLabel tcNoSorguLabel = new JLabel("T.C Kimlik No Giriniz");
		tcNoSorguLabel.setForeground(Color.BLACK);
		tcNoSorguLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		tcNoSorguLabel.setBounds(25, 50, 140, 19);
		panelSorgu.add(tcNoSorguLabel);
		
		JLabel isimSorguLabel = new JLabel("İsim Soyisim");
		isimSorguLabel.setForeground(Color.BLACK);
		isimSorguLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		isimSorguLabel.setBounds(25, 80, 85, 19);
		panelSorgu.add(isimSorguLabel);
		
		JLabel dogumTarihiSorguLabel = new JLabel("Doğum Tarihiniz");
		dogumTarihiSorguLabel.setForeground(Color.BLACK);
		dogumTarihiSorguLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		dogumTarihiSorguLabel.setBounds(25, 110, 115, 19);
		panelSorgu.add(dogumTarihiSorguLabel);
		
		JLabel seferSorguLabel = new JLabel("Seferiniz");
		seferSorguLabel.setForeground(Color.BLACK);
		seferSorguLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		seferSorguLabel.setBounds(25, 140, 60, 19);
		panelSorgu.add(seferSorguLabel);
		
		JLabel seferTarihSorguLabel = new JLabel("Sefer Tarihi");
		seferTarihSorguLabel.setForeground(Color.BLACK);
		seferTarihSorguLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		seferTarihSorguLabel.setBounds(25, 169, 90, 19);
		panelSorgu.add(seferTarihSorguLabel);
		
		JLabel koltukNoSorguLabel = new JLabel("Koltuk Numaranız");
		koltukNoSorguLabel.setForeground(Color.BLACK);
		koltukNoSorguLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		koltukNoSorguLabel.setBounds(25, 198, 125, 19);
		panelSorgu.add(koltukNoSorguLabel);
		
		tcNoSorguText = new JTextField();
		tcNoSorguText.setColumns(10);
		tcNoSorguText.setBounds(200, 50, 145, 19);
		panelSorgu.add(tcNoSorguText);
		
		isimSorguText = new JTextField();
		isimSorguText.setColumns(10);
		isimSorguText.setBounds(200, 80, 145, 19);
		panelSorgu.add(isimSorguText);
		
		dogumTarihiSorguText = new JTextField();
		dogumTarihiSorguText.setColumns(10);
		dogumTarihiSorguText.setBounds(200, 110, 145, 19);
		panelSorgu.add(dogumTarihiSorguText);
		
		seferSorguText = new JTextField();
		seferSorguText.setColumns(10);
		seferSorguText.setBounds(200, 140, 145, 19);
		panelSorgu.add(seferSorguText);		
		
		seferTarihiText = new JTextField();
		seferTarihiText.setColumns(10);
		seferTarihiText.setBounds(200, 168, 145, 19);
		panelSorgu.add(seferTarihiText);
		
		biletNoText = new JTextField();
		biletNoText.setColumns(10);
		biletNoText.setBounds(200, 198, 145, 19);
		panelSorgu.add(biletNoText);
				
		JButton ekleButton = new JButton("Ekle");
		ekleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String biletSayisitext = biletAdetText.getText();
				int biletSayisi = Integer.parseInt(biletSayisitext);
				String secilenSefer = seferlercomboBox.getSelectedItem().toString();
				String[] parcalar1 = secilenSefer.split("'nın");
				String firmaAdi = parcalar1[0].trim();
				String[] parcalar = secilenSefer.split(" ");
				String aracAdı = parcalar[parcalar.length - 2];
				
				Date date = dateChooser.getDate();
				Instant seferAnlık = date.toInstant();
				LocalDate seferTarih = seferAnlık.atZone(ZoneId.systemDefault()).toLocalDate();
				DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		        String seferTarihi = seferTarih.format(format);
				LocalDate sinirTarih = LocalDate.of(2023, 12, 8);

				
				if(Passenger.yolcuAktarma.size() < biletSayisi)
				{
					if(!isimSoyisimText.getText().isEmpty() && !tcKimlikText.getText().isEmpty() && dogumDateChooser.getDate()!=null && tcKimlikText.getText().length()==11)
					{
						int i = table.getSelectedRow();
						if(i>=0)
						{
							boolean tcKimlikVar = false;
							for (int row = 0; row < model.getRowCount(); row++)
							{
								if((String) model.getValueAt(row, 3)!=null)
								{
									String tcKimlikTablo = (String) model.getValueAt(row, 3);						    
								    if (tcKimlikTablo.equals(tcKimlikText.getText())) {
								        tcKimlikVar = true;
								        break;
								    }
								}						    
							}
							if(!tcKimlikVar)
							{
								if(model.getValueAt(i, 1).equals("Boş"))
								{																		
									Date tarih = dogumDateChooser.getDate();
									Instant anlık = tarih.toInstant();
									LocalDate localDate = anlık.atZone(ZoneId.systemDefault()).toLocalDate();
									DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
							        String dogumTarihi = localDate.format(formatter);
							        if(localDate.isBefore(sinirTarih))
							        {
							        	model.setValueAt(dogumTarihi, i, 4);
										model.setValueAt("Dolu", i, 1);
										model.setValueAt(isimSoyisimText.getText(), i, 2);
										model.setValueAt(tcKimlikText.getText(), i, 3);
										Object value = model.getValueAt(i, 0);
										int degis = Integer.parseInt(value.toString());
										koltukislem.koltukGuncelle(firmaAdi, aracAdı, seferTarih, degis);
										String koltukNo = Integer.toString(degis);
										
										String[] liste = new String[5];										
										liste[0]=isimSoyisimText.getText();
										liste[1]=dogumTarihi;
										liste[2]=secilenSefer;
										liste[3]=seferTarihi;
										liste[4]=koltukNo;
										Passenger.yolcuAktarma.put(tcKimlikText.getText(),liste);
										JOptionPane.showMessageDialog(null, "İşleminiz Başarılı!");
										isimSoyisimText.setText("");
										tcKimlikText.setText("");
										dogumDateChooser.setDate(null);
							        }
							        else
							        	JOptionPane.showMessageDialog(null, "Geçersiz Doğum Tarihi!");									
								}
								else
									JOptionPane.showMessageDialog(null, "Boş Koltuk Seçiniz!");
							}
							else
								JOptionPane.showMessageDialog(null, "Bu T.C Kimlik Numarasına Ekli Müşteri Bulunmaktadır!");													
						}
						else
							JOptionPane.showMessageDialog(null, "Bir Koltuk Seçiniz!");
					}
					else
						JOptionPane.showMessageDialog(null, "Eksik Bilgi Girmeyiniz!");
				}
																		
			}
		});
		ekleButton.setBounds(10, 224, 75, 21);
		panelMusteri.add(ekleButton);
		
		JButton odemeYapButton = new JButton("Ödemeyi Tamamla");
		odemeYapButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String biletSayisitext = biletAdetText.getText();
				int biletSayisi = Integer.parseInt(biletSayisitext);
				if(Passenger.yolcuAktarma.size() == biletSayisi)
				{
					Passenger.yolcu.putAll(Passenger.yolcuAktarma);
					Passenger.yolcuAktarma.clear();
					JOptionPane.showMessageDialog(null,"Ödeme Tamamlandı!");
					layeredPane.removeAll();
					layeredPane.add(panel);
					layeredPane.repaint();
					layeredPane.revalidate();
				}
				else if(Passenger.yolcuAktarma.size()==0)
					JOptionPane.showMessageDialog(null, "Önce "+biletSayisi+" Adet Bilet Ekleme Yapınız!");
				else
					JOptionPane.showMessageDialog(null,(biletSayisi-Passenger.yolcuAktarma.size())+" Adet Daha Bilet Ekleme Yapınız!");
			}
		});
		odemeYapButton.setBounds(10, 271, 156, 21);
		panelMusteri.add(odemeYapButton);	
		
		JButton biletSorgulaButton = new JButton("Sorgula");
		biletSorgulaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(!tcNoSorguText.getText().isEmpty())
				{
					if(Passenger.yolcu.get(tcNoSorguText.getText())!=null)
					{
						String[] bilgiler = Passenger.yolcu.get(tcNoSorguText.getText());
						isimSorguText.setText(bilgiler[0]);
						dogumTarihiSorguText.setText(bilgiler[1]);
						seferSorguText.setText(bilgiler[2]);
						seferTarihiText.setText(bilgiler[3]);
						biletNoText.setText(bilgiler[4]);
					}
					else
						JOptionPane.showMessageDialog(null,"Bu T.C Kimlik No'suna Kayıtlı Bilet Bulunamadı");
				}
				else
					JOptionPane.showMessageDialog(null,"T.C Kimlik No Boş Kalamaz!");
			}
		});
		biletSorgulaButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		biletSorgulaButton.setBounds(25, 230, 75, 21);
		panelSorgu.add(biletSorgulaButton);
		
	
		
		
		

				
		
	}
}
