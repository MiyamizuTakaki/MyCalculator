package com.miyamizu.zd5;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import com.miyamizu.zd5.Startview;
public class MainActivity extends AppCompatActivity {
    private ImageView welcomeImg = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Calculator.class);
                startActivity(intent);
                finish();
            }
        }, 3000); // 3秒延时
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startview);

    }

}