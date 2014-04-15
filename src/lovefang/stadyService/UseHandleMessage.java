package lovefang.stadyService;
/***/
	import android.os.Bundle;
	import android.os.Handler;
	import android.os.Message;
	import android.app.Activity;
	import android.util.Log;
	import android.widget.Toast;
	import android.widget.ProgressBar;

/**使用Handle和Message*/
	public class UseHandleMessage extends Activity{
			/**定义参数*/
		protected final static int PROGRESS_END = -1;
		private ProgressBar progressbar;// 进度条
		protected static int progress;
		
		public void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);
			setContentView(R.layout.use_handleandmessage);
			progressbar = (ProgressBar)findViewById(R.id.bar);
			startProgressBar();
		}
			/**建立Handle*/
		protected Handler handler = new Handler(){
			public void handleMessage(Message msg){
				switch (msg.what){
					case PROGRESS_END:
						Toast.makeText(UseHandleMessage.this, "loading finished"
								, Toast.LENGTH_LONG).show();
						break;
					default:
						progressbar.setProgress(msg.what);
				}
			};
		};
			/**启动线程*/
		private void startProgressBar(){
			new Thread(){
				public void run(){
					while(progress <100){
						try{
							Thread.sleep(100);
							countProgress();
							progress ++;
							Log.v("UseHandleMessage","Count"+progress);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
					}
					endProgress();
				}
			}.start();
		}
			/***/
		private void countProgress(){
				/**获取Message对象*/
			Message msg = Message.obtain();
				/**将用户自定义的信息code封装到Message对象中*/
			msg.what = progress;
				/**发送信息*/
			handler.sendMessage(msg);
		}
			/***/
		private void endProgress(){
			Message msg = Message.obtain();
			msg.what = PROGRESS_END;
			handler.sendMessage(msg);
		}
	}
