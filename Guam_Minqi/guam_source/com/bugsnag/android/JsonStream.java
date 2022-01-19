package com.bugsnag.android;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;

public class JsonStream extends JsonWriter {
    public final ObjectJsonStreamer objectJsonStreamer = new ObjectJsonStreamer();
    public final Writer out;

    public interface Streamable {
        void toStream(JsonStream jsonStream) throws IOException;
    }

    public JsonStream(Writer writer) {
        super(writer);
        this.serializeNulls = false;
        this.out = writer;
    }

    @Override // com.bugsnag.android.JsonWriter
    public JsonStream name(String str) throws IOException {
        super.name(str);
        return this;
    }

    public void value(Object obj) throws IOException {
        if (obj instanceof Streamable) {
            ((Streamable) obj).toStream(this);
        } else {
            this.objectJsonStreamer.objectToStream(obj, this, false);
        }
    }

    @Override // com.bugsnag.android.JsonWriter
    /* renamed from: name  reason: collision with other method in class */
    public JsonWriter m6name(String str) throws IOException {
        super.name(str);
        return this;
    }

    public void value(Object obj, boolean z) throws IOException {
        if (obj instanceof Streamable) {
            ((Streamable) obj).toStream(this);
        } else {
            this.objectJsonStreamer.objectToStream(obj, this, z);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004f A[SYNTHETIC, Splitter:B:22:0x004f] */
    public void value(File file) throws IOException {
        BufferedReader bufferedReader;
        Throwable th;
        if (file != null) {
            long j = 0;
            if (file.length() > 0) {
                super.flush();
                beforeValue();
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                    try {
                        Writer writer = this.out;
                        char[] cArr = new char[4096];
                        while (true) {
                            int read = bufferedReader.read(cArr);
                            if (-1 == read) {
                                break;
                            }
                            writer.write(cArr, 0, read);
                            j += (long) read;
                        }
                        int i = (j > 2147483647L ? 1 : (j == 2147483647L ? 0 : -1));
                        try {
                            bufferedReader.close();
                        } catch (Exception unused) {
                        }
                        this.out.flush();
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            }
        }
    }
}
