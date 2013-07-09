package com.example.sizecalculation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Random;
import java.util.UUID;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sizecalculation.pojo.Mosaic;

public class MainActivity extends Activity implements Runnable {
	private Context contexct = this;
	//ADD 加法 MUL乘法 DIV除法
	public static final int ADDSUB = 0;
	public static final int CLEAR_TOTELDATA = 3;
	public static final int DECSUB = 1;
	public static final int DISP_INPUTDATA = 4;
	public static final int DISP_INPUTDATAANDLINE = 5;
	public static final int DIVSUB = 3;
	//QUOTIENT 商 商数
	public static final int DIV_EASY_QUOTIENT = 22;
	public static final int DIV_EASY_QUOTIENT_ERROR = 23;
	public static final int DIV_EASY_QUOTIENT_TRUE = 24;
	//REMAINDER 余数
	public static final int DIV_EASY_REMAINDER = 29;
	public static final int DIV_EASY_REMAINDER_ERROR = 30;
	public static final int DIV_EASY_REMAINDER_TRUE = 31;
	public static final int DIV_EASY_TOTELDATA = 26;
	public static final int DIV_EASY_TOTELDATALINE = 25;
	public static final int DIV_EASY_TOTELDATA_ERROR = 27;
	public static final int DIV_EASY_TOTELDATA_TRUE = 28;
	public static final int DIV_HARD_QUOTIENT1 = 53;
	public static final int DIV_HARD_QUOTIENT1_ERROR = 54;
	public static final int DIV_HARD_QUOTIENT1_TRUE = 55;
	public static final int DIV_HARD_QUOTIENT2 = 64;
	public static final int DIV_HARD_QUOTIENT2_ERROR = 65;
	public static final int DIV_HARD_QUOTIENT2_TRUE = 66;
	public static final int DIV_HARD_QUOTIENT3 = 75;
	public static final int DIV_HARD_QUOTIENT3_ERROR = 76;
	public static final int DIV_HARD_QUOTIENT3_TRUE = 77;
	public static final int DIV_HARD_REMAINDER1 = 60;
	public static final int DIV_HARD_REMAINDER1_ERROR = 62;
	public static final int DIV_HARD_REMAINDER1_TRUE = 63;
	public static final int DIV_HARD_REMAINDER2 = 71;
	public static final int DIV_HARD_REMAINDER2_ERROR = 73;
	public static final int DIV_HARD_REMAINDER2_TRUE = 74;
	public static final int DIV_HARD_REMAINDER3 = 82;
	public static final int DIV_HARD_REMAINDER3_ERROR = 83;
	public static final int DIV_HARD_REMAINDER3_TRUE = 84;
	public static final int DIV_HARD_REMAINDERLINE1 = 61;
	public static final int DIV_HARD_REMAINDERLINE2 = 72;
	public static final int DIV_HARD_TOTELDATA1 = 57;
	public static final int DIV_HARD_TOTELDATA1_ERROR = 58;
	public static final int DIV_HARD_TOTELDATA1_TRUE = 59;
	public static final int DIV_HARD_TOTELDATA2 = 68;
	public static final int DIV_HARD_TOTELDATA2_ERROR = 69;
	public static final int DIV_HARD_TOTELDATA2_TRUE = 70;
	public static final int DIV_HARD_TOTELDATA3 = 79;
	public static final int DIV_HARD_TOTELDATA3_ERROR = 80;
	public static final int DIV_HARD_TOTELDATA3_TRUE = 81;
	public static final int DIV_HARD_TOTELDATALINE1 = 56;
	public static final int DIV_HARD_TOTELDATALINE3 = 78;
	public static final int DIV_HARD_TOTELTALINE2 = 67;
	public static final int DIV_NOR_REMAINDER1 = 40;
	public static final int DIV_NOR_REMAINDER1_ERROR = 41;
	public static final int DIV_NOR_REMAINDER1_TRUE = 42;
	public static final int DIV_NOR_REMAINDERLINE1 = 39;
	public static final int DIV_NOR_QUOTIENT1 = 32;
	public static final int DIV_NOR_QUOTIENT1_ERROR = 33;
	public static final int DIV_NOR_QUOTIENT1_TRUE = 34;
	public static final int DIV_NOR_QUOTIENT2 = 43;
	public static final int DIV_NOR_QUOTIENT2_ERROR = 44;
	public static final int DIV_NOR_QUOTIENT2_TRUE = 45;
	public static final int DIV_NOR_REMAINDER2 = 50;
	public static final int DIV_NOR_REMAINDER2_ERROR = 51;
	public static final int DIV_NOR_REMAINDER2_TRUE = 52;
	public static final int DIV_NOR_TOTELDATA1 = 36;
	public static final int DIV_NOR_TOTELDATA1_ERROR = 37;
	public static final int DIV_NOR_TOTELDATA1_TRUE = 38;
	public static final int DIV_NOR_TOTELDATA2 = 47;
	public static final int DIV_NOR_TOTELDATA2_ERROR = 48;
	public static final int DIV_NOR_TOTELDATA2_TRUE = 49;
	public static final int DIV_NOR_TOTELDATALINE1 = 35;
	public static final int DIV_NOR_TOTELDATALINE2 = 46;
	public static final int MULSUB = 2;
	public static final int MUL_INPUTDATA1 = 6;
	public static final int MUL_INPUTDATA1_ERROR = 8;
	public static final int MUL_INPUTDATA2 = 10;
	public static final int MUL_INPUTDATA2_ERROR = 12;
	public static final int MUL_INPUTDATA3 = 14;
	public static final int MUL_INPUTDATA3_ERROR = 16;
	public static final int MUL_INPUTDATALINE1 = 7;
	public static final int MUL_INPUTDATALINE2 = 11;
	public static final int MUL_INPUTDATALINE3 = 15;
	public static final int MUL_INPUTDATATATOTEL_GOOD = 21;
	public static final int MUL_INPUTDATATOTEL = 18;
	public static final int MUL_INPUTDATATOTELLINE = 19;
	public static final int MUL_INPUTDATATOTEL_ERROR = 20;
	public static final int MUL_SETPOSTDATA2 = 9;
	public static final int MUL_SETPOSTDATA3 = 13;
	public static final int MUL_SETPOSTTOTELDATA = 17;
	public static final int SEND_ERROR = 85;
	public static final int SETBUTTONLISTNSTER = 2;
	static final int StartHeight = 176;
	public static final int VALTOTEDATA_TRUE = 1;
	private static final int bgHeight = 1280;
	private static final int bgWeight = 960;
	int AddDataBak = 0;
	Integer[] ArithTabIds;
	final int BUTTON_MAX = 4;
	private boolean BackFlag = false;
	private int BitFlag0 = 0;
	public String DispStr1 = "";
	public String DispStr2 = "";
	int DivDataBak = 0;
	public int GetData = 0;
	boolean GetDataFlag = false;
	int Height0;
	int Height1;
	int Height2;
	int Height3;
	int Height4;
	int Height5;
	int Height6;
	int Height7;
	int Height8;
	int Height9;
	public ImageView ImageDiv = null;
	private int LevFlag = 0;
	// int MaxPx = 0;
	private int ModeFlag = 0;
	Mosaic MosaicEasy = null;
	Mosaic MosaicHard = null;
	Mosaic MosaicNor = null;
	int MulDataBak = 0;
	public boolean OnceFlag = false;
	private int OneData = 0;
	private boolean OpenAndCloseKeyFlag = false;
	private int QuotientData0 = 0;
	private int QuotientData1 = 0;
	private int QuotientData2 = 0;
	private int RemainderData0 = 0;
	private int RemainderData1 = 0;
	private int RemainderData2 = 0;
	int ScreenHeight;
	int ScreenWidth;
	private int ShowToastTimer = 0;
	int SubDataBak = 0;
	TextView SubSingle = null;
	public int SysDelayCount = 0;
	private int SysMegs = 0;
	private int SysThg = 0;
	private int SyskeyCode = 0;
	private int TwoData = 0;
	private int ValBit = 0;
	private int ValOneData = 0;
	private int ValThirdData = 0;
	private int ValTotelData = 0;
	private int ValTwoData = 0;
	public boolean ValidKeyCodeFlag = false;
	public boolean ValidSetFlag = false;
	int Width0;
	int Width1;
	int Width2;
	int Width3;
	int WordPx;
	private int callback_SysThg = 0;
	public Canvas canvas = null;
	private int currentHeight = 0;
	private int currentWeight = 0;
	private Field field = null;
	public GridView gridView = null;
	Handler handler;
	private Method hideMethod = null;
	ImageButton imageAddBtn = null;
	ImageButton imageBackBtn = null;
	ImageButton imageBtn0 = null;
	ImageButton imageBtn1 = null;
	ImageButton imageBtn2 = null;
	ImageButton imageBtn3 = null;
	ImageButton imageBtn4 = null;
	ImageButton imageBtn5 = null;
	ImageButton imageBtn6 = null;
	ImageButton imageBtn7 = null;
	ImageButton imageBtn8 = null;
	ImageButton imageBtn9 = null;
	ImageButton imageButtonDivSingle = null;
	ImageView imageButtonLine = null;
	ImageView imageButtonLine1 = null;
	ImageView imageButtonLine2 = null;
	ImageButton imageDecBtn = null;
	ImageButton imageDivBtn = null;
	ImageButton imageEasyBtn = null;
	ImageButton imageExit = null;
	ImageButton imageExitBtn = null;
	ImageButton imageHardBtn = null;
	ImageButton imageMulBtn = null;
	ImageButton imageNorBtn = null;
	public LinearLayout linearlayout6 = null;
	Context mContext = null;
	private boolean mIsRunning = false;
	private Thread mThread = null;
	public MediaPlayer mediaPlayer = null;
	public Message msg = null;
	private Object obj = null;
	Rect rect = new Rect();
	private Method showMethod = null;
	int size;
	private Toast toast = null;
	public TextView totelDataText = null;
	public TextView totelDataText1 = null;
	public TextView totelDataText2 = null;
	public TextView totelDataText3 = null;
	public TextView totelDataText4 = null;
	public TextView totelDataText5 = null;
	public TextView totelDataText6 = null;
	public ImageView viewLine1 = null;
	public ImageView viewLine2 = null;
	public ImageView viewLine3 = null;

	public MainActivity() {
		Integer[] arrayOfInteger = new Integer[8];
		arrayOfInteger[0] = Integer.valueOf(R.drawable.sizesp_006);
		arrayOfInteger[1] = Integer.valueOf(R.drawable.sizesp_007);
		arrayOfInteger[2] = Integer.valueOf(R.drawable.sizesp_008);
		arrayOfInteger[3] = Integer.valueOf(R.drawable.sizesp_009);
		arrayOfInteger[4] = Integer.valueOf(R.drawable.sizesp_010);
		arrayOfInteger[5] = Integer.valueOf(R.drawable.sizesp_011);
		arrayOfInteger[6] = Integer.valueOf(R.drawable.sizesp_012);
		arrayOfInteger[7] = Integer.valueOf(R.drawable.sizesp_013);
		this.ArithTabIds = arrayOfInteger;
		this.size = 0;
		this.Width0 = 0;
		this.Width1 = 0;
		this.Width2 = 0;
		this.Width3 = 0;
		this.Height0 = 0;
		this.Height1 = 0;
		this.Height2 = 0;
		this.Height3 = 0;
		this.Height4 = 0;
		this.Height5 = 0;
		this.Height6 = 0;
		this.Height7 = 0;
		this.Height8 = 0;
		this.Height9 = 0;
		this.handler = new MyHandler(this);
	}

	/**
	 * 取消光标处数字
	 * @param paramInt1
	 * @param paramInt2
	 * @return
	 */
	private int BackDataDec(int paramInt1, int paramInt2) {
		switch (this.BitFlag0) {
		case 0:
		case 1:
			this.DispStr1 = "";
			break;
		case 2:
			this.GetData %= 10;
		      this.DispStr1 = this.DispStr1.substring(1);
			break;
		case 3:
			this.GetData %= 100;
		      this.DispStr1 = this.DispStr1.substring(1);
			break;
		case 4:
			this.GetData %= 1000;
		      this.DispStr1 = this.DispStr1.substring(1);
			break;
		default:
			break;
		}
		return this.GetData;
	}


	private int RandomBool() {
		return 0x1 & Math.abs(new Random().nextInt());
	}

	public static int adjustFontSize(int paramInt1, int paramInt2) {
		int i;
		if (paramInt1 <= 240) {
			i = 66;
			return i;
		}
		if (paramInt1 <= 320) {
			i = 66;
			return i;
		}
		if (paramInt1 <= 480) {
			i = 78;
			return i;
		}
		if (paramInt1 <= 540) {
			i = 66;
			return i;
		}
		if (paramInt1 <= 800) {
			i = 66;
			return i;
		}
		i = 78;
		return i;
	}

	private void reflectionTN() {
		try {
			this.field = this.toast.getClass().getDeclaredField("mTN");
			this.field.setAccessible(true);
			this.obj = this.field.get(this.toast);
			this.showMethod = this.obj.getClass().getDeclaredMethod("show",
					null);
			this.hideMethod = this.obj.getClass().getDeclaredMethod("hide",
					null);
		} catch (Exception localException) {
			localException.printStackTrace();
		}
	}

	public void ArithmeticInit() {
		if(mediaPlayer!=null){
			if(mediaPlayer.isPlaying())ValidSetFlag = true;
		}
		switch (this.ModeFlag) {
		case ADDSUB:
			setContentView(R.layout.add);
			ProduceAdd();
			this.ValidKeyCodeFlag = false;
			break;
		case DECSUB:
			setContentView(R.layout.add);
			produceSub();
			this.ValidKeyCodeFlag = false;
			break;
		case MULSUB:
			produceMul();
			this.ValidKeyCodeFlag = false;
			break;
		case DIVSUB:
			produceDiv();
			this.ValidKeyCodeFlag = false;
			break;
		default:
			break;
		}
		InitGetlistneseImageButton();
		Init();
		SetImageButtonTouchPro();
		SetBackReBackListener();
	}

	public void CloseToast(int paramInt) {
		if ((this.field == null) || (this.ShowToastTimer >= paramInt))
			return;
		try {
			this.hideMethod.invoke(this.obj, null);
			this.field = null;
		} catch (Exception localException) {
			localException.printStackTrace();
		}
		this.ShowToastTimer = (1 + this.ShowToastTimer);
	}

	void DivEasyPro() {
		int i = ProduceSummandAndAddMosaic();
		int j = ProduceSummandAndAdd();
		int k = i * j;
		this.OneData = k;
		this.TwoData = j;
		this.ValTotelData = i;
		this.ValOneData = k;
		this.QuotientData0 = this.ValTotelData;
		this.RemainderData1 = 0;
		this.imageButtonDivSingle = ((ImageButton) findViewById(R.id.DivSignLong));
		this.rect.left = (424 * this.ScreenWidth / 960);
		this.rect.right = (2 + (536 * this.ScreenWidth / 960 - this.Width2));
		this.rect.top = (176 * this.ScreenHeight / 1280 + this.Height0);
		this.rect.bottom = (-2 + (1104 * this.ScreenHeight / 1280 - this.Height1));
		((ViewGroup.MarginLayoutParams) this.imageButtonDivSingle
				.getLayoutParams()).setMargins(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		TextView localTextView1 = (TextView) findViewById(R.id.DividendId);
		if (this.OneData < 10) {
			this.rect.left = 0;
			this.rect.right = (512 * this.ScreenWidth / 960 - this.Width0);
			this.rect.top = (8 + (176 * this.ScreenHeight / 1280 + this.Height0));
			this.rect.bottom = (-8 + (1104 * this.ScreenHeight / 1280 - this.Height1));
			localTextView1.setPadding(this.rect.left, this.rect.top,
					this.rect.right, this.rect.bottom);
		} else {
			this.rect.left = 0;
			this.rect.right = (512 * this.ScreenWidth / 960 - this.Width1);
			this.rect.top = (8 + (176 * this.ScreenHeight / 1280 + this.Height0));
			this.rect.bottom = (-8 + (1104 * this.ScreenHeight / 1280 - this.Height1));
			localTextView1.setPadding(this.rect.left, this.rect.top,
					this.rect.right, this.rect.bottom);
		}
		localTextView1.setTextSize(0, this.WordPx);
		localTextView1.setText(this.OneData + "");

		TextView localTextView2 = (TextView) findViewById(R.id.DivsorId);
		this.rect.left = 0;
		this.rect.right = (544 * this.ScreenWidth / 960);
		this.rect.top = (8 + (176 * this.ScreenHeight / 1280 + this.Height0));
		this.rect.bottom = (-8 + (1104 * this.ScreenHeight / 1280 - this.Height1));
		localTextView2.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		localTextView2.setTextSize(0, this.WordPx);
		localTextView2.setText(this.TwoData + "");
		this.totelDataText = ((TextView) findViewById(R.id.QuotientId));
		if (this.OneData >= 10) {
			this.rect.left = 0;
			this.rect.right = (512 * this.ScreenWidth / 960 - this.Width1);
			this.rect.top = (176 * this.ScreenHeight / 1280);
			this.rect.bottom = (1104 * this.ScreenHeight / 1280 - this.Height0);
			this.totelDataText.setPadding(this.rect.left, this.rect.top,
					this.rect.right, this.rect.bottom);
			this.totelDataText.setTextSize(0, this.WordPx);
			this.totelDataText.setText("_");
		} else {
			this.rect.left = 0;
			this.rect.right = (512 * this.ScreenWidth / 960 - this.Width0);
			this.rect.top = (176 * this.ScreenHeight / 1280);
			this.rect.bottom = (1104 * this.ScreenHeight / 1280 - this.Height0);
			this.totelDataText.setPadding(this.rect.left, this.rect.top,
					this.rect.right, this.rect.bottom);
			this.totelDataText.setTextSize(0, this.WordPx);
			this.totelDataText.setText("_");
		}
		this.totelDataText1 = ((TextView) findViewById(R.id.RemainderId));
		if (this.OneData >= 10) {
			this.rect.left = 0;
			this.rect.right = (512 * this.ScreenWidth / 960 - this.Width1);
			this.rect.top = (8 + (176 * this.ScreenHeight / 1280 + this.Height1));
			this.rect.bottom = (-8 + (1104 * this.ScreenHeight / 1280 - this.Height2));
			this.totelDataText1.setPadding(this.rect.left, this.rect.top,
					this.rect.right, this.rect.bottom);
		} else {
			this.rect.left = 0;
			this.rect.right = (512 * this.ScreenWidth / 960 - this.Width0);
			this.rect.top = (8 + (176 * this.ScreenHeight / 1280 + this.Height1));
			this.rect.bottom = (-8 + (1104 * this.ScreenHeight / 1280 - this.Height2));
			this.totelDataText1.setPadding(this.rect.left, this.rect.top,
					this.rect.right, this.rect.bottom);
		}
		this.totelDataText1.setTextSize(0, this.WordPx);
		this.totelDataText1.setText("");
		this.totelDataText2 = ((TextView) findViewById(R.id.RemainderId1));
		if (this.OneData >= 10) {
			this.rect.left = 0;
			this.rect.right = (512 * this.ScreenWidth / 960 - this.Width1);
			this.rect.top = (22 + (176 * this.ScreenHeight / 1280 + this.Height2));
			this.rect.bottom = (-22 + (1104 * this.ScreenHeight / 1280 - this.Height3));
			this.totelDataText2.setPadding(this.rect.left, this.rect.top,
					this.rect.right, this.rect.bottom);
		} else {
			this.rect.left = 0;
			this.rect.right = (512 * this.ScreenWidth / 960 - this.Width0);
			this.rect.top = (22 + (176 * this.ScreenHeight / 1280 + this.Height2));
			this.rect.bottom = (-22 + (1104 * this.ScreenHeight / 1280 - this.Height3));
			this.totelDataText2.setPadding(this.rect.left, this.rect.top,
					this.rect.right, this.rect.bottom);
		}
		this.totelDataText2.setTextSize(0, this.WordPx);
		this.totelDataText2.setText("");
		this.SysThg = 6;

		this.imageButtonLine = ((ImageView) findViewById(R.id.DivEasyLine1));
		this.rect.left = (224 * this.ScreenWidth / 960);
		this.rect.right = (112 * this.ScreenWidth / 960);
		this.rect.top = (8 + (176 * this.ScreenHeight / 1280 + this.Height2));
		this.rect.bottom = (-12 + (1104 * this.ScreenHeight / 1280 - this.Height2));
		((ViewGroup.MarginLayoutParams) this.imageButtonLine.getLayoutParams())
				.setMargins(this.rect.left, this.rect.top, this.rect.right,
						this.rect.bottom);
		this.imageButtonLine.setVisibility(8);
		return;
	}

	void DivHardPro() {
		int i = ProduceSummandAndAddMosaic();
		int j = ProduceSummandAndAdd();
		int k = i * j;
		this.ValTotelData = (i * j);
		this.OneData = k;
		this.TwoData = j;
		int m = i / 100;
		this.QuotientData0 = m;
		this.QuotientData1 = 0;
		this.QuotientData2 = (i - m * 100);
		this.ValOneData = (this.QuotientData0 * this.TwoData);
		this.ValTwoData = 0;
		this.ValThirdData = (this.QuotientData2 * this.TwoData);
		this.RemainderData0 = ((this.OneData - 100 * this.ValOneData) / 10);
		this.RemainderData1 = (this.QuotientData2 * this.TwoData);
		this.RemainderData2 = 0;
		TextView localTextView1 = (TextView) findViewById(R.id.DividendId);
		this.rect.left = 0;
		this.rect.right = (512 * this.ScreenWidth / 960 - this.Width3);
		this.rect.top = (4 + (176 * this.ScreenHeight / 1280 + this.Height0));
		this.rect.bottom = (-4 + (1104 * this.ScreenHeight / 1280 - this.Height1));
		localTextView1.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		localTextView1.setTextSize(0, this.WordPx);
		localTextView1.setText(this.OneData + "");
		this.size = (1 + (int) localTextView1.getTextSize());
		// (this.ScreenHeight * this.MaxPx / 960);
		TextView localTextView2 = (TextView) findViewById(R.id.DivsorId);
		this.rect.left = (0 * this.ScreenWidth / 960);
		this.rect.right = (544 * this.ScreenWidth / 960);
		this.rect.top = (4 + (176 * this.ScreenHeight / 1280 + this.Height0));
		this.rect.bottom = (-4 + (1104 * this.ScreenHeight / 1280 - this.Height1));
		localTextView2.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		localTextView2.setTextSize(0, this.WordPx);
		localTextView2.setText(this.TwoData + "");
		this.totelDataText = ((TextView) findViewById(R.id.QuotientId));
		this.rect.left = 0;
		this.rect.right = (512 * this.ScreenWidth / 960 - this.Width3);
		this.rect.top = (176 * this.ScreenHeight / 1280);
		this.rect.bottom = (1104 * this.ScreenHeight / 1280 - this.Height0);
		this.totelDataText.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		this.totelDataText.setTextSize(0, this.WordPx);
		this.totelDataText.setText("_  ");
		this.totelDataText1 = ((TextView) findViewById(R.id.RemainderId));
		this.rect.left = 0;
		this.rect.right = (512 * this.ScreenWidth / 960 - this.Width3);
		this.rect.top = (176 * this.ScreenHeight / 1280 + this.Height1);
		this.rect.bottom = (1104 * this.ScreenHeight / 1280 - this.Height2);
		this.totelDataText1.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		this.totelDataText1.setTextSize(0, this.WordPx);
		this.totelDataText1.setText("");
		this.totelDataText2 = ((TextView) findViewById(R.id.RemainderId1));
		this.rect.left = 0;
		this.rect.right = (512 * this.ScreenWidth / 960 - this.Width3);
		this.rect.top = (14 + (176 * this.ScreenHeight / 1280 + this.Height2));
		this.rect.bottom = (-14 + (1104 * this.ScreenHeight / 1280 - this.Height3));
		this.totelDataText2.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		this.totelDataText2.setTextSize(0, this.WordPx);
		this.totelDataText2.setText("");
		this.totelDataText3 = ((TextView) findViewById(R.id.RemainderId2));
		this.rect.left = 0;
		this.rect.right = (512 * this.ScreenWidth / 960 - this.Width3);
		this.rect.top = (14 + (176 * this.ScreenHeight / 1280 + this.Height3));
		this.rect.bottom = (-14 + (1104 * this.ScreenHeight / 1280 - this.Height4));
		this.totelDataText3.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		this.totelDataText3.setTextSize(0, this.WordPx);
		this.totelDataText3.setText("");
		this.totelDataText4 = ((TextView) findViewById(R.id.RemainderId3));
		this.rect.left = 0;
		this.rect.right = (512 * this.ScreenWidth / 960 - this.Width3);
		this.rect.top = (18 + (176 * this.ScreenHeight / 1280 + this.Height4));
		this.rect.bottom = (-18 + (1104 * this.ScreenHeight / 1280 - this.Height5));
		this.totelDataText4.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		this.totelDataText4.setTextSize(0, this.WordPx);
		this.totelDataText4.setText("");
		this.totelDataText5 = ((TextView) findViewById(R.id.RemainderId4));
		this.rect.left = 0;
		this.rect.right = (512 * this.ScreenWidth / 960 - this.Width3);
		this.rect.top = (18 + (176 * this.ScreenHeight / 1280 + this.Height5));
		this.rect.bottom = (-18 + (1104 * this.ScreenHeight / 1280 - this.Height6));
		this.totelDataText5.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		this.totelDataText5.setTextSize(0, this.WordPx);
		this.totelDataText5.setText("");
		this.totelDataText6 = ((TextView) findViewById(R.id.RemainderId5));
		this.rect.left = 0;
		this.rect.right = (512 * this.ScreenWidth / 960 - this.Width3);
		this.rect.top = (22 + (176 * this.ScreenHeight / 1280 + this.Height6));
		this.rect.bottom = (-22 + (1104 * this.ScreenHeight / 1280 - this.Height7));
		this.totelDataText6.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		this.totelDataText6.setTextSize(0, this.WordPx);
		this.totelDataText6.setText("");
		this.imageButtonDivSingle = ((ImageButton) findViewById(R.id.DivSignLong));
		this.rect.left = (424 * this.ScreenWidth / 960);
		this.rect.right = (536 * this.ScreenWidth / 960 - this.Width3 - this.Width0);
		this.rect.top = (176 * this.ScreenHeight / 1280 + this.Height0);
		this.rect.bottom = (-2 + (1104 * this.ScreenHeight / 1280 - this.Height1));
		((ViewGroup.MarginLayoutParams) this.imageButtonDivSingle
				.getLayoutParams()).setMargins(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		this.imageButtonLine = ((ImageView) findViewById(R.id.DivEasyLine1));
		this.rect.left = (224 * this.ScreenWidth / 960);
		this.rect.right = (112 * this.ScreenWidth / 960);
		this.rect.top = (4 + (176 * this.ScreenHeight / 1280 + this.Height2));
		this.rect.bottom = (-8 + (1104 * this.ScreenHeight / 1280 - this.Height2));
		((ViewGroup.MarginLayoutParams) this.imageButtonLine.getLayoutParams())
				.setMargins(this.rect.left, this.rect.top, this.rect.right,
						this.rect.bottom);
		this.imageButtonLine.setVisibility(8);
		this.imageButtonLine1 = ((ImageView) findViewById(R.id.DivNorLine2));
		this.rect.left = (224 * this.ScreenWidth / 960);
		this.rect.right = (112 * this.ScreenWidth / 960);
		this.rect.top = (14 + (176 * this.ScreenHeight / 1280 + this.Height4));
		this.rect.bottom = (-18 + (1104 * this.ScreenHeight / 1280 - this.Height4));
		((ViewGroup.MarginLayoutParams) this.imageButtonLine1.getLayoutParams())
				.setMargins(this.rect.left, this.rect.top, this.rect.right,
						this.rect.bottom);
		this.imageButtonLine1.setVisibility(8);
		this.imageButtonLine2 = ((ImageView) findViewById(R.id.DivHardLine3));
		this.rect.left = (224 * this.ScreenWidth / 960);
		this.rect.right = (112 * this.ScreenWidth / 960);
		this.rect.top = (18 + (176 * this.ScreenHeight / 1280 + this.Height6));
		this.rect.bottom = (-22 + (1104 * this.ScreenHeight / 1280 - this.Height6));
		((ViewGroup.MarginLayoutParams) this.imageButtonLine2.getLayoutParams())
				.setMargins(this.rect.left, this.rect.top, this.rect.right,
						this.rect.bottom);
		this.imageButtonLine2.setVisibility(8);
		this.SysThg = 15;
	}

	void DivNorPro() {
		int i = ProduceSummandAndAddMosaic();
		int j = ProduceSummandAndAdd();
		this.OneData = (i * j);
		this.TwoData = j;
		int k = i / 10;
		this.QuotientData0 = k;
		this.QuotientData1 = (i - k * 10);
		this.ValOneData = (this.QuotientData0 * this.TwoData);
		this.ValTwoData = (this.QuotientData1 * this.TwoData);
		this.RemainderData0 = this.ValTwoData;
		this.RemainderData1 = 0;
		TextView localTextView1 = (TextView) findViewById(R.id.DividendId);
		this.rect.left = 0;
		this.rect.right = (512 * this.ScreenWidth / 960 - this.Width2);
		this.rect.top = (4 + (176 * this.ScreenHeight / 1280 + this.Height0));
		this.rect.bottom = (-4 + (1104 * this.ScreenHeight / 1280 - this.Height1));
		localTextView1.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		localTextView1.setTextSize(0, this.WordPx);
		localTextView1.setText(this.OneData + "");
		TextView localTextView2 = (TextView) findViewById(R.id.DivsorId);
		this.rect.left = (0 * this.ScreenWidth / 960);
		this.rect.right = (544 * this.ScreenWidth / 960);
		this.rect.top = (4 + (176 * this.ScreenHeight / 1280 + this.Height0));
		this.rect.bottom = (-4 + (1104 * this.ScreenHeight / 1280 - this.Height1));
		localTextView2.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		localTextView2.setTextSize(0, this.WordPx);
		localTextView2.setText(this.TwoData + "");
		this.totelDataText = ((TextView) findViewById(R.id.QuotientId));
		this.rect.left = 0;
		this.rect.right = (512 * this.ScreenWidth / 960 - this.Width2);
		this.rect.top = (176 * this.ScreenHeight / 1280);
		this.rect.bottom = (1104 * this.ScreenHeight / 1280 - this.Height0);
		this.totelDataText.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		this.totelDataText.setTextSize(0, this.WordPx);
		this.totelDataText.setText("_ ");
		this.totelDataText1 = ((TextView) findViewById(R.id.RemainderId));
		this.rect.left = 0;
		this.rect.right = (512 * this.ScreenWidth / 960 - this.Width2);
		this.rect.top = (176 * this.ScreenHeight / 1280 + this.Height1);
		this.rect.bottom = (1104 * this.ScreenHeight / 1280 - this.Height2);
		this.totelDataText1.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		this.totelDataText1.setTextSize(0, this.WordPx);
		this.totelDataText1.setText("");
		this.totelDataText2 = ((TextView) findViewById(R.id.RemainderId1));
		this.rect.left = 0;
		this.rect.right = (512 * this.ScreenWidth / 960 - this.Width2);
		this.rect.top = (14 + (176 * this.ScreenHeight / 1280 + this.Height2));
		this.rect.bottom = (-14 + (1104 * this.ScreenHeight / 1280 - this.Height3));
		this.totelDataText2.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		this.totelDataText2.setTextSize(0, this.WordPx);
		this.totelDataText2.setText("");
		this.totelDataText3 = ((TextView) findViewById(R.id.RemainderId2));
		this.rect.left = 0;
		this.rect.right = (512 * this.ScreenWidth / 960 - this.Width2);
		this.rect.top = (14 + (176 * this.ScreenHeight / 1280 + this.Height3));
		this.rect.bottom = (-14 + (1104 * this.ScreenHeight / 1280 - this.Height4));
		this.totelDataText3.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		this.totelDataText3.setTextSize(0, this.WordPx);
		this.totelDataText3.setText("");
		this.totelDataText4 = ((TextView) findViewById(R.id.RemainderId3));
		this.rect.left = 0;
		this.rect.right = (512 * this.ScreenWidth / 960 - this.Width2);
		this.rect.top = (18 + (176 * this.ScreenHeight / 1280 + this.Height4));
		this.rect.bottom = (-22 + (1104 * this.ScreenHeight / 1280 - this.Height5));
		this.totelDataText4.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		this.totelDataText4.setTextSize(0, this.WordPx);
		this.totelDataText4.setText("");
		this.imageButtonDivSingle = ((ImageButton) findViewById(R.id.DivSignLong));
		this.rect.left = (424 * this.ScreenWidth / 960);
		this.rect.right = (2 + (536 * this.ScreenWidth / 960 - this.Width3));
		this.rect.top = (176 * this.ScreenHeight / 1280 + this.Height0);
		this.rect.bottom = (-2 + (1104 * this.ScreenHeight / 1280 - this.Height1));
		((ViewGroup.MarginLayoutParams) this.imageButtonDivSingle
				.getLayoutParams()).setMargins(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		this.imageButtonLine = ((ImageView) findViewById(R.id.DivEasyLine1));
		this.rect.left = (224 * this.ScreenWidth / 960);
		this.rect.right = (112 * this.ScreenWidth / 960);
		this.rect.top = (4 + (176 * this.ScreenHeight / 1280 + this.Height2));
		this.rect.bottom = (-8 + (1104 * this.ScreenHeight / 1280 - this.Height2));
		((ViewGroup.MarginLayoutParams) this.imageButtonLine.getLayoutParams())
				.setMargins(this.rect.left, this.rect.top, this.rect.right,
						this.rect.bottom);
		this.imageButtonLine.setVisibility(8);
		this.imageButtonLine1 = ((ImageView) findViewById(R.id.DivNorLine2));
		this.rect.left = (224 * this.ScreenWidth / 960);
		this.rect.right = (112 * this.ScreenWidth / 960);
		this.rect.top = (14 + (176 * this.ScreenHeight / 1280 + this.Height4));
		this.rect.bottom = (-18 + (1104 * this.ScreenHeight / 1280 - this.Height4));
		((ViewGroup.MarginLayoutParams) this.imageButtonLine1.getLayoutParams())
				.setMargins(this.rect.left, this.rect.top, this.rect.right,
						this.rect.bottom);
		this.imageButtonLine1.setVisibility(8);
		this.SysThg = 9;
	}

	void Init() {
		InitSetHardPro();
		InitSetModePro();
		InitSetDataPro();
		InitSetRebackPro();
	}

	void InitGetlistneseImageButton() {
		this.imageEasyBtn = ((ImageButton) findViewById(R.id.imageButton1));
		this.imageNorBtn = ((ImageButton) findViewById(R.id.imageButton2));
		this.imageHardBtn = ((ImageButton) findViewById(R.id.imageButton3));
		this.imageAddBtn = ((ImageButton) findViewById(R.id.imageButton4));
		this.imageDecBtn = ((ImageButton) findViewById(R.id.imageButton5));
		this.imageMulBtn = ((ImageButton) findViewById(R.id.imageButton6));
		this.imageDivBtn = ((ImageButton) findViewById(R.id.imageButton7));
		this.imageBackBtn = ((ImageButton) findViewById(R.id.imageButton18));
		this.imageBtn0 = ((ImageButton) findViewById(R.id.imageButton8));
		this.imageBtn1 = ((ImageButton) findViewById(R.id.imageButton9));
		this.imageBtn2 = ((ImageButton) findViewById(R.id.imageButton10));
		this.imageBtn3 = ((ImageButton) findViewById(R.id.imageButton11));
		this.imageBtn4 = ((ImageButton) findViewById(R.id.imageButton12));
		this.imageBtn5 = ((ImageButton) findViewById(R.id.imageButton13));
		this.imageBtn6 = ((ImageButton) findViewById(R.id.imageButton14));
		this.imageBtn7 = ((ImageButton) findViewById(R.id.imageButton15));
		this.imageBtn8 = ((ImageButton) findViewById(R.id.imageButton16));
		this.imageBtn9 = ((ImageButton) findViewById(R.id.imageButton17));
	}

	void InitSetDataPro() {
		this.rect.left = (372 * this.ScreenWidth / 960);
		this.rect.right = (458 * this.ScreenWidth / 960);
		this.rect.top = (960 * this.ScreenHeight / 1280);
		this.rect.bottom = (224 * this.ScreenHeight / 1280);
		((ViewGroup.MarginLayoutParams) this.imageBtn0.getLayoutParams())
				.setMargins(this.rect.left, this.rect.top, this.rect.right,
						this.rect.bottom);
		this.rect.left = (502 * this.ScreenWidth / 960);
		this.rect.right = (328 * this.ScreenWidth / 960);
		this.rect.top = (960 * this.ScreenHeight / 1280);
		this.rect.bottom = (224 * this.ScreenHeight / 1280);
		((ViewGroup.MarginLayoutParams) this.imageBtn1.getLayoutParams())
				.setMargins(this.rect.left, this.rect.top, this.rect.right,
						this.rect.bottom);
		this.rect.left = (632 * this.ScreenWidth / 960);
		this.rect.right = (198 * this.ScreenWidth / 960);
		this.rect.top = (960 * this.ScreenHeight / 1280);
		this.rect.bottom = (224 * this.ScreenHeight / 1280);
		((ViewGroup.MarginLayoutParams) this.imageBtn2.getLayoutParams())
				.setMargins(this.rect.left, this.rect.top, this.rect.right,
						this.rect.bottom);
		this.rect.left = (762 * this.ScreenWidth / 960);
		this.rect.right = (68 * this.ScreenWidth / 960);
		this.rect.top = (960 * this.ScreenHeight / 1280);
		this.rect.bottom = (224 * this.ScreenHeight / 1280);
		((ViewGroup.MarginLayoutParams) this.imageBtn3.getLayoutParams())
				.setMargins(this.rect.left, this.rect.top, this.rect.right,
						this.rect.bottom);
		this.rect.left = (372 * this.ScreenWidth / 960);
		this.rect.right = (458 * this.ScreenWidth / 960);
		this.rect.top = (1040 * this.ScreenHeight / 1280);
		this.rect.bottom = (144 * this.ScreenHeight / 1280);
		((ViewGroup.MarginLayoutParams) this.imageBtn4.getLayoutParams())
				.setMargins(this.rect.left, this.rect.top, this.rect.right,
						this.rect.bottom);
		this.rect.left = (502 * this.ScreenWidth / 960);
		this.rect.right = (328 * this.ScreenWidth / 960);
		this.rect.top = (1040 * this.ScreenHeight / 1280);
		this.rect.bottom = (144 * this.ScreenHeight / 1280);
		((ViewGroup.MarginLayoutParams) this.imageBtn5.getLayoutParams())
				.setMargins(this.rect.left, this.rect.top, this.rect.right,
						this.rect.bottom);
		this.rect.left = (632 * this.ScreenWidth / 960);
		this.rect.right = (198 * this.ScreenWidth / 960);
		this.rect.top = (1040 * this.ScreenHeight / 1280);
		this.rect.bottom = (144 * this.ScreenHeight / 1280);
		((ViewGroup.MarginLayoutParams) this.imageBtn6.getLayoutParams())
				.setMargins(this.rect.left, this.rect.top, this.rect.right,
						this.rect.bottom);
		this.rect.left = (762 * this.ScreenWidth / 960);
		this.rect.right = (68 * this.ScreenWidth / 960);
		this.rect.top = (1040 * this.ScreenHeight / 1280);
		this.rect.bottom = (144 * this.ScreenHeight / 1280);
		((ViewGroup.MarginLayoutParams) this.imageBtn7.getLayoutParams())
				.setMargins(this.rect.left, this.rect.top, this.rect.right,
						this.rect.bottom);
		this.rect.left = (372 * this.ScreenWidth / 960);
		this.rect.right = (458 * this.ScreenWidth / 960);
		this.rect.top = (1120 * this.ScreenHeight / 1280);
		this.rect.bottom = (64 * this.ScreenHeight / 1280);
		((ViewGroup.MarginLayoutParams) this.imageBtn8.getLayoutParams())
				.setMargins(this.rect.left, this.rect.top, this.rect.right,
						this.rect.bottom);
		this.rect.left = (502 * this.ScreenWidth / 960);
		this.rect.right = (328 * this.ScreenWidth / 960);
		this.rect.top = (1120 * this.ScreenHeight / 1280);
		this.rect.bottom = (64 * this.ScreenHeight / 1280);
		((ViewGroup.MarginLayoutParams) this.imageBtn9.getLayoutParams())
				.setMargins(this.rect.left, this.rect.top, this.rect.right,
						this.rect.bottom);
	}

	void InitSetHardPro() {
		this.imageEasyBtn = ((ImageButton) findViewById(R.id.imageButton1));
		this.rect.left = (224 * this.ScreenWidth / 960);
		this.rect.right = (544 * this.ScreenWidth / 960);
		this.rect.top = (56 * this.ScreenHeight / 1280);
		this.rect.bottom = (1136 * this.ScreenHeight / 1280);
		((ViewGroup.MarginLayoutParams) this.imageEasyBtn.getLayoutParams())
				.setMargins(this.rect.left, this.rect.top, this.rect.right,
						this.rect.bottom);
		this.imageNorBtn = ((ImageButton) findViewById(R.id.imageButton2));
		this.rect.left = (421 * this.ScreenWidth / 960);
		this.rect.right = (347 * this.ScreenWidth / 960);
		this.rect.top = (56 * this.ScreenHeight / 1280);
		this.rect.bottom = (1136 * this.ScreenHeight / 1280);
		((ViewGroup.MarginLayoutParams) this.imageNorBtn.getLayoutParams())
				.setMargins(this.rect.left, this.rect.top, this.rect.right,
						this.rect.bottom);
		this.imageHardBtn = ((ImageButton) findViewById(R.id.imageButton3));
		this.rect.left = (620 * this.ScreenWidth / 960);
		this.rect.right = (148 * this.ScreenWidth / 960);
		this.rect.top = (56 * this.ScreenHeight / 1280);
		this.rect.bottom = (1136 * this.ScreenHeight / 1280);
		((ViewGroup.MarginLayoutParams) this.imageHardBtn.getLayoutParams())
				.setMargins(this.rect.left, this.rect.top, this.rect.right,
						this.rect.bottom);
	}

	void InitSetModePro() {
		this.imageAddBtn = ((ImageButton) findViewById(R.id.imageButton4));
		this.rect.left = (8 * this.ScreenWidth / 960);
		this.rect.right = (760 * this.ScreenWidth / 960);
		this.rect.top = (128 * this.ScreenHeight / 1280);
		this.rect.bottom = (1040 * this.ScreenHeight / 1280);
		((ViewGroup.MarginLayoutParams) this.imageAddBtn.getLayoutParams())
				.setMargins(this.rect.left, this.rect.top, this.rect.right,
						this.rect.bottom);
		this.imageDecBtn = ((ImageButton) findViewById(R.id.imageButton5));
		this.rect.left = (8 * this.ScreenWidth / 960);
		this.rect.right = (760 * this.ScreenWidth / 960);
		this.rect.top = (240 * this.ScreenHeight / 1280);
		this.rect.bottom = (928 * this.ScreenHeight / 1280);
		((ViewGroup.MarginLayoutParams) this.imageDecBtn.getLayoutParams())
				.setMargins(this.rect.left, this.rect.top, this.rect.right,
						this.rect.bottom);
		this.imageMulBtn = ((ImageButton) findViewById(R.id.imageButton6));
		this.rect.left = (8 * this.ScreenWidth / 960);
		this.rect.right = (760 * this.ScreenWidth / 960);
		this.rect.top = (352 * this.ScreenHeight / 1280);
		this.rect.bottom = (816 * this.ScreenHeight / 1280);
		((ViewGroup.MarginLayoutParams) this.imageMulBtn.getLayoutParams())
				.setMargins(this.rect.left, this.rect.top, this.rect.right,
						this.rect.bottom);
		this.imageDivBtn = ((ImageButton) findViewById(R.id.imageButton7));
		this.rect.left = (8 * this.ScreenWidth / 960);
		this.rect.right = (760 * this.ScreenWidth / 960);
		this.rect.top = (464 * this.ScreenHeight / 1280);
		this.rect.bottom = (704 * this.ScreenHeight / 1280);
		((ViewGroup.MarginLayoutParams) this.imageDivBtn.getLayoutParams())
				.setMargins(this.rect.left, this.rect.top, this.rect.right,
						this.rect.bottom);
	}

	void InitSetRebackPro() {
		this.imageBackBtn = ((ImageButton) findViewById(R.id.imageButton18));
		this.rect.left = (632 * this.ScreenWidth / 960);
		this.rect.right = (68 * this.ScreenWidth / 960);
		this.rect.top = (1120 * this.ScreenHeight / 1280);
		this.rect.bottom = (64 * this.ScreenHeight / 1280);
		((ViewGroup.MarginLayoutParams) this.imageBackBtn.getLayoutParams())
				.setMargins(this.rect.left, this.rect.top, this.rect.right,
						this.rect.bottom);
	}

	void MulsEasyPro() {
		this.SubSingle = ((TextView) findViewById(R.id.textView1));
		this.rect.left = (256 * this.ScreenWidth / 960);
		this.rect.right = (448 * this.ScreenWidth / 960);
		this.rect.top = (176 * this.ScreenHeight / 1280 + this.Height1);
		this.rect.bottom = (1104 * this.ScreenHeight / 1280 - this.Height2);
		this.SubSingle.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		this.SubSingle.setTextSize(0, this.WordPx);
		this.SubSingle.setText("x  ");
		int i = ProduceSummandAndAddMosaic();
		int j = ProduceSummandAndAdd();
		int k = i * j;
		this.OneData = i;
		this.TwoData = j;
		this.ValTotelData = k;
		TextView localTextView1 = (TextView) findViewById(R.id.AddOne1);
		this.rect.left = 0;
		this.rect.right = (512 * this.ScreenWidth / 960 - this.Width2);
		this.rect.top = (176 * this.ScreenHeight / 1280 + this.Height0);
		this.rect.bottom = (1104 * this.ScreenHeight / 1280 - this.Height1);
		localTextView1.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		localTextView1.setTextSize(0, this.WordPx);
		localTextView1.setText(this.OneData + "");
		TextView localTextView2 = (TextView) findViewById(R.id.AddTwo2);
		this.rect.left = 0;
		this.rect.right = (512 * this.ScreenWidth / 960 - this.Width2);
		this.rect.top = (176 * this.ScreenHeight / 1280 + this.Height1);
		this.rect.bottom = (1104 * this.ScreenHeight / 1280 - this.Height2);
		localTextView2.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		localTextView2.setTextSize(0, this.WordPx);
		localTextView2.setText(this.TwoData + "");
		this.viewLine1 = ((ImageView) findViewById(R.id.AddLineQue));
		this.rect.left = (224 * this.ScreenWidth / 960);
		this.rect.right = (112 * this.ScreenWidth / 960);
		this.rect.top = (10 + (176 * this.ScreenHeight / 1280 + this.Height2));
		this.rect.bottom = (-14 + (1104 * this.ScreenHeight / 1280 - this.Height2));
		((ViewGroup.MarginLayoutParams) this.viewLine1.getLayoutParams())
				.setMargins(this.rect.left, this.rect.top, this.rect.right,
						this.rect.bottom);
		SetValBit(this.ValTotelData);
		this.totelDataText = ((TextView) findViewById(R.id.AddTotel1));
		this.rect.left = 0;
		this.rect.right = (512 * this.ScreenWidth / 960 - this.Width2);
		this.rect.top = (14 + (176 * this.ScreenHeight / 1280 + this.Height2));
		this.rect.bottom = (-14 + (1104 * this.ScreenHeight / 1280 - this.Height3));
		this.totelDataText.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		this.totelDataText.setTextSize(0, this.WordPx);
		this.totelDataText.setText("_");
		this.SysThg = 1;
	}

	void MulsHardPro() {
		int i = ProduceSummandAndAddMosaic();
		int j = ProduceSummandAndAdd();
		this.OneData = i;
		this.TwoData = j;
		int k = j / 100;
		this.ValOneData = (i * (j - k * 100));
		this.ValTwoData = 0;
		this.ValThirdData = (i * k);
		this.ValTotelData = (i * j);
		this.SubSingle = ((TextView) findViewById(R.id.textView1));
		this.rect.left = (256 * this.ScreenWidth / 960);
		this.rect.right = (448 * this.ScreenWidth / 960);
		this.rect.top = (176 * this.ScreenHeight / 1280 + this.Height1);
		this.rect.bottom = (1104 * this.ScreenHeight / 1280 - this.Height2);
		this.SubSingle.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		this.SubSingle.setTextSize(0, this.WordPx);
		this.SubSingle.setText("x  ");
		TextView localTextView1 = (TextView) findViewById(R.id.AddOne1);
		this.rect.left = 0;
		this.rect.right = (512 * this.ScreenWidth / 960 - this.Width2);
		this.rect.top = (176 * this.ScreenHeight / 1280 + this.Height0);
		this.rect.bottom = (1104 * this.ScreenHeight / 1280 - this.Height1);
		localTextView1.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		localTextView1.setTextSize(0, this.WordPx);
		localTextView1.setText(this.OneData + "");
		TextView localTextView2 = (TextView) findViewById(R.id.AddTwo2);
		this.rect.left = 0;
		this.rect.right = (512 * this.ScreenWidth / 960 - this.Width2);
		this.rect.top = (176 * this.ScreenHeight / 1280 + this.Height1);
		this.rect.bottom = (1104 * this.ScreenHeight / 1280 - this.Height2);
		localTextView2.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		localTextView2.setTextSize(0, this.WordPx);
		localTextView2.setText(this.TwoData + "");
		this.totelDataText = ((TextView) findViewById(R.id.AddTotel1));
		this.rect.left = 0;
		this.rect.right = (512 * this.ScreenWidth / 960 - this.Width2);
		this.rect.top = (14 + (176 * this.ScreenHeight / 1280 + this.Height2));
		this.rect.bottom = (-14 + (1104 * this.ScreenHeight / 1280 - this.Height3));
		this.totelDataText.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		this.totelDataText.setTextSize(0, this.WordPx);
		this.totelDataText.setText("_");
		this.totelDataText1 = ((TextView) findViewById(R.id.MulNum1));
		this.rect.left = 0;
		this.rect.right = (512 * this.ScreenWidth / 960 - this.Width2);
		this.rect.top = (14 + (176 * this.ScreenHeight / 1280 + this.Height3));
		this.rect.bottom = (-14 + (1104 * this.ScreenHeight / 1280 - this.Height4));
		this.totelDataText1.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		this.totelDataText1.setTextSize(0, this.WordPx);
		this.totelDataText1.setText("");
		this.totelDataText2 = ((TextView) findViewById(R.id.MulDataId3));
		this.rect.left = 0;
		this.rect.right = (512 * this.ScreenWidth / 960 - this.Width2);
		this.rect.top = (14 + (176 * this.ScreenHeight / 1280 + this.Height4));
		this.rect.bottom = (-14 + (1104 * this.ScreenHeight / 1280 - this.Height5));
		this.totelDataText2.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		this.totelDataText2.setTextSize(0, this.WordPx);
		this.totelDataText2.setText("");
		this.totelDataText3 = ((TextView) findViewById(R.id.Zhongxiaohong));
		this.rect.left = 0;
		this.rect.right = (512 * this.ScreenWidth / 960 - this.Width2);
		this.rect.top = (18 + (176 * this.ScreenHeight / 1280 + this.Height5));
		this.rect.bottom = (-18 + (1104 * this.ScreenHeight / 1280 - this.Height6));
		this.totelDataText3.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		this.totelDataText3.setTextSize(0, this.WordPx);
		this.totelDataText3.setText("");
		this.viewLine1 = ((ImageView) findViewById(R.id.AddLineQue));
		this.rect.left = (224 * this.ScreenWidth / 960);
		this.rect.right = (112 * this.ScreenWidth / 960);
		this.rect.top = (10 + (176 * this.ScreenHeight / 1280 + this.Height2));
		this.rect.bottom = (-14 + (1104 * this.ScreenHeight / 1280 - this.Height2));
		((ViewGroup.MarginLayoutParams) this.viewLine1.getLayoutParams())
				.setMargins(this.rect.left, this.rect.top, this.rect.right,
						this.rect.bottom);
		this.viewLine2 = ((ImageView) findViewById(R.id.AddLineEqu2));
		this.viewLine1 = ((ImageView) findViewById(R.id.AddLineQue));
		this.rect.left = (224 * this.ScreenWidth / 960);
		this.rect.right = (112 * this.ScreenWidth / 960);
		this.rect.top = (14 + (176 * this.ScreenHeight / 1280 + this.Height5));
		this.rect.bottom = (-18 + (1104 * this.ScreenHeight / 1280 - this.Height5));
		((ViewGroup.MarginLayoutParams) this.viewLine2.getLayoutParams())
				.setMargins(this.rect.left, this.rect.top, this.rect.right,
						this.rect.bottom);
		this.viewLine2.setVisibility(8);
		this.SysThg = 2;
	}

	void MulsNorPro() {
		int i = ProduceSummandAndAddMosaic();
		int j = ProduceSummandAndAdd();
		this.OneData = i;
		this.TwoData = j;
		int k = j / 10;
		this.ValOneData = (i * (j - k * 10));
		this.ValTwoData = (i * k);
		this.ValTotelData = (i * j);
		this.SubSingle = ((TextView) findViewById(R.id.textView1));
		this.rect.left = (256 * this.ScreenWidth / 960);
		this.rect.right = (448 * this.ScreenWidth / 960);
		this.rect.top = (176 * this.ScreenHeight / 1280 + this.Height1);
		this.rect.bottom = (1104 * this.ScreenHeight / 1280 - this.Height2);
		this.SubSingle.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		this.SubSingle.setTextSize(0, this.WordPx);
		this.SubSingle.setText("x  ");
		TextView localTextView1 = (TextView) findViewById(R.id.AddOne1);
		this.rect.left = 0;
		this.rect.right = (512 * this.ScreenWidth / 960 - this.Width2);
		this.rect.top = (176 * this.ScreenHeight / 1280 + this.Height0);
		this.rect.bottom = (1104 * this.ScreenHeight / 1280 - this.Height1);
		localTextView1.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		localTextView1.setTextSize(0, this.WordPx);
		localTextView1.setText(this.OneData + "");
		TextView localTextView2 = (TextView) findViewById(R.id.AddTwo2);
		this.rect.left = 0;
		this.rect.right = (512 * this.ScreenWidth / 960 - this.Width2);
		this.rect.top = (176 * this.ScreenHeight / 1280 + this.Height1);
		this.rect.bottom = (1104 * this.ScreenHeight / 1280 - this.Height2);
		localTextView2.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		localTextView2.setTextSize(0, this.WordPx);
		localTextView2.setText(this.TwoData + "");
		this.totelDataText = ((TextView) findViewById(R.id.AddTotel1));
		this.rect.left = 0;
		this.rect.right = (512 * this.ScreenWidth / 960 - this.Width2);
		this.rect.top = (14 + (176 * this.ScreenHeight / 1280 + this.Height2));
		this.rect.bottom = (-14 + (1104 * this.ScreenHeight / 1280 - this.Height3));
		this.totelDataText.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		this.totelDataText.setTextSize(0, this.WordPx);
		this.totelDataText.setText("_");
		this.totelDataText1 = ((TextView) findViewById(R.id.MulNum1));
		this.rect.left = 0;
		this.rect.right = (512 * this.ScreenWidth / 960 - this.Width2);
		this.rect.top = (14 + (176 * this.ScreenHeight / 1280 + this.Height3));
		this.rect.bottom = (-14 + (1104 * this.ScreenHeight / 1280 - this.Height4));
		this.totelDataText1.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		this.totelDataText1.setTextSize(0, this.WordPx);
		this.totelDataText1.setText("");
		this.viewLine1 = ((ImageView) findViewById(R.id.AddLineQue));
		this.rect.left = (224 * this.ScreenWidth / 960);
		this.rect.right = (112 * this.ScreenWidth / 960);
		this.rect.top = (10 + (176 * this.ScreenHeight / 1280 + this.Height2));
		this.rect.bottom = (-14 + (1104 * this.ScreenHeight / 1280 - this.Height2));
		((ViewGroup.MarginLayoutParams) this.viewLine1.getLayoutParams())
				.setMargins(this.rect.left, this.rect.top, this.rect.right,
						this.rect.bottom);
		this.viewLine2 = ((ImageView) findViewById(R.id.AddLineEqu2));
		this.rect.left = (224 * this.ScreenWidth / 960);
		this.rect.right = (112 * this.ScreenWidth / 960);
		this.rect.top = (14 + (176 * this.ScreenHeight / 1280 + this.Height4));
		this.rect.bottom = (-18 + (1104 * this.ScreenHeight / 1280 - this.Height4));
		((ViewGroup.MarginLayoutParams) this.viewLine2.getLayoutParams())
				.setMargins(this.rect.left, this.rect.top, this.rect.right,
						this.rect.bottom);
		this.viewLine2.setVisibility(8);
		this.totelDataText3 = ((TextView) findViewById(R.id.MulTotalId1));
		this.rect.left = 0;
		this.rect.right = (512 * this.ScreenWidth / 960 - this.Width2);
		this.rect.top = (18 + (176 * this.ScreenHeight / 1280 + this.Height4));
		this.rect.bottom = (-18 + (1104 * this.ScreenHeight / 1280 - this.Height5));
		this.totelDataText3.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		this.totelDataText3.setTextSize(0, this.WordPx);
		this.totelDataText3.setText("");
		this.SysThg = 2;
	}

	public void ProduceAdd() {
		this.OneData = ProduceSummandAndAddMosaic();
		TextView localTextView1 = (TextView) findViewById(R.id.AddOne1);
		this.rect.left = 0;
		this.rect.right = (512 * this.ScreenWidth / 960 - this.Width2);
		this.rect.top = (176 * this.ScreenHeight / 1280 + this.Height0);
		this.rect.bottom = (1104 * this.ScreenHeight / 1280 - this.Height1);
		localTextView1.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		localTextView1.setTextSize(0, this.WordPx);
		localTextView1.setText(this.OneData + "");
		this.TwoData = ProduceSummandAndAdd();
		TextView localTextView2 = (TextView) findViewById(R.id.AddTwo2);
		this.rect.left = 0;
		this.rect.right = (512 * this.ScreenWidth / 960 - this.Width2);
		this.rect.top = (176 * this.ScreenHeight / 1280 + this.Height1);
		this.rect.bottom = (1104 * this.ScreenHeight / 1280 - this.Height2);
		localTextView2.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		localTextView2.setTextSize(0, this.WordPx);
		localTextView2.setText(this.TwoData + "");
		this.SubSingle = ((TextView) findViewById(R.id.textView1));
		this.rect.left = (256 * this.ScreenWidth / 960);
		this.rect.right = (448 * this.ScreenWidth / 960);
		this.rect.top = (176 * this.ScreenHeight / 1280 + this.Height1);
		this.rect.bottom = (1104 * this.ScreenHeight / 1280 - this.Height2);
		this.SubSingle.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		this.SubSingle.setTextSize(0, this.WordPx);
		this.SubSingle.setText("+  ");
		this.viewLine1 = ((ImageView) findViewById(R.id.AddLineQue));
		this.rect.left = (224 * this.ScreenWidth / 960);
		this.rect.right = (112 * this.ScreenWidth / 960);
		this.rect.top = (10 + (176 * this.ScreenHeight / 1280 + this.Height2));
		this.rect.bottom = (-14 + (1104 * this.ScreenHeight / 1280 - this.Height2));
		((ViewGroup.MarginLayoutParams) this.viewLine1.getLayoutParams())
				.setMargins(this.rect.left, this.rect.top, this.rect.right,
						this.rect.bottom);
		this.ValTotelData = (this.OneData + this.TwoData);
		SetValBit(this.ValTotelData);
		this.totelDataText = ((TextView) findViewById(R.id.AddTotel1));
		this.rect.left = 0;
		this.rect.right = (512 * this.ScreenWidth / 960 - this.Width2);
		this.rect.top = (14 + (176 * this.ScreenHeight / 1280 + this.Height2));
		this.rect.bottom = (-14 + (1104 * this.ScreenHeight / 1280 - this.Height3));
		this.totelDataText.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		this.totelDataText.setTextSize(0, this.WordPx);
		this.totelDataText.setText("_");
		this.SyskeyCode = 0;
		this.BitFlag0 = 0;
		this.DispStr1 = "";
		this.SysThg = 1;
	}

	public int ProduceSummandAndAdd() {
		int i;
		switch (this.LevFlag) {
		case 0:
			i = UtilRandom(1, 10);
			break;
		case 1:
			i = UtilRandom(10, 19);
			break;
		case 2:
			i = UtilRandom(100, 109);
			break;
		default:
			i = 0;
			break;
		}
		return i;
	}

	public int ProduceSummandAndAddMosaic() {
		int i;
		switch (this.LevFlag) {
		case 0:
			i = this.MosaicEasy.GetMosaicBuffData();
			break;
		case 1:
			i = this.MosaicNor.GetMosaicBuffData();
			break;
		case 2:
			i = this.MosaicHard.GetMosaicBuffData();
			break;
		default:
			i = 0;
			break;
		}
		// while (true) {
		// continue;
		// continue;
		// }
		return i;
	}

	public int ScanfDataAdd(int paramInt1, int paramInt2) {
		switch (this.BitFlag0) {
		case 0:
			paramInt1 = paramInt2;
			break;
		case 1:
			paramInt1 += paramInt2 * 10;
			break;
		case 2:
			paramInt1 += paramInt2 * 100;
			break;
		case 3:
			paramInt1 += paramInt2 * 1000;
			break;
		case 4:
			paramInt1 += paramInt2 * 10000;
			break;
		default:
			break;
		}
		return paramInt1;
		// while (true) {
		// continue;
		// continue;
		// continue;
		// continue;
		// }
	}

	public boolean ScanfGetData(int paramInt1, int paramInt2, int paramInt3) {
		this.GetDataFlag = false;
		if (this.ValidKeyCodeFlag) {
			this.ValidKeyCodeFlag = false;
			SetValBit(paramInt1);
			if (this.BitFlag0 < this.ValBit) {
				// this.DispStr1 = this.SyskeyCode.concat(this.DispStr1);
				//讲输入的字符SyskeyCode与之前存在的字符DispStr1拼凑成新字符
				this.DispStr1 = this.SyskeyCode+this.DispStr1;
				this.GetData = ScanfDataAdd(this.GetData, this.SyskeyCode);
				this.BitFlag0 = (1 + this.BitFlag0);
			}
			if (this.BitFlag0 >= this.ValBit) {
				this.GetDataFlag = true;
				this.msg = new Message();
				this.msg.what = paramInt2;
				this.handler.sendMessage(this.msg);
			} else {
				this.GetDataFlag = false;
				this.msg = new Message();
				this.msg.what = paramInt3;
				this.handler.sendMessage(this.msg);
			}
		}
		if (this.BackFlag) {
			SetValBit(paramInt1);
			if ((this.ValBit > 1) && (this.BitFlag0 < this.ValBit)
					&& (this.BitFlag0 > 0)) {
				this.GetData = BackDataDec(this.GetData, this.BitFlag0);
				this.BitFlag0 = (-1 + this.BitFlag0);
				this.GetDataFlag = false;
				this.msg = new Message();
				this.msg.what = paramInt3;
				this.handler.sendMessage(this.msg);
			}
		}
		this.BackFlag = false;
		return this.GetDataFlag;
	}

	public void SetBackReBackListener() {
		 this.imageBackBtn.setOnClickListener(new BackBtnClick());
		this.imageExit = ((ImageButton) findViewById(R.id.imageButtonexit));
		this.rect.left = (832 * this.ScreenWidth / 960);
		this.rect.right = 0;
		this.rect.top = 0;
		this.rect.bottom = (1168 * this.ScreenHeight / 1280);
		((ViewGroup.MarginLayoutParams) this.imageExit.getLayoutParams())
				.setMargins(this.rect.left, this.rect.top, this.rect.right,
						this.rect.bottom);
		this.imageExit.setOnClickListener(new exit());
	}

	class exit implements View.OnClickListener {
		public void onClick(View paramView) {
			finish();
		}
	}
	class BackBtnClick implements View.OnClickListener {
		public void onClick(View paramView) {
//			MainActivity.imageBackBtn(this, true);
			BackFlag = true;
		}
	}

	public void SetErrorReset() {
		if (this.mediaPlayer != null)
			this.mediaPlayer.release();
		this.mediaPlayer = MediaPlayer.create(this.mContext, R.raw.dubious);
		this.mediaPlayer.start();
		if (this.field == null) {
			this.toast = Toast.makeText(this.mContext, "做错了重来", 1);
			this.toast.setGravity(17, 0, 0);
			reflectionTN();
		}
		try {
			this.showMethod.invoke(this.obj, null);
			this.ShowToastTimer = 0;
			return;
		} catch (Exception localException) {
			localException.printStackTrace();
		}
	}

	public void SetGood() {
		if (this.mediaPlayer != null)
			this.mediaPlayer.release();
		if (RandomBool() == 0) {

			this.mediaPlayer = MediaPlayer
					.create(this.mContext, R.raw.verygood);
		} else {
			this.mediaPlayer = MediaPlayer
					.create(this.mContext, R.raw.verytrue);
		}
		this.mediaPlayer.start();
		if (this.field == null) {
			this.toast = Toast.makeText(this.mContext, "太棒了", 1);
			this.toast.setGravity(17, 100, 80);
			reflectionTN();
		}
		try {
			this.showMethod.invoke(this.obj, null);
			this.ShowToastTimer = 0;
		} catch (Exception localException) {
			localException.printStackTrace();
		}
	}

	void SetImageButtonTouchPro() {
		this.imageEasyBtn.setOnTouchListener(new EasyBtn());
		this.imageNorBtn.setOnTouchListener(new NorBtn());
		this.imageHardBtn.setOnTouchListener(new HardBtn());
		this.imageAddBtn.setOnTouchListener(new AddBtn());
		this.imageDecBtn.setOnTouchListener(new DecBtn());
		this.imageMulBtn.setOnTouchListener(new MulBtn());
		this.imageDivBtn.setOnTouchListener(new DivBtn());
		this.imageBackBtn.setOnTouchListener(new BackBtn());
		this.imageBtn0.setOnTouchListener(new Btn0());
		this.imageBtn1.setOnTouchListener(new Btn1());
		this.imageBtn2.setOnTouchListener(new Btn2());
		this.imageBtn3.setOnTouchListener(new Btn3());
		this.imageBtn4.setOnTouchListener(new Btn4());
		this.imageBtn5.setOnTouchListener(new Btn5());
		this.imageBtn6.setOnTouchListener(new Btn6());
		this.imageBtn7.setOnTouchListener(new Btn7());
		this.imageBtn8.setOnTouchListener(new Btn8());
		this.imageBtn9.setOnTouchListener(new Btn9());
	}

	class Btn9 implements View.OnTouchListener {
		public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
			if (paramMotionEvent.getAction() == MotionEvent.ACTION_DOWN){
				imageBtn9.setBackgroundDrawable(getResources().getDrawable(R.drawable.sizesp_033));
			}
			else if (paramMotionEvent.getAction() == MotionEvent.ACTION_UP){
				
				imageBtn9.setBackgroundDrawable(getResources().getDrawable(R.drawable.sizesp_032));
				SetMenuKeyProcess(9);
			}
			return false;
		}
	}

	class Btn8 implements View.OnTouchListener {
		public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
			if (paramMotionEvent.getAction() == MotionEvent.ACTION_DOWN){
				imageBtn8.setBackgroundDrawable(getResources().getDrawable(R.drawable.sizesp_031));
			}
			else if (paramMotionEvent.getAction() == MotionEvent.ACTION_UP){
				
				imageBtn8.setBackgroundDrawable(getResources().getDrawable(R.drawable.sizesp_030));
				SetMenuKeyProcess(8);
			}
			return false;
		}
	}

	class Btn7 implements View.OnTouchListener {
		public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
			if (paramMotionEvent.getAction() == MotionEvent.ACTION_DOWN){
				imageBtn7.setBackgroundDrawable(getResources().getDrawable(R.drawable.sizesp_029));
			}
			else if (paramMotionEvent.getAction() == MotionEvent.ACTION_UP){
				
				imageBtn7.setBackgroundDrawable(getResources().getDrawable(R.drawable.sizesp_028));
				SetMenuKeyProcess(7);
			}
			return false;
		}
	}

	class Btn6 implements View.OnTouchListener {
		public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
			if (paramMotionEvent.getAction() == MotionEvent.ACTION_DOWN){
				imageBtn6.setBackgroundDrawable(getResources().getDrawable(R.drawable.sizesp_027));
			}
			else if (paramMotionEvent.getAction() == MotionEvent.ACTION_UP){
				
				imageBtn6.setBackgroundDrawable(getResources().getDrawable(R.drawable.sizesp_026));
				SetMenuKeyProcess(6);
			}
			return false;
		}
	}

	class Btn5 implements View.OnTouchListener {
		public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
			if (paramMotionEvent.getAction() == MotionEvent.ACTION_DOWN){
				imageBtn5.setBackgroundDrawable(getResources().getDrawable(R.drawable.sizesp_025));
			}
			else if (paramMotionEvent.getAction() == MotionEvent.ACTION_UP){
				
				imageBtn5.setBackgroundDrawable(getResources().getDrawable(R.drawable.sizesp_024));
				SetMenuKeyProcess(5);
			}
			return false;
		}
	}

	class Btn4 implements View.OnTouchListener {
		public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
			if (paramMotionEvent.getAction() == MotionEvent.ACTION_DOWN){
				imageBtn4.setBackgroundDrawable(getResources().getDrawable(R.drawable.sizesp_023));
			}
			else if (paramMotionEvent.getAction() == MotionEvent.ACTION_UP){
				
				imageBtn4.setBackgroundDrawable(getResources().getDrawable(R.drawable.sizesp_022));
				SetMenuKeyProcess(4);
			}
			return false;
		}
	}

	class Btn3 implements View.OnTouchListener {
		public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
			if (paramMotionEvent.getAction() == MotionEvent.ACTION_DOWN){
				imageBtn3.setBackgroundDrawable(getResources().getDrawable(R.drawable.sizesp_021));
			}
			else if (paramMotionEvent.getAction() == MotionEvent.ACTION_UP){
				
				imageBtn3.setBackgroundDrawable(getResources().getDrawable(R.drawable.sizesp_020));
				SetMenuKeyProcess(3);
			}
			return false;
		}
	}

	class Btn2 implements View.OnTouchListener {
		public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
			if (paramMotionEvent.getAction() == MotionEvent.ACTION_DOWN){
				imageBtn2.setBackgroundDrawable(getResources().getDrawable(R.drawable.sizesp_019));
			}
			else if (paramMotionEvent.getAction() == MotionEvent.ACTION_UP){
				
				imageBtn2.setBackgroundDrawable(getResources().getDrawable(R.drawable.sizesp_018));
				SetMenuKeyProcess(2);
			}
			return false;
		}
	}

	class Btn1 implements View.OnTouchListener {
		public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
			if (paramMotionEvent.getAction() == MotionEvent.ACTION_DOWN){
				imageBtn1.setBackgroundDrawable(getResources().getDrawable(R.drawable.sizesp_017));
			}
			else if (paramMotionEvent.getAction() == MotionEvent.ACTION_UP){
				
				imageBtn1.setBackgroundDrawable(getResources().getDrawable(R.drawable.sizesp_016));
				SetMenuKeyProcess(1);
			}
			return false;
		}
	}

	class Btn0 implements View.OnTouchListener {
		public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
			if (paramMotionEvent.getAction() == MotionEvent.ACTION_DOWN){
				imageBtn0.setBackgroundDrawable(getResources().getDrawable(R.drawable.sizesp_015));
			}
			else if (paramMotionEvent.getAction() == MotionEvent.ACTION_UP){
				
				imageBtn0.setBackgroundDrawable(getResources().getDrawable(R.drawable.sizesp_014));
				SetMenuKeyProcess(0);
			}
			return false;
		}
	}

	class BackBtn implements View.OnTouchListener {
		public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
			if (paramMotionEvent.getAction() == MotionEvent.ACTION_DOWN){
				imageBackBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.sizesp_035));
			}
			else if (paramMotionEvent.getAction() == MotionEvent.ACTION_UP){
				
				imageBackBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.sizesp_034));
			}
			return false;
		}
	}

	class DivBtn implements View.OnTouchListener {
		public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
			if (paramMotionEvent.getAction() == MotionEvent.ACTION_DOWN){
				imageDivBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.sizesp_013));
			}
			else if (paramMotionEvent.getAction() == MotionEvent.ACTION_UP){
				
				imageDivBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.sizesp_012));
				ModeFlag = 3;
				ArithmeticInit();
			}
			
			return false;
		}
	}

	class MulBtn implements View.OnTouchListener {
		public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
			if (paramMotionEvent.getAction() == MotionEvent.ACTION_DOWN){
				imageMulBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.sizesp_011));
			}
			else if (paramMotionEvent.getAction() == MotionEvent.ACTION_UP){
				
				imageMulBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.sizesp_010));
				ModeFlag = 2;
				ArithmeticInit();
			}
			
			return false;
		}
	}

	class DecBtn implements View.OnTouchListener {
		public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
			if (paramMotionEvent.getAction() == MotionEvent.ACTION_DOWN){
				imageDecBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.sizesp_009));
			}
			else if (paramMotionEvent.getAction() == MotionEvent.ACTION_UP){
				
				imageDecBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.sizesp_008));
				ModeFlag = 1;
				ArithmeticInit();
			}
			
			return false;
		}
	}

	class AddBtn implements View.OnTouchListener {
		public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
			if (paramMotionEvent.getAction() == MotionEvent.ACTION_DOWN){
				imageAddBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.sizesp_007));
			}
			else if (paramMotionEvent.getAction() == MotionEvent.ACTION_UP){
				
				imageAddBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.sizesp_006));
				ModeFlag = 0;
				ArithmeticInit();
			}
			return false;
		}
	}

	class HardBtn implements View.OnTouchListener {
		public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
			if (paramMotionEvent.getAction() == MotionEvent.ACTION_DOWN) {
				imageHardBtn.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.sizesp_005));
			} else if (paramMotionEvent.getAction() == MotionEvent.ACTION_UP) {
				imageHardBtn.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.sizesp_004));
				// MainArithmetic.access$6(this.this$0, 2);
				LevFlag = 2;
				ArithmeticInit();
			}
			return false;
		}
	}

	class EasyBtn implements View.OnTouchListener {
		public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
			if (paramMotionEvent.getAction() == MotionEvent.ACTION_DOWN) {
				imageEasyBtn.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.sizesp_001));
			} else if (paramMotionEvent.getAction() == MotionEvent.ACTION_UP) {
				imageEasyBtn.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.sizesp_000));
				// MainArithmetic.access$6(this.this$0, 0);
				LevFlag = 0;
				ArithmeticInit();
			}
			return false;
		}
	}

	class NorBtn implements View.OnTouchListener {
		public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
			if (paramMotionEvent.getAction() == MotionEvent.ACTION_DOWN) {
				imageNorBtn.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.sizesp_003));
			} else if (paramMotionEvent.getAction() == MotionEvent.ACTION_UP) {
				imageNorBtn.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.sizesp_002));
				// MainArithmetic.access$6(this.this$0, 1);
				LevFlag = 1;
				ArithmeticInit();
			}
			return false;
		}
	}

	/**
	 * 光标处填入数字
	 * @param paramInt
	 */
	public void SetMenuKeyProcess(int paramInt) {
		this.ValidKeyCodeFlag = false;
		switch (paramInt) {
		case 0:
			this.SyskeyCode = 0;
			this.ValidKeyCodeFlag = true;
			break;
		case 1:
			this.SyskeyCode = 1;
			this.ValidKeyCodeFlag = true;
			break;
		case 2:
			this.SyskeyCode = 2;
			this.ValidKeyCodeFlag = true;
			break;
		case 3:
			this.SyskeyCode = 3;
			this.ValidKeyCodeFlag = true;
			break;
		case 4:
			this.SyskeyCode = 4;
			this.ValidKeyCodeFlag = true;
			break;
		case 5:
			this.SyskeyCode = 5;
			this.ValidKeyCodeFlag = true;
			break;
		case 6:
			this.SyskeyCode = 6;
			this.ValidKeyCodeFlag = true;
			break;
		case 7:
			this.SyskeyCode = 7;
			this.ValidKeyCodeFlag = true;
			break;
		case 8:
			this.SyskeyCode = 8;
			this.ValidKeyCodeFlag = true;
			break;
		case 9:
			this.SyskeyCode = 9;
			this.ValidKeyCodeFlag = true;
			break;
		default:
			break;
		}
	}

	public void SetValBit(int paramInt) {
		if (paramInt > 9999) {
			this.ValBit = 5;
			return;
		}
		if (paramInt > 999) {
			this.ValBit = 4;
			return;
		}
		if (paramInt > 99) {
			this.ValBit = 3;
			return;
		}
		if (paramInt > 9) {
			this.ValBit = 2;
			return;
		}
		this.ValBit = 1;
	}

	public boolean SysDelay(int paramInt) {
		int i = 0;
		if (paramInt > 0)
			if (this.SysDelayCount >= paramInt) {
				this.SysDelayCount = 0;
				i = 1;
				return false;
			}
		this.SysDelayCount = (1 + this.SysDelayCount);
		i = 1;
		return true;
	}

	public int UtilRandom(int paramInt1, int paramInt2) {
		return paramInt1 + Math.abs(new Random().nextInt())
				% (paramInt2 - paramInt1);
	}

	public String getUUID(Context paramContext) {
		TelephonyManager localTelephonyManager = (TelephonyManager) paramContext
				.getSystemService("phone");
		String str1 = localTelephonyManager.getDeviceId();
		String str2 = localTelephonyManager.getSimSerialNumber();
		UUID localUUID = new UUID(Settings.Secure.getString(
				paramContext.getContentResolver(), "android_id").hashCode(),
				str1.hashCode() << 32 | str2.hashCode());
		localUUID.toString();
		return localUUID.toString();
	}

	public void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		this.mContext = this;
		requestWindowFeature(1);
		getWindow().setFlags(1024, 1024);
		setContentView(R.layout.add);
		this.ScreenHeight = getWindowManager().getDefaultDisplay().getHeight();
		this.ScreenWidth = getWindowManager().getDefaultDisplay().getWidth();
		this.WordPx = (adjustFontSize(this.ScreenWidth, this.ScreenWidth)
				* this.ScreenWidth / 960);
		this.Height0 = (int) (1.3D * this.WordPx);
		this.Height1 = (int) (2.0D * (1.3D * this.WordPx));
		this.Height2 = (int) (3.0D * (1.3D * this.WordPx));
		this.Height3 = (int) (4.0D * (1.3D * this.WordPx));
		this.Height4 = (int) (5.0D * (1.3D * this.WordPx));
		this.Height5 = (int) (6.0D * (1.3D * this.WordPx));
		this.Height6 = (int) (7.0D * (1.3D * this.WordPx));
		this.Height7 = (int) (8.0D * (1.3D * this.WordPx));
		this.Height8 = (int) (9.0D * (1.3D * this.WordPx));
		this.Height9 = (int) (10.0D * (1.3D * this.WordPx));
		this.Width0 = (1 * this.WordPx);
		this.Width1 = (int) (1.2D * this.WordPx);
		this.Width2 = (int) (1.9D * this.WordPx);
		this.Width3 = (int) (3 * this.WordPx);
		Context localContext1 = this.mContext;
		int[] arrayOfInt1 = new int[9];
		arrayOfInt1[0] = 1;
		arrayOfInt1[1] = 2;
		arrayOfInt1[2] = 3;
		arrayOfInt1[3] = 4;
		arrayOfInt1[4] = 5;
		arrayOfInt1[5] = 6;
		arrayOfInt1[6] = 7;
		arrayOfInt1[7] = 8;
		arrayOfInt1[8] = 9;
		this.MosaicEasy = new Mosaic(localContext1, arrayOfInt1);
		Context localContext2 = this.mContext;
		int[] arrayOfInt2 = new int[10];
		arrayOfInt2[0] = 10;
		arrayOfInt2[1] = 11;
		arrayOfInt2[2] = 12;
		arrayOfInt2[3] = 13;
		arrayOfInt2[4] = 14;
		arrayOfInt2[5] = 15;
		arrayOfInt2[6] = 16;
		arrayOfInt2[7] = 17;
		arrayOfInt2[8] = 18;
		arrayOfInt2[9] = 19;
		this.MosaicNor = new Mosaic(localContext2, arrayOfInt2);
		Context localContext3 = this.mContext;
		int[] arrayOfInt3 = new int[10];
		arrayOfInt3[0] = 100;
		arrayOfInt3[1] = 101;
		arrayOfInt3[2] = 102;
		arrayOfInt3[3] = 103;
		arrayOfInt3[4] = 104;
		arrayOfInt3[5] = 105;
		arrayOfInt3[6] = 106;
		arrayOfInt3[7] = 107;
		arrayOfInt3[8] = 108;
		arrayOfInt3[9] = 109;
		this.MosaicHard = new Mosaic(localContext3, arrayOfInt3);
		this.imageBackBtn = ((ImageButton) findViewById(R.id.imageButton18));
		this.imageBtn0 = ((ImageButton) findViewById(R.id.imageButton8));
		this.imageBtn1 = ((ImageButton) findViewById(R.id.imageButton9));
		this.imageBtn2 = ((ImageButton) findViewById(R.id.imageButton10));
		this.imageBtn3 = ((ImageButton) findViewById(R.id.imageButton11));
		this.imageBtn4 = ((ImageButton) findViewById(R.id.imageButton12));
		this.imageBtn5 = ((ImageButton) findViewById(R.id.imageButton13));
		this.imageBtn6 = ((ImageButton) findViewById(R.id.imageButton14));
		this.imageBtn7 = ((ImageButton) findViewById(R.id.imageButton15));
		this.imageBtn8 = ((ImageButton) findViewById(R.id.imageButton16));
		this.imageBtn9 = ((ImageButton) findViewById(R.id.imageButton17));

		Init();
		SetImageButtonTouchPro();
		SetBackReBackListener();
		this.mThread = new Thread(this);
		this.mIsRunning = true;
		this.mThread.start();
		// try {
		// if (CheckNote()) {
		// Init();
		// SetImageButtonTouchPro();
		// SetBackReBackListener();
		// this.mThread = new Thread(this);
		// this.mIsRunning = true;
		// this.mThread.start();
		// }
		// } catch (Exception localException) {
		// localException.printStackTrace();
		// }
	}

	protected void onDestroy() {
		this.mIsRunning = false;
		super.onDestroy();
	}

	public void processEvaThreed() {
		switch (this.SysThg) {
		case 0:
			this.msg = new Message();
			this.msg.what = 2;
			this.handler.sendMessage(this.msg);
//			this.ValidSetFlag = false;
			break;
		case 1:
			this.GetDataFlag = ScanfGetData(this.ValTotelData, 6, MUL_INPUTDATALINE1);
			if (!this.GetDataFlag)
				break;
			if ((this.ValTotelData == this.GetData) && (this.BitFlag0 > 0)) {
				this.msg = new Message();
				this.msg.what = 1;
				this.handler.sendMessage(this.msg);
				this.DispStr1 = "";
				this.SysThg = DIV_EASY_TOTELDATALINE;
				break;
			}
			this.msg = new Message();
			this.msg.what = SEND_ERROR;
			this.handler.sendMessage(this.msg);
			this.callback_SysThg = this.SysThg;
			this.SysThg = DIV_EASY_QUOTIENT_TRUE;
			this.SysMegs = 3;
			break;
		case 2:
			this.GetDataFlag = ScanfGetData(this.ValOneData, 6, MUL_INPUTDATALINE1);
			if (!this.GetDataFlag)
				break;
			if ((this.ValOneData == this.GetData) && (this.BitFlag0 > 0)) {
				this.msg = new Message();
				this.msg.what = 9;
				this.handler.sendMessage(this.msg);
				this.GetData = 0;
				this.BitFlag0 = 0;
				this.SysThg = 3;
				break;
			}
			this.msg = new Message();
			this.msg.what = SEND_ERROR;
			this.handler.sendMessage(this.msg);
			this.callback_SysThg = this.SysThg;
			this.SysThg = DIV_EASY_QUOTIENT_TRUE;
			this.SysMegs = 8;
			break;
		case 3:
			this.GetDataFlag = ScanfGetData(this.ValTwoData, 10, 11);
			if (!this.GetDataFlag)
				break;
			if ((this.ValTwoData == this.GetData) && (this.BitFlag0 > 0)) {
				if (this.LevFlag == 1) {
					this.SysThg = 5;
					this.msg = new Message();
					this.msg.what = 17;
					this.handler.sendMessage(this.msg);
					this.GetData = 0;
					this.BitFlag0 = 0;
					break;
				} else {
					this.SysThg = 4;
					this.msg = new Message();
					this.msg.what = 13;
					this.handler.sendMessage(this.msg);
					break;
				}
			}
			this.msg = new Message();
			this.msg.what = SEND_ERROR;
			this.handler.sendMessage(this.msg);
			this.callback_SysThg = this.SysThg;
			this.SysThg = DIV_EASY_QUOTIENT_TRUE;
			this.SysMegs = 12;
			break;
		case 4:
			this.GetDataFlag = ScanfGetData(this.ValThirdData, 14, 15);
			if (!this.GetDataFlag)
				break;
			if ((this.ValThirdData == this.GetData) && (this.BitFlag0 > 0)) {
				this.msg = new Message();
				this.msg.what = 17;
				this.handler.sendMessage(this.msg);
				this.SysThg = 5;
				this.GetData = 0;
				this.BitFlag0 = 0;
				break;
			}
			this.msg = new Message();
			this.msg.what = SEND_ERROR;
			this.handler.sendMessage(this.msg);
			this.callback_SysThg = this.SysThg;
			this.SysThg = DIV_EASY_QUOTIENT_TRUE;
			this.SysMegs = 16;
			break;
		case 5:
			this.GetDataFlag = ScanfGetData(this.ValTotelData, 18, 19);
			if (!this.GetDataFlag)
				break;
			if ((this.ValTotelData == this.GetData) && (this.BitFlag0 > 0)) {
				this.msg = new Message();
				this.msg.what = 21;
				this.handler.sendMessage(this.msg);
				this.SysThg = DIV_EASY_TOTELDATALINE;
				this.GetData = 0;
				this.OpenAndCloseKeyFlag = false;
				break;
			}
			this.msg = new Message();
			this.msg.what = SEND_ERROR;
			this.handler.sendMessage(this.msg);
			this.callback_SysThg = this.SysThg;
			this.SysThg = DIV_EASY_QUOTIENT_TRUE;
			this.SysMegs = 20;
			break;
		case 6:
			this.GetDataFlag = ScanfGetData(this.QuotientData0, DIV_EASY_QUOTIENT, DIV_EASY_QUOTIENT);
			if (!this.GetDataFlag)
				break;
			if ((this.QuotientData0 == this.GetData) && (this.BitFlag0 > 0)) {
				this.msg = new Message();
				this.msg.what = DIV_EASY_QUOTIENT_TRUE;
				this.handler.sendMessage(this.msg);
				this.BitFlag0 = 0;
				this.SyskeyCode = 0;
				this.GetData = 0;
				this.SysThg = MUL_INPUTDATALINE1;
				break;
			}
			this.msg = new Message();
			this.msg.what = SEND_ERROR;
			this.handler.sendMessage(this.msg);
			this.callback_SysThg = this.SysThg;
			this.SysThg = DIV_EASY_QUOTIENT_TRUE;
			this.SysMegs = DIV_EASY_QUOTIENT_ERROR;
			break;
		case MUL_INPUTDATALINE1:
			this.GetDataFlag = ScanfGetData(this.ValOneData, DIV_EASY_TOTELDATA, DIV_EASY_TOTELDATALINE);
			if (!this.GetDataFlag)
				break;
			if ((this.ValOneData == this.GetData) && (this.BitFlag0 > 0)) {
				this.msg = new Message();
				this.msg.what = DIV_EASY_TOTELDATA_TRUE;
				this.handler.sendMessage(this.msg);
				this.BitFlag0 = 0;
				this.SyskeyCode = 0;
				this.GetData = 0;
				this.SysThg = 8;
				break;
			}
			this.msg = new Message();
			this.msg.what = SEND_ERROR;
			this.handler.sendMessage(this.msg);
			this.callback_SysThg = this.SysThg;
			this.SysThg = DIV_EASY_QUOTIENT_TRUE;
			this.SysMegs = DIV_EASY_TOTELDATALINE;
			break;
		case 8:
			this.GetDataFlag = ScanfGetData(this.RemainderData1, DIV_EASY_REMAINDER, DIV_EASY_REMAINDER);
			if (!this.GetDataFlag)
				break;
			if ((this.RemainderData1 == this.GetData) && (this.BitFlag0 > 0)) {
				this.msg = new Message();
				this.msg.what = DIV_EASY_REMAINDER_TRUE;
				this.handler.sendMessage(this.msg);
				this.BitFlag0 = 0;
				this.SysThg = DIV_EASY_TOTELDATALINE;
				this.GetData = 0;
				this.OpenAndCloseKeyFlag = false;
				break;
			}
			this.msg = new Message();
			this.msg.what = SEND_ERROR;
			this.handler.sendMessage(this.msg);
			this.callback_SysThg = this.SysThg;
			this.SysThg = DIV_EASY_QUOTIENT_TRUE;
			this.SysMegs = DIV_EASY_REMAINDER_ERROR;
			break;
		case 9:
			this.GetDataFlag = ScanfGetData(this.QuotientData0, 32, 32);
			if (!this.GetDataFlag)
				break;
			if ((this.QuotientData0 == this.GetData) && (this.BitFlag0 > 0)) {
				this.msg = new Message();
				this.msg.what = 34;
				this.handler.sendMessage(this.msg);
				this.BitFlag0 = 0;
				this.SyskeyCode = 0;
				this.GetData = 0;
				this.SysThg = 10;
				break;
			}
			this.msg = new Message();
			this.msg.what = SEND_ERROR;
			this.handler.sendMessage(this.msg);
			this.callback_SysThg = this.SysThg;
			this.SysThg = DIV_EASY_QUOTIENT_TRUE;
			this.SysMegs = 33;
			break;
		case 10:
			this.GetDataFlag = ScanfGetData(this.ValOneData, 36, 35);
			if (!this.GetDataFlag)
				break;
			if ((this.ValOneData == this.GetData) && (this.BitFlag0 > 0)) {
				this.msg = new Message();
				this.msg.what = 38;
				this.handler.sendMessage(this.msg);
				this.BitFlag0 = 0;
				this.SyskeyCode = 0;
				this.GetData = 0;
				this.SysThg = 11;
				break;
			}
			this.msg = new Message();
			this.msg.what = SEND_ERROR;
			this.handler.sendMessage(this.msg);
			this.callback_SysThg = this.SysThg;
			this.SysThg = DIV_EASY_QUOTIENT_TRUE;
			this.SysMegs = 37;
			break;
		case 11:
			this.GetDataFlag = ScanfGetData(this.RemainderData0, DIV_NOR_REMAINDER1, 39);
			if (!this.GetDataFlag)
				break;
			if ((this.RemainderData0 == this.GetData) && (this.BitFlag0 > 0)) {
				this.msg = new Message();
				this.msg.what = DIV_NOR_REMAINDER1_TRUE;
				this.handler.sendMessage(this.msg);
				this.BitFlag0 = 0;
				this.SysThg = 12;
				this.GetData = 0;
				break;
			}
			this.msg = new Message();
			this.msg.what = SEND_ERROR;
			this.handler.sendMessage(this.msg);
			this.callback_SysThg = this.SysThg;
			this.SysThg = DIV_EASY_QUOTIENT_TRUE;
			this.SysMegs = DIV_NOR_REMAINDER1_ERROR;
			break;
		case 12://除法除号上个位
			this.GetDataFlag = ScanfGetData(this.QuotientData1, 43, 43);
			if (!this.GetDataFlag)
				break;
			if ((this.QuotientData1 == this.GetData) && (this.BitFlag0 > 0)) {
				this.msg = new Message();
				this.msg.what = 45;
				this.handler.sendMessage(this.msg);
				this.BitFlag0 = 0;
				this.SyskeyCode = 0;
				this.GetData = 0;
				this.SysThg = 13;
				break;
			}
			this.msg = new Message();
			this.msg.what = SEND_ERROR;
			this.handler.sendMessage(this.msg);
			this.callback_SysThg = this.SysThg;
			this.SysThg = DIV_EASY_QUOTIENT_TRUE;
			this.SysMegs = 44;
			break;
		case 13:
			this.GetDataFlag = ScanfGetData(this.ValTwoData, 47, 46);
			if (!this.GetDataFlag)
				break;
			if ((this.ValTwoData == this.GetData) && (this.BitFlag0 > 0)) {
				this.msg = new Message();
				this.msg.what = 49;
				this.handler.sendMessage(this.msg);
				this.BitFlag0 = 0;
				this.SyskeyCode = 0;
				this.GetData = 0;
				this.SysThg = 14;
				break;
			}
			this.msg = new Message();
			this.msg.what = SEND_ERROR;
			this.handler.sendMessage(this.msg);
			this.callback_SysThg = this.SysThg;
			this.SysThg = DIV_EASY_QUOTIENT_TRUE;
			this.SysMegs = 48;
			break;
		case 14:
			this.GetDataFlag = ScanfGetData(this.RemainderData1, 50, 50);
			if (!this.GetDataFlag)
				break;
			if ((this.RemainderData1 == this.GetData) && (this.BitFlag0 > 0)) {
				this.msg = new Message();
				this.msg.what = 52;
				this.handler.sendMessage(this.msg);
				this.BitFlag0 = 0;
				this.SysThg = DIV_EASY_TOTELDATALINE;
				this.GetData = 0;
				this.OpenAndCloseKeyFlag = false;
				break;
			}
			this.msg = new Message();
			this.msg.what = SEND_ERROR;
			this.handler.sendMessage(this.msg);
			this.callback_SysThg = this.SysThg;
			this.SysThg = DIV_EASY_QUOTIENT_TRUE;
			this.SysMegs = 51;
			break;
		case 15:
			this.GetDataFlag = ScanfGetData(this.QuotientData0, DIV_HARD_QUOTIENT1, DIV_HARD_QUOTIENT1);
			if (!this.GetDataFlag)
				break;
			if ((this.QuotientData0 == this.GetData) && (this.BitFlag0 > 0)) {
				this.msg = new Message();
				this.msg.what = DIV_HARD_QUOTIENT1_TRUE;
				this.handler.sendMessage(this.msg);
				this.BitFlag0 = 0;
				this.SyskeyCode = 0;
				this.GetData = 0;
				this.SysThg = 16;
				break;
			}
			this.msg = new Message();
			this.msg.what = SEND_ERROR;
			this.handler.sendMessage(this.msg);
			this.callback_SysThg = this.SysThg;
			this.SysThg = DIV_EASY_QUOTIENT_TRUE;
			this.SysMegs = DIV_HARD_QUOTIENT1_ERROR;
			break;
		case 16:
			this.GetDataFlag = ScanfGetData(this.ValOneData, DIV_HARD_TOTELDATA1, DIV_HARD_TOTELDATALINE1);
			if (!this.GetDataFlag)
				break;
			if ((this.ValOneData == this.GetData) && (this.BitFlag0 > 0)) {
				this.msg = new Message();
				this.msg.what = DIV_HARD_TOTELDATA1_TRUE;
				this.handler.sendMessage(this.msg);
				this.BitFlag0 = 0;
				this.SyskeyCode = 0;
				this.GetData = 0;
				this.SysThg = 17;
				break;
			}
			this.msg = new Message();
			this.msg.what = SEND_ERROR;
			this.handler.sendMessage(this.msg);
			this.callback_SysThg = this.SysThg;
			this.SysThg = DIV_EASY_QUOTIENT_TRUE;
			this.SysMegs = DIV_HARD_TOTELDATA1_ERROR;
			break;
		case 17:
			this.GetDataFlag = ScanfGetData(this.RemainderData0, DIV_HARD_REMAINDER1, DIV_HARD_REMAINDERLINE1);
			if (!this.GetDataFlag)
				break;
			if ((this.RemainderData0 == this.GetData) && (this.BitFlag0 > 0)) {
				this.msg = new Message();
				this.msg.what = DIV_HARD_REMAINDER1_TRUE;
				this.handler.sendMessage(this.msg);
				this.BitFlag0 = 0;
				this.SysThg = 18;
				this.GetData = 0;
				break;
			}
			this.msg = new Message();
			this.msg.what = SEND_ERROR;
			this.handler.sendMessage(this.msg);
			this.callback_SysThg = this.SysThg;
			this.SysThg = DIV_EASY_QUOTIENT_TRUE;
			this.SysMegs = DIV_HARD_REMAINDER1_ERROR;
			break;
		case 18://除法困难根号上第二位
			this.GetDataFlag = ScanfGetData(this.QuotientData1, DIV_HARD_QUOTIENT2, DIV_HARD_QUOTIENT2);
			if (!this.GetDataFlag)
				break;
			if ((this.QuotientData1 == this.GetData) && (this.BitFlag0 > 0)) {
				this.msg = new Message();
				this.msg.what = DIV_HARD_QUOTIENT2_TRUE;
				this.handler.sendMessage(this.msg);
				this.BitFlag0 = 0;
				this.SyskeyCode = 0;
				this.GetData = 0;
				this.SysThg = 19;
				break;
			}
			this.msg = new Message();
			this.msg.what = SEND_ERROR;
			this.handler.sendMessage(this.msg);
			this.callback_SysThg = this.SysThg;
			this.SysThg = DIV_EASY_QUOTIENT_TRUE;
			this.SysMegs = DIV_HARD_QUOTIENT2_ERROR;
			break;
		case 19:
			this.GetDataFlag = ScanfGetData(this.ValTwoData, DIV_HARD_TOTELDATA2, DIV_HARD_TOTELDATA2);
			if (!this.GetDataFlag)
				break;
			if ((this.ValTwoData == this.GetData) && (this.BitFlag0 > 0)) {
				this.msg = new Message();
				this.msg.what = DIV_HARD_TOTELDATA2_TRUE;
				this.handler.sendMessage(this.msg);
				this.BitFlag0 = 0;
				this.SyskeyCode = 0;
				this.GetData = 0;
				this.SysThg = 20;
				break;
			}
			this.msg = new Message();
			this.msg.what = SEND_ERROR;
			this.handler.sendMessage(this.msg);
			this.callback_SysThg = this.SysThg;
			this.SysThg = DIV_EASY_QUOTIENT_TRUE;
			this.SysMegs = DIV_HARD_TOTELDATA2_ERROR;
			break;
		case 20://除法困难除号最后一位
			this.GetDataFlag = ScanfGetData(this.RemainderData1, DIV_HARD_REMAINDER2, DIV_HARD_REMAINDERLINE2);
			if (!this.GetDataFlag)
				break;
			if ((this.RemainderData1 == this.GetData) && (this.BitFlag0 > 0)) {
				this.msg = new Message();
				this.msg.what = DIV_HARD_REMAINDER2_TRUE;
				this.handler.sendMessage(this.msg);
				this.BitFlag0 = 0;
				this.SysThg = 21;
				this.GetData = 0;
				break;
			}
			this.msg = new Message();
			this.msg.what = SEND_ERROR;
			this.handler.sendMessage(this.msg);
			this.callback_SysThg = this.SysThg;
			this.SysThg = DIV_EASY_QUOTIENT_TRUE;
			this.SysMegs = DIV_HARD_REMAINDER2_ERROR;
			break;
		case 21:
			this.GetDataFlag = ScanfGetData(this.QuotientData2, DIV_HARD_QUOTIENT3, DIV_HARD_QUOTIENT3);
			if (!this.GetDataFlag)
				break;
			if ((this.QuotientData2 == this.GetData) && (this.BitFlag0 > 0)) {
				this.msg = new Message();
				this.msg.what = DIV_HARD_QUOTIENT3_TRUE;
				this.handler.sendMessage(this.msg);
				this.BitFlag0 = 0;
				this.SyskeyCode = 0;
				this.GetData = 0;
				this.SysThg = DIV_EASY_QUOTIENT;
				break;
			}
			this.msg = new Message();
			this.msg.what = SEND_ERROR;
			this.handler.sendMessage(this.msg);
			this.callback_SysThg = this.SysThg;
			this.SysThg = DIV_EASY_QUOTIENT_TRUE;
			this.SysMegs = DIV_HARD_QUOTIENT3_ERROR;
			break;
		case DIV_EASY_QUOTIENT:
			this.GetDataFlag = ScanfGetData(this.ValThirdData, DIV_HARD_TOTELDATA3, DIV_HARD_TOTELDATALINE3);
			if (!this.GetDataFlag)
				break;
			if ((this.ValThirdData == this.GetData) && (this.BitFlag0 > 0)) {
				this.msg = new Message();
				this.msg.what = DIV_HARD_TOTELDATA3_TRUE;
				this.handler.sendMessage(this.msg);
				this.BitFlag0 = 0;
				this.SyskeyCode = 0;
				this.GetData = 0;
				this.SysThg = DIV_EASY_QUOTIENT_ERROR;
				break;
			}
			this.msg = new Message();
			this.msg.what = SEND_ERROR;
			this.handler.sendMessage(this.msg);
			this.callback_SysThg = this.SysThg;
			this.SysThg = DIV_EASY_QUOTIENT_TRUE;
			this.SysMegs = DIV_HARD_TOTELDATA3_ERROR;
			break;
		case DIV_EASY_QUOTIENT_ERROR:
			this.GetDataFlag = ScanfGetData(this.RemainderData2, DIV_HARD_REMAINDER3, DIV_HARD_REMAINDER3);
			if (!this.GetDataFlag)
				break;
			if ((this.RemainderData2 == this.GetData) && (this.BitFlag0 > 0)) {
				this.msg = new Message();
				this.msg.what = DIV_HARD_REMAINDER3_TRUE;
				this.handler.sendMessage(this.msg);
				this.BitFlag0 = 0;
				this.SysThg = DIV_EASY_TOTELDATALINE;
				this.GetData = 0;
				break;
			}
			this.msg = new Message();
			this.msg.what = SEND_ERROR;
			this.handler.sendMessage(this.msg);
			this.callback_SysThg = this.SysThg;
			this.SysThg = DIV_EASY_QUOTIENT_TRUE;
			this.SysMegs = DIV_HARD_REMAINDER3_ERROR;
			break;
		case DIV_EASY_QUOTIENT_TRUE:
			if (SysDelay(10)) {
				while(mediaPlayer.isPlaying()){
					continue;
				}
				this.GetData = 0;
				this.DispStr1 = "";
				this.BitFlag0 = 0;
				this.GetDataFlag = false;
				this.SysThg = this.callback_SysThg;
				this.msg = new Message();
				this.msg.what = this.SysMegs;
				this.handler.sendMessage(this.msg);
			}
			this.ValidKeyCodeFlag = false;
			break;
		case DIV_EASY_TOTELDATALINE:
			if (!SysDelay(15))
				break;
			while(mediaPlayer.isPlaying()){
				continue;
			}
			this.msg = new Message();
			this.msg.what = 2;
			this.handler.sendMessage(this.msg);
//			this.ValidSetFlag = false;
			break;
		default:
			break;
		}
	}

	public void produceDiv() {
		this.SyskeyCode = 0;
		this.BitFlag0 = 0;
		this.DispStr1 = "";
		if (this.LevFlag == 0) {
			setContentView(R.layout.div);
			DivEasyPro();
			return;
		}
		if (this.LevFlag == 1) {
			setContentView(R.layout.divn);
			DivNorPro();
			return;
		}
		setContentView(R.layout.divh);
		DivHardPro();
	}

	public void produceMul() {
		this.SyskeyCode = 0;
		this.BitFlag0 = 0;
		this.DispStr1 = "";
		if (this.LevFlag == 0) {
			setContentView(R.layout.add);
			MulsEasyPro();
			return;
		}
		if (this.LevFlag == 1) {
			setContentView(R.layout.numn);
			MulsNorPro();
			return;
		}
		setContentView(R.layout.mulh);
		MulsHardPro();
	}

	public void produceSub() {
		int i = ProduceSummandAndAddMosaic();
		int j = ProduceSummandAndAdd();
		this.OneData = (i + j);
		this.TwoData = j;
		this.ValTotelData = i;
		TextView localTextView1 = (TextView) findViewById(R.id.AddOne1);
		this.rect.left = 0;
		this.rect.right = (512 * this.ScreenWidth / 960 - this.Width2);
		this.rect.top = (176 * this.ScreenHeight / 1280 + this.Height0);
		this.rect.bottom = (1104 * this.ScreenHeight / 1280 - this.Height1);
		localTextView1.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		localTextView1.setTextSize(0, this.WordPx);
		localTextView1.setText(this.OneData + "");
		TextView localTextView2 = (TextView) findViewById(R.id.AddTwo2);
		this.rect.left = 0;
		this.rect.right = (512 * this.ScreenWidth / 960 - this.Width2);
		this.rect.top = (176 * this.ScreenHeight / 1280 + this.Height1);
		this.rect.bottom = (1104 * this.ScreenHeight / 1280 - this.Height2);
		localTextView2.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		localTextView2.setTextSize(0, this.WordPx);
		localTextView2.setText(this.TwoData + "");
		this.SubSingle = ((TextView) findViewById(R.id.textView1));
		this.rect.left = (256 * this.ScreenWidth / 960);
		this.rect.right = (448 * this.ScreenWidth / 960);
		this.rect.top = (176 * this.ScreenHeight / 1280 + this.Height1);
		this.rect.bottom = (1104 * this.ScreenHeight / 1280 - this.Height2);
		this.SubSingle.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		this.SubSingle.setTextSize(0, this.WordPx);
		this.SubSingle.setText("-  ");
		this.viewLine1 = ((ImageView) findViewById(R.id.AddLineQue));
		this.rect.left = (224 * this.ScreenWidth / 960);
		this.rect.right = (112 * this.ScreenWidth / 960);
		this.rect.top = (10 + (176 * this.ScreenHeight / 1280 + this.Height2));
		this.rect.bottom = (-14 + (1104 * this.ScreenHeight / 1280 - this.Height2));
		((ViewGroup.MarginLayoutParams) this.viewLine1.getLayoutParams())
				.setMargins(this.rect.left, this.rect.top, this.rect.right,
						this.rect.bottom);
		SetValBit(this.ValTotelData);
		this.totelDataText = ((TextView) findViewById(R.id.AddTotel1));
		this.rect.left = 0;
		this.rect.right = (512 * this.ScreenWidth / 960 - this.Width2);
		this.rect.top = (14 + (176 * this.ScreenHeight / 1280 + this.Height2));
		this.rect.bottom = (-14 + (1104 * this.ScreenHeight / 1280 - this.Height3));
		this.totelDataText.setPadding(this.rect.left, this.rect.top,
				this.rect.right, this.rect.bottom);
		this.totelDataText.setTextSize(0, this.WordPx);
		this.totelDataText.setText("_");
		this.SyskeyCode = 0;
		this.BitFlag0 = 0;
		this.DispStr1 = "";
		this.SysThg = 1;
	}

	public void run() {
		while (true) {
			if (!this.mIsRunning)
				return;
			processEvaThreed();
			CloseToast(2);
			try {
				Thread.sleep(200L);
			} catch (InterruptedException localInterruptedException) {
				localInterruptedException.printStackTrace();
			}
		}
	}

	void setRebackAriEqu() {
		this.SyskeyCode = 0;
		this.BitFlag0 = 0;
		this.DispStr1 = "";
		System.out.println(ValidSetFlag);
		this.ValidKeyCodeFlag = false;
		if(ValidSetFlag){
			ValidSetFlag = false;
			return;
		}
		switch (this.ModeFlag) {
		case 0:
			ProduceAdd();
			break;
		case 1:
			produceSub();
			break;
		case 2:
			if (this.LevFlag == 0) {
				MulsEasyPro();
				break;
			}
			if (this.LevFlag == 1) {
				MulsNorPro();
				break;
			}
			MulsHardPro();
			break;
		case 3:
			if (this.LevFlag == 0) {
				DivEasyPro();
				break;
			}
			if (this.LevFlag == 1) {
				DivNorPro();
				break;
			}
			DivHardPro();
			break;
		default:
			break;
		}

	}

}