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

/**
 * @author carlos
 * @author orianna
 * @author pablo
 * @author juan
 *
 * @see libreta.java
 *
 * @version 1.0 "creacion de los getters y lo setters los cuales reciben la informacion para la utilizacion del toString"
 */


public class Zapatillas{
	private String nombre;
	private String talla;
	private String color;
	private int precio;
	private int id;

	public Zapatillas(int id, String nombre, String talla, String color, int precio){
		this.id = id;
		this.nombre = nombre;
		this.talla = talla;
		this.color = color;
		this.precio = precio;
	}

	public Zapatillas(int id){
		this.id = id;
	}

	public Zapatillas(){
		this.id = 0;
		this.nombre = "";
		this.talla = "";
		this.color = "";
		this.precio = 0;
	}



	/**
	 * @param Getter y Setters de todos atributos respectivos.
	 */

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	public String getNombre(){
		return nombre;
	}

	public void setTalla(String talla){
		this.talla = talla;
	}
	public String getTalla(){
		return talla;
	}

	public void setColor(String color){
		this.color = color;
	}
	public String getColor(){
		return color;
	}

	public void setPrecio(int precio){
		this.precio = precio;
	}
	public int getPrecio(){
		return precio;
	}

	public String toCSV(){
		return " "+ id + " " + nombre + " " + talla + " " + color + " " + precio + "€";
	}

	
	public boolean equals(Object obj){
		if(obj == this){
			return true;
		}
		if(obj instanceof Zapatillas){
			Zapatillas a = (Zapatillas) obj;
			if(a.getId() == id){
				return true;
			}
		}
		return false;
	}

	public String toString(){
		return " " + id + " " + nombre + " " + talla + " " + color + " " + precio;

		/**
		 * @return nos regresa toda la informacion completa del catlogo
		 */


	}



}
