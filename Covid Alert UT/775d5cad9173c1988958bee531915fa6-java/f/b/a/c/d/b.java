package f.b.a.c.d;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

public final class b implements DynamiteModule.b {
    @Override // com.google.android.gms.dynamite.DynamiteModule.b
    public final DynamiteModule.b.a a(Context context, String str, DynamiteModule.b.AbstractC0004b bVar) {
        DynamiteModule.b.a aVar = new DynamiteModule.b.a();
        int a = bVar.a(context, str);
        aVar.a = a;
        aVar.b = a != 0 ? bVar.b(context, str, false) : bVar.b(context, str, true);
        int i2 = aVar.a;
        if (i2 == 0 && aVar.b == 0) {
            aVar.c = 0;
        } else if (i2 >= aVar.b) {
            aVar.c = -1;
        } else {
            aVar.c = 1;
        }
        return aVar;
    }
}
