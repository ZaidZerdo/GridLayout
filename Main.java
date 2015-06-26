package vjezbe;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main extends JFrame {
	private static final long serialVersionUID = -3037227350838747481L;
	
	private JButton[] buttons = new JButton[9];
	private Integer sum = 0;
	private Boolean nextClickIsTheOne = false;
	
	public Main() {
		setLayout(new GridLayout(3, 3, 5, 5));
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton((i + 1) + "");
			buttons[i].setFont(new Font("Cambria", Font.BOLD, 30));
			buttons[i].addActionListener(new Action());
			add(buttons[i]);
		}
		
		
		setResizable(false);
		setTitle("Dugmici");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < buttons.length; i++) {
				if (e.getSource() == buttons[i]) {
					if (nextClickIsTheOne) {
						sum += Integer.parseInt(buttons[i].getText());
						JOptionPane.showMessageDialog(null, "Result is " + sum);
						nextClickIsTheOne = false;
						sum = 0;
					} else {
						sum += Integer.parseInt(buttons[i].getText());
						nextClickIsTheOne = true;
					}
					
					
				}
			}
		}
		
	}

}
