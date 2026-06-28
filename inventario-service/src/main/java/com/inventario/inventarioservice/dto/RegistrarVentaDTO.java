package com.inventario.inventarioservice.dto;

public class RegistrarVentaDTO {

    private Long productoId;
    private Integer cantidad;

    public RegistrarVentaDTO() {
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}