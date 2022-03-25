package j.m;

import j.j.b.e;
import java.nio.charset.Charset;

public final class a {
    public static final Charset a;

    static {
        Charset forName = Charset.forName("UTF-8");
        e.b(forName, "Charset.forName(\"UTF-8\")");
        a = forName;
        e.b(Charset.forName("UTF-16"), "Charset.forName(\"UTF-16\")");
        e.b(Charset.forName("UTF-16BE"), "Charset.forName(\"UTF-16BE\")");
        e.b(Charset.forName("UTF-16LE"), "Charset.forName(\"UTF-16LE\")");
        e.b(Charset.forName("US-ASCII"), "Charset.forName(\"US-ASCII\")");
        e.b(Charset.forName("ISO-8859-1"), "Charset.forName(\"ISO-8859-1\")");
    }
}
