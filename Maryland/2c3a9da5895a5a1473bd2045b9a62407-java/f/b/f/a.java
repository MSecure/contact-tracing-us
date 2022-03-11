package f.b.f;

import f.b.f.a;
import f.b.f.a.AbstractC0124a;
import f.b.f.j;
import f.b.f.m;
import f.b.f.t0;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public abstract class a<MessageType extends a<MessageType, BuilderType>, BuilderType extends AbstractC0124a<MessageType, BuilderType>> implements t0 {
    public int memoizedHashCode = 0;

    /* renamed from: f.b.f.a$a  reason: collision with other inner class name */
    public static abstract class AbstractC0124a<MessageType extends a<MessageType, BuilderType>, BuilderType extends AbstractC0124a<MessageType, BuilderType>> implements t0.a {

        /* renamed from: f.b.f.a$a$a  reason: collision with other inner class name */
        public static final class C0125a extends FilterInputStream {
            public int b;

            public C0125a(InputStream inputStream, int i2) {
                super(inputStream);
                this.b = i2;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() {
                return Math.min(super.available(), this.b);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() {
                if (this.b <= 0) {
                    return -1;
                }
                int read = super.read();
                if (read >= 0) {
                    this.b--;
                }
                return read;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i2, int i3) {
                int i4 = this.b;
                if (i4 <= 0) {
                    return -1;
                }
                int read = super.read(bArr, i2, Math.min(i3, i4));
                if (read >= 0) {
                    this.b -= read;
                }
                return read;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j2) {
                long skip = super.skip(Math.min(j2, (long) this.b));
                if (skip >= 0) {
                    this.b = (int) (((long) this.b) - skip);
                }
                return skip;
            }
        }

        @Deprecated
        public static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
            addAll((Iterable) iterable, (List) collection);
        }

        public static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
            Charset charset = c0.a;
            Objects.requireNonNull(iterable);
            if (iterable instanceof i0) {
                List<?> f2 = ((i0) iterable).f();
                i0 i0Var = (i0) list;
                int size = list.size();
                for (Object obj : f2) {
                    if (obj == null) {
                        StringBuilder h2 = f.a.a.a.a.h("Element at index ");
                        h2.append(i0Var.size() - size);
                        h2.append(" is null.");
                        String sb = h2.toString();
                        int size2 = i0Var.size();
                        while (true) {
                            size2--;
                            if (size2 >= size) {
                                i0Var.remove(size2);
                            } else {
                                throw new NullPointerException(sb);
                            }
                        }
                    } else if (obj instanceof j) {
                        i0Var.e((j) obj);
                    } else {
                        i0Var.add((String) obj);
                    }
                }
            } else if (iterable instanceof c1) {
                list.addAll((Collection) iterable);
            } else {
                addAllCheckingNulls(iterable, list);
            }
        }

        private static <T> void addAllCheckingNulls(Iterable<T> iterable, List<? super T> list) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(((Collection) iterable).size() + list.size());
            }
            int size = list.size();
            for (T t : iterable) {
                if (t == null) {
                    StringBuilder h2 = f.a.a.a.a.h("Element at index ");
                    h2.append(list.size() - size);
                    h2.append(" is null.");
                    String sb = h2.toString();
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
            StringBuilder h2 = f.a.a.a.a.h("Reading ");
            h2.append(getClass().getName());
            h2.append(" from a ");
            h2.append(str);
            h2.append(" threw an IOException (should never happen).");
            return h2.toString();
        }

        public static q1 newUninitializedMessageException(t0 t0Var) {
            return new q1();
        }

        @Override // java.lang.Object
        public abstract BuilderType clone();

        @Override // java.lang.Object
        public abstract /* bridge */ /* synthetic */ t0.a clone();

        @Override // java.lang.Object
        public abstract /* bridge */ /* synthetic */ Object clone();

        public abstract BuilderType internalMergeFrom(MessageType messagetype);

        public boolean mergeDelimitedFrom(InputStream inputStream) {
            return mergeDelimitedFrom(inputStream, r.a());
        }

        public boolean mergeDelimitedFrom(InputStream inputStream, r rVar) {
            int read = inputStream.read();
            if (read == -1) {
                return false;
            }
            mergeFrom((InputStream) new C0125a(inputStream, k.t(read, inputStream)), rVar);
            return true;
        }

        public BuilderType mergeFrom(j jVar) {
            try {
                k v = jVar.v();
                mergeFrom(v);
                v.a(0);
                return this;
            } catch (d0 e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RuntimeException(getReadingExceptionMessage("ByteString"), e3);
            }
        }

        public BuilderType mergeFrom(j jVar, r rVar) {
            try {
                k v = jVar.v();
                mergeFrom(v, rVar);
                v.a(0);
                return this;
            } catch (d0 e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RuntimeException(getReadingExceptionMessage("ByteString"), e3);
            }
        }

        public BuilderType mergeFrom(k kVar) {
            return mergeFrom(kVar, r.a());
        }

        public abstract BuilderType mergeFrom(k kVar, r rVar);

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: f.b.f.a$a<MessageType extends f.b.f.a<MessageType, BuilderType>, BuilderType extends f.b.f.a$a<MessageType, BuilderType>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // f.b.f.t0.a
        public BuilderType mergeFrom(t0 t0Var) {
            if (getDefaultInstanceForType().getClass().isInstance(t0Var)) {
                return (BuilderType) internalMergeFrom((a) t0Var);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }

        public BuilderType mergeFrom(InputStream inputStream) {
            k f2 = k.f(inputStream);
            mergeFrom(f2);
            f2.a(0);
            return this;
        }

        public BuilderType mergeFrom(InputStream inputStream, r rVar) {
            k f2 = k.f(inputStream);
            mergeFrom(f2, rVar);
            f2.a(0);
            return this;
        }

        public BuilderType mergeFrom(byte[] bArr) {
            return mergeFrom(bArr, 0, bArr.length);
        }

        public abstract BuilderType mergeFrom(byte[] bArr, int i2, int i3);

        public abstract BuilderType mergeFrom(byte[] bArr, int i2, int i3, r rVar);

        public BuilderType mergeFrom(byte[] bArr, r rVar) {
            return mergeFrom(bArr, 0, bArr.length, rVar);
        }

        public abstract /* bridge */ /* synthetic */ t0.a mergeFrom(k kVar, r rVar);

        public abstract /* bridge */ /* synthetic */ t0.a mergeFrom(byte[] bArr, int i2, int i3);

        public abstract /* bridge */ /* synthetic */ t0.a mergeFrom(byte[] bArr, int i2, int i3, r rVar);
    }

    @Deprecated
    public static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
        AbstractC0124a.addAll((Iterable) iterable, (List) collection);
    }

    public static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
        AbstractC0124a.addAll((Iterable) iterable, (List) list);
    }

    public static void checkByteStringIsUtf8(j jVar) {
        if (!jVar.t()) {
            throw new IllegalArgumentException("Byte string is not UTF-8.");
        }
    }

    private String getSerializingExceptionMessage(String str) {
        StringBuilder h2 = f.a.a.a.a.h("Serializing ");
        h2.append(getClass().getName());
        h2.append(" to a ");
        h2.append(str);
        h2.append(" threw an IOException (should never happen).");
        return h2.toString();
    }

    public int getMemoizedSerializedSize() {
        throw new UnsupportedOperationException();
    }

    public int getSerializedSize(j1 j1Var) {
        int memoizedSerializedSize = getMemoizedSerializedSize();
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int f2 = j1Var.f(this);
        setMemoizedSerializedSize(f2);
        return f2;
    }

    public q1 newUninitializedMessageException() {
        return new q1();
    }

    public void setMemoizedSerializedSize(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // f.b.f.t0
    public byte[] toByteArray() {
        try {
            int serializedSize = getSerializedSize();
            byte[] bArr = new byte[serializedSize];
            Logger logger = m.b;
            m.c cVar = new m.c(bArr, 0, serializedSize);
            writeTo(cVar);
            cVar.b();
            return bArr;
        } catch (IOException e2) {
            throw new RuntimeException(getSerializingExceptionMessage("byte array"), e2);
        }
    }

    @Override // f.b.f.t0
    public j toByteString() {
        try {
            int serializedSize = getSerializedSize();
            j jVar = j.c;
            byte[] bArr = new byte[serializedSize];
            Logger logger = m.b;
            m.c cVar = new m.c(bArr, 0, serializedSize);
            writeTo(cVar);
            cVar.b();
            return new j.h(bArr);
        } catch (IOException e2) {
            throw new RuntimeException(getSerializingExceptionMessage("ByteString"), e2);
        }
    }

    public void writeDelimitedTo(OutputStream outputStream) {
        int serializedSize = getSerializedSize();
        int A = m.A(serializedSize) + serializedSize;
        if (A > 4096) {
            A = 4096;
        }
        m.e eVar = new m.e(outputStream, A);
        eVar.a0(serializedSize);
        writeTo(eVar);
        eVar.i0();
    }

    @Override // f.b.f.t0
    public void writeTo(OutputStream outputStream) {
        int serializedSize = getSerializedSize();
        Logger logger = m.b;
        if (serializedSize > 4096) {
            serializedSize = 4096;
        }
        m.e eVar = new m.e(outputStream, serializedSize);
        writeTo(eVar);
        eVar.i0();
    }
}
