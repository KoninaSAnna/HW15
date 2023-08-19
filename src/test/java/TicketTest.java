import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class TicketTest {

    @Test
    public void testSortPrice() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("PRM", "MSK", 5_000, 8, 10);
        Ticket ticket2 = new Ticket("PRM", "MSK", 3_000, 20, 22);
        Ticket ticket3 = new Ticket("PRM", "MSK", 10_000, 14, 16);
        Ticket ticket4 = new Ticket("PRM", "SPB", 6_000, 10, 12);
        Ticket ticket5 = new Ticket("PRM", "MSK", 6_000, 16, 18);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.search("PRM", "MSK");
        Ticket[] expected = {ticket2, ticket1, ticket5, ticket3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortPriseOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("PRM", "MSK", 5_000, 8, 10);
        Ticket ticket2 = new Ticket("PRM", "MSK", 3_000, 20, 22);
        Ticket ticket3 = new Ticket("PRM", "MSK", 10_000, 14, 16);
        Ticket ticket4 = new Ticket("PRM", "SPB", 6_000, 10, 12);
        Ticket ticket5 = new Ticket("PRM", "MSK", 6_000, 16, 18);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.search("PRM", "SPB");
        Ticket[] expected = {ticket4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortPriseNoTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("PRM", "MSK", 5_000, 8, 10);
        Ticket ticket2 = new Ticket("PRM", "MSK", 3_000, 20, 22);
        Ticket ticket3 = new Ticket("PRM", "MSK", 10_000, 14, 16);
        Ticket ticket4 = new Ticket("PRM", "SPB", 6_000, 10, 12);
        Ticket ticket5 = new Ticket("PRM", "MSK", 6_000, 16, 18);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.search("PRM", "UFA");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTime() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("PRM", "MSK", 5_000, 8, 20); //12
        Ticket ticket2 = new Ticket("PRM", "MSK", 3_000, 20, 24); //4
        Ticket ticket3 = new Ticket("PRM", "MSK", 10_000, 14, 19); //5
        Ticket ticket4 = new Ticket("PRM", "SPB", 6_000, 10, 12);
        Ticket ticket5 = new Ticket("PRM", "MSK", 6_000, 16, 18); //2

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("PRM", "MSK", comparator);
        Ticket[] expected = {ticket5, ticket2, ticket3, ticket1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTimeOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("PRM", "MSK", 5_000, 8, 20); //12
        Ticket ticket2 = new Ticket("PRM", "MSK", 3_000, 20, 24); //4
        Ticket ticket3 = new Ticket("PRM", "MSK", 10_000, 14, 19); //5
        Ticket ticket4 = new Ticket("PRM", "SPB", 6_000, 10, 12);
        Ticket ticket5 = new Ticket("PRM", "MSK", 6_000, 16, 18); //2

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("PRM", "SPB", comparator);
        Ticket[] expected = {ticket4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTimeNoTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("PRM", "MSK", 5_000, 8, 20); //12
        Ticket ticket2 = new Ticket("PRM", "MSK", 3_000, 20, 24); //4
        Ticket ticket3 = new Ticket("PRM", "MSK", 10_000, 14, 19); //5
        Ticket ticket4 = new Ticket("PRM", "SPB", 6_000, 10, 12);
        Ticket ticket5 = new Ticket("PRM", "MSK", 6_000, 16, 18); //2

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("PRM", "UFA", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
}
