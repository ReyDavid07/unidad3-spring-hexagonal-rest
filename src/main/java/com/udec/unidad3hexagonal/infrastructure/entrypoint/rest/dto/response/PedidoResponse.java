package com.udec.unidad3hexagonal.infrastructure.entrypoint.rest.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PedidoResponse {
    private Long id;
    private String numeroPedido;
    private String cliente;
    private String producto;
    private Integer cantidad;
    private BigDecimal valorUnitario;
    private BigDecimal total;
    private String estado;
    private LocalDate fecha;

    public PedidoResponse() {}

    public PedidoResponse(Long id, String numeroPedido, String cliente, String producto, Integer cantidad, BigDecimal valorUnitario, BigDecimal total, String estado, LocalDate fecha) {
        this.id = id;
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
        this.total = total;
        this.estado = estado;
        this.fecha = fecha;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
}
