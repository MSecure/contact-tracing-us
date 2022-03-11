package f.d.b.p;

import androidx.recyclerview.widget.RecyclerView;
import f.d.b.k;
import f.d.b.s.h$a;
import j.k.b.e;
import j.k.b.i;
/* loaded from: classes.dex */
public class a<Item extends k<? extends RecyclerView.b0>> extends c<Item, Item> {
    /* JADX WARN: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public a() {
        super(r0);
        h$a h_a = h$a.c;
        if (h_a.b() == 1) {
            return;
        }
        ClassCastException classCastException = new ClassCastException(f.a.a.a.a.c(h$a.class.getName(), " cannot be cast to ", "kotlin.jvm.functions.Function1"));
        e.d(classCastException, i.class.getName());
        throw classCastException;
    }
}
