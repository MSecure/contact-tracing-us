package b.p;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<File> f1434a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f1435b;

    static {
        String property = System.getProperty("java.vm.version");
        boolean z = false;
        if (property != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(property, ".");
            String str = null;
            String nextToken = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : null;
            if (stringTokenizer.hasMoreTokens()) {
                str = stringTokenizer.nextToken();
            }
            if (!(nextToken == null || str == null)) {
                try {
                    int parseInt = Integer.parseInt(nextToken);
                    int parseInt2 = Integer.parseInt(str);
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 >= 1)) {
                        z = true;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        f1435b = z;
    }

    public static void a(Object obj, String str, Object[] objArr) {
        Field e2 = e(obj, str);
        Object[] objArr2 = (Object[]) e2.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        e2.set(obj, objArr3);
    }

    public static Method b(Object obj, String str, Class[] clsArr) {
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    public static void c(Context context) {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            file.getPath();
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                file.getPath();
                return;
            }
            for (File file2 : listFiles) {
                file2.getPath();
                file2.length();
                file2.delete();
                file2.getPath();
            }
            file.delete();
            file.getPath();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        if ((r2 instanceof dalvik.system.BaseDexClassLoader) != false) goto L_0x0022;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0068 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x006a  */
    public static void d(Context context, File file, File file2, String str, String str2, boolean z) {
        IOException e2;
        ClassLoader classLoader;
        File file3;
        File file4;
        d dVar;
        synchronized (f1434a) {
            if (!f1434a.contains(file)) {
                f1434a.add(file);
                System.getProperty("java.vm.version");
                e2 = null;
                try {
                    classLoader = context.getClassLoader();
                } catch (RuntimeException unused) {
                }
            } else {
                return;
            }
        }
        file4 = new File(file3, str);
        g(file4);
        dVar = new d(file, file4);
        try {
            try {
                f(classLoader, file4, dVar.e(context, str2, false));
            } catch (IOException e3) {
                if (z) {
                    f(classLoader, file4, dVar.e(context, str2, true));
                } else {
                    throw e3;
                }
            }
            try {
            } catch (IOException e4) {
                e2 = e4;
            }
            if (e2 == null) {
                throw e2;
            }
            return;
        } finally {
            try {
                dVar.close();
            } catch (IOException unused2) {
            }
        }
        classLoader = null;
        if (classLoader != null) {
            try {
                c(context);
            } catch (Throwable unused3) {
            }
            file3 = new File(file2, "code_cache");
            try {
                g(file3);
            } catch (IOException unused4) {
                file3 = new File(context.getFilesDir(), "code_cache");
                g(file3);
            }
            file4 = new File(file3, str);
            g(file4);
            dVar = new d(file, file4);
            f(classLoader, file4, dVar.e(context, str2, false));
            if (e2 == null) {
            }
        } else {
            return;
        }
        if (e2 == null) {
        }
        file3 = new File(file2, "code_cache");
        g(file3);
        file4 = new File(file3, str);
        g(file4);
        dVar = new d(file, file4);
        f(classLoader, file4, dVar.e(context, str2, false));
        if (e2 == null) {
        }
    }

    public static Field e(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    public static void f(ClassLoader classLoader, File file, List<? extends File> list) {
        IOException[] iOExceptionArr;
        if (!list.isEmpty()) {
            Object obj = e(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList(list);
            a(obj, "dexElements", (Object[]) b(obj, "makeDexElements", new Class[]{ArrayList.class, File.class, ArrayList.class}).invoke(obj, arrayList2, file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    IOException iOException = (IOException) it.next();
                }
                Field e2 = e(obj, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr2 = (IOException[]) e2.get(obj);
                if (iOExceptionArr2 == null) {
                    iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    IOException[] iOExceptionArr3 = new IOException[(arrayList.size() + iOExceptionArr2.length)];
                    arrayList.toArray(iOExceptionArr3);
                    System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                    iOExceptionArr = iOExceptionArr3;
                }
                e2.set(obj, iOExceptionArr);
                IOException iOException2 = new IOException("I/O exception during makeDexElement");
                iOException2.initCause((Throwable) arrayList.get(0));
                throw iOException2;
            }
        }
    }

    public static void g(File file) {
        file.mkdir();
        if (!file.isDirectory()) {
            File parentFile = file.getParentFile();
            file.getPath();
            if (parentFile != null) {
                parentFile.isDirectory();
                parentFile.isFile();
                parentFile.exists();
                parentFile.canRead();
                parentFile.canWrite();
            }
            StringBuilder g = c.a.a.a.a.g("Failed to create directory ");
            g.append(file.getPath());
            throw new IOException(g.toString());
        }
    }
}
