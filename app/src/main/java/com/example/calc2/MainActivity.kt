package com.example.calc2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.TestLooperManager
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var old_value =""
    var pre_operator ="+"
    var isnewop = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun Num_button(view: View) {
        if (isnewop) {
            answer.setText("")
        }
        isnewop=false
            var btn_selected = answer.text.toString()
            var btn_clicked = view as MaterialButton
            when (btn_clicked.id) {
                btn_9.id -> btn_selected += "9"
                btn_8.id -> btn_selected += "8"
                btn_7.id -> btn_selected += "7"
                btn_6.id -> btn_selected += "6"
                btn_5.id -> btn_selected += "5"
                btn_4.id -> btn_selected += "4"
                btn_3.id -> btn_selected += "3"
                btn_2.id -> btn_selected += "2"
                btn_1.id -> btn_selected += "1"
                btn_zero.id -> btn_selected += "0"
                btn_dot.id -> btn_selected += "."
            }
            answer.setText(btn_selected.toString())
    }

    fun op_button(view: View) {
        isnewop = true
         old_value = answer.text.toString()
        var op_btn = view as MaterialButton
        when(op_btn.id)
        {
            btn_mod.id -> pre_operator = "%"
            btn_div.id -> pre_operator = "/"
            btn_mul.id -> pre_operator = "x"
            btn_min.id -> pre_operator = "-"
            btn_pul.id -> pre_operator = "+"
        }

    }

    fun equal(view: View) {

        if(answer.text.toString()!=""){

            val new_ans = answer.text.toString()
            var solution=0.0
            when(pre_operator){
                "/" -> solution =  old_value.toDouble() / new_ans.toDouble()
                "x" -> solution =  old_value.toDouble() * new_ans.toDouble()
                "-" -> solution =  old_value.toDouble() - new_ans.toDouble()
                "+" -> solution =  old_value.toDouble() + new_ans.toDouble()
                "%" -> solution =  old_value.toDouble() / 100
            }
            answer.setText(solution.toString())
        }
    }

    fun AC(view: View) {
        answer.setText("")
    }

    fun clear(view: View) {
        var clear:String? = null
        if (answer.text.length>0) {
            var string_builder: StringBuilder = StringBuilder(answer.text.toString())
            val last =answer.text.toString().last()
            string_builder.deleteCharAt(answer.text.toString().length - 1)
            clear=string_builder.toString()
            answer.setText(clear)
        }

    }


}




