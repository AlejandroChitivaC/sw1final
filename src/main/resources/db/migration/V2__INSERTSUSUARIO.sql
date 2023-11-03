/*inserts para el rol de usuario*/
INSERT INTO `bd_rosita`.`rol_usuario`(`id_rol`, `nombre_rol`) VALUES (null, 'Admin');
INSERT INTO `bd_rosita`.`rol_usuario`(`id_rol`, `nombre_rol`) VALUES (null, 'Employee');

/*inserts de usuarios todos con rol de admin*/
INSERT INTO `bd_rosita`.`usuario` (`id_usuario`, `usuario`, `contraseña`, `primer_nombre`, `segundo_nombre`, `primer_apellido`, `segundo_apellido`, `estado`, `id_rol`)
VALUES (null, 'jeison', '12345', 'Jeison', 'Gabriel', 'Pedraza', 'Sanabria', 'A', 1);
INSERT INTO `bd_rosita`.`usuario` (`id_usuario`, `usuario`, `contraseña`, `primer_nombre`, `segundo_nombre`, `primer_apellido`, `segundo_apellido`, `estado`,`id_rol`)
VALUES (null, 'karen', '321654', 'Karen', 'Ximena', 'Rojas', 'Calderon', 'A', 1);
INSERT INTO `bd_rosita`.`usuario` (`id_usuario`, `usuario`, `contraseña`, `primer_nombre`, `segundo_nombre`, `primer_apellido`, `segundo_apellido`, `estado`,`id_rol`)
VALUES (null, 'alejandro', '1027150463', 'Alejandro', null, 'Chitiva', 'Castillo', 'A', 1);
INSERT INTO `bd_rosita`.`usuario` (`id_usuario`, `usuario`, `contraseña`, `primer_nombre`, `segundo_nombre`, `primer_apellido`, `segundo_apellido`, `estado`,`id_rol`)
VALUES (null, 'karen', '321654', 'Tomas', null, 'Espitia', 'Galindo', 'A', 1);