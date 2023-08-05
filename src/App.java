import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;
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

        for (Character character : linkedList) {
            System.out.print(character);
        }
        System.out.println("\n");
    AddHash(hashMap, linkedList);

    }

    public static LinkedList<Character> AddHash(HashMap<String, Character> hash, LinkedList<Character> linkedList) {
        LinkedList<Character> begin = new LinkedList<>();
        LinkedList<Character> end = new LinkedList<>();

        for (int i = 0; i < linkedList.size()-1;i++) {
            char a = linkedList.get(i);
            char b = linkedList.get(i + 1);

            String str = Character.toString(b) + Character.toString(a);

            if (hash.containsKey(str)) {
                char value = hash.get(str);
                end.addLast(value);
                i++;
                // if(i>=linkedList.size()){
                //     begin.addLast(linkedList.getLast());
                // }

            } else {
                begin.addLast(a);
            }

        }

        System.out.println("\n");
        begin.addAll(end);
        for (Character character : begin) {
            System.out.print(character);
        }
        if(!allSame(begin)){
            AddHash(hash, begin);
        }
        return begin;
    }

    public static boolean allSame(LinkedList<Character> list) {
        char first = list.getFirst();
        ListIterator<Character> iterator = list.listIterator(1);
        if (list.getFirst() != list.getLast()) {
            return false;
        }

        while (iterator.hasNext()) {
            if (!iterator.next().equals(first)) {
                return false;
            }
        }
        return true;
    }
}
