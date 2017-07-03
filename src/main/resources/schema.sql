CREATE TABLE dog (
  id          INTEGER IDENTITY PRIMARY KEY,
  name        VARCHAR(64) NOT NULL,
  breed       VARCHAR(64) NOT NULL,
  age         INTEGER NOT NULL);