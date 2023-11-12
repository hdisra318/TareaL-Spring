CREATE TABLE Usuario(
    id SERIAL,
    curp varchar(20),
    aPaterno varchar(50),
    aMaterno varchar(50),
    saldo float
);

CREATE TABLE producto
(
    id SERIAL,
    nombre VARCHAR(100) NOT NULL,
    tipo_producto VARCHAR(100) NOT NULL,
    stock INTEGER NOT NULL,
    costo FLOAT NOT NULL,
    fecha_adquision DATE NOT NULL,
    fecha_caducidad DATE NOT NULL,
    nombre_proveedor VARCHAR(100) NOT NULL,
    descripcion VARCHAR(100) NOT NULL,
    comentarios VARCHAR(100)
);