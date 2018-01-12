package uva.tds.pr4.ismpere;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	ColaDeAmigosUnitTDDTest.class,
	ColaDeAmigosIntegrationTDDTest.class,
	ColaDeAmigosBlackBoxUnitTest.class,
	ColaDeAmigosBlackBoxIntegrationTest.class,
	ColaDeAmigosSecuenceTest.class,
	ColaDeAmigosConAmigosYColadosTest.class})

/**
 * Suite de test de la clase ColaDeAmigos
 * @author ismpere
 */
public class ColaDeAmigosAllTest {

}
