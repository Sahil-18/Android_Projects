package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    lateinit var zero: TextView
    lateinit var one: TextView
    lateinit var two: TextView
    lateinit var three: TextView
    lateinit var four: TextView
    lateinit var five: TextView
    lateinit var six: TextView
    lateinit var seven: TextView
    lateinit var eight: TextView
    lateinit var nine: TextView

    lateinit var addition: TextView
    lateinit var subtract: TextView
    lateinit var multiply: TextView
    lateinit var division: TextView
    lateinit var modulo: TextView
    lateinit var changesign: TextView
    lateinit var equal: TextView
    lateinit var decimal: TextView
    lateinit var ac: TextView
    lateinit var backspace: ImageView

    lateinit var expression: TextView
    lateinit var result: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        zero = findViewById(R.id.zero)
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)

        addition = findViewById(R.id.addition)
        subtract = findViewById(R.id.subtract)
        multiply = findViewById(R.id.multiply)
        division = findViewById(R.id.divide)
        modulo = findViewById(R.id.modulo)
        changesign = findViewById(R.id.changesign)
        decimal = findViewById(R.id.decimal)
        equal = findViewById(R.id.equal)
        ac = findViewById(R.id.ac)
        backspace = findViewById(R.id.back)

        expression = findViewById(R.id.expression)
        result = findViewById(R.id.result)

        zero.setOnClickListener() {
            appendText("0", true)
        }

        one.setOnClickListener() {
            appendText("1", true)
        }

        two.setOnClickListener() {
            appendText("2", true)
        }

        three.setOnClickListener() {
            appendText("3", true)
        }

        four.setOnClickListener() {
            appendText("4", true)
        }

        five.setOnClickListener() {
            appendText("5", true)
        }

        six.setOnClickListener() {
            appendText("6", true)
        }

        seven.setOnClickListener() {
            appendText("7", true)
        }

        eight.setOnClickListener() {
            appendText("8", true)
        }

        nine.setOnClickListener() {
            appendText("9", true)
        }

        addition.setOnClickListener() {
            appendText("+", false)
        }

        subtract.setOnClickListener() {
            appendText("-", false)
        }

        multiply.setOnClickListener() {
            appendText("*", false)
        }

        division.setOnClickListener() {
            appendText("/", false)
        }

        modulo.setOnClickListener() {
            appendText("%", false)
        }

        equal.setOnClickListener(){
            try {
                val expr = ExpressionBuilder(expression.text.toString()).build()
                val answer = expr.evaluate()
                result.text = answer.toString()
            } catch (exception: Exception) {
                result.text = exception.message
            }
        }

        decimal.setOnClickListener(){
            appendText(".",true)
        }

        changesign.setOnClickListener(){
            result.text=""
            result.hint=""
            if(expression.text.isNotEmpty()){
                if(expression.text.toString()[0].equals("-")){
                    expression.text=expression.text.substring(1) // Give output as string from index 1 onwards
                }else{
                    expression.text="-${expression.text}"
                }
            }
        }

        backspace.setOnClickListener(){
            result.text=""
            result.hint=""

            if(expression.text.isNotEmpty()){
                expression.text = expression.text.substring(0,expression.text.length-1)
            }
        }

        ac.setOnClickListener(){
            result.text=""
            result.hint=""
            expression.text=""
        }
    }

    private fun appendText(value: String, toBeCleared: Boolean){
        if(result.text!=""){
            expression.text=""
        }
        if(toBeCleared){
            result.text=""
            expression.append(value)
        }else{
            expression.append(result.text)
            expression.append(value)
            result.text=""
        }
        result.hint=expression.text
    }
}