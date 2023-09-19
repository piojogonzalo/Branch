public class CollectionCustom<T> {
   
	
	private T[] array;
    private int Tamaño;

    /*Constructor inico
     * 
     * */
    public CollectionCustom(int capacidad) {
        array = (T[]) new Object [capacidad];
        Tamaño = 0;    
    }

    /* Método para el tamaño
     * 
     * */
    public int tamaño() {
        return Tamaño;
    }

    /* Método para agregar un elemento
     *  
     */
    public void agregar(T elemento) {
        if (Tamaño < array.length) {
            array[Tamaño] = elemento;
            Tamaño++;
        } else {        
            System.out.println("No se puede agregar más");
        }
    }

    /* Eliminar 
     * 
     * */
    public T remover(T elemento) {
        for (int i = 0; i < Tamaño; i++) {
            if (array[i].equals(elemento)) {
                T removerElemento = array[i];
                
                for (int j = i; j < Tamaño - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[Tamaño - 1] = null; // <-------   Elimina la última referencia
                Tamaño--;
                return removerElemento;
            }
        }
        return null; // <-------  Si no encuentra niungún elemento
    }

    /*
     * Acá elimina la referencia
     */
    public void removerTodo(T elemento) {
        int i = 0;
        while (i < Tamaño) {
            if (array[i].equals(elemento)) {
                
            	/* Desplazamos los elementos posteriores para llenar el espacio vacío
                 *
                 * */
            	
            		for (int j = i; j < Tamaño - 1; j++) {
            		array[j] = array[j + 1];
                }
                array[Tamaño - 1] = null; //<------ Eliminamos la última referencia
                Tamaño--;
            } else {
                i++;
            }
        }
    }

    /* Método para verificar si la colección está vacía
     * 
     * */
    public boolean empty() {
        return Tamaño == 0;
    }

    public static void main(String[] args) {
        CollectionCustom<Integer> collection = new CollectionCustom<>(6);

        collection.agregar(6);
        collection.agregar(1);
        collection.agregar(2);
        collection.agregar(3);
        collection.agregar(2);

        System.out.println("Tamaño de la colección: " + collection.tamaño());

        System.out.println("Eliminando Números : " + collection.remover(3));  // < ------ Número a eliminar
        System.out.println("Tamaño después de remover: " + collection.tamaño()); 
        System.out.println("Tamaño después de remover todos los 2: " + collection.tamaño());

        System.out.println("-La colección está vacía? " + collection.empty());
    }
}