package examp.mainshinya.form;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by mainshinya on 2016/04/16.
 */
public class SecondActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondlayout);

        Bundle extra = getIntent().getExtras();

        String name = extra.getString("NAME");
        String address = extra.getString("ADDRESS");
        String month = extra.getString("MONTH");
        String day = extra.getString("DAY");
        String gender = extra.getString("GENDER");
        String apple = extra.getString("APPLE");
        String orange = extra.getString("ORANGE");
        String peach = extra.getString("PEACH");

        TextView tvName = (TextView)findViewById(R.id.tv_name);
        TextView tvAddress = (TextView)findViewById(R.id.tv_address);
        TextView tvMonth = (TextView)findViewById(R.id.tv_month);
        TextView tvDay = (TextView)findViewById(R.id.tv_day);
        TextView tvGender = (TextView)findViewById(R.id.tv_gender);
        TextView tvApple = (TextView)findViewById(R.id.tv_apple);
        TextView tvOrange = (TextView)findViewById(R.id.tv_orange);
        TextView tvPeach = (TextView)findViewById(R.id.tv_peach);

        tvName.setText(name);
        tvAddress.setText(address);
        tvMonth.setText(month);
        tvDay.setText(day);
        tvGender.setText(gender);
        if(apple != null)tvApple.setText(apple);
        if(orange != null)tvOrange.setText(orange);
        if(peach != null)tvPeach.setText(peach);

        Button button = (Button)findViewById(R.id.bt_back);
        button.setOnClickListener(new ButtonBackClickListener());
    }

    class ButtonBackClickListener implements OnClickListener{
        public void onClick(View v){
            finish();
        }
    }
}
