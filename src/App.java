import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.HashMap;

public class App {


    public static void main(String[] args) {

        //StringBuilder concatenated = new StringBuilder();
        HashMap<String, Character> hashMap = new HashMap<>();
        LinkedList<Character> linkedList = new LinkedList<>();

        hashMap.put("AD", 'N');
        hashMap.put("AN", 'D');
        hashMap.put("DA", 'N');
        hashMap.put("DN", 'A');
        hashMap.put("NA", 'D');
        hashMap.put("ND", 'A');




        try{
            FileReader reader = new FileReader("testes\\testecurto.txt");
            int element1;

            while ((element1 = reader.read()) != -1) {
                char character1 = (char) element1;
                int element2 = reader.read();

                String a;
                if(element2 != -1){
                    char character2 = (char) element2;
                    //concatenated.append(character1).append(character2);
                    a = Character.toString(character1)+ Character.toString(character2);
                    System.out.println(a.toString());
                }
                else
                {
                    a = Character.toString(character1);
                    //concatenated.append(character1);
                }

            
                //String str = concatenated.toString();
                //System.out.println(str);
                if(hashMap.containsKey(a)){
                    char value = hashMap.get(a);
                    System.out.println(value);
                    linkedList.add(value);
                    System.out.println(linkedList.toString());
                }
                else
                {
                    for(char c : a.toCharArray()){
                        linkedList.add(c);
                    }
                }
                //linkedList.add(character);
                
            }
            reader.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        /*for (Character character : linkedList) {
            System.out.print(character);
        }*/
    }
}
