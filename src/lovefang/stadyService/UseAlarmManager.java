package lovefang.stadyService;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.app.AlarmManager;

import java.util.Calendar;

public class UseAlarmManager extends Activity {
		/**创建参数*/
	private Button startAlarm;
	private Button shutdownAlarm;
	private AlarmManager alarm;
	
		/**创建Activity*/
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.usealarmmanager);
		getWidget();
	}
	public void getWidget(){
		startAlarm = (Button)findViewById(R.id.startAlarm);
		shutdownAlarm = (Button)findViewById(R.id.shutDowntAlarm);
		alarm = (AlarmManager)getSystemService(ALARM_SERVICE);// 获取AlarmManager
	}
	public void registerWidget(){
		startAlarm.setOnClickListener(startAlarms);
		shutdownAlarm.setOnClickListener(shutdownAlarms);
	}
		/**启动闹钟*/
	public Button.OnClickListener startAlarms = new Button.OnClickListener(){
		public void onClick(View view){
				// 设置10秒后出发闹钟
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(System.currentTimeMillis());// 设置calendar的时间
			calendar.add(Calendar.SECOND, 10);
			
			alarm.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), null);
		}
	};
	public Button.OnClickListener shutdownAlarms = new Button.OnClickListener(){
		public void onClick(View view){
			alarm.cancel(null);
		}
	};
}
