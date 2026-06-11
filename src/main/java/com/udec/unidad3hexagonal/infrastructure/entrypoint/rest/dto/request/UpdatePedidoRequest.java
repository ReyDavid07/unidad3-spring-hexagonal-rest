package com.udec.unidad3hexagonal.infrastructure.entrypoint.rest.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public class UpdatePedidoRequest {
    @NotBlank(message = "El número de pedido es obligatorio")
    private String numeroPedido;
    @NotBlank(message = "El cliente es obligatorio")
    private String cliente;
    @NotBlank(message = "El producto es obligatorio")
    private String producto;
    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "La cantidad mínima es 1")
    private Integer cantidad;
    @NotNull(message = "El valor unitario es obligatorio")
    @Positive(message = "El valor unitario debe ser positivo")
    private BigDecimal valorUnitario;
    @NotBlank(message = "El estado es obligatorio")
    private String estado;
    private LocalDate fecha;

    public String getNumeroPedido() { return numeroPedido; }
    public void setNumeroPedido(String numeroPedido) { this.numeroPedido = numeroPedido; }
    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }
    public String getProducto() { return producto; }
    public void setProducto(String producto) { this.producto = producto; }
    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
    public BigDecimal getValorUnitario() { return valorUnitario; }
    public void setValorUnitario(BigDecimal valorUnitario) { this.valorUnitario = valorUnitario; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
}
