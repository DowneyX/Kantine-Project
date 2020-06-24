public class Datum {

	/**
	 * FIELDS
	 */
	private int dag;
	private int maand;
	private int jaar;

	/**
	 * CONSTUCTOR
	 * 
	 * @param dag   the day
	 * @param maand the month
	 * @param jaar  the year
	 */
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

	/**
	 * METHODS
	 */

	/**
	 * @return the day
	 */
	public int getDag() {
		return dag;
	}

	/**
	 * @return the month
	 */
	public int getMaand() {
		return maand;
	}

	/**
	 * @return the year
	 */
	public int getJaar() {
		return jaar;
	}

	/**
	 * @param dag the day to set
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
	 * @param maand the month to set
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
	 * @param jaar the year to set
	 */
	public void setJaar(int jaar) {
		this.jaar = jaar;
		if (!bestaatDatum(dag, maand, jaar)) {
			dag = 0;
			maand = 0;
			jaar = 0;
		}
	}

	/**
	 * method that checks if a certain date is even possible
	 * 
	 * @param dag   the day
	 * @param maand the month
	 * @param jaar  the year
	 * @return boalean depending on if the date is possible or not
	 */
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
	 * method to get the date as a string
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
