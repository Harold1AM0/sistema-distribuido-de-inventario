package com.inventario.inventarioservice.service;

import com.inventario.inventarioservice.dto.VentaDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReporteServiceClient {

    private final RestTemplate restTemplate;

    public ReporteServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void registrarVenta(VentaDTO ventaDTO) {

        String url = "http://localhost:8081/ventas";

        restTemplate.postForObject(url, ventaDTO, Void.class);

    }

}