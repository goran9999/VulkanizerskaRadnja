package auto_radnja.gume;


/**
 * 
 * @author goran
 * @version 1.0.0
 *
 */

public class AutoGuma {

	/**
	 * Atribut koji opisuje marku i model date gume za automobil
	 */
	private String markaModel = null;
	/**
	 * Precnik gume
	 */
	private int precnik = -1;
	/**
	 * Sirina gume
	 */
	private int sirina = -1;
	/**
	 * Visina gume
	 */
	private int visina = -1;

	/**
	 * Neparametarski konstruktor klase AutoGuma
	 */
	public AutoGuma() {
	}

	/**
	 * Parametarski konstruktor koji putem set metoda postavlja vrednosti atributa na zadate vrednosti
	 * @param markaModel marka i model gume
	 * @param precnik precnik gume
	 * @param sirina sirina gume
	 * @param visina visina gume
	 */
	public AutoGuma(String markaModel, int precnik, int sirina, int visina) {
		super();
		setMarkaModel(markaModel);
		setPrecnik(precnik);
		setSirina(sirina);
		setVisina(visina);
	}

	/**
	 * Metoda koja vraca marku i model konkretne gume
	 * @return markaModel
	 */
	public String getMarkaModel() {
		return markaModel;
	}

	/**
	 * Set metoda koja postavlja vrednost markaModel gume na zadatu vrednost
	 * @param markaModel marka i model gume
	 * @throws NullPointerException ukoliko zadati atribut markaModel ima vrednost null
	 * @throws IllegalArgumentException  ukoliko je duzina stringa markaModel koji je zadat manja od 3 karaktera 
	 */
	public void setMarkaModel(String markaModel) {
		if (markaModel == null)
			throw new NullPointerException("Morate uneti marku i model");
		if (markaModel.length() < 3)
			throw new IllegalArgumentException("Marka i model moraju sadrzati bar 3 znaka");
		this.markaModel = markaModel;
	}

	/**
	 * Get metoda koja vraca precnik zadate gume
	 * @return precnik
	 */
	public int getPrecnik() {
		return precnik;
	}

	/**
	 * Set metoda koja postavlja vrednost precnika gume na zadatu vrednost
	 * @param precnik precnik gume
	 * @throws IllegalArgumentException ukoliko je zadati precink manji od 13 ili veci od 22
	 */
	public void setPrecnik(int precnik) {
		if (precnik < 13 || precnik > 22)
			throw new IllegalArgumentException("Precnik van opsega");
		this.precnik = precnik;
	}

	/**
	 * Get metoda koja vraca sirinu gume
	 * @return sirina
	 */
	public int getSirina() {
		return sirina;
	}
	
	/**
	 * Set metoda koja postavlja vrednost sirine gume na zadatu vrednost
	 * @param sirina sirina gume
	 * @throws IllegalArgumentException Ukolikko je zadata sirina gume manja od 135 ili veca od 335
	 */
	public void setSirina(int sirina) {
		if (sirina < 135 || sirina > 355)
			throw new IllegalArgumentException("Sirina van opsega");
		this.sirina = sirina;
		}
	/**
	 * Get metoda koja vraca visinu gume
	 * @return visina
	 */
	public int getVisina() {
		return visina;
		}
	/**
	 * Set metoda koja postavlja vrednost visine gume na zadatu vrednost
	 * @param visina visina gume
	 * @throws IllegalArgumentException Ako je zadata visina manja od 25 ili veca od 95
	 */
	public void setVisina(int visina) {
		if (visina < 25 || visina > 95)
			throw new IllegalArgumentException("Visina van opsega");
		this.visina = visina;
		}
	/**
	 * toString metoda koja nam omogucava da upravljamo prikazom objekta klase AutoGuma u konzoli
	 * @return Objekat kao string
	 */
	@Override
	public String toString() {
		return"AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik + ", sirina=" + sirina + ", visina=" + visina + "]";
		}
	/**
	 * Equals metoda koja vrsi uporedjivanje atributa 2 objekta klase AutoGuma i na osnovu toga vraca true ili false
	 * @return true ako objekti imaju iste atribute,u suprotnom false
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoGuma other = (AutoGuma) obj;
		if (markaModel == null) {
			if (other.markaModel != null)
				return false;
			} 
		else if (!markaModel.equals(other.markaModel))
			return false;
		if (precnik != other.precnik)
			return false;
		if (sirina != other.sirina)
			return false;
		if (visina != other.visina)
			return false;
		return true;
		}

}
