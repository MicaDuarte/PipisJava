package com.proyecto.pipis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto.pipis.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
