CREATE DATABASE IF NOT EXISTS indicator_db;

CREATE TABLE IF NOT EXISTS indicators
(
    id             BIGINT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    indicator_name VARCHAR(55)    NOT NULL,
    expected_value DECIMAL(10, 2) NOT NULL,
    max_value      DECIMAL(10, 2) NOT NULL,
    min_value      DECIMAL(10, 2) NOT NULL
);

CREATE TABLE IF NOT EXISTS measurements
(
    id                BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    indicator_id      BIGINT NOT NULL,
    description       VARCHAR(255)   NOT NULL,
    measurement_date  DATE   NOT NULL,
    measurement_value DECIMAL(10, 2),
    FOREIGN KEY (indicator_id) REFERENCES indicators (id)
);

-- Consulta SQL
/*SELECT ind.indicator_name,
       me.measurement_date,
       me.description,
       me.measurement_value,
       CASE
           WHEN me.measurement_value < ind.min_value THEN 'RED'
           WHEN me.measurement_value >= ind.min_value AND me.measurement_value < ind.expected_value THEN 'YELLOW'
           WHEN me.measurement_value >= ind.expected_value AND me.measurement_value <= ind.max_value THEN 'GREEN'
           WHEN me.measurement_value > ind.max_value THEN 'BLUE'
           END AS Status
FROM measurements me
         JOIN
     indicators ind ON me.indicator_id = ind.id
ORDER BY me.measurement_date;

SELECT  * FROM measurements;*/
