package c.b.d;

import c.b.d.b;
import c.b.d.h1;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public abstract class c<MessageType extends h1> implements v1<MessageType> {
    public static final z EMPTY_REGISTRY = z.a();

    private MessageType checkMessageInitialized(MessageType messagetype) {
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        n2 newUninitializedMessageException = newUninitializedMessageException(messagetype);
        if (newUninitializedMessageException != null) {
            n0 n0Var = new n0(newUninitializedMessageException.getMessage());
            n0Var.f4007b = messagetype;
            throw n0Var;
        }
        throw null;
    }

    private n2 newUninitializedMessageException(MessageType messagetype) {
        return messagetype instanceof b ? ((b) messagetype).newUninitializedMessageException() : new n2();
    }

    @Override // c.b.d.v1
    public MessageType parseDelimitedFrom(InputStream inputStream) {
        return parseDelimitedFrom(inputStream, EMPTY_REGISTRY);
    }

    @Override // c.b.d.v1
    public MessageType parseDelimitedFrom(InputStream inputStream, z zVar) {
        return checkMessageInitialized(parsePartialDelimitedFrom(inputStream, zVar));
    }

    @Override // c.b.d.v1
    public MessageType parseFrom(j jVar) {
        return parseFrom(jVar, EMPTY_REGISTRY);
    }

    @Override // c.b.d.v1
    public MessageType parseFrom(j jVar, z zVar) {
        return checkMessageInitialized(parsePartialFrom(jVar, zVar));
    }

    @Override // c.b.d.v1
    public MessageType parseFrom(k kVar) {
        return parseFrom(kVar, EMPTY_REGISTRY);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: c.b.d.c<MessageType extends c.b.d.h1> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.b.d.v1
    public MessageType parseFrom(k kVar, z zVar) {
        return (MessageType) checkMessageInitialized((h1) parsePartialFrom(kVar, zVar));
    }

    @Override // c.b.d.v1
    public MessageType parseFrom(InputStream inputStream) {
        return parseFrom(inputStream, EMPTY_REGISTRY);
    }

    @Override // c.b.d.v1
    public MessageType parseFrom(InputStream inputStream, z zVar) {
        return checkMessageInitialized(parsePartialFrom(inputStream, zVar));
    }

    @Override // c.b.d.v1
    public MessageType parseFrom(ByteBuffer byteBuffer) {
        return parseFrom(byteBuffer, EMPTY_REGISTRY);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: c.b.d.c<MessageType extends c.b.d.h1> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.b.d.v1
    public MessageType parseFrom(ByteBuffer byteBuffer, z zVar) {
        try {
            k h = k.h(byteBuffer, false);
            h1 h1Var = (h1) parsePartialFrom(h, zVar);
            try {
                h.a(0);
                return (MessageType) checkMessageInitialized(h1Var);
            } catch (n0 e2) {
                e2.f4007b = h1Var;
                throw e2;
            }
        } catch (n0 e3) {
            throw e3;
        }
    }

    @Override // c.b.d.v1
    public MessageType parseFrom(byte[] bArr) {
        return parseFrom(bArr, EMPTY_REGISTRY);
    }

    public MessageType parseFrom(byte[] bArr, int i, int i2) {
        return parseFrom(bArr, i, i2, EMPTY_REGISTRY);
    }

    public MessageType parseFrom(byte[] bArr, int i, int i2, z zVar) {
        return checkMessageInitialized(parsePartialFrom(bArr, i, i2, zVar));
    }

    @Override // c.b.d.v1
    public MessageType parseFrom(byte[] bArr, z zVar) {
        return parseFrom(bArr, 0, bArr.length, zVar);
    }

    public MessageType parsePartialDelimitedFrom(InputStream inputStream) {
        return parsePartialDelimitedFrom(inputStream, EMPTY_REGISTRY);
    }

    public MessageType parsePartialDelimitedFrom(InputStream inputStream, z zVar) {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            return parsePartialFrom((InputStream) new b.a.C0098a(inputStream, k.z(read, inputStream)), zVar);
        } catch (IOException e2) {
            throw new n0(e2);
        }
    }

    public MessageType parsePartialFrom(j jVar) {
        return parsePartialFrom(jVar, EMPTY_REGISTRY);
    }

    public MessageType parsePartialFrom(j jVar, z zVar) {
        try {
            k q = jVar.q();
            MessageType messagetype = (MessageType) ((h1) parsePartialFrom(q, zVar));
            try {
                q.a(0);
                return messagetype;
            } catch (n0 e2) {
                e2.f4007b = messagetype;
                throw e2;
            }
        } catch (n0 e3) {
            throw e3;
        }
    }

    public MessageType parsePartialFrom(k kVar) {
        return (MessageType) ((h1) parsePartialFrom(kVar, EMPTY_REGISTRY));
    }

    public MessageType parsePartialFrom(InputStream inputStream) {
        return parsePartialFrom(inputStream, EMPTY_REGISTRY);
    }

    public MessageType parsePartialFrom(byte[] bArr) {
        return parsePartialFrom(bArr, 0, bArr.length, EMPTY_REGISTRY);
    }

    public MessageType parsePartialFrom(byte[] bArr, int i, int i2) {
        return parsePartialFrom(bArr, i, i2, EMPTY_REGISTRY);
    }

    public MessageType parsePartialFrom(byte[] bArr, z zVar) {
        return parsePartialFrom(bArr, 0, bArr.length, zVar);
    }

    public MessageType parsePartialFrom(InputStream inputStream, z zVar) {
        k g = k.g(inputStream);
        MessageType messagetype = (MessageType) ((h1) parsePartialFrom(g, zVar));
        try {
            g.a(0);
            return messagetype;
        } catch (n0 e2) {
            e2.f4007b = messagetype;
            throw e2;
        }
    }

    public MessageType parsePartialFrom(byte[] bArr, int i, int i2, z zVar) {
        try {
            k i3 = k.i(bArr, i, i2);
            MessageType messagetype = (MessageType) ((h1) parsePartialFrom(i3, zVar));
            try {
                i3.a(0);
                return messagetype;
            } catch (n0 e2) {
                e2.f4007b = messagetype;
                throw e2;
            }
        } catch (n0 e3) {
            throw e3;
        }
    }
}
