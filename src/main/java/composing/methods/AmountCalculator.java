package composing.methods;

public class AmountCalculator {
  public static double calculatePrice(double amount, int age) {
    double discountBasedOnAge = 0;

    discountBasedOnAge = getDiscountBasedOnAge(amount, age, discountBasedOnAge);
    return amount - discountBasedOnAge;
  }

  private static double getDiscountBasedOnAge(double amount, int age, double discountBasedOnAge) {
    if (age <= 16) {
      discountBasedOnAge = 0.35 * amount;
    } else if (age >= 60) {
      discountBasedOnAge = 0.2 * amount;
    }
    return discountBasedOnAge;
  }

  public static double calculatePrice(Order order, boolean applyAgeDiscount, int age) {
    double result = 0.0;
    double discount = 0.0;
    double resultWithDiscount = 0.0;

    result = getResult(order, result);

    if (applyAgeDiscount) {
      double discountBasedOnAge = 0;
     
      discount = getDiscountBasedOnAge(result, age, discountBasedOnAge);
    }
    resultWithDiscount = result - discount;

    return resultWithDiscount;
  }

  private static double getResult(Order order, double result) {
    for (Product product : order.getProducts()) {
      result += product.getPrice();
    }
    return result;
  }
}