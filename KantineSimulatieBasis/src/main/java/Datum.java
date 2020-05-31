public class Datum {

	// fields
	private int dag;
	private int maand;
	private int jaar;

	// constructor
	public Datum(int dag, int maand, int jaar) {
		if (bestaatDatum(dag, maand, jaar)) {
			this.dag = dag;
			this.maand = maand;
			this.jaar = jaar;
		} else {
			this.dag = 0;
			this.maand = 0;
			this.jaar = 0;
		}
	}

	// methods
	/**
	 * @return the dag
	 */
	public int getDag() {
		return dag;
	}

	/**
	 * @return the maand
	 */
	public int getMaand() {
		return maand;
	}

	/**
	 * @return the jaar
	 */
	public int getJaar() {
		return jaar;
	}

	/**
	 * @param dag the dag to set
	 */
	public void setDag(int dag) {
		this.dag = dag;
		if (!bestaatDatum(dag, maand, jaar)) {
			dag = 0;
			maand = 0;
			jaar = 0;
		}
	}

	/**
	 * @param maand the maand to set
	 */
	public void setMaand(int maand) {
		this.maand = maand;
		if (!bestaatDatum(dag, maand, jaar)) {
			dag = 0;
			maand = 0;
			jaar = 0;
		}
	}

	/**
	 * @param jaar the jaar to set
	 */
	public void setJaar(int jaar) {
		this.jaar = jaar;
		if (!bestaatDatum(dag, maand, jaar)) {
			dag = 0;
			maand = 0;
			jaar = 0;
		}
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
		if (dag == 0 || maand == 0 || jaar == 0) {
			return "Onbekend";
		} else {
			String output = Integer.toString(dag) + " " + Integer.toString(maand) + " " + Integer.toString(jaar);
			return output;
		}

	}
}
