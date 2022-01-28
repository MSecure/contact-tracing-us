package b.l.d;

import android.view.View;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

public class m0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f2067b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ r0 f2068c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View f2069d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Fragment f2070e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArrayList f2071f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ArrayList f2072g;
    public final /* synthetic */ ArrayList h;
    public final /* synthetic */ Object i;

    public m0(Object obj, r0 r0Var, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
        this.f2067b = obj;
        this.f2068c = r0Var;
        this.f2069d = view;
        this.f2070e = fragment;
        this.f2071f = arrayList;
        this.f2072g = arrayList2;
        this.h = arrayList3;
        this.i = obj2;
    }

    public void run() {
        Object obj = this.f2067b;
        if (obj != null) {
            this.f2068c.o(obj, this.f2069d);
            this.f2072g.addAll(p0.h(this.f2068c, this.f2067b, this.f2070e, this.f2071f, this.f2069d));
        }
        if (this.h != null) {
            if (this.i != null) {
                ArrayList<View> arrayList = new ArrayList<>();
                arrayList.add(this.f2069d);
                this.f2068c.p(this.i, this.h, arrayList);
            }
            this.h.clear();
            this.h.add(this.f2069d);
        }
    }
}
