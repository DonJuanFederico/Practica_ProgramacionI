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


package dominio;
import java.util.ArrayList;
import interfaz.*;
/**
 * @author carlos
 * @author orianna
 * @author juan
 * @author pablo
 *
 * @see Zapatillas.java
 * @see Interfaz.java
 *
 * @version 1.0 "Creacion de arrayList" 
 */


public class Libreta{
	/**
	 * 
	 */
	private ArrayList<Zapatillas> zapatillas = new ArrayList<>();

	public ArrayList<Zapatillas> getZapatillas(){
		return zapatillas;
	}

	public void setZapatillas(ArrayList<Zapatillas> zapatillas){
		this.zapatillas = zapatillas;
	}
	/**
	 *@param El metodo annadirZapatilla
	 */

	public void annadirZapatilla(Zapatillas zapatilla){
		zapatillas.add(zapatilla);
	}
	/**
	 * @param se añade la zapatilla al arrayList
	 */

	public void eliminarZapatilla(Zapatillas zapatilla){
		zapatillas.remove(zapatilla);
	}
	/**
         * @param se elimina la zapatilla del arrayList
         */

	
	public void editarZapatilla(Zapatillas zapatilla, Zapatillas sustituto){
		if(zapatillas.remove(zapatilla)){
			zapatillas.remove(zapatilla);
			zapatillas.add(sustituto);
		}else{
			System.out.println("No se puede editar porque no tenemos a esa zapatilla.");
		}
	}
	/**
         * @param se edita la zapatilla del arrayList
         */

	public String toString(){
		String mensaje = "";
		for(int i = 0; i < zapatillas.size(); i++){
			mensaje += zapatillas.get(i) + "\n";
		}
		/**
		 *@return "Estos son los modelos de zapatillas que tenemos en este catalogo:\n" 
		 */ 
		   return mensaje;
	}
	public String toCSV(){
		StringBuilder mensaje = new StringBuilder();
		mensaje.append("nombre,talla,color,precio\n");
		for(Zapatillas zapatilla: zapatillas){
			mensaje.append(zapatilla.toCSV() + "\n");
		}
		return mensaje.toString();

		/**
		 * @return se procesa y se gurda la informacion la cual es envidad al arrayList
		*/
	}


		}
