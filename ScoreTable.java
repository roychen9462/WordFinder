// Name: Jing-Wen Chen
// USC NetID: jchen885
// CS 455 PA4
// Spring 2023

/**
 * A class to get the score of string based on hard-coded score map
 */
public class ScoreTable {
   private static final int[] scoreMap = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};

   /**
    * Return the score of input string
    * @param word to be scored
    * @return the score of input string
    */
   public static int getScore(String word) {
      int score = 0;
      for (char chr : word.toCharArray()) {
         int idx = Character.toLowerCase(chr) - 'a';
         score += scoreMap[idx];
      }
      return score;
   }
}