package h.a.j1;

import h.a.a;
import h.a.j1.f0;
import h.a.v;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public final class g1 implements f0.f {
    public static final Throwable a;

    public static final class a implements c {
        public static void a(NamingEnumeration<?> namingEnumeration, NamingException namingException) {
            try {
                namingEnumeration.close();
            } catch (NamingException unused) {
            }
            throw namingException;
        }

        public static void b(DirContext dirContext, NamingException namingException) {
            try {
                dirContext.close();
            } catch (NamingException unused) {
            }
            throw namingException;
        }

        public List<String> c(String str, String str2) {
            Throwable th = g1.a;
            if (th == null) {
                String[] strArr = {str};
                ArrayList arrayList = new ArrayList();
                Hashtable hashtable = new Hashtable();
                hashtable.put("com.sun.jndi.ldap.connect.timeout", "5000");
                hashtable.put("com.sun.jndi.ldap.read.timeout", "5000");
                InitialDirContext initialDirContext = new InitialDirContext(hashtable);
                try {
                    NamingEnumeration all = initialDirContext.getAttributes(str2, strArr).getAll();
                    while (all.hasMore()) {
                        try {
                            NamingEnumeration all2 = ((Attribute) all.next()).getAll();
                            while (all2.hasMore()) {
                                try {
                                    arrayList.add(String.valueOf(all2.next()));
                                } catch (NamingException e2) {
                                    a(all2, e2);
                                    throw null;
                                }
                            }
                            all2.close();
                        } catch (NamingException e3) {
                            a(all, e3);
                            throw null;
                        }
                    }
                    all.close();
                    initialDirContext.close();
                    return arrayList;
                } catch (NamingException e4) {
                    b(initialDirContext, e4);
                    throw null;
                }
            } else {
                throw new UnsupportedOperationException("JNDI is not currently available", th);
            }
        }
    }

    public static final class b implements f0.e {
        public static final Logger b = Logger.getLogger(b.class.getName());
        public static final Pattern c = Pattern.compile("\\s+");
        public final c a;

        public static final class a {
            public final String a;
            public final int b;

            public a(String str, int i2) {
                this.a = str;
                this.b = i2;
            }
        }

        public b(c cVar) {
            this.a = cVar;
        }

        public static a c(String str) {
            String[] split = c.split(str);
            f.b.a.c.b.o.b.W1(split.length == 4, "Bad SRV Record: %s", str);
            return new a(split[3], Integer.parseInt(split[2]));
        }

        @Override // h.a.j1.f0.e
        public List<v> a(f0.a aVar, String str) {
            Throwable e2;
            Logger logger = b;
            Level level = Level.FINER;
            if (logger.isLoggable(level)) {
                logger.log(level, "About to query SRV records for {0}", new Object[]{str});
            }
            List<String> c2 = ((a) this.a).c("SRV", f.a.a.a.a.t("dns:///", str));
            if (logger.isLoggable(level)) {
                logger.log(level, "Found {0} SRV records", new Object[]{Integer.valueOf(((ArrayList) c2).size())});
            }
            ArrayList arrayList = (ArrayList) c2;
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            Throwable th = null;
            Level level2 = Level.WARNING;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                try {
                    a c3 = c(str2);
                    if (c3.a.endsWith(".")) {
                        String str3 = c3.a;
                        String substring = str3.substring(0, str3.length() - 1);
                        String str4 = c3.a;
                        Objects.requireNonNull((f0.b) aVar);
                        List<InetAddress> unmodifiableList = Collections.unmodifiableList(Arrays.asList(InetAddress.getAllByName(str4)));
                        ArrayList arrayList3 = new ArrayList(unmodifiableList.size());
                        for (InetAddress inetAddress : unmodifiableList) {
                            arrayList3.add(new InetSocketAddress(inetAddress, c3.b));
                        }
                        a.b a2 = h.a.a.a();
                        a2.b(p0.c, substring);
                        arrayList2.add(new v(Collections.unmodifiableList(arrayList3), a2.a()));
                    } else {
                        throw new RuntimeException("Returned SRV host does not end in period: " + c3.a);
                    }
                } catch (UnknownHostException e3) {
                    e2 = e3;
                    Logger logger2 = b;
                    logger2.log(level2, "Can't find address for SRV record " + str2, e2);
                    if (th != null) {
                    }
                    th = e2;
                    level2 = Level.FINE;
                } catch (RuntimeException e4) {
                    e2 = e4;
                    Logger logger3 = b;
                    logger3.log(level2, "Failed to construct SRV record " + str2, e2);
                    if (th != null) {
                    }
                    th = e2;
                    level2 = Level.FINE;
                }
            }
            if (!arrayList2.isEmpty() || th == null) {
                return Collections.unmodifiableList(arrayList2);
            }
            throw th;
        }

        @Override // h.a.j1.f0.e
        public List<String> b(String str) {
            Logger logger = b;
            Level level = Level.FINER;
            if (logger.isLoggable(level)) {
                logger.log(level, "About to query TXT records for {0}", new Object[]{str});
            }
            List<String> c2 = ((a) this.a).c("TXT", f.a.a.a.a.t("dns:///", str));
            if (logger.isLoggable(level)) {
                logger.log(level, "Found {0} TXT records", new Object[]{Integer.valueOf(((ArrayList) c2).size())});
            }
            ArrayList arrayList = (ArrayList) c2;
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                StringBuilder sb = new StringBuilder(str2.length());
                int i2 = 0;
                boolean z = false;
                while (i2 < str2.length()) {
                    char charAt = str2.charAt(i2);
                    if (!z) {
                        if (charAt != ' ') {
                            if (charAt == '\"') {
                                z = true;
                            }
                        }
                        i2++;
                    } else if (charAt == '\"') {
                        z = false;
                        i2++;
                    } else if (charAt == '\\') {
                        i2++;
                        charAt = str2.charAt(i2);
                    }
                    sb.append(charAt);
                    i2++;
                }
                arrayList2.add(sb.toString());
            }
            return Collections.unmodifiableList(arrayList2);
        }
    }

    public interface c {
    }

    static {
        Throwable e2;
        try {
            Class.forName("javax.naming.directory.InitialDirContext");
            Class.forName("com.sun.jndi.dns.DnsContextFactory");
            e2 = null;
        } catch (ClassNotFoundException | Error | RuntimeException e3) {
            e2 = e3;
        }
        a = e2;
    }

    @Override // h.a.j1.f0.f
    public f0.e a() {
        if (a != null) {
            return null;
        }
        return new b(new a());
    }

    @Override // h.a.j1.f0.f
    public Throwable b() {
        return a;
    }
}
