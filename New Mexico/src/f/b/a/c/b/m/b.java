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
/* loaded from: classes.dex */
public abstract class b<T extends IInterface> {
    public static final f.b.a.c.b.c[] v = new f.b.a.c.b.c[0];
    public h0 b;
    public final Context c;

    /* renamed from: d */
    public final g f2705d;

    /* renamed from: e */
    public final Handler f2706e;

    /* renamed from: h */
    public k f2709h;
    @RecentlyNonNull

    /* renamed from: i */
    public c f2710i;

    /* renamed from: j */
    public T f2711j;

    /* renamed from: l */
    public i f2713l;
    public final a n;
    public final AbstractC0086b o;
    public final int p;
    public final String q;
    public volatile String a = null;

    /* renamed from: f */
    public final Object f2707f = new Object();

    /* renamed from: g */
    public final Object f2708g = new Object();

    /* renamed from: k */
    public final ArrayList<h<?>> f2712k = new ArrayList<>();
    public int m = 1;
    public f.b.a.c.b.a r = null;
    public boolean s = false;
    public volatile z t = null;
    @RecentlyNonNull
    public AtomicInteger u = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public interface a {
    }

    /* renamed from: f.b.a.c.b.m.b$b */
    /* loaded from: classes.dex */
    public interface AbstractC0086b {
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(@RecentlyNonNull f.b.a.c.b.a aVar);
    }

    /* loaded from: classes.dex */
    public class d implements c {
        public d() {
            b.this = r1;
        }

        @Override // f.b.a.c.b.m.b.c
        public void a(@RecentlyNonNull f.b.a.c.b.a aVar) {
            if (aVar.d()) {
                b bVar = b.this;
                bVar.h(null, ((f) bVar).w);
                return;
            }
            AbstractC0086b bVar2 = b.this.o;
            if (bVar2 != null) {
                ((s) bVar2).a.p(aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface e {
    }

    /* loaded from: classes.dex */
    public abstract class f extends h<Boolean> {

        /* renamed from: d */
        public final int f2714d;

        /* renamed from: e */
        public final Bundle f2715e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(int i2, Bundle bundle) {
            super(Boolean.TRUE);
            b.this = r2;
            this.f2714d = i2;
            this.f2715e = bundle;
        }

        @Override // f.b.a.c.b.m.b.h
        public final /* synthetic */ void a(Boolean bool) {
            PendingIntent pendingIntent = null;
            if (this.f2714d != 0) {
                b.this.B(1, null);
                Bundle bundle = this.f2715e;
                if (bundle != null) {
                    pendingIntent = (PendingIntent) bundle.getParcelable("pendingIntent");
                }
                d(new f.b.a.c.b.a(this.f2714d, pendingIntent));
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

    /* loaded from: classes.dex */
    public final class g extends f.b.a.c.e.b.d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Looper looper) {
            super(looper);
            b.this = r1;
        }

        public static boolean a(Message message) {
            int i2 = message.what;
            return i2 == 2 || i2 == 1 || i2 == 7;
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
            if (r0 == 5) goto L_0x0031;
         */
        @Override // android.os.Handler
        /* Code decompiled incorrectly, please refer to instructions dump */
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
                    bVar3.f2710i.a(aVar);
                    Objects.requireNonNull(b.this);
                    System.currentTimeMillis();
                } else if (i3 == 5) {
                    b bVar4 = b.this;
                    f.b.a.c.b.a aVar2 = bVar4.r;
                    if (aVar2 == null) {
                        aVar2 = new f.b.a.c.b.a(8);
                    }
                    bVar4.f2710i.a(aVar2);
                    Objects.requireNonNull(b.this);
                    System.currentTimeMillis();
                } else if (i3 == 3) {
                    Object obj = message.obj;
                    if (obj instanceof PendingIntent) {
                        pendingIntent = (PendingIntent) obj;
                    }
                    b.this.f2710i.a(new f.b.a.c.b.a(message.arg2, pendingIntent));
                    Objects.requireNonNull(b.this);
                    System.currentTimeMillis();
                } else if (i3 == 6) {
                    b.this.B(5, null);
                    a aVar3 = b.this.n;
                    if (aVar3 != null) {
                        ((r) aVar3).a.z(message.arg2);
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
                            String.valueOf(hVar3).length();
                        }
                    }
                    if (tlistener != 0) {
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
                    new Exception();
                }
            } else if (a(message)) {
                h hVar4 = (h) message.obj;
                hVar4.b();
                hVar4.c();
            }
        }
    }

    /* loaded from: classes.dex */
    public abstract class h<TListener> {
        public TListener a;
        public boolean b = false;

        public h(TListener tlistener) {
            b.this = r1;
            this.a = tlistener;
        }

        public abstract void a(TListener tlistener);

        public abstract void b();

        public final void c() {
            synchronized (this) {
                this.a = null;
            }
            synchronized (b.this.f2712k) {
                b.this.f2712k.remove(this);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class i implements ServiceConnection {
        public final int a;

        public i(int i2) {
            b.this = r1;
            this.a = i2;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b bVar = b.this;
            if (iBinder == null) {
                b.C(bVar);
                return;
            }
            synchronized (bVar.f2708g) {
                b bVar2 = b.this;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                bVar2.f2709h = (queryLocalInterface == null || !(queryLocalInterface instanceof k)) ? new j(iBinder) : (k) queryLocalInterface;
            }
            b bVar3 = b.this;
            int i2 = this.a;
            Handler handler = bVar3.f2706e;
            handler.sendMessage(handler.obtainMessage(7, i2, -1, new l(0)));
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            b bVar;
            synchronized (b.this.f2708g) {
                bVar = b.this;
                bVar.f2709h = null;
            }
            Handler handler = bVar.f2706e;
            handler.sendMessage(handler.obtainMessage(6, this.a, 1));
        }
    }

    /* loaded from: classes.dex */
    public static final class j extends i.a {
        public b a;
        public final int b;

        public j(b bVar, int i2) {
            this.a = bVar;
            this.b = i2;
        }

        public final void z(int i2, IBinder iBinder, Bundle bundle) {
            m.e.r(this.a, "onPostInitComplete can be called only once per call to getRemoteService");
            b bVar = this.a;
            int i3 = this.b;
            Handler handler = bVar.f2706e;
            handler.sendMessage(handler.obtainMessage(1, i3, -1, new k(i2, iBinder, bundle)));
            this.a = null;
        }
    }

    /* loaded from: classes.dex */
    public final class k extends f {

        /* renamed from: g */
        public final IBinder f2717g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(int i2, IBinder iBinder, Bundle bundle) {
            super(i2, bundle);
            b.this = r1;
            this.f2717g = iBinder;
        }

        @Override // f.b.a.c.b.m.b.f
        public final void d(f.b.a.c.b.a aVar) {
            AbstractC0086b bVar = b.this.o;
            if (bVar != null) {
                ((s) bVar).a.p(aVar);
            }
            Objects.requireNonNull(b.this);
            System.currentTimeMillis();
        }

        @Override // f.b.a.c.b.m.b.f
        public final boolean e() {
            try {
                IBinder iBinder = this.f2717g;
                Objects.requireNonNull(iBinder, "null reference");
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if (!b.this.u().equals(interfaceDescriptor)) {
                    String.valueOf(b.this.u()).length();
                    String.valueOf(interfaceDescriptor).length();
                    return false;
                }
                IInterface q = b.this.q(this.f2717g);
                if (q == null) {
                    return false;
                }
                if (!b.D(b.this, 2, 4, q) && !b.D(b.this, 3, 4, q)) {
                    return false;
                }
                b bVar = b.this;
                bVar.r = null;
                a aVar = bVar.n;
                if (aVar != null) {
                    ((r) aVar).a.Q(null);
                }
                return true;
            } catch (RemoteException unused) {
                return false;
            }
        }
    }

    /* loaded from: classes.dex */
    public final class l extends f {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(int i2) {
            super(i2, null);
            b.this = r2;
        }

        @Override // f.b.a.c.b.m.b.f
        public final void d(f.b.a.c.b.a aVar) {
            Objects.requireNonNull(b.this);
            b.this.f2710i.a(aVar);
            Objects.requireNonNull(b.this);
            System.currentTimeMillis();
        }

        @Override // f.b.a.c.b.m.b.f
        public final boolean e() {
            b.this.f2710i.a(f.b.a.c.b.a.f2666f);
            return true;
        }
    }

    public b(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull g gVar, @RecentlyNonNull f.b.a.c.b.e eVar, @RecentlyNonNull int i2, a aVar, AbstractC0086b bVar, String str) {
        m.e.r(context, "Context must not be null");
        this.c = context;
        m.e.r(looper, "Looper must not be null");
        m.e.r(gVar, "Supervisor must not be null");
        this.f2705d = gVar;
        m.e.r(eVar, "API availability must not be null");
        this.f2706e = new g(looper);
        this.p = i2;
        this.n = aVar;
        this.o = bVar;
        this.q = str;
    }

    public static void C(b bVar) {
        boolean z;
        int i2;
        synchronized (bVar.f2707f) {
            z = bVar.m == 3;
        }
        if (z) {
            i2 = 5;
            bVar.s = true;
        } else {
            i2 = 4;
        }
        Handler handler = bVar.f2706e;
        handler.sendMessage(handler.obtainMessage(i2, bVar.u.get(), 16));
    }

    public static boolean D(b bVar, int i2, int i3, IInterface iInterface) {
        boolean z;
        synchronized (bVar.f2707f) {
            if (bVar.m != i2) {
                z = false;
            } else {
                bVar.B(i3, iInterface);
                z = true;
            }
        }
        return z;
    }

    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException
        	at java.util.BitSet.or(BitSet.java:940)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:668)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:728)
        	at jadx.core.dex.visitors.regions.IfMakerHelper.restructureIf(IfMakerHelper.java:88)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:706)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:731)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public static boolean E(f.b.a.c.b.m.b r2) {
        /*
            boolean r0 = r2.s
            r1 = 0
            if (r0 == 0) goto L_0x0006
            goto L_0x0021
        L_0x0006:
            java.lang.String r0 = r2.u()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0011
            goto L_0x0021
        L_0x0011:
            r0 = 0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0019
            goto L_0x0021
        L_0x0019:
            java.lang.String r2 = r2.u()     // Catch: ClassNotFoundException -> 0x0021
            java.lang.Class.forName(r2)     // Catch: ClassNotFoundException -> 0x0021
            r1 = 1
        L_0x0021:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: f.b.a.c.b.m.b.E(f.b.a.c.b.m.b):boolean");
    }

    public final String A() {
        String str = this.q;
        return str == null ? this.c.getClass().getName() : str;
    }

    public final void B(int i2, T t) {
        h0 h0Var;
        boolean z = false;
        if ((i2 == 4) == (t != null)) {
            z = true;
        }
        m.e.h(z);
        synchronized (this.f2707f) {
            this.m = i2;
            this.f2711j = t;
            if (i2 == 1) {
                i iVar = this.f2713l;
                if (iVar != null) {
                    g gVar = this.f2705d;
                    String str = this.b.a;
                    Objects.requireNonNull(str, "null reference");
                    Objects.requireNonNull(this.b);
                    String A = A();
                    boolean z2 = this.b.b;
                    Objects.requireNonNull(gVar);
                    gVar.b(new g.a(str, "com.google.android.gms", 4225, z2), iVar, A);
                    this.f2713l = null;
                }
            } else if (i2 == 2 || i2 == 3) {
                i iVar2 = this.f2713l;
                if (!(iVar2 == null || (h0Var = this.b) == null)) {
                    String.valueOf(h0Var.a).length();
                    "com.google.android.gms".length();
                    g gVar2 = this.f2705d;
                    String str2 = this.b.a;
                    Objects.requireNonNull(str2, "null reference");
                    Objects.requireNonNull(this.b);
                    String A2 = A();
                    boolean z3 = this.b.b;
                    Objects.requireNonNull(gVar2);
                    gVar2.b(new g.a(str2, "com.google.android.gms", 4225, z3), iVar2, A2);
                    this.u.incrementAndGet();
                }
                i iVar3 = new i(this.u.get());
                this.f2713l = iVar3;
                String v2 = v();
                Object obj = g.a;
                boolean w = w();
                this.b = new h0("com.google.android.gms", v2, false, 4225, w);
                if (!w || p() >= 17895000) {
                    g gVar3 = this.f2705d;
                    String str3 = this.b.a;
                    Objects.requireNonNull(str3, "null reference");
                    Objects.requireNonNull(this.b);
                    if (!gVar3.a(new g.a(str3, "com.google.android.gms", 4225, this.b.b), iVar3, A())) {
                        String.valueOf(this.b.a).length();
                        "com.google.android.gms".length();
                        int i3 = this.u.get();
                        Handler handler = this.f2706e;
                        handler.sendMessage(handler.obtainMessage(7, i3, -1, new l(16)));
                    }
                } else {
                    String valueOf = String.valueOf(this.b.a);
                    throw new IllegalStateException(valueOf.length() != 0 ? "Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(valueOf) : new String("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: "));
                }
            } else if (i2 == 4) {
                Objects.requireNonNull(t, "null reference");
                x(t);
            }
        }
    }

    public void a(@RecentlyNonNull e eVar) {
        r rVar = (r) eVar;
        f.b.a.c.b.l.l.e.this.f2685j.post(new s(rVar));
    }

    @RecentlyNonNull
    public boolean b() {
        boolean z;
        synchronized (this.f2707f) {
            int i2 = this.m;
            if (!(i2 == 2 || i2 == 3)) {
                z = false;
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
        synchronized (this.f2707f) {
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
        Bundle s = s();
        e eVar = new e(this.p);
        eVar.f2735e = this.c.getPackageName();
        eVar.f2738h = s;
        if (set != null) {
            eVar.f2737g = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (l()) {
            Account account = ((f) this).x;
            if (account == null) {
                account = new Account("<<default account>>", "com.google");
            }
            eVar.f2739i = account;
            if (hVar != null) {
                eVar.f2736f = hVar.asBinder();
            }
        }
        eVar.f2740j = v;
        eVar.f2741k = r();
        if (z()) {
            eVar.n = true;
        }
        try {
            try {
                synchronized (this.f2708g) {
                    k kVar = this.f2709h;
                    if (kVar != null) {
                        kVar.K(new j(this, this.u.get()), eVar);
                    }
                }
            } catch (RemoteException | RuntimeException unused) {
                int i2 = this.u.get();
                Handler handler = this.f2706e;
                handler.sendMessage(handler.obtainMessage(1, i2, -1, new k(8, null, null)));
            }
        } catch (DeadObjectException unused2) {
            Handler handler2 = this.f2706e;
            handler2.sendMessage(handler2.obtainMessage(6, this.u.get(), 3));
        } catch (SecurityException e2) {
            throw e2;
        }
    }

    public void i(@RecentlyNonNull c cVar) {
        m.e.r(cVar, "Connection progress callbacks cannot be null.");
        this.f2710i = cVar;
        B(2, null);
    }

    public void j() {
        this.u.incrementAndGet();
        synchronized (this.f2712k) {
            int size = this.f2712k.size();
            for (int i2 = 0; i2 < size; i2++) {
                h<?> hVar = this.f2712k.get(i2);
                synchronized (hVar) {
                    hVar.a = null;
                }
            }
            this.f2712k.clear();
        }
        synchronized (this.f2708g) {
            this.f2709h = null;
        }
        B(1, null);
    }

    public void k(@RecentlyNonNull String str) {
        this.a = str;
        j();
    }

    @Override // f.b.a.c.b.l.a.e
    @RecentlyNonNull
    public boolean l() {
        return false;
    }

    @Override // f.b.a.c.b.l.a.e
    @RecentlyNonNull
    public boolean o() {
        return true;
    }

    @Override // f.b.a.c.b.l.a.e
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
        T t;
        synchronized (this.f2707f) {
            if (this.m == 5) {
                throw new DeadObjectException();
            } else if (d()) {
                T t2 = this.f2711j;
                m.e.r(t2, "Client is connected but service is null");
                t = t2;
            } else {
                throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
            }
        }
        return t;
    }

    public abstract String u();

    public abstract String v();

    @RecentlyNonNull
    public boolean w() {
        return false;
    }

    public void x(@RecentlyNonNull T t) {
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
