package com.inventario.inventarioservice.service;

import com.inventario.inventarioservice.entity.Producto;
import com.inventario.inventarioservice.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import com.inventario.inventarioservice.dto.VentaDTO;
import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final ReporteServiceClient reporteServiceClient;

    public ProductoService(ProductoRepository productoRepository,
                           ReporteServiceClient reporteServiceClient) {

        this.productoRepository = productoRepository;
        this.reporteServiceClient = reporteServiceClient;
    }

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Optional<Producto> obtenerProductoPorId(Long id) {
        return productoRepository.findById(id);
    }

    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    public Producto actualizarProducto(Long id, Producto productoActualizado) {

        Optional<Producto> productoExistente = productoRepository.findById(id);

        if (productoExistente.isPresent()) {

            Producto producto = productoExistente.get();

            producto.setNombre(productoActualizado.getNombre());
            producto.setPrecio(productoActualizado.getPrecio());
            producto.setStock(productoActualizado.getStock());

            return productoRepository.save(producto);
        }

        return null;
    }

    public String registrarVenta(Long productoId, Integer cantidad) {

        Optional<Producto> productoOptional = productoRepository.findById(productoId);

        if (productoOptional.isEmpty()) {
            return "Producto no encontrado";
        }

        Producto producto = productoOptional.get();

        if (producto.getStock() < cantidad) {
            return "Stock insuficiente";
        }

        producto.setStock(producto.getStock() - cantidad);
        productoRepository.save(producto);

        VentaDTO ventaDTO = new VentaDTO();
        ventaDTO.setProductoId(productoId);
        ventaDTO.setCantidad(cantidad);
        ventaDTO.setFecha(LocalDate.now());

        boolean reporteRegistrado = reporteServiceClient.registrarVenta(ventaDTO);

        if (reporteRegistrado) {
            return "Venta registrada correctamente";
        } else {
            return "Venta registrada, pero el servicio de reportes no está disponible.";
        }
    }
}