package lovefang.stadyService;
/**引入包*/
	import android.os.Bundle;
	import android.app.Activity;
	import android.net.Uri;
	import android.view.View;
	import android.content.Intent;
	import android.widget.Button;
	import android.widget.EditText;
/**如何拨打电话*/
	public class UseActionCall extends Activity{
			/**创建参数*/
		private Button call_Button;
		private EditText etext_callnumber;
			/**创建Activity*/
		public void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);
			setContentView(R.layout.use_action_call);
			getWidget();
			call_Button.setOnClickListener(call_Phone);
		}
		public void getWidget(){
			call_Button = (Button) findViewById(R.id.button_call);
			etext_callnumber = (EditText) findViewById(R.id.etext_action_call);
		}
			/**读取手机状态需要权限android.premission,CALL_PHONE*/
		private Button.OnClickListener call_Phone= new Button.OnClickListener(){
			public void onClick(View view){
				String phoneNum = etext_callnumber.getText().toString();
				Uri uri = Uri.parse("tel:"+phoneNum);// 将电话号码解析为Uri
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_CALL);// 将intent的Action设为call
				intent.setData(uri);// 将Uri对象传入intent对象
				startActivity(intent);// 开始通话
			}
		};
		
	}
