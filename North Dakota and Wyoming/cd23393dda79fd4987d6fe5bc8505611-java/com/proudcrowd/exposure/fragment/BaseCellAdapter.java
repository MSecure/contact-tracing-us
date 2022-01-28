package com.proudcrowd.exposure.fragment;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.proudcrowd.exposure.core.ExposureApplication;
import com.proudcrowd.exposure.datasource.BaseDataSource;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class BaseCellAdapter<InnerType> extends BaseAdapter implements Callback<ArrayList<InnerType>> {
    CellConsumer mControllingFragment;
    BaseDataSource<InnerType> mDataSource;
    Long mLastLoadedDate = 0L;

    public interface CellConsumer {
        ExposureApplication getAppContext();

        void onDataLoaded();

        void onDataLoadedNoData();

        void onDataLoadedWithError(String str);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public abstract View getView(int i, View view, ViewGroup viewGroup);

    protected BaseCellAdapter() {
    }

    /* access modifiers changed from: protected */
    public void initDataSource(BaseDataSource<InnerType> baseDataSource, CellConsumer cellConsumer) {
        this.mControllingFragment = cellConsumer;
        this.mDataSource = baseDataSource;
    }

    /* access modifiers changed from: protected */
    public void loadData() {
        if (Long.valueOf(System.currentTimeMillis()).longValue() - this.mLastLoadedDate.longValue() > 5000) {
            this.mDataSource.ExecuteRequest();
        }
    }

    public void cancelLoadData() {
        this.mControllingFragment = null;
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<ArrayList<InnerType>> call, Response<ArrayList<InnerType>> response) {
        if (this.mControllingFragment != null && this.mDataSource != null) {
            if (response.isSuccessful()) {
                this.mDataSource.Results = response.body();
                this.mLastLoadedDate = Long.valueOf(System.currentTimeMillis());
                if (this.mDataSource.getResults().size() == 0) {
                    this.mControllingFragment.onDataLoadedNoData();
                }
                notifyDataSetChanged();
                this.mControllingFragment.onDataLoaded();
                return;
            }
            this.mControllingFragment.onDataLoadedWithError(response.message());
        }
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<ArrayList<InnerType>> call, Throwable th) {
        this.mControllingFragment.onDataLoadedWithError(th.toString());
        Log.e("DATA FAILED", th.toString());
    }

    public void refreshList() {
        notifyDataSetChanged();
    }

    public void reloadList() {
        this.mDataSource.ExecuteRequest();
    }

    /* access modifiers changed from: protected */
    public ExposureApplication getAppContext() {
        return this.mControllingFragment.getAppContext();
    }

    public int getCount() {
        BaseDataSource<InnerType> baseDataSource;
        ArrayList<InnerType> arrayList;
        if (this.mControllingFragment == null || (baseDataSource = this.mDataSource) == null || (arrayList = baseDataSource.Results) == null) {
            return 0;
        }
        return arrayList.size();
    }

    public Object getItem(int i) {
        BaseDataSource<InnerType> baseDataSource;
        ArrayList<InnerType> arrayList;
        if (this.mControllingFragment == null || (baseDataSource = this.mDataSource) == null || (arrayList = baseDataSource.Results) == null) {
            return null;
        }
        return arrayList.get(i);
    }
}
