package f.b.c.k.s;

import f.b.a.c.b.o.b;

public class d0 {
    public int a;
    public int b;

    public d0(int i2, int i3) {
        boolean z = true;
        b.O0((i2 & 1) == i2, "Generator ID %d contains more than %d reserved bits", Integer.valueOf(i2), 1);
        this.b = i2;
        b.O0((i3 & 1) != i2 ? false : z, "Cannot supply target ID from different generator ID", new Object[0]);
        this.a = i3;
    }
}
