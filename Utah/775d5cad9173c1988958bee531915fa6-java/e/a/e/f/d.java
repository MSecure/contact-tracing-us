package e.a.e.f;

import android.content.Context;
import android.content.Intent;
import e.a.e.a;
import e.a.e.e;

public final class d extends a<e, a> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.Object] */
    @Override // e.a.e.f.a
    public Intent a(Context context, e eVar) {
        return new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", eVar);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // e.a.e.f.a
    public a c(int i2, Intent intent) {
        return new a(i2, intent);
    }
}
