package org.netlib.lapack;

import org.netlib.blas.Sgemm;
import org.netlib.blas.Sscal;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Ssbevd
{
  public static void ssbevd(String paramString1, String paramString2, int paramInt1, int paramInt2, float[] paramArrayOfFloat1, int paramInt3, int paramInt4, float[] paramArrayOfFloat2, int paramInt5, float[] paramArrayOfFloat3, int paramInt6, int paramInt7, float[] paramArrayOfFloat4, int paramInt8, int paramInt9, int[] paramArrayOfInt, int paramInt10, int paramInt11, intW paramintW)
  {
    boolean bool1 = false;
    int i = 0;
    boolean bool2 = false;
    intW localintW = new intW(0);
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    float f1 = 0.0F;
    float f2 = 0.0F;
    float f3 = 0.0F;
    float f4 = 0.0F;
    float f5 = 0.0F;
    float f6 = 0.0F;
    float f7 = 0.0F;
    float f8 = 0.0F;
    bool2 = Lsame.lsame(paramString1, "V");
    bool1 = Lsame.lsame(paramString2, "L");
    if ((paramInt9 != -1 ? 0 : 1) == 0) {}
    i = (paramInt11 != -1 ? 0 : 1) == 0 ? 0 : 1;
    paramintW.val = 0;
    if ((paramInt1 > 1 ? 0 : 1) != 0)
    {
      i1 = 1;
      i3 = 1;
    }
    else if (bool2)
    {
      i1 = 3 + 5 * paramInt1;
      i3 = 1 + 5 * paramInt1 + 2 * (int)Math.pow(paramInt1, 2);
    }
    else
    {
      i1 = 1;
      i3 = 2 * paramInt1;
    }
    if ((((!bool2) && (!Lsame.lsame(paramString1, "N")) ? 0 : 1) ^ 0x1) != 0)
    {
      paramintW.val = -1;
    }
    else if ((((!bool1) && (!Lsame.lsame(paramString2, "U")) ? 0 : 1) ^ 0x1) != 0)
    {
      paramintW.val = -2;
    }
    else if ((paramInt1 >= 0 ? 0 : 1) != 0)
    {
      paramintW.val = -3;
    }
    else if ((paramInt2 >= 0 ? 0 : 1) != 0)
    {
      paramintW.val = -4;
    }
    else if ((paramInt4 >= paramInt2 + 1 ? 0 : 1) != 0)
    {
      paramintW.val = -6;
    }
    else
    {
      if ((paramInt7 >= 1 ? 0 : 1) == 0) {
        if (!bool2) {}
      }
      if ((((paramInt7 >= paramInt1 ? 0 : 1) != 0 ? 1 : 0) == 0 ? 0 : 1) != 0) {
        paramintW.val = -9;
      }
    }
    if ((paramintW.val != 0 ? 0 : 1) != 0)
    {
      paramArrayOfFloat4[(1 - 1 + paramInt8)] = i3;
      paramArrayOfInt[(1 - 1 + paramInt10)] = i1;
      if ((paramInt9 >= i3 ? 0 : 1) != 0) {}
      if (((i ^ 0x1) != 0 ? 1 : 0) != 0)
      {
        paramintW.val = -11;
      }
      else
      {
        if ((paramInt11 >= i1 ? 0 : 1) != 0) {}
        if (((i ^ 0x1) != 0 ? 1 : 0) != 0) {
          paramintW.val = -13;
        }
      }
    }
    if ((paramintW.val == 0 ? 0 : 1) != 0)
    {
      Xerbla.xerbla("SSBEVD", -paramintW.val);
      return;
    }
    if (i != 0) {
      return;
    }
    if ((paramInt1 != 0 ? 0 : 1) != 0) {
      return;
    }
    if ((paramInt1 != 1 ? 0 : 1) != 0)
    {
      paramArrayOfFloat2[(1 - 1 + paramInt5)] = paramArrayOfFloat1[(1 - 1 + (1 - 1) * paramInt4 + paramInt3)];
      if (bool2) {
        paramArrayOfFloat3[(1 - 1 + (1 - 1) * paramInt7 + paramInt6)] = 1.0F;
      }
      return;
    }
    f6 = Slamch.slamch("Safe minimum");
    f3 = Slamch.slamch("Precision");
    f8 = f6 / f3;
    f2 = 1.0F / f8;
    f5 = (float)Math.sqrt(f8);
    f4 = (float)Math.sqrt(f2);
    f1 = Slansb.slansb("M", paramString2, paramInt1, paramInt2, paramArrayOfFloat1, paramInt3, paramInt4, paramArrayOfFloat4, paramInt8);
    n = 0;
    if ((f1 <= 0.0F ? 0 : 1) != 0) {}
    if (((f1 >= f5 ? 0 : 1) != 0 ? 1 : 0) != 0)
    {
      n = 1;
      f7 = f5 / f1;
    }
    else if ((f1 <= f4 ? 0 : 1) != 0)
    {
      n = 1;
      f7 = f4 / f1;
    }
    if ((n != 1 ? 0 : 1) != 0) {
      if (bool1) {
        Slascl.slascl("B", paramInt2, paramInt2, 1.0F, f7, paramInt1, paramInt1, paramArrayOfFloat1, paramInt3, paramInt4, paramintW);
      } else {
        Slascl.slascl("Q", paramInt2, paramInt2, 1.0F, f7, paramInt1, paramInt1, paramArrayOfFloat1, paramInt3, paramInt4, paramintW);
      }
    }
    j = 1;
    m = j + paramInt1;
    k = m + paramInt1 * paramInt1;
    i2 = paramInt9 - k + 1;
    Ssbtrd.ssbtrd(paramString1, paramString2, paramInt1, paramInt2, paramArrayOfFloat1, paramInt3, paramInt4, paramArrayOfFloat2, paramInt5, paramArrayOfFloat4, j - 1 + paramInt8, paramArrayOfFloat3, paramInt6, paramInt7, paramArrayOfFloat4, m - 1 + paramInt8, localintW);
    if ((bool2 ^ true))
    {
      Ssterf.ssterf(paramInt1, paramArrayOfFloat2, paramInt5, paramArrayOfFloat4, j - 1 + paramInt8, paramintW);
    }
    else
    {
      Sstedc.sstedc("I", paramInt1, paramArrayOfFloat2, paramInt5, paramArrayOfFloat4, j - 1 + paramInt8, paramArrayOfFloat4, m - 1 + paramInt8, paramInt1, paramArrayOfFloat4, k - 1 + paramInt8, i2, paramArrayOfInt, paramInt10, paramInt11, paramintW);
      Sgemm.sgemm("N", "N", paramInt1, paramInt1, paramInt1, 1.0F, paramArrayOfFloat3, paramInt6, paramInt7, paramArrayOfFloat4, m - 1 + paramInt8, paramInt1, 0.0F, paramArrayOfFloat4, k - 1 + paramInt8, paramInt1);
      Slacpy.slacpy("A", paramInt1, paramInt1, paramArrayOfFloat4, k - 1 + paramInt8, paramInt1, paramArrayOfFloat3, paramInt6, paramInt7);
    }
    if ((n != 1 ? 0 : 1) != 0) {
      Sscal.sscal(paramInt1, 1.0F / f7, paramArrayOfFloat2, paramInt5, 1);
    }
    paramArrayOfFloat4[(1 - 1 + paramInt8)] = i3;
    paramArrayOfInt[(1 - 1 + paramInt10)] = i1;
  }
}


/* Location:              /Users/assaad/Downloads/arpack_combined_all/!/org/netlib/lapack/Ssbevd.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       0.7.1
 */