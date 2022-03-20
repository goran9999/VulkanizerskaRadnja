package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import gume.AutoGuma;

class AutoGumaTest {
	
	AutoGuma autoGuma;

	@BeforeEach
	void setUp() throws Exception {
		autoGuma=new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		autoGuma=null;
	}

	@Test
	void testAutoGumaStringIntIntInt() {
		autoGuma=new AutoGuma("pirelli,sottozero 3",18,145,70);
		assertEquals("pirelli,sottozero 3", autoGuma.getMarkaModel());
		assertEquals(18, autoGuma.getPrecnik());
		assertEquals(145, autoGuma.getSirina());
		assertEquals(70, autoGuma.getVisina());
	}

	@Test
	void testSetMarkaModel() {
		autoGuma.setMarkaModel("Pirelli,cinturato p7");
		assertEquals("Pirelli,cinturato p7", autoGuma.getMarkaModel());
	}
	
	@Test
	void testSetMarkaModelManjeOd3Karaktera() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->autoGuma.setMarkaModel("AB"));
	}
	
	@Test
	void testSetMarkaModelNullVrednost() {
		assertThrows(java.lang.NullPointerException.class, ()->autoGuma.setMarkaModel(null));
	}

	@ParameterizedTest
	@CsvSource({"18,18"})
	void testSetPrecnik(int param,int expValue) {
		autoGuma.setPrecnik(18);
		assertEquals(expValue, autoGuma.getPrecnik());
	}
	//Ovaj test ce uvek da failuje jer je metoda setPrecnik pogresna.Umesto && logickog operatiora postavljamo ||,kako bi test mogao da prodje.
	@Test
	void testSetPrecnikManjeOd13() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->autoGuma.setPrecnik(0));
	}
	
	@Test
	void testSetPrecnikVeciOd22() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->autoGuma.setPrecnik(25));
	}

	@ParameterizedTest
	@CsvSource({"145,145"})
	void testSetSirina(int param,int expValue) {
		autoGuma.setSirina(145);
		assertEquals(expValue,autoGuma.getSirina());
	}
	
	@Test
	void testSetSirinaManjeOd135() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->autoGuma.setSirina(14));
	}
	
	@Test
	void testSetSirinaVecaOd355() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->autoGuma.setSirina(360));
	}


	@ParameterizedTest
	@CsvSource({"70,70"})
	void testSetVisina(int param,int expValue) {
		autoGuma.setVisina(70);
		assertEquals(expValue,autoGuma.getVisina());
	}
	
	@Test
	void testSetVisinaManjeOd25() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->autoGuma.setVisina(20));
	}
	
	@Test
	void testSetVisinaVecaOd95() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->autoGuma.setVisina(100));
	}


	@Test
	void testToString() {
		autoGuma=new AutoGuma("Dunlop 335i",18,145,70);
		assertTrue(autoGuma.toString().contains("Dunlop 335i"));
		assertTrue(autoGuma.toString().contains("18"));
		assertTrue(autoGuma.toString().contains("145"));
		assertTrue(autoGuma.toString().contains("70"));
	}

	@ParameterizedTest
	@CsvSource({"Dunlop D2,15,150,75"})
	void testEqualsObject(String markaModel,int precnik,int sirina,int visina) {
		autoGuma.setMarkaModel("Dunlop D2");
		autoGuma.setPrecnik(15);
		autoGuma.setSirina(150);
		autoGuma.setVisina(75);
		AutoGuma autoGuma2=new AutoGuma(markaModel,precnik,sirina,visina);
		assertTrue(autoGuma.equals(autoGuma2));
	}
	
	@Test
	void testEqualsNullParametar() {
		assertFalse(autoGuma.equals(null));
	}
	
	@ParameterizedTest
	@CsvSource({"Pirelli 124RCV,20,145,88"})
	void testEqualsRazlicitObjekat(String markaModel,int precnik,int sirina,int visina) {
		AutoGuma autoGuma2=new AutoGuma(markaModel,precnik,sirina,visina);
		autoGuma.setMarkaModel("Dunlop D2");
		autoGuma.setPrecnik(20);
		autoGuma.setSirina(155);
		autoGuma.setVisina(85);
		assertFalse(autoGuma.equals(autoGuma2));
	}

}
