package Models;

	import java.lang.reflect.Array;

	public class LaCola<T> {
		
		//Atributos
		
		private T[] elementos;
		private Class<T> clazz;
		
		// Constructor
		
		public LaCola(Class<T>clazz) {
			this.clazz=clazz;
			this.elementos= (T[])Array.newInstance(clazz, 0);
		}
		
		//Métodos

		
		//Añade elementos a la cola
		public void push(T elemento){
			int tam=this.elementos.length+1;
			T []arrayAux = (T[]) Array.newInstance(clazz, tam);
			
			for(int indice=0;indice<this.elementos.length;indice++){
				arrayAux[indice]=this.elementos[indice];
			}
			
			arrayAux[tam]=elemento;
			this.elementos=arrayAux;
		}
		
		//Elimina elementos de la cola
		public void remove(T elemento){
		
			boolean parar = false;
				
				for(int indice=0; indice<this.elementos.length && !parar; indice++){
					if(this.elementos[indice].equals(elementos)){
						parar=true;
						if(indice!=this.elementos.length-1){
							T elementAux;
							for(int indiceAux=indice+1; indiceAux<this.elementos.length; indiceAux++){
								elementAux=this.elementos[indice];
								this.elementos[indice++]=this.elementos[indiceAux];
								this.elementos[indiceAux]=elementAux;
							}
						}
						
						T[]arrayAux=(T[]) new Object[this.elementos.length];
						arrayAux=this.elementos;
						
						this.elementos=(T[]) new Object[arrayAux.length-1];
						
						for(int indiceCopy=0; indiceCopy<this.elementos.length; indiceCopy++){
							this.elementos[indiceCopy]=arrayAux[indiceCopy];
						}
					}
				}
			}
		
		
		//Elimina el siguiente elemento de la cola
		public T pop(){
			
		T elemento=this.elementos[0];
		remove(elemento);
		return elemento;
		
		}
		
		
		//Limpia de elementos la cola
		public void clear(){
			this.elementos=(T[]) new Object[0];
		}
		
		//Comprueba si el elemento esta en la lista
		public boolean contains(T elemento){
			boolean contiene = true;
			for(int indice=0; indice<this.elementos.length; indice++){
				if(this.elementos[indice].equals(elemento)){
					contiene = true;
				}else{
					contiene = false;
				}	
			}
			return contiene;
		}
		
		//Comprueba si la lista de elementos esta vacia
		public boolean isEmpty(){
			boolean vacia=true;
			if(this.elementos.length==0){
				vacia= true;
			}else{
				vacia=false;
			}
			return vacia;
		}
		
		//Devulve el tamaño de la cola
		public int size(){
			return this.elementos.length;
		}
		
		
	}
		
		

