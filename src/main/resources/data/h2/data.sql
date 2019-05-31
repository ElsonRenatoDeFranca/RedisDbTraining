-- Alimentos
INSERT INTO PRODUCT (ID,PRODUCT_ID,PRODUCT_NAME, PRODUCT_DESCRIPTION, PRODUCT_COST) VALUES(1, 1, 'Arroz', 'Arroz Parboilizado', 3.50);
INSERT INTO PRODUCT (ID,PRODUCT_ID, PRODUCT_NAME, PRODUCT_DESCRIPTION, PRODUCT_COST) VALUES(2, 2, 'Feijao', 'Feijao Sitio Cercado', 4.10);

-- Eletrodomésticos
INSERT INTO PRODUCT (ID,PRODUCT_ID, PRODUCT_NAME, PRODUCT_DESCRIPTION, PRODUCT_COST) VALUES(3, 3, 'Aspirador de po', 'Aspirador Vertical Philco Turbo - 309', 193.50);
INSERT INTO PRODUCT (ID,PRODUCT_ID, PRODUCT_NAME, PRODUCT_DESCRIPTION, PRODUCT_COST) VALUES(4, 4, 'Batedeira', 'Batedeira Stand Mixer', 3.599);
INSERT INTO PRODUCT (ID,PRODUCT_ID, PRODUCT_NAME, PRODUCT_DESCRIPTION, PRODUCT_COST) VALUES(5, 5, 'Liquidificador', 'Liquidificador Phillips Walita', 149.00);


-- Móveis
INSERT INTO PRODUCT (ID,PRODUCT_ID, PRODUCT_NAME, PRODUCT_DESCRIPTION, PRODUCT_COST) VALUES(6, 6, 'Sofa', 'Sofa 3 Lugares Retratil Kennedy', 2.500);
INSERT INTO PRODUCT (ID,PRODUCT_ID, PRODUCT_NAME, PRODUCT_DESCRIPTION, PRODUCT_COST) VALUES(7, 7, 'Mesa', 'Mesa de Jantar com 4 cadeiras Tabaco-Perola Rossini', 510.00);
INSERT INTO PRODUCT (ID,PRODUCT_ID, PRODUCT_NAME, PRODUCT_DESCRIPTION, PRODUCT_COST) VALUES(8, 8, 'Estante', 'Estante Multiuso 5 Divisorias', 420.00);


--Insert categories
INSERT INTO CATEGORY (ID, CATEGORY_ID, CATEGORY_NAME) VALUES(1, 1, 'Alimentos');
INSERT INTO CATEGORY (ID, CATEGORY_ID, CATEGORY_NAME) VALUES(2, 2, 'Eletrodomesticos');
INSERT INTO CATEGORY (ID, CATEGORY_ID, CATEGORY_NAME) VALUES(3, 3, 'Moveis');


INSERT INTO PRODUCT_CATEGORY ( CATEGORY_ID, PRODUCT_ID) VALUES(1, 1);
INSERT INTO PRODUCT_CATEGORY ( CATEGORY_ID, PRODUCT_ID) VALUES(1, 2);

INSERT INTO PRODUCT_CATEGORY ( CATEGORY_ID, PRODUCT_ID) VALUES( 2, 3);
INSERT INTO PRODUCT_CATEGORY ( CATEGORY_ID, PRODUCT_ID) VALUES( 2, 4);
INSERT INTO PRODUCT_CATEGORY ( CATEGORY_ID, PRODUCT_ID) VALUES( 2, 5);
INSERT INTO PRODUCT_CATEGORY ( CATEGORY_ID, PRODUCT_ID) VALUES( 3, 6);
INSERT INTO PRODUCT_CATEGORY ( CATEGORY_ID, PRODUCT_ID) VALUES( 3, 7);
INSERT INTO PRODUCT_CATEGORY ( CATEGORY_ID, PRODUCT_ID) VALUES( 3, 8);