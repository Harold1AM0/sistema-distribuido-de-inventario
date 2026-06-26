package com.inventario.reporteservice.service;

import com.inventario.reporteservice.entity.Venta;
import com.inventario.reporteservice.repository.VentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {
    private final VentaRepository ventaRepository;

    public VentaService(VentaRepository ventaRepository){
        this.ventaRepository=ventaRepository;
    }



    public List<Venta> obtenerVentas() {
        return ventaRepository.findAll();
    }
    public Venta guardarVenta(Venta venta) {

        return ventaRepository.save(venta);

    }


}
