package com.example.festafimdeano.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.festafimdeano.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ViewHolder mViewHolder = new ViewHolder();
    //Formatar data
    private static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/mm/yyyy");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.mViewHolder.textToday = findViewById(R.id.text_today);
        this.mViewHolder.textDayLeft = findViewById(R.id.text_days_left);
        this.mViewHolder.buttonConfirm = findViewById(R.id.button_confirm);

        this.mViewHolder.buttonConfirm.setOnClickListener(this);

        this.mViewHolder.textToday.setText(SIMPLE_DATE_FORMAT.format(Calendar.getInstance().getTime()));
        String daysLeft = String.format("%s %s", String.valueOf(this.getDayLeft()), getString(R.string.dias));
        this.mViewHolder.textDayLeft.setText(daysLeft);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_confirm){
            Intent intent = new Intent(this, DetailsActivity.class);
            startActivity(intent);
        }
    }

    private int getDayLeft(){
        //Data e hora
        Calendar calendarToday = Calendar.getInstance();
        int today = calendarToday.get(Calendar.DAY_OF_YEAR);
        //Dia máximo do ano
        Calendar calendarLasDay = Calendar.getInstance();
        int lastDay = calendarLasDay.getActualMaximum(Calendar.DAY_OF_YEAR);

        return lastDay - today;

    }

    private static class ViewHolder{
        TextView textToday;
        TextView textDayLeft;
        Button buttonConfirm;
    }
}
