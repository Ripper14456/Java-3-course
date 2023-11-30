CREATE TABLE lab5.residence (
    id BIGINT NOT NULL AUTO_INCREMENT,
    country varchar(100) NOT NULL,
    city varchar(100) NOT NULL,
    address varchar(100) NOT NULL,
    CONSTRAINT PK_RESIDENCE PRIMARY KEY (id)
);

CREATE TABLE lab5.person (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name varchar(100) NOT NULL,
    surname varchar(100) NOT NULL,
    dataOfBirth date NOT NULL,
    id_residence BIGINT, -- Assuming this is the foreign key column
    CONSTRAINT PK_PERSON PRIMARY KEY (id),
    FOREIGN KEY (id_residence) REFERENCES lab5.residence(id) ON UPDATE CASCADE ON DELETE SET NULL
);
