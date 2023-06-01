INSERT INTO produto (descricao, valor) VALUES ('Blocos De Montar Lego Minecraft Casa Cogumelo Peças 272.', 197.00);
INSERT INTO produto (descricao, valor) VALUES ('Dinossauro Emite Som e anda pela casa a noite. Presente Legal.', 89.00);
INSERT INTO produto (descricao, valor) VALUES ('Luva lança Teia do Homem Aranha ', 35.00);
INSERT INTO produto (descricao, valor) VALUES ('Cacto Dançante E Falante Toca Música Repete A Fala.', 46.00);
INSERT INTO produto (descricao, valor) VALUES ('Boneco Baby Yoda The Child Star Wars The Mandalorian.', 180.00);

INSERT INTO pessoa (id,nome) VALUES (1,'Rafael');
INSERT INTO pessoa (id,nome) VALUES (2,'Jeferson');
INSERT INTO pessoa (id,nome) VALUES (3,'William');
INSERT INTO pessoa (id,nome) VALUES (4,'Douglas');


INSERT INTO pessoa_fisica (cpf, pessoa_id) VALUES ('111555888-88', 1);
INSERT INTO pessoa_fisica (cpf, pessoa_id) VALUES ('111555888-88', 2);

INSERT INTO pessoa_juridica (cnpj, pessoa_id) VALUES ('4440000001/0001-10', 4);
INSERT INTO pessoa_juridica (cnpj, pessoa_id) VALUES ('0004144656/0001-80', 3);

INSERT INTO venda (data, pessoa_id) VALUES ('2022-01-01', 1);
INSERT INTO venda (data, pessoa_id) VALUES ('2022-02-02', 4);

INSERT INTO item_venda (quantidade,produto_id, venda_id) VALUES (2, 1, 1);
INSERT INTO item_venda (quantidade,produto_id, venda_id) VALUES (2, 2, 2);



