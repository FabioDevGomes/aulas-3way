package swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AppSwing extends JFrame {
	
	JButton botao;
	JLabel label;
	
	public AppSwing() {
		super("Primeira ..");
		setSize(300, 100);
		initialize();
	}
	
	private void initialize() {
		
	}
	
	public static void main(String[] args) {
		AppSwing appSwing = new AppSwing();
		appSwing.setVisible(true);
	}

}
