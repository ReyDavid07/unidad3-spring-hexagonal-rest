INSERT INTO users (name, email, password, role, status) VALUES
('Administrador API', 'admin.api@restaurante.com', '1234', 'ADMIN', 'ACTIVO'),
('Operador API', 'operador.api@restaurante.com', '1234', 'MESERO', 'ACTIVO');

INSERT INTO pedidos (numero_pedido, cliente, producto, cantidad, valor_unitario, estado, fecha) VALUES
('PED-API-001', 'María Torres', 'Hamburguesa artesanal', 2, 22000, 'PENDIENTE', CURRENT_DATE),
('PED-API-002', 'Andrés López', 'Pizza personal', 1, 18000, 'ENTREGADO', CURRENT_DATE);
