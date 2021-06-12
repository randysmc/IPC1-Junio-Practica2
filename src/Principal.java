package src;

import java.util.*;

public class Principal{

	Scanner teclado = new Scanner(System.in);
	int eleccion =0;

	public Principal(){
		bienvenida();
		seleccionarMenu(eleccion);



	}


	public void seleccionarMenu(int eleccion){
		//mostrarOpciones();
		while(eleccion !=9){
			mostrarOpciones();
			eleccion = Integer.parseInt(teclado.nextLine());
			switch(eleccion){
				case 1:
					System.out.println("Prestamo de peliculas");
					break;
				case 2:
					System.out.println("Devoludion de peliculas");
					break;
				case 3:
					System.out.println("Mostrar peliculas");
					break;
				case 4:
					System.out.println("Ingresar peliculas");
					break;
				case 5:
					System.out.println("Ordenar peliculas");
					break;
				case 6:
					System.out.println("Ingresar clientes");
					break;
				case 7:
					System.out.println("Mostrar clientes");
					break;
				case 8:
					System.out.println("Prestamo de peliculas");
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
	}



	public static void main(String[]args){
		Principal principal = new Principal();

	}
}