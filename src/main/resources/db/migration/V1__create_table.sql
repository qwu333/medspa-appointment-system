CREATE TABLE Treatments (
                            id          BIGSERIAL NOT NULL,
                            Treatment_Name        VARCHAR(30) not null unique,
                            Treatment_Cost        MONEY,
                            Treatment_Price       MONEY,
                            Treatment_Length      INTEGER,
                            Treatment_Target      VARCHAR(150),
                            Nurses                VARCHAR(50)
);
ALTER TABLE Treatments ADD CONSTRAINT Treatments_pk PRIMARY KEY (id);

CREATE TABLE Clients (
                         id              BIGSERIAL NOT NULL,
                         name            VARCHAR(30) not null unique,
                         First_Name      VARCHAR(30),
                         Last_Name       VARCHAR(30),
                         Phone_Number    INT,
                         Email_Address   VARCHAR(100),
                         Allergies       VARCHAR(150),
                         Targets         VARCHAR(150)

);
ALTER TABLE Clients ADD CONSTRAINT clients_pk PRIMARY KEY ( id );

CREATE TABLE Appointments (
                              id             BIGSERIAL NOT NULL,
                              Client_ID    BIGINT,
                              Date         DATE,
                              Time         TIME,
                              Treatment    BIGINT
);
ALTER TABLE Appointments ADD CONSTRAINT Appointments_pk PRIMARY KEY ( id );

ALTER TABLE Appointments
    ADD CONSTRAINT appointments_clients_fk FOREIGN KEY ( Client_ID )
        REFERENCES Clients ( id );

ALTER TABLE Appointments
    ADD CONSTRAINT appointments_treatments_fk FOREIGN KEY ( Treatment )
        REFERENCES Treatments ( id );