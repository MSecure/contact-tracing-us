package c.b.d;

import c.b.a.a.c.n.c;
import c.b.d.b;
import c.b.d.e1;
import c.b.d.m0;
import c.b.d.p2;
import c.b.d.s;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class a extends b implements e1 {
    public int memoizedSize = -1;

    public interface b {
        void a();
    }

    public static boolean compareBytes(Object obj, Object obj2) {
        return (!(obj instanceof byte[]) || !(obj2 instanceof byte[])) ? toByteString(obj).equals(toByteString(obj2)) : Arrays.equals((byte[]) obj, (byte[]) obj2);
    }

    public static boolean compareFields(Map<s.g, Object> map, Map<s.g, Object> map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (s.g gVar : map.keySet()) {
            if (!map2.containsKey(gVar)) {
                return false;
            }
            Object obj = map.get(gVar);
            Object obj2 = map2.get(gVar);
            if (gVar.g == s.g.b.BYTES) {
                if (gVar.c()) {
                    List list = (List) obj;
                    List list2 = (List) obj2;
                    if (list.size() != list2.size()) {
                        return false;
                    }
                    for (int i = 0; i < list.size(); i++) {
                        if (!compareBytes(list.get(i), list2.get(i))) {
                            return false;
                        }
                    }
                    continue;
                } else if (!compareBytes(obj, obj2)) {
                    return false;
                }
            } else if (gVar.q()) {
                if (!compareMapField(obj, obj2)) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean compareMapField(Object obj, Object obj2) {
        return z0.e(convertMapEntryListToMap((List) obj), convertMapEntryListToMap((List) obj2));
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005e A[SYNTHETIC] */
    public static java.util.Map convertMapEntryListToMap(java.util.List r6) {
        /*
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L_0x000b
            java.util.Map r6 = java.util.Collections.emptyMap()
            return r6
        L_0x000b:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.Iterator r6 = r6.iterator()
            java.lang.Object r1 = r6.next()
            c.b.d.e1 r1 = (c.b.d.e1) r1
            c.b.d.s$b r2 = r1.getDescriptorForType()
            java.lang.String r3 = "key"
            c.b.d.s$g r3 = r2.k(r3)
            java.lang.String r4 = "value"
            c.b.d.s$g r2 = r2.k(r4)
            java.lang.Object r4 = r1.getField(r2)
            boolean r5 = r4 instanceof c.b.d.s.f
            if (r5 == 0) goto L_0x003c
            c.b.d.s$f r4 = (c.b.d.s.f) r4
            c.b.d.r$e r4 = r4.f4288b
            int r4 = r4.f4112d
        L_0x0038:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L_0x003c:
            java.lang.Object r1 = r1.getField(r3)
            r0.put(r1, r4)
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x005e
            java.lang.Object r1 = r6.next()
            c.b.d.e1 r1 = (c.b.d.e1) r1
            java.lang.Object r4 = r1.getField(r2)
            boolean r5 = r4 instanceof c.b.d.s.f
            if (r5 == 0) goto L_0x003c
            c.b.d.s$f r4 = (c.b.d.s.f) r4
            c.b.d.r$e r4 = r4.f4288b
            int r4 = r4.f4112d
            goto L_0x0038
        L_0x005e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.d.a.convertMapEntryListToMap(java.util.List):java.util.Map");
    }

    @Deprecated
    public static int hashBoolean(boolean z) {
        return z ? 1231 : 1237;
    }

    @Deprecated
    public static int hashEnum(m0.c cVar) {
        return cVar.a();
    }

    @Deprecated
    public static int hashEnumList(List<? extends m0.c> list) {
        int i = 1;
        for (m0.c cVar : list) {
            i = (i * 31) + hashEnum(cVar);
        }
        return i;
    }

    public static int hashFields(int i, Map<s.g, Object> map) {
        int i2;
        int i3;
        for (Map.Entry<s.g, Object> entry : map.entrySet()) {
            s.g key = entry.getKey();
            Object value = entry.getValue();
            int i4 = (i * 37) + key.f4293c.f4132d;
            if (key.q()) {
                i2 = i4 * 53;
                i3 = hashMapField(value);
            } else if (key.g != s.g.b.ENUM) {
                i2 = i4 * 53;
                i3 = value.hashCode();
            } else if (key.c()) {
                int i5 = i4 * 53;
                int i6 = 1;
                for (m0.c cVar : (List) value) {
                    i6 = (i6 * 31) + cVar.a();
                }
                i = i5 + i6;
            } else {
                i = (i4 * 53) + ((m0.c) value).a();
            }
            i = i2 + i3;
        }
        return i;
    }

    @Deprecated
    public static int hashLong(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int hashMapField(Object obj) {
        return z0.a(convertMapEntryListToMap((List) obj));
    }

    public static j toByteString(Object obj) {
        return obj instanceof byte[] ? j.e((byte[]) obj) : (j) obj;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e1)) {
            return false;
        }
        e1 e1Var = (e1) obj;
        if (getDescriptorForType() != e1Var.getDescriptorForType()) {
            return false;
        }
        return compareFields(getAllFields(), e1Var.getAllFields()) && getUnknownFields().equals(e1Var.getUnknownFields());
    }

    public List<String> findInitializationErrors() {
        return c.P0(this);
    }

    public String getInitializationErrorString() {
        return c.F0(findInitializationErrors());
    }

    @Override // c.b.d.b
    public int getMemoizedSerializedSize() {
        return this.memoizedSize;
    }

    public s.g getOneofFieldDescriptor(s.k kVar) {
        throw new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
    }

    @Override // c.b.d.h1
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i1 = c.i1(this, getAllFields());
        this.memoizedSize = i1;
        return i1;
    }

    public boolean hasOneof(s.k kVar) {
        throw new UnsupportedOperationException("hasOneof() is not implemented.");
    }

    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int hashFields = (hashFields(getDescriptorForType().hashCode() + 779, getAllFields()) * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = hashFields;
        return hashFields;
    }

    @Override // c.b.d.i1
    public boolean isInitialized() {
        for (s.g gVar : getDescriptorForType().n()) {
            if (gVar.t() && !hasField(gVar)) {
                return false;
            }
        }
        for (Map.Entry<s.g, Object> entry : getAllFields().entrySet()) {
            s.g key = entry.getKey();
            if (key.g.f4303b == s.g.a.MESSAGE) {
                boolean c2 = key.c();
                Object value = entry.getValue();
                if (c2) {
                    for (e1 e1Var : (List) value) {
                        if (!e1Var.isInitialized()) {
                            return false;
                        }
                    }
                    continue;
                } else if (!((e1) value).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    public e1.a newBuilderForType(b bVar) {
        throw new UnsupportedOperationException("Nested builder is not supported for this type.");
    }

    @Override // c.b.d.b
    public n2 newUninitializedMessageException() {
        return AbstractC0097a.newUninitializedMessageException((e1) this);
    }

    @Override // c.b.d.b
    public void setMemoizedSerializedSize(int i) {
        this.memoizedSize = i;
    }

    public final String toString() {
        return i2.i().c(this);
    }

    @Override // c.b.d.h1
    public void writeTo(m mVar) {
        c.A2(this, getAllFields(), mVar, false);
    }

    /* renamed from: c.b.d.a$a  reason: collision with other inner class name */
    public static abstract class AbstractC0097a<BuilderType extends AbstractC0097a<BuilderType>> extends b.a implements e1.a {
        public static n2 newUninitializedMessageException(e1 e1Var) {
            return new n2(c.P0(e1Var));
        }

        public BuilderType clear() {
            for (Map.Entry<s.g, Object> entry : getAllFields().entrySet()) {
                clearField(entry.getKey());
            }
            return this;
        }

        public BuilderType clearOneof(s.k kVar) {
            throw new UnsupportedOperationException("clearOneof() is not implemented.");
        }

        @Override // c.b.d.b.a, c.b.d.b.a, c.b.d.b.a, java.lang.Object
        public BuilderType clone() {
            throw new UnsupportedOperationException("clone() should be implemented in subclasses.");
        }

        public void dispose() {
            throw new IllegalStateException("Should be overridden by subclasses.");
        }

        public List<String> findInitializationErrors() {
            return c.P0(this);
        }

        public e1.a getFieldBuilder(s.g gVar) {
            throw new UnsupportedOperationException("getFieldBuilder() called on an unsupported message type.");
        }

        public String getInitializationErrorString() {
            return c.F0(findInitializationErrors());
        }

        public s.g getOneofFieldDescriptor(s.k kVar) {
            throw new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
        }

        public e1.a getRepeatedFieldBuilder(s.g gVar, int i) {
            throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on an unsupported message type.");
        }

        public boolean hasOneof(s.k kVar) {
            throw new UnsupportedOperationException("hasOneof() is not implemented.");
        }

        @Override // c.b.d.b.a
        public BuilderType internalMergeFrom(b bVar) {
            return mergeFrom((e1) bVar);
        }

        public void markClean() {
            throw new IllegalStateException("Should be overridden by subclasses.");
        }

        @Override // c.b.d.b.a
        public boolean mergeDelimitedFrom(InputStream inputStream) {
            return super.mergeDelimitedFrom(inputStream);
        }

        @Override // c.b.d.b.a
        public boolean mergeDelimitedFrom(InputStream inputStream, z zVar) {
            return super.mergeDelimitedFrom(inputStream, zVar);
        }

        @Override // c.b.d.e1.a
        public BuilderType mergeFrom(e1 e1Var) {
            return mergeFrom(e1Var, e1Var.getAllFields());
        }

        @Override // c.b.d.b.a, c.b.d.b.a
        public BuilderType mergeFrom(j jVar) {
            return (BuilderType) ((AbstractC0097a) super.mergeFrom(jVar));
        }

        @Override // c.b.d.b.a, c.b.d.b.a, c.b.d.e1.a
        public BuilderType mergeFrom(j jVar, z zVar) {
            return (BuilderType) ((AbstractC0097a) super.mergeFrom(jVar, zVar));
        }

        @Override // c.b.d.b.a, c.b.d.b.a
        public BuilderType mergeFrom(k kVar) {
            return mergeFrom(kVar, (z) x.f4383e);
        }

        @Override // c.b.d.b.a, c.b.d.b.a
        public BuilderType mergeFrom(InputStream inputStream) {
            return (BuilderType) ((AbstractC0097a) super.mergeFrom(inputStream));
        }

        @Override // c.b.d.b.a, c.b.d.b.a
        public BuilderType mergeFrom(InputStream inputStream, z zVar) {
            return (BuilderType) ((AbstractC0097a) super.mergeFrom(inputStream, zVar));
        }

        @Override // c.b.d.b.a, c.b.d.b.a
        public BuilderType mergeFrom(byte[] bArr) {
            return (BuilderType) ((AbstractC0097a) super.mergeFrom(bArr));
        }

        @Override // c.b.d.b.a, c.b.d.b.a
        public BuilderType mergeFrom(byte[] bArr, int i, int i2) {
            return (BuilderType) ((AbstractC0097a) super.mergeFrom(bArr, i, i2));
        }

        @Override // c.b.d.b.a, c.b.d.b.a
        public BuilderType mergeFrom(byte[] bArr, int i, int i2, z zVar) {
            return (BuilderType) ((AbstractC0097a) super.mergeFrom(bArr, i, i2, zVar));
        }

        @Override // c.b.d.b.a, c.b.d.b.a
        public BuilderType mergeFrom(byte[] bArr, z zVar) {
            return (BuilderType) ((AbstractC0097a) super.mergeFrom(bArr, zVar));
        }

        public BuilderType mergeUnknownFields(p2 p2Var) {
            p2.b c2 = p2.c(getUnknownFields());
            c2.g(p2Var);
            setUnknownFields(c2.build());
            return this;
        }

        public String toString() {
            return i2.i().c(this);
        }

        @Override // c.b.d.h1.a, c.b.d.b.a, c.b.d.b.a
        public BuilderType mergeFrom(k kVar, z zVar) {
            p2.b bVar;
            int G;
            if (kVar.f3938e) {
                bVar = null;
            } else {
                bVar = p2.c(getUnknownFields());
            }
            do {
                G = kVar.G();
                if (G == 0) {
                    break;
                }
            } while (c.D1(kVar, bVar, zVar, getDescriptorForType(), new k1(this), G));
            if (bVar != null) {
                setUnknownFields(bVar.build());
            }
            return this;
        }

        public BuilderType mergeFrom(e1 e1Var, Map<s.g, Object> map) {
            Object obj;
            if (e1Var.getDescriptorForType() == getDescriptorForType()) {
                for (Map.Entry<s.g, Object> entry : map.entrySet()) {
                    s.g key = entry.getKey();
                    if (key.c()) {
                        for (Object obj2 : (List) entry.getValue()) {
                            addRepeatedField(key, obj2);
                        }
                    } else {
                        if (key.g.f4303b == s.g.a.MESSAGE) {
                            e1 e1Var2 = (e1) getField(key);
                            if (e1Var2 != e1Var2.getDefaultInstanceForType()) {
                                obj = e1Var2.newBuilderForType().mergeFrom(e1Var2).mergeFrom((e1) entry.getValue()).build();
                                setField(key, obj);
                            }
                        }
                        obj = entry.getValue();
                        setField(key, obj);
                    }
                }
                mergeUnknownFields(e1Var.getUnknownFields());
                return this;
            }
            throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
        }
    }
}
