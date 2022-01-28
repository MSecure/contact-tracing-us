package com.google.android.gms.nearby.connection;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.IOUtils;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public class Payload {
    private final long zza;
    private final int zzb;
    private final byte[] zzc;
    private final File zzd;
    private final Stream zze;

    /* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
    public @interface Type {
        public static final int BYTES = 1;
        public static final int FILE = 2;
        public static final int STREAM = 3;
    }

    public static Payload fromBytes(byte[] bArr) {
        Preconditions.checkNotNull(bArr, "Cannot create a Payload from null bytes.");
        return zza(bArr, UUID.randomUUID().getLeastSignificantBits());
    }

    /* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
    public static class Stream {
        private final ParcelFileDescriptor zza;
        private InputStream zzb;

        public static Stream zza(InputStream inputStream) {
            Preconditions.checkNotNull(inputStream, "Cannot create Payload.Stream from null InputStream.");
            return new Stream(null, inputStream);
        }

        public static Stream zza(ParcelFileDescriptor parcelFileDescriptor) {
            Preconditions.checkNotNull(parcelFileDescriptor, "Cannot create Payload.Stream from null ParcelFileDescriptor.");
            return new Stream(parcelFileDescriptor, null);
        }

        private Stream(ParcelFileDescriptor parcelFileDescriptor, InputStream inputStream) {
            this.zza = parcelFileDescriptor;
            this.zzb = inputStream;
        }

        public InputStream asInputStream() {
            if (this.zzb == null) {
                this.zzb = new ParcelFileDescriptor.AutoCloseInputStream(this.zza);
            }
            return this.zzb;
        }

        public ParcelFileDescriptor asParcelFileDescriptor() {
            return this.zza;
        }

        public void close() {
            IOUtils.closeQuietly(this.zza);
            IOUtils.closeQuietly(this.zzb);
        }
    }

    /* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
    public static class File {
        private final java.io.File zza;
        private final ParcelFileDescriptor zzb;
        private final long zzc;
        private final Uri zzd;

        public static File zza(java.io.File file, ParcelFileDescriptor parcelFileDescriptor, long j, Uri uri) {
            return new File((java.io.File) Preconditions.checkNotNull(file, "Cannot create Payload.File from null java.io.File."), (ParcelFileDescriptor) Preconditions.checkNotNull(parcelFileDescriptor, "Cannot create Payload.File from null ParcelFileDescriptor."), j, (Uri) Preconditions.checkNotNull(uri, "Cannot create Payload.File from null Uri"));
        }

        public static File zza(ParcelFileDescriptor parcelFileDescriptor) {
            return new File(null, (ParcelFileDescriptor) Preconditions.checkNotNull(parcelFileDescriptor, "Cannot create Payload.File from null ParcelFileDescriptor."), parcelFileDescriptor.getStatSize(), null);
        }

        private File(java.io.File file, ParcelFileDescriptor parcelFileDescriptor, long j, Uri uri) {
            this.zza = file;
            this.zzb = parcelFileDescriptor;
            this.zzc = j;
            this.zzd = uri;
        }

        @Deprecated
        public java.io.File asJavaFile() {
            return this.zza;
        }

        public Uri asUri() {
            return this.zzd;
        }

        public ParcelFileDescriptor asParcelFileDescriptor() {
            return this.zzb;
        }

        public long getSize() {
            return this.zzc;
        }

        public void close() {
            IOUtils.closeQuietly(this.zzb);
        }
    }

    public static Payload zza(byte[] bArr, long j) {
        return new Payload(j, 1, bArr, null, null);
    }

    public static Payload fromFile(java.io.File file) throws FileNotFoundException {
        return zza(File.zza(file, ParcelFileDescriptor.open(file, 268435456), file.length(), Uri.fromFile(file)), UUID.randomUUID().getLeastSignificantBits());
    }

    public static Payload fromFile(ParcelFileDescriptor parcelFileDescriptor) {
        return zza(File.zza(parcelFileDescriptor), UUID.randomUUID().getLeastSignificantBits());
    }

    public static Payload zza(File file, long j) {
        return new Payload(j, 2, null, file, null);
    }

    public static Payload fromStream(InputStream inputStream) {
        return zza(Stream.zza(inputStream), UUID.randomUUID().getLeastSignificantBits());
    }

    public static Payload fromStream(ParcelFileDescriptor parcelFileDescriptor) {
        return zza(Stream.zza(parcelFileDescriptor), UUID.randomUUID().getLeastSignificantBits());
    }

    public static Payload zza(Stream stream, long j) {
        return new Payload(j, 3, null, null, stream);
    }

    private Payload(long j, int i, byte[] bArr, File file, Stream stream) {
        this.zza = j;
        this.zzb = i;
        this.zzc = bArr;
        this.zzd = file;
        this.zze = stream;
    }

    public long getId() {
        return this.zza;
    }

    public int getType() {
        return this.zzb;
    }

    public byte[] asBytes() {
        return this.zzc;
    }

    public File asFile() {
        return this.zzd;
    }

    public Stream asStream() {
        return this.zze;
    }

    public void close() {
        File file = this.zzd;
        if (file != null) {
            file.close();
        }
        Stream stream = this.zze;
        if (stream != null) {
            stream.close();
        }
    }
}
