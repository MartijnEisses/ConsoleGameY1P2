import java.util.Scanner;

public class InputReader {

    private Scanner reader;

    public InputReader() {
        reader = new Scanner(System.in);
    }

    public String GetInput() {
        System.out.print("> ");
        String inputLine = reader.nextLine();
        return inputLine;
    }
}