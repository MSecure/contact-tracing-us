package f.b.a.a.a;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.logging.FirelogAnalyticsWorker;
import e.p.a.b;
import java.util.Objects;
/*  JADX ERROR: UnsupportedOperationException in pass: OverrideMethodVisitor
    java.lang.UnsupportedOperationException
    	at jadx.core.utils.ImmutableList.listIterator(ImmutableList.java:198)
    	at java.util.AbstractList.equals(AbstractList.java:519)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.fixMethodArgTypes(OverrideMethodVisitor.java:297)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.processMth(OverrideMethodVisitor.java:71)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.processCls(OverrideMethodVisitor.java:56)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.visit(OverrideMethodVisitor.java:48)
    */
/* loaded from: classes.dex */
public class c implements b {
    public final /* synthetic */ k a;

    public c(k kVar) {
        this.a = kVar;
    }

    @Override // e.p.a.b
    public ListenableWorker a(Context context, WorkerParameters workerParameters) {
        k kVar = this.a.t;
        Objects.requireNonNull(kVar);
        return new FirelogAnalyticsWorker(context, workerParameters, kVar.B.get(), kVar.v(), kVar.v.get());
    }
}
