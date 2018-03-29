import com.codecool.hashmap.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        System.out.println(hashMap.toString());
        hashMap.add("Hello", 12);
        hashMap.add("ello", 123);
        hashMap.add("Hell", 1223);
        hashMap.add("Hllo", 132);
        hashMap.add("Helo", 122);
        hashMap.add("llo", 162);
        hashMap.add("Hlo", 102);
        hashMap.add("Heo", 172);
        hashMap.add("Hel", 129);
        hashMap.add("lo", 182);
        hashMap.add("Ho", 1892);
        System.out.println(hashMap.toString());
        System.out.println(hashMap.getValue("Hello"));
        System.out.println(hashMap.getValue("Hel"));
        hashMap.remove("Hello");
        System.out.println(hashMap.toString());

    }
}
