import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndividualTest
{
    Individual individual = new Individual("Alex", 3);

    @Test
    void copy()
    {
        Individual tmp = new Individual();

        tmp.copy(individual);

        assertEquals("Alex", tmp.getFirst_name());

        assertEquals(3, tmp.getRate());
    }

    @Test
    void testToString()
    {
        assertEquals("Alex 3", individual.toString());
    }

    @Test
    void compareTo()
    {
        Individual tmp_1 = new Individual("Wars", 5);
        Individual tmp_2 = new Individual("Wanda", 2);
        Individual tmp_3 = new Individual("Albert", 3);

        assertEquals(-1, individual.compareTo(tmp_1));
        assertEquals(1, individual.compareTo(tmp_2));
        assertEquals(0, individual.compareTo(tmp_3));
    }
}