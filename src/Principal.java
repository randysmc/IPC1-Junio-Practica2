package src;

import java.util.Scanner;


public class Principal {
    final int TAMANO_MATRIZ =30;
    final int TAMANO_PERS =4;
    final int TAMANO_PELIS =5;
    final int TAMANO_TIENDA =3;
    String [][] personas =  new String[TAMANO_MATRIZ][4];
    String [][] peliculas = new String[TAMANO_MATRIZ][5];
    String [][] prestamoPeliculas = new String[30][5];
    //String [][] manejoPeliculas = new String[TAMANO_MATRIZ][2]
    int posicion;  //var para buscar la posicion donde se insertara un nuevo usuario/pelicula
    int tamanoArreglo;  //var para imprimir la matriz segun el tamano que tenga
    int masAlquilada;   //para llevar control sobre la pelicula mas alquilada
    int menorAlquilada; //lleva un control de la pelicula menos alquilada
    int numeroVecesAlquiler =0; //contador para las veces que se alquila una pelicula
    boolean poseePeliculas; //para saber si el usuario posee alguna pelicula
    boolean peliculaDisponible;//para saber si la pelicula esta disponible o alquilada
    boolean existeID =true; //para saber si el ID que se ingreso existe
    Scanner teclado = new Scanner(System.in);
    int eleccion =0;
    int ID;
    int usuario, prestamo, diasPrestamo;




    public Principal(){
        System.out.println("HOLA");
        System.out.println("HOLAAAAAAAAAAAA");
        catalogoUsuario();
        catalogoDePeliculas();
        seleccionarMenu();


    }

    public void seleccionarMenu(){
        while(eleccion !=9){
            mostrarOpciones();
            eleccion = Integer.parseInt(teclado.nextLine());
            switch(eleccion){
                case 1:
                    System.out.println("Prestamo de peliculas");
                    prestarPelicula();
                    break;
                case 2:
                    System.out.println("Devolucion de peliculas");
                    devolverPelicula();
                    break;
                case 3:
                    System.out.println("Mostrar peliculas");
                    imprimirPeliculas();
                    //imprimirPrestamoPeliculas();
                    break;
                case 4:
                    System.out.println("Ingresar peliculas");
                    ingresarPelicula();
                    break;
                case 5:
                    System.out.println("Ordenar peliculas");
                    ordenarPorNombre(peliculas, 1);
                    break;
                case 6:
                    System.out.println("Ingresar usuario");
                    ingresarUsuario();
                    break;
                case 7:
                    imprimirUsuario();
                    System.out.println("Mostrar clientes");
                    break;
                case 8:
                    System.out.println("Reportes");
                    imprimirPrestamoPeliculas();
                    break;
                case 9:
                    System.out.println("Vuelva pronto");
                    break;
                default:
                    System.out.println("Opcion no existente");
                    break;


            }
        }

    }

    public void mostrarOpciones(){

        //int eleccion =0;
        System.out.println("1. Prestamo de peliculas");
        System.out.println("2. Devolucion de pelicula");
        System.out.println("3. Mostrar las peliculas");
        System.out.println("4. Ingresar peliculas");
        System.out.println("5. Ordenar peliculas");
        System.out.println("6. Ingresar clientes nuevos");
        System.out.println("7. Mostrar clientes");
        System.out.println("8. Reportes");
        System.out.println("9. Salir");



    }

    public void bienvenida(){

        System.out.println("Bienvenido al sistema de control de peliculas de <<Memorabilia>>");
        System.out.println("Estas son las opciones que puede elegir");
        mostrarOpciones();
        seleccionarMenu();

    }



    public void catalogoDePeliculas(){

        peliculas[0][0]= "123"; peliculas[0][1] ="Pasion"; peliculas[0][2]= "2010"; peliculas[0][3] ="Drama";
        peliculas[0][4]= String.valueOf(peliculaDisponible =true);
        peliculas[1][0]= "215"; peliculas[1][1] ="Terminator"; peliculas[1][2]= "2002"; peliculas[1][3] ="Accion";
        peliculas[1][4]= String.valueOf(peliculaDisponible=true);
        peliculas[2][0]= "316"; peliculas[2][1] ="Looney Tunes"; peliculas[2][2]= "2004"; peliculas[2][3] ="Comedia";
        peliculas[2][4]= String.valueOf(peliculaDisponible=true);
        peliculas[3][0]= "105"; peliculas[3][1] ="Rapido y fogoso"; peliculas[3][2]= "2008"; peliculas[3][3] ="Comedia";
        peliculas[3][4]= String.valueOf(peliculaDisponible=true);
        peliculas[4][0]= "314"; peliculas[4][1] ="Harry Potter"; peliculas[4][2]= "2014"; peliculas[4][3] ="Fantasia";
        peliculas[4][4]= String.valueOf(peliculaDisponible=true);

    }
    public void catalogoUsuario(){

        personas[0][0] ="Randy";
        personas[0][1] ="2693";
        personas[0][2]= "3314";
        personas[0][3] =String.valueOf(poseePeliculas=false);
    }

    public void ingresarUsuario(){
        //catalogoUsuario();
        posicion = buscarPosicion(personas/*, posicion*/);
        System.out.println("Ingrese el nombre de la persona, en la " +posicion);
        personas[posicion][0]= teclado.nextLine();
        //while(existeID){
        do{
            System.out.println("Ingrese su ID");
            ID = Integer.parseInt(teclado.nextLine());



            //System.out.println("Existe Id" +existeID);
            personas[posicion][1] = String.valueOf(ID);
            existeID = verificarId(personas, ID/*, posicion*/, 1);

        }while(!existeID );

        System.out.println("Ingrese su numero de telefono");
        int numeroTel = Integer.parseInt(teclado.nextLine());
        personas[posicion][2] = String.valueOf(numeroTel);

        personas[posicion][3] = String.valueOf(poseePeliculas=false);
        //personas[posicion][1] = String.valueOf(ID);

    }

    public void ingresarPelicula(){
        //catalogoDePeliculas();
        posicion = buscarPosicion(peliculas/*, posicion*/);
        System.out.println("********************");
        System.out.println("***  PELICULAS   *** ");
        System.out.println("********************");
        System.out.println("la posicion es:" +posicion);
        System.out.println("Ingrese el Id de la pelicula");
        int ID = Integer.parseInt(teclado.nextLine());

        peliculas[posicion][0] = Integer.toString(ID);
        System.out.println("Ingrese el nombre de la pelicula");
        peliculas[posicion][1] = teclado.nextLine();
        System.out.println("Ingrese el anio de la pelicula");
        int anio = Integer.parseInt(teclado.nextLine());
        peliculas[posicion][2] = Integer.toString(anio);
        System.out.println("Ingrese el genero de la pelicula");
        peliculas[posicion][3] = teclado.nextLine();
        peliculas[posicion][4] = String.valueOf(peliculaDisponible = true);


    }
    //funcion para guardar el id de la pelicula, el usuario y los dias de alquiler

   /* public  void controlPrestamoDePeliculas(String idPelicula, String nombreP, String idUsuario, String nombreU, String diasAlquiler){


    }*/

    /*public void llenarArregloPrestamoPeliculas(){
        posicion = buscarPosicion(prestamoPeliculas);
    }*/


    public void prestarPelicula(){
        System.out.println("Que usuario eres");
        imprimirUsuario();
        usuario = Integer.parseInt(teclado.nextLine());
        if((personas[usuario][3]).equalsIgnoreCase("false")){
            System.out.println("Que pelicula deseas alquilar?");
            imprimirPeliculas();
            prestamo = Integer.parseInt(teclado.nextLine());
            if((peliculas[prestamo][4]).equalsIgnoreCase("true")){
                System.out.println("Cuantos dias prestaras la pelicula?");
                diasPrestamo = Integer.parseInt(teclado.nextLine());
                poseePeliculas = true;
                peliculaDisponible = false;
                personas[usuario][3] = String.valueOf(poseePeliculas);
                peliculas[prestamo][4] =String.valueOf(peliculaDisponible);

            }else{
                System.out.println("Lo sentimos, esa pelicula ya fue alquilada");
            }
        }else{
            System.out.println("Lo sentimos, no puedes alquilar una pelicula ahorita, puesto que ya tienes una");
        }

        //controlPrestamoDePeliculas(peliculas[prestamo][0], peliculas[prestamo][1], personas[usuario][1], personas[usuario][0], String.valueOf(diasPrestamo));
        posicion = buscarPosicion(prestamoPeliculas);
        prestamoPeliculas[posicion][0] = peliculas[prestamo][0];
        prestamoPeliculas[posicion][1] = peliculas[prestamo][1];
        prestamoPeliculas[posicion][2] = personas[usuario][1];
        prestamoPeliculas[posicion][3] = personas[usuario][0];
        prestamoPeliculas[posicion][4] = String.valueOf(diasPrestamo);


    }

    public void devolverPelicula(){
        System.out.println("Que usuario eres");
        imprimirUsuario();
        usuario = Integer.parseInt(teclado.nextLine());
        if(personas[usuario][3].equalsIgnoreCase("true")){
            System.out.println("que pelicula deseas devolver");
            imprimirPeliculas();
            prestamo = Integer.parseInt(teclado.nextLine());
            if((peliculas[prestamo][4]).equalsIgnoreCase("false")){
                System.out.println("Gracias por su alquiler");
                poseePeliculas =false;
                peliculaDisponible = true;
                personas[usuario][3] =String.valueOf(poseePeliculas);
                peliculas[prestamo][4]= String.valueOf(peliculaDisponible);
            }else{
                System.out.println("Esa no es la pelicula");
            }
            System.out.println("Gracias por devolver la pelicula, vuelva pronto");

        }else{
            System.out.println("Aun no tienes peliculas alquiladas con nosotros");
        }
    }

    public void imprimirUsuario(){
        tamanoArreglo = calcularTamanoArr(personas/*, tamanoArreglo*/);

        for(int i=0 ; i<tamanoArreglo; i++){
            System.out.println((i) +"\tNombre: "+ personas[i][0] + "\tId" +personas[i][1] +
                    "\tTelefono: " +personas[i][2] + "\tPosee pelicula: " +personas[i][3]);
        }
        System.out.println("");
    }

    public void imprimirPeliculas(){
        tamanoArreglo = calcularTamanoArr(peliculas/*, tamanoArreglo*/);

        for (int i = 0; i < tamanoArreglo; i++) {
            System.out.println((i)+"\tId: " +peliculas[i][0]+ "\tNombre:"+peliculas[i][1]
            +"\t\tAnio: \t"+peliculas[i][2] + "\tCategoria: \t"+ peliculas[i][3]+
                    "\tEsta disponible: " +peliculas[i][4]);
        }
    }

    public void imprimirPrestamoPeliculas(){
        tamanoArreglo = calcularTamanoArr(prestamoPeliculas);
        for(int i=0; i<tamanoArreglo; i++){
        System.out.println("Id Pelicula:" + prestamoPeliculas[i][0] + " Nombre: " +prestamoPeliculas[i][1]+
                "Id del usuario: " +prestamoPeliculas[i][2] + " Usuario: "+prestamoPeliculas[i][3]+
                " dias que fue prestada: " + prestamoPeliculas[i][4]);
    }
    }



    public void ordenarPorNombre(String[][] peliculas, int indice){
        tamanoArreglo = calcularTamanoArr(peliculas);

        for (int i = 0; i < tamanoArreglo-1; i++) {
            for (int j = i+1; j <tamanoArreglo ; j++) {

                if(peliculas[i][indice].compareTo(peliculas[j][indice]) <0){

                    String temp= peliculas[j][indice];
                    peliculas[j][indice] = peliculas[i][indice];
                    peliculas[i][indice] = temp;
                    int oB = i;
                    String iDTemp= peliculas[j][0];
                    peliculas[j][0] = peliculas[i][0];
                    peliculas[i][0] = iDTemp;
                    String anioTemp= peliculas[j][2];
                    peliculas[j][2] = peliculas[i][2];
                    peliculas[i][2] = anioTemp;
                    String genTemp= peliculas[j][3];
                    peliculas[j][3] = peliculas[i][3];
                    peliculas[i][3] = genTemp;
                    String dispTemp= peliculas[j][4];
                    peliculas[j][4] = peliculas[i][4];
                    peliculas[i][4] = dispTemp;
                }
            }
        }
        imprimirPeliculas();
    }

    public void ordenarIdMayor(String[][] peliculas, int indice){
        tamanoArreglo = calcularTamanoArr(peliculas);
        for (int i = 0; i < tamanoArreglo-1; i++) {
            for (int j = i+1; j <tamanoArreglo ; j++) {

                int num1 = Integer.parseInt(peliculas[i][indice]);
                int num2 = Integer.parseInt(peliculas[j][indice]);

                if(num1 < num2){

                    String temp= peliculas[j][indice];
                    peliculas[j][indice] = peliculas[i][indice];
                    peliculas[i][indice] = temp;
                    int oB = i;
                    String nombTemp= peliculas[j][1];
                    peliculas[j][1] = peliculas[i][1];
                    peliculas[i][1] = nombTemp;
                    String anioTemp= peliculas[j][2];
                    peliculas[j][2] = peliculas[i][2];
                    peliculas[i][2] = anioTemp;
                    String genTemp= peliculas[j][3];
                    peliculas[j][3] = peliculas[i][3];
                    peliculas[i][3] = genTemp;
                    String dispTemp= peliculas[j][4];
                    peliculas[j][4] = peliculas[i][4];
                    peliculas[i][4] = dispTemp;
                }
            }
        }
               imprimirPeliculas();


    }
    public void ordenarIdMenor(String[][] peliculas, int indice){
        tamanoArreglo = calcularTamanoArr(peliculas);
        for (int i = 0; i > tamanoArreglo-1; i++) {
            for (int j = i+1; j <tamanoArreglo ; j++) {

                int num1 = Integer.parseInt(peliculas[i][indice]);
                int num2 = Integer.parseInt(peliculas[j][indice]);

                if(num1 < num2){

                    String temp= peliculas[j][indice];
                    peliculas[j][indice] = peliculas[i][indice];
                    peliculas[i][indice] = temp;
                    int oB = i;
                    String nombTemp= peliculas[j][1];
                    peliculas[j][1] = peliculas[i][1];
                    peliculas[i][1] = nombTemp;
                    String anioTemp= peliculas[j][2];
                    peliculas[j][2] = peliculas[i][2];
                    peliculas[i][2] = anioTemp;
                    String genTemp= peliculas[j][3];
                    peliculas[j][3] = peliculas[i][3];
                    peliculas[i][3] = genTemp;
                    String dispTemp= peliculas[j][4];
                    peliculas[j][4] = peliculas[i][4];
                    peliculas[i][4] = dispTemp;

                }

            }

        }

               imprimirPeliculas();


    }

    public int buscarPosicion(String[][] arreglo/*, int posicion*/){
        int contador =0;
        while(contador<TAMANO_MATRIZ && arreglo[contador][0]!=null){
            contador++;
        }
        posicion = contador;
        return posicion;
    }

    public int calcularTamanoArr(String[][] arreglo/*, int tamanoArreglo*/){
        int contador =0;
        while(contador< TAMANO_MATRIZ && arreglo[contador][0] != null){
            contador ++;
        }
       tamanoArreglo = contador;
       return tamanoArreglo;
    }

    public boolean verificarId(String [][] arreglo,int iD,/* int posicion,*/int posId){
        tamanoArreglo = calcularTamanoArr(personas/*, tamanoArreglo*/);
        //System.out.println("El tamano es: " +tamanoArreglo);

        for(int i=0; i<tamanoArreglo; i++){
            int verificar =Integer.parseInt(arreglo[i][posId]);

            if(verificar != iD){
                //System.out.println("Entro a la condicion que no es igual el arreglo");
                existeID = true;
            }else{
                //System.out.println("entro a la segunda condicion que es igual");
                existeID = false;
                //System.out.println(""+existeID);
                break;

            }

            //System.out.println("Termina el ciclo for");
            break;
        }
        //System.out.println("termina el ciclo for, sale enter para continuar");
        //teclado.nextLine();
        //System.out.println("antes de retornar");
        return existeID;
    }

    public static void main(String[]args){
        Principal principal = new Principal();
    }

}
