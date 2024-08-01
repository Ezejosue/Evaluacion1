import com.evaluacion.modelos.*;
import com.evaluacion.repositorio.BolsaSupermercado;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Creando bolsas de productos
        BolsaSupermercado<Fruta> bolsaFrutas = new BolsaSupermercado<>();
        BolsaSupermercado<Lacteo> bolsaLacteos = new BolsaSupermercado<>();
        BolsaSupermercado<Limpieza> bolsaLimpieza = new BolsaSupermercado<>();
        BolsaSupermercado<NoPerecible> bolsaNoPerecibles = new BolsaSupermercado<>();

        //Agregando productos a cada bolsa
        bolsaFrutas.crear(new Fruta("Manzana", 1.5, 0.5, "Rojo"));
        bolsaFrutas.crear(new Fruta("Pera", 1.0, 0.3, "Verde"));
        bolsaFrutas.crear(new Fruta("Banano", 0.5, 0.2, "Amarillo"));
        bolsaFrutas.crear(new Fruta("Naranja", 0.8, 0.4, "Naranja"));
        bolsaFrutas.crear(new Fruta("Mango", 2.0, 0.6, "Amarillo"));

        //Mostrar productos de las bolsas
        System.out.println("=====Bolsa de frutas=====");
        bolsaFrutas.imprimirProductos();


        //Demostración de CRUD
        System.out.println("=== Demostración de CRUD ===");
        System.out.println("==== Buscando producto por ID====");
        Fruta fruta = bolsaFrutas.porId(1);
        System.out.println("==== Editando producto ====");
        if (fruta != null) {
            System.out.println("Producto encontrado: " + fruta.getNombre());
            fruta.setNombre("Manzana Roja");
            bolsaFrutas.editar(fruta);
            System.out.println("Producto editado: " + fruta.getNombre());
        } else {
            System.out.println("Producto no encontrado");
        }

        System.out.println("==== Eliminando producto ====");
        bolsaFrutas.eliminar(2);
        System.out.println("=================================");
        bolsaFrutas.imprimirProductos();
    }
}