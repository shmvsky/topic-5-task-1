CREATE SEQUENCE IF NOT EXISTS todos_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE todos
(
    id          INTEGER NOT NULL,
    title       VARCHAR(100) NOT NULL,
    description TEXT,
    completed   BOOLEAN default false,
    CONSTRAINT pk_todos PRIMARY KEY (id)
);
