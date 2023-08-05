import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.HashMap;

public class App {


    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        LinkedList<Character> linkedList = new LinkedList<>();

        try{
            FileReader reader = new FileReader("testes\\caso0010.txt");
            int element;

            while ((element = reader.read()) != -1) {
                char character = (char) element;
                linkedList.add(character);
                
            }
            reader.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        for (Character character : linkedList) {
            System.out.print(character);
        }
    }
}
