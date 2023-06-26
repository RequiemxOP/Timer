package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    Button btnstart, btnstop;
    TextView txtcounter;
    int i = 1;
    Handler customHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtcounter = findViewById(R.id.textView1);
        btnstart = findViewById(R.id.btn_start);
        btnstop = findViewById(R.id.btn_stop);
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customHandler.postDelayed(updateTimerThread,0);
            }
        });
        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customHandler.removeCallbacks(updateTimerThread);
            }
        });
    }
    private final Runnable updateTimerThread = new Runnable() {
        @Override
        public void run() {
            txtcounter.setText(""+i);
            customHandler.postDelayed(this,1000);
            i++;
        }
    };
}
