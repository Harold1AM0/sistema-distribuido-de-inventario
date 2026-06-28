package com.inventario.inventarioservice.controller;

import com.inventario.inventarioservice.entity.Producto;
import com.inventario.inventarioservice.service.ProductoService;
import org.springframework.web.bind.annotation.*;
import com.inventario.inventarioservice.dto.RegistrarVentaDTO;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }

    @GetMapping("/{id}")
    public Optional<Producto> obtenerProducto(@PathVariable Long id) {
        return productoService.obtenerProductoPorId(id);
    }

    @PostMapping

    public Producto guardarProducto(@RequestBody Producto producto) {
        return productoService.guardarProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id,
                                       @RequestBody Producto producto) {

        return productoService.actualizarProducto(id, producto);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
    }

    @PostMapping("/ventas")
    public String registrarVenta(@RequestBody RegistrarVentaDTO venta) {

        return productoService.registrarVenta(
                venta.getProductoId(),
                venta.getCantidad()
        );

    }
}