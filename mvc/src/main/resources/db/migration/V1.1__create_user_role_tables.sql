DROP TABLE IF EXISTS users CASCADE;
--DROP TABLE IF EXISTS refers CASCADE

CREATE TABLE users(
    id                  BIGSERIAL not null ,
    name                VARCHAR(30) not null unique,
    password            VARCHAR(64),
    secrete_key         VARCHAR(512),
    first_name          VARCHAR(30),
    last_name           VARCHAR(30),
    email               VARCHAR(50) not null unique
);

ALTER TABLE users ADD CONSTRAINT users_pk PRIMARY KEY (id);

CREATE TABLE roles(
    id                  BIGSERIAL not null ,
    name                VARCHAR(30) not null unique ,
    allowed_resource    VARCHAR(200),
    allowed_read        BOOLEAN not null default FALSE,
    allowed_create      BOOLEAN not null default FALSE,
    allowed_update      BOOLEAN not null default FALSE,
    allowed_delete      BOOLEAN not null default FALSE
);

ALTER TABLE roles ADD CONSTRAINT roles_pk PRIMARY KEY (id);

CREATE TABLE users_roles(
    user_id             BIGINT NOT NULL ,
    role_id             BIGINT NOT NULL
);

ALTER TABLE users_roles
    ADD CONSTRAINT users_fk FOREIGN KEY (user_id)
        REFERENCES users(id);

ALTER TABLE users_roles
    ADD CONSTRAINT roles_fk FOREIGN KEY (role_id)
        REFERENCES roles(id);