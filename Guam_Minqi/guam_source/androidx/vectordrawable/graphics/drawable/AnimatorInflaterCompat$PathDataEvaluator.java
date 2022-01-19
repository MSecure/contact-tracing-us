package androidx.vectordrawable.graphics.drawable;

import android.animation.TypeEvaluator;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.graphics.PathParser$PathDataNode;

public class AnimatorInflaterCompat$PathDataEvaluator implements TypeEvaluator<PathParser$PathDataNode[]> {
    public PathParser$PathDataNode[] mNodeArray;

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
    @Override // android.animation.TypeEvaluator
    public PathParser$PathDataNode[] evaluate(float f, PathParser$PathDataNode[] pathParser$PathDataNodeArr, PathParser$PathDataNode[] pathParser$PathDataNodeArr2) {
        PathParser$PathDataNode[] pathParser$PathDataNodeArr3 = pathParser$PathDataNodeArr;
        PathParser$PathDataNode[] pathParser$PathDataNodeArr4 = pathParser$PathDataNodeArr2;
        if (AppCompatDelegateImpl.ConfigurationImplApi17.canMorph(pathParser$PathDataNodeArr3, pathParser$PathDataNodeArr4)) {
            if (!AppCompatDelegateImpl.ConfigurationImplApi17.canMorph(this.mNodeArray, pathParser$PathDataNodeArr3)) {
                this.mNodeArray = AppCompatDelegateImpl.ConfigurationImplApi17.deepCopyNodes(pathParser$PathDataNodeArr3);
            }
            for (int i = 0; i < pathParser$PathDataNodeArr3.length; i++) {
                PathParser$PathDataNode pathParser$PathDataNode = this.mNodeArray[i];
                PathParser$PathDataNode pathParser$PathDataNode2 = pathParser$PathDataNodeArr3[i];
                PathParser$PathDataNode pathParser$PathDataNode3 = pathParser$PathDataNodeArr4[i];
                if (pathParser$PathDataNode != null) {
                    pathParser$PathDataNode.mType = pathParser$PathDataNode2.mType;
                    int i2 = 0;
                    while (true) {
                        float[] fArr = pathParser$PathDataNode2.mParams;
                        if (i2 >= fArr.length) {
                            break;
                        }
                        pathParser$PathDataNode.mParams[i2] = (pathParser$PathDataNode3.mParams[i2] * f) + ((1.0f - f) * fArr[i2]);
                        i2++;
                    }
                } else {
                    throw null;
                }
            }
            return this.mNodeArray;
        }
        throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
    }
}
