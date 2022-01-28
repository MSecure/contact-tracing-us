package androidx.recyclerview.widget;

import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SimplePool;
import androidx.recyclerview.widget.OpReorderer;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class AdapterHelper implements OpReorderer.Callback {
    public final Callback mCallback;
    public final boolean mDisableRecycler;
    public int mExistingUpdateTypes = 0;
    public final OpReorderer mOpReorderer;
    public final ArrayList<UpdateOp> mPendingUpdates = new ArrayList<>();
    public final ArrayList<UpdateOp> mPostponedList = new ArrayList<>();
    public Pools$Pool<UpdateOp> mUpdateOpPool = new Pools$SimplePool(30);

    public interface Callback {
    }

    public static class UpdateOp {
        public int cmd;
        public int itemCount;
        public Object payload;
        public int positionStart;

        public UpdateOp(int i, int i2, int i3, Object obj) {
            this.cmd = i;
            this.positionStart = i2;
            this.itemCount = i3;
            this.payload = obj;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || UpdateOp.class != obj.getClass()) {
                return false;
            }
            UpdateOp updateOp = (UpdateOp) obj;
            int i = this.cmd;
            if (i != updateOp.cmd) {
                return false;
            }
            if (i == 8 && Math.abs(this.itemCount - this.positionStart) == 1 && this.itemCount == updateOp.positionStart && this.positionStart == updateOp.itemCount) {
                return true;
            }
            if (this.itemCount != updateOp.itemCount || this.positionStart != updateOp.positionStart) {
                return false;
            }
            Object obj2 = this.payload;
            if (obj2 != null) {
                if (!obj2.equals(updateOp.payload)) {
                    return false;
                }
            } else if (updateOp.payload != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.cmd * 31) + this.positionStart) * 31) + this.itemCount;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append("[");
            int i = this.cmd;
            sb.append(i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : "up" : "rm" : "add");
            sb.append(",s:");
            sb.append(this.positionStart);
            sb.append("c:");
            sb.append(this.itemCount);
            sb.append(",p:");
            sb.append(this.payload);
            sb.append("]");
            return sb.toString();
        }
    }

    public AdapterHelper(Callback callback) {
        this.mCallback = callback;
        this.mDisableRecycler = false;
        this.mOpReorderer = new OpReorderer(this);
    }

    public final boolean canFindInPreLayout(int i) {
        int size = this.mPostponedList.size();
        for (int i2 = 0; i2 < size; i2++) {
            UpdateOp updateOp = this.mPostponedList.get(i2);
            int i3 = updateOp.cmd;
            if (i3 == 8) {
                if (findPositionOffset(updateOp.itemCount, i2 + 1) == i) {
                    return true;
                }
            } else if (i3 == 1) {
                int i4 = updateOp.positionStart;
                int i5 = updateOp.itemCount + i4;
                while (i4 < i5) {
                    if (findPositionOffset(i4, i2 + 1) == i) {
                        return true;
                    }
                    i4++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    public void consumePostponedUpdates() {
        int size = this.mPostponedList.size();
        for (int i = 0; i < size; i++) {
            ((RecyclerView.AnonymousClass6) this.mCallback).dispatchUpdate(this.mPostponedList.get(i));
        }
        recycleUpdateOpsAndClearList(this.mPostponedList);
        this.mExistingUpdateTypes = 0;
    }

    public void consumeUpdatesInOnePass() {
        consumePostponedUpdates();
        int size = this.mPendingUpdates.size();
        for (int i = 0; i < size; i++) {
            UpdateOp updateOp = this.mPendingUpdates.get(i);
            int i2 = updateOp.cmd;
            if (i2 == 1) {
                ((RecyclerView.AnonymousClass6) this.mCallback).dispatchUpdate(updateOp);
                RecyclerView.AnonymousClass6 r4 = (RecyclerView.AnonymousClass6) this.mCallback;
                RecyclerView.this.offsetPositionRecordsForInsert(updateOp.positionStart, updateOp.itemCount);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            } else if (i2 == 2) {
                ((RecyclerView.AnonymousClass6) this.mCallback).dispatchUpdate(updateOp);
                Callback callback = this.mCallback;
                int i3 = updateOp.positionStart;
                int i4 = updateOp.itemCount;
                RecyclerView.AnonymousClass6 r42 = (RecyclerView.AnonymousClass6) callback;
                RecyclerView.this.offsetPositionRecordsForRemove(i3, i4, true);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mItemsAddedOrRemoved = true;
                recyclerView.mState.mDeletedInvisibleItemCountSincePreviousLayout += i4;
            } else if (i2 == 4) {
                ((RecyclerView.AnonymousClass6) this.mCallback).dispatchUpdate(updateOp);
                ((RecyclerView.AnonymousClass6) this.mCallback).markViewHoldersUpdated(updateOp.positionStart, updateOp.itemCount, updateOp.payload);
            } else if (i2 == 8) {
                ((RecyclerView.AnonymousClass6) this.mCallback).dispatchUpdate(updateOp);
                RecyclerView.AnonymousClass6 r43 = (RecyclerView.AnonymousClass6) this.mCallback;
                RecyclerView.this.offsetPositionRecordsForMove(updateOp.positionStart, updateOp.itemCount);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }
        }
        recycleUpdateOpsAndClearList(this.mPendingUpdates);
        this.mExistingUpdateTypes = 0;
    }

    public final void dispatchAndUpdateViewHolders(UpdateOp updateOp) {
        int i;
        int i2 = updateOp.cmd;
        if (i2 == 1 || i2 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int updatePositionWithPostponed = updatePositionWithPostponed(updateOp.positionStart, i2);
        int i3 = updateOp.positionStart;
        int i4 = updateOp.cmd;
        if (i4 == 2) {
            i = 0;
        } else if (i4 == 4) {
            i = 1;
        } else {
            throw new IllegalArgumentException("op should be remove or update." + updateOp);
        }
        int i5 = 1;
        for (int i6 = 1; i6 < updateOp.itemCount; i6++) {
            int updatePositionWithPostponed2 = updatePositionWithPostponed((i * i6) + updateOp.positionStart, updateOp.cmd);
            int i7 = updateOp.cmd;
            if (i7 == 2 ? updatePositionWithPostponed2 == updatePositionWithPostponed : i7 == 4 && updatePositionWithPostponed2 == updatePositionWithPostponed + 1) {
                i5++;
            } else {
                UpdateOp obtainUpdateOp = obtainUpdateOp(updateOp.cmd, updatePositionWithPostponed, i5, updateOp.payload);
                dispatchFirstPassAndUpdateViewHolders(obtainUpdateOp, i3);
                if (!this.mDisableRecycler) {
                    obtainUpdateOp.payload = null;
                    this.mUpdateOpPool.release(obtainUpdateOp);
                }
                if (updateOp.cmd == 4) {
                    i3 += i5;
                }
                i5 = 1;
                updatePositionWithPostponed = updatePositionWithPostponed2;
            }
        }
        Object obj = updateOp.payload;
        if (!this.mDisableRecycler) {
            updateOp.payload = null;
            this.mUpdateOpPool.release(updateOp);
        }
        if (i5 > 0) {
            UpdateOp obtainUpdateOp2 = obtainUpdateOp(updateOp.cmd, updatePositionWithPostponed, i5, obj);
            dispatchFirstPassAndUpdateViewHolders(obtainUpdateOp2, i3);
            if (!this.mDisableRecycler) {
                obtainUpdateOp2.payload = null;
                this.mUpdateOpPool.release(obtainUpdateOp2);
            }
        }
    }

    public void dispatchFirstPassAndUpdateViewHolders(UpdateOp updateOp, int i) {
        ((RecyclerView.AnonymousClass6) this.mCallback).dispatchUpdate(updateOp);
        int i2 = updateOp.cmd;
        if (i2 == 2) {
            Callback callback = this.mCallback;
            int i3 = updateOp.itemCount;
            RecyclerView.AnonymousClass6 r0 = (RecyclerView.AnonymousClass6) callback;
            RecyclerView.this.offsetPositionRecordsForRemove(i, i3, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mItemsAddedOrRemoved = true;
            recyclerView.mState.mDeletedInvisibleItemCountSincePreviousLayout += i3;
        } else if (i2 == 4) {
            RecyclerView.AnonymousClass6 r02 = (RecyclerView.AnonymousClass6) this.mCallback;
            RecyclerView.this.viewRangeUpdate(i, updateOp.itemCount, updateOp.payload);
            RecyclerView.this.mItemsChanged = true;
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    public int findPositionOffset(int i, int i2) {
        int size = this.mPostponedList.size();
        while (i2 < size) {
            UpdateOp updateOp = this.mPostponedList.get(i2);
            int i3 = updateOp.cmd;
            if (i3 == 8) {
                int i4 = updateOp.positionStart;
                if (i4 == i) {
                    i = updateOp.itemCount;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (updateOp.itemCount <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = updateOp.positionStart;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = updateOp.itemCount;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += updateOp.itemCount;
                }
            }
            i2++;
        }
        return i;
    }

    public boolean hasPendingUpdates() {
        return this.mPendingUpdates.size() > 0;
    }

    public UpdateOp obtainUpdateOp(int i, int i2, int i3, Object obj) {
        UpdateOp acquire = this.mUpdateOpPool.acquire();
        if (acquire == null) {
            return new UpdateOp(i, i2, i3, obj);
        }
        acquire.cmd = i;
        acquire.positionStart = i2;
        acquire.itemCount = i3;
        acquire.payload = obj;
        return acquire;
    }

    public final void postponeAndUpdateViewHolders(UpdateOp updateOp) {
        this.mPostponedList.add(updateOp);
        int i = updateOp.cmd;
        if (i == 1) {
            Callback callback = this.mCallback;
            RecyclerView.AnonymousClass6 r0 = (RecyclerView.AnonymousClass6) callback;
            RecyclerView.this.offsetPositionRecordsForInsert(updateOp.positionStart, updateOp.itemCount);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        } else if (i == 2) {
            Callback callback2 = this.mCallback;
            RecyclerView.AnonymousClass6 r02 = (RecyclerView.AnonymousClass6) callback2;
            RecyclerView.this.offsetPositionRecordsForRemove(updateOp.positionStart, updateOp.itemCount, false);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        } else if (i == 4) {
            ((RecyclerView.AnonymousClass6) this.mCallback).markViewHoldersUpdated(updateOp.positionStart, updateOp.itemCount, updateOp.payload);
        } else if (i == 8) {
            Callback callback3 = this.mCallback;
            RecyclerView.AnonymousClass6 r03 = (RecyclerView.AnonymousClass6) callback3;
            RecyclerView.this.offsetPositionRecordsForMove(updateOp.positionStart, updateOp.itemCount);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + updateOp);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:189:0x0009 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0142  */
    public void preProcess() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        int i2;
        int i3;
        int i4;
        UpdateOp updateOp;
        UpdateOp updateOp2;
        int i5;
        int i6;
        UpdateOp updateOp3;
        OpReorderer opReorderer = this.mOpReorderer;
        ArrayList<UpdateOp> arrayList = this.mPendingUpdates;
        if (opReorderer != null) {
            while (true) {
                int size = arrayList.size() - 1;
                boolean z5 = false;
                while (true) {
                    if (size < 0) {
                        size = -1;
                        break;
                    }
                    if (arrayList.get(size).cmd != 8) {
                        z5 = true;
                    } else if (z5) {
                        break;
                    }
                    size--;
                }
                if (size == -1) {
                    break;
                }
                int i7 = size + 1;
                UpdateOp updateOp4 = arrayList.get(size);
                UpdateOp updateOp5 = arrayList.get(i7);
                int i8 = updateOp5.cmd;
                if (i8 == 1) {
                    int i9 = updateOp4.itemCount < updateOp5.positionStart ? -1 : 0;
                    if (updateOp4.positionStart < updateOp5.positionStart) {
                        i9++;
                    }
                    int i10 = updateOp5.positionStart;
                    int i11 = updateOp4.positionStart;
                    if (i10 <= i11) {
                        updateOp4.positionStart = i11 + updateOp5.itemCount;
                    }
                    int i12 = updateOp5.positionStart;
                    int i13 = updateOp4.itemCount;
                    if (i12 <= i13) {
                        updateOp4.itemCount = i13 + updateOp5.itemCount;
                    }
                    updateOp5.positionStart += i9;
                    arrayList.set(size, updateOp5);
                    arrayList.set(i7, updateOp4);
                } else if (i8 == 2) {
                    int i14 = updateOp4.positionStart;
                    int i15 = updateOp4.itemCount;
                    if (i14 < i15) {
                        if (updateOp5.positionStart == i14 && updateOp5.itemCount == i15 - i14) {
                            z4 = true;
                            z3 = false;
                            i = updateOp4.itemCount;
                            i2 = updateOp5.positionStart;
                            if (i < i2) {
                                updateOp5.positionStart = i2 - 1;
                            } else {
                                int i16 = updateOp5.itemCount;
                                if (i < i2 + i16) {
                                    updateOp5.itemCount = i16 - 1;
                                    updateOp4.cmd = 2;
                                    updateOp4.itemCount = 1;
                                    if (updateOp5.itemCount == 0) {
                                        arrayList.remove(i7);
                                        AdapterHelper adapterHelper = (AdapterHelper) opReorderer.mCallback;
                                        if (!adapterHelper.mDisableRecycler) {
                                            updateOp5.payload = null;
                                            adapterHelper.mUpdateOpPool.release(updateOp5);
                                        }
                                    }
                                }
                            }
                            i3 = updateOp4.positionStart;
                            i4 = updateOp5.positionStart;
                            if (i3 <= i4) {
                                updateOp5.positionStart = i4 + 1;
                            } else {
                                int i17 = i4 + updateOp5.itemCount;
                                if (i3 < i17) {
                                    updateOp = ((AdapterHelper) opReorderer.mCallback).obtainUpdateOp(2, i3 + 1, i17 - i3, null);
                                    updateOp5.itemCount = updateOp4.positionStart - updateOp5.positionStart;
                                    if (!z4) {
                                        arrayList.set(size, updateOp5);
                                        arrayList.remove(i7);
                                        AdapterHelper adapterHelper2 = (AdapterHelper) opReorderer.mCallback;
                                        if (!adapterHelper2.mDisableRecycler) {
                                            updateOp4.payload = null;
                                            adapterHelper2.mUpdateOpPool.release(updateOp4);
                                        }
                                    } else {
                                        if (z3) {
                                            if (updateOp != null) {
                                                int i18 = updateOp4.positionStart;
                                                if (i18 > updateOp.positionStart) {
                                                    updateOp4.positionStart = i18 - updateOp.itemCount;
                                                }
                                                int i19 = updateOp4.itemCount;
                                                if (i19 > updateOp.positionStart) {
                                                    updateOp4.itemCount = i19 - updateOp.itemCount;
                                                }
                                            }
                                            int i20 = updateOp4.positionStart;
                                            if (i20 > updateOp5.positionStart) {
                                                updateOp4.positionStart = i20 - updateOp5.itemCount;
                                            }
                                            int i21 = updateOp4.itemCount;
                                            if (i21 > updateOp5.positionStart) {
                                                updateOp4.itemCount = i21 - updateOp5.itemCount;
                                            }
                                        } else {
                                            if (updateOp != null) {
                                                int i22 = updateOp4.positionStart;
                                                if (i22 >= updateOp.positionStart) {
                                                    updateOp4.positionStart = i22 - updateOp.itemCount;
                                                }
                                                int i23 = updateOp4.itemCount;
                                                if (i23 >= updateOp.positionStart) {
                                                    updateOp4.itemCount = i23 - updateOp.itemCount;
                                                }
                                            }
                                            int i24 = updateOp4.positionStart;
                                            if (i24 >= updateOp5.positionStart) {
                                                updateOp4.positionStart = i24 - updateOp5.itemCount;
                                            }
                                            int i25 = updateOp4.itemCount;
                                            if (i25 >= updateOp5.positionStart) {
                                                updateOp4.itemCount = i25 - updateOp5.itemCount;
                                            }
                                        }
                                        arrayList.set(size, updateOp5);
                                        if (updateOp4.positionStart != updateOp4.itemCount) {
                                            arrayList.set(i7, updateOp4);
                                        } else {
                                            arrayList.remove(i7);
                                        }
                                        if (updateOp != null) {
                                            arrayList.add(size, updateOp);
                                        }
                                    }
                                }
                            }
                            updateOp = null;
                            if (!z4) {
                            }
                        } else {
                            z4 = false;
                        }
                    } else if (updateOp5.positionStart == i15 + 1 && updateOp5.itemCount == i14 - i15) {
                        z4 = true;
                    } else {
                        z3 = true;
                        z4 = false;
                        i = updateOp4.itemCount;
                        i2 = updateOp5.positionStart;
                        if (i < i2) {
                        }
                        i3 = updateOp4.positionStart;
                        i4 = updateOp5.positionStart;
                        if (i3 <= i4) {
                        }
                        updateOp = null;
                        if (!z4) {
                        }
                    }
                    z3 = z4;
                    i = updateOp4.itemCount;
                    i2 = updateOp5.positionStart;
                    if (i < i2) {
                    }
                    i3 = updateOp4.positionStart;
                    i4 = updateOp5.positionStart;
                    if (i3 <= i4) {
                    }
                    updateOp = null;
                    if (!z4) {
                    }
                } else if (i8 == 4) {
                    int i26 = updateOp4.itemCount;
                    int i27 = updateOp5.positionStart;
                    if (i26 < i27) {
                        updateOp5.positionStart = i27 - 1;
                    } else {
                        int i28 = updateOp5.itemCount;
                        if (i26 < i27 + i28) {
                            updateOp5.itemCount = i28 - 1;
                            updateOp2 = ((AdapterHelper) opReorderer.mCallback).obtainUpdateOp(4, updateOp4.positionStart, 1, updateOp5.payload);
                            i5 = updateOp4.positionStart;
                            i6 = updateOp5.positionStart;
                            if (i5 > i6) {
                                updateOp5.positionStart = i6 + 1;
                            } else {
                                int i29 = i6 + updateOp5.itemCount;
                                if (i5 < i29) {
                                    int i30 = i29 - i5;
                                    updateOp3 = ((AdapterHelper) opReorderer.mCallback).obtainUpdateOp(4, i5 + 1, i30, updateOp5.payload);
                                    updateOp5.itemCount -= i30;
                                    arrayList.set(i7, updateOp4);
                                    if (updateOp5.itemCount > 0) {
                                        arrayList.set(size, updateOp5);
                                    } else {
                                        arrayList.remove(size);
                                        AdapterHelper adapterHelper3 = (AdapterHelper) opReorderer.mCallback;
                                        if (!adapterHelper3.mDisableRecycler) {
                                            updateOp5.payload = null;
                                            adapterHelper3.mUpdateOpPool.release(updateOp5);
                                        }
                                    }
                                    if (updateOp2 != null) {
                                        arrayList.add(size, updateOp2);
                                    }
                                    if (updateOp3 != null) {
                                        arrayList.add(size, updateOp3);
                                    }
                                }
                            }
                            updateOp3 = null;
                            arrayList.set(i7, updateOp4);
                            if (updateOp5.itemCount > 0) {
                            }
                            if (updateOp2 != null) {
                            }
                            if (updateOp3 != null) {
                            }
                        }
                    }
                    updateOp2 = null;
                    i5 = updateOp4.positionStart;
                    i6 = updateOp5.positionStart;
                    if (i5 > i6) {
                    }
                    updateOp3 = null;
                    arrayList.set(i7, updateOp4);
                    if (updateOp5.itemCount > 0) {
                    }
                    if (updateOp2 != null) {
                    }
                    if (updateOp3 != null) {
                    }
                }
            }
            int size2 = this.mPendingUpdates.size();
            for (int i31 = 0; i31 < size2; i31++) {
                UpdateOp updateOp6 = this.mPendingUpdates.get(i31);
                int i32 = updateOp6.cmd;
                if (i32 == 1) {
                    postponeAndUpdateViewHolders(updateOp6);
                } else if (i32 == 2) {
                    int i33 = updateOp6.positionStart;
                    int i34 = updateOp6.itemCount + i33;
                    int i35 = i33;
                    boolean z6 = true;
                    int i36 = 0;
                    while (i35 < i34) {
                        if (((RecyclerView.AnonymousClass6) this.mCallback).findViewHolder(i35) != null || canFindInPreLayout(i35)) {
                            if (!z6) {
                                dispatchAndUpdateViewHolders(obtainUpdateOp(2, i33, i36, null));
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            z = true;
                        } else {
                            if (z6) {
                                postponeAndUpdateViewHolders(obtainUpdateOp(2, i33, i36, null));
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            z = false;
                        }
                        if (z2) {
                            i35 -= i36;
                            i34 -= i36;
                            i36 = 1;
                        } else {
                            i36++;
                        }
                        i35++;
                        z6 = z;
                    }
                    if (i36 != updateOp6.itemCount) {
                        if (!this.mDisableRecycler) {
                            updateOp6.payload = null;
                            this.mUpdateOpPool.release(updateOp6);
                        }
                        updateOp6 = obtainUpdateOp(2, i33, i36, null);
                    }
                    if (!z6) {
                        dispatchAndUpdateViewHolders(updateOp6);
                    } else {
                        postponeAndUpdateViewHolders(updateOp6);
                    }
                } else if (i32 == 4) {
                    int i37 = updateOp6.positionStart;
                    int i38 = updateOp6.itemCount + i37;
                    boolean z7 = true;
                    int i39 = i37;
                    int i40 = 0;
                    while (i37 < i38) {
                        if (((RecyclerView.AnonymousClass6) this.mCallback).findViewHolder(i37) != null || canFindInPreLayout(i37)) {
                            if (!z7) {
                                dispatchAndUpdateViewHolders(obtainUpdateOp(4, i39, i40, updateOp6.payload));
                                i39 = i37;
                                i40 = 0;
                            }
                            z7 = true;
                        } else {
                            if (z7) {
                                postponeAndUpdateViewHolders(obtainUpdateOp(4, i39, i40, updateOp6.payload));
                                i39 = i37;
                                i40 = 0;
                            }
                            z7 = false;
                        }
                        i40++;
                        i37++;
                    }
                    if (i40 != updateOp6.itemCount) {
                        Object obj = updateOp6.payload;
                        if (!this.mDisableRecycler) {
                            updateOp6.payload = null;
                            this.mUpdateOpPool.release(updateOp6);
                        }
                        updateOp6 = obtainUpdateOp(4, i39, i40, obj);
                    }
                    if (!z7) {
                        dispatchAndUpdateViewHolders(updateOp6);
                    } else {
                        postponeAndUpdateViewHolders(updateOp6);
                    }
                } else if (i32 == 8) {
                    postponeAndUpdateViewHolders(updateOp6);
                }
            }
            this.mPendingUpdates.clear();
            return;
        }
        throw null;
    }

    public void recycleUpdateOp(UpdateOp updateOp) {
        if (!this.mDisableRecycler) {
            updateOp.payload = null;
            this.mUpdateOpPool.release(updateOp);
        }
    }

    public void recycleUpdateOpsAndClearList(List<UpdateOp> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            recycleUpdateOp(list.get(i));
        }
        list.clear();
    }

    public final int updatePositionWithPostponed(int i, int i2) {
        for (int size = this.mPostponedList.size() - 1; size >= 0; size--) {
            UpdateOp updateOp = this.mPostponedList.get(size);
            int i3 = updateOp.cmd;
            if (i3 == 8) {
                int i4 = updateOp.positionStart;
                int i5 = updateOp.itemCount;
                if (i4 >= i5) {
                    i5 = i4;
                    i4 = i5;
                }
                if (i < i4 || i > i5) {
                    int i6 = updateOp.positionStart;
                    if (i < i6) {
                        if (i2 == 1) {
                            updateOp.positionStart = i6 + 1;
                            updateOp.itemCount++;
                        } else if (i2 == 2) {
                            updateOp.positionStart = i6 - 1;
                            updateOp.itemCount--;
                        }
                    }
                } else {
                    int i7 = updateOp.positionStart;
                    if (i4 == i7) {
                        if (i2 == 1) {
                            updateOp.itemCount++;
                        } else if (i2 == 2) {
                            updateOp.itemCount--;
                        }
                        i++;
                    } else {
                        if (i2 == 1) {
                            updateOp.positionStart = i7 + 1;
                        } else if (i2 == 2) {
                            updateOp.positionStart = i7 - 1;
                        }
                        i--;
                    }
                }
            } else {
                int i8 = updateOp.positionStart;
                if (i8 <= i) {
                    if (i3 == 1) {
                        i -= updateOp.itemCount;
                    } else if (i3 == 2) {
                        i += updateOp.itemCount;
                    }
                } else if (i2 == 1) {
                    updateOp.positionStart = i8 + 1;
                } else if (i2 == 2) {
                    updateOp.positionStart = i8 - 1;
                }
            }
        }
        for (int size2 = this.mPostponedList.size() - 1; size2 >= 0; size2--) {
            UpdateOp updateOp2 = this.mPostponedList.get(size2);
            if (updateOp2.cmd == 8) {
                int i9 = updateOp2.itemCount;
                if (i9 == updateOp2.positionStart || i9 < 0) {
                    this.mPostponedList.remove(size2);
                    if (!this.mDisableRecycler) {
                        updateOp2.payload = null;
                        this.mUpdateOpPool.release(updateOp2);
                    }
                }
            } else if (updateOp2.itemCount <= 0) {
                this.mPostponedList.remove(size2);
                if (!this.mDisableRecycler) {
                    updateOp2.payload = null;
                    this.mUpdateOpPool.release(updateOp2);
                }
            }
        }
        return i;
    }
}
