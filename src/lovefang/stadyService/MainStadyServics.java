package lovefang.stadyService;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.util.Log;
/**����ʹ�ú�̨�����ѧϰ����*/
public class MainStadyServics extends Activity {
    	/**��������*/
	Button startServiceButton;// ��������ť
	Button shutDownServiceButton;// �رշ���ť
	Button startBindServiceButton;// �����󶨷���ť
	Button sendBroadcast;// ʹ�ù㲥
	Button notificationButton;// ʹ��֪ͨ����
	Button alarmButton;// ʹ������
	Button handlerButton;// ʹ��handler
	Button asyncButton;// ʹ���첽����
	Button phoneStateButton;// �鿴�ֻ�״̬
	Button callphoneButton;// ����绰
	Button vibratorButton;// ʹ���� 
	CountService countService;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("MainStadyServics", "setContentView");
        setContentView(R.layout.main);
        getWidget();
        regiestListener();
    }
    	/**������*/
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
    	/**Ϊ��ť��Ӽ���*/
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
    	/**����������¼�����*/
    public Button.OnClickListener startService = new Button.OnClickListener(){
    	public void onClick(View view){
    			/**������ťʱ��������*/
    		Intent intent = new Intent(MainStadyServics.this,CountService.class);
    		startService(intent);
    		Log.v("MainStadyServics", "start Service");
    	}
    };
    	/**�رշ���*/
    public Button.OnClickListener shutdownService = new Button.OnClickListener(){
    	public void onClick(View view){
    			/**������ťʱ��������*/
    		Intent intent = new Intent(MainStadyServics.this,CountService.class);
    			/**�˳�Activity�ǣ�ֹͣ����*/
    		stopService(intent);
    		Log.v("MainStadyServics", "shutDown serveice");
    	}
    };
    	/**�򿪰󶨷����Activity*/
    public Button.OnClickListener startBinderService = new Button.OnClickListener(){
    	public void onClick(View view){
    			/**������ťʱ��������*/
    		Intent intent = new Intent(MainStadyServics.this,UseBrider.class);
    		startActivity(intent);
    		Log.v("MainStadyServics", "start Binder Service");
    	}
    };
    	/**�򿪹㲥ѧϰ�İ�ť*/
    public Button.OnClickListener broadcastReceiver = new Button.OnClickListener(){
    	public void onClick(View view){
    		Intent intent = new Intent(MainStadyServics.this,UseBroadcast.class);
    		startActivity(intent);
    		Log.v("MainStadyServics","start broadcast");
    	}
    };
    	/**��֪ͨ*/
    public Button.OnClickListener notification = new Button.OnClickListener(){
    	public void onClick(View view){
    		Intent intent = new Intent(MainStadyServics.this, UseNotification.class);
    		startActivity(intent);
    		Log.v("MainStadyService ","start Notification");
    		
    	}
    };
    	/**ʹ������*/
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
    		/**�˳�Activity�ǣ�ֹͣ����*/
    	stopService(intent);
    }
    	
    
}