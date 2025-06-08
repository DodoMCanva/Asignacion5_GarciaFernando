package garcia.fernando.calculadoraaritmetica

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var texto = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val impresion : TextView = findViewById(R.id.Impresion)
        val suma : Button = findViewById(R.id.sumar)
        val resta : Button = findViewById(R.id.restar)
        val multiplicacion : Button = findViewById(R.id.multiplicar)
        val dividir : Button = findViewById(R.id.dividir)
        val igual : Button = findViewById(R.id.resultado)

        val n1 : Button = findViewById(R.id.button1)
        val n2 : Button = findViewById(R.id.button2)
        val n3 : Button = findViewById(R.id.button3)
        val n4 : Button = findViewById(R.id.button4)
        val n5 : Button = findViewById(R.id.button5)
        val n6 : Button = findViewById(R.id.button6)
        val n7 : Button = findViewById(R.id.button7)
        val n8 : Button = findViewById(R.id.button)
        val n9 : Button = findViewById(R.id.button8)
        val n0 : Button = findViewById(R.id.button9)

        suma.setOnClickListener{
            if (texto.concatenacion()){
                texto = texto+'+'
                impresion.setText(texto)
            }else{
                println("concatenacion invalida")
            }
        }
        resta.setOnClickListener{
            if (texto.concatenacion()){
                texto = texto+'-'
                impresion.setText(texto)
            }else{
                println("concatenacion invalida")
            }
        }
        dividir.setOnClickListener{
            if (texto.concatenacion()){
                texto = texto+'/'
                impresion.setText(texto)
            }else{
                println("concatenacion invalida")
            }

        }
        multiplicacion.setOnClickListener{
            if (texto.concatenacion()){
                texto = texto+'x'
                impresion.setText(texto)
            }else{
                println("concatenacion invalida")
            }
        }

        igual.setOnClickListener{
            if (texto.concatenacion()){
                impresion.setText(texto.resolver())
                texto = ""
            }else{
                println("concatenacion invalida")
            }

        }

        n1.setOnClickListener{
            texto = texto+'1'
            impresion.setText(texto)
        }
        n2.setOnClickListener{
            texto = texto+'2'
            impresion.setText(texto)
        }
        n3.setOnClickListener{
            texto = texto+'3'
            impresion.setText(texto)
        }
        n4.setOnClickListener{
            texto = texto+'4'
            impresion.setText(texto)
        }
        n5.setOnClickListener{
            texto = texto+'5'
            impresion.setText(texto)
        }
        n6.setOnClickListener{
            texto = texto+'6'
            impresion.setText(texto)
        }
        n7.setOnClickListener{
            texto = texto+'7'
            impresion.setText(texto)
        }
        n8.setOnClickListener{
            texto = texto+'8'
            impresion.setText(texto)
        }
        n9.setOnClickListener{
            texto = texto+'9'
            impresion.setText(texto)
        }
        n0.setOnClickListener{
            if (texto[texto.length-1] != '/'){
                texto = texto+'0'
                impresion.setText(texto)
            }

        }
    }

    fun String.concatenacion():Boolean{
        if (this[this.length-1] != '+' && this[this.length-1] != '-'  && this[this.length-1] != '/' && this[this.length-1] != 'x'){
            return true
        }else{
            return false
        }
    }

    fun String.resolver():String{
        var numero = ""
        val numeros = mutableListOf<Int>()
        val operadores = mutableListOf<Char>()
        for (c in this){
            if(c in '0'..'9'){
                numero = numero + c
            }else{
                if (!numero.isEmpty()){
                    numeros.add(numero.toInt())
                    numero = ""
                }
                operadores.add(c)
            }
        }


        if (!numero.isEmpty()){
            numeros.add(numero.toInt())
            numero = ""
        }
        while (operadores.contains('x') || operadores.contains('/')) {
            for (index in operadores.indices) {
                if (operadores[index] == 'x' || operadores[index] == '/') {
                    var izquierda = numeros[index]
                    var derecha = numeros[index + 1]
                    val resultado = if (operadores[index] == 'x') {
                        izquierda * derecha
                    } else {
                        izquierda / derecha
                    }
                    numeros[index] = resultado
                    numeros.removeAt(index + 1)
                    operadores.removeAt(index)
                    break
                }
            }
        }
        var acumulador = numeros[0]
        for (index in operadores.indices){
            if (operadores[index] == '+' || operadores[index] == '-' ){
                var numero = numeros[index+1]
                if (operadores[index] == '+'){
                    acumulador = acumulador+numero
                }else{
                    acumulador = acumulador-numero
                }
            }
        }
        return acumulador.toString()
    }
}