
public class Test {
    public static void main(String[] args) {
        HashMap<String, Integer> myMap = new HashMap<>();

        myMap.put("Baguette", 7);
        System.out.println(myMap);
        myMap.put("Bagkfdgfde", 26);
        myMap.put("Bague32523e", 75);
        myMap.put("Baghdruite", 71);
        myMap.put("Marian", 20);
        myMap.put("Bafje", 12);
        myMap.put("Emilus", 3);
        System.out.println(myMap);

        System.out.println(myMap.get("Bafje"));
        System.out.println(myMap.get("NoName"));
        System.out.println(myMap.get("Bague32523e"));

        myMap.remove("Baguette");
        System.out.println(myMap);

        myMap.remove("Bague32523e");
        System.out.println(myMap);

        myMap.remove("Bafje");
        System.out.println(myMap);

        myMap.remove("Emilus");
        System.out.println(myMap);

        myMap.remove("cykasdsad");
        System.out.println(myMap);
    }
}