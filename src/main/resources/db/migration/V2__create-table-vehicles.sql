CREATE TABLE tb_user(
                          id BIGSERIAL PRIMARY KEY NOT NULL,
                          login VARCHAR(255),
                          password VARCHAR(255) ,
                          role VARCHAR(255)
);

CREATE TABLE tb_vehicles(
                              id_vehicle BIGSERIAL PRIMARY KEY,
                              name VARCHAR (255),
                              brand VARCHAR (255),
                              model VARCHAR (255),
                              price DOUBLE PRECISION NOT NULL
);

CREATE TABLE tb_images(
                            id_image BIGSERIAL PRIMARY KEY NOT NULL,
                            id_vehicle BIGSERIAL,
                            name VARCHAR (255),
                            FOREIGN KEY (id_vehicle) REFERENCES tb_vehicles(id_vehicle)
)
