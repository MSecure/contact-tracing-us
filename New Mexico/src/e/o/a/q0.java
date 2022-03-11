package e.o.a;

import android.view.View;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class q0 implements Runnable {
    public final /* synthetic */ Object b;
    public final /* synthetic */ v0 c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View f1845d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ m f1846e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1847f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1848g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1849h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f1850i;

    public q0(Object obj, v0 v0Var, View view, m mVar, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
        this.b = obj;
        this.c = v0Var;
        this.f1845d = view;
        this.f1846e = mVar;
        this.f1847f = arrayList;
        this.f1848g = arrayList2;
        this.f1849h = arrayList3;
        this.f1850i = obj2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj = this.b;
        if (obj != null) {
            this.c.o(obj, this.f1845d);
            this.f1848g.addAll(t0.h(this.c, this.b, this.f1846e, this.f1847f, this.f1845d));
        }
        if (this.f1849h != null) {
            if (this.f1850i != null) {
                ArrayList<View> arrayList = new ArrayList<>();
                arrayList.add(this.f1845d);
                this.c.p(this.f1850i, this.f1849h, arrayList);
            }
            this.f1849h.clear();
            this.f1849h.add(this.f1845d);
        }
    }
}
