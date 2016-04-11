package examp.mainshinya.intentsample1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        ListView listView = (ListView) findViewById(R.id.lv_fruit);
        listView.setOnItemClickListener(new ListItemClickListener());

    }

    class ListItemClickListener implements AdapterView.OnItemClickListener {
       public void onItemClick(AdapterView<?> parent,
                               View view,
                               int position,
                               long id){

           ListView listView = (ListView) parent;
           String item = (String) listView.getItemAtPosition(position);

           Intent intent =new Intent(FirstActivity.this, SecondActivity.class);
           intent.putExtra("SELECTED_PICT", item);

           startActivity(intent);
       }
    }


}
