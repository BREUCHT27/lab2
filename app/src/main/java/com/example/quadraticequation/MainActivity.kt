package com.example.quadraticequation

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.Math.sqrt

class MainActivity : AppCompatActivity() {
            @SuppressLint("SetTextI18n")
            @Override
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)
                val a = findViewById<EditText>(R.id.Text_a);
                val b = findViewById<EditText>(R.id. Text_b);
                val c = findViewById<EditText>(R.id.Text_c);
                val button = findViewById<Button>(R.id.button1);
                val result = findViewById<TextView>(R.id.textView_all);
                button.setOnClickListener(){
                    if (!a.getText().toString().equals("") && !b.getText().toString().equals("")
                        && !c.getText().toString().equals("")){
                        val A = a.getText().toString().format("%.2f").toDoubleOrNull();
                        val B = b.getText().toString().format("%.2f").toDoubleOrNull();
                        val C = c.getText().toString().format("%.2f").toDoubleOrNull();
                        if (A == 0.0) {
                            fun Lineal(b: Double?, c: Double?) = -c!! / b!!
                            if (B != 0.0 && C != 0.0) {
                                result.text = "Квадратное уравнение стало линейным!!!\nx =" + Lineal(B, C);
                            };
                            if (B == 0.0 && C == 0.0) {
                                result.text = "Не является квадратным уравнением и при таких коэффициентах оно принимает верное равенство!!!";
                            };
                            if (B == 0.0 && C != 0.0) {
                                result.text = "Не является квадратным уравнением и при таких коэффициентах выражение не будет уравнением!!!";
                            };
                        }
                        else{
                            fun d(a: Double, b: Double, c: Double) = Math.pow(b, 2.0) - 4 * a * c
                            val dist = d(A!!, B!!, C!!);
                            fun Positive(a: Double, b: Double, c: Double) = (-b + sqrt(d(a, b, c))) / (2 * a)
                            fun Negative(a: Double, b: Double, c: Double) = (-b - sqrt(d(a, b, c))) / (2 * a)
                            fun Zero(a: Double, b: Double) = (-b / (2 * a))
                            if (dist < 0.0) {
                                result.text = "Дискриминант меньше нуля\nи от этого корней у уравнения не существует!!!";
                            }
                            if (dist > 0.0) {
                                result.text = "x1 = " + Positive(A, B, C) + "\nx2 = " + Negative(A, B, C);
                            }
                            if(dist == 0.0){
                                result.text = "Уравнение имеет один корень\nx1 = x2 = " + Zero(A, B);
                            }
                        }
                    }
                    else {
                        result.text = "Заполните все поля!!!"
                    }
                }
            }
        }
