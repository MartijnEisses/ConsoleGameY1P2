import java.util.*;
import java.io.*;

// Reads the file and saves it to a list
public class TextFromFile {

    private static Map<Integer, String> textLines = new HashMap<Integer, String>();

    public TextFromFile() {
        GetTextFromFile("textfile.txt");
    }

    private void GetTextFromFile(String path) {
        try {
            File file = new File(path); // Creates a new file instance
            FileReader fr = new FileReader(file); // Reads the file
            BufferedReader br = new BufferedReader(fr); // Creates a buffering character input stream
            String line = "";
            while ((line = br.readLine()) != null) {
                SplitString(line);
            }
            fr.close(); // Closes the stream and release the resources
        } catch (IOException e) {
            // Sends an error when the file could not be read
            e.printStackTrace();
        }
    }

    // Splits the string and adds it to the map
    private void SplitString(String line) {
        String[] splittedLine = line.split("-");
        AddLineToDictionary(Integer.parseInt(splittedLine[0]), splittedLine[1]);
    }

    private void AddLineToDictionary(Integer key, String value) {
        if (textLines.containsKey(key)) {
            System.out.println(key + "  Already exists");
        }
        textLines.put(key, value);
    }

    public static String GetLine(Integer key) {
        if (textLines.containsKey(key)) {
            return textLines.get(key);
        } else
            return "INCORRECT KEY";
    }
}