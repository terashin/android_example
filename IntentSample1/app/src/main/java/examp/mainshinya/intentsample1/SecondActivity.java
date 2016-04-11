package examp.mainshinya.intentsample1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.app.Activity;

/**
 * Created by mainshinya on 2016/04/12.
 */
    public class SecondActivity extends Activity {
        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.secondlayout);

            Intent data = getIntent();
            Bundle extras = data.getExtras();
            String disp_pict = extras != null ? extras.getString("SELECTED_PICT"):"";

            ImageView image = (ImageView) findViewById(R.id.iv_fruit);

            if(disp_pict.equals("Apple")){
                image.setImageResource(R.drawable.apple);
            }
            else if(disp_pict.equals("Banana")){
                image.setImageResource(R.drawable.banana);
            }
            else if(disp_pict.equals("Grape")){
                image.setImageResource(R.drawable.grape);
            }

            Button button = (Button)findViewById(R.id.bt_back);
            button.setOnClickListener(new ButtonClickListener());
        }

        class ButtonClickListener implements OnClickListener{
            public void onClick(View v){
                finish();
            }
        }
    }

