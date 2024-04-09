CREATE TABLE usuarios (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(255) NOT NULL,
  apellido VARCHAR(255) NOT NULL,
  correo_electronico VARCHAR(255) NOT NULL UNIQUE,
  contrasena VARCHAR(255) NOT NULL,
  rol VARCHAR(255) NOT NULL,
  fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);

CREATE TABLE aviones (
  id INT NOT NULL AUTO_INCREMENT,
  matricula VARCHAR(255) NOT NULL UNIQUE,
  modelo VARCHAR(255) NOT NULL,
  capacidad_pasajeros INT NOT NULL,
  combustible_maximo INT NOT NULL,
  origen VARCHAR(255) NOT NULL,
  destino VARCHAR(255) NOT NULL,
  altitud INT NOT NULL,
  estado VARCHAR(255) NOT NULL,
  fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);

CREATE TABLE vuelos (
  id INT NOT NULL AUTO_INCREMENT,
  id_avion INT NOT NULL,
  fecha_salida DATE NOT NULL,
  hora_salida TIME NOT NULL,
  fecha_llegada DATE NOT NULL,
  hora_llegada TIME NOT NULL,
  origen VARCHAR(255) NOT NULL,
  destino VARCHAR(255) NOT NULL,
  estado VARCHAR(255) NOT NULL,
  retraso INT,
  numero_pasajeros INT NOT NULL,
  id_piloto INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_avion) REFERENCES aviones(id),
  FOREIGN KEY (id_piloto) REFERENCES usuarios(id)
);

CREATE TABLE bitacoras (
  id INT NOT NULL AUTO_INCREMENT,
  fecha_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  usuario VARCHAR(255) NOT NULL,
  accion VARCHAR(255) NOT NULL,
  tabla VARCHAR(255) NOT NULL,
  id_registro INT NOT NULL,
  descripcion VARCHAR(255),
  PRIMARY KEY (id)
);

CREATE TABLE controladores (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(255) NOT NULL,
  apellido VARCHAR(255) NOT NULL,
  correo_electronico VARCHAR(255) NOT NULL UNIQUE,
  contrasena VARCHAR(255) NOT NULL,
  numero_identificacion VARCHAR(255) NOT NULL UNIQUE,
  fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);
