package utils;

public class UtilMethods {
  public static String getAlternateTitle(String originalName) {
    if ("Leia Organa".equals(originalName)) {
      return "Princess Leia";
    } else if ("A New Hope".equals(originalName)) {
      return "Star Wars (film)";
    }

    return originalName;
  }
}
