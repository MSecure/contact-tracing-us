package androidx.loader.app;

import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.collection.SparseArrayCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelProvider$KeyedFactory;
import androidx.lifecycle.ViewModelProvider$OnRequeryFactory;
import androidx.lifecycle.ViewModelStore;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class LoaderManagerImpl extends LoaderManager {
    public final LifecycleOwner mLifecycleOwner;
    public final LoaderViewModel mLoaderViewModel;

    public static class LoaderInfo<D> extends MutableLiveData<D> {
        public LifecycleOwner mLifecycleOwner;
        public LoaderObserver<D> mObserver;

        @Override // androidx.lifecycle.LiveData
        public void onActive() {
            throw null;
        }

        @Override // androidx.lifecycle.LiveData
        public void onInactive() {
            throw null;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: androidx.lifecycle.Observer<? super D> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void removeObserver(Observer<? super D> observer) {
            super.removeObserver(observer);
            this.mLifecycleOwner = null;
            this.mObserver = null;
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(D d) {
            super.setValue(d);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(0);
            sb.append(" : ");
            AppCompatDelegateImpl.ConfigurationImplApi17.buildShortClassTag(null, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    public static class LoaderObserver<D> implements Observer<D> {
    }

    public static class LoaderViewModel extends ViewModel {
        public static final ViewModelProvider$Factory FACTORY = new ViewModelProvider$Factory() {
            /* class androidx.loader.app.LoaderManagerImpl.LoaderViewModel.AnonymousClass1 */

            public <T extends ViewModel> T create(Class<T> cls) {
                return new LoaderViewModel();
            }
        };
        public SparseArrayCompat<LoaderInfo> mLoaders = new SparseArrayCompat<>(10);

        @Override // androidx.lifecycle.ViewModel
        public void onCleared() {
            if (this.mLoaders.size() <= 0) {
                SparseArrayCompat<LoaderInfo> sparseArrayCompat = this.mLoaders;
                int i = sparseArrayCompat.mSize;
                Object[] objArr = sparseArrayCompat.mValues;
                for (int i2 = 0; i2 < i; i2++) {
                    objArr[i2] = null;
                }
                sparseArrayCompat.mSize = 0;
                sparseArrayCompat.mGarbage = false;
            } else if (this.mLoaders.valueAt(0) != null) {
                throw null;
            } else {
                throw null;
            }
        }
    }

    public LoaderManagerImpl(LifecycleOwner lifecycleOwner, ViewModelStore viewModelStore) {
        ViewModel viewModel;
        this.mLifecycleOwner = lifecycleOwner;
        ViewModelProvider$Factory viewModelProvider$Factory = LoaderViewModel.FACTORY;
        String canonicalName = LoaderViewModel.class.getCanonicalName();
        if (canonicalName != null) {
            String outline10 = GeneratedOutlineSupport.outline10("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
            ViewModel viewModel2 = viewModelStore.mMap.get(outline10);
            if (!LoaderViewModel.class.isInstance(viewModel2)) {
                if (viewModelProvider$Factory instanceof ViewModelProvider$KeyedFactory) {
                    viewModel = ((ViewModelProvider$KeyedFactory) viewModelProvider$Factory).create(outline10, LoaderViewModel.class);
                } else {
                    viewModel = ((LoaderViewModel.AnonymousClass1) viewModelProvider$Factory).create(LoaderViewModel.class);
                }
                viewModel2 = viewModel;
                ViewModel put = viewModelStore.mMap.put(outline10, viewModel2);
                if (put != null) {
                    put.onCleared();
                }
            } else if (viewModelProvider$Factory instanceof ViewModelProvider$OnRequeryFactory) {
                ViewModelProvider$OnRequeryFactory viewModelProvider$OnRequeryFactory = (ViewModelProvider$OnRequeryFactory) viewModelProvider$Factory;
            }
            this.mLoaderViewModel = (LoaderViewModel) viewModel2;
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.loader.app.LoaderManager
    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        LoaderViewModel loaderViewModel = this.mLoaderViewModel;
        if (loaderViewModel.mLoaders.size() > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            String str2 = str + "    ";
            if (loaderViewModel.mLoaders.size() > 0) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(loaderViewModel.mLoaders.keyAt(0));
                printWriter.print(": ");
                printWriter.println(loaderViewModel.mLoaders.valueAt(0).toString());
                printWriter.print(str2);
                printWriter.print("mId=");
                printWriter.print(0);
                printWriter.print(" mArgs=");
                printWriter.println((Object) null);
                printWriter.print(str2);
                printWriter.print("mLoader=");
                printWriter.println((Object) null);
                throw null;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        AppCompatDelegateImpl.ConfigurationImplApi17.buildShortClassTag(this.mLifecycleOwner, sb);
        sb.append("}}");
        return sb.toString();
    }
}
