package com.getkeepsafe.relinker;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ApkLibraryInstaller implements ReLinker$LibraryInstaller {

    public static class ZipFileInZipEntry {
        public ZipEntry zipEntry;
        public ZipFile zipFile;

        public ZipFileInZipEntry(ZipFile zipFile2, ZipEntry zipEntry2) {
            this.zipFile = zipFile2;
            this.zipEntry = zipEntry2;
        }
    }

    public final ZipFileInZipEntry findAPKWithLibrary(Context context, String[] strArr, String str, ReLinkerInstance reLinkerInstance) {
        int i;
        String[] sourceDirectories = sourceDirectories(context);
        int length = sourceDirectories.length;
        int i2 = 0;
        ZipFile zipFile = null;
        int i3 = 0;
        while (i2 < length) {
            String str2 = sourceDirectories[i2];
            int i4 = i3;
            while (true) {
                int i5 = i4 + 1;
                i = 5;
                if (i4 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i4 = i5;
                }
            }
            if (zipFile != null) {
                int i6 = i3;
                while (true) {
                    int i7 = i3 + 1;
                    if (i3 < i) {
                        int length2 = strArr.length;
                        int i8 = i;
                        int i9 = i6;
                        while (i6 < length2) {
                            String str3 = strArr[i6];
                            StringBuilder outline15 = GeneratedOutlineSupport.outline15("lib");
                            outline15.append(File.separatorChar);
                            outline15.append(str3);
                            outline15.append(File.separatorChar);
                            outline15.append(str);
                            String sb = outline15.toString();
                            Object[] objArr = new Object[2];
                            objArr[i9] = sb;
                            objArr[1] = str2;
                            if (reLinkerInstance != null) {
                                String.format(Locale.US, "Looking for %s in APK %s...", objArr);
                                ZipEntry entry = zipFile.getEntry(sb);
                                if (entry != null) {
                                    return new ZipFileInZipEntry(zipFile, entry);
                                }
                                i6++;
                                i9 = 0;
                                i8 = 5;
                            } else {
                                throw null;
                            }
                        }
                        i3 = i7;
                        i6 = i9;
                        i = i8;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i2++;
            i3 = 0;
        }
        return null;
    }

    public final String[] getSupportedABIs(Context context, String str) {
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("lib");
        outline15.append(File.separatorChar);
        outline15.append("([^\\");
        outline15.append(File.separatorChar);
        outline15.append("]*)");
        outline15.append(File.separatorChar);
        outline15.append(str);
        Pattern compile = Pattern.compile(outline15.toString());
        HashSet hashSet = new HashSet();
        for (String str2 : sourceDirectories(context)) {
            try {
                Enumeration<? extends ZipEntry> entries = new ZipFile(new File(str2), 1).entries();
                while (entries.hasMoreElements()) {
                    Matcher matcher = compile.matcher(((ZipEntry) entries.nextElement()).getName());
                    if (matcher.matches()) {
                        hashSet.add(matcher.group(1));
                    }
                }
            } catch (IOException unused) {
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public final String[] sourceDirectories(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr == null || strArr.length == 0) {
            return new String[]{applicationInfo.sourceDir};
        }
        String[] strArr2 = new String[(strArr.length + 1)];
        strArr2[0] = applicationInfo.sourceDir;
        System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
        return strArr2;
    }
}
