package f.b.c.k.s;

public abstract class i {

    public enum a {
        LESS_THAN("<"),
        LESS_THAN_OR_EQUAL("<="),
        EQUAL("=="),
        NOT_EQUAL("!="),
        GREATER_THAN(">"),
        GREATER_THAN_OR_EQUAL(">="),
        ARRAY_CONTAINS("array_contains"),
        ARRAY_CONTAINS_ANY("array_contains_any"),
        IN("in"),
        NOT_IN("not_in");
        
        public final String b;

        /* access modifiers changed from: public */
        a(String str) {
            this.b = str;
        }

        public String toString() {
            return this.b;
        }
    }

    public abstract String a();
}
