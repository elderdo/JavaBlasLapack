package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dgelq2
{
  public static void dgelq2(int paramInt1, int paramInt2, double[] paramArrayOfDouble1, int paramInt3, int paramInt4, double[] paramArrayOfDouble2, int paramInt5, double[] paramArrayOfDouble3, int paramInt6, intW paramintW)
  {
    int i = 0;
    int j = 0;
    double d = 0.0D;
    paramintW.val = 0;
    if ((paramInt1 >= 0 ? 0 : 1) != 0) {
      paramintW.val = -1;
    } else if ((paramInt2 >= 0 ? 0 : 1) != 0) {
      paramintW.val = -2;
    } else if ((paramInt4 >= Math.max(1, paramInt1) ? 0 : 1) != 0) {
      paramintW.val = -4;
    }
    if ((paramintW.val == 0 ? 0 : 1) != 0)
    {
      Xerbla.xerbla("DGELQ2", -paramintW.val);
      return;
    }
    j = Math.min(paramInt1, paramInt2);
    i = 1;
    for (int k = j - 1 + 1; k > 0; k--)
    {
      dlarfg_adapter(paramInt2 - i + 1, paramArrayOfDouble1, i - 1 + (i - 1) * paramInt4 + paramInt3, paramArrayOfDouble1, i - 1 + (Math.min(i + 1, paramInt2) - 1) * paramInt4 + paramInt3, paramInt4, paramArrayOfDouble2, i - 1 + paramInt5);
      if ((i >= paramInt1 ? 0 : 1) != 0)
      {
        d = paramArrayOfDouble1[(i - 1 + (i - 1) * paramInt4 + paramInt3)];
        paramArrayOfDouble1[(i - 1 + (i - 1) * paramInt4 + paramInt3)] = 1.0D;
        Dlarf.dlarf("Right", paramInt1 - i, paramInt2 - i + 1, paramArrayOfDouble1, i - 1 + (i - 1) * paramInt4 + paramInt3, paramInt4, paramArrayOfDouble2[(i - 1 + paramInt5)], paramArrayOfDouble1, i + 1 - 1 + (i - 1) * paramInt4 + paramInt3, paramInt4, paramArrayOfDouble3, paramInt6);
        paramArrayOfDouble1[(i - 1 + (i - 1) * paramInt4 + paramInt3)] = d;
      }
      i += 1;
    }
  }
  
  private static void dlarfg_adapter(int paramInt1, double[] paramArrayOfDouble1, int paramInt2, double[] paramArrayOfDouble2, int paramInt3, int paramInt4, double[] paramArrayOfDouble3, int paramInt5)
  {
    doubleW localdoubleW1 = new doubleW(paramArrayOfDouble1[paramInt2]);
    doubleW localdoubleW2 = new doubleW(paramArrayOfDouble3[paramInt5]);
    Dlarfg.dlarfg(paramInt1, localdoubleW1, paramArrayOfDouble2, paramInt3, paramInt4, localdoubleW2);
    paramArrayOfDouble1[paramInt2] = localdoubleW1.val;
    paramArrayOfDouble3[paramInt5] = localdoubleW2.val;
  }
}


/* Location:              /Users/assaad/Downloads/arpack_combined_all/!/org/netlib/lapack/Dgelq2.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       0.7.1
 */