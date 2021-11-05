package b.d.e;

import androidx.cardview.widget.CardView;

public class a implements c {
    public final d a(b bVar) {
        return (d) ((CardView.a) bVar).f107a;
    }

    public float b(b bVar) {
        return a(bVar).f792e;
    }

    public float c(b bVar) {
        return a(bVar).f788a;
    }

    public void d(b bVar, float f) {
        d a2 = a(bVar);
        CardView.a aVar = (CardView.a) bVar;
        boolean useCompatPadding = CardView.this.getUseCompatPadding();
        boolean a3 = aVar.a();
        if (!(f == a2.f792e && a2.f == useCompatPadding && a2.g == a3)) {
            a2.f792e = f;
            a2.f = useCompatPadding;
            a2.g = a3;
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
        float f = a(bVar).f792e;
        float f2 = a(bVar).f788a;
        int ceil = (int) Math.ceil((double) e.a(f, f2, aVar.a()));
        int ceil2 = (int) Math.ceil((double) e.b(f, f2, aVar.a()));
        aVar.b(ceil, ceil2, ceil, ceil2);
    }
}
