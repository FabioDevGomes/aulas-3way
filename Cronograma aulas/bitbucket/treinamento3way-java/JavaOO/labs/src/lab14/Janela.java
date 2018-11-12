package lab14;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public final class Janela extends JFrame {
	
	private JLabel jlAgencia;
	private JTextField jtfAgencia;
	private JLabel jlConta;
	private JTextField jtfConta;
	private JSeparator jSeparator01;
	private JLabel jlNome;
	private JTextField jtfNome;
	private JLabel jlEndereco;
	private JTextField jtfEndereco;
	private JLabel jlTelefone;
	private JTextField jtfTelefone;
	private JLabel jlCpf;
	private JTextField jtfCpf;
	private JLabel jlCorrente;
	private JRadioButton jrbCorrente;
	private JLabel jlPoupanca;
	private JRadioButton jrbPoupanca;
	private ButtonGroup bgContas;
	private JSeparator jSeparator02;
	private JButton jbConsultar;
	private JButton jbAtualizar;
	private JButton jbFechar;

	public Janela() {
		setSize(400, 255);
		setTitle("Linguagem de Programação II");
		setResizable(false);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jlAgencia = new JLabel("Codigo da Agencia:");
		jlAgencia.setBounds(10, 10, 110, 18);
		getContentPane().add(jlAgencia);
		
		
		try {
			jtfAgencia = new JFormattedTextField(new MaskFormatter("####-#"));
		} catch (ParseException e) {
				e.printStackTrace();
		}
		jtfAgencia.addFocusListener(new FocusAdapter(){
			@Override
			public void focusGained(FocusEvent evt) {
				jtfAgencia.setBackground(Color.YELLOW);
			}
			
			@Override
			public void focusLost(FocusEvent evt) {
				jtfAgencia.setBackground(Color.WHITE);
			}
		});
		jtfAgencia.setBounds(125,10,50,20);
		getContentPane().add(jtfAgencia);
		
		
		jlConta = new JLabel("Numero da conta");
		jlConta.setBounds(205, 10, 105, 18);
		getContentPane().add(jlConta);
		
		try {
			jtfConta = new JFormattedTextField(new MaskFormatter("#####-#"));
		} catch (ParseException e) {
				e.printStackTrace();
		}
		jtfConta.setBounds(315, 10, 60, 20);
		jtfConta.addFocusListener(new FocusAdapter(){
			@Override
			public void focusGained(FocusEvent evt) {
				jtfConta.setBackground(Color.YELLOW);
			}
			
			@Override
			public void focusLost(FocusEvent evt) {
				jtfConta.setBackground(Color.WHITE);
			}
		});
		getContentPane().add(jtfConta);
		
		jSeparator01 = new JSeparator();
		jSeparator01.setBounds(10, 40, 365, 10);
		getContentPane().add(jSeparator01);
		
		jlNome = new JLabel("Nome:");
		jlNome.setBounds(10, 50, 60, 18);
		jlNome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		getContentPane().add(jlNome);
		
		jtfNome = new JTextField();
		jtfNome.setBounds(70, 50, 300, 20);
		jtfNome.addFocusListener(new FocusAdapter(){
			@Override
			public void focusGained(FocusEvent evt) {
				jtfNome.setBackground(Color.YELLOW);
			}
			
			@Override
			public void focusLost(FocusEvent evt) {
				jtfNome.setBackground(Color.WHITE);
			}
		});
		getContentPane().add(jtfNome);
		
		jlEndereco = new JLabel ("Endereço");
		jlEndereco.setBounds(10, 75, 60, 18);
		jlEndereco.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		getContentPane().add(jlEndereco);
		
		jtfEndereco = new JTextField();
		jtfEndereco.setBounds(75, 75, 300, 20);
		jtfEndereco.addFocusListener(new FocusAdapter(){
			@Override
			public void focusGained(FocusEvent evt) {
				jtfEndereco.setBackground(Color.YELLOW);
			}
			
			@Override
			public void focusLost(FocusEvent evt) {
				jtfEndereco.setBackground(Color.WHITE);
			}
		});
		getContentPane().add(jtfEndereco);
		
		jlTelefone = new JLabel ("Telefone:");
		jlTelefone.setBounds(10, 100, 60, 18);
		jlTelefone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		getContentPane().add(jlTelefone);
		
		try {
			jtfTelefone = new JFormattedTextField(new MaskFormatter("(0xx##) ####-####"));
		} catch (ParseException e) {
				e.printStackTrace();
		}
		jtfTelefone.setBounds(75, 100, 300, 20);
		jtfTelefone.addFocusListener(new FocusAdapter(){
			@Override
			public void focusGained(FocusEvent evt) {
				jtfTelefone.setBackground(Color.YELLOW);
			}
			
			@Override
			public void focusLost(FocusEvent evt) {
				jtfTelefone.setBackground(Color.WHITE);
			}
		});
		getContentPane().add(jtfTelefone);
		
		jlCpf = new JLabel ("CPF:");
		jlCpf.setBounds(10, 125, 60, 18);
		jlCpf.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		getContentPane().add(jlCpf);
		
		try {
			jtfCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e) {
				e.printStackTrace();
		}
		jtfCpf.setBounds(75, 125, 300, 20);
		jtfCpf.addFocusListener(new FocusAdapter(){
			@Override
			public void focusGained(FocusEvent evt) {
				jtfCpf.setBackground(Color.YELLOW);
			}
			
			@Override
			public void focusLost(FocusEvent evt) {
				jtfCpf.setBackground(Color.WHITE);
			}
		});
		getContentPane().add(jtfCpf);
		
		jlCorrente = new JLabel ("Conta Corrente:");
		jlCorrente.setBounds(120, 150, 100, 18);
		getContentPane().add(jlCorrente);
		
		jrbCorrente  = new JRadioButton();
		jrbCorrente.setBounds(100, 150, 111, 20);
		jrbCorrente.setMnemonic('C');
		jrbCorrente.setSelected(true);
		getContentPane().add(jrbCorrente);
		
		jlPoupanca = new JLabel ("Conta Poupanca:");
		jlPoupanca.setBounds(245, 150, 100, 18);
		getContentPane().add(jlPoupanca);
		
		jrbPoupanca = new JRadioButton();
		jrbPoupanca.setBounds(225, 150, 118, 20);
		jrbPoupanca.setMnemonic('P');
		jrbPoupanca.setSelected(true);
		getContentPane().add(jrbPoupanca);
		
		bgContas = new ButtonGroup();
		bgContas.add(jrbCorrente);
		bgContas.add(jrbPoupanca);
		
		jSeparator02 = new JSeparator();
		jSeparator02.setBounds(10, 180, 365, 10);
		getContentPane().add(jSeparator02);

		jbConsultar = new JButton("Consultar");
		jbConsultar.setBounds(45, 190, 100, 23);
		jbConsultar.setMnemonic('S');
		jbConsultar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
						
				if(jtfAgencia.getText().equals("    - ") || jtfConta.getText().equals("     - ")){
					JOptionPane.showMessageDialog(null, "E' necessário informar a agência e a conta", "3Way NetWorks", JOptionPane.INFORMATION_MESSAGE);
				}
						
			}
		});
		getContentPane().add(jbConsultar);
		
		jbAtualizar = new JButton("Atualizar");
		jbAtualizar.setBounds(150, 190, 100, 23);
		jbAtualizar.setMnemonic('A');
		jbAtualizar.setEnabled(false);
		getContentPane().add(jbAtualizar);
		
		jbFechar = new JButton("Fechar");
		jbFechar.setBounds(255, 190, 100, 23);
		jbFechar.setMnemonic('F');
		jbFechar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		getContentPane().add(jbFechar);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent evt) {
				JOptionPane.showMessageDialog(null, "Programação Java OO", "3Way NetWorks",JOptionPane.INFORMATION_MESSAGE);
			}
			
			@Override
			public void windowClosing(WindowEvent evt){
				JOptionPane.showMessageDialog(null, "Obrigado por utilizar nosso sistema.","3Way NetWorks",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		
		jbConsultar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jtfAgencia.getText().equals(" - ") || jtfConta.getText().equals(" - ")){
					JOptionPane.showMessageDialog(null, "E necessário informar a agência e a conta", "3Way NetWorks", JOptionPane.INFORMATION_MESSAGE);
				}
			}

		});
		
		jbFechar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String args[]) {
		Janela janela = new Janela();
		janela.setVisible(true);
	}
	
	private void centralizar() {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension janela = getSize();

		if (janela.height > screen.height) {
			setSize(janela.width, screen.height);
		}

		if (janela.width > screen.width) {
			setSize(screen.width, janela.height);
		}

		setLocation((screen.width - janela.width) / 2,
		(screen.height - janela.height) / 2);
	}
	
	
}