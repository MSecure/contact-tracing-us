package e.j.g;

import e.f.h;
import e.j.g.j;
import e.j.i.a;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i implements a<j.a> {
    public final /* synthetic */ String a;

    public i(String str) {
        this.a = str;
    }

    /* renamed from: b */
    public void a(j.a aVar) {
        synchronized (j.c) {
            h<String, ArrayList<a<j.a>>> hVar = j.f1595d;
            ArrayList<a<j.a>> arrayList = hVar.get(this.a);
            if (arrayList != null) {
                hVar.remove(this.a);
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    arrayList.get(i2).a(aVar);
                }
            }
        }
    }
}
