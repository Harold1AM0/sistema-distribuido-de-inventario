package com.inventario.inventarioservice.repository;

import com.inventario.inventarioservice.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}