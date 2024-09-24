package com.proyecto.pipis;


import com.proyecto.pipis.entity.Producto;
import com.proyecto.pipis.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PipisApplication implements CommandLineRunner {

	@Autowired
	private ProductoRepository productoRepository;

	public static void main(String[] args) {
		SpringApplication.run(PipisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Insertando datos de ejemplo
		Producto producto1 = new Producto();
		producto1.setNombre("Producto 1");
		producto1.setDescripcion("Descripción del Producto 1");
		producto1.setPrecio(10.99);

		Producto producto2 = new Producto();
		producto2.setNombre("Producto 2");
		producto2.setDescripcion("Descripción del Producto 2");
		producto2.setPrecio(15.99);

		productoRepository.save(producto1);
		productoRepository.save(producto2);
	}
}

