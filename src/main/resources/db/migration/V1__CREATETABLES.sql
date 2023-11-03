CREATE TABLE bd_rosita.pais
(
    id_pais INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre  VARCHAR(25)
);
CREATE TABLE bd_rosita.ciudad
(
    id_ciudad INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_pais   INT(10),
    nombre    VARCHAR(25),
    FOREIGN KEY (id_pais) REFERENCES bd_rosita.pais (id_pais)
);

CREATE TABLE bd_rosita.proveedor
(
    id_prov   INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_ciudad INT(10),
    nombre    VARCHAR(40),
    nit       VARCHAR(25),
    correo    VARCHAR(25),
    telefono  VARCHAR(15),
    direccion VARCHAR(30),
    estado    VARCHAR(1),
    FOREIGN KEY (id_ciudad) REFERENCES bd_rosita.ciudad (id_ciudad)
);

CREATE TABLE bd_rosita.producto
(
    id_prod         INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre_producto VARCHAR(50),
    precio_venta    INT(10),
    stock_min       INT(10),
    stock_max       INT(10),
    existencia      INT(10),
    estado          VARCHAR(1)
);

CREATE TABLE bd_rosita.producto_proveedor
(
    id_prod_prov INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_prod      INT(10),
    id_prov      INT(10),
    FOREIGN KEY (id_prov) REFERENCES bd_rosita.proveedor (id_prov),
    FOREIGN KEY (id_prod) REFERENCES bd_rosita.producto (id_prod)
);

CREATE TABLE bd_rosita.cliente
(
    id_cliente INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre     VARCHAR(60),
    nit        VARCHAR(25),
    estado     VARCHAR(1)
);

CREATE TABLE bd_rosita.detalle_cliente
(
    id_detalle_cliente INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    correo             VARCHAR(25),
    telefono           VARCHAR(15),
    direccion          VARCHAR(30),
    estado             VARCHAR(1),
    id_ciudad          INT(10),
    id_cliente         INT(10),
    FOREIGN KEY (id_cliente) REFERENCES bd_rosita.cliente (id_cliente),
    FOREIGN KEY (id_ciudad) REFERENCES bd_rosita.ciudad (id_ciudad)
);
CREATE TABLE bd_rosita.rol_usuario
(
    id_rol     INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre_rol VARCHAR(20)
);

CREATE TABLE bd_rosita.usuario
(
    id_usuario       INT(10)     NOT NULL AUTO_INCREMENT PRIMARY KEY,
    usuario          VARCHAR(50),
    contraseña       VARCHAR(30) NOT NULL,
    primer_nombre    VARCHAR(20),
    segundo_nombre   VARCHAR(20),
    primer_apellido  VARCHAR(20),
    segundo_apellido VARCHAR(20),
    estado           VARCHAR(1),
    id_rol           INT(10)     not null,
    FOREIGN KEY (id_rol) REFERENCES bd_rosita.rol_usuario (id_rol)
);


CREATE TABLE bd_rosita.venta
(
    id_venta    INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_cliente  INT(10),
    fecha_venta DATE,
    total_venta INT,
    FOREIGN KEY (id_cliente) REFERENCES bd_rosita.cliente (id_cliente)
);

CREATE TABLE bd_rosita.detalle_venta
(
    id_detalle_venta INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_venta         INT(10),
    id_prod          INT(10),
    cantidad         INT,
    subtotal         INT(10),
    FOREIGN KEY (id_venta) REFERENCES bd_rosita.venta (id_venta),
    FOREIGN KEY (id_prod) REFERENCES bd_rosita.producto (id_prod)
);

CREATE TABLE bd_rosita.estado_proveedor
(
    id_estado          INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    descripcion_estado VARCHAR(50)
);

CREATE TABLE bd_rosita.orden_proveedor
(
    id_orden_proveedor   INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_prov              INT(10),
    fecha_orden          DATE,
    fecha_orden_recibida DATE,
    id_estado            INT(10),
    FOREIGN KEY (id_prov) REFERENCES bd_rosita.proveedor (id_prov),
    FOREIGN KEY (id_estado) REFERENCES bd_rosita.estado_proveedor (id_estado)
);

CREATE TABLE bd_rosita.detalle_orden_proveedor
(
    id_detalle_orden_proveedor INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_orden_proveedor         INT(10),
    id_prod_prov               INT(10),
    cantidad                   INT,
    precio_compra              INT,
    FOREIGN KEY (id_orden_proveedor) REFERENCES bd_rosita.orden_proveedor (id_orden_proveedor),
    FOREIGN KEY (id_prod_prov) REFERENCES bd_rosita.producto_proveedor (id_prod_prov)
);