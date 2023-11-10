import java.util.ArrayList;

public class RackTester {

   public static void main(String[] args) {
      String s;
      Rack r;

      System.out.println("\n======== Case 1 ========");

      s = "flier";
      System.out.println("> Input rack: " + s);
      r = new Rack(s);
      System.out.println(r);


      System.out.println("\n======== Case 2 ========");

      s = "Dog@";
      System.out.println("> Input rack: " + s);
      r = new Rack(s);
      System.out.println(r);

      System.out.println("\n======== Case 3 ========");

      s = "aadbb";
      System.out.println("> Input rack: " + s);
      r = new Rack(s);
      System.out.println(r);

      System.out.println("\n======== Case 4 ========");

      s = "";
      System.out.println("> Input rack: " + s + "<Empty>");
      r = new Rack(s);
      System.out.println(r);


      System.out.println("\n======== Test deep copy ========");
      s = "Dog";
      System.out.println("> Input rack: " + s);
      r = new Rack(s);
      System.out.println(r);

      ArrayList<String> arr = r.getAllSubsets();
      arr.set(0, "Replaced");
      System.out.println("> Replaced first element of returned array");
      System.out.println("Returned array: " + arr);
      System.out.println("Original array: " + r.getAllSubsets());
   }
}