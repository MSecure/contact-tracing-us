package c.b.a.a.g.b;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class y2 extends x2<FieldDescriptorType, Object> {
    public y2(int i) {
        super(i, null);
    }

    @Override // c.b.a.a.g.b.x2
    public final void j() {
        if (!this.f3468e) {
            for (int i = 0; i < f(); i++) {
                Map.Entry d2 = d(i);
                if (((t0) d2.getKey()).M()) {
                    d2.setValue(Collections.unmodifiableList((List) d2.getValue()));
                }
            }
            for (Map.Entry entry : g()) {
                if (((t0) entry.getKey()).M()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.j();
    }
}
