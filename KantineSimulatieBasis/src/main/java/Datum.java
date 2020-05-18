public class Datum {

	// fields
	private int dag = 0;
	private int maand = 0;
	private int jaar = 0;

	// constructor
	public Datum(int dag, int maand, int jaar) {
		if (bestaatDatum(dag, maand, jaar)) {
			this.dag = dag;
			this.maand = maand;
			this.jaar = jaar;
		}
	}

	// methods
	public int getDag() {
		return dag;
	}

	public int getMaand() {
		return maand;
	}

	public int getJaar() {
		return jaar;
	}

	public void setDag(int dag) {
		this.dag = dag;
	}

	public void setMaand(int maand) {
		this.maand = maand;
	}

	public void setJaar(int jaar) {
		this.jaar = jaar;
	}

	public boolean bestaatDatum(int dag, int maand, int jaar) {

		if (dag < 1 || dag > 31) {
			return false;
		}

		if (maand < 1 || maand > 12) {
			return false;
		}

		if (jaar < 1900 || jaar > 2100) {
			return false;
		}

		if ((maand == 4 || maand == 6 || maand == 9 || maand == 11) && dag > 30) {
			return false;
		}

		if (maand == 2) {
			if (((jaar % 400) == 0 || (jaar % 4) == 0) && (jaar % 100) != 0) {
				if (dag > 29) {
					return false;
				}
			} else {
				if (dag > 28) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Getter voor Sting weergave van datum
	 *
	 * 
	 * @return Geboortedatum
	 */
	public String getDatumAsString() {
		// TODO
		return "";
	}
}
