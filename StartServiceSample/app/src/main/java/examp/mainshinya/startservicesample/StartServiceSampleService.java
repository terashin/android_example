package examp.mainshinya.startservicesample;

/**
 * Created by mainshinya on 2016/05/15.
 */

import java.util.Timer;
import java.util.TimerTask;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.widget.Toast;

public class StartServiceSampleService extends Service{
    private Timer timer = null;
    private int countTime;
    private int stopTime;
    private static Service serviceObj;

    @Override
    public IBinder onBind(Intent arg0){
        return null;
    }

    @Override
    public void onCreate(){
        Toast.makeText(this,
                        "Start Service",
                        Toast.LENGTH_SHORT).show();

        timer = new Timer();
        countTime = 0;

        serviceObj = this;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){

        Toast.makeText(this,
                        "Start Service",
                        Toast.LENGTH_SHORT).show();

        timer.schedule(task, 10000, 10000);

        Bundle bundle = intent.getExtras();
        stopTime = Integer.parseInt(bundle.getString("STOPTIME"));

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy(){

        Toast.makeText(this,
                        "Stop Service",
                        Toast.LENGTH_SHORT).show();

        timer.cancel();
        timer.purge();
    }

    private static Handler handler = new Handler(){

        public void handleMessage(Message msg){
            Toast.makeText(serviceObj,
                    (String)msg.obj,
                        Toast.LENGTH_SHORT).show();
        }
    };

    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
            countTime += 10;

            if(countTime / 60 == stopTime){
                stopSelf();
            }else{
                handler.sendMessage(
                        Message.obtain(handler,
                                        0,
                                countTime / 60 + "M" + countTime % 60+"expressed"));

            }
        }
    };
}
