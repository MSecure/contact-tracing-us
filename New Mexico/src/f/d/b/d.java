package f.d.b;

import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import f.d.b.k;
import java.util.List;
/* loaded from: classes.dex */
public interface d<Item extends k<? extends RecyclerView.b0>> {
    boolean a(View view, MotionEvent motionEvent, int i2, b<Item> bVar, Item item);

    void b(int i2, int i3);

    boolean c(View view, int i2, b<Item> bVar, Item item);

    void d(int i2, int i3, Object obj);

    void e(CharSequence charSequence);

    boolean f(View view, int i2, b<Item> bVar, Item item);

    void g(int i2, int i3);

    void h();

    void i(List<? extends Item> list, boolean z);
}
