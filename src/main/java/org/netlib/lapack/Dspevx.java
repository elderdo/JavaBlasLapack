package org.netlib.lapack;

import org.netlib.blas.Dcopy;
import org.netlib.blas.Dscal;
import org.netlib.blas.Dswap;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dspevx
{
  public static void dspevx(String paramString1, String paramString2, String paramString3, int paramInt1, double[] paramArrayOfDouble1, int paramInt2, double paramDouble1, double paramDouble2, int paramInt3, int paramInt4, double paramDouble3, intW paramintW1, double[] paramArrayOfDouble2, int paramInt5, double[] paramArrayOfDouble3, int paramInt6, int paramInt7, double[] paramArrayOfDouble4, int paramInt8, int[] paramArrayOfInt1, int paramInt9, int[] paramArrayOfInt2, int paramInt10, intW paramintW2)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    int i = 0;
    boolean bool3 = false;
    boolean bool4 = false;
    String str = new String(" ");
    int j = 0;
    intW localintW1 = new intW(0);
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i6 = 0;
    int i7 = 0;
    int i8 = 0;
    int i9 = 0;
    int i10 = 0;
    intW localintW2 = new intW(0);
    double d1 = 0.0D;
    double d2 = 0.0D;
    double d3 = 0.0D;
    double d4 = 0.0D;
    double d5 = 0.0D;
    double d6 = 0.0D;
    double d7 = 0.0D;
    double d8 = 0.0D;
    double d9 = 0.0D;
    double d10 = 0.0D;
    double d11 = 0.0D;
    double d12 = 0.0D;
    bool4 = Lsame.lsame(paramString1, "V");
    bool1 = Lsame.lsame(paramString2, "A");
    bool3 = Lsame.lsame(paramString2, "V");
    bool2 = Lsame.lsame(paramString2, "I");
    paramintW2.val = 0;
    if ((((!bool4) && (!Lsame.lsame(paramString1, "N")) ? 0 : 1) ^ 0x1) != 0)
    {
      paramintW2.val = -1;
    }
    else
    {
      if (((!bool1) && (!bool3) ? 0 : 1) == 0) {}
      if (((!bool2 ? 0 : 1) ^ 0x1) != 0)
      {
        paramintW2.val = -2;
      }
      else if ((((!Lsame.lsame(paramString3, "L")) && (!Lsame.lsame(paramString3, "U")) ? 0 : 1) ^ 0x1) != 0)
      {
        paramintW2.val = -3;
      }
      else if ((paramInt1 >= 0 ? 0 : 1) != 0)
      {
        paramintW2.val = -4;
      }
      else if (bool3)
      {
        if ((paramInt1 <= 0 ? 0 : 1) != 0) {}
        if (((paramDouble2 > paramDouble1 ? 0 : 1) != 0 ? 1 : 0) != 0) {
          paramintW2.val = -7;
        }
      }
      else if (bool2)
      {
        if ((paramInt3 >= 1 ? 0 : 1) == 0) {}
        if (((paramInt3 <= Math.max(1, paramInt1) ? 0 : 1) == 0 ? 0 : 1) != 0)
        {
          paramintW2.val = -8;
        }
        else
        {
          if ((paramInt4 >= Math.min(paramInt1, paramInt3) ? 0 : 1) == 0) {}
          if (((paramInt4 <= paramInt1 ? 0 : 1) == 0 ? 0 : 1) != 0) {
            paramintW2.val = -9;
          }
        }
      }
    }
    if ((paramintW2.val != 0 ? 0 : 1) != 0)
    {
      if ((paramInt7 >= 1 ? 0 : 1) == 0) {
        if (!bool4) {}
      }
      if ((((paramInt7 >= paramInt1 ? 0 : 1) != 0 ? 1 : 0) == 0 ? 0 : 1) != 0) {
        paramintW2.val = -14;
      }
    }
    if ((paramintW2.val == 0 ? 0 : 1) != 0)
    {
      Xerbla.xerbla("DSPEVX", -paramintW2.val);
      return;
    }
    paramintW1.val = 0;
    if ((paramInt1 != 0 ? 0 : 1) != 0) {
      return;
    }
    if ((paramInt1 != 1 ? 0 : 1) != 0)
    {
      if (((!bool1) && (!bool2) ? 0 : 1) != 0)
      {
        paramintW1.val = 1;
        paramArrayOfDouble2[(1 - 1 + paramInt5)] = paramArrayOfDouble1[(1 - 1 + paramInt2)];
      }
      else
      {
        if ((paramDouble1 >= paramArrayOfDouble1[(1 - 1 + paramInt2)] ? 0 : 1) != 0) {}
        if (((paramDouble2 < paramArrayOfDouble1[(1 - 1 + paramInt2)] ? 0 : 1) != 0 ? 1 : 0) != 0)
        {
          paramintW1.val = 1;
          paramArrayOfDouble2[(1 - 1 + paramInt5)] = paramArrayOfDouble1[(1 - 1 + paramInt2)];
        }
      }
      if (bool4) {
        paramArrayOfDouble3[(1 - 1 + (1 - 1) * paramInt7 + paramInt6)] = 1.0D;
      }
      return;
    }
    d7 = Dlamch.dlamch("Safe minimum");
    d4 = Dlamch.dlamch("Precision");
    d9 = d7 / d4;
    d3 = 1.0D / d9;
    d6 = Math.sqrt(d9);
    d5 = Math.min(Math.sqrt(d3), 1.0D / Math.sqrt(Math.sqrt(d7)));
    i7 = 0;
    d1 = paramDouble3;
    if (bool3)
    {
      d11 = paramDouble1;
      d12 = paramDouble2;
    }
    else
    {
      d11 = 0.0D;
      d12 = 0.0D;
    }
    d2 = Dlansp.dlansp("M", paramString3, paramInt1, paramArrayOfDouble1, paramInt2, paramArrayOfDouble4, paramInt8);
    if ((d2 <= 0.0D ? 0 : 1) != 0) {}
    if (((d2 >= d6 ? 0 : 1) != 0 ? 1 : 0) != 0)
    {
      i7 = 1;
      d8 = d6 / d2;
    }
    else if ((d2 <= d5 ? 0 : 1) != 0)
    {
      i7 = 1;
      d8 = d5 / d2;
    }
    if ((i7 != 1 ? 0 : 1) != 0)
    {
      Dscal.dscal(paramInt1 * (paramInt1 + 1) / 2, d8, paramArrayOfDouble1, paramInt2, 1);
      if ((paramDouble3 <= 0 ? 0 : 1) != 0) {
        d1 = paramDouble3 * d8;
      }
      if (bool3)
      {
        d11 = paramDouble1 * d8;
        d12 = paramDouble2 * d8;
      }
    }
    i5 = 1;
    n = i5 + paramInt1;
    m = n + paramInt1;
    i6 = m + paramInt1;
    Dsptrd.dsptrd(paramString3, paramInt1, paramArrayOfDouble1, paramInt2, paramArrayOfDouble4, m - 1 + paramInt8, paramArrayOfDouble4, n - 1 + paramInt8, paramArrayOfDouble4, i5 - 1 + paramInt8, localintW1);
    i = 0;
    if (bool2)
    {
      if ((paramInt3 != 1 ? 0 : 1) != 0) {}
      if (((paramInt4 != paramInt1 ? 0 : 1) != 0 ? 1 : 0) != 0) {
        i = 1;
      }
    }
    if (((!bool1) && (i == 0) ? 0 : 1) != 0) {}
    int i11;
    if (((paramDouble3 > 0.0D ? 0 : 1) != 0 ? 1 : 0) != 0)
    {
      Dcopy.dcopy(paramInt1, paramArrayOfDouble4, m - 1 + paramInt8, 1, paramArrayOfDouble2, paramInt5, 1);
      i1 = i6 + 2 * paramInt1;
      if ((bool4 ^ true))
      {
        Dcopy.dcopy(paramInt1 - 1, paramArrayOfDouble4, n - 1 + paramInt8, 1, paramArrayOfDouble4, i1 - 1 + paramInt8, 1);
        Dsterf.dsterf(paramInt1, paramArrayOfDouble2, paramInt5, paramArrayOfDouble4, i1 - 1 + paramInt8, paramintW2);
      }
      else
      {
        Dopgtr.dopgtr(paramString3, paramInt1, paramArrayOfDouble1, paramInt2, paramArrayOfDouble4, i5 - 1 + paramInt8, paramArrayOfDouble3, paramInt6, paramInt7, paramArrayOfDouble4, i6 - 1 + paramInt8, localintW1);
        Dcopy.dcopy(paramInt1 - 1, paramArrayOfDouble4, n - 1 + paramInt8, 1, paramArrayOfDouble4, i1 - 1 + paramInt8, 1);
        Dsteqr.dsteqr(paramString1, paramInt1, paramArrayOfDouble2, paramInt5, paramArrayOfDouble4, i1 - 1 + paramInt8, paramArrayOfDouble3, paramInt6, paramInt7, paramArrayOfDouble4, i6 - 1 + paramInt8, paramintW2);
        if ((paramintW2.val != 0 ? 0 : 1) != 0)
        {
          j = 1;
          for (i11 = paramInt1 - 1 + 1; i11 > 0; i11--)
          {
            paramArrayOfInt2[(j - 1 + paramInt10)] = 0;
            j += 1;
          }
        }
      }
      if ((paramintW2.val != 0 ? 0 : 1) != 0) {
        paramintW1.val = paramInt1;
      } else {
        paramintW2.val = 0;
      }
    }
    else
    {
      if (bool4) {
        str = "B";
      } else {
        str = "E";
      }
      i2 = 1;
      i3 = i2 + paramInt1;
      i4 = i3 + paramInt1;
      Dstebz.dstebz(paramString2, str, paramInt1, d11, d12, paramInt3, paramInt4, d1, paramArrayOfDouble4, m - 1 + paramInt8, paramArrayOfDouble4, n - 1 + paramInt8, paramintW1, localintW2, paramArrayOfDouble2, paramInt5, paramArrayOfInt1, i2 - 1 + paramInt9, paramArrayOfInt1, i3 - 1 + paramInt9, paramArrayOfDouble4, i6 - 1 + paramInt8, paramArrayOfInt1, i4 - 1 + paramInt9, paramintW2);
      if (bool4)
      {
        Dstein.dstein(paramInt1, paramArrayOfDouble4, m - 1 + paramInt8, paramArrayOfDouble4, n - 1 + paramInt8, paramintW1.val, paramArrayOfDouble2, paramInt5, paramArrayOfInt1, i2 - 1 + paramInt9, paramArrayOfInt1, i3 - 1 + paramInt9, paramArrayOfDouble3, paramInt6, paramInt7, paramArrayOfDouble4, i6 - 1 + paramInt8, paramArrayOfInt1, i4 - 1 + paramInt9, paramArrayOfInt2, paramInt10, paramintW2);
        Dopmtr.dopmtr("L", paramString3, "N", paramInt1, paramintW1.val, paramArrayOfDouble1, paramInt2, paramArrayOfDouble4, i5 - 1 + paramInt8, paramArrayOfDouble3, paramInt6, paramInt7, paramArrayOfDouble4, i6 - 1 + paramInt8, paramintW2);
      }
    }
    if ((i7 != 1 ? 0 : 1) != 0)
    {
      if ((paramintW2.val != 0 ? 0 : 1) != 0) {
        k = paramintW1.val;
      } else {
        k = paramintW2.val - 1;
      }
      Dscal.dscal(k, 1.0D / d8, paramArrayOfDouble2, paramInt5, 1);
    }
    if (bool4)
    {
      i9 = 1;
      for (i11 = paramintW1.val - 1 - 1 + 1; i11 > 0; i11--)
      {
        j = 0;
        d10 = paramArrayOfDouble2[(i9 - 1 + paramInt5)];
        i10 = i9 + 1;
        for (int i12 = paramintW1.val - (i9 + 1) + 1; i12 > 0; i12--)
        {
          if ((paramArrayOfDouble2[(i10 - 1 + paramInt5)] >= d10 ? 0 : 1) != 0)
          {
            j = i10;
            d10 = paramArrayOfDouble2[(i10 - 1 + paramInt5)];
          }
          i10 += 1;
        }
        if ((j == 0 ? 0 : 1) != 0)
        {
          i8 = paramArrayOfInt1[(i2 + j - 1 - 1 + paramInt9)];
          paramArrayOfDouble2[(j - 1 + paramInt5)] = paramArrayOfDouble2[(i9 - 1 + paramInt5)];
          paramArrayOfInt1[(i2 + j - 1 - 1 + paramInt9)] = paramArrayOfInt1[(i2 + i9 - 1 - 1 + paramInt9)];
          paramArrayOfDouble2[(i9 - 1 + paramInt5)] = d10;
          paramArrayOfInt1[(i2 + i9 - 1 - 1 + paramInt9)] = i8;
          Dswap.dswap(paramInt1, paramArrayOfDouble3, 1 - 1 + (j - 1) * paramInt7 + paramInt6, 1, paramArrayOfDouble3, 1 - 1 + (i9 - 1) * paramInt7 + paramInt6, 1);
          if ((paramintW2.val == 0 ? 0 : 1) != 0)
          {
            i8 = paramArrayOfInt2[(j - 1 + paramInt10)];
            paramArrayOfInt2[(j - 1 + paramInt10)] = paramArrayOfInt2[(i9 - 1 + paramInt10)];
            paramArrayOfInt2[(i9 - 1 + paramInt10)] = i8;
          }
        }
        i9 += 1;
      }
    }
  }
}


/* Location:              /Users/assaad/Downloads/arpack_combined_all/!/org/netlib/lapack/Dspevx.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       0.7.1
 */