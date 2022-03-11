package f.b.g;

import f.b.g.v;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class m1 extends n1<FieldDescriptorType, Object> {
    public m1(int i2) {
        super(i2, null);
    }

    @Override // f.b.g.n1
    public void g() {
        if (!this.f3929e) {
            for (int i2 = 0; i2 < d(); i2++) {
                Map.Entry<FieldDescriptorType, Object> c = c(i2);
                if (((v.a) c.getKey()).d()) {
                    c.setValue(Collections.unmodifiableList((List) c.getValue()));
                }
            }
            Iterator it = e().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (((v.a) entry.getKey()).d()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.g();
    }

    @Override // f.b.g.n1, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((v.a) obj, obj2);
    }
}
