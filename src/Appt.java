import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.time.Instant;
import java.time.Duration;

public class Appt {

    public static void main(String[] args) {
        Instant start = Instant.now();

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
            System.out.println("\n");
            System.out.println("Tamanho inicial da lista: " + list.size());
            //list.print();
            list.mutacao(hashMap);
            list.print();
            System.out.print("\n");
            System.out.println("Tamanho final da lista: \0" + list.size());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Tempo de execução: " + timeElapsed.toMillis() + " milissegundos");
        System.out.println("\nNão fui genial, prof?");
    }
}