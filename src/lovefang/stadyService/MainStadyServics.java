package lovefang.stadyService;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.util.Log;
/**这是使用后台服务的学习例子*/
public class MainStadyServics extends Activity {
    	/**参数设置*/
	Button startServiceButton;// 启动服务按钮
	Button shutDownServiceButton;// 关闭服务按钮
	Button startBindServiceButton;// 启动绑定服务按钮
	Button sendBroadcast;// 使用广播
	Button notificationButton;// 使用通知功能
	Button alarmButton;// 使用闹钟
	Button handlerButton;// 使用handler
	Button asyncButton;// 使用异步加载
	Button phoneStateButton;// 查看手机状态
	Button callphoneButton;// 拨打电话
	Button vibratorButton;// 使用震动 
	CountService countService;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("MainStadyServics", "setContentView");
        setContentView(R.layout.main);
        getWidget();
        regiestListener();
    }
    	/**获得组件*/
    public void getWidget(){
    	startServiceButton = (Button)findViewById(R.id.startServerButton);
    	startBindServiceButton = (Button)findViewById(R.id.startBindServerButton);
    	shutDownServiceButton = (Button)findViewById(R.id.sutdownServerButton);
    	sendBroadcast = (Button)findViewById(R.id.sendBroadcast);
    	notificationButton = (Button)findViewById(R.id.notification);
    	alarmButton = (Button)findViewById(R.id.alarm);
    	handlerButton = (Button)findViewById(R.id.handler);
    	asyncButton = (Button)findViewById(R.id.async);
    	phoneStateButton = (Button) findViewById(R.id.phonestate);
    	callphoneButton = (Button) findViewById(R.id.callphone);
    	vibratorButton = (Button) findViewById(R.id.vibrator);
    }
    	/**为按钮添加监听*/
    public void regiestListener(){
    	startServiceButton.setOnClickListener(startService);
    	shutDownServiceButton.setOnClickListener(shutdownService);
    	startBindServiceButton.setOnClickListener(startBinderService);
    	sendBroadcast.setOnClickListener(broadcastReceiver);
    	notificationButton.setOnClickListener(notification);
    	alarmButton.setOnClickListener(startAlarm);
    	handlerButton.setOnClickListener(handler);
    	asyncButton.setOnClickListener(async);
    	phoneStateButton.setOnClickListener(phonestate);
    	callphoneButton.setOnClickListener(callphoneEvent);
    	vibratorButton.setOnClickListener(vibrator);
    }
    	/**启动服务的事件监听*/
    public Button.OnClickListener startService = new Button.OnClickListener(){
    	public void onClick(View view){
    			/**单击按钮时启动服务*/
    		Intent intent = new Intent(MainStadyServics.this,CountService.class);
    		startService(intent);
    		Log.v("MainStadyServics", "start Service");
    	}
    };
    	/**关闭服务*/
    public Button.OnClickListener shutdownService = new Button.OnClickListener(){
    	public void onClick(View view){
    			/**单击按钮时启动服务*/
    		Intent intent = new Intent(MainStadyServics.this,CountService.class);
    			/**退出Activity是，停止服务*/
    		stopService(intent);
    		Log.v("MainStadyServics", "shutDown serveice");
    	}
    };
    	/**打开绑定服务的Activity*/
    public Button.OnClickListener startBinderService = new Button.OnClickListener(){
    	public void onClick(View view){
    			/**单击按钮时启动服务*/
    		Intent intent = new Intent(MainStadyServics.this,UseBrider.class);
    		startActivity(intent);
    		Log.v("MainStadyServics", "start Binder Service");
    	}
    };
    	/**打开广播学习的按钮*/
    public Button.OnClickListener broadcastReceiver = new Button.OnClickListener(){
    	public void onClick(View view){
    		Intent intent = new Intent(MainStadyServics.this,UseBroadcast.class);
    		startActivity(intent);
    		Log.v("MainStadyServics","start broadcast");
    	}
    };
    	/**打开通知*/
    public Button.OnClickListener notification = new Button.OnClickListener(){
    	public void onClick(View view){
    		Intent intent = new Intent(MainStadyServics.this, UseNotification.class);
    		startActivity(intent);
    		Log.v("MainStadyService ","start Notification");
    		
    	}
    };
    	/**使用闹钟*/
    public Button.OnClickListener startAlarm = new Button.OnClickListener(){
    	public void onClick(View view){
    		Intent intent = new Intent(MainStadyServics.this, UseAlarmManager.class);
    		startActivity(intent);
    		Log.v("MainStadyService ","start alarm");
    		
    	}
    };
    public Button.OnClickListener handler= new Button.OnClickListener(){
    	public void onClick(View view){
    		Intent intent = new Intent(MainStadyServics.this, UseHandleMessage.class);
    		startActivity(intent);
    		Log.v("MainStadyService ","start handle");
    	}
    };
    public Button.OnClickListener async= new Button.OnClickListener(){
    	public void onClick(View view){
    		Intent intent = new Intent(MainStadyServics.this, UseAsyncTask.class);
    		startActivity(intent);
    		Log.v("MainStadyService ","start handle");
    	}
    };
    public Button.OnClickListener phonestate= new Button.OnClickListener(){
    	public void onClick(View view){
    		Intent intent = new Intent(MainStadyServics.this, UsePhoneState.class);
    		startActivity(intent);
    		Log.v("MainStadyService ","start phonestate");
    	}
    };
    public Button.OnClickListener callphoneEvent= new Button.OnClickListener(){
    	public void onClick(View view){
    		Intent intent = new Intent(MainStadyServics.this, UseActionCall.class);
    		startActivity(intent);
    		Log.v("MainStadyService ","start callphone");
    	}
    };
    public Button.OnClickListener vibrator= new Button.OnClickListener(){
    	public void onClick(View view){
    		Intent intent = new Intent(MainStadyServics.this, UseVibrator.class);
    		startActivity(intent);
    		Log.v("MainStadyService ","start callphone");
    	}
    };
    	/***/
    protected void onDestroy(){
    	super.onDestroy();
    	Intent intent = new Intent(MainStadyServics.this,CountService.class);
    		/**退出Activity是，停止服务*/
    	stopService(intent);
    }
    	
    
}