package h.a.j1;

import h.a.k0;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public final class w1 extends n0 {
    public static final ReferenceQueue<w1> c = new ReferenceQueue<>();

    /* renamed from: d  reason: collision with root package name */
    public static final ConcurrentMap<a, a> f3763d = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    public static final Logger f3764e = Logger.getLogger(w1.class.getName());
    public final a b;

    public static final class a extends WeakReference<w1> {

        /* renamed from: f  reason: collision with root package name */
        public static final boolean f3765f = Boolean.parseBoolean(System.getProperty("io.grpc.ManagedChannel.enableAllocationTracking", "true"));

        /* renamed from: g  reason: collision with root package name */
        public static final RuntimeException f3766g;
        public final ReferenceQueue<w1> a;
        public final ConcurrentMap<a, a> b;
        public final String c;

        /* renamed from: d  reason: collision with root package name */
        public final Reference<RuntimeException> f3767d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f3768e;

        static {
            RuntimeException runtimeException = new RuntimeException("ManagedChannel allocation site not recorded.  Set -Dio.grpc.ManagedChannel.enableAllocationTracking=true to enable it");
            runtimeException.setStackTrace(new StackTraceElement[0]);
            f3766g = runtimeException;
        }

        public a(w1 w1Var, k0 k0Var, ReferenceQueue<w1> referenceQueue, ConcurrentMap<a, a> concurrentMap) {
            super(w1Var, referenceQueue);
            this.f3767d = new SoftReference(f3765f ? new RuntimeException("ManagedChannel allocation site") : f3766g);
            this.c = k0Var.toString();
            this.a = referenceQueue;
            this.b = concurrentMap;
            concurrentMap.put(this, this);
            a(referenceQueue);
        }

        public static int a(ReferenceQueue<w1> referenceQueue) {
            int i2 = 0;
            while (true) {
                a aVar = (a) referenceQueue.poll();
                if (aVar == null) {
                    return i2;
                }
                RuntimeException runtimeException = aVar.f3767d.get();
                super.clear();
                aVar.b.remove(aVar);
                aVar.f3767d.clear();
                if (!aVar.f3768e) {
                    i2++;
                    Level level = Level.SEVERE;
                    Logger logger = w1.f3764e;
                    if (logger.isLoggable(level)) {
                        StringBuilder h2 = f.a.a.a.a.h("*~*~*~ Channel {0} was not shutdown properly!!! ~*~*~*");
                        h2.append(System.getProperty("line.separator"));
                        h2.append("    Make sure to call shutdown()/shutdownNow() and wait until awaitTermination() returns true.");
                        LogRecord logRecord = new LogRecord(level, h2.toString());
                        logRecord.setLoggerName(logger.getName());
                        logRecord.setParameters(new Object[]{aVar.c});
                        logRecord.setThrown(runtimeException);
                        logger.log(logRecord);
                    }
                }
            }
        }

        public void clear() {
            super.clear();
            this.b.remove(this);
            this.f3767d.clear();
            a(this.a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w1(k0 k0Var) {
        super(k0Var);
        ReferenceQueue<w1> referenceQueue = c;
        ConcurrentMap<a, a> concurrentMap = f3763d;
        this.b = new a(this, k0Var, referenceQueue, concurrentMap);
    }

    @Override // h.a.k0
    public k0 m() {
        this.b.f3768e = true;
        this.b.clear();
        return this.a.m();
    }
}
