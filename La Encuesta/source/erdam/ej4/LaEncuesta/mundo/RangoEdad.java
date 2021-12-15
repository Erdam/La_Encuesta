package erdam.ej4.LaEncuesta.mundo;
/**
 * Clase que representa un rango de edad para la encuesta.
 */
public class RangoEdad {
	
	//------- A T R I B U T O S -------//
	private int edadMinima;         //Edad m�nima para este rango de la poblaci�n.
	private int edadMaxima;         //Edad m�xima para este rango de la poblaci�n.
	private int numeroDeSolteros;   //Cantidad de opiniones hechas por gente soltera en este rango de edad.
	private int numeroDeCasados;    //Cantidad de opiniones hechas por gente casada en este rango de edad.
	private int totalOpcionSolteros;//Suma de las opiniones hechas por gente soltera en este rango de edad.
	private int totalOpcionCasados; //Suma de las opiniones hechas por gente casada en este rango de edad.
	//----- C O N S T R U C T O R  -----//
    /**
     * Construye el rango de encuestas.<br>
     * <b>post: </b> La edad m�nima y edad m�xima fueron inicializadas con los valores dados por par�metro.<br>
     * El n�mero de casados, n�mero de solteros, el total de opiniones de solteros y el total de opiniones de casados fueron inicializados en 0.
     * @param pEdadMinima Edad m�nima para este rango de la poblaci�n. pEdadMinima>0.
     * @param pEdadMaxima Edad m�xima para este rango de la poblaci�n. pEdadMaxima>0 && pEdadMaxima>pEdadMinima.
     */
	public RangoEdad(int pEdadMinima, int pEdadMaxima)
	{
		edadMinima 				= pEdadMinima;
		edadMaxima 				= pEdadMaxima;
		numeroDeSolteros 		= 0;
		numeroDeCasados 		= 0;
		totalOpcionSolteros 	= 0;
		totalOpcionCasados 		= 0;
		
	}
	//--------- M � T O D O S ----------//

    /**
     * Retorna el n�mero de personas casadas que respondieron la encuesta en este rango de edad.
     * @return N�mero de personas casadas que respondieron la encuesta.
     */
	public int getNumeroDeCasados()
	{
		return numeroDeCasados;
	}
	//---------------------------------------------------// 
    /**
     * Retorna el n�mero de personas solteras que respondieron la encuesta en este rango de edad.
     * @return N�mero de personas solteras que respondieron la encuesta en este rango de edad.
     */
	public int getNumeroDeSolteros()
	{
		return numeroDeSolteros;
	}
	//---------------------------------------------------// 
    /**
     * Retorna el n�mero total de opiniones de los encuestados casados en este rango de edad.
     * @return N�mero total de opiniones de los encuestados casados en este rango de edad.
     */
	public int getTotalOpinionesCasados()
	{
		return totalOpcionCasados;
	}

	//---------------------------------------------------//
    /**
     * Retorna el n�mero total de opiniones de los encuestados solteros en este rango de edad.
     * @return N�mero total de opiniones de los encuestados solteros en este rango de edad.
     */
	public int getTotalOpinionesSolteros()
	{
		return totalOpcionSolteros;
	}
	//---------------------------------------------------//
	 
    /**
     * Retorna el n�mero de opiniones hechas para este rango.
     * @return Cantidad total de opiniones.
     */
	public int getNumeroDeOpiniones()
	{
		int opiniones =(int) numeroDeCasados + numeroDeSolteros;
		
		return opiniones;
	}
	//---------------------------------------------------//
    /**
     * Retorna la suma de opiniones hechas para este rango.
     * @return Total de opiniones del curso.
     */
	public int getTotalOpiniones()
	{
		int opiniones =(int) totalOpcionCasados + totalOpcionSolteros;
		
		return opiniones;
	}

	//---------------------------------------------------//
	/**
	 * Retorna el promedio de las opiniones de la gente soltera en este rango de edad. <br>
	 * @return Promedio de opini�n del curso en la encuesta en este rango de edad de la clase considerada s�lo los solteros.
	 */
	public double getPromedioSolteros()
	{
		double solteros = (double)totalOpcionSolteros / numeroDeSolteros;
		
		return solteros;
	}
	//---------------------------------------------------// 
    /**
     * Retorna el promedio de las opiniones de la gente casada en este rango de edad. <br>
     * @return Promedio de opini�n del curso en la encuesta en este rango de edad de la clase considerando s�lo los casados.
     */
	public double getPromedioCasados()
	{
		double casados =(double) totalOpcionCasados / numeroDeCasados;
		
		return casados;
	}
	//---------------------------------------------------//  
    /**
     * Agrega una opini�n de una persona soltera para este rango de edad. <br>
     * <b>post: </b> Se agreg� una nueva opini�n.
     * @param pOpinion Opinion del encuestado. pOpinion >= 0 && pOpinion < 11.
     */
	public void agregarOpinionesSoltero(int pOpinion) 
	{
		numeroDeSolteros     +=1;
		totalOpcionSolteros  += pOpinion;
	}
	//---------------------------------------------------// 
    /**
     * Agrega una opini�n de una persona casada para este rango de la poblaci�n. <br>
     * <b>post: </b> Se agreg� una nueva opini�n.
     * @param pOpinion Opinion del encuestado. pOpinion >= 0 && pOpinion < 11.
     */
	public void agregarOpinionesCasados(int pOpinion) 
	{
		numeroDeCasados     +=1;
		totalOpcionCasados  +=pOpinion;
	}
	//---------------------------------------------------// 
    /**
     * Retorna una cadena de texto con la edad m�nima y edad m�xima.
     * @return Cadena de car�cteres con el rango de edades para este grupo.
     */
    public String darRangoDeEdad( )
    {
        return edadMinima + "-" + ( edadMaxima - 1 );
    }
}
