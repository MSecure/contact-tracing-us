package f.b.c.k.s;
/* loaded from: classes.dex */
public abstract class i {

    /* loaded from: classes.dex */
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

        a(String str) {
            this.b = str;
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return this.b;
        }
    }

    public abstract String a();
}
