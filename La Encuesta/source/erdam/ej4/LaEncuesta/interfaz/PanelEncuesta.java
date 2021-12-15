package erdam.ej4.LaEncuesta.interfaz;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import erdam.ej4.LaEncuesta.mundo.Encuesta;


@SuppressWarnings("serial")
public class PanelEncuesta extends JPanel implements ActionListener {
	// ------- C O N S T A N T E S -------//
	private static final String INICIAR_ENCUESTA 		= "Iniciar encuesta";
	private static final String RANGO_DE_EDAD 			= "Rango de edad";
	private static final String ESTADO_CIVIL 			= "Estado civil";
	private static final String OPINION 				= "Opinión";
	private static final String AGREGAR_OPINION 		= "Agregar opinión";
	private static final String CONSULTAR 				= "Consultar";
	private static final String VER_RESULTADOS 			= "Ver resultados";
	
	// ------- A T R I B U T O S -------//
	private InterfazEncuesta 		principal;
	private PanelImagenes 			fondoRangoEdad;
	private PanelImagenes 			fondoEstadoCivil;
	private PanelImagenes 			fondoOpinion;

	private JLabel 					lblOpinion;
	private JLabel 					lblNumerOpiniones;
	private JLabel 					lblRango;
	private JLabel 					lblFiltroRango;
	private JLabel 					lblEstadoCivil;
	private JLabel 					lblFiltroEstadoCivil;
	private JLabel 					lblPromedioEncuesta;
	private JLabel 					lblPregunta;
	private JLabel 					lblConsulta;
	
	private JTextField 				txtNumerOpiniones;
	private JTextField 				txtPromedioEncuesta;
	private JTextField 				txtConsulta;
	
	private JButton 				btnRealizarEncuesta;
	private JButton 				btnSiguienteRangoDeEdad;
	private JButton 				btnAnteriorEstadoCivil;
	private JButton 				btnSiguienteEstadoCivil;
	private JButton 				btnAnteriorOpinion;
	private JButton 				btnAgregarOpinion;
	private JButton 				btnConsulta;
	private JButton 				btnNuevaEncuesta;
	
	private JComboBox<String> 		cbxRango;
	private JComboBox<String> 		cbxFiltroRango;
	private JComboBox<String> 		cbxOpinion;
	private JComboBox<String> 		cbxEstadoCivil;
	private JComboBox<String> 		cbxFiltroEstadoCivil;
	
	private JPanel    				panPregunta;  
	private JPanel 					panCabecera;
	private JPanel      			panInternoIniciarEncuesta;
	
	private JPanel      			panInternoRangoEdad;
	private JPanel      			panBotonesRangoEdad;
	private JPanel      			panPreguntaRangoEdad;
	
	private JPanel      			panInternoEstadoCivil;
	private JPanel      			panBotonesEstadoCivil;
	private JPanel      			panPreguntaEstadoCivil;
	
	private JPanel      			panInternoOpinion;
	private JPanel      			panBotonesOpinion;
	private JPanel      			panPreguntaOpinion;
	
	private JPanel      			panInternoResultados;
	private JPanel      			panConsulta;
	
	private JPanel      			panInterno1;
	private JPanel      			panInterno2;
	private JPanel      			panInterno3;
	private JPanel      			panInterno4;
	
	private JPanel      			panGrafico;
	private JPanel                  panEstadisticasGenerales;
	private JPanel                  panTotal;
	
	private DefaultCategoryDataset 	bdCasados;
	private DefaultCategoryDataset 	bdSolteros;
	
	private ChartPanel 				panCasados;
	private ChartPanel 				panSolteros;


	// ----- C O N S T R U C T O R -----//
    /**
     * Constructor del panel. <b>post: </b> Se inicializó el panel.<br>
     * @param pPrincipal Ventana principal. pPrincipal != null.
     */
	
	public PanelEncuesta(InterfazEncuesta pPrincipal) 
	{
		setLayout(new BorderLayout());
		TitledBorder titulo 			= BorderFactory.createTitledBorder("Agregar opción a encuesta");
		titulo.setTitleFont(new Font("Comic Sans MS",Font.BOLD,15));
		titulo.setTitleColor(Color.GRAY);
		setBorder(titulo);
		
		// inicializo
		
		principal 						= pPrincipal;
		fondoRangoEdad                  = new PanelImagenes("data/imagenes/RangoEdad.png");
		fondoEstadoCivil                = new PanelImagenes("data/imagenes/EstadoCivil.png");
		fondoOpinion                    = new PanelImagenes("data/imagenes/Calificacion.png");
		
		panCabecera 					= new JPanel();
		panPregunta 					= new JPanel(new CardLayout());
		panInternoIniciarEncuesta 		= new JPanel();
		
		panInternoRangoEdad 			= new JPanel();
		panBotonesRangoEdad				= new JPanel();
		panPreguntaRangoEdad			= new JPanel();
		
		panInternoEstadoCivil			= new JPanel();
		panBotonesEstadoCivil			= new JPanel();
		panPreguntaEstadoCivil			= new JPanel();
		
		panInternoOpinion				= new JPanel();
		panBotonesOpinion				= new JPanel();
		panPreguntaOpinion				= new JPanel();
		
		panInternoResultados            = new JPanel();
	    panConsulta                     = new JPanel();
	    
	    panInterno1                     = new JPanel();
	    panInterno2                     = new JPanel();
	    panInterno3                     = new JPanel();
	    panInterno4                     = new JPanel();
		
	    panGrafico                      = new JPanel();
	    panEstadisticasGenerales        = new JPanel();
	    panTotal                        = new JPanel();
	    
	    bdCasados                       = new DefaultCategoryDataset();
	    bdSolteros                      = new DefaultCategoryDataset();
	 //   String[] listaRangoEdad         = principal.darRangoEdades();
	    String[] listaEstados           = {"Casado/a","Soltero/a"};
	    String[] listaOpiniones       	= {"0","1","2","3","4","5","6","7","8","9","10"};
		//---------------------------------------------------//

		
		// Panel De bienvenida
		
		lblPregunta 					= new JLabel("Bienvenidos/as a nuestra encuesta");
		lblPregunta.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		lblPregunta.setForeground(new Color(22,105,101));
		

		
		panCabecera.setBackground(new Color(255,255,231));
		
		panCabecera.add(lblPregunta);
		
		Border border 					= BorderFactory.createLineBorder(new Color(22,105,101), 2);
		panCabecera.setBorder(border);
		
		btnRealizarEncuesta 			= new JButton(INICIAR_ENCUESTA);
		btnRealizarEncuesta.setActionCommand(RANGO_DE_EDAD);
		btnRealizarEncuesta.addActionListener(this);
		
		panInternoIniciarEncuesta.setLayout(new GridLayout(1,1));
		panInternoIniciarEncuesta.add(btnRealizarEncuesta);
		
		
		
		// Panel pregunta 1.
		
		lblRango 						= new JLabel("Por favor, seleccione un rango de edad");
		cbxRango                        = new JComboBox<String>(principal.darRangoEdades());
		cbxRango.addActionListener(this);
		cbxRango.setPreferredSize(new Dimension(150,0));
		
		btnSiguienteRangoDeEdad 		= new JButton(">>");
		btnSiguienteRangoDeEdad.setActionCommand(ESTADO_CIVIL);
		btnSiguienteRangoDeEdad.setPreferredSize(new Dimension(80,30));
		btnSiguienteRangoDeEdad.addActionListener(this);
		
		//---------------------------------------------------//
		panInternoRangoEdad.setLayout(new BorderLayout());
		panBotonesRangoEdad.setLayout(new BorderLayout());
		panPreguntaRangoEdad.setLayout(new BorderLayout());
		panPreguntaRangoEdad.setBorder(new EmptyBorder(0,82,0,10));//top,left,bottom,right antihorario
		
		panInternoRangoEdad.add(panBotonesRangoEdad, BorderLayout.NORTH);
		panInternoRangoEdad.add(fondoRangoEdad, BorderLayout.CENTER);
		panBotonesRangoEdad.add(new JLabel(""), BorderLayout.WEST);
		panBotonesRangoEdad.add(btnSiguienteRangoDeEdad , BorderLayout.EAST);
		panBotonesRangoEdad.add(panPreguntaRangoEdad, BorderLayout.CENTER);
		panPreguntaRangoEdad.add(lblRango, BorderLayout.CENTER);
		panPreguntaRangoEdad.add(cbxRango, BorderLayout.EAST);
		
		// Panel pregunta 2
		
		lblEstadoCivil 					= new JLabel("Su estado civil es : ");
		cbxEstadoCivil                  = new JComboBox<String>(listaEstados);
		cbxEstadoCivil.addActionListener(this);
		cbxEstadoCivil.setPreferredSize(new Dimension(150,0));
		
		btnAnteriorEstadoCivil          = new JButton("<<"); 
		btnAnteriorEstadoCivil.setActionCommand(RANGO_DE_EDAD);
		btnAnteriorEstadoCivil.addActionListener(this);
		btnAnteriorEstadoCivil.setPreferredSize(new Dimension(80,30));
		
		btnSiguienteEstadoCivil         = new JButton(">>");
		btnSiguienteEstadoCivil.setActionCommand(OPINION);
		btnSiguienteEstadoCivil.addActionListener(this);
		btnSiguienteEstadoCivil.setPreferredSize(new Dimension(80,30));
		//---------------------------------------------------//
		panInternoEstadoCivil.setLayout(new BorderLayout());
		panBotonesEstadoCivil.setLayout(new BorderLayout());
		panPreguntaEstadoCivil.setLayout(new BorderLayout());
		panPreguntaEstadoCivil.setBorder(new EmptyBorder(0,82,0,10));//top,left,bottom,right antihorario
		
		panInternoEstadoCivil.add(panBotonesEstadoCivil, BorderLayout.NORTH);
		panInternoEstadoCivil.add(fondoEstadoCivil, BorderLayout.CENTER);
		panBotonesEstadoCivil.add(btnAnteriorEstadoCivil,BorderLayout.WEST);
		panBotonesEstadoCivil.add(btnSiguienteEstadoCivil,BorderLayout.EAST);
		panBotonesEstadoCivil.add(panPreguntaEstadoCivil,BorderLayout.CENTER);
		panPreguntaEstadoCivil.add(lblEstadoCivil, BorderLayout.CENTER);
		panPreguntaEstadoCivil.add(cbxEstadoCivil,BorderLayout.EAST);
		
		// Panel pregunta 3
		
		lblOpinion                    	= new JLabel("Califique de 0 a 10 el curso: " );
		cbxOpinion              	    = new JComboBox<String>(listaOpiniones);
		cbxOpinion.addActionListener(this);
		cbxOpinion.setPreferredSize(new Dimension(150,0));
		
		btnAnteriorOpinion           	= new JButton("<<");
		btnAnteriorOpinion.setActionCommand(ESTADO_CIVIL);
		btnAnteriorOpinion.addActionListener(this);
		btnAnteriorOpinion.setPreferredSize(new Dimension(80,30));
		
		btnAgregarOpinion              = new JButton("Enviar");  
		btnAgregarOpinion.setActionCommand(AGREGAR_OPINION);
		btnAgregarOpinion.addActionListener(this);
		btnAgregarOpinion.setPreferredSize(new Dimension(80,30));
		
		//---------------------------------------------------//
		panInternoOpinion.setLayout(new BorderLayout());
		panBotonesOpinion.setLayout(new BorderLayout());
		panPreguntaOpinion.setLayout(new BorderLayout());
		panPreguntaOpinion.setBorder(new EmptyBorder(0, 78, 0, 10));
		
		panInternoOpinion.add(panBotonesOpinion, BorderLayout.NORTH);
		panInternoOpinion.add(fondoOpinion, BorderLayout.CENTER);
		panBotonesOpinion.add(btnAnteriorOpinion, BorderLayout.WEST);
		panBotonesOpinion.add(btnAgregarOpinion, BorderLayout.EAST);
		panBotonesOpinion.add(panPreguntaOpinion, BorderLayout.CENTER);
		panPreguntaOpinion.add(lblOpinion, BorderLayout.CENTER);
		panPreguntaOpinion.add(cbxOpinion, BorderLayout.EAST );
		
		
		// Panel Resultados.
		
		panInternoResultados.setLayout(new BorderLayout());
		panConsulta.setLayout(new GridLayout(2,1));
		panConsulta.setBorder(new CompoundBorder(new EmptyBorder(3,5,3,5),new TitledBorder("Consulta por sector demográfico" )));
		
		//---------------------------------------------------//
		lblConsulta 						= new JLabel("");
		lblConsulta.setFont(new Font("Comic Sans MS",Font.BOLD, 16));
		lblNumerOpiniones              		= new JLabel("Número total de opiniones:");
		lblPromedioEncuesta            		= new JLabel("Promedio total encuesta:");
		
		txtConsulta                     	= new JTextField();
		txtConsulta.setEditable(false);
		txtConsulta.setPreferredSize(new Dimension(100,0));
		
		
		txtNumerOpiniones				 	= new JTextField();
		txtNumerOpiniones.setEditable(false);
		txtNumerOpiniones.setPreferredSize(new Dimension(100,0));
		
		txtPromedioEncuesta				 	= new JTextField();
		txtPromedioEncuesta	.setEditable(false);
		txtPromedioEncuesta	.setPreferredSize(new Dimension(100,0));
		
		lblFiltroRango                   	= new JLabel("Rango de Edad");
		lblFiltroEstadoCivil             	= new JLabel("Estado Civil");
		
		btnConsulta                     	= new JButton(CONSULTAR);
		btnConsulta.setActionCommand(CONSULTAR);
		btnConsulta.addActionListener(this);
		
		btnNuevaEncuesta               		= new JButton("Responder nuevamente");
		btnNuevaEncuesta.setActionCommand(RANGO_DE_EDAD);
		btnNuevaEncuesta.addActionListener(this);
		
		cbxFiltroRango    					= new JComboBox<String>(principal.darRangoEdades());
		cbxFiltroEstadoCivil                = new JComboBox<String>(listaEstados);
		
		panInterno1.setLayout(new GridLayout(1,5,5,5));
		panInterno2.setLayout(new BorderLayout());
		
		panInterno1.add(lblFiltroRango);
		panInterno1.add(cbxFiltroRango);
		panInterno1.add(lblFiltroEstadoCivil);
		panInterno1.add(cbxFiltroEstadoCivil);
		panInterno1.add(btnConsulta);
		
		panInterno2.add(lblConsulta, BorderLayout.CENTER);
		panInterno2.add(txtConsulta, BorderLayout.EAST);
		
		panConsulta.add(panInterno1);
		panConsulta.add(panInterno2);
		
		JFreeChart graficosCasados = crearGrafico( "Calificación casados", bdCasados);
		JFreeChart graficosSolteros= crearGrafico("Calificación solteros", bdSolteros);
		
		panGrafico.setLayout( new GridLayout( 1, 2 ) );
		panCasados                        	= new ChartPanel(graficosCasados);
		panCasados.setBorder(new EmptyBorder(5,5,5,5)); //top,left,bottom,right antihorario
		panGrafico.add(panCasados);
		
		panSolteros                         = new ChartPanel(graficosSolteros);
		panSolteros.setBorder(new EmptyBorder(5,5,5,5)); //top,left,bottom,right antihorario
		panGrafico.add(panSolteros);
		
		
		panInterno3.setLayout(new BorderLayout());
		panInterno3.add(lblNumerOpiniones, BorderLayout.CENTER);
		panInterno3.add(txtNumerOpiniones, BorderLayout.EAST);
		
		panTotal.setLayout(new GridLayout(2,1));
		panTotal.setBorder(new EmptyBorder(5,1,1,1));//top,left,bottom,right antihorario
		panTotal.add(panInterno3);
		
		
		panInterno4.setLayout(new BorderLayout());
		panInterno4.add(lblPromedioEncuesta, BorderLayout.CENTER);
		panInterno4.add(txtPromedioEncuesta, BorderLayout.EAST);
		panTotal.add(panInterno4);
		
		panEstadisticasGenerales.setLayout(new BorderLayout());
		panEstadisticasGenerales.add(panTotal, BorderLayout.NORTH);
		panEstadisticasGenerales.add(panGrafico, BorderLayout.CENTER);
		panEstadisticasGenerales.setBorder( new CompoundBorder( new EmptyBorder( 3, 5, 3, 5 ), new TitledBorder( "Estadísticas generales" ) ) );
		
		
		panInternoResultados.add(panConsulta, BorderLayout.NORTH);
		panInternoResultados.add(panEstadisticasGenerales, BorderLayout.CENTER);
		panInternoResultados.add(btnNuevaEncuesta, BorderLayout.SOUTH);
		
		
		// Ingreso de paneles
		
		
		panPregunta.add(panInternoIniciarEncuesta, INICIAR_ENCUESTA);
		panPregunta.add( panInternoRangoEdad, RANGO_DE_EDAD );
		panPregunta.add( panInternoEstadoCivil, ESTADO_CIVIL );
		panPregunta.add( panInternoOpinion, OPINION );
		panPregunta.add( panInternoResultados, VER_RESULTADOS);

        add( panCabecera, BorderLayout.NORTH );
        add( panPregunta, BorderLayout.CENTER );
		

	}

	// --------- M É T O D O S ----------//
    /**
     * Actualiza la información
     * @param pEncuesta Encuesta de la cual se va a mostrar la información. pEncuesta != null.
     */
	public void actualizar(Encuesta pEncuesta) {
		txtNumerOpiniones.setText("" + pEncuesta.getNumeroTotalOpiniones());
		txtPromedioEncuesta.setText(principal.formatearValoresReales(pEncuesta.getPromedio()));
		
		bdCasados.setValue(pEncuesta.getResultadoJovenesCasados(),  "0-17 años", " "); //setValue(el valor,la clave de la fila, la clave de la columna)
		bdCasados.setValue(pEncuesta.getResultadoAdultosCasados(), "18-54 años", "" );
		bdCasados.setValue(pEncuesta.getResultadoMayoresCasados(), "55 o más", "");
		
		bdSolteros.setValue(pEncuesta.getResultadoJovenesSolteros(), "0-17 años", " ");
		bdSolteros.setValue(pEncuesta.getResultadoAdultosSolteros(),"18-54 años", "");
		bdSolteros.setValue(pEncuesta.getResultadoMayoresSolteros(), "55 o más", "");
		
		
	        
	  

	}
	//---------------------------------------------------//
    /**
     * Muestra resultados de la encuesta en una ventana.
     * @param pResultado Resultado parcial de la encuesta según rango y estado Civil. pResultado>0.
     * @param pRango Edad de las personas para este grupo de resultados.
     * @param pEsCasado Estados civil de las personas para este grupo de resultados.
     */
	private void getResultados(double pResultado)
	{
		DecimalFormat df = (DecimalFormat)NumberFormat.getInstance();
		df.applyPattern("###.##");
		
		if(!Double.isNaN(pResultado))
		{
			lblConsulta.setText( "Los participantes le dieron una calificación promedio de : " );
			txtConsulta.setText(df.format(pResultado));
			txtConsulta.setVisible(true);
		}
		else
		{
			lblConsulta.setText( "Los participantes aún no han calificado el curso"  );
			txtConsulta.setText(" ");
			txtConsulta.setVisible(false);
			
		}
		
	}
	//---------------------------------------------------//
    /**
     * Crea y configura los atributos de la gráfica en barras.
     * @param pTitulo Título de la gráfica.
     * @return pDatos Datos que se dibujan en la gráfica.
     */
	private static JFreeChart crearGrafico(String pTitulo, DefaultCategoryDataset pDato)
	{
		/* ChartFactory.createBarChart
		 *  Parámetro 1: El título del gráfico
			Parámetro 2: Etiqueta o nombre del eje horizontal
			Parámetro 3: Etiqueta o nombre del eje vertical.
			Parámetro 4: El modelo de datos
			Parámetro 5: Se le agrega PlotOrientation y se decide si se desea que el gráfico sea vertical (PlotOrientation.VERTICAL) u horizontal (PlotOrientation.HORIZONTAL).
			Parámetro 6: un valor True o False. Si se coloca True se colocará una etiqueta debajo del gráfico que indicará que grupo de datos representa cada color. Por ejemplo, los datos en rojo son del negocio 1, los datos en azul son los del negocio 2, etc…
			Parámetro 7: Un valor True o False. Si se le coloca True, cuando se le pase el ratón por encima aparecerá una pequeña etiqueta que indica el valor que se halla graficado.
			Parámetro 8: Un valor True o False. Es para agregar urls. Se deja casi exclusivamente para diseños orientados a la web. Nosotros lo dejaremos en False.
			*/

		JFreeChart chart 				= ChartFactory.createBarChart(pTitulo, "Sector demográfico", "Promedio", pDato, PlotOrientation.VERTICAL,true, true, false);
		CategoryPlot plot 				= chart.getCategoryPlot();
		NumberAxis rangeAxis 			= (NumberAxis)plot.getRangeAxis();
		BarRenderer renderer 			= (BarRenderer)plot.getRenderer();
		CategoryAxis domainAxis 		= (CategoryAxis)plot.getDomainAxis();
		
		
		chart.setBackgroundPaint(Color.WHITE);
		plot.setBackgroundPaint(Color.LIGHT_GRAY);
		plot.setDomainGridlinePaint(Color.WHITE);
		plot.setRangeGridlinePaint(Color.WHITE);
		
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		renderer.setDrawBarOutline(false);
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.createDownRotationLabelPositions(Math.PI / 6.0));
		
		
		return chart;
	}
	//---------------------------------------------------//
    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Evento de click sobre un botón. pEvento != null.
     */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		try {
			CardLayout layout 	= (CardLayout)(panPregunta.getLayout());
			String command 		= e.getActionCommand();

			switch (command)
			{
			case CONSULTAR:
			
				boolean esCasado 	= (cbxFiltroEstadoCivil.getSelectedIndex()==0 ? true : false);// OPERADOR TERNARIO
				int rango 			= cbxFiltroRango.getSelectedIndex() + 1;
				double resultado    = principal.getResultadosParciales(rango, esCasado);
				getResultados(resultado); 
		
				
				break;
			case AGREGAR_OPINION:
				int opinion 				= cbxOpinion.getSelectedIndex();
				int rangoOpinion           	= cbxRango.getSelectedIndex() + 1;  
				boolean esCasadoOpinion 	= (cbxEstadoCivil.getSelectedIndex()==0 ? true : false);// OPERADOR TERNARIO   
		        getToolkit().beep();
		        principal.agregarOpiniones(rangoOpinion, esCasadoOpinion, opinion);
		        principal.actualizar();
		        
		        cbxOpinion.setSelectedIndex(0);
		        cbxEstadoCivil.setSelectedIndex(0);
		        cbxRango.setSelectedIndex(0);
		        cbxFiltroEstadoCivil.setSelectedIndex(0);
		        cbxFiltroRango.setSelectedIndex(0);
		        lblConsulta.setText("");
		        txtConsulta.setText("");
		        txtConsulta.setVisible(false);
		        layout.show(panPregunta,VER_RESULTADOS);
				break;
			default :
				layout.show(panPregunta, command);

			}
		} catch (Exception pEvent) {
			pEvent.printStackTrace();
		}

	}

}
