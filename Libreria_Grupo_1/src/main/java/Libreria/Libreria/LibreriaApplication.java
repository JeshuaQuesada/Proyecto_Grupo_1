package Libreria.Libreria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibreriaApplication {


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class NewClass {

	public static void main(String[] args) {
		SpringApplication.run(HistorialComprasApplication.class, args);
	}
        
}
class Compra {
    String fecha;
    String cliente;
    String libro;
    double precio;

    public String getFecha() {
        return fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public String getLibro() {
        return libro;
    }

    public double getPrecio() {
        return precio;
    }
}

@RestController
@RequestMapping("/compras")
class HistorialComprasController {

    @GetMapping
    public String obtenerHistorial() {
        Compra compra1 = new Compra();
        compra1.fecha = "2024-03-10";
        compra1.cliente = "Juan Pérez";
        compra1.libro = "El Principito";
        compra1.precio = 15.99;

        Compra compra2 = new Compra();
        compra2.fecha = "2024-03-09";
        compra2.cliente = "Ana Gómez";
        compra2.libro = "1984";
        compra2.precio = 20.50;

        Compra compra3 = new Compra();
        compra3.fecha = "2024-03-08";
        compra3.cliente = "Carlos Ramírez";
        compra3.libro = "Cien años de soledad";
        compra3.precio = 25.75;
        
        return "Historial de Compras:\n" +
                "1. Fecha: " + compra1.getFecha() + ", Cliente: " + compra1.getCliente() + ", Libro: " + compra1.getLibro() + ", Precio: $" + compra1.getPrecio() + "\n" +
                "2. Fecha: " + compra2.getFecha() + ", Cliente: " + compra2.getCliente() + ", Libro: " + compra2.getLibro() + ", Precio: $" + compra2.getPrecio() + "\n" +
                "3. Fecha: " + compra3.getFecha() + ", Cliente: " + compra3.getCliente() + ", Libro: " + compra3.getLibro() + ", Precio: $" + compra3.getPrecio();
    }
}