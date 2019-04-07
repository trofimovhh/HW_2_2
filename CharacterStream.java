import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharacterStream {


    private static Pattern getPattern() {
        return Pattern.compile("byte|short|int|long|char|float|double|boolean|if|else|switch|" +
                "case|default|while|do|break|continue|for|try|catch|finally|throw|throws|private|protected|" +
                "public|import|package|class|interface|extends|implements|static|final|void|abstract|native|" +
                "new|return|this|super|synchronized|volatile|const|goto|instanceof|enum|assert|transient|strictfp");
    }

    static void keywordsSearcher(String fileName) {
        try {

            BufferedReader inFile = new BufferedReader(new FileReader(fileName));
            String readedString;
            StringBuffer stringsFromTestFile = new StringBuffer();

            while ((readedString = inFile.readLine()) != null) {
                stringsFromTestFile.append(readedString);
            }
            inFile.close();

            Matcher m = getPattern().matcher(stringsFromTestFile);
            FileWriter outFile = new FileWriter("keyWords.txt");
            String stringBuffer;
            int count = 0;

            while (m.find()) {
                stringBuffer = stringsFromTestFile.substring(m.start(), m.end()) + " ";
                outFile.write(stringBuffer);
                count++;
            }

            String words = "Keywords found: " + count;
            outFile.write(words);
            outFile.close();
            System.out.println("Keywords found: " + count);
        } catch (FileNotFoundException fileNotFound) {
            System.out.println("File not found");
            fileNotFound.printStackTrace();
        } catch (IOException ioException) {
            System.out.println("IOException");
            ioException.printStackTrace();
        }
    }
}
