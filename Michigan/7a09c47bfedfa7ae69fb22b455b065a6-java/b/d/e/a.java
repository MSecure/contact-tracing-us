package b.d.e;

import androidx.cardview.widget.CardView;

public class a implements c {
    public final d a(b bVar) {
        return (d) ((CardView.a) bVar).f161a;
    }

    public float b(b bVar) {
        return a(bVar).f1366e;
    }

    public float c(b bVar) {
        return a(bVar).f1362a;
    }

    public void d(b bVar, float f2) {
        d a2 = a(bVar);
        CardView.a aVar = (CardView.a) bVar;
        boolean useCompatPadding = CardView.this.getUseCompatPadding();
        boolean a3 = aVar.a();
        if (!(f2 == a2.f1366e && a2.f1367f == useCompatPadding && a2.f1368g == a3)) {
            a2.f1366e = f2;
            a2.f1367f = useCompatPadding;
            a2.f1368g = a3;
            a2.c(null);
            a2.invalidateSelf();
        }
        e(bVar);
    }

    public void e(b bVar) {
        CardView.a aVar = (CardView.a) bVar;
        if (!CardView.this.getUseCompatPadding()) {
            aVar.b(0, 0, 0, 0);
            return;
        }
        float f2 = a(bVar).f1366e;
        float f3 = a(bVar).f1362a;
        int ceil = (int) Math.ceil((double) e.a(f2, f3, aVar.a()));
        int ceil2 = (int) Math.ceil((double) e.b(f2, f3, aVar.a()));
        aVar.b(ceil, ceil2, ceil, ceil2);
    }
}
