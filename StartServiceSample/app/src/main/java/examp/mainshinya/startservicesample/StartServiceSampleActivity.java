package examp.mainshinya.startservicesample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;

public class StartServiceSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_service_sample);

        Button startButton=(Button)findViewById(R.id.bt_start);
        startButton.setOnClickListener(new StartButtonClickListener());
    }

    class StartButtonClickListener implements OnClickListener {
        public void onClick(View v){
            Intent intent = new Intent(StartServiceSampleActivity.this,
                                        StartServiceSampleService.class);

            EditText stopcount = (EditText)findViewById(R.id.et_time);
            intent.putExtra("STOPTIME",stopcount.getText().toString());

            startService(intent);
        }
    }

}


