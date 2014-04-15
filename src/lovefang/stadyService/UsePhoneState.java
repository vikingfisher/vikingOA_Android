package lovefang.stadyService;
/**引入包*/
	import android.os.Bundle;
	import android.app.Activity;
	import android.app.Service;
	import android.view.View;
	import android.widget.Button;
	import android.widget.TextView;
	import android.content.ContentResolver;//This class provides applications access to the content model.
	import android.telephony.TelephonyManager;
	import android.util.Log;
/**获取手机的状态*/
	public class UsePhoneState extends Activity{
			/**创建参数*/
		private ContentResolver cr;
		private Button getStateButton;// 用来获取用户的手机状态
			/**创建Activity*/
		public void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);
			setContentView(R.layout.usephonestate);
			
			cr = getContentResolver();
			Log.v("UsePhonestate","cr = getContentResolver()");
			Log.v("UsePhonestate","setContentView");
			getStateButton = (Button) findViewById(R.id.button_getphonestate);
			Log.v("UsePhonestate","getStateButton");
			getStateButton.setOnClickListener(getState);
			Log.v("UsePhonestate","getStateButton.setOnClickListener");
		}
		private Button.OnClickListener getState = new Button.OnClickListener(){
			public void onClick(View view){
					/**获得TelephonyManager对象*/
				TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Service.TELEPHONY_SERVICE);
					/**获取电信网络级别*/
				String teleCode = telephonyManager.getNetworkCountryIso();
					/**获取电信网络公司代码*/
				String teleComCode = telephonyManager.getNetworkOperator();
					/**获取电信网络公司名称*/
				String teleComName = telephonyManager.getNetworkOperatorName();
					/**获取行动通信类型*/
				int TypeCode = telephonyManager.getPhoneType();
				
				String type = "";
				
				switch(TypeCode){
					case TelephonyManager.PHONE_TYPE_NONE:
						type = "PHONE_TYPE_NONE";
						break;
					case TelephonyManager.PHONE_TYPE_GSM:
						type = "PHONE_TYPE_GSM";
						break;
					case TelephonyManager.PHONE_TYPE_CDMA:
						type = "PHONE_TYPE_CDMA";
						break;
				}
					/**获取网络类型*/
				int netTypeCode = telephonyManager.getNetworkType();
				String netType = "NETWORK_TYPE_UNKNOW";
				switch(netTypeCode){
					case TelephonyManager.NETWORK_TYPE_1xRTT:
						netType = "NETWORK_TYPE_1xRTT";
						break;
					case TelephonyManager.NETWORK_TYPE_CDMA:
						netType = "NETWORK_TYPE_CDMA";
						break;
					case TelephonyManager.NETWORK_TYPE_EDGE:
						netType = "NETWORK_TYPE_EDGE";
						break;
					case TelephonyManager.NETWORK_TYPE_EVDO_0:
						netType = "NETWORK_TYPE_EVDO_0";
						break;
					case TelephonyManager.NETWORK_TYPE_EVDO_A:
						netType = "NETWORK_TYPE_EVDO_A";
						break;
					case TelephonyManager.NETWORK_TYPE_GPRS:
						netType = "NETWORK_TYPE_GPRS";
						break;
					case TelephonyManager.NETWORK_TYPE_HSDPA:
						netType = "NETWORK_TYPE_HSDPA";
						break;
					case TelephonyManager.NETWORK_TYPE_HSPA:
						netType = "NETWORK_TYPE_HSPA";
						break;
					case TelephonyManager.NETWORK_TYPE_HSUPA:
						netType = "NETWORK_TYPE_HSUPA";
						break;
					case TelephonyManager.NETWORK_TYPE_IDEN:
						netType = "NETWORK_TYPE_IDEN";
						break;
					case TelephonyManager.NETWORK_TYPE_UMTS:
						netType = "NETWORK_TYPE_UMTS";
						break;
					default:
						break;
				}
				
					/**获取漫游状态*/
				boolean roamStatusCode = telephonyManager.isNetworkRoaming();
				String roamStatus = "NOT ROAMINF";
				if(roamStatusCode){
					roamStatus = "ROAMING";
				}
				
					/**获取手机唯一标识*/
				String imei = telephonyManager.getDeviceId();
					/**获取手机IMEI SV*/
				String imeiSV = telephonyManager.getDeviceSoftwareVersion();
					/**获取手机IMSI*/
				String imsi = telephonyManager.getSubscriberId();
				
					/**蓝牙服务*/
				String statusCode = android.provider.Settings.System.getString(cr,
						android.provider.Settings.System.BLUETOOTH_ON);
				String bulettothStatus = "";
				if(statusCode.equals("1")){
					bulettothStatus = "ENABLE";
				}else{
					bulettothStatus = "DISABLE";
				}
				
					/**飞行模式是否打开*/
				statusCode = android.provider.Settings.System.getString(cr,
						android.provider.Settings.System.AIRPLANE_MODE_ON);
				
				String AirplaneStatus = "";
				if(statusCode.equals("1")){
					AirplaneStatus = "ENABLE";
				}else{
					AirplaneStatus = "DISABLE";
				}
				
					/**数据漫游模式是否打开*/
				statusCode = android.provider.Settings.System.getString(cr,
						android.provider.Settings.System.DATA_ROAMING);
				String dataRoamStatus = "";
				if(statusCode.equals("1")){
					dataRoamStatus = "ENABLE";
				}else{
					dataRoamStatus = "DISABLE";
				}
				TextView txt = (TextView) findViewById(R.id.text_showphonestate);
				StringBuilder sb = new StringBuilder();
				sb.append("teleCode: "+teleCode+"\n");
				sb.append("teleComCode: "+teleComCode+"\n");
				sb.append("teleComName: "+teleComName+"\n");
				sb.append("type: "+type+"\n");
				sb.append("netType: "+netType+"\n");
				sb.append("roamStatus: "+roamStatus+"\n");
				sb.append("imei: "+imei+"\n");
				sb.append("imeiSV: "+imeiSV+"\n");
				sb.append("imsi: "+imsi+"\n");
				sb.append("bulettothStatus: "+bulettothStatus+"\n");
				sb.append("AirplaneStatus: "+AirplaneStatus+"\n");
				sb.append("dataRoamStatus: "+dataRoamStatus+"\n");
				
				txt.setText(sb.toString());
			}
		};
	}
