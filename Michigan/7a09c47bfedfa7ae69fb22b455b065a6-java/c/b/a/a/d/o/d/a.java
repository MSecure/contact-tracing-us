package c.b.a.a.d.o.d;

import androidx.annotation.RecentlyNonNull;
import b.x.t;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class a implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final String f3175a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicInteger f3176b = new AtomicInteger();

    /* renamed from: c  reason: collision with root package name */
    public final ThreadFactory f3177c = Executors.defaultThreadFactory();

    public a(@RecentlyNonNull String str) {
        t.D(str, "Name must not be null");
        this.f3175a = str;
    }

    @RecentlyNonNull
    public Thread newThread(@RecentlyNonNull Runnable runnable) {
        Thread newThread = this.f3177c.newThread(new b(runnable));
        String str = this.f3175a;
        int andIncrement = this.f3176b.getAndIncrement();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13);
        sb.append(str);
        sb.append("[");
        sb.append(andIncrement);
        sb.append("]");
        newThread.setName(sb.toString());
        return newThread;
    }
}
