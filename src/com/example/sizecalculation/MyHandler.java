package com.example.sizecalculation;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

public class MyHandler extends Handler {
	private MainActivity context;

	public MyHandler(MainActivity context) {
		this.context = context;
	}

	public void handleMessage(Message paramMessage) {
		System.out.println("paramMessage.what:"+paramMessage.what);
		switch (paramMessage.what) {
		case 1:
			context.totelDataText.setText(context.GetData+"");
			context.SetGood();
			break;
		case 2:
			context.setRebackAriEqu();
			break;
		case 3:
			context.totelDataText.setText("_");
			break;
		case 4:
			context.totelDataText.setText(context.DispStr1);
			break;
		case 5:
			context.totelDataText.setText("_" + context.DispStr1);
			break;
		case 6:
			context.totelDataText.setText(context.DispStr1);
			break;
		case 7:
			context.totelDataText.setText("_" + context.DispStr1);
			break;
		case 8:
			context.totelDataText.setText("_");
			break;
		case 9:
			context.totelDataText1.setText("_ ");
			context.DispStr1 = "";
			break;
		case 10:
			context.totelDataText1.setText(context.DispStr1 + " ");
			break;
		case 11:
			context.totelDataText1.setText("_" + context.DispStr1 + " ");
			break;
		case 12:
			context.totelDataText1.setText("_ ");
			break;
		case 13:
			context.totelDataText2.setText("_  ");
			context.DispStr1 = "";
			break;
		case 14:
			context.totelDataText2.setText(context.DispStr1 + "  ");
			break;
		case 15:
			context.totelDataText2.setText("_" + context.DispStr1 + "  ");
			break;
		case 16:
			context.totelDataText2.setText("_  ");
			break;
		case 17:
			context.viewLine2.setVisibility(0);
			context.totelDataText3.setText("_");
			context.DispStr1 = "";
			break;
		case 18:
			context.totelDataText3.setText(context.DispStr1);
			break;
		case 19:
			context.totelDataText3.setText("_" + context.DispStr1);
			break;
		case 20:
			context.totelDataText3.setText("_");
			break;
		case 21:
//			context.totelDataText3.setText(MainActivity.access$0(context));
			context.SetGood();
			break;
		case 22:
			context.totelDataText.setText(context.DispStr1);
			break;
		case 23:
			context.totelDataText.setText("_");
			break;
		case 24:
			context.totelDataText1.setText("_");
			context.DispStr1 = "";
			break;
		case 25:
			context.totelDataText1.setText("_" + context.DispStr1);
			break;
		case 26:
			context.totelDataText1.setText(context.DispStr1);
			break;
		case 27:
			context.totelDataText1.setText("_");
			break;
		case 28:
			context.imageButtonLine.setVisibility(0);
			context.totelDataText2.setText("_");
			context.DispStr1 = "";
			break;
		case 29:
			context.totelDataText2.setText(context.DispStr1);
			break;
		case 30:
			context.totelDataText2.setText("_");
			break;
		case 31:
//			context.totelDataText2.setText(MainActivity.access$1(context));
			context.SetGood();
			break;
		case 32://简单除法第一位
			context.totelDataText.setText(context.DispStr1 + " ");
			break;
		case 33:
			context.totelDataText.setText("_ ");
			break;
		case 34:
			context.totelDataText1.setText("_ ");
			context.DispStr1 = "";
			break;
		case 35:
			context.totelDataText1.setText("_" + context.DispStr1 + " ");
			break;
		case 36:
			context.totelDataText1.setText(context.DispStr1 + " ");
			break;
		case 37:
			context.totelDataText1.setText("_ ");
			break;
		case 38:
			context.imageButtonLine.setVisibility(0);
			context.totelDataText2.setText("_");
			context.DispStr1 = "";
			break;
		case 40://除法普通 第5个数
			context.totelDataText2.setText(context.DispStr1);
			break;
		case 39://除法普通 第4个数
			context.totelDataText2.setText("_" + context.DispStr1);
			break;
			
		case 41:
			context.totelDataText2.setText("_");
			break;
			
		case 42://除法普通第6个数
//			context.totelDataText.setText(MainActivity.access$2(context)
//					+ "_");
			context.totelDataText.setText(context.totelDataText.getText().toString().substring(0, 1)+ "_");
			context.DispStr1 = "";
			break;
		
		case 43:
			context.totelDataText.setText(context.totelDataText.getText().toString().substring(0, 1)
					+ context.DispStr1);
			break;
			
		case 44:
			context.totelDataText.setText(context.totelDataText.getText().toString().substring(0, 1)
					+ "_");
			break;
			
		case 45:
			context.totelDataText3.setText("_");
			context.DispStr1 = "";
			break;
		case 46:
			context.totelDataText3.setText("_" + context.DispStr1);
			break;
			
		case 47:
			context.totelDataText3.setText(context.DispStr1);
			break;
			
		case 48:
			context.totelDataText3.setText("_");
			break;
			
		case 49:
			context.imageButtonLine1.setVisibility(0);
			context.totelDataText4.setText("_");
			context.DispStr1 = "";
			break;
			
		case 50:
			context.totelDataText4.setText(context.DispStr1);
			break;
			
		case 51:
			context.totelDataText4.setText("_");
			break;
			
		case 52://除法普通最后一位
			context.totelDataText4.setText("答对了");
//			context.totelDataText4.setText(MainActivity.access$1(context));
			context.SetGood();
			break;
			
		case 53:
			context.totelDataText.setText(context.DispStr1 + "  ");
			break;
			
		case 54:
			context.totelDataText.setText("_  ");
			break;
			
		case 55:
			context.totelDataText1.setText("_  ");
			context.DispStr1 = "";
			break;
			
		case 56:
			context.totelDataText1.setText("_" + context.DispStr1 + "  ");
			break;
			
		case 57:
			context.totelDataText1.setText(context.DispStr1 + "  ");
			break;
			
		case 58:
			context.totelDataText1.setText("_  ");
			break;
			
		case 59:
			context.imageButtonLine.setVisibility(0);
			context.totelDataText2.setText("_ ");
			context.DispStr1 = "";
			break;
			
		case 60://除法困难 第六个数
			context.totelDataText2.setText(context.DispStr1 + " ");
			break;
			
		case 61://除法困难 第五个数
			context.totelDataText2.setText("_" + context.DispStr1 + " ");
			break;
		case 62:
			context.totelDataText2.setText("_ ");
			break;
			
		case 63://除法困难第7个数
			context.DispStr2=context.totelDataText.getText().toString().trim();
			context.totelDataText.setText(context.DispStr2+ "_ ");
			context.DispStr1 = "";
			break;
			
		case 64://除法困难第七位
			context.totelDataText.setText(context.DispStr2.substring(0, 1)
					+ context.DispStr1 + " ");
			context.DispStr2 = context.totelDataText.getText().toString().trim();
			break;
			
		case 65://除法困难第七位输入错误 返回 *_
			context.totelDataText.setText(context.DispStr2.substring(0, 1)
					+ "_ ");
			break;
			
		case 66:
			context.totelDataText3.setText("_ ");
			context.DispStr1 = "";
			break;
			
		case 67:
			context.totelDataText3.setText("_" + context.DispStr1 + " ");
			break;
			
		case 68:
			context.totelDataText3.setText(context.DispStr1 + " ");
			break;
			
		case 69:
			context.totelDataText3.setText("_ ");
			break;
			
		case 70:
			context.imageButtonLine1.setVisibility(0);
			context.totelDataText4.setText("_");
			context.DispStr1 = "";
			break;
		case 71://除法困难第11位 
			context.totelDataText4.setText(context.DispStr1);
			break;
		
		case 72:
			context.totelDataText4.setText("_" + context.DispStr1);
			break;
			
		case 73:
			context.totelDataText4.setText("_");
			break;
			
		case 74://除法困难第12位 即除号上 10_
//			context.totelDataText.setText(MainActivity.access$2(context)
//					+ MainActivity.access$3(context) + "_");
			context.totelDataText.setText(context.DispStr2 + "_");
			context.DispStr1 = "";
			break;
			
		case 75:
//			context.totelDataText.setText(MainActivity.access$2(context)
//					+ MainActivity.access$3(context) + context.DispStr1);
			context.totelDataText.setText(context.DispStr2 + context.DispStr1);
			break;
			
		case 76:
			context.totelDataText.setText(context.totelDataText.getText().toString().substring(0, 2) + "_");
			break;
			
		case 77:
			context.totelDataText5.setText("_");
			context.DispStr1 = "";
			break;
			
		case 78:
			context.totelDataText5.setText("_" + context.DispStr1);
			break;
			
		case 79:
			context.totelDataText5.setText(context.DispStr1);
			break;
		case 80:
			context.totelDataText5.setText("_");
			break;
		case 81:
			context.imageButtonLine2.setVisibility(0);
			context.totelDataText6.setText("_");
			context.DispStr1 = "";
			break;
		case 82:
			context.totelDataText6.setText(context.DispStr1);
			break;
		case 83:
			context.totelDataText6.setText("_");
			break;
		case 84:
//			context.totelDataText6.setText(MainActivity.access$4(context));
			context.SetGood();
			break;
		case 85:
			context.SetErrorReset();
			break;
		default:
			break;
		}
		super.handleMessage(paramMessage);
	}
}
