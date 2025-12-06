import java.util.ArrayList;
import java.util.LinkedList;

interface MapADT<K, V> {
    V get(K key);
    V put(K key, V value);
    V remove(K key);
    int size();
    boolean isEmpty();
}

class MapEntry<K, V> {
    private K key;
    private V value;

    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }
    public void setValue(V value) { this.value = value; }

    public String toString() {
        return key + "=" + value;
    }
}

class SeparateChainingMap<K, V> implements MapADT<K, V> {
    private ArrayList<LinkedList<MapEntry<K, V>>> table;
    private int size = 0;
    private final int N = 11;

    public SeparateChainingMap() {
        table = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            table.add(new LinkedList<>());
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % N);
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public V get(K key) {
        int h = hash(key);
        LinkedList<MapEntry<K, V>> bucket = table.get(h);
        for (MapEntry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) return entry.getValue();
        }
        return null;
    }

    public V put(K key, V value) {
        int h = hash(key);
        LinkedList<MapEntry<K, V>> bucket = table.get(h);
        for (MapEntry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                V oldValue = entry.getValue();
                entry.setValue(value);
                return oldValue;
            }
        }
        bucket.addFirst(new MapEntry<>(key, value));
        size++;
        return null;
    }

    public V remove(K key) {
        int h = hash(key);
        LinkedList<MapEntry<K, V>> bucket = table.get(h);
        for (MapEntry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                bucket.remove(entry);
                size--;
                return entry.getValue();
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[\n");
        for (int i = 0; i < N; i++) {
            sb.append(i).append(": ").append(table.get(i)).append("\n");
        }
        return sb.append("]").toString();
    }
}

class TestMap {
    public static void main(String[] args) {
        SeparateChainingMap<String, Integer> map = new SeparateChainingMap<>();

        String key1 = "Aa";
        String key2 = "BB";
        String key3 = "Cc";

        map.put(key1, 10);
        map.put(key2, 20);
        map.put(key3, 30);

        map.put("X", 100);
        map.put("Y", 200);

        System.out.println(map);

        System.out.println("get(" + key1 + "): " + map.get(key1));
        System.out.println("get(" + key2 + "): " + map.get(key2));
        System.out.println("get(" + key3 + "): " + map.get(key3));

        map.put(key2, 999);
        System.out.println("get(" + key2 + ") after update: " + map.get(key2));

        System.out.println("remove(" + key1 + "): " + map.remove(key1));
        System.out.println("get(" + key1 + "): " + map.get(key1));

        System.out.println("\nFinal map:");
        System.out.println(map);
        System.out.println("Size = " + map.size());
    }
}

