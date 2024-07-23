CREATE TABLE public.proveedores (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR NOT NULL,
    rut VARCHAR NOT NULL,
    direccion VARCHAR NOT NULL,
    correo VARCHAR NOT NULL,
    telefono VARCHAR NOT NULL,
    contacto VARCHAR NOT NULL,
    telefono_contacto VARCHAR NOT NULL
);
