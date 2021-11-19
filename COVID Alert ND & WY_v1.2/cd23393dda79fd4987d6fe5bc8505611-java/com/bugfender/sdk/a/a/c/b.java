package com.bugfender.sdk.a.a.c;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class b implements a<File, List<String>> {
    private List<String> b(File file) {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(file)));
        ArrayList arrayList = new ArrayList();
        while (scanner.hasNextLine()) {
            try {
                String nextLine = scanner.nextLine();
                if (nextLine != null && !nextLine.isEmpty()) {
                    arrayList.add(nextLine);
                }
            } finally {
                scanner.close();
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public List<String> b(File file) {
        try {
            return b(file);
        } catch (IOException unused) {
            return Collections.emptyList();
        }
    }

    public File a(List<String> list) {
        throw new UnsupportedOperationException("from(List<String> value) not supported");
    }
}
