package f.b.c.l;

public interface c {

    public enum a {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);
        
        public final int b;

        /* access modifiers changed from: public */
        a(int i2) {
            this.b = i2;
        }
    }

    a a(String str);
}
