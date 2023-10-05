import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Input extends JFrame implements ActionListener
{
    private String[] names =
            {
                    "Johnny", "Robbie", "Juliet", "Scarlet", "Jude",
                    "Deborah"
            };
    private int[] rates =
            {
                    8, 5, 3, 5, 9,
                    6
            };
    private int number_of_teams = 3;
    private ArrayList<Individual> individuals;
    private int size_individuals;
    private String results;
    private String title = "Zadanie";
    private Dimension dimension = new Dimension(1200, 600);
    private JTextArea jTextArea, jTextErrorArea, jTextResultArea;
    private JButton jButton;
    private JTextField jTextField;
    private JLabel jLabel1, jLabel2, jLabel3, jLabel4;
    private JLabel jLabel5, jLabel6;
    private JPanel jPanel_1, jPanel_2, jPanel_3;
    private Font font = new Font("Arial", Font.PLAIN, 16);

    Input()
    {
        this.setTitle(title);
        this.setSize(dimension);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(1, 3));
        this.setResizable(true);

        jTextArea = new JTextArea();
        jTextField = new JTextField();
        jTextErrorArea = new JTextArea();
        jTextResultArea = new JTextArea();
        jButton = new JButton();

        jPanel_1 = new JPanel();
        jPanel_2 = new JPanel();
        jPanel_3 = new JPanel();

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();

        jTextArea.setBounds(40, 100, 400, 300);
        jTextArea.setSize(new Dimension(400, 300));
        jTextArea.setFont(font);
        jTextArea.setLineWrap(true);
        jTextArea.setOpaque(true);
        jTextArea.setAutoscrolls(true);
        jTextArea.setWrapStyleWord(true);

        jButton.setName("Enter");
        jButton.setText("Enter");
        jButton.addActionListener(this);
        jButton.setBounds(175,
                          425, 100 ,100);
        jButton.setFont(new Font("Arial", Font.BOLD, 20));

        jTextField.setEnabled(true);
        jTextField.addActionListener(this);
        jTextField.setBounds(300, 425, 100, 50);
        jTextField.setSize(new Dimension(100, 50));
        jTextField.setHorizontalAlignment(JTextField.HORIZONTAL);
        jTextField.setOpaque(true);

        jTextErrorArea.setBounds(50, 100, 350, 300);
        jTextErrorArea.setSize(new Dimension(350, 300));
        jTextErrorArea.setFont(new Font("Arial", Font.BOLD, 16));
        jTextErrorArea.setForeground(Color.RED);
        jTextErrorArea.setLineWrap(true);
        jTextErrorArea.setOpaque(true);
        jTextErrorArea.setAutoscrolls(true);
        jTextErrorArea.setEditable(false);
        jTextErrorArea.setWrapStyleWord(true);

        jTextResultArea.setBounds(40, 100, 350, 300);
        jTextResultArea.setSize(new Dimension(350, 300));
        jTextResultArea.setFont(new Font("Arial", Font.BOLD, 14));
        jTextResultArea.setForeground(new Color(0, 200, 0));
        jTextResultArea.setLineWrap(true);
        jTextResultArea.setOpaque(true);
        jTextResultArea.setAutoscrolls(true);
        jTextResultArea.setEditable(false);
        jTextResultArea.setWrapStyleWord(true);

        jLabel1.setEnabled(true);
        jLabel1.setVisible(true);
        jLabel1.setOpaque(true);
        jLabel1.setText("Insert in the below area a list of individuals.");
        jLabel1.setFont(new Font("Arial", Font.BOLD, 16));
        jLabel1.setBounds(25, 0, 400, 50);
        jLabel1.setSize(new Dimension(400, 50));
        jLabel1.setHorizontalAlignment(JLabel.HORIZONTAL);

        jLabel3.setEnabled(true);
        jLabel3.setVisible(true);
        jLabel3.setOpaque(true);
        jLabel3.setText("\n For example \"Alex\", 3");
        jLabel3.setFont(new Font("Arial", Font.BOLD, 16));
        jLabel3.setBounds(0, 50, 400, 50);
        jLabel3.setSize(new Dimension(400, 50));
        jLabel3.setHorizontalAlignment(JLabel.HORIZONTAL);

        jLabel2.setEnabled(true);
        jLabel2.setVisible(true);
        jLabel2.setOpaque(true);
        jLabel2.setText("Insert a number of teams:");
        jLabel2.setFont(new Font("Arial", Font.BOLD, 16));
        jLabel2.setBounds(50, 425, 250, 25);
        jLabel2.setSize(new Dimension(250, 25));
        jLabel2.setHorizontalAlignment(JLabel.HORIZONTAL);

        jLabel4.setEnabled(true);
        jLabel4.setVisible(true);
        jLabel4.setOpaque(true);
        jLabel4.setText("For example 3");
        jLabel4.setFont(new Font("Arial", Font.BOLD, 16));
        jLabel4.setBounds(50, 450, 250, 50);
        jLabel4.setSize(new Dimension(250, 50));
        jLabel4.setHorizontalAlignment(JLabel.HORIZONTAL);

        jLabel5.setEnabled(true);
        jLabel5.setVisible(true);
        jLabel5.setOpaque(true);
        jLabel5.setText("Error information");
        jLabel5.setFont(new Font("Arial", Font.BOLD, 20));
        jLabel5.setBounds((200 / 2), 25, 250, 50);
        jLabel5.setSize(new Dimension(250, 50));
        jLabel5.setHorizontalAlignment(JLabel.HORIZONTAL);

        jLabel6.setEnabled(true);
        jLabel6.setVisible(true);
        jLabel6.setOpaque(true);
        jLabel6.setText("Results information");
        jLabel6.setFont(new Font("Arial", Font.BOLD, 20));
        jLabel6.setBounds(100, 25, 250, 50);
        jLabel6.setSize(new Dimension(250, 50));
        jLabel6.setHorizontalAlignment(JLabel.HORIZONTAL);

        jPanel_1.setBounds(0, 0, 400, 600);
        jPanel_2.setBounds(0, 0, 400, 600);
        jPanel_3.setBounds(0, 0, 400, 600);

        jPanel_1.setLayout(null);
        jPanel_2.setLayout(null);
        jPanel_3.setLayout(null);

        jPanel_1.add(jLabel1);
        jPanel_1.add(jLabel3);
        jPanel_1.add(jTextArea);

        jPanel_1.add(jLabel2);
        jPanel_1.add(jLabel4);
        jPanel_1.add(jTextField);

        jPanel_2.add(jLabel5);
        jPanel_2.add(jTextErrorArea);
        jPanel_2.add(jButton);

        jPanel_3.add(jLabel6);
        jPanel_3.add(jTextResultArea);

        this.add(jPanel_1);
        this.add(jPanel_2);
        this.add(jPanel_3);

        this.results = "";

        size_individuals = names.length;
        individuals = new ArrayList<>();

        this.setEnabled(true);
        this.setVisible(true);

        fill_Individuals();
    }

    public void fill_Individuals()
    {
        for(int i = 0; i < size_individuals; i++ )
        {
            individuals.add(new Individual(names[i], rates[i]));
        }
    }

    public int getNumber_of_teams()
    {
        return this.number_of_teams;
    }

    public int getSize_individuals()
    {
        return this.size_individuals;
    }

    public Individual getIndividualsElement(int i)
    {
        return individuals.get(i);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        String text = this.jTextArea.getText();
        String text1 = this.jTextField.getText();

        ArrayList<String> text2;

            if ((text.isEmpty() == false)
                    && (e.getSource() == jButton
                    && text1.isEmpty() == false))
            {
                String newline = System.getProperty("line.separator");

                String[] words = text.split("\"");

                for(String i : words)
                {
                    i = i.strip();
                    i = i.trim();

                    i = i.replace(newline, "");
                    i = i.replace(" ", "");
                    i = i.replace(",", "");
                }

                text2 = new ArrayList<String>(List.of(words));

                text2.removeIf(i -> i.isEmpty() || i.isBlank());

                for(int i = 0; i < text2.size(); i++)
                {
                    String tmp = text2.get(i);

                    tmp = tmp.strip();
                    tmp = tmp.trim();

                    tmp = tmp.replace(newline, "");
                    tmp = tmp.replace(" ", "");
                    tmp = tmp.replace(",", "");

                    text2.set(i, tmp);

                }

                for(int i = 0; i < text2.size(); i+= 2)
                {
                    try
                    {
                        Integer.parseInt(text2.get(i + 1));
                    }
                    catch(ArrayIndexOutOfBoundsException ex)
                    {
                        jTextErrorArea.setText("Bad data for number field");
                        jTextResultArea.setText("");
                        throw new RuntimeException("Bad data for number field");
                    }
                    catch(NumberFormatException ex)
                    {
                        jTextErrorArea.setText("Bad data");
                        jTextResultArea.setText("");
                        throw new RuntimeException("Bad data");
                    }
                }

                try
                {
                    this.number_of_teams = Integer.parseInt(text1);
                }
                catch (NumberFormatException ex)
                {
                    jTextErrorArea.setText("Bad value. Choose between 1 to number of the records.");
                    jTextResultArea.setText("");
                    System.out.println("Bad value. Choose between 1 to number of the records.");
                }

                if((this.number_of_teams <= 0) || (this.number_of_teams > individuals.size()))
                {
                    try
                    {
                        jTextErrorArea.setText("Bad value. Choose between 1 to number of the records.");
                        jTextResultArea.setText("");
                        throw new CustomException("Bad value. Choose between 1 to number of the records.");
                    }
                    catch (CustomException ex)
                    {
                        jTextErrorArea.setText("Bad value. Choose between 1 to number of the records.");
                        jTextResultArea.setText("");
                        throw new RuntimeException(ex);
                    }
                }

                this.number_of_teams = Integer.parseInt(text1);

                individuals.clear();


                for(int i = 0; i < text2.size(); i+= 2)
                {
                    try
                    {
                        individuals.add(new Individual(text2.get(i), Integer.parseInt(
                                text2.get(i + 1))));
                    }
                    catch (NumberFormatException ex)
                    {
                        jTextErrorArea.setText("Bad value in the records.");
                        jTextResultArea.setText("");
                        throw new RuntimeException(ex);
                    }

                }

                this.size_individuals = individuals.size();

                jTextErrorArea.setText("");

                Main.output_results(this);

                print_Results();

            }
    }

    public void setResults(String results)
    {
        this.results = results;
    }

    public void print_Results()
    {
        jTextResultArea.setText("");
        jTextResultArea.setText(results);
    }
}
