package org.netlib.lapack;

import org.netlib.blas.Strsm;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Strtrs
{
  public static void strtrs(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, float[] paramArrayOfFloat1, int paramInt3, int paramInt4, float[] paramArrayOfFloat2, int paramInt5, int paramInt6, intW paramintW)
  {
    boolean bool = false;
    paramintW.val = 0;
    bool = Lsame.lsame(paramString3, "N");
    if ((((Lsame.lsame(paramString1, "U") ^ true)) && ((Lsame.lsame(paramString1, "L") ^ true)) ? 1 : 0) != 0)
    {
      paramintW.val = -1;
    }
    else
    {
      if ((((Lsame.lsame(paramString2, "N") ^ true)) && ((Lsame.lsame(paramString2, "T") ^ true)) ? 1 : 0) != 0) {}
      if (((Lsame.lsame(paramString2, "C") ^ true) ? 1 : 0) != 0) {
        paramintW.val = -2;
      } else if ((((bool ^ true)) && ((Lsame.lsame(paramString3, "U") ^ true)) ? 1 : 0) != 0) {
        paramintW.val = -3;
      } else if ((paramInt1 >= 0 ? 0 : 1) != 0) {
        paramintW.val = -4;
      } else if ((paramInt2 >= 0 ? 0 : 1) != 0) {
        paramintW.val = -5;
      } else if ((paramInt4 >= Math.max(1, paramInt1) ? 0 : 1) != 0) {
        paramintW.val = -7;
      } else if ((paramInt6 >= Math.max(1, paramInt1) ? 0 : 1) != 0) {
        paramintW.val = -9;
      }
    }
    if ((paramintW.val == 0 ? 0 : 1) != 0)
    {
      Xerbla.xerbla("STRTRS", -paramintW.val);
      return;
    }
    if ((paramInt1 != 0 ? 0 : 1) != 0) {
      return;
    }
    if (bool)
    {
      paramintW.val = 1;
      for (int i = paramInt1 - 1 + 1; i > 0; i--)
      {
        if ((paramArrayOfFloat1[(paramintW.val - 1 + (paramintW.val - 1) * paramInt4 + paramInt3)] != 0.0F ? 0 : 1) != 0) {
          return;
        }
        paramintW.val += 1;
      }
    }
    paramintW.val = 0;
    Strsm.strsm("Left", paramString1, paramString2, paramString3, paramInt1, paramInt2, 1.0F, paramArrayOfFloat1, paramInt3, paramInt4, paramArrayOfFloat2, paramInt5, paramInt6);
  }
}


/* Location:              /Users/assaad/Downloads/arpack_combined_all/!/org/netlib/lapack/Strtrs.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       0.7.1
 */