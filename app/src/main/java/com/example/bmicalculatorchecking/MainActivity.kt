package com.example.bmicalculatorchecking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        try {

            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            calculate.setOnClickListener() {
                val weight = inputWeight.text.toString().toDouble();
                val height: Double = inputHeight.text.toString().toDouble();
                val bmi: Double = weight / Math.pow(height, 2.0);
                var showStat: String = " ";

                stats.text= " %s".format(showStat)


                if (bmi < 18.5) {
                    imgResult.setImageResource(R.drawable.under)
                    showStat="under";
                } else if (bmi <= 24.9) {
                    imgResult.setImageResource(R.drawable.normal)
                    showStat="normal";                }
                else{
                    imgResult.setImageResource(R.drawable.over)
                    showStat="over";
                }
                bmiResult.text = "%.2f(%s)".format(bmi,showStat);
            }

            reset.setOnClickListener() {
                imgResult.setImageResource(R.drawable.empty);
                stats.text=" ";
                bmiResult.text=" ";



            }
        }catch(ex:Exception){
            val toast: Toast=Toast.makeText( this,"Invalid input!!!", Toast.LENGTH_LONG)
            toast.setGravity(Gravity.CENTER,0, 0)
            toast.show()


        }


    }

}
