package b.p;

import java.io.File;
import java.io.FileFilter;

public class c implements FileFilter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f1436a;

    public c(d dVar) {
        this.f1436a = dVar;
    }

    public boolean accept(File file) {
        return !file.getName().equals("MultiDex.lock");
    }
}
