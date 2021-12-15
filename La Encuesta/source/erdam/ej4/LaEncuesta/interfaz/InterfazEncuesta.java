package erdam.ej4.LaEncuesta.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import erdam.ej4.LaEncuesta.mundo.Encuesta;
/**
 * Ventana principal de la aplicaci�n.
 */
@SuppressWarnings("serial")
public class InterfazEncuesta extends JFrame{
	//------- A T R I B U T O S -------//
	private PanelEncuesta panelEncuesta;
	private PanelImagenes banner;
	private Encuesta encuesta;
	//----- C O N S T R U C T O R  -----//
    /**
     * Constructor de la interfaz. <b>post: </b> Se inicializ� la interfaz principal y sus p�neles.<br>
     */
	public InterfazEncuesta()
	{
		setTitle("Encuesta del Curso");
		setSize(600,700);
		setLocationRelativeTo(null);
		encuesta      = new Encuesta();
		panelEncuesta = new PanelEncuesta(this);
		banner        = new PanelImagenes("data/imagenes/Encabezado.png");
		setLayout(new BorderLayout());
		add(banner, BorderLayout.NORTH);
		
		JPanel panCentral = new JPanel(new GridLayout(1,1));
		panCentral.add(panelEncuesta);
		add(panCentral, BorderLayout.CENTER);
	
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		
		
	}
	//--------- M � T O D O S ----------//
	/**
     * Devuelve el rango de edades de la encuesta.
     * @return Rango de edades de la encuesta.
     */
    public String[] darRangoEdades( )
    {
        String[] rangoEdades = new String[3];
        rangoEdades[ 0 ] = encuesta.darRangoEdadJoven() + " a�os";
        rangoEdades[ 1 ] = encuesta.darRangoEdadAdulto() + " a�os";

        int edadMaxima = Integer.parseInt( encuesta.darRangoEdadMayores().split( "-" )[ 1 ] );
        if( edadMaxima > 100 )
        {
            rangoEdades[ 2 ] = encuesta.darRangoEdadMayores().split( "-" )[ 0 ] + " o m�s";
        }
        else
        {
            rangoEdades[ 2 ] = encuesta.darRangoEdadMayores();
        }

        return rangoEdades;
    }
	//---------------------------------------------------//
    /**
     * Devuelve los resultados parciales de un grupo dado por par�metro.
     * @param pRango Edad para el grupo del cual se consultar� el promedio. pRango entre: 1,2 � 3.
     * @param pEsCasado Estado civil para el grupo del cual se consultar� el promedio.
     * @return Calificaci�n promedio para el grupo dado.
     */
	public double getResultadosParciales(int pRango, boolean pEsCasado)
	{
		double resultado = 0d;
		
		if (pEsCasado) {
			switch (pRango) {
			case 1:
				resultado = encuesta.getResultadoJovenesCasados();
				break;
			case 2:
				resultado = encuesta.getResultadoAdultosCasados();
				break;
			case 3:
				resultado = encuesta.getResultadoMayoresCasados();
			}

		} else {
			
			switch (pRango) {
			case 1:
				resultado = encuesta.getResultadoJovenesSolteros();
				break;
			case 2:
				resultado = encuesta.getResultadoAdultosSolteros();
				break;
			case 3:
				resultado = encuesta.getResultadoMayoresSolteros();
			}
		}

		return resultado;
	}
	
	//---------------------------------------------------//
    /**
     * Devuelve el n�mero total de opiniones recogidas.
     * @return N�mero total de opiniones recogidas.
     */
	public int getNumeroTotalDeOpiniones()
	{
		return encuesta.getNumeroTotalOpiniones();
	}
	//---------------------------------------------------//
    /**
     * Agrega una opini�n a la encuesta en el grupo dado por el rango de edad y si es casado o no.
     * @param pRango Edad de la persona que opin�. pRango entre: 1,2 � 3.
     * @param pEsCasado Estado civil de la persona que opin�.
     * @param pOpinion Valor de opini�n que se agregar�. pOpinion>0 && pOpinion<10.
     */
	public void agregarOpiniones(int pRango, boolean pEsCasado, int pOpinion)
	{
		if (pEsCasado) {
			switch (pRango) 
			{
			case 1:
				encuesta.agregarOpinionJovenCasados(pOpinion);
				break;
			case 2:
				encuesta.agregarOpinionAdultoCasados(pOpinion);
				break;
			case 3:
				encuesta.agregarOpinionMayorCasados(pOpinion);
			}

		} else {
			
			switch (pRango) {
			case 1:
				encuesta.agregarOpinionJovenSoltero(pOpinion);
				break;
			case 2:
				encuesta.agregarOpinionAdultoSoltero(pOpinion);
				break;
			case 3:
				encuesta.agregarOpinionMayorSoltero(pOpinion);
			}
		}
		
	}
	//---------------------------------------------------//
    /**
     * Actualiza los resultados totales mostrados en la interfaz.
     */
	public void actualizar()
	{
		panelEncuesta.actualizar(encuesta);
	}
	
	//---------------------------------------------------//
    /**
     * Formatea un valor num�rico real para presentar en la interfaz <br>
     * @param valor El valor num�rico a ser formateado
     * @return Cadena con el valor formateado con puntos y signos.
     */
	public String formatearValoresReales(double pValor)
	{
		DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
		df.applyPattern("###,###.##");
		df.setMinimumFractionDigits(2);
		return df.format(pValor);
	}
	
	//---------------------------------------------------//
	public static void main(String[] pArgs) {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			InterfazEncuesta encuesta = new InterfazEncuesta();
			encuesta.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
