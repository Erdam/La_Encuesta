package erdam.ej4.LaEncuesta.interfaz;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Panel con la imagen fondo reango de edad.
 */
@SuppressWarnings("serial")
public class PanelImagenes extends JPanel{
	// ------- A T R I B U T O S -------//
	 private JLabel 	contenedor;
	 private ImageIcon 	fondo;
	 private String 	url;
	
		// ----- C O N S T R U C T O R -----//

	/**
	 *  Constructor del panel. <br>
	 *  <b>post: </b> Panel quedó inicializado.
	 * @param pUrl de la imagen que irá de fondo.
	 */
	 public PanelImagenes(String pUrl)
	{
		 url = pUrl;
		contenedor = new JLabel("");
		fondo = new ImageIcon(url);
		contenedor.setIcon(fondo);
		add(contenedor);
	}
	 
	
	

}
