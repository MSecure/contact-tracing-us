package f.b.a.a.a;

import android.content.Context;
import android.net.Uri;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import e.b.a.m;
import e.o.a.b;
import f.b.a.a.a.b0.g1;
import f.b.a.a.a.b0.i1;
import f.b.a.a.a.c0.g;
import f.b.a.a.a.h0.f;
import f.b.a.a.a.i0.c;
import f.b.a.a.a.l0.m0;
import f.b.a.a.a.s.d0.a;
import f.b.a.a.a.x.l;
import f.b.a.a.a.x.n;
import f.b.a.a.a.x.p;
import f.b.a.a.a.x.r;
import f.b.a.a.a.x.s;
import f.b.b.b.b;
import f.b.b.b.h;
import g.b.a.c.c.d;
import gov.ut.covid19.exposurenotifications.R;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class e implements b {
    public final /* synthetic */ k a;

    public e(k kVar) {
        this.a = kVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v12, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r5v14, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r5v32, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // e.o.a.b
    public ListenableWorker a(Context context, WorkerParameters workerParameters) {
        Map map;
        int i2;
        boolean z;
        int i3;
        boolean z2;
        int i4;
        k kVar = this.a.s;
        Objects.requireNonNull(kVar);
        Context t = d.t(kVar.c);
        g gVar = kVar.D.get();
        c h2 = kVar.h();
        r rVar = new r(new m0(kVar.v.get()), kVar.D.get(), m.e.e1(kVar.f2257e), kVar.u.get(), kVar.F.get());
        p pVar = kVar.f2264l;
        Context t2 = d.t(kVar.c);
        Objects.requireNonNull(pVar);
        l lVar = new l(Uri.parse(t2.getString(R.string.enx_tekLocalDownloadIndexFile)), Uri.parse(t2.getString(R.string.enx_tekLocalDownloadBasePath)));
        p pVar2 = kVar.f2264l;
        Context t3 = d.t(kVar.c);
        Objects.requireNonNull(pVar2);
        String string = t3.getString(R.string.enx_tekRoamingUrls);
        a aVar = s.a;
        int i5 = 4;
        try {
            JSONObject jSONObject = new JSONObject(string);
            Object[] objArr = new Object[8];
            Iterator<String> keys = jSONObject.keys();
            int i6 = 0;
            while (keys.hasNext()) {
                String next = keys.next();
                JSONArray jSONArray = jSONObject.getJSONArray(next);
                f.b.b.b.a<Object> aVar2 = f.b.b.b.c.c;
                f.b.a.c.b.o.b.y(i5, "initialCapacity");
                Object[] objArr2 = new Object[i5];
                int i7 = 0;
                int i8 = 0;
                while (i7 < jSONArray.length()) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i7);
                    l lVar2 = new l(Uri.parse(jSONObject2.getString("index")), Uri.parse(jSONObject2.getString("base")));
                    int i9 = i8 + 1;
                    if (objArr2.length < i9) {
                        objArr2 = Arrays.copyOf(objArr2, b.AbstractC0103b.b(objArr2.length, i9));
                    }
                    objArr2[i8] = lVar2;
                    i7++;
                    i8 = i9;
                }
                f.b.b.b.c p = f.b.b.b.c.p(objArr2, i8);
                int i10 = i6 + 1;
                int i11 = i10 * 2;
                if (i11 > objArr.length) {
                    objArr = Arrays.copyOf(objArr, b.AbstractC0103b.b(objArr.length, i11));
                }
                f.b.a.c.b.o.b.x(next, p);
                int i12 = i6 * 2;
                objArr[i12] = next;
                objArr[i12 + 1] = p;
                i6 = i10;
                i5 = 4;
            }
            s.a.a("Parsed " + h.d(i6, objArr).f3141g + " region(s) roaming config");
            map = h.d(i6, objArr);
        } catch (Exception e2) {
            s.a.d("Failed to parse JSON roaming download config, continuing with no roaming servers.", e2);
            map = new HashMap();
        }
        n nVar = new n(t, gVar, h2, rVar, lVar, map, kVar.u.get(), kVar.F.get(), kVar.z.get(), kVar.A.get(), m.e.e1(kVar.f2257e));
        i1 i1Var = kVar.w.get();
        g1 g1Var = new g1(kVar.w.get(), new m0(kVar.v.get()), kVar.k(), kVar.b(), m.e.e1(kVar.f2257e), kVar.u.get(), kVar.z.get());
        f fVar = kVar.m;
        Context t4 = d.t(kVar.c);
        Objects.requireNonNull(fVar);
        String string2 = t4.getResources().getString(R.string.enx_symptomOnsetToInfectiousnessMap);
        int integer = t4.getResources().getInteger(R.integer.enx_reportTypeNoneMap);
        String upperCase = string2.substring(2).toUpperCase();
        Objects.requireNonNull(upperCase);
        if (upperCase.length() < 16) {
            StringBuilder sb = new StringBuilder(16);
            for (int length = upperCase.length(); length < 16; length++) {
                sb.append('0');
            }
            sb.append(upperCase);
            upperCase = sb.toString();
        }
        byte[] a2 = f.b.b.c.a.c.a(upperCase);
        int[] iArr = new int[(a2.length * 4)];
        int length2 = a2.length;
        while (true) {
            length2--;
            if (length2 < 0) {
                break;
            }
            byte b = a2[length2];
            for (byte b2 = 3; b2 >= 0; b2 = (byte) (b2 - 1)) {
                iArr[(3 - b2) + (((a2.length - 1) - length2) * 4)] = (byte) (b & 3);
                b = (byte) (b >> 2);
            }
        }
        HashMap hashMap = new HashMap();
        int i13 = -14;
        while (true) {
            i2 = 14;
            if (i13 > 14) {
                break;
            }
            hashMap.put(Integer.valueOf(i13), Integer.valueOf(iArr[i13 + 14]));
            i13++;
        }
        int i14 = 1;
        m.e.k(true, "daysSinceOnsetToInfectiousness must not be null.");
        m.e.j(hashMap.size() <= 29, "the size of daysSinceOnsetToInfectiousness exceeds maximum size %d.", 29);
        Integer[] numArr = new Integer[29];
        Arrays.fill((Object[]) numArr, (Object) 0);
        for (Map.Entry entry : hashMap.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            boolean z3 = Math.abs(intValue) <= i2;
            Object[] objArr3 = new Object[i14];
            objArr3[0] = Integer.valueOf(intValue);
            m.e.j(z3, "Invalid day since onset %d", objArr3);
            boolean z4 = f.b.a.c.f.b.l.a(intValue2) != null;
            Integer valueOf = Integer.valueOf(intValue2);
            m.e.j(z4, "Invalid value of Infectiousness %d", valueOf);
            numArr[intValue + 14] = valueOf;
            i14 = 1;
            i2 = 14;
        }
        List asList = Arrays.asList(numArr);
        int i15 = iArr[29];
        if (f.b.a.c.f.b.l.a(i15) != null) {
            i3 = 1;
            z = true;
        } else {
            i3 = 1;
            z = false;
        }
        Object[] objArr4 = new Object[i3];
        Integer valueOf2 = Integer.valueOf(i15);
        objArr4[0] = valueOf2;
        m.e.j(z, "Invalid value of Infectiousness %d", objArr4);
        m.e.k(integer != 0, "Invalid reportTypeWhenMissing value");
        if (integer < 0 || integer > 5) {
            i4 = 1;
            z2 = false;
        } else {
            i4 = 1;
            z2 = true;
        }
        Object[] objArr5 = new Object[i4];
        objArr5[0] = Integer.valueOf(integer);
        m.e.j(z2, "Invalid value of ReportType %d", objArr5);
        m.e.k(asList != null, "Must set daysSinceOnsetToInfectiousness");
        m.e.k(integer != 0, "Must set reportTypeWhenMissing");
        boolean z5 = i4;
        if (valueOf2 == null) {
            z5 = 0;
        }
        m.e.k(z5, "Must set infectiousnessWhenDaysSinceOnsetMissing");
        DiagnosisKeysDataMapping diagnosisKeysDataMapping = new DiagnosisKeysDataMapping(asList, integer, valueOf2.intValue());
        f.a.a("Created diagnosisKeysDataMapping: " + diagnosisKeysDataMapping);
        return new ProvideDiagnosisKeysWorker(context, workerParameters, nVar, i1Var, g1Var, diagnosisKeysDataMapping, kVar.u.get(), kVar.z.get(), kVar.t(), kVar.A.get());
    }
}
