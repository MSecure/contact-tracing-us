package f.b.a.e.k;

import android.os.Build;
import com.google.android.material.textfield.TextInputLayout;
import f.b.a.c.b.o.b;
import f.b.a.e.k.a0;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

public class e implements Runnable {
    public final /* synthetic */ long b;
    public final /* synthetic */ d c;

    public e(d dVar, long j2) {
        this.c = dVar;
        this.b = j2;
    }

    public void run() {
        String str;
        d dVar = this.c;
        TextInputLayout textInputLayout = dVar.b;
        String str2 = dVar.f2841e;
        Object[] objArr = new Object[1];
        long j2 = this.b;
        Calendar f2 = d0.f();
        Calendar g2 = d0.g();
        g2.setTimeInMillis(j2);
        if (f2.get(1) == g2.get(1)) {
            Locale locale = Locale.getDefault();
            if (Build.VERSION.SDK_INT >= 24) {
                str = d0.c("MMMd", locale).format(new Date(j2));
            } else {
                AtomicReference<c0> atomicReference = d0.a;
                DateFormat dateInstance = DateFormat.getDateInstance(2, locale);
                dateInstance.setTimeZone(d0.e());
                SimpleDateFormat simpleDateFormat = (SimpleDateFormat) dateInstance;
                String pattern = simpleDateFormat.toPattern();
                int b2 = d0.b(pattern, "yY", 1, 0);
                if (b2 < pattern.length()) {
                    String str3 = "EMd";
                    int b3 = d0.b(pattern, str3, 1, b2);
                    if (b3 < pattern.length()) {
                        str3 = "EMd,";
                    }
                    pattern = pattern.replace(pattern.substring(d0.b(pattern, str3, -1, b2) + 1, b3), " ").trim();
                }
                simpleDateFormat.applyPattern(pattern);
                str = simpleDateFormat.format(new Date(j2));
            }
        } else {
            str = b.L0(j2);
        }
        objArr[0] = str;
        textInputLayout.setError(String.format(str2, objArr));
        ((a0.a) this.c).f2830h.a();
    }
}
