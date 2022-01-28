package h.a.j1;

import f.b.a.c.b.o.b;
import h.a.b0;
import h.a.d0;
import h.a.e;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public final class o {

    /* renamed from: e  reason: collision with root package name */
    public static final Logger f4011e = Logger.getLogger(e.class.getName());
    public final Object a = new Object();
    public final d0 b;
    public final Collection<b0> c;

    /* renamed from: d  reason: collision with root package name */
    public int f4012d;

    public class a extends ArrayDeque<b0> {
        public final /* synthetic */ int b;

        public a(int i2) {
            this.b = i2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Queue, java.util.ArrayDeque, java.util.Deque
        public boolean add(b0 b0Var) {
            b0 b0Var2 = b0Var;
            if (size() == this.b) {
                removeFirst();
            }
            o.this.f4012d++;
            return super.add(b0Var2);
        }
    }

    public o(d0 d0Var, int i2, long j2, String str) {
        b.z(str, "description");
        b.z(d0Var, "logId");
        this.b = d0Var;
        this.c = i2 > 0 ? new a(i2) : null;
        String w = f.a.a.a.a.w(str, " created");
        b0.a aVar = b0.a.CT_INFO;
        Long valueOf = Long.valueOf(j2);
        b.z(w, "description");
        b.z(aVar, "severity");
        b.z(valueOf, "timestampNanos");
        b.F(true, "at least one of channelRef and subchannelRef must be null");
        b(new b0(w, aVar, valueOf.longValue(), null, null, null));
    }

    public static void a(d0 d0Var, Level level, String str) {
        Logger logger = f4011e;
        if (logger.isLoggable(level)) {
            LogRecord logRecord = new LogRecord(level, "[" + d0Var + "] " + str);
            logRecord.setLoggerName(logger.getName());
            logRecord.setSourceClassName(logger.getName());
            logRecord.setSourceMethodName("log");
            logger.log(logRecord);
        }
    }

    public void b(b0 b0Var) {
        int ordinal = b0Var.b.ordinal();
        Level level = ordinal != 2 ? ordinal != 3 ? Level.FINEST : Level.FINE : Level.FINER;
        synchronized (this.a) {
            Collection<b0> collection = this.c;
            if (collection != null) {
                collection.add(b0Var);
            }
        }
        a(this.b, level, b0Var.a);
    }
}
