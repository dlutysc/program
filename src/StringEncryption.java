import java.util.*;

public class StringEncryption {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String key = sc.nextLine();
            String str = sc.nextLine();
            String key1 = key.toUpperCase();
            Set<Character> set = new LinkedHashSet<>();
            for(int i = 0; i < key1.length(); ++i){
                set.add(key1.charAt(i));
            }
            char ch = 'A';
            ArrayList<Character> list = new ArrayList<>();
            for(int i = 0; i < 26; ++i){
                list.add(ch);
                ch++;
            }
            for (Character c : list){
                set.add(c);
            }

            Map<Character, Character> map = new HashMap<>();
            for (int i = 0; i < 26; ++i){
                Object[] chars = set.toArray();
                map.put(list.get(i), (Character) chars[i]);
            }

            ArrayList<Character> res = new ArrayList();
            for (int i = 0; i < str.length(); ++i){
                char c = str.charAt(i);
                if (Character.isLetter(c)){
                    res.add(map.get(Character.toUpperCase(c)));
                }else {
                    res.add(c);
                }
            }

            for (int i = 0; i < str.length(); i++) {
                if (Character.isLowerCase(str.charAt(i))){
                    System.out.print(Character.toLowerCase(res.get(i)));
                }else {
                    System.out.print(res.get(i));
                }
            }
        }

    }
}
