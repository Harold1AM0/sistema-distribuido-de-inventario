package com.inventario.inventarioservice.service;

import com.inventario.inventarioservice.dto.VentaDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class ReporteServiceClient {

    private final RestTemplate restTemplate;

    public ReporteServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean registrarVenta(VentaDTO ventaDTO) {

        String url = "http://reporte-service:8081/ventas";

        try {
            restTemplate.postForObject(url, ventaDTO, Void.class);
            return true;
        } catch (RestClientException e) {
            System.out.println("Reporte Service no disponible: " + e.getMessage());
            return false;
        }
    }
}