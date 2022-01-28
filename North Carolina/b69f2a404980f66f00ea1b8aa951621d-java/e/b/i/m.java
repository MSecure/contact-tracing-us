package e.b.i;

import c.b.a.a.c.n.c;
import e.b.h.f;
import e.b.h.i;
import e.b.i.i;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public abstract class m {

    /* renamed from: a  reason: collision with root package name */
    public g f4921a;

    /* renamed from: b  reason: collision with root package name */
    public a f4922b;

    /* renamed from: c  reason: collision with root package name */
    public k f4923c;

    /* renamed from: d  reason: collision with root package name */
    public f f4924d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<i> f4925e;
    public String f;
    public i g;
    public f h;
    public i.h i = new i.h();
    public i.g j = new i.g();

    public e.b.h.i a() {
        int size = this.f4925e.size();
        if (size > 0) {
            return this.f4925e.get(size - 1);
        }
        return null;
    }

    public abstract f b();

    public void c(Reader reader, String str, g gVar) {
        c.K1(reader, "String input must not be null");
        c.K1(str, "BaseURI must not be null");
        f fVar = new f(str);
        this.f4924d = fVar;
        fVar.k = gVar;
        this.f4921a = gVar;
        this.h = gVar.f4888c;
        this.f4922b = new a(reader, 32768);
        this.g = null;
        this.f4923c = new k(this.f4922b, gVar.f4887b);
        this.f4925e = new ArrayList<>(32);
        this.f = str;
    }

    public f d(Reader reader, String str, g gVar) {
        i.c cVar;
        c(reader, str, gVar);
        k kVar = this.f4923c;
        i.j jVar = i.j.EOF;
        while (true) {
            if (!kVar.f4916e) {
                kVar.f4914c.k(kVar, kVar.f4912a);
            } else {
                StringBuilder sb = kVar.g;
                if (sb.length() != 0) {
                    String sb2 = sb.toString();
                    sb.delete(0, sb.length());
                    kVar.f = null;
                    i.c cVar2 = kVar.l;
                    cVar2.f4894b = sb2;
                    cVar = cVar2;
                } else {
                    String str2 = kVar.f;
                    if (str2 != null) {
                        i.c cVar3 = kVar.l;
                        cVar3.f4894b = str2;
                        kVar.f = null;
                        cVar = cVar3;
                    } else {
                        kVar.f4916e = false;
                        cVar = kVar.f4915d;
                    }
                }
                e(cVar);
                cVar.g();
                if (cVar.f4893a == jVar) {
                    break;
                }
            }
        }
        a aVar = this.f4922b;
        Reader reader2 = aVar.f4866b;
        if (reader2 != null) {
            try {
                reader2.close();
            } catch (IOException unused) {
            } catch (Throwable th) {
                aVar.f4866b = null;
                aVar.f4865a = null;
                aVar.h = null;
                throw th;
            }
            aVar.f4866b = null;
            aVar.f4865a = null;
            aVar.h = null;
        }
        this.f4922b = null;
        this.f4923c = null;
        this.f4925e = null;
        return this.f4924d;
    }

    public abstract boolean e(i iVar);

    public boolean f(String str) {
        i iVar = this.g;
        i.g gVar = this.j;
        if (iVar == gVar) {
            i.g gVar2 = new i.g();
            gVar2.f4902b = str;
            gVar2.f4903c = c.C1(str);
            return e(gVar2);
        }
        gVar.g();
        gVar.f4902b = str;
        gVar.f4903c = c.C1(str);
        return e(gVar);
    }

    public boolean g(String str) {
        i.h hVar = this.i;
        if (this.g == hVar) {
            hVar = new i.h();
        } else {
            hVar.s();
        }
        hVar.f4902b = str;
        hVar.f4903c = c.C1(str);
        return e(hVar);
    }
}
