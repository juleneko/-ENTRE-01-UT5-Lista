/**
 * Un objeto de esta clase
 * guarda una lista de números enteros
 * 
 * La clase incluye una serie de métodos de instancia
 * para hacer operaciones sobre la lista
 * y dos  métodos estáticos para trabajar con
 * arrays de dos dimensiones
 *
 * @author - Julen
 */


import java.util.Random;
import java.util.Arrays;
public class ListaNumeros {
    public static final int DIMENSION = 10;
    public static final int ANCHO_FORMATO = 6;
    public static final char CAR_CABECERA = '-';
    
    private static final Random generador = new Random();
    public int[] lista;
    public int pos; 
    /**
     * Constructor de la clase ListaNumeros
     * Crea e inicializa adecuadamente los
     * atributos
     *
     * @param n el tamaño máximo de la lista
     */
    public ListaNumeros(int numero) 
    {
        pos=0;
        lista = new int[numero];
    }

    /**
     * Añade un valor al final de la lista 
     * siempre que no esté completa
     *
     * @param numero el valor que se añade.  
     * @return true si se ha podido añadir, false en otro caso
     */
    public boolean addElemento(int numero) 
    {
        if(pos<lista.length)
        {
            lista[pos]=numero;
            pos++;
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * @return true si la lista está completa, false en otro caso
     * Hacer sin if
     */
    public boolean estaCompleta() 
    {
        return pos==lista.length-1;
    }

    /**
     * @return true si la lista está vacía, false en otro caso.
     * Hacer sin if
     */
    public boolean estaVacia() 
    {
       return pos==0;
    }
    
    /**
     * @return el nº de elementos realmente guardados en la lista
     */
    public void getTotalNumeros() 
    {
        int contador=0;
        while(contador<=pos)
        {
            System.out.print(lista[contador]);
        }
    }
    
    /**
     * Vacía la lista
     */
    public void vaciarLista() 
    {
        int contador=0;
        while(contador<lista.length)
        {
            lista[contador]=0;
            contador++;
        }
        pos=0;
    }
    
    /**
     * @return una cadena con representación textual de la lista 
     * (leer enunciado)
     * 
     * Si la lista está vacía devuelve ""
     */
    public String toString() 
    {
        String t1="";
        String t2="";
        int t3 = ANCHO_FORMATO * pos;
        int c=0;
        while(c<lista.length)
        {
            t1= t1 + " " + lista[c];
            c++;
        }
        while (t3>0)
        {
            t2 =t2 + " " + CAR_CABECERA; 
            t3=t3-1;
        }
        if(pos==0)
        {
            return "";
        }
        return t2 + "\n" + t1 + "\n" + t2 + "\n";
    }
    
    /**
     * Mostrar en pantalla la lista
     */
    public void escribirLista() {
        System.out.println(this.toString());
    }
    
    /**
     *  
     * @return el segundo valor máximo en la lista
     * Cuando no haya un segundo máximo el método 
     * devolverá el valor Integer.MIN_VALUE
     * 
     * Si lista = {21, -5, 28, -7, 28, 77, 77, -17, 21, 15, 28, 28, 77} se devuelve 28
     * Si lista = {21, -5, 28, -7, 77} se devuelve 28
     * Si lista = {77, 21} se devuelve 21
     * Si lista = {21} se devuelve Integer.MIN_VALUE
     * Si lista = {21, 21, 21, 21} se devuelve Integer.MIN_VALUE
     * 
     * No se puede usar ningún otro array auxiliar ni hay que ordenar previamente
     * la lista
     */
    public int segundoMaximo() 
    {       
        int max=lista[0];
        int max2=lista[0];
        int c=0;
        while(c<lista.length)
        {
            if(lista.length==0 && pos==1)
            {
                return Integer.MIN_VALUE;
            }
            else
            {
                if(lista.length>c+1 && lista[c+1]>max)
                {
                    max= lista[c+1];
                }
                if(lista[c]<max && lista[c]>max2)
                {
                    max2=lista[c];
                }
            }
            c++;
        }
        return max2;
    }

    /**
     * El método coloca los valores que son segundos máximos al principio de
     * la lista respetando el orden de aparición del resto de elementos
     * 
     * No se puede usar ningún otro array auxiliar ni hay que ordenar previamente
     * la lista
     * 
     * Si lista = {21, -5, 28, -7, 28, 77, 77, -17, 21, 15, 28, 28, 77} 
     * lista queda  {28, 28, 28, 28, 21, -5, -7, 77, 77, -17, 21, 15, 77} y se devuelve true
     * 
     * Si lista = {77, 21} lista queda {21, 77} y se devuelve true
     * Si lista = {21} lista queda igual y se devuelve false
     * Si lista = {21, 21, 21, 21} lista queda igual y se devuelve false
     * 
     * @return true si se han colocado los segundos máximos
     *          false si no se han colocado los segundos máximos porque no había ninguno
     */
    public int[] segundosMaximosAlPrincipio() 
    {
        int c=0;
        int t1=segundoMaximo();
        int t2=0;
        while(c<lista.length)
        {
            if (lista[c]==t1)
            {
                t2++;
            }
            c++;
        }
        int c2=lista.length-1;
        int c3=lista.length-1;
        int c4=lista.length-1;
        while(c4==0)
        {
            if(lista[c2]!=t1)
            {
                lista[c3]=lista[c2];
                c2=c2-1;
                c3=c3-1;
            }else if(lista[c2]==t1 && lista[c2-1]!=t1 && c2>t2)
                {
                    lista[c3]=lista[c2-1];
                    c2=c2-2;
                    c3=c3-1;
                }
                    else if (lista[c2]==t1 && lista[c2-2]==t1 && c2>t2)
                    {
                        lista[c3]=lista[c2-2];
                        c2=c2-2;
                        c3=c3-1;
                    }
                        else if (lista[c2]==t1 && c2<t2 && t2>0)
                        {
                            lista[c3]=t1;
                            c2=c2-1;
                            c3=c3-1;
                            t2=t2-1;
                        }
            c4=c4-1;
        }
        return lista;
    }

    /**
     * @param numero búsqueda binaria de  numero en lista
     * @return devuelve -1 si no se encuentra o la posición en la que aparece
     *  
     * El array original lista no se modifica
     * Para ello crea  previamente una copia
     * de lista y trabaja  con la copia
     *  
     * Usa exclusivamente métodos de la clase Arrays
     */
    public int buscarBinario(int numero) 
    {
        int[] lista2=lista;         
        int c=0;
        Arrays.sort(lista2);
        return Arrays.binarySearch(lista2, numero);
    }

    /**
     * 
     * @return devuelve un array bidimensional de enteros de tamaño DIMENSION
     * inicializado con valores aleatorios entre 0 y 10 inclusive
     * 
     * Estos valores van a representar el brillo de una zona del espacio
     * 
     */
    public int[][] crearBrillos() 
    {
        int[][] t1=new int[DIMENSION][DIMENSION];
        int c=0;
        int c2=0;
        while (c<t1.length)
        {
            t1[c][c2]=generador.nextInt(11);
            c2++;
            if (c2==t1[c].length)
            {
                c++;
                c2=0;
            }
        }
        return t1;
    }

    /**
     * @param  un array bidimensional brillos 
     * @return un nuevo array bidimensional de valores booleanos
     *          de las mismas dimensiones que el array brillos con
     *          valores true en las posiciones donde hay estrellas
     * 
     * Una posición f,c del array brillos es una estrella 
     * si la suma del valor de los brillos de sus cuatro vecinos 
     * (arriba, abajo, derecha e izquierda) es mayor que 30
     * 
     * Nota -  No hay estrellas en los bordes del array brillos
     */
    public boolean[][] detectarEstrellas() 
    {
        int c=0;
        int c2=0;
        int c3=0;
        boolean[][] t1=new boolean[DIMENSION][DIMENSION];
        int[][] t2 = crearBrillos();
        while (c3<t1.length)
        {
            if (c2==t1[c].length)
            {
                c2=0;
                c++;
            }    
            if(c==0 || c2==0 || c==t1.length || c2==t1[c].length)
            {
                t1[c][c2]=false;
                c2++;
            } 
            if(c>0 && c2>0 && c<t1.length-1 && c2<t1[c].length-1)
            {
                if(t2[c][c2] + t2[c-1][c2] + t2[c+1][c2] + t2[c][c2-1] + t2[c][c+1]> 30)
                {
                    t1[c][c2]=true;
                    c2++;
                }
                else
                {
                    t1[c][c2]=false;
                    c2++;
                }   
            }
            c3++;
        }
        return t1;
    }
}
