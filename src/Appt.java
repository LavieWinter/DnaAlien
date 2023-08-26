import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Appt {

    public static void main(String[] args) {

        HashMap<String, Character> hashMap = new HashMap<>();
        MyLinkedList list = new MyLinkedList();

        hashMap.put("AD", 'N');
        hashMap.put("AN", 'D');
        hashMap.put("DA", 'N');
        hashMap.put("DN", 'A');
        hashMap.put("NA", 'D');
        hashMap.put("ND", 'A');

        try {
            FileReader reader = new FileReader("testes\\caso2000.txt");
            int element1;

            while ((element1 = reader.read()) != -1) {
                char character1 = (char) element1;
                if(character1 != '\n') list.add(character1);
            }
            reader.close();
            System.out.println(list.size());
            //list.print();
            list.mutacao(hashMap);
            System.out.println("\n");
            list.print();
            System.out.println("\n");
            System.out.println(list.size());
            System.out.println("\nNunca fui triste");
            
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("\n");

    }
}