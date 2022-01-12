package timber.log;

import java.util.ArrayList;

public final class Timber {
    public static final Tree[] TREE_ARRAY_EMPTY = new Tree[0];
    public static final Tree TREE_OF_SOULS = new Tree() {
        /* class timber.log.Timber.AnonymousClass1 */

        @Override // timber.log.Timber.Tree
        public void d(String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.d(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public void e(String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.e(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public void v(String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.v(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public void w(String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.w(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public void d(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.d(th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public void e(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.e(th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public void w(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.w(th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public void e(Throwable th) {
            for (Tree tree : Timber.forestAsArray) {
                tree.e(th);
            }
        }
    };
    public static volatile Tree[] forestAsArray = TREE_ARRAY_EMPTY;

    public static abstract class Tree {
        public final ThreadLocal<String> explicitTag = new ThreadLocal<>();

        public abstract void d(String str, Object... objArr);

        public abstract void d(Throwable th, String str, Object... objArr);

        public abstract void e(String str, Object... objArr);

        public abstract void e(Throwable th);

        public abstract void e(Throwable th, String str, Object... objArr);

        public abstract void v(String str, Object... objArr);

        public abstract void w(String str, Object... objArr);

        public abstract void w(Throwable th, String str, Object... objArr);
    }

    static {
        new ArrayList();
    }

    public static Tree tag(String str) {
        for (Tree tree : forestAsArray) {
            tree.explicitTag.set(str);
        }
        return TREE_OF_SOULS;
    }
}
