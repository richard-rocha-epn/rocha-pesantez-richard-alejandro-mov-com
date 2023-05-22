import java.util.*

fun main(args: Array<String>) {
    println("Hello World!")

    //tipos de variables

    //inmutables (no se pueden reasignar "=")
    val inmutable: String = "Richard";


    //mutables (re asignar)
    var mutable: String="Richard";
    mutable = "Alejandro";
    println("el valor de VAl: "+inmutable+"\nEl valor de VAR: "+mutable);



    //Duck typing
    val ejemploVariable = "Richard Rocha"
    val edadEjemplo: Int = 12;
    ejemploVariable.trim(); // quita los espacios en blanco

    //variable primitivo
    val nombreProfesor: String = "Adrian Eguez";
    val sueldo: Double = 1.2;
    val estadoCivil: Char = 'c';
    val mayorEdad:Boolean = true;

    //clases de java
    val fechaNacimiento: Date = Date()

    //No existe el switch
    //pero tenemos when
    val estadoCivilWhen = "C";
    when(estadoCivilWhen){
        ("C")->{println("Estado civil: Casado")}
        "S"->{println("Estado Civil: Soltero")}
        else->{println("No sabemos")}

    }

    //if else de una linea
    val coqueto = if (estadoCivilWhen == "S") "Si" else "No";
    println("Es coqueto?: "+coqueto)



    //En kotlin no tenemos VOID

    fun imprimirNombre(nombre:String): Unit{
        println("Nombre: ${nombre}")
    }

    fun calcularSueldo(
        sueldo: Double, //requerido
        tasa: Double = 12.00, //opcional(defecto)
        bonoEspecial: Double? = null, //opcion null -> nullable
    ): Double{
        if(bonoEspecial == null){
            return sueldo*(100/tasa)
        }else {
            return sueldo * (100 / tasa) + bonoEspecial
        }
    }


    println("el sueldo es: "+calcularSueldo(10.00));
    println("el sueldo es: "+calcularSueldo(10.00, bonoEspecial = 20.00)) // nombrar parametros para no tener que digitar todos los aprametros
    println("el sueldo es: "+calcularSueldo(sueldo=10.00, tasa=14.00, bonoEspecial = 15.00))

}

abstract class numerosJava{
    protected val numeroUno: Int;
    private val numeroDos: Int;
    constructor(
        uno: Int,
        dos: Int
    ){
        //bloque de codigo del constructor.
        this.numeroUno = uno
        this.numeroDos = dos
        println("Inicializando.")
    }
}

abstract class numeros(// constructor primario
    //ejemplo:
    //uno: Int, (parametro (sin modificador de acceso))
    //public var uno: Int, // propiedad publica de clase numeros, uno.
    protected val numeroUno: Int,
    protected val numeroDos: Int,
 ){
    //var cedula: String = "" (public)
    //private valorCalculado: Int = 0 (private)
    init {
        this.numeroUno; this.numeroDos; //el this es opcional
        println("Inicializando")
    }
}