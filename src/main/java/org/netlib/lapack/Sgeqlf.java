package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Sgeqlf
{
  public static void sgeqlf(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, int paramInt3, int paramInt4, float[] paramArrayOfFloat2, int paramInt5, float[] paramArrayOfFloat3, int paramInt6, int paramInt7, intW paramintW)
  {
    int i = 0;
    int j = 0;
    int k = 0;
    intW localintW = new intW(0);
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
    paramintW.val = 0;
    i = paramInt7 != -1 ? 0 : 1;
    if ((paramInt1 >= 0 ? 0 : 1) != 0) {
      paramintW.val = -1;
    } else if ((paramInt2 >= 0 ? 0 : 1) != 0) {
      paramintW.val = -2;
    } else if ((paramInt4 >= Math.max(1, paramInt1) ? 0 : 1) != 0) {
      paramintW.val = -4;
    }
    if ((paramintW.val != 0 ? 0 : 1) != 0)
    {
      n = Math.min(paramInt1, paramInt2);
      if ((n != 0 ? 0 : 1) != 0)
      {
        i4 = 1;
      }
      else
      {
        i6 = Ilaenv.ilaenv(1, "SGEQLF", " ", paramInt1, paramInt2, -1, -1);
        i4 = paramInt2 * i6;
      }
      paramArrayOfFloat3[(1 - 1 + paramInt6)] = i4;
      if ((paramInt7 >= Math.max(1, paramInt2) ? 0 : 1) != 0) {}
      if (((i ^ 0x1) != 0 ? 1 : 0) != 0) {
        paramintW.val = -7;
      }
    }
    if ((paramintW.val == 0 ? 0 : 1) != 0)
    {
      Xerbla.xerbla("SGEQLF", -paramintW.val);
      return;
    }
    if (i != 0) {
      return;
    }
    if ((n != 0 ? 0 : 1) != 0) {
      return;
    }
    i7 = 2;
    i9 = 1;
    m = paramInt2;
    if ((i6 <= 1 ? 0 : 1) != 0) {}
    if (((i6 >= n ? 0 : 1) != 0 ? 1 : 0) != 0)
    {
      i9 = Math.max(0, Ilaenv.ilaenv(3, "SGEQLF", " ", paramInt1, paramInt2, -1, -1));
      if ((i9 >= n ? 0 : 1) != 0)
      {
        i3 = paramInt2;
        m = i3 * i6;
        if ((paramInt7 >= m ? 0 : 1) != 0)
        {
          i6 = paramInt7 / i3;
          i7 = Math.max(2, Ilaenv.ilaenv(2, "SGEQLF", " ", paramInt1, paramInt2, -1, -1));
        }
      }
    }
    if ((i6 < i7 ? 0 : 1) != 0) {}
    if (((i6 >= n ? 0 : 1) != 0 ? 1 : 0) != 0) {}
    if (((i9 >= n ? 0 : 1) != 0 ? 1 : 0) != 0)
    {
      i1 = (n - i9 - 1) / i6 * i6;
      i2 = Math.min(n, i1 + i6);
      j = n - i2 + i1 + 1;
      for (int i10 = (n - i2 + 1 - (n - i2 + i1 + 1) + -i6) / -i6; i10 > 0; i10--)
      {
        k = Math.min(n - j + 1, i6);
        Sgeql2.sgeql2(paramInt1 - n + j + k - 1, k, paramArrayOfFloat1, 1 - 1 + (paramInt2 - n + j - 1) * paramInt4 + paramInt3, paramInt4, paramArrayOfFloat2, j - 1 + paramInt5, paramArrayOfFloat3, paramInt6, localintW);
        if ((paramInt2 - n + j <= 1 ? 0 : 1) != 0)
        {
          Slarft.slarft("Backward", "Columnwise", paramInt1 - n + j + k - 1, k, paramArrayOfFloat1, 1 - 1 + (paramInt2 - n + j - 1) * paramInt4 + paramInt3, paramInt4, paramArrayOfFloat2, j - 1 + paramInt5, paramArrayOfFloat3, paramInt6, i3);
          Slarfb.slarfb("Left", "Transpose", "Backward", "Columnwise", paramInt1 - n + j + k - 1, paramInt2 - n + j - 1, k, paramArrayOfFloat1, 1 - 1 + (paramInt2 - n + j - 1) * paramInt4 + paramInt3, paramInt4, paramArrayOfFloat3, paramInt6, i3, paramArrayOfFloat1, paramInt3, paramInt4, paramArrayOfFloat3, k + 1 - 1 + paramInt6, i3);
        }
        j += -i6;
      }
      i5 = paramInt1 - n + j + i6 - 1;
      i8 = paramInt2 - n + j + i6 - 1;
    }
    else
    {
      i5 = paramInt1;
      i8 = paramInt2;
    }
    if ((i5 <= 0 ? 0 : 1) != 0) {}
    if (((i8 <= 0 ? 0 : 1) != 0 ? 1 : 0) != 0) {
      Sgeql2.sgeql2(i5, i8, paramArrayOfFloat1, paramInt3, paramInt4, paramArrayOfFloat2, paramInt5, paramArrayOfFloat3, paramInt6, localintW);
    }
    paramArrayOfFloat3[(1 - 1 + paramInt6)] = m;
  }
}


/* Location:              /Users/assaad/Downloads/arpack_combined_all/!/org/netlib/lapack/Sgeqlf.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       0.7.1
 */