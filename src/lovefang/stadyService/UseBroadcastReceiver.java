package lovefang.stadyService;
/***/
	import android.content.BroadcastReceiver;
	import android.content.Context;
	import android.content.Intent;
	import android.util.Log;
/**这是一个接收广播的类*/
	public class UseBroadcastReceiver extends BroadcastReceiver{
		public void onReceive(Context context, Intent intent){
			Log.v("UseBroadcastReceiver", "I get a message");
		}
	}
