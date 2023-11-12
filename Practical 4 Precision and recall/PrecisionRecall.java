import java.util.*;

public class PrecisionRecall {

    public static void main(String[] args) {
        // Define the answer set, query, and relevant documents.
        Set<String> answerSet = new HashSet<>(Arrays.asList("doc1", "doc2", "doc3", "doc4", "doc6", "doc8"));
        String query = "my query";
        Set<String> relevantDocuments = new HashSet<>(Arrays.asList("doc1", "doc2", "doc4","doc6", "doc8"));

        // Calculate precision and recall.
        double precision = calculatePrecision(answerSet, query, relevantDocuments);
        double recall = calculateRecall(answerSet, query, relevantDocuments);

        // Print the results.
        System.out.println("Precision: " + precision);
        System.out.println("Recall: " + recall);
    }

    private static double calculatePrecision(Set<String> answerSet, String query, Set<String> relevantDocuments) {
        // Calculate the number of relevant documents in the answer set.
        int relevantDocumentsInAnswerSet = 0;
        for (String document : answerSet) {
            if (relevantDocuments.contains(document)) {
                relevantDocumentsInAnswerSet++;
            }
        }

        // Calculate the number of documents in the answer set.
        int numberOfDocumentsInAnswerSet = answerSet.size();

        // Calculate precision.
        return (double) relevantDocumentsInAnswerSet / numberOfDocumentsInAnswerSet;
    }

    private static double calculateRecall(Set<String> answerSet, String query, Set<String> relevantDocuments) {
        // Calculate the number of relevant documents in the answer set.
        int relevantDocumentsInAnswerSet = 0;
        for (String document : answerSet) {
            if (relevantDocuments.contains(document)) {
                relevantDocumentsInAnswerSet++;
            }
        }

        // Calculate the number of relevant documents.
        int numberOfRelevantDocuments = relevantDocuments.size();

        // Calculate recall.
        return (double) relevantDocumentsInAnswerSet / numberOfRelevantDocuments;
    }
}