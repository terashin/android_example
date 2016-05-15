package examp.mainshinya.implicitintentsample1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


import java.util.List;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        ListView listview = (ListView)findViewById(R.id.fruitlist);
        listview.setOnItemClickListener(new List());
    }

    class List implements OnItemClickListener {
        public void onItemClick(AdapterView<?> parent,
                                View view,
                                int position,
                                long id){
            ListView listView = (ListView) parent;
            String item = (String)listView.getItemAtPosition(position);

            Intent intent = new Intent(Intent.ACTION_VIEW);

            String uriStr = "";
            if(item.equals("Apple")){
                uriStr += "intentsample://fruit/Apple?selecteditem="+item;
            }
            else if(item.equals("Banana")){
                uriStr += "intentsample://fruit/Banana?selecteditem="+item;
            }
            else if(item.equals("Grape")){
                uriStr += "intentsample://fruit/Grape?selecteditem="+item;
            }
            else {
                uriStr += "intentsample://fruitall?selecteditem=all";
            }
            Uri uri = Uri.parse(uriStr);

            intent.setData(uri);

            startActivity(intent);
        }
    }

}
