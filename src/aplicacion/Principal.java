/*Copyright [2021] [Carlos Moragon, Pablo Torres, Juan Garcia, Orianna Milone]

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. */

package aplicacion;
import interfaz.Interfaz;
import dominio.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author carlos
 * @author orianna
 * @author juan
 * @author pablo
 *
 * @param inicio del programa.
 * @see dominio e interfaz las cuales se inicilizan en esta clase. 
 */

public class Principal{
	public static void main(String[] args){
		System.out.println("-------------------------------------");
		System.out.println("Bienvenido a tu catalogo de Zapatillas\n");
		Interfaz interfaz = new Interfaz();
		interfaz.printHelp();
		int i = 0;
		Scanner sc = new Scanner(System.in);
		String sustitucion = "";
		while(i == 0){
			System.out.println("¿Que deseas hacer?");
			String sentencia = sc.nextLine();

			if(sentencia.equalsIgnoreCase("exit")){
				i = 1;

			}else if(sentencia.contains("edit")){
				StringTokenizer st = new StringTokenizer(sentencia);
				if(st.countTokens() == 6){
					System.out.println("Por que zapatilla la quieres sustituir");
					sustitucion = sc.nextLine();
				}
			}
			interfaz.procesarPeticion(sentencia, sustitucion);
		}
	}
}
