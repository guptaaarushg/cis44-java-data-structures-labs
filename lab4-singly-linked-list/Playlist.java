public class Playlist {
    private class Node {
        Song song;
        Node next;

        Node(Song song) {
            this.song = song;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private Node current;

    public Playlist() {
        head = null;
        tail = null;
        current = null;
    }

    public void addSong(Song song) {
        Node newNode = new Node(song);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        if (current == null) current = head;
        System.out.println("Added: " + song);
    }

    public void removeSong(String title) {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        if (head.song.getTitle().equalsIgnoreCase(title)) {
            System.out.println("Removed: " + head.song);
            head = head.next;
            if (current == head) current = head;
            if (head == null) tail = null;
            return;
        }
        Node prev = head;
        Node temp = head.next;
        while (temp != null) {
            if (temp.song.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Removed: " + temp.song);
                prev.next = temp.next;
                if (temp == tail) tail = prev;
                if (current == temp) current = prev.next;
                return;
            }
            prev = temp;
            temp = temp.next;
        }
        System.out.println("Song not found.");
    }

    public void playNext() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        System.out.println("Now playing: " + current.song);
        current = (current.next != null) ? current.next : head;
    }

    public void displayPlaylist() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        System.out.println("\n--- Current Playlist ---");
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.song);
            temp = temp.next;
        }
        System.out.println("------------------------\n");
    }
}