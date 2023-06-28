import java.util.Scanner;

/**
 * Enables reading from stdin using a Scanner and
 * writing to stdout using print/println
 *
 * @author
 */
public class InteractiveCLI {

    private Scanner reader;

    public InteractiveCLI() {
        reader = new Scanner(System.in);
    }

    /**
     * Reads from stdin.
     * fails quietly by returning 0
     * if value cannot be parsed to int
     *
     * @return integer entered if possible or 0
     */
    public int getKeyboardInteger(){
        if(reader.hasNextInt())
            return reader.nextInt();
        else
            return 0;
    }

    /**
     * Reads from stdin.
     * fails quietly by returning 0.0
     * if value cannot be parsed to double
     *
     * @return double entered if possible or 0.0
     */
    public double getKeyboardDouble(){
        if(reader.hasNextDouble())
            return reader.nextDouble();
        else
            return 0.0;
    }

    /**
     * Reads a line from stdin.
     *
     * @return line as String from stdin
     */
    public String getKeyboardString(){
        if(reader.hasNextLine())
            return reader.nextLine();
        else
            return "";
    }
    /**
     * Print string s as a prompt without a newline.
     * @param s
     */
    public void prompt(String s){
        System.out.print(s);
    }


    /**
     * Print string s as a message with newline.
     * @param s
     */
    public void display(String s){
        System.out.println(s);
    }

}

