package c.b.c.a;

import c.b.c.a.i0.v0;
import c.b.c.a.i0.w0;
import c.b.c.a.i0.x0;
import c.b.c.a.i0.z0;
import c.b.c.a.j0.a.i;
import c.b.c.a.j0.a.r0;
import c.b.c.a.p;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f5225a = Logger.getLogger(y.class.getName());

    /* renamed from: b  reason: collision with root package name */
    public static final ConcurrentMap<String, a> f5226b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    public static final ConcurrentMap<String, Object> f5227c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    public static final ConcurrentMap<String, Boolean> f5228d = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    public static final ConcurrentMap<Class<?>, q<?>> f5229e = new ConcurrentHashMap();

    public interface a {
        <P> f<P> a(Class<P> cls);

        Set<Class<?>> b();

        f<?> c();

        Class<?> d();

        Class<?> e();
    }

    static {
        new ConcurrentHashMap();
    }

    public static synchronized void a(String str, Class<?> cls, boolean z) {
        synchronized (y.class) {
            if (f5226b.containsKey(str)) {
                a aVar = f5226b.get(str);
                if (!aVar.e().equals(cls)) {
                    Logger logger = f5225a;
                    logger.warning("Attempted overwrite of a registered key manager for key type " + str);
                    throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", str, aVar.e().getName(), cls.getName()));
                } else if (z && !f5228d.get(str).booleanValue()) {
                    throw new GeneralSecurityException("New keys are already disallowed for key type " + str);
                }
            }
        }
    }

    public static synchronized a b(String str) {
        a aVar;
        synchronized (y.class) {
            if (f5226b.containsKey(str)) {
                aVar = f5226b.get(str);
            } else {
                throw new GeneralSecurityException("No key manager found for key type " + str);
            }
        }
        return aVar;
    }

    public static <P> P c(String str, byte[] bArr, Class<P> cls) {
        return (P) d(str, i.e(bArr), cls);
    }

    public static <P> P d(String str, i iVar, Class<P> cls) {
        f<?> fVar;
        a b2 = b(str);
        if (cls == null) {
            fVar = b2.c();
        } else if (b2.b().contains(cls)) {
            fVar = b2.a(cls);
        } else {
            StringBuilder h = c.a.a.a.a.h("Primitive type ");
            h.append(cls.getName());
            h.append(" not supported by key manager of type ");
            h.append(b2.e());
            h.append(", supported primitives: ");
            Set<Class<?>> b3 = b2.b();
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (Class<?> cls2 : b3) {
                if (!z) {
                    sb.append(", ");
                }
                sb.append(cls2.getCanonicalName());
                z = false;
            }
            h.append(sb.toString());
            throw new GeneralSecurityException(h.toString());
        }
        return (P) ((g) fVar).a(iVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0016 A[SYNTHETIC] */
    public static <P> p<P> e(j jVar, Class<P> cls) {
        byte[] bArr;
        List<p.a<P>> put;
        ByteBuffer byteBuffer;
        if (cls != null) {
            w0 w0Var = w0.ENABLED;
            a0.b(jVar.f4884a);
            p<P> pVar = new p<>(cls);
            for (z0.c cVar : jVar.f4884a.key_) {
                if (cVar.s() == w0Var) {
                    Object d2 = d(cVar.q().typeUrl_, cVar.q().value_, cls);
                    if (cVar.s() == w0Var) {
                        int ordinal = cVar.r().ordinal();
                        if (ordinal != 1) {
                            if (ordinal != 2) {
                                if (ordinal == 3) {
                                    bArr = b.f4775a;
                                    p.a<P> aVar = new p.a<>(d2, bArr, cVar.s(), cVar.r(), cVar.keyId_);
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.add(aVar);
                                    String str = new String(aVar.a(), p.f5213d);
                                    put = pVar.f5214a.put(str, Collections.unmodifiableList(arrayList));
                                    if (put != null) {
                                        ArrayList arrayList2 = new ArrayList();
                                        arrayList2.addAll(put);
                                        arrayList2.add(aVar);
                                        pVar.f5214a.put(str, Collections.unmodifiableList(arrayList2));
                                    }
                                    if (cVar.keyId_ != jVar.f4884a.primaryKeyId_) {
                                        continue;
                                    } else if (aVar.f5219c != w0Var) {
                                        throw new IllegalArgumentException("the primary entry has to be ENABLED");
                                    } else if (!pVar.a(aVar.a()).isEmpty()) {
                                        pVar.f5215b = aVar;
                                    } else {
                                        throw new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
                                    }
                                } else if (ordinal != 4) {
                                    throw new GeneralSecurityException("unknown output prefix type");
                                }
                            }
                            byteBuffer = ByteBuffer.allocate(5).put((byte) 0);
                        } else {
                            byteBuffer = ByteBuffer.allocate(5).put((byte) 1);
                        }
                        bArr = byteBuffer.putInt(cVar.keyId_).array();
                        p.a<P> aVar2 = new p.a<>(d2, bArr, cVar.s(), cVar.r(), cVar.keyId_);
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(aVar2);
                        String str2 = new String(aVar2.a(), p.f5213d);
                        put = pVar.f5214a.put(str2, Collections.unmodifiableList(arrayList3));
                        if (put != null) {
                        }
                        if (cVar.keyId_ != jVar.f4884a.primaryKeyId_) {
                        }
                    } else {
                        throw new GeneralSecurityException("only ENABLED key is allowed");
                    }
                }
            }
            return pVar;
        }
        throw null;
    }

    public static synchronized r0 f(x0 x0Var) {
        r0 b2;
        synchronized (y.class) {
            f<?> c2 = b(x0Var.typeUrl_).c();
            if (f5228d.get(x0Var.typeUrl_).booleanValue()) {
                b2 = ((g) c2).b(x0Var.value_);
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type " + x0Var.typeUrl_);
            }
        }
        return b2;
    }

    public static synchronized v0 g(x0 x0Var) {
        v0 c2;
        synchronized (y.class) {
            f<?> c3 = b(x0Var.typeUrl_).c();
            if (f5228d.get(x0Var.typeUrl_).booleanValue()) {
                c2 = ((g) c3).c(x0Var.value_);
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type " + x0Var.typeUrl_);
            }
        }
        return c2;
    }

    public static synchronized <KeyProtoT extends r0, PublicKeyProtoT extends r0> void h(s<KeyProtoT, PublicKeyProtoT> sVar, i<PublicKeyProtoT> iVar, boolean z) {
        Class<?> d2;
        synchronized (y.class) {
            String a2 = sVar.a();
            String a3 = iVar.a();
            a(a2, sVar.getClass(), z);
            a(a3, iVar.getClass(), false);
            if (!a2.equals(a3)) {
                if (f5226b.containsKey(a2) && (d2 = f5226b.get(a2).d()) != null) {
                    if (!d2.equals(iVar.getClass())) {
                        Logger logger = f5225a;
                        logger.warning("Attempted overwrite of a registered key manager for key type " + a2 + " with inconsistent public key type " + a3);
                        throw new GeneralSecurityException(String.format("public key manager corresponding to %s is already registered with %s, cannot be re-registered with %s", sVar.getClass().getName(), d2.getName(), iVar.getClass().getName()));
                    }
                }
                if (!f5226b.containsKey(a2) || f5226b.get(a2).d() == null) {
                    f5226b.put(a2, new w(sVar, iVar));
                    f5227c.put(a2, new x(sVar));
                }
                f5228d.put(a2, Boolean.valueOf(z));
                if (!f5226b.containsKey(a3)) {
                    f5226b.put(a3, new v(iVar));
                }
                f5228d.put(a3, Boolean.FALSE);
            } else {
                throw new GeneralSecurityException("Private and public key type must be different.");
            }
        }
    }

    public static synchronized <KeyProtoT extends r0> void i(i<KeyProtoT> iVar, boolean z) {
        synchronized (y.class) {
            String a2 = iVar.a();
            a(a2, iVar.getClass(), z);
            if (!f5226b.containsKey(a2)) {
                f5226b.put(a2, new v(iVar));
                f5227c.put(a2, new x(iVar));
            }
            f5228d.put(a2, Boolean.valueOf(z));
        }
    }

    public static synchronized <P> void j(q<P> qVar) {
        synchronized (y.class) {
            Class<P> a2 = qVar.a();
            if (f5229e.containsKey(a2)) {
                q<?> qVar2 = f5229e.get(a2);
                if (!qVar.getClass().equals(qVar2.getClass())) {
                    Logger logger = f5225a;
                    logger.warning("Attempted overwrite of a registered SetWrapper for type " + a2);
                    throw new GeneralSecurityException(String.format("SetWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", a2.getName(), qVar2.getClass().getName(), qVar.getClass().getName()));
                }
            }
            f5229e.put(a2, qVar);
        }
    }
}
