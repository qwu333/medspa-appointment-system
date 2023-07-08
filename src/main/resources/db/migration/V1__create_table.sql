CREATE TABLE treatments (
                            id          BIGSERIAL NOT NULL,
                            treatment_name        VARCHAR(30) not null unique,
                            treatment_cost        numeric(19,2),
                            treatment_price       numeric(19,2),
                            treatment_length      INTEGER,
                            treatment_target      VARCHAR(150),
                            nurses                VARCHAR(50)
);
ALTER TABLE treatments ADD CONSTRAINT treatments_pk PRIMARY KEY (id);

CREATE TABLE clients (
                         id              BIGSERIAL NOT NULL,
                         first_name      VARCHAR(30),
                         last_name       VARCHAR(30),
                         phone_number    INT,
                         email_address   VARCHAR(100),
                         allergies       VARCHAR(150),
                         targets         VARCHAR(150)

);
ALTER TABLE clients ADD CONSTRAINT clients_pk PRIMARY KEY ( id );

CREATE TABLE appointments (
                              id             BIGSERIAL NOT NULL,
                              client_id    BIGINT,
                              date         DATE,
                              time         TIME,
                              treatment    BIGINT
);
ALTER TABLE appointments ADD CONSTRAINT appointments_pk PRIMARY KEY ( id );

ALTER TABLE appointments
    ADD CONSTRAINT appointments_clients_fk FOREIGN KEY ( client_id )
        REFERENCES clients ( id );

ALTER TABLE appointments
    ADD CONSTRAINT appointments_treatments_fk FOREIGN KEY ( treatment )
        REFERENCES treatments ( id );