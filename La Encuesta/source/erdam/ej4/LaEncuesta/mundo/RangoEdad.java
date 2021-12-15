package erdam.ej4.LaEncuesta.mundo;
/**
 * Clase que representa un rango de edad para la encuesta.
 */
public class RangoEdad {
	
	//------- A T R I B U T O S -------//
	private int edadMinima;         //Edad mínima para este rango de la población.
	private int edadMaxima;         //Edad máxima para este rango de la población.
	private int numeroDeSolteros;   //Cantidad de opiniones hechas por gente soltera en este rango de edad.
	private int numeroDeCasados;    //Cantidad de opiniones hechas por gente casada en este rango de edad.
	private int totalOpcionSolteros;//Suma de las opiniones hechas por gente soltera en este rango de edad.
	private int totalOpcionCasados; //Suma de las opiniones hechas por gente casada en este rango de edad.
	//----- C O N S T R U C T O R  -----//
    /**
     * Construye el rango de encuestas.<br>
     * <b>post: </b> La edad mínima y edad máxima fueron inicializadas con los valores dados por parámetro.<br>
     * El número de casados, número de solteros, el total de opiniones de solteros y el total de opiniones de casados fueron inicializados en 0.
     * @param pEdadMinima Edad mínima para este rango de la población. pEdadMinima>0.
     * @param pEdadMaxima Edad máxima para este rango de la población. pEdadMaxima>0 && pEdadMaxima>pEdadMinima.
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
	//--------- M É T O D O S ----------//

    /**
     * Retorna el número de personas casadas que respondieron la encuesta en este rango de edad.
     * @return Número de personas casadas que respondieron la encuesta.
     */
	public int getNumeroDeCasados()
	{
		return numeroDeCasados;
	}
	//---------------------------------------------------// 
    /**
     * Retorna el número de personas solteras que respondieron la encuesta en este rango de edad.
     * @return Número de personas solteras que respondieron la encuesta en este rango de edad.
     */
	public int getNumeroDeSolteros()
	{
		return numeroDeSolteros;
	}
	//---------------------------------------------------// 
    /**
     * Retorna el número total de opiniones de los encuestados casados en este rango de edad.
     * @return Número total de opiniones de los encuestados casados en este rango de edad.
     */
	public int getTotalOpinionesCasados()
	{
		return totalOpcionCasados;
	}

	//---------------------------------------------------//
    /**
     * Retorna el número total de opiniones de los encuestados solteros en este rango de edad.
     * @return Número total de opiniones de los encuestados solteros en este rango de edad.
     */
	public int getTotalOpinionesSolteros()
	{
		return totalOpcionSolteros;
	}
	//---------------------------------------------------//
	 
    /**
     * Retorna el número de opiniones hechas para este rango.
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
	 * @return Promedio de opinión del curso en la encuesta en este rango de edad de la clase considerada sólo los solteros.
	 */
	public double getPromedioSolteros()
	{
		double solteros = (double)totalOpcionSolteros / numeroDeSolteros;
		
		return solteros;
	}
	//---------------------------------------------------// 
    /**
     * Retorna el promedio de las opiniones de la gente casada en este rango de edad. <br>
     * @return Promedio de opinión del curso en la encuesta en este rango de edad de la clase considerando sólo los casados.
     */
	public double getPromedioCasados()
	{
		double casados =(double) totalOpcionCasados / numeroDeCasados;
		
		return casados;
	}
	//---------------------------------------------------//  
    /**
     * Agrega una opinión de una persona soltera para este rango de edad. <br>
     * <b>post: </b> Se agregó una nueva opinión.
     * @param pOpinion Opinion del encuestado. pOpinion >= 0 && pOpinion < 11.
     */
	public void agregarOpinionesSoltero(int pOpinion) 
	{
		numeroDeSolteros     +=1;
		totalOpcionSolteros  += pOpinion;
	}
	//---------------------------------------------------// 
    /**
     * Agrega una opinión de una persona casada para este rango de la población. <br>
     * <b>post: </b> Se agregó una nueva opinión.
     * @param pOpinion Opinion del encuestado. pOpinion >= 0 && pOpinion < 11.
     */
	public void agregarOpinionesCasados(int pOpinion) 
	{
		numeroDeCasados     +=1;
		totalOpcionCasados  +=pOpinion;
	}
	//---------------------------------------------------// 
    /**
     * Retorna una cadena de texto con la edad mínima y edad máxima.
     * @return Cadena de carácteres con el rango de edades para este grupo.
     */
    public String darRangoDeEdad( )
    {
        return edadMinima + "-" + ( edadMaxima - 1 );
    }
}
