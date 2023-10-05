import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
public class Output
{
    private int number_persons;
    private int number_teams;
    private String results;
    private ArrayList<Individual> temporary_list_individuals;
    private ArrayList<Double> average_teams_rate;
    private ArrayList<ArrayList<Individual>> teams;

    Output()
    {
        this.number_persons = 0;
        this.number_teams = 0;
        this.results = "";
        this.temporary_list_individuals = null;
        this.teams = null;
        this.average_teams_rate = null;
    }

    Output(int number_persons, int number_of_teams)
    {
        this.number_persons = number_persons;
        this.number_teams = number_of_teams;
        this.results = "";
        this.temporary_list_individuals = new ArrayList<>();
        this.teams = new ArrayList<ArrayList<Individual>>();
        this.average_teams_rate = new ArrayList<>();
    }

    public void setIndividualsElement(Individual individual)
    {
        temporary_list_individuals.add(individual);
    }

    public void setIndividualsElement(Individual individual, int index)
    {
        temporary_list_individuals.add(index, individual);
    }

    // Used block sort
    public void sort_list_individuals(int block_size)
    {
        ArrayList<ArrayList<Individual>> blocks = new ArrayList<>();

        for(int i = 0; i < this.number_persons; i += block_size)
        {
            ArrayList<Individual> block = new ArrayList<>();

            for(int j = i; (j < i + block_size) && (j < this.number_persons); j++)
            {
                block.add(this.temporary_list_individuals.get(j));
            }
            Collections.sort(block);
            blocks.add(block);
        }

        ArrayList<Individual> result = new ArrayList<>();

        while(blocks.isEmpty() == false)
        {
            int min_index = 0;

            for(int i = 1; i < blocks.size(); i++)
            {
                if(-1 == (blocks.get(i).get(0).compareTo(blocks.get(min_index).get(0))))
                {
                    min_index = i;
                }
            }

            result.add(blocks.get(min_index).remove(0));

            if(blocks.get(min_index).isEmpty())
            {
                blocks.remove(min_index);
            }
        }
        temporary_list_individuals = new ArrayList<>(result);
    }

    public void create_teams()
    {
        int number_teams = this.number_teams;
        double number_person_teams = 0;

        double rest_division = (this.number_persons % number_teams);

        int first_index = 0;
        int last_index = (temporary_list_individuals.size() - 1);

        boolean used_first_index = true;
        boolean used_last_index = true;

        if(rest_division == 0)
        {
            number_person_teams = (this.number_persons / number_teams);

            for(int i = 0; i < number_teams; i++)
            {

                ArrayList<Individual> tmp_array_list = new ArrayList<>();

                for(int j = 0; j < number_person_teams; j++)
                {
                    if(used_first_index == true)
                    {
                        tmp_array_list.add(temporary_list_individuals.get(last_index));

                        used_first_index = false;
                        used_last_index = true;

                        last_index -= 1;
                    }
                    else
                    {
                        tmp_array_list.add(temporary_list_individuals.get(first_index));

                        used_first_index = true;
                        used_last_index = false;

                        first_index += 1;
                    }

                }
                teams.add(tmp_array_list);
            }
        }
        else
        {
            int iterator = (int)rest_division;
            int plus_one = 1;

            number_person_teams = (int)(this.number_persons / number_teams);

            for(int i = 0; i < number_teams; i++)
            {
                ArrayList<Individual> tmp_array_list = new ArrayList<>();

                for(int j = 0; j < number_person_teams + plus_one; j++)
                {
                    if(used_first_index == true)
                    {
                        tmp_array_list.add(temporary_list_individuals.get(last_index));

                        used_first_index = false;
                        used_last_index = true;

                        last_index -= 1;
                    }
                    else
                    {
                        tmp_array_list.add(temporary_list_individuals.get(first_index));

                        used_first_index = true;
                        used_last_index = false;

                        first_index += 1;
                    }
                }
                teams.add(tmp_array_list);

                iterator--;

                if(iterator <= 0)
                {
                    plus_one = 0;
                }
            }
        }
    }

    public void setAverage_teams_rate()
    {
        double  average_rate = 0;

        for(int i = 0; i < this.number_teams; i++)
        {
            for (int j = 0; j < teams.get(i).size(); j++)
            {
                average_rate += teams.get(i).get(j).getRate();
            }

            average_rate = (average_rate / teams.get(i).size());

            average_teams_rate.add(average_rate);

            average_rate = 0;
        }

    }

    public void print_results()
    {
        double tmp_double = 0;
        String tmp = null;

        for(int i = 0; i < this.number_teams; i++)
        {

            tmp = ("Team no " + (i+1) + " has " + teams.get(i).size() + " players (");

            for(int j = 0; j < teams.get(i).size(); j++)
            {
                tmp = tmp.concat(teams.get(i).get(j).getFirst_name() + ",");
            }

            tmp = tmp.substring(0, tmp.length() - 1);
            tmp = tmp + ").";

            tmp = tmp + "Average rate: " + average_teams_rate.get(i);

            this.results += (tmp + System.getProperty("line.separator"));

            System.out.print(tmp);
            System.out.println();

            tmp = null;
        }

        tmp_double = teams_Rate_Rounded_Standard_Deviation();
        System.out.println("Teams rate standard deviation: " + tmp_double);;
        System.out.println();

        this.results += ("Teams rate standard deviation: " + tmp_double);
    }

    public double teams_Rate_Rounded_Standard_Deviation()
    {
        double mean = 0;
        int number_elements = this.number_teams;
        double variance = 0;
        double sum1 = 0;
        double sum2 = 0;
        double standard_deviation = 0;
        double rounded_standard_deviation = 0;

        BigDecimal tmp;

        double[] tab = new double[number_elements];

        for(int i = 0; i < average_teams_rate.size(); i++)
        {
            sum1 += average_teams_rate.get(i);
        }

        mean = (sum1 / number_elements);

        for(int i = 0; i < number_elements; i++)
        {
            tab[i] =  Math.pow((average_teams_rate.get(i) - mean), 2);

            sum2 += tab[i];
        }

        variance = (sum2 / number_elements);

        standard_deviation = Math.sqrt(variance);

        tmp = new BigDecimal(standard_deviation).setScale(2, RoundingMode.HALF_UP);

        rounded_standard_deviation = tmp.doubleValue();

        return rounded_standard_deviation;
    }
    public int getNumber_teams()
    {
        return this.number_teams;
    }

    public int getNumber_persons()
    {
        return this.number_persons;
    }

    public void setNumber_teams(int number_teams)
    {
        this.number_teams = number_teams;
    }

    public void setNumber_persons(int number_persons)
    {
        this.number_persons = number_persons;
    }

    public String getResults()
    {
        return this.results;
    }

    public ArrayList<Individual> getTemporary_list_individuals()
    {
        return this.temporary_list_individuals;
    }
}
