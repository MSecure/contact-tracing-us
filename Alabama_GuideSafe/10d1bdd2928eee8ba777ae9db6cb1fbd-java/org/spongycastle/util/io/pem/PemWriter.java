package org.spongycastle.util.io.pem;

import java.io.BufferedWriter;
import java.io.Writer;
import org.spongycastle.util.Strings;

public class PemWriter extends BufferedWriter {
    public char[] buf = new char[64];

    public PemWriter(Writer writer) {
        super(writer);
        String str = Strings.LINE_SEPARATOR;
        if (str != null) {
            str.length();
        }
    }
}
