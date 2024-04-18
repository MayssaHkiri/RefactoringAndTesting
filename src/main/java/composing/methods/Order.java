package composing.methods;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class Order {
  private final Customer customer;
  private final ArrayList<Product> products;

  public String generateStatement() {
    checkInputs();
    StringBuilder statement = new StringBuilder();

    //Add banner
    statement.append("Statement for : " + customer + "%n");

    addProducts(statement);
    double total = AmountCalculator.calculatePrice(this, true, customer.getAge());
    statement.append("Total: " + total + "€");

    return statement.toString();
  }

  private void addProducts(StringBuilder statement) {
    for (Product p : products) {
      // Add details.
      statement.append("Product: " + p.getName() + " Price: " + p.getPrice() + "%n");
    }
  }

  private void checkInputs() {
    if (customer == null || customer.getName().isEmpty() || products.size() <= 0) {
      throw new IllegalArgumentException("InvalidOrder");
    }
  }

  public Double totalPrice() {
    return getProducts().stream().map(Product::getPrice).reduce(0.0, Double::sum);
  }
}