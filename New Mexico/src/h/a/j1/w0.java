package h.a.j1;

import f.b.b.a.s;
import h.a.j1.w;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public class w0 {

    /* renamed from: g  reason: collision with root package name */
    public static final Logger f4337g = Logger.getLogger(w0.class.getName());
    public final long a;
    public final s b;
    public Map<w.a, Executor> c = new LinkedHashMap();

    /* renamed from: d  reason: collision with root package name */
    public boolean f4338d;

    /* renamed from: e  reason: collision with root package name */
    public Throwable f4339e;

    /* renamed from: f  reason: collision with root package name */
    public long f4340f;

    public w0(long j2, s sVar) {
        this.a = j2;
        this.b = sVar;
    }

    public static void a(Executor executor, Runnable runnable) {
        try {
            executor.execute(runnable);
        } catch (Throwable th) {
            f4337g.log(Level.SEVERE, "Failed to execute PingCallback", th);
        }
    }
}
