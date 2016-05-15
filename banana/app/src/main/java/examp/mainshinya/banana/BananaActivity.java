package examp.mainshinya.banana;

import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class BananaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banana);

        Uri uri =getIntent().getData();
        if(uri!=null){
            String fruitname = uri.getQueryParameter("selecteditem");
            TextView fruittext = (TextView)findViewById(R.id.tv_fruit);
            fruittext.setText(fruitname);
        }

        Button button = (Button)findViewById(R.id.bt_back);
        button.setOnClickListener(new ButtonClickListener());
    }

    class ButtonClickListener implements View.OnClickListener{
        public void onClick(View v){
            finish();
        }
    }

}
