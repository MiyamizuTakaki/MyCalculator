package com.miyamizu.zd5;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import org.w3c.dom.Text;

public class Calculator extends FragmentActivity implements View.OnClickListener {
    String numbers1 = "";
    String numbers2 = "";
    String numbers3 = "";
    int operation = 0; //1为加2为减3为乘法4为除法
    boolean on = false;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calcuator);

    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("MyApp", "Orientation changed to: " + newConfig.orientation);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.calacuator_more);
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.calcuator);
        }
    }

    @Override
    public void onClick(View view) {
        int vid = view.getId();

        // 加载指定的动画资源文件
        @SuppressLint("ResourceType") AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.anim.rotate_animator);
        animatorSet.setTarget(view);
// 开始动画
        animatorSet.start();
        if (vid == R.id.b0) {
            addNumber("0");
        } else if (vid == R.id.b1) {
            addNumber("1");
        } else if (vid == R.id.b2) {
            addNumber("2");
        } else if (vid == R.id.b3) {
            addNumber("3");
        } else if (vid == R.id.b4) {
            addNumber("4");
        } else if (vid == R.id.b5) {
            addNumber("5");
        } else if (vid == R.id.b6) {
            addNumber("6");
        } else if (vid == R.id.b7) {
            addNumber("7");
        } else if (vid == R.id.b8) {
            addNumber("8");
        } else if (vid == R.id.b9) {
            addNumber("9");
        } else if (vid == R.id.btn_dot) {
            addNumber(".");
        } else if (vid == R.id.btn_plus) {
            operation = 1;
            on = true;
        } else if (vid == R.id.btn_minus) {
            operation = 2;
            on = true;
        } else if (vid == R.id.btn_multiply) {
            operation = 3;
            on = true;
        } else if (vid == R.id.btn_divide) {
            operation = 4;
            on = true;
        } else if (vid == R.id.btn_eqal) {
            String eql = equelNumber();
            TextView tv = (TextView) findViewById(R.id.tv_result);
            tv.setText(eql);
            numbers1 = eql;
            numbers2 = "";
            on = false;
        } else if (vid == R.id.btn_cancel) {
            clear();
        } else if (vid == R.id.btn_clear) {
            clearAll();
        } else if (vid == R.id.btn_reciprocal) {

        } else if (vid == R.id.btn_sqrt) {

        } else if (vid == R.id.left_parenthesis) {

        } else if (vid == R.id.right_parenthesis_2_button) {

        } else if (vid == R.id.cube_root_x_button) {
            float n;
            TextView tv = (TextView) findViewById(R.id.tv_result);
            if(!on){
                n = Float.parseFloat(numbers1);
                n = (float) Math.cbrt(n);
                tv.setText(String.valueOf(n));
                numbers1 = String.valueOf(n);
            }
            else{
                n = Float.parseFloat(numbers2);
                n = (float) Math.cbrt(n);
                tv.setText(String.valueOf(n));
                numbers2 = String.valueOf(n);
            }

//        }else if (vid == R.id.yth_root_x_button) {

        }else if (vid == R.id.reciprocal_button) {
            float n;
            TextView tv = (TextView) findViewById(R.id.tv_result);
            if(!on){
                n = Float.parseFloat(numbers1);
                n = 1/n;
                tv.setText(String.valueOf(n));
                numbers1 = String.valueOf(n);
            }
            else{
                n = Float.parseFloat(numbers2);
                n = 1/n;
                tv.setText(String.valueOf(n));
                numbers2 = String.valueOf(n);
            }

        }else if (vid == R.id.natural_log_button) {
            float n;
            TextView tv = (TextView) findViewById(R.id.tv_result);
            if(!on){
                n = Float.parseFloat(numbers1);
                n = (float) Math.log(n);
                tv.setText(String.valueOf(n));
                numbers1 = String.valueOf(n);
            }
            else{
                n = Float.parseFloat(numbers2);
                n = (float) Math.log(n);
                tv.setText(String.valueOf(n));
                numbers2 = String.valueOf(n);
            }

        }else if (vid == R.id.logarithm_base_10_button) {
            float n;
            TextView tv = (TextView) findViewById(R.id.tv_result);
            if(!on){
                n = Float.parseFloat(numbers1);
                n = (float) Math.log10(n);
                tv.setText(String.valueOf(n));
                numbers1 = String.valueOf(n);
            }
            else{
                n = Float.parseFloat(numbers2);
                n = (float) Math.log10(n);
                tv.setText(String.valueOf(n));
                numbers2 = String.valueOf(n);
            }

        }else if (vid == R.id.factorial_button) {
            float n;
            TextView tv = (TextView) findViewById(R.id.tv_result);
            if(!on){
                n = Float.parseFloat(numbers1);
                for(float i = n-1; (int)i >0; i--){
                    n *= i;
                }
                tv.setText(String.valueOf(n));
                numbers1 = String.valueOf(n);
            }
            else{
                n = Float.parseFloat(numbers2);
                for(float i = n-1; (int)i >0; i--){
                    n *= i;
                }
                tv.setText(String.valueOf(n));
                numbers2 = String.valueOf(n);
            }

        }else if (vid == R.id.sine_button) {
            float n;
            TextView tv = (TextView) findViewById(R.id.tv_result);
            if(!on){
                n = Float.parseFloat(numbers1);
                n = (float) Math.sin(n);
                tv.setText(String.valueOf(n));
                numbers1 = String.valueOf(n);
            }
            else{
                n = Float.parseFloat(numbers2);
                n = (float) Math.sin(n);
                tv.setText(String.valueOf(n));
                numbers2 = String.valueOf(n);
            }

        }else if (vid == R.id.cosine_button) {
            float n;
            TextView tv = (TextView) findViewById(R.id.tv_result);
            if(!on){
                n = Float.parseFloat(numbers1);
                n = (float) Math.cos(n);
                tv.setText(String.valueOf(n));
                numbers1 = String.valueOf(n);
            }
            else{
                n = Float.parseFloat(numbers2);
                n = (float) Math.cos(n);
                tv.setText(String.valueOf(n));
                numbers2 = String.valueOf(n);
            }

        }else if (vid == R.id.tangent_button) {
            float n;
            TextView tv = (TextView) findViewById(R.id.tv_result);
            if(!on){
                n = Float.parseFloat(numbers1);
                n = (float) Math.tan(n);
                tv.setText(String.valueOf(n));
                numbers1 = String.valueOf(n);
            }
            else{
                n = Float.parseFloat(numbers2);
                n = (float) Math.tan(n);
                tv.setText(String.valueOf(n));
                numbers2 = String.valueOf(n);
            }

        }else if (vid == R.id.eulers_number_button) {
            float n;
            TextView tv = (TextView) findViewById(R.id.tv_result);
            if(!on){
                n = (float) Math.E;
                tv.setText(String.valueOf(n));
                numbers1 = String.valueOf(n);
            }
            else{
                n = (float) Math.E;
                tv.setText(String.valueOf(n));
                numbers2 = String.valueOf(n);
            }

        }else if (vid == R.id.hyperbolic_sine_button) {
            float n;
            TextView tv = (TextView) findViewById(R.id.tv_result);
            if(!on){
                n = Float.parseFloat(numbers1);
                n = (float) Math.sinh(n);
                tv.setText(String.valueOf(n));
                numbers1 = String.valueOf(n);
            }
            else{
                n = Float.parseFloat(numbers2);
                n = (float) Math.sinh(n);
                tv.setText(String.valueOf(n));
                numbers2 = String.valueOf(n);
            }

        }else if (vid == R.id.hyperbolic_cosine_button) {
            float n;
            TextView tv = (TextView) findViewById(R.id.tv_result);
            if(!on){
                n = Float.parseFloat(numbers1);
                n = (float) Math.cosh(n);
                tv.setText(String.valueOf(n));
                numbers1 = String.valueOf(n);
            }
            else{
                n = Float.parseFloat(numbers2);
                n = (float) Math.cosh(n);
                tv.setText(String.valueOf(n));
                numbers2 = String.valueOf(n);
            }

        }else if (vid == R.id.hyperbolic_tangent_button) {
            float n;
            TextView tv = (TextView) findViewById(R.id.tv_result);
            if(!on){
                n = Float.parseFloat(numbers1);
                n = (float) Math.tanh(n);
                tv.setText(String.valueOf(n));
                numbers1 = String.valueOf(n);
            }
            else{
                n = Float.parseFloat(numbers2);
                n = (float) Math.tanh(n);
                tv.setText(String.valueOf(n));
                numbers2 = String.valueOf(n);
            }

        }else if (vid == R.id.pi_constant_button) {
            float n;
            TextView tv = (TextView) findViewById(R.id.tv_result);
            if(!on){
                n = (float) Math.PI;
                tv.setText(String.valueOf(n));
                numbers1 = String.valueOf(n);
            }
            else{
                n = (float) Math.PI;
                tv.setText(String.valueOf(n));
                numbers2 = String.valueOf(n);
            }

        }else if(vid == R.id.x_squared_button){
            float n;
            TextView tv = (TextView) findViewById(R.id.tv_result);
            if(!on){
                n = Float.parseFloat(numbers1);
                n = n * n;
                tv.setText(String.valueOf(n));
                numbers1 = String.valueOf(n);
            }
            else{
                n = Float.parseFloat(numbers2);
                n = n * n;
                tv.setText(String.valueOf(n));
                numbers2 = String.valueOf(n);
            }
        }
        else if(vid == R.id.square_root_x_button){
            float n;
            TextView tv = (TextView) findViewById(R.id.tv_result);
            if(!on){
                n = Float.parseFloat(numbers1);
                n = (float) Math.sqrt(n);
                tv.setText(String.valueOf(n));
                numbers1 = String.valueOf(n);
            }
            else{
                n = Float.parseFloat(numbers2);
                n = (float) Math.sqrt(n);
                tv.setText(String.valueOf(n));
                numbers2 = String.valueOf(n);
            }
        }

    }

    public void addNumber(String number) {
        TextView tv = (TextView) findViewById(R.id.tv_result);
        if(!on)
        {
            numbers1 = numbers1 + number;
            tv.setText(numbers1);
        }
        else{
            numbers2 = numbers2 + number;
            tv.setText(numbers2);
        }

    }
    public void setOperation(int operation) {
        this.operation = operation;
    }
    public String equelNumber() {
        if(numbers1.isEmpty())
            numbers1="0";
        if(numbers2.isEmpty())
            numbers2="0";
        float n1 = Float.parseFloat(numbers1);
        float n2 = Float.parseFloat(numbers2);
        float equal = 0;
        switch (operation){
            case 1:
                equal = n1 + n2;
                break;
            case 2:
                equal = n1 - n2;
                break;
            case 3:
                equal = n1 * n2;
                break;
            case 4:
                equal = n1 / n2;
                break;
        }
        on = false;
        return String.valueOf(equal);
    }
    public void clearAll() {
        TextView tv = (TextView) findViewById(R.id.tv_result);
        numbers1 = "";
        numbers2 = "";
        if(on)
            on = false;
        tv.setText(numbers1);
        tv.setText(numbers2);
    }
    public void clear(){
        TextView tv = (TextView) findViewById(R.id.tv_result);
        if(!on)
        {
            numbers1 = "";
            tv.setText(numbers1);
        }
        else
        {
            numbers2 = "";
            tv.setText(numbers2);
        }
    }
}
