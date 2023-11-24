/*inserts de usuarios todos con rol de admin*/
INSERT INTO `bd_rosita`.`usuario` (`id_usuario`, `username`, `contraseña`, `primer_nombre`, `segundo_nombre`, `primer_apellido`, `segundo_apellido`, `estado`, `rol`)
VALUES (null, 'jeison', '12345', 'Jeison', 'Gabriel', 'Pedraza', 'Sanabria', 'A', 'ADMIN');
INSERT INTO `bd_rosita`.`usuario` (`id_usuario`, `username`, `contraseña`, `primer_nombre`, `segundo_nombre`, `primer_apellido`, `segundo_apellido`, `estado`,`rol`)
VALUES (null, 'empleado', '1234', 'Karen', 'Ximena', 'Rojas', 'Calderon', 'A', 'EMPLOYEE');
INSERT INTO `bd_rosita`.`usuario` (`id_usuario`, `username`, `contraseña`, `primer_nombre`, `segundo_nombre`, `primer_apellido`, `segundo_apellido`, `estado`,`rol`)
VALUES (null, 'alejandro', '1027150463', 'Alejandro', null, 'Chitiva', 'Castillo', 'A', 'ADMIN');
INSERT INTO `bd_rosita`.`usuario` (`id_usuario`, `username`, `contraseña`, `primer_nombre`, `segundo_nombre`, `primer_apellido`, `segundo_apellido`, `estado`,`rol`)
VALUES (null, 'karen', '321654', 'Tomas', null, 'Espitia', 'Galindo', 'A', 'ADMIN');


INSERT INTO `bd_rosita`.`producto` (`id_prod`, `nombre_producto`, `precio_venta`, `stock_min`, `stock_max`, `existencia`, `iva`, `estado`)
VALUES (null, 'lapiz #2', 700, 150, 300, 200, 19, 'A');
INSERT INTO `bd_rosita`.`producto` (`id_prod`, `nombre_producto`, `precio_venta`, `stock_min`, `stock_max`, `existencia`, `iva`, `estado`)
VALUES (null, 'borrador pelican', 500, 100, 180, 120, 19, 'A');
INSERT INTO `bd_rosita`.`producto` (`id_prod`, `nombre_producto`, `precio_venta`, `stock_min`, `stock_max`, `existencia`, `iva`, `estado`)
VALUES (null, 'hojas examen', 350, 120, 250, 150, 19, 'A');
INSERT INTO `bd_rosita`.`producto` (`id_prod`, `nombre_producto`, `precio_venta`, `stock_min`, `stock_max`, `existencia`, `iva`, `estado`)
VALUES (null, 'cartulina (pliego)', 1300, 180, 300, 210, 19, 'A');
INSERT INTO `bd_rosita`.`producto` (`id_prod`, `nombre_producto`, `precio_venta`, `stock_min`, `stock_max`, `existencia`, `iva`, `estado`)
VALUES (null, 'cartulina (octavo)', 600, 200, 350, 290, 19, 'A');
INSERT INTO `bd_rosita`.`producto` (`id_prod`, `nombre_producto`, `precio_venta`, `stock_min`, `stock_max`, `existencia`, `iva`, `estado`)
VALUES (null, 'Cuaderno rayado (100 hojas)', 15000, 50, 100, 80, 19, 'A');
INSERT INTO `bd_rosita`.`producto` (`id_prod`, `nombre_producto`, `precio_venta`, `stock_min`, `stock_max`, `existencia`, `iva`, `estado`)
VALUES (null, 'Lápices de colores (12 unidades)', 8000, 20, 50, 40, 19, 'A');
INSERT INTO `bd_rosita`.`producto` (`id_prod`, `nombre_producto`, `precio_venta`, `stock_min`, `stock_max`, `existencia`, `iva`, `estado`)
VALUES (null, 'Borradores grandes', 2500, 10, 30, 25, 19, 'A');
INSERT INTO `bd_rosita`.`producto` (`id_prod`, `nombre_producto`, `precio_venta`, `stock_min`, `stock_max`, `existencia`, `iva`, `estado`)
VALUES (null, 'Pegamento líquido', 5000, 15, 40, 35, 19, 'A');
INSERT INTO `bd_rosita`.`producto` (`id_prod`, `nombre_producto`, `precio_venta`, `stock_min`, `stock_max`, `existencia`, `iva`, `estado`)
VALUES (null, 'Regla plástica (30 cm)', 3000, 10, 25, 20, 19, 'A');
INSERT INTO `bd_rosita`.`producto` (`id_prod`, `nombre_producto`, `precio_venta`, `stock_min`, `stock_max`, `existencia`, `iva`, `estado`)
VALUES (null, 'Marcadores fluorescentes (juego de 4)', 12000, 25, 60, 50, 19, 'A');
INSERT INTO `bd_rosita`.`producto` (`id_prod`, `nombre_producto`, `precio_venta`, `stock_min`, `stock_max`, `existencia`, `iva`, `estado`)
VALUES (null, 'Papel bond (reamo)', 18000, 30, 80, 70, 19, 'A');
INSERT INTO `bd_rosita`.`producto` (`id_prod`, `nombre_producto`, `precio_venta`, `stock_min`, `stock_max`, `existencia`, `iva`, `estado`)
VALUES (null, 'Calculadora básica', 25000, 15, 40, 35, 19, 'A');
INSERT INTO `bd_rosita`.`producto` (`id_prod`, `nombre_producto`, `precio_venta`, `stock_min`, `stock_max`, `existencia`, `iva`, `estado`)
VALUES (null, 'Cinta adhesiva transparente', 3500, 20, 50, 40, 19, 'A');
INSERT INTO `bd_rosita`.`producto` (`id_prod`, `nombre_producto`, `precio_venta`, `stock_min`, `stock_max`, `existencia`, `iva`, `estado`)
VALUES (null, 'Carpeta de argollas', 10000, 10, 30, 25, 19, 'A');
INSERT INTO `bd_rosita`.`producto` (`id_prod`, `nombre_producto`, `precio_venta`, `stock_min`, `stock_max`, `existencia`, `iva`, `estado`)
VALUES (null, 'Grapadora de escritorio', 8000, 15, 35, 30, 19, 'A');
INSERT INTO `bd_rosita`.`producto` (`id_prod`, `nombre_producto`, `precio_venta`, `stock_min`, `stock_max`, `existencia`, `iva`, `estado`)
VALUES (null, 'Estuche para lápices', 5000, 10, 25, 20, 19, 'A');
INSERT INTO `bd_rosita`.`producto` (`id_prod`, `nombre_producto`, `precio_venta`, `stock_min`, `stock_max`, `existencia`, `iva`, `estado`)
VALUES (null, 'Bloc de notas adhesivas', 6000, 15, 40, 35, 19, 'A');
INSERT INTO `bd_rosita`.`producto` (`id_prod`, `nombre_producto`, `precio_venta`, `stock_min`, `stock_max`, `existencia`, `iva`, `estado`)
VALUES (null, 'Tijeras de oficina', 4500, 10, 30, 25, 19, 'A');
INSERT INTO `bd_rosita`.`producto` (`id_prod`, `nombre_producto`, `precio_venta`, `stock_min`, `stock_max`, `existencia`, `iva`, `estado`)
VALUES (null, 'Papel de colores (50 hojas)', 8000, 20, 50, 40, 19, 'A');
INSERT INTO `bd_rosita`.`producto` (`id_prod`, `nombre_producto`, `precio_venta`, `stock_min`, `stock_max`, `existencia`, `iva`, `estado`)
VALUES (null, 'Plumones para pizarra blanca (juego de 6)', 15000, 25, 60, 50, 19, 'A');
INSERT INTO `bd_rosita`.`producto` (`id_prod`, `nombre_producto`, `precio_venta`, `stock_min`, `stock_max`, `existencia`, `iva`, `estado`)
VALUES (null, 'Pegatinas decorativas', 3500, 15, 35, 30, 19, 'A');
INSERT INTO `bd_rosita`.`producto` (`id_prod`, `nombre_producto`, `precio_venta`, `stock_min`, `stock_max`, `existencia`, `iva`, `estado`)
VALUES (null, 'Archivador de documentos', 12000, 20, 50, 40, 19, 'A');
INSERT INTO `bd_rosita`.`producto` (`id_prod`, `nombre_producto`, `precio_venta`, `stock_min`, `stock_max`, `existencia`, `iva`, `estado`)
VALUES (null, 'Resaltadores (juego de 3)', 9000, 15, 40, 35, 19, 'A');
INSERT INTO `bd_rosita`.`producto` (`id_prod`, `nombre_producto`, `precio_venta`, `stock_min`, `stock_max`, `existencia`, `iva`, `estado`)
VALUES (null, 'Goma de borrar premium', 3000, 10, 25, 20, 19, 'A');




INSERT INTO `bd_rosita`.`cliente` (`id_cliente`, `nombre`, `nit`, `estado`)
VALUES (null, 'Tomas Espitia', 'NIT01','A');
INSERT INTO `bd_rosita`.`cliente` (`id_cliente`, `nombre`, `nit`, `estado`)
VALUES (null, 'Alejandro Chitiva', 'NIT02','A');
INSERT INTO `bd_rosita`.`cliente` (`id_cliente`, `nombre`, `nit`, `estado`)
VALUES (null, 'Apolo Espitia', 'NIT03','A');


INSERT INTO `bd_rosita`.`pais` (`id_pais`, `nombre`)
VALUES (null, 'Colombia');

INSERT INTO `bd_rosita`.`ciudad` (`id_ciudad`, `id_pais`, `nombre`)
VALUES (null, 1, 'Bogotá');
INSERT INTO `bd_rosita`.`ciudad` (`id_ciudad`, `id_pais`, `nombre`)
VALUES (null, 1, 'Cali');
INSERT INTO `bd_rosita`.`ciudad` (`id_ciudad`, `id_pais`, `nombre`)
VALUES (null, 1, 'Medellin');
INSERT INTO `bd_rosita`.`ciudad` (`id_ciudad`, `id_pais`, `nombre`)
VALUES (null, 1, 'Barranquilla');
INSERT INTO `bd_rosita`.`ciudad` (`id_ciudad`, `id_pais`, `nombre`)
VALUES (null, 1, 'Valledupar');
INSERT INTO `bd_rosita`.`ciudad` (`id_ciudad`, `id_pais`, `nombre`)
VALUES (null, 1, 'Yopal');
INSERT INTO `bd_rosita`.`ciudad` (`id_ciudad`, `id_pais`, `nombre`)
VALUES (null, 1, 'Santa Marta');
INSERT INTO `bd_rosita`.`ciudad` (`id_ciudad`, `id_pais`, `nombre`)
VALUES (null, 1, 'Leticia');
INSERT INTO `bd_rosita`.`ciudad` (`id_ciudad`, `id_pais`, `nombre`)
VALUES (null, 1, 'Pasto');
INSERT INTO `bd_rosita`.`ciudad` (`id_ciudad`, `id_pais`, `nombre`)
VALUES (null, 1, 'Tunja');
INSERT INTO `bd_rosita`.`ciudad` (`id_ciudad`, `id_pais`, `nombre`)
VALUES (null, 1, 'Cucuta');
INSERT INTO `bd_rosita`.`ciudad` (`id_ciudad`, `id_pais`, `nombre`)
VALUES (null, 1, 'Bucaramanga');




INSERT INTO `bd_rosita`.`proveedor` (`id_prov`, `id_ciudad`, `nombre`, `nit`, `correo`, `telefono`, `direccion`, `estado`)
VALUES (null, 1, 'Pelikan', 'NITPelikan', 'pelikan@proveedor.com', '3152014', 'cra 13 # 12a-45', 'A');
INSERT INTO `bd_rosita`.`proveedor` (`id_prov`, `id_ciudad`, `nombre`, `nit`, `correo`, `telefono`, `direccion`, `estado`)
VALUES (null, 1, 'Norma', 'NITNorma', 'norma@proveedor.com', '7841203', 'cra 10 # 14a-4', 'A');
INSERT INTO `bd_rosita`.`proveedor` (`id_prov`, `id_ciudad`, `nombre`, `nit`, `correo`, `telefono`, `direccion`, `estado`)
VALUES (null, 1, 'Sanford', 'NITSanford', 'sandford@proveedor.com', '1204841', 'cra 1 # 144-87', 'A');
INSERT INTO `bd_rosita`.`proveedor` (`id_prov`, `id_ciudad`, `nombre`, `nit`, `correo`, `telefono`, `direccion`, `estado`)
VALUES (null, 1, 'Kilometrico', 'NITKilo', 'kilo@proveedor.com', '3217000', 'cra 32 # 4-78', 'A');
INSERT INTO `bd_rosita`.`proveedor` (`id_prov`, `id_ciudad`, `nombre`, `nit`, `correo`, `telefono`, `direccion`, `estado`)
VALUES (null, 1, 'Papermate', 'NITpaper', 'paper@proveedor.com', '7841001', 'cra 177 # 7b-44', 'A');
INSERT INTO `bd_rosita`.`proveedor` (`id_prov`, `id_ciudad`, `nombre`, `nit`, `correo`, `telefono`, `direccion`, `estado`)
VALUES (null, 1, 'Parker', 'NITParker', 'parker@proveedor.com', '1422512', 'cra 100 # 32-44', 'A');
INSERT INTO `bd_rosita`.`proveedor` (`id_prov`, `id_ciudad`, `nombre`, `nit`, `correo`, `telefono`, `direccion`, `estado`)
VALUES (null, 1, 'Liquid paper', 'NITLiquid', 'liquid@proveedor.com', '9998510', 'cra 74 # 5-24', 'A');
INSERT INTO `bd_rosita`.`proveedor` (`id_prov`, `id_ciudad`, `nombre`, `nit`, `correo`, `telefono`, `direccion`, `estado`)
VALUES (null, 1, 'Magicolor', 'NITMColor', 'mcolor@proveedor.com', '1245000', 'cra 7 # 144-78', 'A');
INSERT INTO `bd_rosita`.`proveedor` (`id_prov`, `id_ciudad`, `nombre`, `nit`, `correo`, `telefono`, `direccion`, `estado`)
VALUES (null, 1, 'Prismacolor', 'NITPcolor', 'pcolor@proveedor.com', '4104411', 'cra 71 # 94-9', 'A');
INSERT INTO `bd_rosita`.`proveedor` (`id_prov`, `id_ciudad`, `nombre`, `nit`, `correo`, `telefono`, `direccion`, `estado`)
VALUES (null, 1, 'Mirado', 'NITMirado', 'mirado@proveedor.com', '6541074', 'cra 12 # 174-4', 'A');
INSERT INTO `bd_rosita`.`proveedor` (`id_prov`, `id_ciudad`, `nombre`, `nit`, `correo`, `telefono`, `direccion`, `estado`)
VALUES (null, 1, 'Abrifolder', 'NITAfolder', 'afolder@proveedor.com', '9874101', 'cra 4 # 7b-8', 'A');
INSERT INTO `bd_rosita`.`proveedor` (`id_prov`, `id_ciudad`, `nombre`, `nit`, `correo`, `telefono`, `direccion`, `estado`)
VALUES (null, 1, 'Gema', 'NITGema', 'gema@proveedor.com', '8647923', 'cra 122 # 174-8', 'A');
INSERT INTO `bd_rosita`.`proveedor` (`id_prov`, `id_ciudad`, `nombre`, `nit`, `correo`, `telefono`, `direccion`, `estado`)
VALUES (null, 1, 'Colibri', 'NITColibri', 'colibri@proveedor.com', '6549987', 'cra 6 # 148-1', 'A');
INSERT INTO `bd_rosita`.`proveedor` (`id_prov`, `id_ciudad`, `nombre`, `nit`, `correo`, `telefono`, `direccion`, `estado`)
VALUES (null, 1, 'Bic', 'NITBic', 'bic@proveedor.com', '3214196', 'cra 200 # 54-30', 'A');
INSERT INTO `bd_rosita`.`proveedor` (`id_prov`, `id_ciudad`, `nombre`, `nit`, `correo`, `telefono`, `direccion`, `estado`)
VALUES (null, 1, 'Barrilito', 'NITBarri', 'barri@proveedor.com', '4108585', 'cra 32 # 174-10', 'A');
INSERT INTO `bd_rosita`.`proveedor` (`id_prov`, `id_ciudad`, `nombre`, `nit`, `correo`, `telefono`, `direccion`, `estado`)
VALUES (null, 1, 'Faber castell', 'NITFcastell', 'fcastell@proveedor.com', '9874102', 'cra 32 # 74-10', 'A');
