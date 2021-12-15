package erdam.ej4.LaEncuesta.test;

import org.junit.Test;

import erdam.ej4.LaEncuesta.mundo.RangoEdad;
import junit.framework.TestCase;

/**
 * Clase usada para verificar que los métodos de la clase RangoEdad estén correctamente implementados.
 */
public class RangoEdadTest extends TestCase {
	//------- A T R I B U T O S -------//
	private RangoEdad rangoEncuesta1;
	private RangoEdad rangoEncuesta2;

	//--------- E S C E N A R I O S ----------//
	//---------------------------------------------------//
	 /**
     * Escenario 1: Crea un escenario de prueba con dos rangos.
     */
	private void setupEscenario1()
	{
		rangoEncuesta1 		 = new RangoEdad(0,  18);
		rangoEncuesta2		 = new RangoEdad(18, 55);
	}
	//---------------------------------------------------//
    /**
     * Escenario 2: Crea un escenario de prueba con dos rangos con opiniones de soltero.
     */
	private void setupEscenario2()
	{
		setupEscenario1();
		rangoEncuesta1.agregarOpinionesSoltero(5);
		rangoEncuesta1.agregarOpinionesSoltero(1);
		rangoEncuesta1.agregarOpinionesSoltero(9);
		rangoEncuesta2.agregarOpinionesSoltero(0);
		rangoEncuesta2.agregarOpinionesSoltero(8);
	}
	//---------------------------------------------------//
    /**
     * Escenario 3: Crea un escenario de prueba con dos rangos con opiniones de casado.
     */
	private void setupEscenario3()
	{
		setupEscenario1();
		rangoEncuesta1.agregarOpinionesCasados(10);
		rangoEncuesta1.agregarOpinionesCasados(5);
		rangoEncuesta1.agregarOpinionesCasados(1);
		rangoEncuesta1.agregarOpinionesCasados(7);
		rangoEncuesta2.agregarOpinionesCasados(6);
		rangoEncuesta2.agregarOpinionesCasados(6);
		rangoEncuesta2.agregarOpinionesCasados(9);
		rangoEncuesta2.agregarOpinionesCasados(2);
		rangoEncuesta2.agregarOpinionesCasados(2);
		rangoEncuesta2.agregarOpinionesCasados(1);
	}
	//---------------------------------------------------//
    /**
     * Escenario 4: Crea un escenario de prueba con dos rangos con opiniones.
     */
	private void setupEscenario4()
	{
		setupEscenario1();
        rangoEncuesta1.agregarOpinionesCasados( 10 );
        rangoEncuesta1.agregarOpinionesCasados( 5 );
        rangoEncuesta1.agregarOpinionesCasados( 1 );
        rangoEncuesta1.agregarOpinionesCasados( 7 );
        rangoEncuesta1.agregarOpinionesSoltero( 8 );
        rangoEncuesta1.agregarOpinionesSoltero( 4 );
        rangoEncuesta1.agregarOpinionesSoltero( 4 );
        rangoEncuesta1.agregarOpinionesSoltero( 6 );

        rangoEncuesta2.agregarOpinionesCasados( 8 );
        rangoEncuesta2.agregarOpinionesCasados( 2 );
        rangoEncuesta2.agregarOpinionesCasados( 0 );
        rangoEncuesta2.agregarOpinionesCasados( 8 );
        rangoEncuesta2.agregarOpinionesSoltero( 9 );
        rangoEncuesta2.agregarOpinionesSoltero( 5 );
        rangoEncuesta2.agregarOpinionesSoltero( 3 );
        rangoEncuesta2.agregarOpinionesSoltero( 7 );
        rangoEncuesta2.agregarOpinionesSoltero( 7 );
		
	}
	//--------- M É T O D O S  D E  P R U E B A ----------//
	//---------------------------------------------------//
    /**
     * Prueba 1: Método que se encarga de verificar el método agregarOpinionSoltero.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarOpinionesSoltero<br>
     * getNumeroDeOpiniones<br>
     * getTotalOpiniones<br>
     * getTotalOpinionCasados<br>
     * getTotalOpinionSolteros<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se agregan varias opiniones a los rangos.
     */
	@Test
	public void testAgregarOpinionesSolteros()
	{
		setupEscenario2();
		assertEquals("No se puede agregar las opiniones correctamente a un rango",3,rangoEncuesta1.getNumeroDeOpiniones());
		assertEquals("No se puede agregar las opiniones correctamente a un rango",15,rangoEncuesta1.getTotalOpiniones());
		
		assertEquals("No se puede agregar las opiniones correctamente a un rango",2,rangoEncuesta2.getNumeroDeOpiniones());
		assertEquals("No se puede agregar las opiniones correctamente a un rango",8,rangoEncuesta2.getTotalOpiniones());
		
		assertEquals("No se puede agregar las opiniones correctamente a un rango",2,rangoEncuesta2.getNumeroDeSolteros());
		assertEquals("No se puede agregar las opiniones correctamente a un rango",0,rangoEncuesta2.getNumeroDeCasados());
		
		assertEquals("No se puede agregar las opiniones correctamente a un rango",8,rangoEncuesta2.getTotalOpiniones());
		assertEquals("No se puede agregar las opiniones correctamente a un rango",0,rangoEncuesta2.getTotalOpinionesCasados());
		
		assertEquals("No se puede agregar las opiniones correctamente a un rango",8,rangoEncuesta2.getTotalOpinionesSolteros());
		
		
	}
	//---------------------------------------------------//
    /**
     * Prueba 2: Método que se encarga de verificar el método agregarOpinionCasado.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarOpinionesCasados<br>
     * getNumeroDeOpiniones<br>
     * getTotalOpiniones<br>
     * getTotalOpinionCasados<br>
     * getTotalOpinionSolteros<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se agregan varias opiniones a los rangos.
     */
	@Test
	public void testAgregarOpinionesCasados()
	{
		setupEscenario3();
		assertEquals("No se puede agregar las opiniones correctamente a un rango",4,rangoEncuesta1.getNumeroDeOpiniones());
		assertEquals("No se puede agregar las opiniones correctamente a un rango",23,rangoEncuesta1.getTotalOpiniones());
		
		assertEquals("No se puede agregar las opiniones correctamente a un rango",6,rangoEncuesta2.getNumeroDeOpiniones());
		assertEquals("No se puede agregar las opiniones correctamente a un rango",26,rangoEncuesta2.getTotalOpiniones());
		
		assertEquals("No se puede agregar las opiniones correctamente a un rango",0,rangoEncuesta2.getNumeroDeSolteros());
		assertEquals("No se puede agregar las opiniones correctamente a un rango",6,rangoEncuesta2.getNumeroDeCasados());
		
		assertEquals("No se puede agregar las opiniones correctamente a un rango",26,rangoEncuesta2.getTotalOpiniones());
		assertEquals("No se puede agregar las opiniones correctamente a un rango",26,rangoEncuesta2.getTotalOpinionesCasados());
		
		assertEquals("No se puede agregar las opiniones correctamente a un rango",0,rangoEncuesta2.getTotalOpinionesSolteros());
		
	
		
	}
	//---------------------------------------------------//
    /**
     * Prueba 3: Método que se encarga de verificar el método getPromedioSolteros.<br>
     * <b> Métodos a probar: </b> <br>
     * getPromedioSolteros<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se agregan varias opiniones a los rangos.
     */
	@Test
	public void testGetPromedioSolteros()
	{
		setupEscenario2();
		assertEquals( "No se está calculando el promedio correctamente", 5d, rangoEncuesta1.getPromedioSolteros() );//(23/4=5.0)
		assertEquals( "No se está calculando el promedio correctamente", 4d, rangoEncuesta2.getPromedioSolteros() );//(8/2=4.0)

		
	}
	//---------------------------------------------------//
    /**
     * Prueba 4: Método que se encarga de verificar el método getPromedioCasados.<br>
     * <b> Métodos a probar: </b> <br>
     * getPromedioCasados<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se agregan varias opiniones a los rangos.
     */
	@Test
	public void testGetPromedioCasados()
	{
		setupEscenario3();
		assertEquals( "No se está calculando el promedio correctamente", 5d, rangoEncuesta1.getPromedioCasados(),1d);//(23/4=5.75)
		assertEquals( "No se está calculando el promedio correctamente", 4d, rangoEncuesta2.getPromedioCasados(),1d );//(26/6=4.333333333)
		
	}

}
