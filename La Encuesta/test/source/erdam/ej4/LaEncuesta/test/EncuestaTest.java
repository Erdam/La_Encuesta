package erdam.ej4.LaEncuesta.test;

import org.junit.Test;

import erdam.ej4.LaEncuesta.mundo.Encuesta;
import junit.framework.TestCase;

public class EncuestaTest extends TestCase{
	//------- A T R I B U T O S -------//
	private Encuesta encuesta;
	//--------- E S C E N A R I O S ----------//
    /**
     * Escenario 1: Crea una encuesta.
     */
	private void setupEscenario1()
	{
		encuesta = new Encuesta();
		
	}
    /**
     * Escenario 1: Crea una encuesta.
     */
	private void setupEscenario2()
	{
		setupEscenario1();
		encuesta.agregarOpinionJovenCasados(8);
        encuesta.agregarOpinionAdultoCasados( 6 );
        encuesta.agregarOpinionMayorCasados(7);
        
		encuesta.agregarOpinionJovenSoltero(8);
        encuesta.agregarOpinionAdultoSoltero(9);
        encuesta.agregarOpinionMayorSoltero(4);

	}
	//---------------------------------------------------//
	//--------- M É T O D O S  D E  P R U E B A ----------//
    /**
     * Prueba 1: Método que se encarga de verificar el método agregarOpinionRangoEdadJovenesCasado. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarOpinionRangoEdadJovenesCasado<br>
     * darResultadosJovenesCasados<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se agregan varias opiniones de casados al rango de edad jóvenes de la encuesta.
     */
    @Test
    public void testAgregarOpinionRangoEdadJovenesCasado( )
    {
        setupEscenario1( );

        encuesta.agregarOpinionJovenCasados( 8 );
        encuesta.agregarOpinionJovenCasados( 10 );
        encuesta.agregarOpinionJovenCasados( 5 );
        encuesta.agregarOpinionJovenCasados( 3 );

        double promedioEncuesta = ( double ) ( 8 + 10 + 5 + 3 ) / 4;

        assertEquals( "No se están agregando bien las opiniones del rango 1", promedioEncuesta, encuesta.getResultadoJovenesCasados());

    }
	//---------------------------------------------------//
    
    /**
     * Prueba 2: Método que se encarga de verificar el método agregarOpinionRangoEdadAdultosCasado. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarOpinionRangoEdadAdultosCasado<br>
     * darResultadosAdultosCasados<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se agregan varias opiniones de casados al rango de edad adultos de la encuesta.
     */
    @Test
    public void testAgregarOpinionRangoEdadAdultosCasado( )
    {
        setupEscenario1( );
        encuesta.agregarOpinionAdultoCasados(6);
        encuesta.agregarOpinionAdultoCasados( 5 );
        encuesta.agregarOpinionAdultoCasados( 4 );
        encuesta.agregarOpinionAdultoCasados( 2 );
        encuesta.agregarOpinionAdultoCasados( 3 );
        encuesta.agregarOpinionAdultoCasados( 1 );
        encuesta.agregarOpinionAdultoCasados( 7 );

        double promedioEncuesta = ( double ) ( 6 + 5 + 4 + 2 + 3 + 1 + 7 ) / 7;

        assertEquals( "No se están agregando bien las opiniones del rango 2", promedioEncuesta, encuesta.getResultadoAdultosCasados());
    }
    
	//---------------------------------------------------//
    
    /**
     * Prueba 3: Método que se encarga de verificar el método agregarOpinionRangoEdadMayoresCasado. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarOpinionMayoresCasado<br>
     * darResultadosMayoresCasados<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se agregan varias opiniones de casados al rango de edad mayores de la encuesta.
     */
    @Test
    public void testAgregarOpinionRangoEdadMayoresCasado( )
    {
        setupEscenario1( );

        encuesta.agregarOpinionMayorCasados( 2 );
        encuesta.agregarOpinionMayorCasados( 3 );
        encuesta.agregarOpinionMayorCasados( 7 );
        encuesta.agregarOpinionMayorCasados( 9 );
        encuesta.agregarOpinionMayorCasados( 10 );
        encuesta.agregarOpinionMayorCasados( 2 );
        encuesta.agregarOpinionMayorCasados( 4 );
        encuesta.agregarOpinionMayorCasados( 4 );
        encuesta.agregarOpinionMayorCasados( 4 );

        double promedioEncuesta = ( double ) ( 2 + 3 + 7 + 9 + 10 + 2 + 4 + 4 + 4 ) / 9;

        assertEquals( "No se están agregando bien las opiniones del rango 3", promedioEncuesta, encuesta.getResultadoMayoresCasados());
    }
    
	//---------------------------------------------------//
    /**
     * Prueba 4: Método que se encarga de verificar el método agregarOpinionRangoEdadJovenesSoltero. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarOpinionRangoEdadJovenesSoltero<br>
     * darResultadosJovenesSolteros<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se agregan varias opiniones de soltero al rango de edad jovenes de la encuesta.
     */
    @Test
    public void testAgregarOpinionRangoEdadJovenesSoltero( )
    {
        setupEscenario1( );

        encuesta.agregarOpinionJovenSoltero( 10 );
        encuesta.agregarOpinionJovenSoltero( 10 );
        encuesta.agregarOpinionJovenSoltero( 4 );
        encuesta.agregarOpinionJovenSoltero( 6 );
        encuesta.agregarOpinionJovenSoltero( 7 );

        double promedioEncuesta = ( double ) ( 10 + 10 + 4 + 6 + 7 ) / 5;

        assertEquals( "No se están agregando bien las opiniones del rango 1", promedioEncuesta, encuesta.getResultadoJovenesSolteros() );

    }
	//---------------------------------------------------//
    /**
     * Prueba 5: Método que se encarga de verificar el método agregarOpinionRangoEdadAdultosSoltero. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarOpinionRangoEdadAdultosSoltero<br>
     * darResultadosAdultosSolteros<br>
     * <b> Caso de prueba: </b> <br>
     * 1. Se agregam varias opiniones de soltero al rango de edad adultos de la encuesta.
     */
    @Test
    public void testAgregarOpinionRangoEdadAdultosSoltero( )
    {
        setupEscenario1( );
    
        encuesta.agregarOpinionAdultoSoltero( 1 );
        encuesta.agregarOpinionAdultoSoltero( 2 );
        encuesta.agregarOpinionAdultoSoltero( 2 );
        encuesta.agregarOpinionAdultoSoltero( 5 );
        encuesta.agregarOpinionAdultoSoltero( 5 );

        double promedioEncuesta = ( double ) ( 1 + 2 + 2 + 5 + 5 ) / 5;

        assertEquals( "No se están agregando bien las opiniones del rango 2", promedioEncuesta, encuesta.getResultadoAdultosSolteros() );
    }

	//---------------------------------------------------//
    /**
     * Prueba 6: Método que se encarga de verificar el método agregarOpinionRangoEdadMayoresSoltero. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarOpinionRangoEdadMayoresSoltero<br>
     * darResultadosMayoresSolteros<br>
     * <b> Casos de prueba: </b> <br>
     * Se agregan varias opiniones de soltero al rango de edad mayores de la encuesta.
     */
    @Test
    public void testAgregarOpinionRangoEdadMayoresSoltero( )
    {
        setupEscenario1( );

        encuesta.agregarOpinionMayorSoltero( 4 );
        encuesta.agregarOpinionMayorSoltero( 5 );
        encuesta.agregarOpinionMayorSoltero( 9 );
        encuesta.agregarOpinionMayorSoltero( 8 );
        encuesta.agregarOpinionMayorSoltero( 8 );
        encuesta.agregarOpinionMayorSoltero( 2 );
        encuesta.agregarOpinionMayorSoltero( 2 );

        double promedioEncuesta = ( double ) ( 4 + 5 + 9 + 8 + 8 + 2 + 2 ) / 7;

        assertEquals( "No se están agregando bien las opiniones del rango 3", promedioEncuesta, encuesta.getResultadoMayoresSolteros() );
    }

	//---------------------------------------------------//
    /**
     * Prueba 7: Método que se encarga de verificar el método darPromedio. <br>
     * <b> Métodos a probar: </b> <br>
     * darPromedio<br>
     * darResultadosJovenesCasados<br>
     * darResultadosJovenesSolteros<br>
     * darResultadosAdultosCasados<br>
     * darResultadosAdultosSolteros<br>
     * darResultadosMayoresCasados<br>
     * darResultadosMayoresSolteros<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se calcula el promedio de las opiniones de la encuesta.
     */
    @Test
    public void testDarPromedio( )
    {
        setupEscenario2( );

        double totalPromedios;
        double promedioEncuesta;

        totalPromedios = encuesta.getResultadoJovenesCasados() +
        				 encuesta.getResultadoJovenesSolteros()  +
        				 encuesta.getResultadoAdultosCasados() +
        				 encuesta.getResultadoAdultosSolteros() +
        				 encuesta.getResultadoMayoresCasados() + 
        				 encuesta.getResultadoMayoresSolteros();

        promedioEncuesta = totalPromedios / 6;

        assertEquals( "No se está calculando bien el promedio total de la encuesta", encuesta.getPromedio(), promedioEncuesta);
    }
	//---------------------------------------------------//
    /**
     * Prueba 8: Método que se encarga de verificar el método darPromedioCasados. <br>
     * <b> Métodos a probar: </b> <br>
     * darPromedioCasados<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se calcula el promedio de las opiniones de casados de la encuesta.
     */
    @Test
    public void testDarPromedioCasados( )
    {
        setupEscenario2( );

        double totalPromedios;
        double promedioEncuesta;
        totalPromedios = 8 + 6 + 7;
        promedioEncuesta = totalPromedios / 3;

        assertEquals( "No se está calculando bien el promedio total de casados de la encuesta", promedioEncuesta, encuesta.getPromedioCasados());
    }

	//---------------------------------------------------//
    /**
     * Prueba 9: Método que se encarga de verificar el método darNumeroTotalOpiniones.<br>
     * <b> Métodos a probar: </b> <br>
     * darNumeroTotalOpiniones<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se calcula el total de las opiniones de la encuesta.
     */
    @Test
    public void testDarNumeroTotalOpiniones( )
    {
        setupEscenario2( );
         int numeroDeOpinionesTotal = 6;
        assertEquals( "No se suma bien el total de numero de opiniones en la encuesta",numeroDeOpinionesTotal,  encuesta.getNumeroTotalOpiniones());
    }
	//---------------------------------------------------//


}
