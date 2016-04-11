package examp.mainshinya.listclicksample;

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
import android.widget.Toast;

public class ListClickSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_click_sample);

        // Get ListView Object
        ListView listView = (ListView) findViewById(R.id.lv_greeting);
        // Setting ClickListener to listView
        listView.setOnItemClickListener(new ListItemClickListener());
    }

    // Define ItemClickListener
    class ListItemClickListener implements AdapterView.OnItemClickListener{
        // onItemClick Method
        public void onItemClick(AdapterView<?> parent,
                                View view,
                                int position,
                                long id){
            ListView listview = (ListView) parent;
            String item = (String) listview.getItemAtPosition(position);

            Toast.makeText(ListClickSampleActivity.this,
                    item,
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_click_sample, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
