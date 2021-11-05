package b.t.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import c.b.c.a.b0.f;
import c.b.c.a.f0.a.a;
import c.b.c.a.h;
import c.b.c.a.i0.s;
import c.b.c.a.i0.u;
import c.b.c.a.j;
import c.b.c.a.m0.h;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a implements SharedPreferences {

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f1714a;

    /* renamed from: b  reason: collision with root package name */
    public final List<SharedPreferences.OnSharedPreferenceChangeListener> f1715b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final String f1716c;

    /* renamed from: d  reason: collision with root package name */
    public final c.b.c.a.a f1717d;

    /* renamed from: e  reason: collision with root package name */
    public final c.b.c.a.c f1718e;

    /* renamed from: b.t.a.a$a  reason: collision with other inner class name */
    public static final class SharedPreferences$EditorC0041a implements SharedPreferences.Editor {

        /* renamed from: a  reason: collision with root package name */
        public final a f1719a;

        /* renamed from: b  reason: collision with root package name */
        public final SharedPreferences.Editor f1720b;

        /* renamed from: c  reason: collision with root package name */
        public final List<String> f1721c;

        /* renamed from: d  reason: collision with root package name */
        public AtomicBoolean f1722d = new AtomicBoolean(false);

        public SharedPreferences$EditorC0041a(a aVar, SharedPreferences.Editor editor) {
            this.f1719a = aVar;
            this.f1720b = editor;
            this.f1721c = new CopyOnWriteArrayList();
        }

        public final void a() {
            if (this.f1722d.getAndSet(false)) {
                for (String str : ((HashMap) this.f1719a.getAll()).keySet()) {
                    if (!this.f1721c.contains(str) && !this.f1719a.d(str)) {
                        this.f1720b.remove(this.f1719a.b(str));
                    }
                }
            }
        }

        public void apply() {
            a();
            this.f1720b.apply();
            b();
            this.f1721c.clear();
        }

        public final void b() {
            for (SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : this.f1719a.f1715b) {
                for (String str : this.f1721c) {
                    onSharedPreferenceChangeListener.onSharedPreferenceChanged(this.f1719a, str);
                }
            }
        }

        public final void c(String str, byte[] bArr) {
            if (!this.f1719a.d(str)) {
                this.f1721c.add(str);
                if (str == null) {
                    str = "__NULL__";
                }
                try {
                    a aVar = this.f1719a;
                    String b2 = aVar.b(str);
                    Pair pair = new Pair(b2, h.b(aVar.f1717d.a(bArr, b2.getBytes(StandardCharsets.UTF_8))));
                    this.f1720b.putString((String) pair.first, (String) pair.second);
                } catch (GeneralSecurityException e2) {
                    StringBuilder g = c.a.a.a.a.g("Could not encrypt data: ");
                    g.append(e2.getMessage());
                    throw new SecurityException(g.toString(), e2);
                }
            } else {
                throw new SecurityException(c.a.a.a.a.o(str, " is a reserved key for the encryption keyset."));
            }
        }

        public SharedPreferences.Editor clear() {
            this.f1722d.set(true);
            return this;
        }

        public boolean commit() {
            a();
            try {
                return this.f1720b.commit();
            } finally {
                b();
                this.f1721c.clear();
            }
        }

        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            ByteBuffer allocate = ByteBuffer.allocate(5);
            allocate.putInt(b.BOOLEAN.f1726b);
            allocate.put(z ? (byte) 1 : 0);
            c(str, allocate.array());
            return this;
        }

        public SharedPreferences.Editor putFloat(String str, float f) {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.putInt(b.FLOAT.f1726b);
            allocate.putFloat(f);
            c(str, allocate.array());
            return this;
        }

        public SharedPreferences.Editor putInt(String str, int i) {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.putInt(b.INT.f1726b);
            allocate.putInt(i);
            c(str, allocate.array());
            return this;
        }

        public SharedPreferences.Editor putLong(String str, long j) {
            ByteBuffer allocate = ByteBuffer.allocate(12);
            allocate.putInt(b.LONG.f1726b);
            allocate.putLong(j);
            c(str, allocate.array());
            return this;
        }

        public SharedPreferences.Editor putString(String str, String str2) {
            if (str2 == null) {
                str2 = "__NULL__";
            }
            byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
            int length = bytes.length;
            ByteBuffer allocate = ByteBuffer.allocate(length + 8);
            allocate.putInt(b.STRING.f1726b);
            allocate.putInt(length);
            allocate.put(bytes);
            c(str, allocate.array());
            return this;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:0:0x0000 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v0, types: [java.util.Set<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r6v1, types: [java.util.Set] */
        /* JADX WARN: Type inference failed for: r6v5, types: [b.e.c] */
        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            if (set == 0) {
                set = new b.e.c<>();
                set.add("__NULL__");
            }
            ArrayList arrayList = new ArrayList(set.size());
            int size = set.size() * 4;
            for (String str2 : set) {
                byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
                arrayList.add(bytes);
                size += bytes.length;
            }
            ByteBuffer allocate = ByteBuffer.allocate(size + 4);
            allocate.putInt(b.STRING_SET.f1726b);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                byte[] bArr = (byte[]) it.next();
                allocate.putInt(bArr.length);
                allocate.put(bArr);
            }
            c(str, allocate.array());
            return this;
        }

        public SharedPreferences.Editor remove(String str) {
            if (!this.f1719a.d(str)) {
                this.f1720b.remove(this.f1719a.b(str));
                this.f1721c.remove(str);
                return this;
            }
            throw new SecurityException(c.a.a.a.a.o(str, " is a reserved key for the encryption keyset."));
        }
    }

    public enum b {
        STRING(0),
        STRING_SET(1),
        INT(2),
        LONG(3),
        FLOAT(4),
        BOOLEAN(5);
        

        /* renamed from: b  reason: collision with root package name */
        public final int f1726b;

        /* access modifiers changed from: public */
        b(int i2) {
            this.f1726b = i2;
        }
    }

    /* JADX WARN: Init of enum c can be incorrect */
    public enum c {
        AES256_SIV(c.b.c.a.h.a("type.googleapis.com/google.crypto.tink.AesSivKey", ((u) r2.b()).toByteArray(), r1));
        

        /* renamed from: b  reason: collision with root package name */
        public final c.b.c.a.h f1729b;

        /* access modifiers changed from: public */
        static {
            h.a aVar = h.a.TINK;
            u.b bVar = (u.b) u.DEFAULT_INSTANCE.e();
            bVar.d();
            ((u) bVar.f3674c).keySize_ = 64;
            new c.b.c.a.d0.a();
        }

        /* access modifiers changed from: public */
        c(c.b.c.a.h hVar) {
            this.f1729b = hVar;
        }
    }

    /* JADX WARN: Init of enum c can be incorrect */
    public enum d {
        AES256_GCM(c.b.c.a.h.a("type.googleapis.com/google.crypto.tink.AesGcmKey", ((s) r2.b()).toByteArray(), r1));
        

        /* renamed from: b  reason: collision with root package name */
        public final c.b.c.a.h f1732b;

        /* access modifiers changed from: public */
        static {
            h.a aVar = h.a.TINK;
            s.b bVar = (s.b) s.DEFAULT_INSTANCE.e();
            bVar.d();
            ((s) bVar.f3674c).keySize_ = 32;
            new f();
        }

        /* access modifiers changed from: public */
        d(c.b.c.a.h hVar) {
            this.f1732b = hVar;
        }
    }

    public a(String str, String str2, SharedPreferences sharedPreferences, c.b.c.a.a aVar, c.b.c.a.c cVar) {
        this.f1716c = str;
        this.f1714a = sharedPreferences;
        this.f1717d = aVar;
        this.f1718e = cVar;
    }

    public static SharedPreferences a(Context context, String str, b bVar, c cVar, d dVar) {
        j b2;
        j b3;
        String str2 = bVar.f1733a;
        c.b.c.a.c0.a.a();
        Context applicationContext = context.getApplicationContext();
        a.b bVar2 = new a.b();
        bVar2.f = cVar.f1729b;
        bVar2.e(applicationContext, "__androidx_security_crypto_encrypted_prefs_key_keyset__", str);
        bVar2.d("android-keystore://" + str2);
        c.b.c.a.f0.a.a a2 = bVar2.a();
        synchronized (a2) {
            b2 = a2.f3453a.b();
        }
        a.b bVar3 = new a.b();
        bVar3.f = dVar.f1732b;
        bVar3.e(applicationContext, "__androidx_security_crypto_encrypted_prefs_value_keyset__", str);
        bVar3.d("android-keystore://" + str2);
        c.b.c.a.f0.a.a a3 = bVar3.a();
        synchronized (a3) {
            b3 = a3.f3453a.b();
        }
        c.b.c.a.c cVar2 = (c.b.c.a.c) b2.b(c.b.c.a.c.class);
        return new a(str, str2, applicationContext.getSharedPreferences(str, 0), (c.b.c.a.a) b3.b(c.b.c.a.a.class), cVar2);
    }

    public String b(String str) {
        if (str == null) {
            str = "__NULL__";
        }
        try {
            return c.b.c.a.m0.h.b(this.f1718e.a(str.getBytes(StandardCharsets.UTF_8), this.f1716c.getBytes()));
        } catch (GeneralSecurityException e2) {
            StringBuilder g = c.a.a.a.a.g("Could not encrypt key. ");
            g.append(e2.getMessage());
            throw new SecurityException(g.toString(), e2);
        }
    }

    public final Object c(String str) {
        if (!d(str)) {
            if (str == null) {
                str = "__NULL__";
            }
            try {
                String b2 = b(str);
                String string = this.f1714a.getString(b2, null);
                if (string == null) {
                    return null;
                }
                boolean z = false;
                ByteBuffer wrap = ByteBuffer.wrap(this.f1717d.b(c.b.c.a.m0.h.a(string, 0), b2.getBytes(StandardCharsets.UTF_8)));
                wrap.position(0);
                int i = wrap.getInt();
                int ordinal = (i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? null : b.BOOLEAN : b.FLOAT : b.LONG : b.INT : b.STRING_SET : b.STRING).ordinal();
                if (ordinal == 0) {
                    int i2 = wrap.getInt();
                    ByteBuffer slice = wrap.slice();
                    wrap.limit(i2);
                    String charBuffer = StandardCharsets.UTF_8.decode(slice).toString();
                    if (charBuffer.equals("__NULL__")) {
                        return null;
                    }
                    return charBuffer;
                } else if (ordinal == 1) {
                    b.e.c cVar = new b.e.c();
                    while (wrap.hasRemaining()) {
                        int i3 = wrap.getInt();
                        ByteBuffer slice2 = wrap.slice();
                        slice2.limit(i3);
                        wrap.position(wrap.position() + i3);
                        cVar.add(StandardCharsets.UTF_8.decode(slice2).toString());
                    }
                    if (cVar.f798d != 1 || !"__NULL__".equals(cVar.f797c[0])) {
                        return cVar;
                    }
                    return null;
                } else if (ordinal == 2) {
                    return Integer.valueOf(wrap.getInt());
                } else {
                    if (ordinal == 3) {
                        return Long.valueOf(wrap.getLong());
                    }
                    if (ordinal == 4) {
                        return Float.valueOf(wrap.getFloat());
                    }
                    if (ordinal != 5) {
                        return null;
                    }
                    if (wrap.get() != 0) {
                        z = true;
                    }
                    return Boolean.valueOf(z);
                }
            } catch (GeneralSecurityException e2) {
                StringBuilder g = c.a.a.a.a.g("Could not decrypt value. ");
                g.append(e2.getMessage());
                throw new SecurityException(g.toString(), e2);
            }
        } else {
            throw new SecurityException(c.a.a.a.a.o(str, " is a reserved key for the encryption keyset."));
        }
    }

    public boolean contains(String str) {
        if (!d(str)) {
            return this.f1714a.contains(b(str));
        }
        throw new SecurityException(c.a.a.a.a.o(str, " is a reserved key for the encryption keyset."));
    }

    public boolean d(String str) {
        return "__androidx_security_crypto_encrypted_prefs_key_keyset__".equals(str) || "__androidx_security_crypto_encrypted_prefs_value_keyset__".equals(str);
    }

    public SharedPreferences.Editor edit() {
        return new SharedPreferences$EditorC0041a(this, this.f1714a.edit());
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, ?> entry : this.f1714a.getAll().entrySet()) {
            if (!d(entry.getKey())) {
                try {
                    String str = new String(this.f1718e.b(c.b.c.a.m0.h.a(entry.getKey(), 0), this.f1716c.getBytes()), StandardCharsets.UTF_8);
                    if (str.equals("__NULL__")) {
                        str = null;
                    }
                    hashMap.put(str, c(str));
                } catch (GeneralSecurityException e2) {
                    StringBuilder g = c.a.a.a.a.g("Could not decrypt key. ");
                    g.append(e2.getMessage());
                    throw new SecurityException(g.toString(), e2);
                }
            }
        }
        return hashMap;
    }

    public boolean getBoolean(String str, boolean z) {
        Object c2 = c(str);
        return (c2 == null || !(c2 instanceof Boolean)) ? z : ((Boolean) c2).booleanValue();
    }

    public float getFloat(String str, float f) {
        Object c2 = c(str);
        return (c2 == null || !(c2 instanceof Float)) ? f : ((Float) c2).floatValue();
    }

    public int getInt(String str, int i) {
        Object c2 = c(str);
        return (c2 == null || !(c2 instanceof Integer)) ? i : ((Integer) c2).intValue();
    }

    public long getLong(String str, long j) {
        Object c2 = c(str);
        return (c2 == null || !(c2 instanceof Long)) ? j : ((Long) c2).longValue();
    }

    public String getString(String str, String str2) {
        Object c2 = c(str);
        return (c2 == null || !(c2 instanceof String)) ? str2 : (String) c2;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        Object c2 = c(str);
        Set<String> cVar = c2 instanceof Set ? (Set) c2 : new b.e.c<>();
        return cVar.size() > 0 ? cVar : set;
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f1715b.add(onSharedPreferenceChangeListener);
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f1715b.remove(onSharedPreferenceChangeListener);
    }
}
