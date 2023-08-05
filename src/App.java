import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.HashMap;

public class App 
{


    public static void main(String[] args) 
    {

        HashMap<String, Character> hashMap = new HashMap<>();
        LinkedList<Character> linkedList = new LinkedList<>();

        hashMap.put("AD", 'N');
        hashMap.put("AN", 'D');
        hashMap.put("DA", 'N');
        hashMap.put("DN", 'A');
        hashMap.put("NA", 'D');
        hashMap.put("ND", 'A');


        try
        {
            FileReader reader = new FileReader("testes\\caso0010.txt");
            int element1;
            int count=0;

            while ((element1 = reader.read()) != -1) 
            {
                char character1 = (char) element1;
                int element2 = reader.read();

                String a;
                if(element2 != -1)
                {
                    char character2 = (char) element2;
                    a = Character.toString(character1)+ Character.toString(character2);
                }
                else
                {
                    a = Character.toString(character1);
                }

                if(hashMap.containsKey(a))
                {
                    char value = hashMap.get(a);
                    linkedList.add(value);
                    count++;

                }
                else
                {
                    for(char c : a.toCharArray())
                    {
                        linkedList.add(c);
                        count++;
                    }
                }
            }
            reader.close();
            System.out.println(count);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        //mostra quantos há na fila
        /*for (Character character : linkedList) 
        {
            System.out.print(character);
        }*/

    }
}
