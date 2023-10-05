import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputTest
{
    Input input = new Input();

    @Test
    void getNumber_of_teams()
    {
        assertEquals(3, input.getNumber_of_teams());
    }

    @Test
    void getSize_individuals()
    {
        assertEquals(6, input.getSize_individuals());
    }
}