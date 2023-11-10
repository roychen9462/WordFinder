import java.io.FileNotFoundException;

public class AnagramDictionaryTester {

   public static void main(String[] args) {

      // Test FileNotFound Exception Handling
      try {
         System.out.println("\n======== Test FileNotFound Exception Handling ========");
         System.out.println("> Read ./testFiles/non-exist.txt");
         AnagramDictionary dict = new AnagramDictionary("./testFilesnon-exist.txt");
      } catch (FileNotFoundException e) {
         System.out.println("Not found file.");
      } catch (IllegalDictionaryException e) {
         System.out.println("File has duplicate word.");
      }

      // Test Invalid Dictionary Exception Handling
      try {
         System.out.println("\n======== Test Invalid Dictionary Exception Handling ========");
         System.out.println("> Read ./testFiles/duplicate.txt");
         AnagramDictionary dict = new AnagramDictionary("./testFiles/duplicate.txt");
      } catch (FileNotFoundException e) {
         System.out.println("Not found file.");
      } catch (IllegalDictionaryException e) {
         System.out.println("File has duplicate word.");
      }

      // Test getAnagramOf
      try {
         System.out.println("\n======== Test getAnagramOf ========");
         System.out.println("> Read ./testFiles/tinyDictionary.txt");
         AnagramDictionary dict = new AnagramDictionary("./testFiles/tinyDictionary.txt");

         System.out.println("Dictionary:");
         System.out.println(dict);

         System.out.println();
         System.out.println("key: flier, dict: " + dict.getAnagramsOf("flier") + " (Exp: [rifle, flier])");
         System.out.println("key: Flier, dict: " + dict.getAnagramsOf("Flier") + " (Exp: null)");
         System.out.println("key: me, dict: " + dict.getAnagramsOf("me") + " (Exp: [em, me])");
         System.out.println("key: hi, dict: " + dict.getAnagramsOf("hi") + " (Exp: null)");
      } catch (FileNotFoundException e) {
         System.out.println("Not found file.");
      } catch (IllegalDictionaryException e) {
         System.out.println("File has duplicate word.");
      }
   }
}