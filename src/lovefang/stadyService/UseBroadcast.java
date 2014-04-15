package lovefang.stadyService;
/**引入包*/
	import android.view.View;
	import android.os.Bundle;
	import android.app.Activity;
	import android.content.Intent;
	import android.widget.Button;
/**使用Broadcast,这是一个发送广播的类*/
	public class UseBroadcast extends Activity{
			/**创建参数*/
		private Button sendBroadcast;
			/**创建Activity*/
		public void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);
			setContentView(R.layout.broadcast);// 使用布局文件
			getView();
			sendBroadcast.setOnClickListener(sendBroadcastClick);// 添加事件监听
		}
		public void getView(){
			sendBroadcast = (Button)findViewById(R.id.sendBroadcast);
		}
			/**创建事件监听*/
		public Button.OnClickListener sendBroadcastClick = new Button.OnClickListener(){
			public void onClick(View view){
				Intent intent = new Intent();// 创建意图
				intent.putExtra("CONTENT",  "This is a Braodcast demo");// 设置广播的内容
				intent.setAction("lovefang.stadyService");// 设置广播的Action
				sendBroadcast(intent);
			}
		};
		
	}
