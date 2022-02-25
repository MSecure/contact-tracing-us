package h.a.k1;

import java.util.EnumMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import k.e;
import k.q;

public class h {
    public final Logger a;
    public final Level b;

    public enum a {
        INBOUND,
        OUTBOUND
    }

    public enum b {
        HEADER_TABLE_SIZE(1),
        ENABLE_PUSH(2),
        MAX_CONCURRENT_STREAMS(4),
        MAX_FRAME_SIZE(5),
        MAX_HEADER_LIST_SIZE(6),
        INITIAL_WINDOW_SIZE(7);
        
        public final int b;

        /* access modifiers changed from: public */
        b(int i2) {
            this.b = i2;
        }
    }

    public h(Level level, Class<?> cls) {
        Logger logger = Logger.getLogger(cls.getName());
        f.b.a.c.b.o.b.A(level, "level");
        this.b = level;
        f.b.a.c.b.o.b.A(logger, "logger");
        this.a = logger;
    }

    public static String h(e eVar) {
        long j2 = eVar.c;
        if (j2 <= 64) {
            return eVar.X().e();
        }
        int min = (int) Math.min(j2, 64L);
        StringBuilder sb = new StringBuilder();
        sb.append((min == 0 ? k.h.f4015f : new q(eVar, min)).e());
        sb.append("...");
        return sb.toString();
    }

    public final boolean a() {
        return this.a.isLoggable(this.b);
    }

    public void b(a aVar, int i2, e eVar, int i3, boolean z) {
        if (a()) {
            Logger logger = this.a;
            Level level = this.b;
            logger.log(level, aVar + " DATA: streamId=" + i2 + " endStream=" + z + " length=" + i3 + " bytes=" + h(eVar));
        }
    }

    public void c(a aVar, int i2, h.a.k1.p.m.a aVar2, k.h hVar) {
        if (a()) {
            Logger logger = this.a;
            Level level = this.b;
            StringBuilder sb = new StringBuilder();
            sb.append(aVar);
            sb.append(" GO_AWAY: lastStreamId=");
            sb.append(i2);
            sb.append(" errorCode=");
            sb.append(aVar2);
            sb.append(" length=");
            sb.append(hVar.l());
            sb.append(" bytes=");
            e eVar = new e();
            eVar.Z(hVar);
            sb.append(h(eVar));
            logger.log(level, sb.toString());
        }
    }

    public void d(a aVar, long j2) {
        if (a()) {
            Logger logger = this.a;
            Level level = this.b;
            logger.log(level, aVar + " PING: ack=false bytes=" + j2);
        }
    }

    public void e(a aVar, int i2, h.a.k1.p.m.a aVar2) {
        if (a()) {
            Logger logger = this.a;
            Level level = this.b;
            logger.log(level, aVar + " RST_STREAM: streamId=" + i2 + " errorCode=" + aVar2);
        }
    }

    public void f(a aVar, h.a.k1.p.m.h hVar) {
        if (a()) {
            Logger logger = this.a;
            Level level = this.b;
            StringBuilder sb = new StringBuilder();
            sb.append(aVar);
            sb.append(" SETTINGS: ack=false settings=");
            EnumMap enumMap = new EnumMap(b.class);
            b[] values = b.values();
            for (int i2 = 0; i2 < 6; i2++) {
                b bVar = values[i2];
                if (hVar.a(bVar.b)) {
                    enumMap.put((Enum) bVar, (Object) Integer.valueOf(hVar.f3940d[bVar.b]));
                }
            }
            sb.append(enumMap.toString());
            logger.log(level, sb.toString());
        }
    }

    public void g(a aVar, int i2, long j2) {
        if (a()) {
            Logger logger = this.a;
            Level level = this.b;
            logger.log(level, aVar + " WINDOW_UPDATE: streamId=" + i2 + " windowSizeIncrement=" + j2);
        }
    }
}
