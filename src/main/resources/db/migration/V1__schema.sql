CREATE TABLE IF NOT EXISTS Employee (
    id   INT  UNIQUE PRIMARY KEY NOT NULL,
   name  VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Reservation (
    id INT,
    name VARCHAR,
    reserve DATE,
    status BOOLEAN,
    PRIMARY KEY (id, reserve),
    FOREIGN KEY (id) REFERENCES Employee(id) ON DELETE CASCADE
);