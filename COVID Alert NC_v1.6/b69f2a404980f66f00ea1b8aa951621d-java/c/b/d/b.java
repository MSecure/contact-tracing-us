package c.b.d;

import c.b.d.b;
import c.b.d.b.a;
import c.b.d.h1;
import c.b.d.j;
import c.b.d.m;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class b<MessageType extends b<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> implements h1 {
    public int memoizedHashCode = 0;

    public static abstract class a<MessageType extends b<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> implements h1.a {

        /* renamed from: c.b.d.b$a$a  reason: collision with other inner class name */
        public static final class C0098a extends FilterInputStream {

            /* renamed from: b  reason: collision with root package name */
            public int f3829b;

            public C0098a(InputStream inputStream, int i) {
                super(inputStream);
                this.f3829b = i;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() {
                return Math.min(super.available(), this.f3829b);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() {
                if (this.f3829b <= 0) {
                    return -1;
                }
                int read = super.read();
                if (read >= 0) {
                    this.f3829b--;
                }
                return read;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                int i3 = this.f3829b;
                if (i3 <= 0) {
                    return -1;
                }
                int read = super.read(bArr, i, Math.min(i2, i3));
                if (read >= 0) {
                    this.f3829b -= read;
                }
                return read;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j) {
                long skip = super.skip(Math.min(j, (long) this.f3829b));
                if (skip >= 0) {
                    this.f3829b = (int) (((long) this.f3829b) - skip);
                }
                return skip;
            }
        }

        @Deprecated
        public static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
            addAll((Iterable) iterable, (List) collection);
        }

        public static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
            m0.a(iterable);
            if (iterable instanceof s0) {
                List<?> i = ((s0) iterable).i();
                s0 s0Var = (s0) list;
                int size = list.size();
                for (Object obj : i) {
                    if (obj == null) {
                        StringBuilder g = c.a.a.a.a.g("Element at index ");
                        g.append(s0Var.size() - size);
                        g.append(" is null.");
                        String sb = g.toString();
                        int size2 = s0Var.size();
                        while (true) {
                            size2--;
                            if (size2 >= size) {
                                s0Var.remove(size2);
                            } else {
                                throw new NullPointerException(sb);
                            }
                        }
                    } else if (obj instanceof j) {
                        s0Var.l((j) obj);
                    } else {
                        s0Var.add((String) obj);
                    }
                }
            } else if (iterable instanceof w1) {
                list.addAll((Collection) iterable);
            } else {
                addAllCheckingNulls(iterable, list);
            }
        }

        public static <T> void addAllCheckingNulls(Iterable<T> iterable, List<? super T> list) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(((Collection) iterable).size() + list.size());
            }
            int size = list.size();
            for (T t : iterable) {
                if (t == null) {
                    StringBuilder g = c.a.a.a.a.g("Element at index ");
                    g.append(list.size() - size);
                    g.append(" is null.");
                    String sb = g.toString();
                    int size2 = list.size();
                    while (true) {
                        size2--;
                        if (size2 >= size) {
                            list.remove(size2);
                        } else {
                            throw new NullPointerException(sb);
                        }
                    }
                } else {
                    list.add(t);
                }
            }
        }

        private String getReadingExceptionMessage(String str) {
            StringBuilder g = c.a.a.a.a.g("Reading ");
            g.append(getClass().getName());
            g.append(" from a ");
            g.append(str);
            g.append(" threw an IOException (should never happen).");
            return g.toString();
        }

        public static n2 newUninitializedMessageException(h1 h1Var) {
            return new n2();
        }

        @Override // java.lang.Object
        public abstract BuilderType clone();

        @Override // java.lang.Object
        public abstract /* bridge */ /* synthetic */ h1.a clone();

        @Override // java.lang.Object
        public abstract /* bridge */ /* synthetic */ Object clone();

        public abstract BuilderType internalMergeFrom(MessageType messagetype);

        public boolean mergeDelimitedFrom(InputStream inputStream) {
            return mergeDelimitedFrom(inputStream, z.a());
        }

        public boolean mergeDelimitedFrom(InputStream inputStream, z zVar) {
            int read = inputStream.read();
            if (read == -1) {
                return false;
            }
            mergeFrom((InputStream) new C0098a(inputStream, k.z(read, inputStream)), zVar);
            return true;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: c.b.d.b$a<MessageType extends c.b.d.b<MessageType, BuilderType>, BuilderType extends c.b.d.b$a<MessageType, BuilderType>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c.b.d.h1.a
        public BuilderType mergeFrom(h1 h1Var) {
            if (getDefaultInstanceForType().getClass().isInstance(h1Var)) {
                return (BuilderType) internalMergeFrom((b) h1Var);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }

        public BuilderType mergeFrom(j jVar) {
            try {
                k q = jVar.q();
                mergeFrom(q);
                q.a(0);
                return this;
            } catch (n0 e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RuntimeException(getReadingExceptionMessage("ByteString"), e3);
            }
        }

        public BuilderType mergeFrom(j jVar, z zVar) {
            try {
                k q = jVar.q();
                mergeFrom(q, zVar);
                q.a(0);
                return this;
            } catch (n0 e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RuntimeException(getReadingExceptionMessage("ByteString"), e3);
            }
        }

        public BuilderType mergeFrom(k kVar) {
            return mergeFrom(kVar, z.a());
        }

        @Override // c.b.d.h1.a
        public abstract BuilderType mergeFrom(k kVar, z zVar);

        public BuilderType mergeFrom(InputStream inputStream) {
            k g = k.g(inputStream);
            mergeFrom(g);
            g.a(0);
            return this;
        }

        public BuilderType mergeFrom(InputStream inputStream, z zVar) {
            k g = k.g(inputStream);
            mergeFrom(g, zVar);
            g.a(0);
            return this;
        }

        public BuilderType mergeFrom(byte[] bArr) {
            return mergeFrom(bArr, 0, bArr.length);
        }

        public BuilderType mergeFrom(byte[] bArr, int i, int i2) {
            try {
                k i3 = k.i(bArr, i, i2);
                mergeFrom(i3);
                i3.a(0);
                return this;
            } catch (n0 e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RuntimeException(getReadingExceptionMessage("byte array"), e3);
            }
        }

        public BuilderType mergeFrom(byte[] bArr, int i, int i2, z zVar) {
            try {
                k i3 = k.i(bArr, i, i2);
                mergeFrom(i3, zVar);
                i3.a(0);
                return this;
            } catch (n0 e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RuntimeException(getReadingExceptionMessage("byte array"), e3);
            }
        }

        public BuilderType mergeFrom(byte[] bArr, z zVar) {
            return mergeFrom(bArr, 0, bArr.length, zVar);
        }

        @Override // c.b.d.h1.a
        public abstract /* bridge */ /* synthetic */ h1.a mergeFrom(k kVar, z zVar);

        public abstract /* bridge */ /* synthetic */ h1.a mergeFrom(byte[] bArr, int i, int i2);

        public abstract /* bridge */ /* synthetic */ h1.a mergeFrom(byte[] bArr, int i, int i2, z zVar);
    }

    @Deprecated
    public static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
        a.addAll((Iterable) iterable, (List) collection);
    }

    public static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
        a.addAll((Iterable) iterable, (List) list);
    }

    public static void checkByteStringIsUtf8(j jVar) {
        if (!jVar.o()) {
            throw new IllegalArgumentException("Byte string is not UTF-8.");
        }
    }

    private String getSerializingExceptionMessage(String str) {
        StringBuilder g = c.a.a.a.a.g("Serializing ");
        g.append(getClass().getName());
        g.append(" to a ");
        g.append(str);
        g.append(" threw an IOException (should never happen).");
        return g.toString();
    }

    public int getMemoizedSerializedSize() {
        throw new UnsupportedOperationException();
    }

    public int getSerializedSize(c2 c2Var) {
        int memoizedSerializedSize = getMemoizedSerializedSize();
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int d2 = c2Var.d(this);
        setMemoizedSerializedSize(d2);
        return d2;
    }

    public n2 newUninitializedMessageException() {
        return new n2();
    }

    public void setMemoizedSerializedSize(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // c.b.d.h1
    public byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            m V = m.V(bArr);
            writeTo(V);
            V.b();
            return bArr;
        } catch (IOException e2) {
            throw new RuntimeException(getSerializingExceptionMessage("byte array"), e2);
        }
    }

    @Override // c.b.d.h1
    public j toByteString() {
        try {
            j.e p = j.p(getSerializedSize());
            writeTo(p.f3917a);
            return p.a();
        } catch (IOException e2) {
            throw new RuntimeException(getSerializingExceptionMessage("ByteString"), e2);
        }
    }

    public void writeDelimitedTo(OutputStream outputStream) {
        int serializedSize = getSerializedSize();
        int P = m.P(serializedSize) + serializedSize;
        if (P > 4096) {
            P = 4096;
        }
        m.e eVar = new m.e(outputStream, P);
        eVar.t0(serializedSize);
        writeTo(eVar);
        if (eVar.f > 0) {
            eVar.A0();
        }
    }

    public void writeTo(OutputStream outputStream) {
        m.e eVar = new m.e(outputStream, m.B(getSerializedSize()));
        writeTo(eVar);
        if (eVar.f > 0) {
            eVar.A0();
        }
    }
}
