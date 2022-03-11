package f.d.b;

import androidx.recyclerview.widget.RecyclerView;
import f.d.b.k;
import java.util.List;
/* loaded from: classes.dex */
public interface l<Item extends k<? extends RecyclerView.b0>> {
    void a(List<? extends Item> list, int i2);

    void b(List<? extends Item> list, int i2, f fVar);

    List<Item> c();

    void d(int i2);

    Item get(int i2);

    int size();
}
