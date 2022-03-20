package auto_radnja;

/**
 * @author goran
 * @version 1.0.0
 */

import java.util.List;

import gume.AutoGuma;

public interface Radnja {
	/**
	 * Metoda koja kao parametar prima novu gumu i cuva je u kolekciju
	 * @param a AutoGuma koju dodajemo u kolekciju
	 * @throws RuntimeException ako zadata guma vec postoji u kolekciji
	 * @throws NullPointerException ako je prosledjena vrednost null
	 */
	void dodajGumu(AutoGuma a);

	/**
	 * 
	 * @param markaModel marka i model gume koji nam sluze kao vrednost po kojoj pretrazujemu gumu u kolekciji
	 * @return Pronadjean AutoGuma koja ima marku i model koji su prosledjeni kao parametri
	 * 
	 */
	List<AutoGuma> pronadjiGumu(String markaModel);

	/**
	 * 
	 * @return Lista svih sacuvanih guma u nasoj kolekciji
	 */
	List<AutoGuma> vratiSveGume();
}
