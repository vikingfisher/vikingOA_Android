package lovefang.stadyService;
/***/
	import android.os.Bundle;
	import android.os.AsyncTask;
	import android.view.View;
	import android.widget.Button;
	import android.widget.TextView;
	import android.app.Activity;
	import android.app.ProgressDialog;
/***/
	public class UseAsyncTask extends Activity{
			/**创建参数*/
		private Button button;
		private TextView text;
			/**创建Activity*/
		public void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);
			setContentView(R.layout.use_async);
			getWidget();
			button.setOnClickListener(asnyc);
		}
			/**关联组件*/
		private void getWidget(){
			button = (Button) findViewById(R.id.button_async);
			text = (TextView) findViewById(R.id.text_async);
		}
			/**创建监听*/
		public Button.OnClickListener asnyc = new Button.OnClickListener(){
			
			public void onClick(View view){
					/**获取LoadTast对象*/
				LoadTast loadtast = new LoadTast();
					/**执行异步task*/
				loadtast.execute();
			}
		};
			/**继承自AsyncTast的LoadTast*/
		public class LoadTast extends AsyncTask<Void, Integer, String>{
			
			private ProgressDialog progressDialog;
			
			protected String doInBackground(Void... params) {
					/**模拟一个加速的进度*/
				int sum = 1;
				while(sum <= 100 ){
					try{
						Thread.sleep(100);
						publishProgress(sum);
						sum ++;
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
				return "Loading Fibished..";
			}
			
			public void onPreExecute(){
					/**创建一个对话框并显示*/
				progressDialog = ProgressDialog.show(UseAsyncTask.this,
						"AsyncTask Demo", "Loading....", true);
			}
			
			public void onProgressUpdate(Integer... values){
					/**将从publishProgress传递过来的值进行格式化后显示到TextView组件*/
				text.setText(values[0] +"%");
			}
			public void onPostExecute(String result){
					/**隐藏对话框*/
				progressDialog.dismiss();
					/**将从onInBackground返回的result设置到TextView组件*/
				text.setText(result);
			}
			
		};
	}
