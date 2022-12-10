/*CopyrighSystem.out.println(libreta)it [2021] [Carlos Moragon, Pablo Torres, Juan Garcia, Orianna Milone]

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. */


package interfaz;
import dominio.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.NoSuchElementException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.NumberFormatException;
public class Interfaz{

	/**
	 * @author carlos
	 * @author orianna
	 * @author juan
	 * @author pablo
	 *
	 * @see dominio
	 *
	 * @version 1.0 "en esta clase se le otorga vaios opcciones al usuario en dodne este usuario podra manipular los objetos del arrayList
	 */


	private static String NOMBRE_FICHERO_CSV = "libreta.csv";


	public void procesarPeticion(String sentencia, String sustitucion){
		Libreta libreta = inicializarLibreta();

		String[] partes = sentencia.split(" ");
		String[] partesSustitucion = sustitucion.split(" ");
		/**
		 * @param se crea un loop en el cual se pide al usuario que accion desea realizar.
		 */
		if(partes.length == 6){
			if (partes[0].equalsIgnoreCase("add")){
				Zapatillas zapatilla = new Zapatillas(Integer.parseInt(partes[1]), partes[2], partes[3], partes[4], Integer.parseInt(partes[5]));
				libreta.annadirZapatilla(zapatilla);
				guardarLibreta(libreta);

			}else if (partes[0].equalsIgnoreCase("edit")){
				Zapatillas zapatilla = new Zapatillas(Integer.parseInt(partes[1]), partes[2], partes[3], partes[4], Integer.parseInt(partes[5]));
				Zapatillas zapaSustitucion = new Zapatillas(Integer.parseInt(partesSustitucion[0]), partesSustitucion[1], partesSustitucion[2], partesSustitucion[3], Integer.parseInt(partesSustitucion[4]));
				libreta.editarZapatilla(zapatilla, zapaSustitucion);
				guardarLibreta(libreta);
			}else{
				System.out.println("Lo siento no te entiendo, vuelve a intentarlo.");
			}
		}else if (partes[0].equalsIgnoreCase("delete")){
			Zapatillas zapatilla = new Zapatillas(Integer.parseInt(partes[1]));
			libreta.eliminarZapatilla(zapatilla);
			guardarLibreta(libreta);

		}else if(partes[0].equalsIgnoreCase("list")){
			System.out.println("Estos son los productos que tienes en la libreta:\n");
			System.out.println(libreta);

		}else if(partes[0].equalsIgnoreCase("help")){
			printHelp();



		}else if(partes[0].equalsIgnoreCase("exit")){
			System.out.println("Gracias por su visita vuelva pronto");

		}else{	
			System.out.println("Lo siento no te entiendo, vuelve a intentarlo.");

		}

	}

	private static void guardarLibreta(Libreta libreta){
		try{
			FileWriter fw = new FileWriter(NOMBRE_FICHERO_CSV);
			fw.write(libreta.toString());
			fw.close();
		}catch(IOException p){
			System.out.println("Ha habido un error al guardar el fichero");
		}

	}

	public static void printHelp(){
		/**
		 * @param metodo el cual le da la opccion al usuario de ver las operaciones que puede ralizar 
		 */
		String ayuda= "Menu: Las operaciones son las siguientes:\n"+
			">'add' (Para añadir un modelo de zapatillas).\nDebera especificar: id, Nombre, Talla, Color, Precio\n"+
			">'edit' (Para modificar la informacion de alguna zapatilla).\nDebera especificar: id, Nombre, Talla, Color, Precio\n"+
			">'delete' (Para eliminar alguna zapatilla del catalogo).\nDebera especificar: id\n"+
			">'list' (Mostrar las zaptillas del catalogo).\n"+
			">'help'\n"+
			">'exit'.\n" ;//+">'crearCSV'";
		System.out.println(ayuda);
	}

	private static Libreta inicializarLibreta(){
		Libreta libreta = new Libreta();
		try{
			try{
				try{
					File file = new File(NOMBRE_FICHERO_CSV);
					Scanner sc = new Scanner(file);
					while(sc.hasNext()){
						String id = sc.next();
						String nombre = sc.next();
						String talla = sc.next();
						String color = sc.next();
						String precio = sc.next();
						Zapatillas zapatilla = new Zapatillas(Integer.parseInt(id), nombre, talla, color, Integer.parseInt(precio));
						libreta.annadirZapatilla(zapatilla);
					}
					sc.close();
				}catch(NoSuchElementException j){
				}
			}catch(NumberFormatException i){

			}
		}catch(FileNotFoundException e){
		}
		/**
		 * @trows "colocamos la exepcion ue nos lanza"
		 */
		return libreta;
		/**
		 * @return regresa al progrema la accion que realizo el usuario.
		 */

	}
	private static void generarCSV(Libreta libreta){
		/**
		 * @param creacion de la Libreta.CSV
		 */
		try{
			FileWriter fw = new FileWriter(NOMBRE_FICHERO_CSV);
			fw.write(libreta.toCSV());
			fw.close();
			System.out.println("Se ha generado el fichero CSV");
		} catch(IOException e){
			System.out.println("No se ha podido generar el fichero CSV");
		}
	}



}
