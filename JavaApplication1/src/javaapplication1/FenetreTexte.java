
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetreTexte extends JFrame{
	public FenetreTexte(){
		super();
		
		build();//On initialise notre fenêtre
	}
	
	private void build(){
		setTitle("Fenêtre qui affiche du texte"); //On donne un titre à l'application
		setSize(320,240); //On donne une taille à notre fenêtre
		setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		setResizable(true); //On permet le redimensionnement
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
		setContentPane(buildContentPane());
	}
	
	private JPanel buildContentPane(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		JLabel label = new JLabel("Bienvenue dans ma modeste application");
		
		panel.add(label);
		
		return panel;
	}	
	
	public static void main(String[] args) {
		//On crée une nouvelle instance de notre FenetreTexte
		FenetreTexte fenetre = new FenetreTexte();
		fenetre.setVisible(true);//On la rend visible
	}
}