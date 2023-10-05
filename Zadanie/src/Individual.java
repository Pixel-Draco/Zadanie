public class Individual implements Comparable<Individual>
{
    private String first_name;
    private int rate;

    Individual()
    {
        this.first_name = "";
        this.rate = 0;
    }
    Individual(String first_name, int rate)
    {
        this.first_name = first_name;
        this.rate = rate;
    }

    public String getFirst_name()
    {
        return first_name;
    }

    public int getRate()
    {
        return rate;
    }

    public void setFirst_name(String first_name)
    {
        this.first_name = first_name;
    }

    public void setRate(int rate)
    {
        this.rate = rate;
    }

    public void copy(Individual individual)
    {
        this.setFirst_name(individual.getFirst_name());
        this.setRate(individual.getRate());
    }

    @Override
    public String toString()
    {
        String tmp = this.getFirst_name() + " " + this.getRate();

        return tmp;
    }

    @Override
    public int compareTo(Individual o)
    {
        if(this.getRate() == o.getRate())
        {
            return 0;
        }
        else if(this.getRate() > o.getRate())
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
}
