import java.util.*;

public class HashMap<K, V> {
    private HashMapNode<K, V>[] myMap = new HashMapNode[10];
    private int indexFound = -1;
    private int size=0;

    private HashSet<K> keySet= new HashSet<>();
    private LinkedList<V> values= new LinkedList<>();


    public void put(K key, V value) {
        keySet.add(key);
        values.add(value);
        HashMapNode<K, V> entry = new HashMapNode(key, value, null);
        int index = entry.index();

        if (myMap[index] == null) {
            myMap[index] = entry;
        } else {
            if (myMap[index].next != null) {
                HashMapNode currentNode = myMap[index];
                do {
                    currentNode = currentNode.next;

                } while (currentNode.next != null);

                currentNode.next = entry;
            } else {
                myMap[index].next = entry;
            }
        }

        size++;

    }

    public V get(K key) {
        for (int i = 0; i < myMap.length; i++) {
            if (myMap[i] != null) {
                if (myMap[i].getKey() == key) {
                    indexFound = i;
                    return myMap[i].getValue();
                }

                HashMapNode<K, V> currentNode = myMap[i];

                if (currentNode.next != null) {
                    do {
                        currentNode = currentNode.next;

                        if (currentNode.getKey() == key) {
                            indexFound = i;
                            return currentNode.getValue();
                        }
                    } while (currentNode.next != null);
                }
            }
        }

        return null;
    }

    public void remove(K key) {
        keySet.remove(key);

        V value = get(key);
        values.remove(value);

        if (value == null) return;

        if (myMap[indexFound].getKey() == key) {

            if (myMap[indexFound].next == null) {
                myMap[indexFound] = null;
            } else {
                myMap[indexFound] = myMap[indexFound].next;
            }

        } else {
            HashMapNode currentNode = myMap[indexFound];
            HashMapNode previousNode = myMap[indexFound];

            do {
                currentNode = currentNode.next;
                if (currentNode.getKey() == key) {
                    if (currentNode.next == null) {
                        previousNode.next = null;
                        currentNode = null;
                    } else {
                        previousNode.next = currentNode.next;
                        currentNode = null;
                    }
                }
                previousNode = previousNode.next;
            } while (currentNode != null);
        }
        size--;
    }

    public void clear(){
        for(HashMapNode node: myMap){
            node=null;
            size=0;
        }
    }

    public int size(){
        return size;
    }

    public HashSet<K> keySet(){
        return keySet;
    }

    public LinkedList<V> values(){
        return values;
    }

    @Override
    public String toString() {
        String s = "{";
        for (int i = 0; i < myMap.length; i++) {
            if (myMap[i] != null) {
                if (s == "{") {
                    s += myMap[i].getKey() + "=" + myMap[i].getValue();
                } else {
                    s += ", " + myMap[i].getKey() + "=" + myMap[i].getValue();
                }

                HashMapNode currentNode = myMap[i];
                if (currentNode.next != null) {
                    do {
                        currentNode = currentNode.next;
                        s += ", " + currentNode.getKey() + "=" + currentNode.getValue();
                    } while (currentNode.next != null);
                }
            }
        }
        s += "}";
        return s;
    }
}