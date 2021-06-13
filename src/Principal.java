package src;

import java.util.*;

public class Principal {
    final int TAMANO_MATRIZ =30;
    final int TAMANO_PERS =4;
    final int TAMANO_PELIS =5;
    final int TAMANO_TIENDA =3;
    String [][] personas =  new String[TAMANO_MATRIZ][4];
    String [][] peliculas = new String[TAMANO_MATRIZ][5];
    String [][] prestamoPeliculas = new String[TAMANO_MATRIZ][3];
    //String [][] manejoPeliculas = new String[TAMANO_MATRIZ][2]
    int posicion;  //var para buscar la posicion donde se insertara un nuevo usuario/pelicula
    int tamanoArreglo;  //var para imprimir la matriz segun el tamano que tenga
    int masAlquilada;   //para llevar control sobre la pelicula mas alquilada
    int menorAlquilada; //lleva un control de la pelicula menos alquilada
    int numeroVecesAlquiler=0; //contador para las veces que se alquila una pelicula
    boolean poseePeliculas= false; //para saber si el usuario posee alguna pelicula
    boolean peliculaDisponible = true;//para saber si la pelicula esta disponible o alquilada
    boolean existeID = false; //para saber si el ID que se ingreso existe
    Scanner teclado = new Scanner(System.in);
    int eleccion =0;
    int ID;


    public Principal(){

        seleccionarMenu();

    }



    public void seleccionarMenu(int eleccion){
        //mostrarOpciones();
        while(eleccion !=9){
            mostrarOpciones();
            eleccion = Integer.parseInt(teclado.nextLine());
            switch(eleccion){
                case 1:
                    System.out.println("Prestamo de peliculas");
                    prestarPelicula();
                    break;
                case 2:
                    System.out.println("Devoludion de peliculas");
                    devolverPelicula();
                    break;
                case 3:
                    System.out.println("Mostrar peliculas");
                    imprimirPeliculas();
                    break;
                case 4:
                    System.out.println("Ingresar peliculas");
                    ingresarPelicula();
                    break;
                case 5:
                    System.out.println("Ordenar peliculas");
                    ordenarPorNombre(peliculas);
                    break;
                case 6:
                    //agregarCliente();
                    //System.out.println("Ingresar clientes");
                    ingresarUsuario();
                    break;
                case 7:
                    System.out.println("Mostrar clientes");
                    imprimirUsuario();
                    break;
                case 8:
                    System.out.println("Reporte");
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


    //Aqui agregamos el catalogo de peliculas utilizando la matriz de peliculas, agregamos cada elemento con id, nombre, anio, genero y todas inician con disponible
    public void catalogoDePeliculas(){
        peliculas[0][0]= "123"; peliculas[0][1] ="Pasion"; peliculas[0][2]= "2010"; peliculas[0][3] ="Drama";
        peliculas[0][4]= "true";
        peliculas[1][0]= "215"; peliculas[1][1] ="Terminator"; peliculas[1][2]= "2002"; peliculas[1][3] ="Accion";
        peliculas[1][4]= "true";
        peliculas[2][0]= "316"; peliculas[2][1] ="Looney Tunes"; peliculas[2][2]= "2004"; peliculas[2][3] ="Comedia";
        peliculas[2][4]= "true";
        peliculas[3][0]= "105"; peliculas[3][1] ="Rapido y fogoso"; peliculas[3][2]= "2008"; peliculas[3][3] ="Comedia";
        peliculas[3][4]= "true";
        peliculas[4][0]= "314"; peliculas[4][1] ="Harry Potter"; peliculas[4][2]= "2014"; peliculas[4][3] ="Fantasia";
        peliculas[4][4]= "true";


    }
        public void catalogoUsuario(){
            personas[0][0] ="Randy";
            personas[0][1] ="2693";
            personas[0][2]= "3314";
            personas[0][3] ="false";
    }



    public void ingresarUsuario(){
        catalogoUsuario();
        posicion = buscarPosicion(personas/*, posicion*/);
        System.out.println("Ingrese el nombre de la persona");
        personas[posicion][0]= teclado.nextLine();
        //do{
        System.out.println("Ingrese su ID");
        ID = Integer.parseInt(teclado.nextLine());
        //existeID = verificarId(personas, ID, posicion, 1);
        //System.out.println("Existe Id" +existeID);

        //}while(existeID);
        personas[posicion][1] = String.valueOf(ID);
        System.out.println("Ingrese su numero de telefono");
        int numeroTel = Integer.parseInt(teclado.nextLine());
        personas[posicion][2] = String.valueOf(numeroTel);

        personas[posicion][3] = "false";


    }

    //para ingresar las peliculas hacemos lo mismo que con usuario, llamamos a una funcion que nos va a entregar una posicion en el arreglo
    // y luego rellenamos los campos que falten
    public void ingresarPelicula(){
        catalogoDePeliculas();
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
        peliculas[posicion][4] = "false";


    }


    //para llenar este arreglo nos auxiliamos de la funcion posicion que nos devuelve el indice donde podemos ingresar
    //recibimos los parametros de id pelicual, id usuario y dias de alquiler
    public void prestamoDePeliculas(String idPelicula, String idUsuario, int diasAlquiler){
        posicion = buscarPosicion(prestamoPeliculas);
        prestamoPeliculas[posicion][0] = String.valueOf(idPelicula);
        prestamoPeliculas[posicion][1] = String.valueOf(idUsuario);
        prestamoPeliculas[posicion][2] = Integer.toString(diasAlquiler);
    }




    //funcion para prestar una pelicula, mostramos los usuarios disponibles y luego las peliculas disponibles
    //guardamos la informacion en el arreglo prestamoPeliculas
    public void prestarPelicula(){
        int usuario, prestamo, diasPrestamo;
        System.out.println("Que usuario eres");
        imprimirUsuario();
        usuario = Integer.parseInt(teclado.nextLine());
        if((personas[usuario][3]).equalsIgnoreCase("false")){

            System.out.println("Que pelicula deseas alquilar?");
            imprimirPeliculas();
            prestamo = Integer.parseInt(teclado.nextLine());
            //while(poseePeliculas = true || eleccion ==1){
                if((peliculas[prestamo][4]).equalsIgnoreCase("true")){
                    System.out.println("Cuantos dias prestaras la pelicula?");
                    diasPrestamo = Integer.parseInt(teclado.nextLine());
                    System.out.println("Pelicula:"+peliculas[prestamo][4]+ "alquilada");

                    //poseePeliculas = true;
                    //peliculaDisponible = false;
                    personas[usuario][3] = String.valueOf("true");
                    peliculas[prestamo][4] =String.valueOf("false");
                    prestamoDePeliculas((peliculas[prestamo][0]),(personas[usuario][1]), diasPrestamo);

                }else{
                    System.out.println("Lo sentimos, esa pelicula ya fue alquilada");
                    System.out.println("Quieres volver al menu principal? 1.Si");
                    eleccion = Integer.parseInt(teclado.nextLine());
                }


        }else{
            System.out.println("Lo sentimos, no puedes alquilar una pelicula ahorita, puesto que ya tienes una");
        }




    }


    public void devolverPelicula(){
        System.out.println("Que usuario eres");

        int usuario = Integer.parseInt(teclado.nextLine());

        if(personas[usuario][3].equalsIgnoreCase("true")){
            poseePeliculas = true;
            System.out.println("Gracias por devolver la pelicula");

        }else{
            poseePeliculas = false;
        }

    }


    public void imprimirUsuario(){
        catalogoUsuario();
        tamanoArreglo = calcularTamanoArr(personas, tamanoArreglo);

        for(int i=0 ; i<tamanoArreglo; i++){
            System.out.println((i) +"\tNombre: "+ personas[i][0] + "\tId" +personas[i][1] +
                    "\tTelefono: " +personas[i][2] + "\tPosee pelicula: " +personas[i][3]);

        }
        System.out.println("");
    }

    public void imprimirPeliculas(){
        catalogoDePeliculas();
        //ingresarPelicula();
        tamanoArreglo = calcularTamanoArr(peliculas, tamanoArreglo);

        for (int i = 0; i < tamanoArreglo; i++) {
            System.out.println((i)+"\tId: " +peliculas[i][0]+ "\tNombre:"+peliculas[i][1]
            +"\t\tAnio: \t"+peliculas[i][2] + "\tCategoria: \t"+ peliculas[i][3]+
                    "\tEsta disponible: " +peliculas[i][4]);

        }
    }



    public void imprimirPrestamoPeliculas(){
        tamanoArreglo = calcularTamanoArr(prestamoPeliculas, tamanoArreglo);
        for(int i=0; i<tamanoArreglo; i++){
        System.out.println("Id Pelicula:" + prestamoPeliculas[i][0]+ "\tId Cliente: " +prestamoPeliculas[i][1]+
                " dias " + prestamoPeliculas[i][2]);
        }
    }

        public void ordenarPorNombre(String[][] peliculas){
        tamanoArreglo = calcularTamanoArr(peliculas, tamanoArreglo);
        for(int i=0; i<tamanoArreglo-1; i++ ){
            if(Integer.parseInt(peliculas[i][2])>Integer.parseInt(peliculas[i+1][2])){
                int aux = Integer.parseInt(peliculas[i][2]);
                System.out.println("La primera es mas reciente");
            }else{
                System.out.println("La segunda es mas reciente");
            }
        }


    }



    public int buscarPosicion(String[][] arreglo/*, int posicion*/){
        int contador =0;
        while(contador<TAMANO_MATRIZ && arreglo[contador][0]!=null){
            contador++;
        }
        posicion = contador;
        return posicion;
    }

    public int calcularTamanoArr(String[][] arreglo, int tamanoArreglo){
        int contador =0;
        while(contador< TAMANO_MATRIZ && arreglo[contador][0] != null){
            contador ++;
        }
       tamanoArreglo = contador;
       return tamanoArreglo;
    }


    public static void main(String[] args) {

        Principal mat = new Principal();

    }



}
