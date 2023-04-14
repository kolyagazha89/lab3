package com.example.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.math.*
import android.widget.RelativeLayout
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn_clear: Button = findViewById(R.id.btn_clear) as Button;
        var btn_plus_minus: Button = findViewById(R.id.btn_plus_minus) as Button;
        var btn_proc: Button = findViewById(R.id.btn_proc) as Button;
        var btn_del: Button = findViewById(R.id.btn_del) as Button;
        var btn_umz: Button = findViewById(R.id.btn_umz) as Button;
        var btn_minus: Button = findViewById(R.id.btn_minus) as Button;
        var btn_plus: Button = findViewById(R.id.btn_plus) as Button;
        var btn_ravno: Button = findViewById(R.id.btn_ravno) as Button;
        var btn_nine: Button = findViewById(R.id.btn_nine) as Button;
        var btn_eight: Button = findViewById(R.id.btn_eight) as Button;
        var btn_seven: Button = findViewById(R.id.btn_seven) as Button;
        var btn_six: Button = findViewById(R.id.btn_six) as Button;
        var btn_five: Button = findViewById(R.id.btn_five) as Button;
        var btn_four: Button = findViewById(R.id.btn_four) as Button;
        var btn_three: Button = findViewById(R.id.btn_three) as Button;
        var btn_two: Button = findViewById(R.id.btn_two) as Button;
        var btn_one: Button = findViewById(R.id.btn_one) as Button;
        var btn_zero: Button = findViewById(R.id.btn_zero) as Button;
        var btn_tochka: Button = findViewById(R.id.btn_tochka) as Button;
        var text_write: TextView = findViewById(R.id.text_write) as TextView;

        fun removeLastChar(str: String?): String? {
            return str?.replaceFirst(".$".toRegex(), "")
        }

        var A: Double = 0.0;
        var B: Double = 0.0;
        var method: String = "";
        var write_text:Boolean=false;
        text_write.setOnTouchListener(object : OnSwipeTouchListener(this@MainActivity) {
            override fun onSwipeLeft() {
                super.onSwipeLeft()
                if (text_write.text !="0" && method==""  && !write_text) {
                    var x: String = text_write.text.toString();
                    text_write.setText(removeLastChar(x))
                    if (text_write.text==""){
                        text_write.setText("0")
                    }
                }
            }
            override fun onSwipeRight() {
                super.onSwipeRight()
                if (text_write.text !="0" && method=="" && !write_text) {
                    var x: String = text_write.text.toString();
                    text_write.setText(removeLastChar(x))
                    if (text_write.text==""){
                        text_write.setText("0")
                    }
                }
            }
        })

        fun goToInt(result:Double):String{
           if (Math.floor(result) == result){
               return result.toInt().toString();
           }else{
                return  result.toString()
           }
        }
        fun resultMethod(){
            if (method=="plus"){
                B = text_write.text.toString().toDouble();
                text_write.setText(goToInt(A + B));
                A = text_write.text.toString().toDouble();
                write_text=true;
            }
            if (method=="minus"){
                B = text_write.text.toString().toDouble();
                text_write.setText(goToInt(A - B));
                A = text_write.text.toString().toDouble();
                write_text=true;
            }
            if (method=="umz"){
                B = text_write.text.toString().toDouble();
                text_write.setText(goToInt(A * B));
                A = text_write.text.toString().toDouble();
                write_text=true;
            }
            if (method=="del"){
                B = text_write.text.toString().toDouble();
                if(B!=0.0){
                    text_write.setText(goToInt(A / B));
                }else {
                    text_write.setText("ОШИБКА");
                }
                A = text_write.text.toString().toDouble();
                write_text=true;
            }
            method=""
        }
        btn_proc.setOnClickListener(){
            if(A == 0.0) {
                var x:Double = text_write.text.toString().toDouble();
                text_write.setText(goToInt(x/100));
            }else if (method=="umz" || method=="del"){
                B = text_write.text.toString().toDouble();
                text_write.setText(goToInt(B/100));
            }
            else{
                B = text_write.text.toString().toDouble() * A / 100;
                text_write.setText(goToInt(B));
            }
            write_text=true;
        }
        btn_plus.setOnClickListener() {
            if (method != "") {
                resultMethod();
                method="plus";
            }else{
                A = text_write.text.toString().toDouble();
                method = "plus";
                write_text=true;
            }
        }
        btn_minus.setOnClickListener() {
            if (method != "") {
                resultMethod();
                method = "minus";
            }else{
                A = text_write.text.toString().toDouble();
                method = "minus";
                write_text=true;
            }
        }
        btn_umz.setOnClickListener() {
            if (method != "") {
                resultMethod();
                method = "umz";
            }else{
                A = text_write.text.toString().toDouble();
                method = "umz";
                write_text=true;
            }
        }
        btn_del.setOnClickListener() {
            if (method != "") {
                resultMethod();
                method = "del";
            }else{
                A = text_write.text.toString().toDouble();
                method = "del";
                write_text=true;
            }
        }
        btn_plus_minus.setOnClickListener(){
            if (text_write.text!="0") {
                var value: String = goToInt(text_write.text.toString().toDouble() * (-1));
                text_write.setText(value);
            }

        }
        btn_ravno.setOnClickListener() {
            B = text_write.text.toString().toDouble();
            if (method == "plus") {
                text_write.setText(goToInt(A + B));
            }
            if (method == "minus") {
                text_write.setText(goToInt(A - B));
            }
            if (method == "umz") {
                text_write.setText(goToInt(A * B));
            }
            if (method == "del") {
                if(B==0.0){
                    text_write.setText("ОШИБКА");
                }else{
                    text_write.setText(goToInt(A / B));
                }
            }
            write_text=true;
            method=""
        }

        btn_clear.setOnClickListener() {
            text_write.setText("0");
            method=""
        }
        btn_one.setOnClickListener() {
            if (text_write.text == "") {
                text_write.setText("1");
            } else {
                if (text_write.text == "0" || write_text ) {
                    text_write.setText("1");
                    write_text=false;
                } else {
                    text_write.setText(text_write.text.toString() + "1")
                }
            }
        }
        btn_two.setOnClickListener() {
            if (text_write.text == "") {
                text_write.setText("2");
            } else {
                if (text_write.text == "0" || write_text) {
                    text_write.setText("2");
                    write_text=false;
                } else {
                    text_write.setText(text_write.text.toString() + "2")
                }
            }
        }
        btn_three.setOnClickListener() {
            if (text_write.text == "") {
                text_write.setText("3");
            } else {
                if (text_write.text == "0" || write_text) {
                    text_write.setText("3");
                    write_text=false;
                } else {
                    text_write.setText(text_write.text.toString() + "3")
                }
            }
        }
        btn_four.setOnClickListener() {
            if (text_write.text == "") {
                text_write.setText("4");
            } else {
                if (text_write.text == "0" || write_text) {
                    text_write.setText("4");
                    write_text=false;
                } else {
                    text_write.setText(text_write.text.toString() + "4")
                }
            }
        }
        btn_five.setOnClickListener() {
            if (text_write.text == "") {
                text_write.setText("5");
            } else {
                if (text_write.text == "0" || write_text) {
                    text_write.setText("5");
                    write_text=false;
                } else {
                    text_write.setText(text_write.text.toString() + "5")
                }
            }
        }
        btn_six.setOnClickListener() {
            if (text_write.text == "") {
                text_write.setText("6");
            } else {
                if (text_write.text == "0" || write_text) {
                    text_write.setText("6");
                    write_text=false;
                } else {
                    text_write.setText(text_write.text.toString() + "6")
                }
            }
        }
        btn_seven.setOnClickListener() {
            if (text_write.text == "") {
                text_write.setText("7");
            } else {
                if (text_write.text == "0" || write_text) {
                    text_write.setText("7");
                    write_text=false;
                }else {
                    text_write.setText(text_write.text.toString() + "7")
                }
            }
        }
        btn_eight.setOnClickListener() {
            if (text_write.text == "") {
                text_write.setText("8");
            } else {
                if (text_write.text == "0" || write_text) {
                    text_write.setText("8");
                    write_text=false;
                }else {
                    text_write.setText(text_write.text.toString() + "8")
                }
            }
        }
        btn_nine.setOnClickListener() {
            if (text_write.text == "") {
                text_write.setText("9");
            } else {
                if (text_write.text == "0" || write_text) {
                    text_write.setText("9");
                    write_text=false;
                }else {
                    text_write.setText(text_write.text.toString() + "9")
                }
            }
        }
        btn_zero.setOnClickListener() {
            if (text_write.text == "") {
                text_write.setText("");
            } else {
                if (text_write.text == "0" || write_text) {
                    text_write.setText("0");
                    write_text=false;
                } else {
                    text_write.setText(text_write.text.toString() + "0")
                }
            }
        }
        btn_tochka.setOnClickListener() {
            var txt = text_write.text.toString();
            var toch = txt.split('.');
            if (toch.count() == 1) {
                text_write.setText(text_write.text.toString() + ".");
            }
        }
    }
}