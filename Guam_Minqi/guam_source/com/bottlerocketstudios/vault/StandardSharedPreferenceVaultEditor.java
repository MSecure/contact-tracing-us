package com.bottlerocketstudios.vault;

import android.content.SharedPreferences;
import java.util.HashSet;
import java.util.Set;

public class StandardSharedPreferenceVaultEditor implements SharedPreferences.Editor {
    public boolean mCleared;
    public Set<String> mRemovalSet = new HashSet();
    public final StandardSharedPreferenceVault mStandardSharedPreferenceVault;
    public StronglyTypedBundle mStronglyTypedBundle = new StronglyTypedBundle();

    public StandardSharedPreferenceVaultEditor(StandardSharedPreferenceVault standardSharedPreferenceVault) {
        this.mStandardSharedPreferenceVault = standardSharedPreferenceVault;
    }

    public void apply() {
        this.mStandardSharedPreferenceVault.writeValues(false, this.mCleared, this.mRemovalSet, this.mStronglyTypedBundle);
    }

    public SharedPreferences.Editor clear() {
        this.mCleared = true;
        return this;
    }

    public boolean commit() {
        return this.mStandardSharedPreferenceVault.writeValues(true, this.mCleared, this.mRemovalSet, this.mStronglyTypedBundle);
    }

    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        StronglyTypedBundle stronglyTypedBundle = this.mStronglyTypedBundle;
        Boolean valueOf = Boolean.valueOf(z);
        stronglyTypedBundle.mValueMap.put(str, valueOf);
        stronglyTypedBundle.mClassMap.put(str, valueOf.getClass());
        return this;
    }

    public SharedPreferences.Editor putFloat(String str, float f) {
        StronglyTypedBundle stronglyTypedBundle = this.mStronglyTypedBundle;
        Float valueOf = Float.valueOf(f);
        stronglyTypedBundle.mValueMap.put(str, valueOf);
        stronglyTypedBundle.mClassMap.put(str, valueOf.getClass());
        return this;
    }

    public SharedPreferences.Editor putInt(String str, int i) {
        StronglyTypedBundle stronglyTypedBundle = this.mStronglyTypedBundle;
        Integer valueOf = Integer.valueOf(i);
        stronglyTypedBundle.mValueMap.put(str, valueOf);
        stronglyTypedBundle.mClassMap.put(str, valueOf.getClass());
        return this;
    }

    public SharedPreferences.Editor putLong(String str, long j) {
        StronglyTypedBundle stronglyTypedBundle = this.mStronglyTypedBundle;
        Long valueOf = Long.valueOf(j);
        stronglyTypedBundle.mValueMap.put(str, valueOf);
        stronglyTypedBundle.mClassMap.put(str, valueOf.getClass());
        return this;
    }

    public SharedPreferences.Editor putString(String str, String str2) {
        StronglyTypedBundle stronglyTypedBundle = this.mStronglyTypedBundle;
        stronglyTypedBundle.mValueMap.put(str, str2);
        stronglyTypedBundle.mClassMap.put(str, str2.getClass());
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        StronglyTypedBundle stronglyTypedBundle = this.mStronglyTypedBundle;
        stronglyTypedBundle.mValueMap.put(str, set);
        stronglyTypedBundle.mClassMap.put(str, set.getClass());
        return this;
    }

    public SharedPreferences.Editor remove(String str) {
        StronglyTypedBundle stronglyTypedBundle = this.mStronglyTypedBundle;
        stronglyTypedBundle.mValueMap.remove(str);
        stronglyTypedBundle.mClassMap.remove(str);
        this.mRemovalSet.add(str);
        return this;
    }
}
