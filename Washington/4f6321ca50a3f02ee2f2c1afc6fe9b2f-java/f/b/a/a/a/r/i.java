package f.b.a.a.a.r;

import android.util.Log;
import androidx.work.ListenableWorker;
import f.b.b.a.g;

public final /* synthetic */ class i implements g {
    public final /* synthetic */ String a;

    public /* synthetic */ i(String str) {
        this.a = str;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        String str = this.a;
        Log.w("PrioSubmitter", "Error submitting metric" + str, (Exception) obj);
        return new ListenableWorker.a.C0002a();
    }
}
