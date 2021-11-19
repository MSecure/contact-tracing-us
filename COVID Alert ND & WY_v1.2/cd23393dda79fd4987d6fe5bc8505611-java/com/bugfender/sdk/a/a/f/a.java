package com.bugfender.sdk.a.a.f;

import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a implements Cloneable, Runnable {
    private static final String f = "Logcat";
    private Process a;
    private BufferedReader b;
    private AbstractC0004a c;
    private volatile boolean d = true;
    private final String e;

    /* renamed from: com.bugfender.sdk.a.a.f.a$a  reason: collision with other inner class name */
    public interface AbstractC0004a {
        void a(String str);
    }

    public a(String str) {
        this.e = str;
    }

    private BufferedReader b() {
        if (this.b == null && this.a != null) {
            this.b = new BufferedReader(new InputStreamReader(this.a.getInputStream()));
        }
        return this.b;
    }

    private void c() {
        BufferedReader b2 = b();
        if (b2 != null) {
            try {
                for (String readLine = b2.readLine(); readLine != null && this.d; readLine = b2.readLine()) {
                    a(readLine);
                }
            } catch (IOException e2) {
                Log.e(f, "IOException reading logcat trace.", e2);
            }
        }
    }

    public AbstractC0004a a() {
        return this.c;
    }

    public void run() {
        try {
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("logcat -c").waitFor();
            this.a = runtime.exec("logcat -v brief " + this.e);
        } catch (IOException | InterruptedException e2) {
            Log.e(f, "Exception executing logcat command.", e2);
        }
        c();
        Log.d(f, "run: Logcat thread finished");
    }

    public void a(AbstractC0004a aVar) {
        this.c = aVar;
    }

    private void a(String str) {
        AbstractC0004a aVar = this.c;
        if (aVar != null) {
            aVar.a(str);
        }
    }
}
