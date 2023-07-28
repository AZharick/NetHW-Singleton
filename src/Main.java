import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
   private static int listSize;
   private static int maxValue;
   private static Scanner scanner;
   private static ArrayList<Integer> list;
   private static int minimumToFilter;
   private static ArrayList<Integer> resultList;
   private static String greeting = "Welcome to \"FilterLogger-9000\"!\n";
   private static Logger logger = Logger.getInstance();

   public static void main(String[] args) {
      logger.log("Program start");
      System.out.println(greeting);
      scanner = new Scanner(System.in);

      requestListParams();
      list = createList(listSize, maxValue);
      System.out.println("Original random list: " + list);
      requestFilterParam();
      Filter filter = new Filter(minimumToFilter);


      resultList = new ArrayList<>(filter.filterOut(list));

      logger.log("Printing result list...");
      System.out.println("result: " + resultList);

      logger.log("Terminating the program...");
      System.out.println("Goodbye!");
   }

   public static void requestListParams() {
      logger.log("Requesting params for list...");
      System.out.print("Please enter list size and max value: ");
      String response = scanner.nextLine();
      String[] answers = response.split(" ");
      listSize = 0;
      maxValue = 0;
      try {
         listSize = Integer.parseInt(answers[0]);
         maxValue = Integer.parseInt(answers[1]);
      } catch (NumberFormatException e) {
         logger.log("ERROR: Incorrect data!");
         System.out.println("Two integers must be entered!");
      }
   }

   public static ArrayList createList(int listSize, int maxValue) {
      logger.log("Creating and filling up the list...");
      list = new ArrayList<>();
      for (int i = 0; i < listSize; i++) {
         Random random = new Random();
         int element = random.nextInt(maxValue);
         list.add(element);
      }
      return list;
   }

   public static void requestFilterParam() {
      logger.log("Requesting lower border of filtering");
      System.out.print("Please enter lower border of list filtering: ");
      try {
         minimumToFilter = scanner.nextInt();
      } catch (NumberFormatException e) {
         logger.log("ERROR: Incorrect data!");
         System.out.println("An integer must be entered!");
      }
   }

}