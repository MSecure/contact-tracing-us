package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import android.os.StrictMode;
import android.util.Log;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import java.io.Closeable;
import java.io.DataInput;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class UnpackingSoSource extends DirectorySoSource {
    public final Context mContext;
    public String mCorruptedLib;
    public final Map<String, Object> mLibsBeingLoaded = new HashMap();

    public static class Dso {
        public final String hash;
        public final String name;

        public Dso(String str, String str2) {
            this.name = str;
            this.hash = str2;
        }
    }

    public static final class DsoManifest {
        public final Dso[] dsos;

        public DsoManifest(Dso[] dsoArr) {
            this.dsos = dsoArr;
        }

        public static final DsoManifest read(DataInput dataInput) throws IOException {
            if (dataInput.readByte() == 1) {
                int readInt = dataInput.readInt();
                if (readInt >= 0) {
                    Dso[] dsoArr = new Dso[readInt];
                    for (int i = 0; i < readInt; i++) {
                        dsoArr[i] = new Dso(dataInput.readUTF(), dataInput.readUTF());
                    }
                    return new DsoManifest(dsoArr);
                }
                throw new RuntimeException("illegal number of shared libraries");
            }
            throw new RuntimeException("wrong dso manifest version");
        }
    }

    public static final class InputDso implements Closeable {
        public final InputStream content;
        public final Dso dso;

        public InputDso(Dso dso2, InputStream inputStream) {
            this.dso = dso2;
            this.content = inputStream;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.content.close();
        }
    }

    public static abstract class InputDsoIterator implements Closeable {
        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        public abstract boolean hasNext();

        public abstract InputDso next() throws IOException;
    }

    public static abstract class Unpacker implements Closeable {
        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        public abstract DsoManifest getDsoManifest() throws IOException;

        public abstract InputDsoIterator openDsoIterator() throws IOException;
    }

    public UnpackingSoSource(Context context, String str) {
        super(new File(context.getApplicationInfo().dataDir + ColorPropConverter.PATH_DELIMITER + str), 1);
        this.mContext = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        r3.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
        r4 = move-exception;
     */
    public static void writeState(File file, byte b) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        randomAccessFile.seek(0);
        randomAccessFile.write(b);
        randomAccessFile.setLength(randomAccessFile.getFilePointer());
        randomAccessFile.getFD().sync();
        randomAccessFile.close();
    }

    public final void deleteUnmentionedFiles(Dso[] dsoArr) throws IOException {
        String[] list = this.soDirectory.list();
        if (list != null) {
            for (String str : list) {
                if (!str.equals("dso_state") && !str.equals("dso_lock") && !str.equals("dso_deps") && !str.equals("dso_manifest")) {
                    boolean z = false;
                    int i = 0;
                    while (!z && i < dsoArr.length) {
                        if (dsoArr[i].name.equals(str)) {
                            z = true;
                        }
                        i++;
                    }
                    if (!z) {
                        File file = new File(this.soDirectory, str);
                        String str2 = "deleting unaccounted-for file " + file;
                        ReactYogaConfigProvider.dumbDeleteRecursive(file);
                    }
                }
            }
            return;
        }
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("unable to list directory ");
        outline15.append(this.soDirectory);
        throw new IOException(outline15.toString());
    }

    public final void extractDso(InputDso inputDso, byte[] bArr) throws IOException {
        RandomAccessFile randomAccessFile;
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("extracting DSO ");
        outline15.append(inputDso.dso.name);
        Log.i("fb-UnpackingSoSource", outline15.toString());
        if (this.soDirectory.setWritable(true, true)) {
            File file = new File(this.soDirectory, inputDso.dso.name);
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
            } catch (IOException e) {
                Log.w("fb-UnpackingSoSource", "error overwriting " + file + " trying to delete and start over", e);
                ReactYogaConfigProvider.dumbDeleteRecursive(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
            }
            try {
                int available = inputDso.content.available();
                if (available > 1) {
                    SysUtil$LollipopSysdeps.fallocateIfSupported(randomAccessFile.getFD(), (long) available);
                }
                InputStream inputStream = inputDso.content;
                int i = 0;
                while (i < Integer.MAX_VALUE) {
                    int read = inputStream.read(bArr, 0, Math.min(bArr.length, Integer.MAX_VALUE - i));
                    if (read == -1) {
                        break;
                    }
                    randomAccessFile.write(bArr, 0, read);
                    i += read;
                }
                randomAccessFile.setLength(randomAccessFile.getFilePointer());
                if (file.setExecutable(true, false)) {
                    randomAccessFile.close();
                    return;
                }
                throw new IOException("cannot make file executable: " + file);
            } catch (IOException e2) {
                ReactYogaConfigProvider.dumbDeleteRecursive(file);
                throw e2;
            } catch (Throwable th) {
                randomAccessFile.close();
                throw th;
            }
        } else {
            StringBuilder outline152 = GeneratedOutlineSupport.outline15("cannot make directory writable for us: ");
            outline152.append(this.soDirectory);
            throw new IOException(outline152.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
        if (r1 != null) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0040, code lost:
        r0.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0043, code lost:
        throw r2;
     */
    public byte[] getDepsBlock() throws IOException {
        Parcel obtain = Parcel.obtain();
        Unpacker makeUnpacker = makeUnpacker();
        Dso[] dsoArr = makeUnpacker.getDsoManifest().dsos;
        obtain.writeByte((byte) 1);
        obtain.writeInt(dsoArr.length);
        for (int i = 0; i < dsoArr.length; i++) {
            obtain.writeString(dsoArr[i].name);
            obtain.writeString(dsoArr[i].hash);
        }
        makeUnpacker.close();
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    public final Object getLibraryLock(String str) {
        Object obj;
        synchronized (this.mLibsBeingLoaded) {
            obj = this.mLibsBeingLoaded.get(str);
            if (obj == null) {
                obj = new Object();
                this.mLibsBeingLoaded.put(str, obj);
            }
        }
        return obj;
    }

    @Override // com.facebook.soloader.DirectorySoSource, com.facebook.soloader.SoSource
    public int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        int loadLibraryFrom;
        synchronized (getLibraryLock(str)) {
            loadLibraryFrom = loadLibraryFrom(str, i, this.soDirectory, threadPolicy);
        }
        return loadLibraryFrom;
    }

    public abstract Unpacker makeUnpacker() throws IOException;

    @Override // com.facebook.soloader.SoSource
    public void prepare(int i) throws IOException {
        File file = this.soDirectory;
        if (file.mkdirs() || file.isDirectory()) {
            FileLocker fileLocker = new FileLocker(new File(this.soDirectory, "dso_lock"));
            try {
                String str = "locked dso store " + this.soDirectory;
                if (refreshLocked(fileLocker, i, getDepsBlock())) {
                    fileLocker = null;
                } else {
                    Log.i("fb-UnpackingSoSource", "dso store is up-to-date: " + this.soDirectory);
                }
                if (fileLocker == null) {
                    StringBuilder outline15 = GeneratedOutlineSupport.outline15("not releasing dso store lock for ");
                    outline15.append(this.soDirectory);
                    outline15.append(" (syncer thread started)");
                    outline15.toString();
                }
            } finally {
                StringBuilder outline152 = GeneratedOutlineSupport.outline15("releasing dso store lock for ");
                outline152.append(this.soDirectory);
                outline152.toString();
                fileLocker.close();
            }
        } else {
            throw new IOException("cannot mkdir: " + file);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0037, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        r11.addSuppressed(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003b, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00be, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00bf, code lost:
        if (r0 != null) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00c5, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00c6, code lost:
        r11.addSuppressed(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00c9, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00cc, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00d1, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00d2, code lost:
        r11.addSuppressed(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00d5, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0032, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0088 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0089  */
    public final boolean refreshLocked(final FileLocker fileLocker, int i, final byte[] bArr) throws IOException {
        final DsoManifest dsoManifest;
        final File file = new File(this.soDirectory, "dso_state");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        byte b = randomAccessFile.readByte();
        if (b != 1) {
            String str = "dso store " + this.soDirectory + " regeneration interrupted: wiping clean";
            b = 0;
        }
        randomAccessFile.close();
        final File file2 = new File(this.soDirectory, "dso_deps");
        RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
        int length = (int) randomAccessFile2.length();
        byte[] bArr2 = new byte[length];
        if (randomAccessFile2.read(bArr2) != length) {
            b = 0;
        }
        if (!Arrays.equals(bArr2, bArr)) {
            b = 0;
        }
        if (b != 0) {
            if ((i & 2) == 0) {
                dsoManifest = null;
                randomAccessFile2.close();
                if (dsoManifest != null) {
                    return false;
                }
                AnonymousClass1 r9 = new Runnable() {
                    /* class com.facebook.soloader.UnpackingSoSource.AnonymousClass1 */

                    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0083, code lost:
                        r3 = move-exception;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
                        r4.close();
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0088, code lost:
                        r4 = move-exception;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0089, code lost:
                        r2.addSuppressed(r4);
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008c, code lost:
                        throw r3;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008f, code lost:
                        r4 = move-exception;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
                        r3.close();
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0094, code lost:
                        r3 = move-exception;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0095, code lost:
                        r2.addSuppressed(r3);
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0098, code lost:
                        throw r4;
                     */
                    public void run() {
                        try {
                            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                            randomAccessFile.write(bArr);
                            randomAccessFile.setLength(randomAccessFile.getFilePointer());
                            randomAccessFile.close();
                            RandomAccessFile randomAccessFile2 = new RandomAccessFile(new File(UnpackingSoSource.this.soDirectory, "dso_manifest"), "rw");
                            DsoManifest dsoManifest = dsoManifest;
                            if (dsoManifest != null) {
                                randomAccessFile2.writeByte(1);
                                randomAccessFile2.writeInt(dsoManifest.dsos.length);
                                int i = 0;
                                while (true) {
                                    Dso[] dsoArr = dsoManifest.dsos;
                                    if (i < dsoArr.length) {
                                        randomAccessFile2.writeUTF(dsoArr[i].name);
                                        randomAccessFile2.writeUTF(dsoManifest.dsos[i].hash);
                                        i++;
                                    } else {
                                        randomAccessFile2.close();
                                        ReactYogaConfigProvider.fsyncRecursive(UnpackingSoSource.this.soDirectory);
                                        UnpackingSoSource.writeState(file, (byte) 1);
                                        try {
                                            return;
                                        } catch (IOException e) {
                                            throw new RuntimeException(e);
                                        }
                                    }
                                }
                            } else {
                                throw null;
                            }
                        } finally {
                            String str = "releasing dso store lock for " + UnpackingSoSource.this.soDirectory + " (from syncer thread)";
                            fileLocker.close();
                        }
                    }
                };
                if ((i & 1) != 0) {
                    StringBuilder outline15 = GeneratedOutlineSupport.outline15("SoSync:");
                    outline15.append(this.soDirectory.getName());
                    new Thread(r9, outline15.toString()).start();
                } else {
                    r9.run();
                }
                return true;
            }
        }
        writeState(file, (byte) 0);
        Unpacker makeUnpacker = makeUnpacker();
        DsoManifest dsoManifest2 = makeUnpacker.getDsoManifest();
        regenerate(b, dsoManifest2, makeUnpacker.openDsoIterator());
        makeUnpacker.close();
        dsoManifest = dsoManifest2;
        randomAccessFile2.close();
        if (dsoManifest != null) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a1, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00a6, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00a7, code lost:
        r9.addSuppressed(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00aa, code lost:
        throw r10;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002e A[Catch:{ all -> 0x00a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0045 A[Catch:{ all -> 0x00a1 }] */
    public final void regenerate(byte b, DsoManifest dsoManifest, InputDsoIterator inputDsoIterator) throws IOException {
        DsoManifest dsoManifest2;
        getClass().getName();
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.soDirectory, "dso_manifest"), "rw");
        if (b == 1) {
            try {
                dsoManifest2 = DsoManifest.read(randomAccessFile);
            } catch (Exception e) {
                Log.i("fb-UnpackingSoSource", "error reading existing DSO manifest", e);
            }
            if (dsoManifest2 == null) {
                dsoManifest2 = new DsoManifest(new Dso[0]);
            }
            deleteUnmentionedFiles(dsoManifest.dsos);
            byte[] bArr = new byte[32768];
            while (inputDsoIterator.hasNext()) {
                InputDso next = inputDsoIterator.next();
                boolean z = true;
                int i = 0;
                while (z) {
                    try {
                        if (i >= dsoManifest2.dsos.length) {
                            break;
                        }
                        if (dsoManifest2.dsos[i].name.equals(next.dso.name) && dsoManifest2.dsos[i].hash.equals(next.dso.hash)) {
                            z = false;
                        }
                        i++;
                    } catch (Throwable th) {
                        if (next != null) {
                            try {
                                next.content.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                }
                if (z) {
                    extractDso(next, bArr);
                }
                if (next != null) {
                    next.content.close();
                }
            }
            randomAccessFile.close();
            getClass().getName();
        }
        dsoManifest2 = null;
        if (dsoManifest2 == null) {
        }
        deleteUnmentionedFiles(dsoManifest.dsos);
        byte[] bArr2 = new byte[32768];
        while (inputDsoIterator.hasNext()) {
        }
        randomAccessFile.close();
        getClass().getName();
    }
}
