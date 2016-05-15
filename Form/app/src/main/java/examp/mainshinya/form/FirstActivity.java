package examp.mainshinya.form;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button)findViewById(R.id.bt_send);
        button1.setOnClickListener(new ButtonClickListener());
    }

    class ButtonClickListener implements View.OnClickListener{
        public void onClick(View v){
            //Getting Object
            EditText name = (EditText)findViewById(R.id.et_name);

            EditText address = (EditText)findViewById(R.id.et_address);

            Spinner month = (Spinner)findViewById(R.id.sp_month);
            Spinner day = (Spinner)findViewById(R.id.sp_day);

            RadioGroup radio = (RadioGroup)findViewById(R.id.rg_gender);
            RadioButton radiobutton = (RadioButton)findViewById(radio.getCheckedRadioButtonId());

            CheckBox applecheck = (CheckBox)findViewById(R.id.cb_apple);
            CheckBox orangecheck = (CheckBox)findViewById(R.id.cb_orange);
            CheckBox peachcheck = (CheckBox)findViewById(R.id.cb_peach);

            EditText appleqty = (EditText)findViewById(R.id.et_apple);
            EditText orangeqty = (EditText)findViewById(R.id.et_orange);
            EditText peachqty = (EditText)findViewById(R.id.et_peach);

            // Generate Intent
            Intent intent = new Intent(FirstActivity.this, SecondActivity.class);

            // Setting Input Data
            intent.putExtra("NAME", name.getText().toString());
            intent.putExtra("ADDRESS", address.getText().toString());
            intent.putExtra("NONTH", month.getSelectedItem().toString());
            intent.putExtra("DAY", day.getSelectedItem().toString());
            intent.putExtra("GENDER", radiobutton.getText().toString());

            if(applecheck.isChecked()){
                intent.putExtra("APPLE",appleqty.getText().toString());
            }
            if(orangecheck.isChecked()){
                intent.putExtra("ORANGE",orangeqty.getText().toString());
            }
            if(peachcheck.isChecked()){
                intent.putExtra("PEACH",peachqty.getText().toString());
            }

            startActivity(intent);
        }
    }

}
