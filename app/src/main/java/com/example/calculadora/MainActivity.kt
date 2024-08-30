package com.example.calculadora

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.StringReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var parser:Parser
        var lexer:Lexer
        var lectura:StringReader
        var textoCalcular = ""
        var resultado = ""
        val texto = findViewById<EditText>(R.id.txtTexto)

        //Numeros
        val btn0 = findViewById<Button>(R.id.btn_0)
        val btn1 = findViewById<Button>(R.id.btn_1)
        val btn2 = findViewById<Button>(R.id.btn_2)
        val btn3 = findViewById<Button>(R.id.btn_3)
        val btn4 = findViewById<Button>(R.id.btn_4)
        val btn5 = findViewById<Button>(R.id.btn_5)
        val btn6 = findViewById<Button>(R.id.btn_6)
        val btn7 = findViewById<Button>(R.id.btn_7)
        val btn8 = findViewById<Button>(R.id.btn_8)
        val btn9 = findViewById<Button>(R.id.btn_9)

        //Operadores
        val btnSum = findViewById<Button>(R.id.btn_suma)
        val btnRes = findViewById<Button>(R.id.btn_resta)
        val btnMult = findViewById<Button>(R.id.btn_multi)
        val btnDiv = findViewById<Button>(R.id.btn_div)
        val btnPunto = findViewById<Button>(R.id.btn_punto)
        val btn_ParA = findViewById<Button>(R.id.btn_par_a)
        val btn_ParC = findViewById<Button>(R.id.btn_par_c)
        val btnCLS = findViewById<Button>(R.id.btn_cls)

        btn0.setOnClickListener{
            textoCalcular = texto.getText().toString();
            texto.setText( textoCalcular + "0")
        }

        btn1.setOnClickListener{
            textoCalcular = texto.getText().toString();
            texto.setText( textoCalcular + "1")
        }

        btn2.setOnClickListener{
            textoCalcular = texto.getText().toString();
            texto.setText( textoCalcular + "2")
        }

        btn3.setOnClickListener{
            textoCalcular = texto.getText().toString();
            texto.setText( textoCalcular + "3")
        }

        btn4.setOnClickListener{
            textoCalcular = texto.getText().toString();
            texto.setText( textoCalcular + "4")
        }

        btn5.setOnClickListener{
            textoCalcular = texto.getText().toString();
            texto.setText( textoCalcular + "5")
        }

        btn6.setOnClickListener{
            textoCalcular = texto.getText().toString();
            texto.setText( textoCalcular + "6")
        }

        btn7.setOnClickListener{
            textoCalcular = texto.getText().toString();
            texto.setText( textoCalcular + "7")
        }

        btn8.setOnClickListener{
            textoCalcular = texto.getText().toString();
            texto.setText( textoCalcular + "8")
        }

        btn9.setOnClickListener{
            textoCalcular = texto.getText().toString();
            texto.setText( textoCalcular + "9")
        }

        btnPunto.setOnClickListener{
            textoCalcular = texto.getText().toString();
            texto.setText( textoCalcular + ".")
        }

        btnSum.setOnClickListener{
            textoCalcular = texto.getText().toString();
            texto.setText( textoCalcular + "+")
        }

        btnRes.setOnClickListener{
            textoCalcular = texto.getText().toString();
            texto.setText( textoCalcular + "-")
        }

        btnMult.setOnClickListener{
            textoCalcular = texto.getText().toString();
            texto.setText( textoCalcular + "*")
        }

        btnDiv.setOnClickListener{
            textoCalcular = texto.getText().toString();
            texto.setText( textoCalcular + "/")
        }

        btn_ParA.setOnClickListener{
            textoCalcular = texto.getText().toString();
            texto.setText( textoCalcular + "(")
        }

        btn_ParC.setOnClickListener{
            textoCalcular = texto.getText().toString();
            texto.setText( textoCalcular + ")")
        }

        btnCLS.setOnClickListener{
            texto.setText("")
        }


        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        btnCalcular.setOnClickListener{
            textoCalcular = texto.getText().toString()
            Log.d("TXT", "Texto a calcular: " + textoCalcular)

            lectura=StringReader(textoCalcular)
            lexer=Lexer(lectura)
            parser=Parser(lexer)

            try {
                parser.parse()
            } catch (e:Exception){

            }
            resultado = parser.resultado
            Log.d("RES", resultado)
            texto.setText(resultado)
        }
    }
}