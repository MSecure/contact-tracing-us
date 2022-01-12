package com.facebook.soloader;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Parcel;
import com.facebook.soloader.ExtractFromZipSoSource;
import com.facebook.soloader.UnpackingSoSource;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipEntry;

public class ApkSoSource extends ExtractFromZipSoSource {
    public final int mFlags;

    public class ApkUnpacker extends ExtractFromZipSoSource.ZipUnpacker {
        public final int mFlags;
        public File mLibDir;

        public ApkUnpacker(ExtractFromZipSoSource extractFromZipSoSource) throws IOException {
            super(extractFromZipSoSource);
            this.mLibDir = new File(ApkSoSource.this.mContext.getApplicationInfo().nativeLibraryDir);
            this.mFlags = ApkSoSource.this.mFlags;
        }

        @Override // com.facebook.soloader.ExtractFromZipSoSource.ZipUnpacker
        public boolean shouldExtract(ZipEntry zipEntry, String str) {
            String name = zipEntry.getName();
            if (str.equals(ApkSoSource.this.mCorruptedLib)) {
                ApkSoSource.this.mCorruptedLib = null;
                String.format("allowing consideration of corrupted lib %s", str);
            } else if ((this.mFlags & 1) != 0) {
                File file = new File(this.mLibDir, str);
                if (!file.isFile()) {
                    String.format("allowing considering of %s: %s not in system lib dir", name, str);
                } else {
                    long length = file.length();
                    long size = zipEntry.getSize();
                    if (length == size) {
                        return false;
                    }
                    String.format("allowing consideration of %s: sysdir file length is %s, but the file is %s bytes long in the APK", file, Long.valueOf(length), Long.valueOf(size));
                }
            }
            return true;
        }
    }

    public ApkSoSource(Context context, File file, String str, int i) {
        super(context, str, file, "^lib/([^/]+)/([^/]+\\.so)$");
        this.mFlags = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0045  */
    @Override // com.facebook.soloader.UnpackingSoSource
    public byte[] getDepsBlock() throws IOException {
        int i;
        File canonicalFile = this.mZipFileName.getCanonicalFile();
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeByte((byte) 2);
            obtain.writeString(canonicalFile.getPath());
            obtain.writeLong(canonicalFile.lastModified());
            Context context = this.mContext;
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                try {
                    i = packageManager.getPackageInfo(context.getPackageName(), 0).versionCode;
                } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
                }
                obtain.writeInt(i);
                if ((this.mFlags & 1) != 0) {
                    obtain.writeByte((byte) 0);
                    return obtain.marshall();
                }
                String str = this.mContext.getApplicationInfo().nativeLibraryDir;
                if (str == null) {
                    obtain.writeByte((byte) 1);
                    byte[] marshall = obtain.marshall();
                    obtain.recycle();
                    return marshall;
                }
                File canonicalFile2 = new File(str).getCanonicalFile();
                if (!canonicalFile2.exists()) {
                    obtain.writeByte((byte) 1);
                    byte[] marshall2 = obtain.marshall();
                    obtain.recycle();
                    return marshall2;
                }
                obtain.writeByte((byte) 2);
                obtain.writeString(canonicalFile2.getPath());
                obtain.writeLong(canonicalFile2.lastModified());
                byte[] marshall3 = obtain.marshall();
                obtain.recycle();
                return marshall3;
            }
            i = 0;
            obtain.writeInt(i);
            if ((this.mFlags & 1) != 0) {
            }
        } finally {
            obtain.recycle();
        }
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    public UnpackingSoSource.Unpacker makeUnpacker() throws IOException {
        return new ApkUnpacker(this);
    }
}
