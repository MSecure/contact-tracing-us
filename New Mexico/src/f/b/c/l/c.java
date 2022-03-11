package f.b.c.l;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public enum a {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);
        
        public final int b;

        a(int i2) {
            this.b = i2;
        }
    }

    a a(String str);
}
