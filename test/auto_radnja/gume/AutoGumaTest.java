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
		autoGuma = new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		autoGuma = null;
	}

	@Test
	void testAutoGumaStringIntIntInt() {
		autoGuma = new AutoGuma("pirelli,sottozero 3", 18, 145, 70);
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
		assertThrows(java.lang.IllegalArgumentException.class, () -> autoGuma.setMarkaModel("AB"));
	}

	@Test
	void testSetMarkaModelNullVrednost() {
		assertThrows(java.lang.NullPointerException.class, () -> autoGuma.setMarkaModel(null));
	}

	@Test
	void testSetPrecnik() {
		autoGuma.setPrecnik(18);
		assertEquals(18, autoGuma.getPrecnik());
	}

	// Ovaj test ce uvek da failuje jer je metoda setPrecnik pogresna.Umesto &&
	// logickog operatiora postavljamo ||,kako bi test mogao da prodje.
	@Test
	void testSetPrecnikManjeOd13() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> autoGuma.setPrecnik(0));
	}

	@Test
	void testSetPrecnikVeciOd22() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> autoGuma.setPrecnik(25));
	}

	@Test
	void testSetSirina() {
		autoGuma.setSirina(145);
		assertEquals(145, autoGuma.getSirina());
	}

	@Test
	void testSetSirinaManjeOd135() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> autoGuma.setSirina(14));
	}

	@Test
	void testSetSirinaVecaOd355() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> autoGuma.setSirina(360));
	}

	@Test
	void testSetVisina() {
		autoGuma.setVisina(70);
		assertEquals(70, autoGuma.getVisina());
	}

	@Test
	void testSetVisinaManjeOd25() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> autoGuma.setVisina(20));
	}

	@Test
	void testSetVisinaVecaOd95() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> autoGuma.setVisina(100));
	}

	@Test
	void testToString() {
		autoGuma = new AutoGuma("Dunlop 335i", 18, 145, 70);
		assertTrue(autoGuma.toString().contains("Dunlop 335i"));
		assertTrue(autoGuma.toString().contains("18"));
		assertTrue(autoGuma.toString().contains("145"));
		assertTrue(autoGuma.toString().contains("70"));
	}

	@ParameterizedTest
	@CsvSource({ "Dunlop D2,15,150,75,true", "Pirelli 124RCV,20,145,88,false" })
	void testEqualsObject(String markaModel, int precnik, int sirina, int visina, boolean isti) {
		autoGuma.setMarkaModel("Dunlop D2");
		autoGuma.setPrecnik(15);
		autoGuma.setSirina(150);
		autoGuma.setVisina(75);
		AutoGuma autoGuma2 = new AutoGuma(markaModel, precnik, sirina, visina);
		assertEquals(autoGuma.equals(autoGuma2), isti);
	}

	@Test
	void testEqualsNullParametar() {
		assertFalse(autoGuma.equals(null));
	}

}
