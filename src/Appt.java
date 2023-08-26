import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.HashMap;
import java.util.LinkedList;

public class Appt {

    public static void main(String[] args) {

        HashMap<String, Character> hashMap = new HashMap<>();
        ArrayList<Character> arrayList = new ArrayList<>();
        LinkedList<Character> list = new LinkedList<>();

        hashMap.put("AD", 'N');
        hashMap.put("AN", 'D');
        hashMap.put("DA", 'N');
        hashMap.put("DN", 'A');
        hashMap.put("NA", 'D');
        hashMap.put("ND", 'A');

        try {
            FileReader reader = new FileReader("testes\\testecurto.txt");
            int element1;

            while ((element1 = reader.read()) != -1) {
                char character1 = (char) element1;
                arrayList.add(character1);
            }
            reader.close();
            System.out.println(arrayList.size());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Character character : arrayList) {
            System.out.print(character);
        }
        System.out.println("\n");
        mutation(hashMap, arrayList);

    }

    public static ArrayList<Character> mutation(HashMap<String, Character> hash, ArrayList<Character> dnaSequence) {
        ArrayList<Character> begin = new ArrayList<>();
        ArrayList<Character> end = new ArrayList<>();
        int i = 0;
        int k = 1;
        while (i < dnaSequence.size()) {
            char b = 0;
            char a = 0;
            try {
                a = dnaSequence.get(i);
                b = dnaSequence.get(k);
                if (b == '\n') {
                    System.out.println("quebra");
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                begin.add(a);
                break;
            }

            catch (Exception e) {
                System.out.println("Erro getting chars");
                System.out.println(e.toString());
            }
            if (a != b) {
                String str = Character.toString(a) + Character.toString(b);
                char value = hash.get(str);
                end.add(value);
                i = k + 1;
                k = k + 2;

            } else {
                begin.add(a);
                i++;
                k++;
            }
            begin.addAll(end);
            System.out.println(begin);
            if (allSame(begin)) {
                return begin;
            }
            dnaSequence = begin;

        }
        return begin;
    }

    public static ArrayList<Character> addHash(HashMap<String, Character> hash, ArrayList<Character> arrayList) {
        ArrayList<Character> begin = new ArrayList<>();
        ArrayList<Character> end = new ArrayList<>();
        int aux = 1;

        try {
            for (int i = aux - 1; i < arrayList.size() - 1; i++) {
                char a = arrayList.get(i);
                char b = arrayList.get(i + 1);

                String str = Character.toString(b) + Character.toString(a);

                if (hash.containsKey(str)) {
                    char value = hash.get(str);
                    end.add(value);
                    aux = i;
                    i++;
                    if (i == arrayList.size() - 2) {
                        begin.add(arrayList.get(i + 1));
                    }

                } else {
                    begin.add(a);
                }
                if (i == arrayList.size() - 2) {
                    begin.add(arrayList.get(i + 1));
                }

            }

            begin.addAll(end);
            // for (Character character : begin) {
            // System.out.print(character);
            // }
            // System.out.println("\n");
            ListIterator<Character> iterator = begin.listIterator();
            int lineNumber = 1;
            while (iterator.hasNext()) {
                char c = iterator.next();
                if (c == '\n' || c == '\r' || c == '\0') {
                    iterator.remove(); // Remove a quebra de linha
                    System.out.println("Quebra de linha removida da linha " + lineNumber);
                    break; // Se já encontrou e removeu uma quebra de linha, não precisa continuar
                           // procurando
                }
                lineNumber++;
            }

            if (!allSame(begin)) {
                try {

                    addHash(hash, begin);
                } catch (StackOverflowError e) {
                    System.out.println("StackOverflowError");
                    System.out.println("Tamanho da lista: " + begin.size());
                    System.out.println("Lista: ");
                    for (Character character : begin) {
                        System.out.print(character);
                    }

                }
            } else {
                for (Character character : begin) {
                    System.out.print(character);
                }
                return begin;

            }
        } catch (Exception e) {
            for (Character character : begin) {
                System.out.print(character);
            }

        }
        return begin;

    }

    public static boolean allSame(ArrayList<Character> list) {
        char first = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) != first) {
                return false;
            }
        }
        return true;
    }
}