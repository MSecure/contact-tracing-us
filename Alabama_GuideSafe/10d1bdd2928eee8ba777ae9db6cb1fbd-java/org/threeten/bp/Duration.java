package org.threeten.bp;

import com.google.common.util.concurrent.MoreExecutors;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.io.DataInput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.math.BigInteger;
import java.util.regex.Pattern;
import okhttp3.internal.http2.Http2Connection;

public final class Duration implements Object, Comparable<Duration> {
    public static final Duration ZERO = new Duration(0, 0);
    public final int nanos;
    public final long seconds;

    static {
        BigInteger.valueOf(Http2Connection.DEGRADED_PONG_TIMEOUT_NS);
        Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)D)?(T(?:([-+]?[0-9]+)H)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)(?:[.,]([0-9]{0,9}))?S)?)?", 2);
    }

    public Duration(long j, int i) {
        this.seconds = j;
        this.nanos = i;
    }

    public static Duration create(long j, int i) {
        if ((((long) i) | j) == 0) {
            return ZERO;
        }
        return new Duration(j, i);
    }

    public static Duration ofDays(long j) {
        return create(MoreExecutors.safeMultiply(j, 86400), 0);
    }

    public static Duration ofMinutes(long j) {
        return create(MoreExecutors.safeMultiply(j, 60), 0);
    }

    public static Duration ofNanos(long j) {
        long j2 = j / Http2Connection.DEGRADED_PONG_TIMEOUT_NS;
        int i = (int) (j % Http2Connection.DEGRADED_PONG_TIMEOUT_NS);
        if (i < 0) {
            i += 1000000000;
            j2--;
        }
        return create(j2, i);
    }

    public static Duration ofSeconds(long j) {
        return create(j, 0);
    }

    public static Duration readExternal(DataInput dataInput) throws IOException {
        return ofSeconds(dataInput.readLong(), (long) dataInput.readInt());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(Duration duration) {
        Duration duration2 = duration;
        int compareLongs = MoreExecutors.compareLongs(this.seconds, duration2.seconds);
        return compareLongs != 0 ? compareLongs : this.nanos - duration2.nanos;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Duration)) {
            return false;
        }
        Duration duration = (Duration) obj;
        return this.seconds == duration.seconds && this.nanos == duration.nanos;
    }

    public int hashCode() {
        long j = this.seconds;
        return (this.nanos * 51) + ((int) (j ^ (j >>> 32)));
    }

    public long toMillis() {
        return MoreExecutors.safeAdd(MoreExecutors.safeMultiply(this.seconds, (int) RNCWebViewManager.COMMAND_CLEAR_FORM_DATA), (long) (this.nanos / 1000000));
    }

    public String toString() {
        if (this == ZERO) {
            return "PT0S";
        }
        long j = this.seconds;
        long j2 = j / 3600;
        int i = (int) ((j % 3600) / 60);
        int i2 = (int) (j % 60);
        StringBuilder sb = new StringBuilder(24);
        sb.append("PT");
        if (j2 != 0) {
            sb.append(j2);
            sb.append('H');
        }
        if (i != 0) {
            sb.append(i);
            sb.append('M');
        }
        if (i2 == 0 && this.nanos == 0 && sb.length() > 2) {
            return sb.toString();
        }
        if (i2 >= 0 || this.nanos <= 0) {
            sb.append(i2);
        } else if (i2 == -1) {
            sb.append("-0");
        } else {
            sb.append(i2 + 1);
        }
        if (this.nanos > 0) {
            int length = sb.length();
            if (i2 < 0) {
                sb.append(2000000000 - this.nanos);
            } else {
                sb.append(this.nanos + 1000000000);
            }
            while (sb.charAt(sb.length() - 1) == '0') {
                sb.setLength(sb.length() - 1);
            }
            sb.setCharAt(length, '.');
        }
        sb.append('S');
        return sb.toString();
    }

    public static Duration ofSeconds(long j, long j2) {
        return create(MoreExecutors.safeAdd(j, MoreExecutors.floorDiv(j2, Http2Connection.DEGRADED_PONG_TIMEOUT_NS)), MoreExecutors.floorMod(j2, 1000000000));
    }
}
