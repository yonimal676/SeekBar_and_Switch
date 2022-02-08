package com.example.seekbarandswitch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener {

    ImageView img;
    Switch swt;
    SeekBar sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);



        swt = findViewById(R.id.swtch);
        img = findViewById(R.id.image);
        sb = findViewById(R.id.sb);

        swt.setOnCheckedChangeListener(this);


        sb.setOnSeekBarChangeListener(this);
        sb.setMax(100);
        sb.setProgress(100);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
    {

        if (buttonView == swt)
        {
            if (isChecked)
            {
                img.setVisibility(View.VISIBLE);
            }

            else
            {
                img.setVisibility(View.INVISIBLE);

            }
        }

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
    {
        if (seekBar == sb)
        {
            float alpha = (float) progress / 100;
            img.setAlpha(alpha);

            Log.d("yoni","progress = " + progress);

            /** SEE LOGCAT */
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}