import java.util.*;
// import java.util.regex.*;
import java.util.stream.Collectors;

public class DocumentRetrieval {

    // Define a function to tokenize and preprocess text
    private static List<String> preprocess(String text) {
        text = text.toLowerCase();
        String[] words = text.split("\\W+");
        return Arrays.asList(words);
    }

    // Define a function to create an inverted index from a collection of documents
    private static Map<String, List<Integer>> createInvertedIndex(List<String> documents) {
        Map<String, List<Integer>> invertedIndex = new HashMap<>();

        for (int docId = 0; docId < documents.size(); docId++) {
            String document = documents.get(docId);
            List<String> tokens = preprocess(document);

            for (String token : tokens) {
                invertedIndex.computeIfAbsent(token, k -> new ArrayList<>()).add(docId);
            }
        }

        return invertedIndex;
    }

    // Define a function to retrieve documents that match a query
    private static List<String> retrieveDocuments(String query, Map<String, List<Integer>> invertedIndex, List<String> documents) {
        List<String> queryTerms = preprocess(query);
        Set<Integer> matchingDocIds = new HashSet<>();

        for (String term : queryTerms) {
            if (invertedIndex.containsKey(term)) {
                matchingDocIds.addAll(invertedIndex.get(term));
            }
        }

        return matchingDocIds.stream().map(docId -> documents.get(docId)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // Sample collection of documents
        List<String> documents = Arrays.asList(
            "This is the first document.",
            "This document is the second document.",
            "And this is the third one.",
            "Is this the first document?",
            "And all documents are arranged in best Manner"
        );

        // Create the inverted index
        Map<String, List<Integer>> invertedIndex = createInvertedIndex(documents);

        // Example query
        String query = "This is the second document.";
        List<String> matchingDocs = retrieveDocuments(query, invertedIndex, documents);

        // Print the inverted index
        System.out.println("Inverted Index:");
        for (Map.Entry<String, List<Integer>> entry : invertedIndex.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Print the matching documents
        System.out.println("\nMatching Documents:");
        for (String doc : matchingDocs) {
            System.out.println(doc);
        }
    }
}