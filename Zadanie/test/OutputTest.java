import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutputTest
{
    Input input = new Input();
    Output output;

    @BeforeEach
    void setIndividualsElement()
    {
        output = new Output(input.getSize_individuals(),
                            input.getNumber_of_teams());

        for(int i = 0; i < input.getSize_individuals(); i++)
        {
            Individual tmp = input.getIndividualsElement(i);
            output.setIndividualsElement(new Individual(tmp.getFirst_name(), tmp.getRate()), i);
        }

        output.sort_list_individuals(2);
        output.create_teams();
        output.setAverage_teams_rate();
    }

    @Test
    void sort_list_individuals()
    {
        System.out.println(output.getTemporary_list_individuals());
    }

    @Test
    void teams_Rate_Rounded_Standard_Deviation()
    {
        assertEquals(0.41, output.teams_Rate_Rounded_Standard_Deviation());
    }

    @Test
    void getNumber_teams()
    {
        assertEquals(3, output.getNumber_teams());
    }

    @Test
    void getNumber_persons()
    {
        assertEquals(6, output.getNumber_persons());
    }

    @Test
    void setNumber_teams()
    {
        output.setNumber_teams(4);

        assertEquals(4, output.getNumber_teams());
    }

    @Test
    void setNumber_persons()
    {
        output.setNumber_persons(5);

        assertEquals(5, output.getNumber_persons());
    }

    @Test
    void getResults()
    {
        String tmp = "Team no 1 has 2 players (Jude,Juliet).Average rate: 6.0\n" +
                "Team no 2 has 2 players (Johnny,Robbie).Average rate: 6.5\n" +
                "Team no 3 has 2 players (Deborah,Scarlet).Average rate: 5.5\n" +
                "Teams rate standard deviation: 0.41";

        output.print_results();

        assertEquals(tmp, output.getResults());
    }
}