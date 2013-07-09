package com.example.sizecalculation.pojo;

import android.content.Context;
import java.util.Random;

public class Mosaic {
	public int[] MosaicBuff = null;
	public int[] MosaicBuffBak = null;
	public int MosaicCount = 0;
	public int MosaicMaxCount = 0;
	public Context mContext = null;

	public Mosaic(Context paramContext, int[] paramArrayOfInt) {
		this.mContext = paramContext;
		this.MosaicMaxCount = paramArrayOfInt.length;
		this.MosaicCount = this.MosaicMaxCount;
		this.MosaicBuff = new int[this.MosaicMaxCount];
		this.MosaicBuffBak = new int[this.MosaicMaxCount];
		for (int i = 0;; i++) {
			if (i >= this.MosaicMaxCount)
				return;
			this.MosaicBuff[i] = paramArrayOfInt[i];
			this.MosaicBuffBak[i] = paramArrayOfInt[i];
		}
	}

	private int UtilRandom(int paramInt1, int paramInt2) {
		return paramInt1 + Math.abs(new Random().nextInt())
				% (paramInt2 - paramInt1);
	}

	public int GetMosaicBuffData() {
		int i = UtilRandom(0, -1 + this.MosaicCount);
		int j = this.MosaicBuff[i];
		for (int k = i;; k++) {
			if (k >= -1 + this.MosaicCount) {
				this.MosaicCount = (-1 + this.MosaicCount);
				break;
			}
			this.MosaicBuff[k] = this.MosaicBuff[(k + 1)];
		}
		if (this.MosaicCount == 1) {
			j = this.MosaicBuff[0];
			for (int m = 0;; m++) {
				if (m >= this.MosaicMaxCount) {
					this.MosaicCount = this.MosaicMaxCount;
					return j;
				}
				this.MosaicBuff[m] = this.MosaicBuffBak[m];
			}
		}
		return j;
	}
}