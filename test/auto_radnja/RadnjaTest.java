package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;


import org.junit.jupiter.api.Test;

import gume.AutoGuma;

abstract class RadnjaTest {

	protected Radnja radnja;

	@Test
	void testDodajGumu() {
		AutoGuma autoGuma = new AutoGuma("Bridgestone 55", 15, 145, 85);
		radnja.dodajGumu(autoGuma);
		assertEquals(radnja.vratiSveGume().size(), 1);
		assertEquals(radnja.vratiSveGume().get(0), autoGuma);
	}

	@Test
	void testDodajGumuNull() {
	Exception e=assertThrows(java.lang.NullPointerException.class, () -> radnja.dodajGumu(null));
	assertEquals("Guma ne sme biti null", e.getMessage());
	}

	@Test
	void testDodajPostojecuGumu() {
		AutoGuma autoGuma = new AutoGuma("Bridgestone 55", 15, 145, 85);
		radnja.dodajGumu(autoGuma);
		AutoGuma autoGuma2 = new AutoGuma("Bridgestone 55", 15, 145, 85);
		Exception e=assertThrows(java.lang.RuntimeException.class, () -> radnja.dodajGumu(autoGuma2));
		assertEquals("Guma vec postoji", e.getMessage());
	}

	@Test
	void testPronadjiGumuNull() {
		
		assertEquals(null, radnja.pronadjiGumu(null));
		
	}
	
	@Test
	void testNePostojiZadataGuma() {
		AutoGuma autoGuma = new AutoGuma("Bridgestone 55", 15, 145, 85);
		radnja.dodajGumu(autoGuma);
		assertEquals(0, radnja.pronadjiGumu("Dunlop 123CV").size());
	}
	
	@Test
	void testPronadjiViseGumaIsteMarkeIModela() {
		AutoGuma autoGuma = new AutoGuma("Bridgestone 55", 15, 145, 85);
		AutoGuma autoGuma2 = new AutoGuma("Bridgestone 55", 13, 139, 78);
		radnja.dodajGumu(autoGuma);
		radnja.dodajGumu(autoGuma2);
		List<AutoGuma> gume=radnja.pronadjiGumu("Bridgestone 55");
		assertEquals(2, gume.size());
		assertTrue(gume.contains(autoGuma));
		assertTrue(gume.contains(autoGuma2));
		
	}

	@Test
	void testVratiSveGume() {
		AutoGuma autoGuma = new AutoGuma("Bridgestone 55", 15, 145, 85);
		AutoGuma autoGuma2 = new AutoGuma("Bridgestone 55", 13, 139, 78);
		radnja.dodajGumu(autoGuma);
		radnja.dodajGumu(autoGuma2);
		assertEquals(2, radnja.vratiSveGume().size());
	}
	
	@Test
	void vratiSveGumePraznaLista() {
		assertEquals(0,radnja.vratiSveGume().size());
	}

}
