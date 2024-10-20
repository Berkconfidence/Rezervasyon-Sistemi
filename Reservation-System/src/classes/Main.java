package proje;

import java.awt.EventQueue;

public class Main {

	public static void main(String[] args)
	{   
		Company.hazirFirmalar();
				
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
}
