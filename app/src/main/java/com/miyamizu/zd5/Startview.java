package com.miyamizu.zd5;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class Startview {
    public static class Logo extends AppCompatActivity{
        public Logo(){

        }
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.startview);

        }
    }
}
