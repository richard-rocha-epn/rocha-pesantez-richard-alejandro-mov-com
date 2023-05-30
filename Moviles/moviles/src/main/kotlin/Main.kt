import java.util.*
import kotlin.collections.ArrayList

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

    val sumaUno = Suma(1,1)
    val sumaDos = Suma(null, 1)
    val sumaTres = Suma(1, null)
    val sumaCuatro = Suma(null,null)
    sumaUno.sumar()
    sumaDos.sumar()
    sumaTres.sumar()
    sumaCuatro.sumar()
    println(Suma.pi)
    println(Suma.elevarAlCuadrado(2))
    println(Suma.historialSuma)


    //Arreglos
    //Tipos de arrelogs

    //ESTATICO - No se puede editar
    val arregloEstatico: Array<Int> = arrayOf<Int>(1,2,3,4)
    println("Este es un arreglo estatico: $arregloEstatico" )

    //Arreglo Dinamicos
    val arregloDinamico: ArrayList<Int> = arrayListOf<Int>(1,2,3,4,5,6,7,8,9,10)
    println("Este es un arreglo Dinamico: "+ arregloDinamico)
    arregloDinamico.add(11);
    arregloDinamico.add(12);
    println("Este es un arreglo Dinamico despues de agregar: "+arregloDinamico)

    print("Respuesta forEach largo:");
    //foreach para arreglo dinmico o estatico.
    val respuestaForEach: Unit = arregloDinamico.forEach{
        valorArray:Int -> println("Valor actual: $valorArray ")
    }
    //print("Respuesta forEach largo: \n"+respuestaForEach)
    //una forma simplificada es
    println("Forma automatica de forEach:\n")
    arregloDinamico.forEach{ println("Valor: $it") } //va iterando automaticamente
    println("\nForEach con indices\n")
    //podemos pasar dos parametros, es decir con el index1
    arregloEstatico.forEachIndexed{indice: Int, valorArray:Int ->
        println("Valor $valorArray \tIndice: $indice")
    }


    //MAP -> modificar y crar un nuevo arreglo con la informacion que deseemos
    /*1) evieoms el nuevo valor de la iteraccion
    * 2) nos devuelve es un nuevo arreglo con los valores modificados
    * */
    val respuestaMap: List<Double> = arregloDinamico.map{
        valorActual:Int -> return@map valorActual.toDouble() + 100.00
    }
    print("\nMap largo\n")
    respuestaMap.forEach{print("$it\t")}
    print("\nMap corto\n")
    //la forma simplificada de map
    val respuestaSimpMap = arregloDinamico.map {it+15};
    respuestaSimpMap.forEach{print("$it\t")}

    /*Filter -> filtrar un arreglo
    1-devolver una expresion true o false
    2- nuevo arreglo filtrado
    * */
    val respuestaFilter: List<Int> = arregloDinamico.filter {
        valorActual: Int -> val mayorACinco: Boolean = valorActual >5 //expresion o condicion
        return@filter mayorACinco
    }
    val respuestaSimFilter = arregloDinamico.filter { it <=5 }
    println("\nArreglo filtado largo: $respuestaFilter")
    println("Arreglo filtrado corto: $respuestaSimFilter")

    //or and
    /* or -> any alguno cumple
    and -> all todos cumplen
    * */
    val respuestaAny: Boolean = arregloDinamico.any{
        valorActual: Int -> return@any(valorActual>5)
    }
    println("Respuesta Any: $respuestaAny");

    val respuestaAll: Boolean = arregloDinamico.all{
        valorActual: Int -> return@all (valorActual >5)
    }
    println("Repuesta all: $respuestaAll")

    /*
    * Reduce -> valor acumulado
    * valor acumulado = 0 (siempre 0 en lenaje kotlin)
    * [1,2,3,4,5] -> sumeme todos los valores del arreglo
    * */

    val respuestaReduce: Int = arregloDinamico.reduce{
        //acumulado=0 -> siempre inicia en cero
        acumulado: Int, valorActual:Int -> return@reduce (acumulado+valorActual)
    }
    println("vamos a sumar los valores del array: $respuestaReduce");



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


class Suma( uno:Int, dos:Int):numeros(uno,dos){
    init{
        this.numeroUno;
        this.numeroDos;
    }
    constructor(uno:Int?, dos:Int): this( if(uno==null) 0 else uno, dos)
    constructor(uno:Int, dos:Int?): this(uno, if(dos==null) 0 else uno)
    constructor(uno:Int?, dos:Int?): this(if(uno==null)0 else uno, if(dos==null)0 else dos)

    public fun sumar(): Int{
        val total= numeroUno+numeroDos
        agregarHistorial(total)
        return total
    }

    companion object { //atributos y metodos compartidos
        //entre las instancias
        val pi=3.14
        fun elevarAlCuadrado(num: Int): Int{
            return num*num
        }
        val historialSuma = arrayListOf<Int>()
        fun agregarHistorial(valorNuevaSuma:Int){
            historialSuma.add(valorNuevaSuma)
        }

    }



}

