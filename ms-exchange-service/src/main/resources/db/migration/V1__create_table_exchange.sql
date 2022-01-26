CREATE TABLE tb_exchange (
  id INT(10) AUTO_INCREMENT PRIMARY KEY,
  from_currency CHAR(3) NOT NULL,
  to_currency CHAR(3) NOT NULL,
  conversion_factor decimal(65,2) NOT NULL
);

INSERT INTO tb_exchange (from_currency, to_currency, conversion_factor)
    VALUES ('USD', 'BRL', 5.73),
			('USD', 'EUR', 0.84),
			('USD', 'GBP', 0.73),
			('USD', 'ARS', 92.56),
			('USD', 'CLP', 713.30),
			('USD', 'COP', 3665.00),
			('USD', 'MXN', 20.15);
