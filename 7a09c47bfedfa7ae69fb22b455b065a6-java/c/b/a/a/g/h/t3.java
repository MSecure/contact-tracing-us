package c.b.a.a.g.h;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class t3 extends r3<FieldDescriptorType, Object> {
    public t3(int i) {
        super(i, null);
    }

    @Override // c.b.a.a.g.h.r3
    public final void g() {
        if (!this.f4021e) {
            for (int i = 0; i < h(); i++) {
                Map.Entry e2 = e(i);
                if (((l1) e2.getKey()).w()) {
                    e2.setValue(Collections.unmodifiableList((List) e2.getValue()));
                }
            }
            for (Map.Entry entry : i()) {
                if (((l1) entry.getKey()).w()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.g();
    }
}
