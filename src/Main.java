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

        bolsaLacteos.crear(new Lacteo("Leche", 1.5, 1, 5));
        bolsaLacteos.crear(new Lacteo("Queso", 2.0, 2, 10));
        bolsaLacteos.crear(new Lacteo("Yogurt", 1.0, 3, 3));
        bolsaLacteos.crear(new Lacteo("Mantequilla", 1.2, 1, 4));
        bolsaLacteos.crear(new Lacteo("Crema", 1.0, 1, 3));

        bolsaLimpieza.crear(new Limpieza("Jabón", 1.0, "Aloe Vera", 0.5));
        bolsaLimpieza.crear(new Limpieza("Shampoo", 2.0, "Vitamina E", 0.5));
        bolsaLimpieza.crear(new Limpieza("Detergente", 1.5, "Limon", 0.5));
        bolsaLimpieza.crear(new Limpieza("Desinfectante", 1.0, "Cloro", 0.5));
        bolsaLimpieza.crear(new Limpieza("Suavizante", 1.0, "Aloe Vera", 0.5));

        bolsaNoPerecibles.crear(new NoPerecible("Arroz", 1.0, 20, 243));
        bolsaNoPerecibles.crear(new NoPerecible("Frijoles", 1.5, 2, 633));
        bolsaNoPerecibles.crear(new NoPerecible("Azucar", 1.0, 1, 233));
        bolsaNoPerecibles.crear(new NoPerecible("Sal", 1.0, 3, 234));
        bolsaNoPerecibles.crear(new NoPerecible("Aceite", 1.0, 400, 223));

        //Mostrar productos de las bolsas
        System.out.println("=====Bolsa de frutas=====");
        bolsaFrutas.imprimirProductos();
        System.out.println("\n");

        System.out.println("=====Bolsa de limpieza=====");
        bolsaLimpieza.imprimirProductos();
        System.out.println("\n");

        System.out.println("=====Bolsa de lacteo=====");
        bolsaLacteos.imprimirProductos();
        System.out.println("\n");

        System.out.println("=====Bolsa de no perecibles=====");
        bolsaNoPerecibles.imprimirProductos();
        System.out.println("\n");

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

        System.out.println("\n");
        System.out.println("==== Eliminando producto ====");
        bolsaFrutas.eliminar(2);
        System.out.println("=================================");
        bolsaFrutas.imprimirProductos();
    }
}