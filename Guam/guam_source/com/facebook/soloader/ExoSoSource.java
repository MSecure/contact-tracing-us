package com.facebook.soloader;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.soloader.UnpackingSoSource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public final class ExoSoSource extends UnpackingSoSource {

    public final class ExoUnpacker extends UnpackingSoSource.Unpacker {
        public final FileDso[] mDsos;

        public final class FileBackedInputDsoIterator extends UnpackingSoSource.InputDsoIterator {
            public int mCurrentDso;

            public FileBackedInputDsoIterator(AnonymousClass1 r2) {
            }

            @Override // com.facebook.soloader.UnpackingSoSource.InputDsoIterator
            public boolean hasNext() {
                return this.mCurrentDso < ExoUnpacker.this.mDsos.length;
            }

            @Override // com.facebook.soloader.UnpackingSoSource.InputDsoIterator
            public UnpackingSoSource.InputDso next() throws IOException {
                FileDso[] fileDsoArr = ExoUnpacker.this.mDsos;
                int i = this.mCurrentDso;
                this.mCurrentDso = i + 1;
                FileDso fileDso = fileDsoArr[i];
                FileInputStream fileInputStream = new FileInputStream(fileDso.backingFile);
                try {
                    return new UnpackingSoSource.InputDso(fileDso, fileInputStream);
                } catch (Throwable th) {
                    fileInputStream.close();
                    throw th;
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00e6, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
            r7.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ec, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ed, code lost:
            r0.addSuppressed(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00f1, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f5, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
            r9.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x00fb, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x00fc, code lost:
            r0.addSuppressed(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0100, code lost:
            throw r0;
         */
        public ExoUnpacker(ExoSoSource exoSoSource, UnpackingSoSource unpackingSoSource) throws IOException {
            boolean z;
            Context context = exoSoSource.mContext;
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("/data/local/tmp/exopackage/");
            outline15.append(context.getPackageName());
            outline15.append("/native-libs/");
            File file = new File(outline15.toString());
            ArrayList arrayList = new ArrayList();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            String[] supportedAbis = SysUtil$LollipopSysdeps.getSupportedAbis();
            for (String str : supportedAbis) {
                File file2 = new File(file, str);
                if (file2.isDirectory()) {
                    linkedHashSet.add(str);
                    File file3 = new File(file2, "metadata.txt");
                    if (file3.isFile()) {
                        FileReader fileReader = new FileReader(file3);
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                bufferedReader.close();
                                fileReader.close();
                                break;
                            } else if (readLine.length() != 0) {
                                int indexOf = readLine.indexOf(32);
                                if (indexOf != -1) {
                                    String str2 = readLine.substring(0, indexOf) + ".so";
                                    int size = arrayList.size();
                                    int i = 0;
                                    while (true) {
                                        if (i >= size) {
                                            z = false;
                                            break;
                                        } else if (((FileDso) arrayList.get(i)).name.equals(str2)) {
                                            z = true;
                                            break;
                                        } else {
                                            i++;
                                        }
                                    }
                                    if (!z) {
                                        String substring = readLine.substring(indexOf + 1);
                                        arrayList.add(new FileDso(str2, substring, new File(file2, substring)));
                                    }
                                } else {
                                    throw new RuntimeException("illegal line in exopackage metadata: [" + readLine + "]");
                                }
                            }
                        }
                    } else {
                        continue;
                    }
                }
            }
            String[] strArr = (String[]) linkedHashSet.toArray(new String[linkedHashSet.size()]);
            this.mDsos = (FileDso[]) arrayList.toArray(new FileDso[arrayList.size()]);
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public UnpackingSoSource.DsoManifest getDsoManifest() throws IOException {
            return new UnpackingSoSource.DsoManifest(this.mDsos);
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public UnpackingSoSource.InputDsoIterator openDsoIterator() throws IOException {
            return new FileBackedInputDsoIterator(null);
        }
    }

    public static final class FileDso extends UnpackingSoSource.Dso {
        public final File backingFile;

        public FileDso(String str, String str2, File file) {
            super(str, str2);
            this.backingFile = file;
        }
    }

    public ExoSoSource(Context context, String str) {
        super(context, str);
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    public UnpackingSoSource.Unpacker makeUnpacker() throws IOException {
        return new ExoUnpacker(this, this);
    }
}
