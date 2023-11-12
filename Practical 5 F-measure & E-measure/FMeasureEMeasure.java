public class FMeasureEMeasure {

    public static double harmonicMean(double precision, double recall) {
        if (precision == 0 || recall == 0) {
            return 0;
        } else {
            return 2 * (precision * recall) / (precision + recall);
        }
    }

    public static double eMeasure(double precision, double recall, double beta) {
        return (1 + Math.pow(beta, 2)) * (precision * recall) / (Math.pow(beta, 2) * precision + recall);
    }

    public static void main(String[] args) {
        double precision = 0.88;
        double recall = 0.45;
        double beta = 1.25;

        double harmonicMean = harmonicMean(precision, recall);
        double eMeasure = eMeasure(precision, recall, beta);

        System.out.println("Harmonic mean: " + harmonicMean);
        System.out.println("E-measure: " + eMeasure);
    }
}

