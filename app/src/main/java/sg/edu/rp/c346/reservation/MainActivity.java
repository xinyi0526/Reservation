package sg.edu.rp.c346.reservation;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView name,phone,size;
    Button confirm,reset;
    DatePicker dp;
    TimePicker tp;
    RadioButton smoking;
    RadioButton nonsmoking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editText);
        size = findViewById(R.id.editText3);
        phone = findViewById(R.id.editText2);
        smoking = findViewById(R.id.radioButton3);
        nonsmoking = findViewById(R.id.radioButton4);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        reset = findViewById(R.id.buttonReset);
        confirm = findViewById(R.id.button);



        reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View va){
                name.setText("");
                size.setText("");
                phone.setText("");
                dp.updateDate(2019,05,01);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                smoking.setChecked(false);
                nonsmoking.setChecked(false);

            }
        });

        confirm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View vi){
                String iname = name.getText().toString();
                String tel = phone.getText().toString();
                String nsize =size.getText().toString();
                int day =dp.getDayOfMonth();
                int month = dp.getMonth()+1;
                int year = dp.getYear();
                int hour = tp.getCurrentHour();
                int min = tp.getCurrentMinute();

                String d = "Name: " + iname + "\nPhone: " + tel + "\nPax: " + nsize + "\nDate: "
                        + day +"/"+ month +"/" + year + "\nTime: " + hour + ":" +min + "\nArea: ";

                if(smoking.isChecked()){
                    Toast.makeText(MainActivity.this,d + "Smoking Area",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,d + "Non-smoking area",Toast.LENGTH_LONG).show();
                }


            }

        });
    }
}
