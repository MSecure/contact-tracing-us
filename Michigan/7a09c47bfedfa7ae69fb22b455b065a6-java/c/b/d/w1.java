package c.b.d;

import java.io.InputStream;
import java.nio.ByteBuffer;

public interface w1<MessageType> {
    MessageType parseDelimitedFrom(InputStream inputStream);

    MessageType parseDelimitedFrom(InputStream inputStream, z zVar);

    MessageType parseFrom(j jVar);

    MessageType parseFrom(j jVar, z zVar);

    MessageType parseFrom(k kVar);

    MessageType parseFrom(k kVar, z zVar);

    MessageType parseFrom(InputStream inputStream);

    MessageType parseFrom(InputStream inputStream, z zVar);

    MessageType parseFrom(ByteBuffer byteBuffer);

    MessageType parseFrom(ByteBuffer byteBuffer, z zVar);

    MessageType parseFrom(byte[] bArr);

    MessageType parseFrom(byte[] bArr, z zVar);

    MessageType parsePartialFrom(k kVar, z zVar);
}
