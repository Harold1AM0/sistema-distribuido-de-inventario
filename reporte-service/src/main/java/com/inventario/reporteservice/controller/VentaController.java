package com.inventario.reporteservice.controller;

import com.inventario.reporteservice.entity.Venta;
import com.inventario.reporteservice.service.VentaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VentaController {
    private final VentaService ventaService;

    public VentaController(VentaService ventaService){
        this.ventaService=ventaService;
    }

  @GetMapping("/ventas")
  public List<Venta> obtenerVentas() {
      return ventaService.obtenerVentas();
  }

    @PostMapping("/ventas")
    public Venta guardarVenta(@RequestBody Venta venta) {

        return ventaService.guardarVenta(venta);

    }


}
