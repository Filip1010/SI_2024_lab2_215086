import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void testMultipleConditions() {
        Item item1 = new Item("item1", "0123456789", 301, 0.1f);
        Item item2 = new Item("item2", "1234567890", 299, 0.2f);
        Item item3 = new Item("item3", "0234567891", 302, 0f);

        List<Item> items1 = List.of(item1);
        assertTrue(SILab2.checkCart(items1, 30));

        List<Item> items2 = List.of(item2);
        assertTrue(SILab2.checkCart(items2, 60));

        List<Item> items3 = List.of(item3);
        assertTrue(SILab2.checkCart(items3, 302));

        List<Item> items4 = List.of(item2);
        assertTrue(SILab2.checkCart(items4, 60));
    }

    @Test
    void testEveryBranch() {
        Item item1 = new Item(null, "0123456789", 301, 0.1f);
        Item item2 = new Item("item2", null, 299, 0.2f);

        assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 100));

        List<Item> items1 = List.of(item1);
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(items1, 30));

        List<Item> items2 = List.of(item2);
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(items2, 60));

        List<Item> items3 = List.of(new Item("item3", "1234567890", 100, 0.1f));
        assertTrue(SILab2.checkCart(items3, 100));

        assertFalse(SILab2.checkCart(items3, 5));
    }
}
