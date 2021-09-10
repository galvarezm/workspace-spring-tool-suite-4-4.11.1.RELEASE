INSERT INTO customer (create_at, rut, names, surnames, can_operate) VALUES (NOW(), '1-1', 'Ana Maria', 'Perez Gonzalez', true);
INSERT INTO customer (create_at, rut, names, surnames, can_operate) VALUES (NOW(), '1-2', 'Roberto Danilo', 'Cotapos Huellan', true);
INSERT INTO customer (create_at, rut, names, surnames, can_operate) VALUES (NOW(), '1-3', 'Dayana Isabel', 'Piñera Fox', true);

INSERT INTO money (create_at, code, name, enabled, price) VALUES (NOW(), 'CLP', 'Pesos Chilenos', true, 1000);
INSERT INTO money (create_at, code, name, enabled, price) VALUES (NOW(), 'USD', 'Pesos EE.UU.', true, 780);
INSERT INTO money (create_at, code, name, enabled, price) VALUES (NOW(), 'EUR', 'Pesos Europeos', true, 850);

INSERT INTO order_buy (create_at, limit_date, customer_rut, money_code, operation_type, transaction_price) VALUES (NOW(), NOW(), '1-1', 'USD', 'BUY', 1500);
INSERT INTO order_buy (create_at, limit_date, customer_rut, money_code, operation_type, transaction_price) VALUES (NOW(), NOW(), '1-1', 'USD', 'SALE', 1200);
INSERT INTO order_buy (create_at, limit_date, customer_rut, money_code, operation_type, transaction_price) VALUES (NOW(), NOW(), '1-2', 'EUR', 'SALE', 900);
