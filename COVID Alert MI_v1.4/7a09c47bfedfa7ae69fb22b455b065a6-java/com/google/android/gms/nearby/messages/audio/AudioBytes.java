package com.google.android.gms.nearby.messages.audio;

import b.x.t;
import com.google.android.gms.nearby.messages.Message;
import java.util.Arrays;

public final class AudioBytes {
    public static final int MAX_SIZE = 10;
    public final byte[] zza;

    public AudioBytes(byte[] bArr) {
        t.C(bArr);
        boolean z = true;
        t.r(bArr.length <= 10, "Given byte array longer than 10 bytes, given by AudioBytes.MAX_SIZE.");
        t.r(bArr.length <= 0 ? false : z, "Given byte array is of zero length.");
        this.zza = bArr;
    }

    public static AudioBytes from(Message message) {
        t.C(message);
        boolean zza2 = message.zza(Message.MESSAGE_TYPE_AUDIO_BYTES);
        String type = message.getType();
        StringBuilder sb = new StringBuilder(String.valueOf(type).length() + 56);
        sb.append("Message type '");
        sb.append(type);
        sb.append("' is not Message.MESSAGE_TYPE_AUDIO_BYTES.");
        t.r(zza2, sb.toString());
        return new AudioBytes(message.getContent());
    }

    public final byte[] getBytes() {
        return this.zza;
    }

    public final Message toMessage() {
        return new Message(this.zza, Message.MESSAGE_NAMESPACE_RESERVED, Message.MESSAGE_TYPE_AUDIO_BYTES);
    }

    public final String toString() {
        String arrays = Arrays.toString(this.zza);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 14);
        sb.append("AudioBytes [");
        sb.append(arrays);
        sb.append(" ]");
        return sb.toString();
    }
}
