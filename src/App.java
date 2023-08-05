import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.HashMap;

public class App {

    public static void main(String[] args) {

        HashMap<String, Character> hashMap = new HashMap<>();
        LinkedList<Character> linkedList = new LinkedList<>();

        hashMap.put("AD", 'N');
        hashMap.put("AN", 'D');
        hashMap.put("DA", 'N');
        hashMap.put("DN", 'A');
        hashMap.put("NA", 'D');
        hashMap.put("ND", 'A');

        try {
            FileReader reader = new FileReader("testes\\testecurto.txt");
            int element1;
            int count = 0;

            while ((element1 = reader.read()) != -1) {
                char character1 = (char) element1;
                int element2 = reader.read();

                String a;
                if (element2 != -1) {
                    char character2 = (char) element2;
                    a = Character.toString(character1) + Character.toString(character2);
                } else {
                    a = Character.toString(character1);
                }
                ////
                if (hashMap.containsKey(a)) {
                    char value = hashMap.get(a);
                    linkedList.add(value);
                    count++;

                } else {
                    for (char c : a.toCharArray()) {
                        linkedList.add(c);
                        count++;
                    }
                }
            }
            reader.close();
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // mostra quantos há na fila
        for (Character character : linkedList) {
            System.out.print(character);
        }
        System.out.println("\n");
        AddHash(hashMap, linkedList);

    }

    public static void AddHash(HashMap<String, Character> hash, LinkedList<Character> linkedList) {
        boolean allSame = false;


            for (int i = 0; i < linkedList.size(); i += 2) {
                for (int j = i+1; j<linkedList.size(); j+=2) {
                    char a = linkedList.get(i);
                    char b = linkedList.get(j);

                    String str = Character.toString(a) + Character.toString(b);

                    if (hash.containsKey(str)) {
                        char value = hash.get(str);
                        linkedList.addLast(value);
                        linkedList.remove(i);
                        linkedList.remove(i); // Remove i novamente para atualizar o índice corretamente
                        allSame = checkAllSame(linkedList);
                    } else {
                        for (char c : str.toCharArray()) {
                            linkedList.addLast(c);
                        }
                        linkedList.remove(i);
                        linkedList.remove(i); // Remove i novamente para atualizar o índice corretamente
                        allSame = checkAllSame(linkedList);

                    }
                    
                }
                

            }

        
            allSame = checkAllSame(linkedList);
            if (allSame) {
                for (Character character : linkedList) {
                    System.out.print(character);
                }
            }
            for (Character character : linkedList) {
                    System.out.print(character);
                }

        }
    
    public static boolean checkAllSame(LinkedList<Character> list) {
        if (list.isEmpty()) {
            return false;
        }
        
        char firstChar = list.get(0);
        
        for (char c : list) {
            if (c != firstChar) {
                return false;
            }
        }
        return true;
    }
}