package org.netlib.lapack;

import org.netlib.blas.Dnrm2;
import org.netlib.blas.Dswap;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dgeqp3
{
  public static void dgeqp3(int paramInt1, int paramInt2, double[] paramArrayOfDouble1, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5, double[] paramArrayOfDouble2, int paramInt6, double[] paramArrayOfDouble3, int paramInt7, int paramInt8, intW paramintW)
  {
    int i = 0;
    intW localintW = new intW(0);
    int j = 0;
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
    int i11 = 0;
    paramintW.val = 0;
    i = paramInt8 != -1 ? 0 : 1;
    if ((paramInt1 >= 0 ? 0 : 1) != 0) {
      paramintW.val = -1;
    } else if ((paramInt2 >= 0 ? 0 : 1) != 0) {
      paramintW.val = -2;
    } else if ((paramInt4 >= Math.max(1, paramInt1) ? 0 : 1) != 0) {
      paramintW.val = -4;
    }
    if ((paramintW.val != 0 ? 0 : 1) != 0)
    {
      i1 = Math.min(paramInt1, paramInt2);
      if ((i1 != 0 ? 0 : 1) != 0)
      {
        j = 1;
        n = 1;
      }
      else
      {
        j = 3 * paramInt2 + 1;
        i4 = Ilaenv.ilaenv(1, "DGEQRF", " ", paramInt1, paramInt2, -1, -1);
        n = 2 * paramInt2 + (paramInt2 + 1) * i4;
      }
      paramArrayOfDouble3[(1 - 1 + paramInt7)] = n;
      if ((paramInt8 >= j ? 0 : 1) != 0) {}
      if (((i ^ 0x1) != 0 ? 1 : 0) != 0) {
        paramintW.val = -8;
      }
    }
    if ((paramintW.val == 0 ? 0 : 1) != 0)
    {
      Xerbla.xerbla("DGEQP3", -paramintW.val);
      return;
    }
    if (i != 0) {
      return;
    }
    if ((i1 != 0 ? 0 : 1) != 0) {
      return;
    }
    i6 = 1;
    k = 1;
    for (int i12 = paramInt2 - 1 + 1; i12 > 0; i12--)
    {
      if ((paramArrayOfInt[(k - 1 + paramInt5)] == 0 ? 0 : 1) != 0)
      {
        if ((k == i6 ? 0 : 1) != 0)
        {
          Dswap.dswap(paramInt1, paramArrayOfDouble1, 1 - 1 + (k - 1) * paramInt4 + paramInt3, 1, paramArrayOfDouble1, 1 - 1 + (i6 - 1) * paramInt4 + paramInt3, 1);
          paramArrayOfInt[(k - 1 + paramInt5)] = paramArrayOfInt[(i6 - 1 + paramInt5)];
          paramArrayOfInt[(i6 - 1 + paramInt5)] = k;
        }
        else
        {
          paramArrayOfInt[(k - 1 + paramInt5)] = k;
        }
        i6 += 1;
      }
      else
      {
        paramArrayOfInt[(k - 1 + paramInt5)] = k;
      }
      k += 1;
    }
    i6 -= 1;
    if ((i6 <= 0 ? 0 : 1) != 0)
    {
      i3 = Math.min(paramInt1, i6);
      Dgeqrf.dgeqrf(paramInt1, i3, paramArrayOfDouble1, paramInt3, paramInt4, paramArrayOfDouble2, paramInt6, paramArrayOfDouble3, paramInt7, paramInt8, paramintW);
      j = Math.max(j, (int)paramArrayOfDouble3[(1 - 1 + paramInt7)]);
      if ((i3 >= paramInt2 ? 0 : 1) != 0)
      {
        Dormqr.dormqr("Left", "Transpose", paramInt1, paramInt2 - i3, i3, paramArrayOfDouble1, paramInt3, paramInt4, paramArrayOfDouble2, paramInt6, paramArrayOfDouble1, 1 - 1 + (i3 + 1 - 1) * paramInt4 + paramInt3, paramInt4, paramArrayOfDouble3, paramInt7, paramInt8, paramintW);
        j = Math.max(j, (int)paramArrayOfDouble3[(1 - 1 + paramInt7)]);
      }
    }
    if ((i6 >= i1 ? 0 : 1) != 0)
    {
      i8 = paramInt1 - i6;
      i10 = paramInt2 - i6;
      i9 = i1 - i6;
      i4 = Ilaenv.ilaenv(1, "DGEQRF", " ", i8, i10, -1, -1);
      i5 = 2;
      i7 = 0;
      if ((i4 <= 1 ? 0 : 1) != 0) {}
      if (((i4 >= i9 ? 0 : 1) != 0 ? 1 : 0) != 0)
      {
        i7 = Math.max(0, Ilaenv.ilaenv(3, "DGEQRF", " ", i8, i10, -1, -1));
        if ((i7 >= i9 ? 0 : 1) != 0)
        {
          i2 = 2 * i10 + (i10 + 1) * i4;
          j = Math.max(j, i2);
          if ((paramInt8 >= i2 ? 0 : 1) != 0)
          {
            i4 = (paramInt8 - 2 * i10) / (i10 + 1);
            i5 = Math.max(2, Ilaenv.ilaenv(2, "DGEQRF", " ", i8, i10, -1, -1));
          }
        }
      }
      k = i6 + 1;
      for (i12 = paramInt2 - (i6 + 1) + 1; i12 > 0; i12--)
      {
        paramArrayOfDouble3[(k - 1 + paramInt7)] = Dnrm2.dnrm2(i8, paramArrayOfDouble1, i6 + 1 - 1 + (k - 1) * paramInt4 + paramInt3, 1);
        paramArrayOfDouble3[(paramInt2 + k - 1 + paramInt7)] = paramArrayOfDouble3[(k - 1 + paramInt7)];
        k += 1;
      }
      if ((i4 < i5 ? 0 : 1) != 0) {}
      if (((i4 >= i9 ? 0 : 1) != 0 ? 1 : 0) != 0) {}
      if (((i7 >= i9 ? 0 : 1) != 0 ? 1 : 0) != 0)
      {
        k = i6 + 1;
        i11 = i1 - i7;
        while ((k > i11 ? 0 : 1) != 0)
        {
          m = Math.min(i4, i11 - k + 1);
          Dlaqps.dlaqps(paramInt1, paramInt2 - k + 1, k - 1, m, localintW, paramArrayOfDouble1, 1 - 1 + (k - 1) * paramInt4 + paramInt3, paramInt4, paramArrayOfInt, k - 1 + paramInt5, paramArrayOfDouble2, k - 1 + paramInt6, paramArrayOfDouble3, k - 1 + paramInt7, paramArrayOfDouble3, paramInt2 + k - 1 + paramInt7, paramArrayOfDouble3, 2 * paramInt2 + 1 - 1 + paramInt7, paramArrayOfDouble3, 2 * paramInt2 + m + 1 - 1 + paramInt7, paramInt2 - k + 1);
          k += localintW.val;
        }
      }
      else
      {
        k = i6 + 1;
      }
      if ((k > i1 ? 0 : 1) != 0) {
        Dlaqp2.dlaqp2(paramInt1, paramInt2 - k + 1, k - 1, paramArrayOfDouble1, 1 - 1 + (k - 1) * paramInt4 + paramInt3, paramInt4, paramArrayOfInt, k - 1 + paramInt5, paramArrayOfDouble2, k - 1 + paramInt6, paramArrayOfDouble3, k - 1 + paramInt7, paramArrayOfDouble3, paramInt2 + k - 1 + paramInt7, paramArrayOfDouble3, 2 * paramInt2 + 1 - 1 + paramInt7);
      }
    }
    paramArrayOfDouble3[(1 - 1 + paramInt7)] = j;
  }
}


/* Location:              /Users/assaad/Downloads/arpack_combined_all/!/org/netlib/lapack/Dgeqp3.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       0.7.1
 */