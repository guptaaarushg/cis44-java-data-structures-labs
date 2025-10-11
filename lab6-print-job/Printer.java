interface Queue<E> {
    void enqueue(E item);
    E dequeue();
    boolean isEmpty();
}

class LinkedQueue<E> implements Queue<E> {
    private static class Node<E> {
        E data;
        Node<E> next;
        Node(E data) {
            this.data = data;
        }
    }

    private Node<E> front;
    private Node<E> rear;

    @Override
    public void enqueue(E item) {
        Node<E> newNode = new Node<>(item);
        if (rear != null) {
            rear.next = newNode;
        }
        rear = newNode;
        if (front == null) {
            front = rear;
        }
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E item = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return item;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }
}

class PrintJob {
    private String documentName;
    private int pageCount;

    public PrintJob(String documentName, int pageCount) {
        this.documentName = documentName;
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        return "PrintJob[Document: " + documentName + ", Pages: " + pageCount + "]";
    }
}

public class Printer {
    private Queue<PrintJob> jobQueue;

    public Printer() {
        jobQueue = new LinkedQueue<>();
    }

    public void addJob(PrintJob job) {
        System.out.println("Adding to queue: " + job);
        jobQueue.enqueue(job);
    }

    public void processNextJob() {
        if (jobQueue.isEmpty()) {
            System.out.println("No jobs left in the queue. The queue is empty.");
        } else {
            PrintJob job = jobQueue.dequeue();
            System.out.println("Processing: " + job);
        }
    }

    public static void main(String[] args) {
        Printer officePrinter = new Printer();

        officePrinter.addJob(new PrintJob("Annual_Report.pdf", 25));
        officePrinter.addJob(new PrintJob("Meeting_Agenda.docx", 2));
        officePrinter.addJob(new PrintJob("Presentation_Slides.pptx", 30));

        System.out.println("\n--- Starting to Print ---");
        officePrinter.processNextJob();
        officePrinter.processNextJob();

        System.out.println("\nNew high-priority job arrives...");
        officePrinter.addJob(new PrintJob("Urgent_Memo.pdf", 1));

        officePrinter.processNextJob();
        officePrinter.processNextJob();
        officePrinter.processNextJob();
    }
}
