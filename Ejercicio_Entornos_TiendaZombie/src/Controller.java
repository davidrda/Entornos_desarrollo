import java.util.ArrayList;

public class Controller {

    ArrayList<Producto> listaProductos;

    public Controller() {
        listaProductos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {

        for (Producto p : listaProductos) {
            if (p.getNombre().equalsIgnoreCase(producto.getNombre())) {
                System.out.println("El producto ya está agregado");
                return;
            }
        }

        listaProductos.add(producto);
        System.out.println("Producto añadido");
    }

    public void verProductos(){

        for (Producto p : listaProductos) {
            System.out.printf("%s, %2.f€, %d%n",p.getNombre(), p.getPrecio(), p.getStock());
        }
    }

    public void comprar() {

        double precioTotal = 0;

        System.out.println("\nHaciendo compra...");
        for (Producto p : listaProductos) {
            precioTotal += p.getPrecio();
            p.setStock(0);
        }

        listaProductos.clear();

        System.out.println("Compra hecha");
        System.out.println("Total: " + precioTotal + "€");

    }

    public void  buscarProducto(Producto producto) {

        boolean encontrado = false;

        for (Producto p : listaProductos) {
            if (p.getNombre().equalsIgnoreCase(producto.getNombre())) {
                encontrado = true;
                System.out.println(p.getNombre());
            }
        }

        if (!encontrado) {
            System.out.println("No existe el producto");
        }


    }
}
