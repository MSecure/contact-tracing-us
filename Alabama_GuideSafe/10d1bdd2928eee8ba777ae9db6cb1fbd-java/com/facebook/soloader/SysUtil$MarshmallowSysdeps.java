package com.facebook.soloader;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Process;
import java.util.ArrayList;
import java.util.TreeSet;

@DoNotOptimize
@TargetApi(23)
public final class SysUtil$MarshmallowSysdeps {
    @DoNotOptimize
    public static String[] getSupportedAbis() {
        String[] strArr = Build.SUPPORTED_ABIS;
        TreeSet treeSet = new TreeSet();
        if (is64Bit()) {
            treeSet.add(MinElf$ISA.AARCH64.value);
            treeSet.add(MinElf$ISA.X86_64.value);
        } else {
            treeSet.add(MinElf$ISA.ARM.value);
            treeSet.add(MinElf$ISA.X86.value);
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (treeSet.contains(str)) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @DoNotOptimize
    public static boolean is64Bit() {
        return Process.is64Bit();
    }
}
