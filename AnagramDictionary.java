// Name: Jing-Wen Chen
// USC NetID: jchen885
// CS 455 PA4
// Spring 2023

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


/**
   A dictionary of all anagram sets. 
   Note: the processing is case-sensitive; so if the dictionary has all lower
   case words, you will likely want any string you test to have all lower case
   letters too, and likewise if the dictionary words are all upper case.
 */
public class AnagramDictionary {
   private final HashMap<String, HashSet<String>> anagramDict;


   /**
      Create an anagram dictionary from the list of words given in the file
      indicated by fileName.  
      @param fileName  the name of the file to read from
      @throws FileNotFoundException  if the file is not found
      @throws IllegalDictionaryException  if the dictionary has any duplicate words
    */
   public AnagramDictionary(String fileName) throws FileNotFoundException,
                                                    IllegalDictionaryException {
      this.anagramDict = buildDictionary(fileName);
   }
   

   /**
      Get all anagrams of the given string. This method is case-sensitive.
      E.g. "CARE" and "race" would not be recognized as anagrams.
      @param string to process
      @return a list of the anagrams of s
    */
   public HashSet<String> getAnagramsOf(String string) {
      return this.anagramDict.get(this.sortCharInString(string));
   }

   /***
    * Build anagramDictionary based ob the input file
    * @param fileName to read
    * @return AnagramDictionary
    * @throws FileNotFoundException
    * @throws IllegalDictionaryException
    */
   private HashMap<String, HashSet<String>> buildDictionary(String fileName) throws FileNotFoundException, IllegalDictionaryException {
      File infile = new File(fileName);
      Scanner in = new Scanner(infile);

      HashMap<String, HashSet<String>> dict = new HashMap<>();
      while (in.hasNext()) {
         String word = in.next();
         String key = this.sortCharInString(word);

         if (dict.containsKey(key)) {
            // Check if there is duplicate word in file
            if (dict.get(key).contains(word)) {
               throw new IllegalDictionaryException("ERROR: Illegal dictionary: " +
                                                    "dictionary file has a duplicate word: " + word);
            }

            dict.get(key).add(word);
         } else {
            // Add new entry into dictionary
            HashSet<String> array = new HashSet<>();
            array.add(word);
            dict.put(key, array);
         }
      }

      return dict;
   }

   /***
    * Sort string s according to the alphabetic order of its characters
    * @param s to be sorted
    * @return sorted string
    */
   private String sortCharInString(String s) {
      char[] chars = s.toCharArray();
      Arrays.sort(chars);

      return new String(chars);
   }

   @Override
   public String toString() {
      return this.anagramDict.toString();
   }
}
