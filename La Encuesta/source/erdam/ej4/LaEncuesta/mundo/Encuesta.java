package erdam.ej4.LaEncuesta.mundo;
/**
 * Clase que representa la encuesta del curso.
 */
public class Encuesta {
	//------- A T R I B U T O S -------//
	private RangoEdad rangoEdadJoven;   //Modela el rango de edad: 0 < años <  18.
	private RangoEdad rangoEdadAdulto;  //Modela el rango de edad: 18 < años < = 55.
	private RangoEdad rangoEdadMayores; // Modela el rango de edad: 55 < años .
	//----- C O N S T R U C T O R  -----//
    /**
     * Inicializa la encuesta. <b>post: </b> Se inicializaron los tres rangos de la encuesta.<br>
     * Rango jóvenes: 0 < años <= 17<br>
     * Rango adultos: 18 <= años <= 54<br>
     * Rango mayores: 55 <= años <= 154<br>
     */
	public Encuesta()
	{
		rangoEdadJoven    	= new RangoEdad(0,  18);
		rangoEdadAdulto  	= new RangoEdad(18, 55);
		rangoEdadMayores   	= new RangoEdad(55, 155);
	}
	
	

	//--------- M É T O D O S ----------//

	/**
     * Retorna el rango de edades para el primer rango de la encuesta.
     * @return Cadena con el rango de edades para el Joven en la encuesta.
     */
    public String darRangoEdadJoven( )
    {
        return rangoEdadJoven.darRangoDeEdad( );
    }
  //---------------------------------------------------// 

    /**
     * Retorna el rango de edades para el segundo rango de la encuesta.
     * @return Cadena con el rango de edades para el  Adulto en la encuesta.
     */
    public String darRangoEdadAdulto( )
    {
        return rangoEdadAdulto.darRangoDeEdad( );
    }
  //---------------------------------------------------// 
    /**
     * Retorna el rango de edades para el tercer rango de la encuesta.
     * @return Cadena con el rango de edades para el Mayor la encuesta.
     */
    public String darRangoEdadMayores( )
    {
        return rangoEdadMayores.darRangoDeEdad( );
    }
  //---------------------------------------------------// 
    /**
     * Retorna el promedio de opiniones de gente entre 0 y 17 años que sea casada.
     * @return Promedio de opiniones de personas casadas entre 0 y 17 años.
     */
	public double getResultadoJovenesCasados()
	{
		return rangoEdadJoven.getPromedioCasados();
	}
	//---------------------------------------------------// 
    /**
     * Retorna el promedio de opiniones de gente entre 18 y 54 años que sea casada.
     * @return Promedio de opiniones de personas casadas entre 18 y 55 años.
     */
	public double getResultadoAdultosCasados()
	{
		return rangoEdadAdulto.getPromedioCasados();
	}
	//---------------------------------------------------// 
    /**
     * Retorna el promedio de opiniones de gente entre 55 y 149 años que sea casada.
     * @return Promedio de opiniones de personas casadas entre 55 y 149 años.
     */
	public double getResultadoMayoresCasados()
	{
		return rangoEdadMayores.getPromedioCasados();
	}
	//---------------------------------------------------// 
    /**
     * Retorna el promedio de opiniones de gente entre 0 y 17 años que sea soltera.
     * @return Promedio de opiniones de personas solteras entre 0 y 17 años.
     */
	public double getResultadoJovenesSolteros()
	{
		return rangoEdadJoven.getPromedioSolteros();
	}
	//---------------------------------------------------// 
    /**
     * Retorna el promedio de opiniones de gente entre 18 y 54 años que sea casada.
     * @return Promedio de opiniones de personas casadas entre 18 y 55 años.
     */
	public double getResultadoAdultosSolteros()
	{
		return rangoEdadAdulto.getPromedioSolteros();
	}
	//---------------------------------------------------// 
    /**
     * Retorna el promedio de opiniones de gente entre 55 y 149 años que sea casada.
     * @return Promedio de opiniones de personas casadas entre 55 y 149 años.
     */
	public double getResultadoMayoresSolteros()
	{
		return rangoEdadMayores.getPromedioSolteros();
	}
	//---------------------------------------------------// 
    /**
     * Retorna el número total de opiniones hechas en la encuesta.
     * @return Número total de opiniones.
     */
	public int getNumeroTotalOpiniones()
	{
		return (int)(rangoEdadJoven.getNumeroDeOpiniones() + 
					rangoEdadAdulto.getNumeroDeOpiniones() +
					rangoEdadMayores.getNumeroDeOpiniones()
					);
	}
	//---------------------------------------------------// 
    /**
     * Retorna el número total de casados que han contestado la encuesta.
     * @return Número total de opiniones de personas casadas.
     */
	public int getNumeroTotalOpinionesCasados()
	{
		return (int)(rangoEdadJoven.getNumeroDeCasados() + 
					rangoEdadMayores.getNumeroDeCasados() +
					rangoEdadMayores.getNumeroDeCasados()
					);
	}
	//---------------------------------------------------// 
    /**
     * Retorna el número total de solteros que han contestado la encuesta.
     * @return Número total de opinions de personas solteras.
     */
	public int getNumeroTotalOpinionesSolteros()
	{
		return (int)(rangoEdadJoven.getNumeroDeSolteros() + 
					rangoEdadMayores.getNumeroDeSolteros() + 
					rangoEdadMayores.getNumeroDeSolteros()
					);
	}
	//---------------------------------------------------//
    /**
     * Retorna el promedio de las respuestas de la encuesta. <br>
     * @return Promedio de las respuestas de la encuesta.
     */
	public double getPromedio()
	{
		double totalDeEncuestas = (double)(rangoEdadJoven.getTotalOpiniones() + 
											rangoEdadAdulto.getTotalOpiniones() + 
											rangoEdadMayores.getTotalOpiniones()
											); 
		
		return (totalDeEncuestas/getNumeroTotalOpiniones());
	}
	//---------------------------------------------------//
    /**
     * Retorna el promedio de las respuestas de personas casadas. <br>
     * @return Promedio de las respuestas de personas casadas.
     */
	public double getPromedioCasados()
	{
		double totalDeENcuestaCasados = (double)(rangoEdadJoven.getTotalOpinionesCasados() + 
												rangoEdadAdulto.getTotalOpinionesCasados() + 
												rangoEdadMayores.getTotalOpinionesCasados()
												); 
		return (totalDeENcuestaCasados/getNumeroTotalOpinionesCasados());
	}
	//---------------------------------------------------//
    /**
     * Retorna el promedio de las respuestas de personas solteras. <br>
     * @return Promedio de las respuestas de personas solteras.
     */
	public double getPromedioSolteros()
	{
		double totalDeENcuestaSolteros = (double)(rangoEdadJoven.getTotalOpinionesSolteros() + 
												rangoEdadAdulto.getTotalOpinionesSolteros()  + 
												rangoEdadMayores.getTotalOpinionesSolteros() 
												); 
		return (totalDeENcuestaSolteros/getNumeroTotalOpinionesSolteros());
	}

    /**
     * Agrega una opinión de una personas soltera entre 0 y 17 años. <br>
     * <b>post: </b>Se agregó la opinión a la encuesta.<br>
     * @param pOpinion Opinión que se va a agregar a la encuesta. pOpinion>0 && pOpinion<=10.
     */
	public void agregarOpinionJovenSoltero(int pOpinion)
	{
		rangoEdadJoven.agregarOpinionesSoltero(pOpinion);
		
	}
	//---------------------------------------------------//
    /**
     * Agrega una opinión de una personas soltera entre 18 y 55 años. <br>
     * <b>post: </b>Se agregó la opinión a la encuesta.<br>
     * @param pOpinion Opinión que se va a agregar a la encuesta. pOpinion>0 && pOpinion<=10.
     */
	public void agregarOpinionAdultoSoltero(int pOpinion)
	{
		rangoEdadAdulto.agregarOpinionesSoltero(pOpinion);
		
	}
	//---------------------------------------------------//
    /**
     * Agrega una opinión de una personas soltera entre 55 y 150 años. <br>
     * <b>post: </b>Se agregó la opinión a la encuesta.<br>
     * @param pOpinion Opinión que se va a agregar a la encuesta. pOpinion>0 && pOpinion<=10.
     */
	public void agregarOpinionMayorSoltero(int pOpinion)
	{
		rangoEdadMayores.agregarOpinionesSoltero(pOpinion);
		
	}
	//---------------------------------------------------//
    /**
     * Agrega una opinión de una personas casada entre 0 y 18 años. <br>
     * <b>post: </b>Se agregó la opinión a la encuesta.<br>
     * @param pOpinion Opinión que se va a agregar a la encuesta. pOpinion>0 && pOpinion<=10.
     */
	public void agregarOpinionJovenCasados(int pOpinion)
	{
		rangoEdadJoven.agregarOpinionesCasados(pOpinion);
		
	}
	//---------------------------------------------------//
	/** 
	 * Agrega una opinión de una persona casada entre 18 y 55 años. <br>
	 * <b>post: </b>se agregó la opinión a la encuesta.<br>
	 * @param pOpinion Opinión que se va a agregar a la encuesta. pOpinion>0 && pOninion<=10.
	 */
	public void agregarOpinionAdultoCasados(int pOpinion)
	{
		rangoEdadAdulto.agregarOpinionesCasados(pOpinion);
		
	}
	//---------------------------------------------------//
	/** 
	 * Agrega una opinión de una persona casada entre  55 y 150 años. <br>
	 * <b>post: </b>se agregó la opinión a la encuesta.<br>
	 * @param pOpinion Opinión que se va a agregar a la encuesta. pOpinion>0 && pOninion<=10.
	 */
	public void agregarOpinionMayorCasados(int pOpinion)
	{
		rangoEdadMayores.agregarOpinionesCasados(pOpinion);
		
	}
	//---------------------------------------------------//
}

