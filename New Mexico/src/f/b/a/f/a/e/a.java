package f.b.a.f.a.e;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.util.IllegalFormatException;
import java.util.Locale;
/* loaded from: classes.dex */
public final class a {
    public final String a;

    public a(String str) {
        int myUid = Process.myUid();
        int myPid = Process.myPid();
        StringBuilder sb = new StringBuilder(39);
        sb.append("UID: [");
        sb.append(myUid);
        sb.append("]  PID: [");
        sb.append(myPid);
        sb.append("] ");
        String valueOf = String.valueOf(sb.toString());
        this.a = str.length() != 0 ? valueOf.concat(str) : new String(valueOf);
    }

    public static String f(String str, String str2, Object... objArr) {
        if (objArr.length > 0) {
            try {
                str2 = String.format(Locale.US, str2, objArr);
            } catch (IllegalFormatException unused) {
                String valueOf = String.valueOf(str2);
                if (valueOf.length() != 0) {
                    "Unable to format ".concat(valueOf);
                } else {
                    new String("Unable to format ");
                }
                String join = TextUtils.join(", ", objArr);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 3 + String.valueOf(join).length());
                sb.append(str2);
                sb.append(" [");
                sb.append(join);
                sb.append("]");
                str2 = sb.toString();
            }
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb2.append(str);
        sb2.append(" : ");
        sb2.append(str2);
        return sb2.toString();
    }

    public final int a(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 3)) {
            return Log.d("PlayCore", f(this.a, str, objArr));
        }
        return 0;
    }

    public final int b(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 6)) {
            return Log.e("PlayCore", f(this.a, str, objArr));
        }
        return 0;
    }

    public final int c(Throwable th, String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 6)) {
            return Log.e("PlayCore", f(this.a, str, objArr), th);
        }
        return 0;
    }

    public final int d(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 4)) {
            return Log.i("PlayCore", f(this.a, str, objArr));
        }
        return 0;
    }

    public final int e(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 5)) {
            return Log.w("PlayCore", f(this.a, str, objArr));
        }
        return 0;
    }
}
