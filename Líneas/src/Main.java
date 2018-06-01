import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Main extends JFrame{
	
	private Lienzo lienzo;
	public int numLineas;
	private JSlider barra;
	private JPanel p;
	
	public Main(){
		super("Líneas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setPreferredSize(new Dimension(500, 500));
		c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
		// crear y añadir el JSlider
		barra = new JSlider(JSlider.HORIZONTAL,0,30,0);
		barra.setMajorTickSpacing(5);
		barra.setMinorTickSpacing(1);
		barra.setToolTipText("Número de Líneas"); //mantener el raton y sale el texto
		barra.setPaintLabels(true);//muestra los numeros
		barra.setPaintTicks(true);
		barra.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
		barra.addChangeListener(new EventoSlider());
		p = new JPanel();
		p.add(barra);
		add(p,BorderLayout.NORTH);
		// crear y añadir el Lienzo
		lienzo = new Lienzo(900, 300, barra.getValue());
		c.add(lienzo);		
		pack();
	
		pack();
	}
	
	private class EventoSlider implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {			
			lienzo.setNumeroLineas(barra.getValue() * 2 + 1);	
		}
		
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
						new Main().setVisible(true);
			}
		});
	}
	
}
