import java.util.List;
import java.util.stream.Collectors;

public class Filter {
   protected int threshold;

   public Filter(int threshold) {
      this.threshold = threshold;
   }

   public List<Integer> filterOut(List<Integer> source) {
      Logger logger = Logger.getInstance();
      logger.log("Running filtering procedure...");

      List<Integer>result = source.stream()
              .peek(s -> {
                 if (s>=threshold) {
                    logger.log(s + " accepted");
                 } else {
                    logger.log((s + " declined"));
              }})
              .filter(s -> s>threshold)
              .collect(Collectors.toList());

      logger.log("Filtered out " +
              (source.size()-result.size()) +
              " elements out of " +
              source.size());

      return result;
   }
}