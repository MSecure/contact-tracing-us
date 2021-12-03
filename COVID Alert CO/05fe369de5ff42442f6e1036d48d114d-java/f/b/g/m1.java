package f.b.g;

import f.b.g.v;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class m1 extends n1<FieldDescriptorType, Object> {
    public m1(int i2) {
        super(i2, null);
    }

    @Override // f.b.g.n1
    public void g() {
        if (!this.f3610e) {
            for (int i2 = 0; i2 < d(); i2++) {
                Map.Entry c = c(i2);
                if (((v.a) c.getKey()).d()) {
                    c.setValue(Collections.unmodifiableList((List) c.getValue()));
                }
            }
            for (Map.Entry entry : e()) {
                if (((v.a) entry.getKey()).d()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.g();
    }

    @Override // java.util.AbstractMap, f.b.g.n1, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((v.a) obj, obj2);
    }
}
