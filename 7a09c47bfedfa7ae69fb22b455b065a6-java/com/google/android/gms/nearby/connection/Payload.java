package com.google.android.gms.nearby.connection;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import b.x.t;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class Payload {
    public final long zza;
    @Type
    public final int zzb;
    public final byte[] zzc;
    public final File zzd;
    public final Stream zze;
    public long zzf;

    public static class File {
        public final java.io.File zza;
        public final ParcelFileDescriptor zzb;
        public final long zzc;
        public final Uri zzd;

        public File(java.io.File file, ParcelFileDescriptor parcelFileDescriptor, long j, Uri uri) {
            this.zza = file;
            this.zzb = parcelFileDescriptor;
            this.zzc = j;
            this.zzd = uri;
        }

        public static File zza(ParcelFileDescriptor parcelFileDescriptor) {
            t.D(parcelFileDescriptor, "Cannot create Payload.File from null ParcelFileDescriptor.");
            return new File(null, parcelFileDescriptor, parcelFileDescriptor.getStatSize(), null);
        }

        public static File zza(java.io.File file, ParcelFileDescriptor parcelFileDescriptor, long j, Uri uri) {
            t.D(file, "Cannot create Payload.File from null java.io.File.");
            t.D(parcelFileDescriptor, "Cannot create Payload.File from null ParcelFileDescriptor.");
            t.D(uri, "Cannot create Payload.File from null Uri");
            return new File(file, parcelFileDescriptor, j, uri);
        }

        @Deprecated
        public java.io.File asJavaFile() {
            return this.zza;
        }

        public ParcelFileDescriptor asParcelFileDescriptor() {
            return this.zzb;
        }

        public Uri asUri() {
            return this.zzd;
        }

        public void close() {
            ParcelFileDescriptor parcelFileDescriptor = this.zzb;
            if (parcelFileDescriptor != null) {
                try {
                    parcelFileDescriptor.close();
                } catch (IOException unused) {
                }
            }
        }

        public long getSize() {
            return this.zzc;
        }
    }

    public static class Stream {
        public final ParcelFileDescriptor zza;
        public InputStream zzb;

        public Stream(ParcelFileDescriptor parcelFileDescriptor, InputStream inputStream) {
            this.zza = parcelFileDescriptor;
            this.zzb = inputStream;
        }

        public static Stream zza(ParcelFileDescriptor parcelFileDescriptor) {
            t.D(parcelFileDescriptor, "Cannot create Payload.Stream from null ParcelFileDescriptor.");
            return new Stream(parcelFileDescriptor, null);
        }

        public static Stream zza(InputStream inputStream) {
            t.D(inputStream, "Cannot create Payload.Stream from null InputStream.");
            return new Stream(null, inputStream);
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
            ParcelFileDescriptor parcelFileDescriptor = this.zza;
            if (parcelFileDescriptor != null) {
                try {
                    parcelFileDescriptor.close();
                } catch (IOException unused) {
                }
            }
            InputStream inputStream = this.zzb;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
        }
    }

    public @interface Type {
        public static final int BYTES = 1;
        public static final int FILE = 2;
        public static final int STREAM = 3;
    }

    public Payload(long j, int i, byte[] bArr, File file, Stream stream) {
        this.zza = j;
        this.zzb = i;
        this.zzc = bArr;
        this.zzd = file;
        this.zze = stream;
    }

    public static Payload fromBytes(byte[] bArr) {
        t.D(bArr, "Cannot create a Payload from null bytes.");
        return zza(bArr, UUID.randomUUID().getLeastSignificantBits());
    }

    public static Payload fromFile(ParcelFileDescriptor parcelFileDescriptor) {
        return zza(File.zza(parcelFileDescriptor), UUID.randomUUID().getLeastSignificantBits());
    }

    public static Payload fromFile(java.io.File file) {
        return zza(File.zza(file, ParcelFileDescriptor.open(file, 268435456), file.length(), Uri.fromFile(file)), UUID.randomUUID().getLeastSignificantBits());
    }

    public static Payload fromStream(ParcelFileDescriptor parcelFileDescriptor) {
        return zza(Stream.zza(parcelFileDescriptor), UUID.randomUUID().getLeastSignificantBits());
    }

    public static Payload fromStream(InputStream inputStream) {
        return zza(Stream.zza(inputStream), UUID.randomUUID().getLeastSignificantBits());
    }

    public static Payload zza(File file, long j) {
        return new Payload(j, 2, null, file, null);
    }

    public static Payload zza(Stream stream, long j) {
        return new Payload(j, 3, null, null, stream);
    }

    public static Payload zza(byte[] bArr, long j) {
        return new Payload(j, 1, bArr, null, null);
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

    public long getId() {
        return this.zza;
    }

    public long getOffset() {
        return this.zzf;
    }

    @Type
    public int getType() {
        return this.zzb;
    }

    public void setOffset(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Payload offset must be positive or zero.");
        } else if (getType() == 2 || getType() == 3) {
            File file = this.zzd;
            if (file == null || j < file.getSize()) {
                this.zzf = j;
                return;
            }
            throw new IllegalArgumentException("Payload offset should be smaller than the file size.");
        } else {
            throw new IllegalArgumentException("Payload offset only support FILE or STREAM type.");
        }
    }
}
