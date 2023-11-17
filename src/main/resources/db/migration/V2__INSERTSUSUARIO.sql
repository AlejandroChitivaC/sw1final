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
VALUES (null, 'regla', 5500, 150, 300, 200, 19, 'A');


INSERT INTO `bd_rosita`.`cliente` (`id_cliente`, `nombre`, `nit`, `estado`)
VALUES (null, 'Tomas Espitia', 'NIT01','A');
INSERT INTO `bd_rosita`.`cliente` (`id_cliente`, `nombre`, `nit`, `estado`)
VALUES (null, 'Alejandro Chitiva', 'NIT02','A');
INSERT INTO `bd_rosita`.`cliente` (`id_cliente`, `nombre`, `nit`, `estado`)
VALUES (null, 'Apolo Espitia', 'NIT03','A');