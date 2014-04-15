package lovefang.stadyService;

	import android.content.Intent;
	import android.os.Bundle;
	import android.app.Activity;
	import android.app.Notification;
	import android.app.NotificationManager;
	import android.app.PendingIntent;
	import android.net.Uri;
	import android.media.RingtoneManager;
	import android.widget.Button;
	import android.view.View;

/**使用notification*/
	public class UseNotification extends Activity {
			/**创建组件*/
		private Button textButton;
		private Button soundButton;// 声音通知
		private Button vibrateButton;// 震动通知
		private Button ledButton;// led通知
		private Button offButton;// 关闭通知
		NotificationManager notificationManager;
			/**创建Activity*/
		public void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);
			setContentView(R.layout.notification);
			getComment();
			registerComment();
		}
			/**获取对象*/
		public void getComment(){
				/**获取Notification对象*/
			notificationManager = (NotificationManager)this.getSystemService(NOTIFICATION_SERVICE);
			textButton = (Button)findViewById(R.id.notificationMessage);
			soundButton =(Button)findViewById(R.id.notificationSound);
			vibrateButton = (Button)findViewById(R.id.notificationVibrate);
			ledButton = (Button)findViewById(R.id.notificationLED);
			offButton = (Button)findViewById(R.id.offnotification);
		}
			/**注册对象*/
		public void registerComment(){
			textButton.setOnClickListener(notificationMessage);
			soundButton.setOnClickListener(notificationSound);
			vibrateButton.setOnClickListener(notificationVibrate);
			ledButton.setOnClickListener(notificationLed);
			offButton.setOnClickListener(notificationOff);
		}
		public Button.OnClickListener notificationMessage = new Button.OnClickListener(){
			public void onClick(View view){
				Notification notification = new Notification();// 创建Notification对象
				notification.icon = R.drawable.icon;
				notification.tickerText = "This is text notication";// 设置通知消息
					/**单击通知后的Intent，此例子单击后还是在当前页面*/
				PendingIntent intent = PendingIntent
					.getActivity(UseNotification.this,
							0, new Intent(UseNotification.this,UseNotification.class)
							, 0);
					/**设置通知消息*/
				notification.setLatestEventInfo(UseNotification.this
						,"Notification","Content of Notification Demo",intent);
					/**执行通知*/
				notificationManager.notify(0, notification);
			}
		};
		public Button.OnClickListener notificationSound = new Button.OnClickListener(){
			public void onClick(View view){
					/**创建通知对象*/
				Notification notification = new Notification();
					/**获取系统当前声音*/
				String ringName = RingtoneManager.getActualDefaultRingtoneUri(
						UseNotification.this, RingtoneManager.TYPE_RINGTONE)
						.toString();
					/**设置系统当前铃声为此通知的铃声*/
				notification.sound = Uri.parse(ringName);
					/**执行通知*/
				notificationManager.notify(0,notification);
			}
		};
			/**震动通知*/
		public Button.OnClickListener notificationVibrate = new Button.OnClickListener(){
			public void onClick(View view){
				Notification notification = new Notification();// 创建Notification对象
				notification.vibrate = new long[] {0, 100, 200, 300};// 设置通知震动模式
				notificationManager.notify(0,notification);// 执行通知
			}
		};
			/**LED通知*/
		public Button.OnClickListener notificationLed = new Button.OnClickListener(){
			public void onClick(View view){
				Notification notification = new Notification();// 创建Notification对象
				notification.ledOnMS = 300;// 设置led开始闪光的时间
				notification.ledOffMS = 1000;// 设置关闭时的闪光时间
				notificationManager.notify(0,notification);// 执行通知
			}
		};
			/**关闭通知*/
		public Button.OnClickListener notificationOff = new Button.OnClickListener(){
			public void onClick(View view){
				notificationManager.cancel(0);// 关闭通知
			}
		};
	}
