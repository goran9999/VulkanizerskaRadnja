package auto_radnja;

/**
 * Klasa VulkanizerskaRadnja koja predstavlja vulkanizersku radnju kao entitet u nasem sistemu.
 * Ova klasa prvenstveno sluzi za vodjenje evidencije o auto gumama i cuvanje podataka o njima.
 */

/**
 * @author goran
 * @version 1.0.0
 */

import java.util.LinkedList;
import java.util.List;

import gume.AutoGuma;

public class VulkanizerskaRadnja implements Radnja {
	/**
	 * Lista u kojoj cuvamo podatke o nasim gumama
	 */
	private List<AutoGuma> gume = new LinkedList<AutoGuma>();

	@Override
	public void dodajGumu(AutoGuma a) {
		if (a == null)
			throw new NullPointerException("Guma ne sme biti null");
		if (gume.contains(a))
			throw new RuntimeException("Guma vec postoji");
		 gume.add(a);
	}

	//U ovoj metodi je bila greska.Dodato je .getMarkaModel() u if naredbi kako bi se uporedjivali stringovi a ne objekat sa stringom.
	@Override
	public List<AutoGuma> pronadjiGumu(String markaModel) {
		if (markaModel == null)
			return null;
		List<AutoGuma> novaLista = new LinkedList<AutoGuma>();
		for (int i = 0; i < gume.size(); i++)
			if (gume.get(i).getMarkaModel().equals(markaModel))
				novaLista.add(gume.get(i));
		return novaLista;
	}

	@Override
	public List<AutoGuma> vratiSveGume() {
		return gume;
	}

}
