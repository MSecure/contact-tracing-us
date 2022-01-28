package com.bugfender.sdk.a.a.c.e;

import com.bugfender.sdk.a.a.h.g;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class a implements com.bugfender.sdk.a.a.c.a<File, List<g>> {
    private b a;

    public a(b bVar) {
        this.a = bVar;
    }

    private List<g> b(File file) {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(file)));
        ArrayList arrayList = new ArrayList();
        while (scanner.hasNextLine()) {
            try {
                g a2 = this.a.a(scanner.nextLine());
                if (a2 != null) {
                    arrayList.add(a2);
                }
            } finally {
                scanner.close();
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public List<g> b(File file) {
        try {
            return b(file);
        } catch (IOException unused) {
            return Collections.emptyList();
        }
    }

    public File a(List<g> list) {
        throw new UnsupportedOperationException("from(List<LogEntry> value) not supported");
    }
}
