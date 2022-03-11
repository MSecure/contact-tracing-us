package f.b.a.c.b.m;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.api.Scope;
import e.b.a.m;
import f.b.a.c.b.l.l.r;
import f.b.a.c.b.l.l.s;
import f.b.a.c.b.m.g;
import f.b.a.c.b.m.i;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class b<T extends IInterface> {
    public static final f.b.a.c.b.c[] v = new f.b.a.c.b.c[0];
    public volatile String a = null;
    public h0 b;
    public final Context c;

    /* renamed from: d  reason: collision with root package name */
    public final g f2521d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f2522e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f2523f = new Object();

    /* renamed from: g  reason: collision with root package name */
    public final Object f2524g = new Object();

    /* renamed from: h  reason: collision with root package name */
    public k f2525h;
    @RecentlyNonNull

    /* renamed from: i  reason: collision with root package name */
    public c f2526i;

    /* renamed from: j  reason: collision with root package name */
    public T f2527j;

    /* renamed from: k  reason: collision with root package name */
    public final ArrayList<h<?>> f2528k = new ArrayList<>();

    /* renamed from: l  reason: collision with root package name */
    public i f2529l;
    public int m = 1;
    public final a n;
    public final AbstractC0087b o;
    public final int p;
    public final String q;
    public f.b.a.c.b.a r = null;
    public boolean s = false;
    public volatile z t = null;
    @RecentlyNonNull
    public AtomicInteger u = new AtomicInteger(0);

    public interface a {
    }

    /* renamed from: f.b.a.c.b.m.b$b  reason: collision with other inner class name */
    public interface AbstractC0087b {
    }

    public interface c {
        void a(@RecentlyNonNull f.b.a.c.b.a aVar);
    }

    public class d implements c {
        public d() {
        }

        @Override // f.b.a.c.b.m.b.c
        public void a(@RecentlyNonNull f.b.a.c.b.a aVar) {
            if (aVar.d()) {
                b bVar = b.this;
                bVar.h(null, ((f) bVar).w);
                return;
            }
            AbstractC0087b bVar2 = b.this.o;
            if (bVar2 != null) {
                ((s) bVar2).a.k(aVar);
            }
        }
    }

    public interface e {
    }

    public abstract class f extends h<Boolean> {

        /* renamed from: d  reason: collision with root package name */
        public final int f2530d;

        /* renamed from: e  reason: collision with root package name */
        public final Bundle f2531e;

        public f(int i2, Bundle bundle) {
            super(Boolean.TRUE);
            this.f2530d = i2;
            this.f2531e = bundle;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // f.b.a.c.b.m.b.h
        public final /* synthetic */ void a(Boolean bool) {
            PendingIntent pendingIntent = null;
            if (this.f2530d != 0) {
                b.this.B(1, null);
                Bundle bundle = this.f2531e;
                if (bundle != null) {
                    pendingIntent = (PendingIntent) bundle.getParcelable("pendingIntent");
                }
                d(new f.b.a.c.b.a(this.f2530d, pendingIntent));
            } else if (!e()) {
                b.this.B(1, null);
                d(new f.b.a.c.b.a(8, null));
            }
        }

        @Override // f.b.a.c.b.m.b.h
        public final void b() {
        }

        public abstract void d(f.b.a.c.b.a aVar);

        public abstract boolean e();
    }

    public final class g extends f.b.a.c.e.b.d {
        public g(Looper looper) {
            super(looper);
        }

        public static boolean a(Message message) {
            int i2 = message.what;
            return i2 == 2 || i2 == 1 || i2 == 7;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x002f, code lost:
            if (r0 == 5) goto L_0x0031;
         */
        public final void handleMessage(Message message) {
            TListener tlistener;
            if (b.this.u.get() == message.arg1) {
                int i2 = message.what;
                if (!(i2 == 1 || i2 == 7)) {
                    if (i2 == 4) {
                        Objects.requireNonNull(b.this);
                    }
                }
                if (!b.this.b()) {
                    h hVar = (h) message.obj;
                    hVar.b();
                    hVar.c();
                    return;
                }
                int i3 = message.what;
                PendingIntent pendingIntent = null;
                if (i3 == 4) {
                    b bVar = b.this;
                    bVar.r = new f.b.a.c.b.a(message.arg2);
                    if (b.E(bVar)) {
                        b bVar2 = b.this;
                        if (!bVar2.s) {
                            bVar2.B(3, null);
                            return;
                        }
                    }
                    b bVar3 = b.this;
                    f.b.a.c.b.a aVar = bVar3.r;
                    if (aVar == null) {
                        aVar = new f.b.a.c.b.a(8);
                    }
                    bVar3.f2526i.a(aVar);
                    Objects.requireNonNull(b.this);
                    System.currentTimeMillis();
                } else if (i3 == 5) {
                    b bVar4 = b.this;
                    f.b.a.c.b.a aVar2 = bVar4.r;
                    if (aVar2 == null) {
                        aVar2 = new f.b.a.c.b.a(8);
                    }
                    bVar4.f2526i.a(aVar2);
                    Objects.requireNonNull(b.this);
                    System.currentTimeMillis();
                } else if (i3 == 3) {
                    Object obj = message.obj;
                    if (obj instanceof PendingIntent) {
                        pendingIntent = (PendingIntent) obj;
                    }
                    b.this.f2526i.a(new f.b.a.c.b.a(message.arg2, pendingIntent));
                    Objects.requireNonNull(b.this);
                    System.currentTimeMillis();
                } else if (i3 == 6) {
                    b.this.B(5, null);
                    a aVar3 = b.this.n;
                    if (aVar3 != null) {
                        ((r) aVar3).a.m(message.arg2);
                    }
                    b.this.y(message.arg2);
                    b.D(b.this, 5, 1, null);
                } else if (i3 == 2 && !b.this.d()) {
                    h hVar2 = (h) message.obj;
                    hVar2.b();
                    hVar2.c();
                } else if (a(message)) {
                    h hVar3 = (h) message.obj;
                    synchronized (hVar3) {
                        tlistener = hVar3.a;
                        if (hVar3.b) {
                            String valueOf = String.valueOf(hVar3);
                            StringBuilder sb = new StringBuilder(valueOf.length() + 47);
                            sb.append("Callback proxy ");
                            sb.append(valueOf);
                            sb.append(" being reused. This is not safe.");
                            Log.w("GmsClient", sb.toString());
                        }
                    }
                    if (tlistener != null) {
                        try {
                            hVar3.a(tlistener);
                        } catch (RuntimeException e2) {
                            hVar3.b();
                            throw e2;
                        }
                    } else {
                        hVar3.b();
                    }
                    synchronized (hVar3) {
                        hVar3.b = true;
                    }
                    hVar3.c();
                } else {
                    int i4 = message.what;
                    StringBuilder sb2 = new StringBuilder(45);
                    sb2.append("Don't know how to handle message: ");
                    sb2.append(i4);
                    Log.wtf("GmsClient", sb2.toString(), new Exception());
                }
            } else if (a(message)) {
                h hVar4 = (h) message.obj;
                hVar4.b();
                hVar4.c();
            }
        }
    }

    public abstract class h<TListener> {
        public TListener a;
        public boolean b = false;

        public h(TListener tlistener) {
            this.a = tlistener;
        }

        public abstract void a(TListener tlistener);

        public abstract void b();

        public final void c() {
            synchronized (this) {
                this.a = null;
            }
            synchronized (b.this.f2528k) {
                b.this.f2528k.remove(this);
            }
        }
    }

    public final class i implements ServiceConnection {
        public final int a;

        public i(int i2) {
            this.a = i2;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b bVar = b.this;
            if (iBinder == null) {
                b.C(bVar);
                return;
            }
            synchronized (bVar.f2524g) {
                b bVar2 = b.this;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                bVar2.f2525h = (queryLocalInterface == null || !(queryLocalInterface instanceof k)) ? new j(iBinder) : (k) queryLocalInterface;
            }
            b bVar3 = b.this;
            int i2 = this.a;
            Handler handler = bVar3.f2522e;
            handler.sendMessage(handler.obtainMessage(7, i2, -1, new l(0)));
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            b bVar;
            synchronized (b.this.f2524g) {
                bVar = b.this;
                bVar.f2525h = null;
            }
            Handler handler = bVar.f2522e;
            handler.sendMessage(handler.obtainMessage(6, this.a, 1));
        }
    }

    public static final class j extends i.a {
        public b a;
        public final int b;

        public j(b bVar, int i2) {
            this.a = bVar;
            this.b = i2;
        }

        public final void m(int i2, IBinder iBinder, Bundle bundle) {
            m.h.p(this.a, "onPostInitComplete can be called only once per call to getRemoteService");
            b bVar = this.a;
            int i3 = this.b;
            Handler handler = bVar.f2522e;
            handler.sendMessage(handler.obtainMessage(1, i3, -1, new k(i2, iBinder, bundle)));
            this.a = null;
        }
    }

    public final class k extends f {

        /* renamed from: g  reason: collision with root package name */
        public final IBinder f2533g;

        public k(int i2, IBinder iBinder, Bundle bundle) {
            super(i2, bundle);
            this.f2533g = iBinder;
        }

        @Override // f.b.a.c.b.m.b.f
        public final void d(f.b.a.c.b.a aVar) {
            AbstractC0087b bVar = b.this.o;
            if (bVar != null) {
                ((s) bVar).a.k(aVar);
            }
            Objects.requireNonNull(b.this);
            System.currentTimeMillis();
        }

        @Override // f.b.a.c.b.m.b.f
        public final boolean e() {
            try {
                IBinder iBinder = this.f2533g;
                Objects.requireNonNull(iBinder, "null reference");
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if (!b.this.u().equals(interfaceDescriptor)) {
                    String u = b.this.u();
                    StringBuilder sb = new StringBuilder(String.valueOf(interfaceDescriptor).length() + String.valueOf(u).length() + 34);
                    sb.append("service descriptor mismatch: ");
                    sb.append(u);
                    sb.append(" vs. ");
                    sb.append(interfaceDescriptor);
                    Log.e("GmsClient", sb.toString());
                    return false;
                }
                IInterface q = b.this.q(this.f2533g);
                if (q == null || (!b.D(b.this, 2, 4, q) && !b.D(b.this, 3, 4, q))) {
                    return false;
                }
                b bVar = b.this;
                bVar.r = null;
                a aVar = bVar.n;
                if (aVar == null) {
                    return true;
                }
                ((r) aVar).a.E(null);
                return true;
            } catch (RemoteException unused) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    public final class l extends f {
        public l(int i2) {
            super(i2, null);
        }

        @Override // f.b.a.c.b.m.b.f
        public final void d(f.b.a.c.b.a aVar) {
            Objects.requireNonNull(b.this);
            b.this.f2526i.a(aVar);
            Objects.requireNonNull(b.this);
            System.currentTimeMillis();
        }

        @Override // f.b.a.c.b.m.b.f
        public final boolean e() {
            b.this.f2526i.a(f.b.a.c.b.a.f2482f);
            return true;
        }
    }

    public b(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull g gVar, @RecentlyNonNull f.b.a.c.b.e eVar, @RecentlyNonNull int i2, a aVar, AbstractC0087b bVar, String str) {
        m.h.p(context, "Context must not be null");
        this.c = context;
        m.h.p(looper, "Looper must not be null");
        m.h.p(gVar, "Supervisor must not be null");
        this.f2521d = gVar;
        m.h.p(eVar, "API availability must not be null");
        this.f2522e = new g(looper);
        this.p = i2;
        this.n = aVar;
        this.o = bVar;
        this.q = str;
    }

    public static void C(b bVar) {
        boolean z;
        int i2;
        synchronized (bVar.f2523f) {
            z = bVar.m == 3;
        }
        if (z) {
            i2 = 5;
            bVar.s = true;
        } else {
            i2 = 4;
        }
        Handler handler = bVar.f2522e;
        handler.sendMessage(handler.obtainMessage(i2, bVar.u.get(), 16));
    }

    public static boolean D(b bVar, int i2, int i3, IInterface iInterface) {
        boolean z;
        synchronized (bVar.f2523f) {
            if (bVar.m != i2) {
                z = false;
            } else {
                bVar.B(i3, iInterface);
                z = true;
            }
        }
        return z;
    }

    public static boolean E(b bVar) {
        if (bVar.s || TextUtils.isEmpty(bVar.u()) || TextUtils.isEmpty(null)) {
            return false;
        }
        try {
            Class.forName(bVar.u());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final String A() {
        String str = this.q;
        return str == null ? this.c.getClass().getName() : str;
    }

    public final void B(int i2, T t2) {
        h0 h0Var;
        boolean z = false;
        if ((i2 == 4) == (t2 != null)) {
            z = true;
        }
        m.h.i(z);
        synchronized (this.f2523f) {
            this.m = i2;
            this.f2527j = t2;
            if (i2 == 1) {
                i iVar = this.f2529l;
                if (iVar != null) {
                    g gVar = this.f2521d;
                    String str = this.b.a;
                    Objects.requireNonNull(str, "null reference");
                    Objects.requireNonNull(this.b);
                    String A = A();
                    boolean z2 = this.b.b;
                    Objects.requireNonNull(gVar);
                    gVar.b(new g.a(str, "com.google.android.gms", 4225, z2), iVar, A);
                    this.f2529l = null;
                }
            } else if (i2 == 2 || i2 == 3) {
                i iVar2 = this.f2529l;
                if (!(iVar2 == null || (h0Var = this.b) == null)) {
                    String str2 = h0Var.a;
                    StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 70 + "com.google.android.gms".length());
                    sb.append("Calling connect() while still connected, missing disconnect() for ");
                    sb.append(str2);
                    sb.append(" on ");
                    sb.append("com.google.android.gms");
                    Log.e("GmsClient", sb.toString());
                    g gVar2 = this.f2521d;
                    String str3 = this.b.a;
                    Objects.requireNonNull(str3, "null reference");
                    Objects.requireNonNull(this.b);
                    String A2 = A();
                    boolean z3 = this.b.b;
                    Objects.requireNonNull(gVar2);
                    gVar2.b(new g.a(str3, "com.google.android.gms", 4225, z3), iVar2, A2);
                    this.u.incrementAndGet();
                }
                i iVar3 = new i(this.u.get());
                this.f2529l = iVar3;
                String v2 = v();
                Object obj = g.a;
                boolean w = w();
                this.b = new h0("com.google.android.gms", v2, false, 4225, w);
                if (!w || p() >= 17895000) {
                    g gVar3 = this.f2521d;
                    String str4 = this.b.a;
                    Objects.requireNonNull(str4, "null reference");
                    Objects.requireNonNull(this.b);
                    if (!gVar3.a(new g.a(str4, "com.google.android.gms", 4225, this.b.b), iVar3, A())) {
                        String str5 = this.b.a;
                        StringBuilder sb2 = new StringBuilder(String.valueOf(str5).length() + 34 + "com.google.android.gms".length());
                        sb2.append("unable to connect to service: ");
                        sb2.append(str5);
                        sb2.append(" on ");
                        sb2.append("com.google.android.gms");
                        Log.e("GmsClient", sb2.toString());
                        int i3 = this.u.get();
                        Handler handler = this.f2522e;
                        handler.sendMessage(handler.obtainMessage(7, i3, -1, new l(16)));
                    }
                } else {
                    String valueOf = String.valueOf(this.b.a);
                    throw new IllegalStateException(valueOf.length() != 0 ? "Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(valueOf) : new String("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: "));
                }
            } else if (i2 == 4) {
                Objects.requireNonNull(t2, "null reference");
                x(t2);
            }
        }
    }

    public void a(@RecentlyNonNull e eVar) {
        r rVar = (r) eVar;
        f.b.a.c.b.l.l.e.this.f2501j.post(new s(rVar));
    }

    @RecentlyNonNull
    public boolean b() {
        boolean z;
        synchronized (this.f2523f) {
            int i2 = this.m;
            if (i2 != 2) {
                if (i2 != 3) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    @RecentlyNullable
    public final f.b.a.c.b.c[] c() {
        z zVar = this.t;
        if (zVar == null) {
            return null;
        }
        return zVar.c;
    }

    @RecentlyNonNull
    public boolean d() {
        boolean z;
        synchronized (this.f2523f) {
            z = this.m == 4;
        }
        return z;
    }

    @RecentlyNonNull
    public String e() {
        h0 h0Var;
        if (!d() || (h0Var = this.b) == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        Objects.requireNonNull(h0Var);
        return "com.google.android.gms";
    }

    @RecentlyNullable
    public String f() {
        return this.a;
    }

    public void h(h hVar, @RecentlyNonNull Set<Scope> set) {
        Bundle s2 = s();
        e eVar = new e(this.p);
        eVar.f2551e = this.c.getPackageName();
        eVar.f2554h = s2;
        if (set != null) {
            eVar.f2553g = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (l()) {
            Account account = ((f) this).x;
            if (account == null) {
                account = new Account("<<default account>>", "com.google");
            }
            eVar.f2555i = account;
            if (hVar != null) {
                eVar.f2552f = hVar.asBinder();
            }
        }
        eVar.f2556j = v;
        eVar.f2557k = r();
        if (z()) {
            eVar.n = true;
        }
        try {
            synchronized (this.f2524g) {
                k kVar = this.f2525h;
                if (kVar != null) {
                    kVar.y(new j(this, this.u.get()), eVar);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e2) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            Handler handler = this.f2522e;
            handler.sendMessage(handler.obtainMessage(6, this.u.get(), 3));
        } catch (SecurityException e3) {
            throw e3;
        } catch (RemoteException | RuntimeException e4) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e4);
            int i2 = this.u.get();
            Handler handler2 = this.f2522e;
            handler2.sendMessage(handler2.obtainMessage(1, i2, -1, new k(8, null, null)));
        }
    }

    public void i(@RecentlyNonNull c cVar) {
        m.h.p(cVar, "Connection progress callbacks cannot be null.");
        this.f2526i = cVar;
        B(2, null);
    }

    public void j() {
        this.u.incrementAndGet();
        synchronized (this.f2528k) {
            int size = this.f2528k.size();
            for (int i2 = 0; i2 < size; i2++) {
                h<?> hVar = this.f2528k.get(i2);
                synchronized (hVar) {
                    hVar.a = null;
                }
            }
            this.f2528k.clear();
        }
        synchronized (this.f2524g) {
            this.f2525h = null;
        }
        B(1, null);
    }

    public void k(@RecentlyNonNull String str) {
        this.a = str;
        j();
    }

    @RecentlyNonNull
    public boolean l() {
        return false;
    }

    @RecentlyNonNull
    public boolean o() {
        return true;
    }

    @RecentlyNonNull
    public abstract int p();

    @RecentlyNullable
    public abstract T q(@RecentlyNonNull IBinder iBinder);

    @RecentlyNonNull
    public f.b.a.c.b.c[] r() {
        return v;
    }

    @RecentlyNonNull
    public Bundle s() {
        return new Bundle();
    }

    @RecentlyNonNull
    public final T t() {
        T t2;
        synchronized (this.f2523f) {
            if (this.m == 5) {
                throw new DeadObjectException();
            } else if (d()) {
                T t3 = this.f2527j;
                m.h.p(t3, "Client is connected but service is null");
                t2 = t3;
            } else {
                throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
            }
        }
        return t2;
    }

    public abstract String u();

    public abstract String v();

    @RecentlyNonNull
    public boolean w() {
        return false;
    }

    public void x(@RecentlyNonNull T t2) {
        System.currentTimeMillis();
    }

    public void y(@RecentlyNonNull int i2) {
        System.currentTimeMillis();
    }

    @RecentlyNonNull
    public boolean z() {
        return false;
    }
}
