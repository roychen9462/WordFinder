public class ScoreTableTester {
   public static void main(String[] args) {
      String word;

      word = "antlers";
      System.out.println(word + ": " + ScoreTable.getScore(word) + " (Exp: 7)");

      word = "learns";
      System.out.println(word + ": " + ScoreTable.getScore(word) + " (Exp: 6)");

      word = "later";
      System.out.println(word + ": " + ScoreTable.getScore(word) + " (Exp: 5)");

      word = "elt";
      System.out.println(word + ": " + ScoreTable.getScore(word) + " (Exp: 3)");

   }
}