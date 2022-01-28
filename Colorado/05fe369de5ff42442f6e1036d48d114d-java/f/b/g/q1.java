package f.b.g;

public class q1 extends RuntimeException {
    public q1() {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }
}
