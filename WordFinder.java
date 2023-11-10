// Name: Jing-Wen Chen
// USC NetID: jchen885
// CS 455 PA4
// Spring 2023

import java.io.FileNotFoundException;
import java.util.*;

/**
 * Class WordFinder
 *
 * A command-line user interactive interface for user to get anagram of user-defined word.
 */
public class WordFinder {
   public static void main(String[] args) {
      // Check optional command-line argument & build anagram dictionary
      String fileName = args.length > 0 ? args[0] : "./sowpods.txt";
      try {
         AnagramDictionary anagramDict = new AnagramDictionary(fileName);

         System.out.println("Type . to quit.");

         // Keep reading rack until user input a '.'
         Scanner in = new Scanner(System.in);
         while (true) {
            System.out.print("Rack? ");
            String s = in.next();
            if (s.equals(".")) { break; }

            Rack rack = new Rack(s);
            showReport(anagramDict, rack);
         }

      } catch (FileNotFoundException e) {
         System.out.println("ERROR: Dictionary file \"" + fileName + "\" does not exist.");
         System.out.println("Exiting program.");
      } catch (IllegalDictionaryException e) {
         System.out.println(e.getMessage());
         System.out.println("Exiting program.");
      }
   }

   /**
    * Show the number of possible anagrams and sorted them based on the score
    * @param anagramDictionary pre-build word dictionary
    * @param rack rack object with all possible subsets
    */
   private static void showReport(AnagramDictionary anagramDictionary, Rack rack) {
      HashMap<Integer, HashSet<String>> scoreMap = new HashMap<>();
      int count = 0; // Count total number of found anagrams
      for (String str : rack.getAllSubsets()){
         if (anagramDictionary.getAnagramsOf(str) != null) { // Check if the dictionary contains the str
            HashSet<String> words = anagramDictionary.getAnagramsOf(str);
            // Calculate score for every word and build scoreMap
            for (String word: words) {
               int score = ScoreTable.getScore(word);
               if (scoreMap.containsKey(score)) {
                  scoreMap.get(score).add(word);
               } else {
                  HashSet<String> arr = new HashSet<>();
                  arr.add(word);
                  scoreMap.put(score, arr);
               }
            }
            count += words.size();
         }
      }

      System.out.println("We can make " + count + " words from \"" + rack.getRack() + "\"");

      if (count > 0) { // Show the result only if found at least one anagram
         showScoreMap(scoreMap);
      }
   }

   private static void showScoreMap(HashMap<Integer, HashSet<String>> scoreMap) {
      System.out.println("All of the words with their scores (sorted by score):");
      ArrayList<Integer> keyList = new ArrayList<>(scoreMap.keySet());
      for (int i = keyList.size()-1; i >= 0; i--) { // Sort the score in descending order
         int score = keyList.get(i);
         ArrayList<String> words = new ArrayList<>(scoreMap.get(score));
         Collections.sort(words); // Sort the word in ascending order
         for (String word : words) {
            System.out.println(score + ": " + word);
         }
      }
   }
}