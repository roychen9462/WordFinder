// Name: Jing-Wen Chen
// USC NetID: jchen885
// CS 455 PA4
// Spring 2023

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
   A Rack of Scrabble tiles
 */

public class Rack {
   private final String rack;
   private final ArrayList<String> allSubsets;

   public Rack(String s) {
      this.rack = s.replaceAll("[^a-zA-Z]", "");
      this.allSubsets = this.genAllSubsets(this.rack);
   }


   /**
      Finds all subsets of the multiset starting at position k in unique and mult.
      unique and mult describe a multiset such that mult[i] is the multiplicity of the char
           unique.charAt(i).
      PRE: mult.length must be at least as big as unique.length()
           0 <= k <= unique.length()
      @param unique a string of unique letters
      @param mult the multiplicity of each letter from unique.  
      @param k the smallest index of unique and mult to consider.
      @return all subsets of the indicated multiset.  Unlike the multiset in the parameters,
      each subset is represented as a String that can have repeated characters in it.
      @author Claire Bono
    */
   private static ArrayList<String> allSubsets(String unique, int[] mult, int k) {
      ArrayList<String> allCombos = new ArrayList<>();
      
      if (k == unique.length()) {  // multiset is empty
         allCombos.add("");
         return allCombos;
      }
      
      // get all subsets of the multiset without the first unique char
      ArrayList<String> restCombos = allSubsets(unique, mult, k+1);
      
      // prepend all possible numbers of the first char (i.e., the one at position k) 
      // to the front of each string in restCombos.  Suppose that char is 'a'...
      
      String firstPart = "";          // in outer loop firstPart takes on the values: "", "a", "aa", ...
      for (int n = 0; n <= mult[k]; n++) {   
         for (int i = 0; i < restCombos.size(); i++) {  // for each of the subsets 
                                                        // we found in the recursive call
            // create and add a new string with n 'a's in front of that subset
            allCombos.add(firstPart + restCombos.get(i));  
         }
         firstPart += unique.charAt(k);  // append another instance of 'a' to the first part
      }
      
      return allCombos;
   }

   /**
    * Generate all possible subsets based on input string
    * @param s input string
    * @return an arrayList contains all subsets
    */
   private ArrayList<String> genAllSubsets(String s) {
      HashMap<Character, Integer> counts = new HashMap<>();
      String unique = "";
      for (char chr : s.toCharArray()) {
         if (counts.containsKey(chr)) {
            counts.put(chr, counts.get(chr) + 1);
         } else {
            counts.put(chr, 1);
            unique += chr;
         }
      }

      // Sort unique string
      char[] tmp = unique.toCharArray();
      Arrays.sort(tmp);
      unique = new String(tmp);

      // get mult array
      int[] mult = new int[unique.length()];
      for (int i = 0; i < mult.length; i++) {
         char chr = tmp[i];
         mult[i] = counts.get(chr);
      }

      return allSubsets(unique, mult, 0);
   }

   /**
    * Return the rack
    * @return the rack
    */
   public String getRack() {
      return this.rack;
   }

   /**
    * Return a copy of all subsets of rack
    * @return a copy of all subsets of rack
    */
   public ArrayList<String> getAllSubsets() {
      return new ArrayList<>(this.allSubsets);
   }

   @Override
   public String toString() {
      String s = "";
      s += "Rack: " + this.rack + "\n";
      s += "All Subsets: " + this.allSubsets;

      return s;
   }
}
