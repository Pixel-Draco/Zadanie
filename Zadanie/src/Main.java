public class Main
{
    private static Input input;
    private static Output output;

    public static void main(String[] args)
    {
        input = new Input();

        output_results(input);
    }

    public static void output_results(Input obj)
    {
        output = new Output(obj.getSize_individuals(),
                                   obj.getNumber_of_teams());

        for(int i = 0; i < obj.getSize_individuals(); i++)
        {
            Individual tmp = obj.getIndividualsElement(i);
            output.setIndividualsElement(new Individual(tmp.getFirst_name(), tmp.getRate()), i);
        }

        output.sort_list_individuals(2);
        output.create_teams();
        output.setAverage_teams_rate();
        output.print_results();

        input.setResults(output.getResults());
    }
}