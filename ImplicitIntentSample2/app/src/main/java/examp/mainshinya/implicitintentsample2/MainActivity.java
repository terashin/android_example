package examp.mainshinya.implicitintentsample2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button)findViewById(R.id.bt_execute);
        button1.setOnClickListener(new ButtonClickListener());
    }

    class ButtonClickListener implements View.OnClickListener{
        public void onClick(View v){
            EditText content = (EditText)findViewById(R.id.et_content);
            String contentStr = content.getText().toString();

            Spinner application = (Spinner)findViewById(R.id.sp_application);
            String applicationStr = (String)application.getSelectedItem();

            String action = null;
            if(applicationStr.equals("Call")){
                action = "android.intent.action.DIAL";
                contentStr = "tel:"+content.getText().toString();
            }
            else if(applicationStr.equals("Browser")){
                action = "android.intent.action.VIEW";
            }
            else if(applicationStr.equals("Map")){
                action = "android.intent.action.VIEW";
                contentStr = "geo:"+content.getText().toString();
            }

            Intent intent = new Intent(action, Uri.parse(contentStr));

            startActivity(intent);
        }
    }

}
