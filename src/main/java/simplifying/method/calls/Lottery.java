package simplifying.method.calls;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Lottery {
  private static final Random RANDOM = new Random(42);
  private final HashMap<UUID, LotteryTicket> tickets = new HashMap<>();

  public String purchaseTicketForCustomer(UUID id, String name) {
    String ticketNumber = generateTicketNumber(null);
    tickets.put(id, new LotteryTicket(ticketNumber, id));

    return ticketNumber;
  }

  public LotteryTicket drawWinner(double ticketPrice, double prizeAmount) {
    if (tickets.isEmpty()) {
      throw new IllegalStateException("No tickets");
    }

    List<LotteryTicket> randomizedTickets = new ArrayList<>(tickets.values());
    Collections.shuffle(randomizedTickets);

    return randomizedTickets.get(0);
  }

  private String generateTicketNumber(String format) {
    return String.format("%06d", RANDOM.nextInt(1000000));
  }
}