import java.io.*;
import java.util.*;

//Single_Pass -Algorithm

public class Practical2 {

    public static void main(String[] args) {
        // Initialize parameters
        int numClusters = 2; // Number of clusters you want to create
        List<Set<String>> clusters = new ArrayList<>(); // List to store clusters
        double similarityThreshold = 0.5; // Jaccard similarity threshold for clustering

        // Create file names for demonstration purposes
        String[] fileNames = {"D:\\Engineering\\BE Last Year\\Information Storage & Retreival\\ISR\\ISR\\Practical 2 Single-Pass\\File1.txt","D:\\Engineering\\BE Last Year\\Information Storage & Retreival\\ISR\\ISR\\Practical 2 Single-Pass\\File2.txt", "D:\\Engineering\\BE Last Year\\Information Storage & Retreival\\ISR\\ISR\\Practical 2 Single-Pass\\File3.txt", "D:\\Engineering\\BE Last Year\\Information Storage & Retreival\\ISR\\ISR\\Practical 2 Single-Pass\\File4.txt", "D:\\Engineering\\BE Last Year\\Information Storage & Retreival\\ISR\\ISR\\Practical 2 Single-Pass\\File5.txt", "D:\\\\Engineering\\\\BE Last Year\\\\Information Storage & Retreival\\\\ISR\\\\ISR\\\\Practical 2 Single-Pass\\\\File6.txt" };

        // Process files one by one
        for (String fileName : fileNames) {
            Set<String> currentFileTokens = readFileTokens(fileName);

            // Flag to check if the file was assigned to an existing cluster
            boolean assigned = false;

            // Check if the current file is similar to any existing clusters
            for (int i = 0; i < clusters.size(); i++) {
                Set<String> cluster = clusters.get(i);
                double similarity = calculateJaccardSimilarity(currentFileTokens, cluster);

                if (similarity >= similarityThreshold) {
                    // Add the file to the cluster
                    cluster.addAll(currentFileTokens);
                    assigned = true;
                    break; // Stop checking other clusters
                }
            }

            // If not assigned to any existing cluster, create a new cluster
            if (!assigned) {
                clusters.add(currentFileTokens);
            }
        }

        // Print the clusters
        for (int i = 0; i < clusters.size(); i++) {
            System.out.println("Cluster " + (i + 1) + ": " + clusters.get(i));
        }
    }

    // Read a file and tokenize its content
    private static Set<String> readFileTokens(String fileName) {
        Set<String> tokens = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                tokens.addAll(Arrays.asList(words));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tokens;
    }

    // Calculate Jaccard Similarity between two sets
    private static double calculateJaccardSimilarity(Set<String> set1, Set<String> set2) {
        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);
        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return (double) intersection.size() / union.size();
    }
}
