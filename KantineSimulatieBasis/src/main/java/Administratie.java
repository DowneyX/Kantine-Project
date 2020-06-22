public class Administratie {

    private static final int DAYS_IN_WEEK = 7;

    /**
     * Deze methode berekent van de int array aantal de gemiddelde waarde
     *
     * @param aantal
     * @return het gemiddelde
     */
    private Administratie() {
    }

    public static double berekenGemiddeldAantal(int[] aantal) {
        double optelling = 0;
        for (int aant : aantal) {
            optelling += aant;
        }
        double average = optelling / aantal.length;
        return average;
    }

    /**
     * Deze methode berekent van de double array omzet de gemiddelde waarde
     *
     * @param omzet
     * @return het gemiddelde
     */
    public static double berekenGemiddeldeOmzet(double[] omzet) {

        double optelling = 0;
        for (double geld : omzet) {
            optelling += geld;
        }

        return (optelling / omzet.length);
    }

    /**
     * Methode om dagomzet uit te rekenen
     *
     * @param omzet
     * @return array (7 elementen) met dagomzetten
     */

    public static double[] berekenDagOmzet(double[] omzet) {
        double[] temp = new double[DAYS_IN_WEEK];
        for (int i = 0; i < DAYS_IN_WEEK; i++) {

            // if the last day of a week is reached this will turn to true
            boolean endOfList = false;
            int j = 0;

            // this will count up all the values for each specific day
            if (i < omzet.length) {
                while (!endOfList) {
                    temp[i] += omzet[i + (DAYS_IN_WEEK * j)];
                    if ((i + (DAYS_IN_WEEK * (j + 1))) < omzet.length) {
                        j++;
                    } else {
                        endOfList = true;
                    }
                }
            }

            // calculates the average
            temp[i] = temp[i] / (j + 1);
        }
        return temp;
    }
}
