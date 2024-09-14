/* criando pets*/
CREATE TABLE pets
	(id_pets INTEGER PRIMARY KEY autoincrement NOT NULL,
	nm_pet VARCHAR(30) NOT NULL,
    	tipo VARCHAR(20) NOT NULL,
	sexo VARCHAR(1) NOT NULL CONSTRAINT sexo_check CHECK (sexo IN ('M', 'F')),
    	raca VARCHAR(30) NOT NULL,
	data_nasc DATE NOT NULL,
	cor VARCHAR(20) NOT NULL DEFAULT 'Não informada',
	id_cliente INT NOT NULL,
	FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente) ON DELETE CASCADE ON UPDATE CASCADE);
	
	
/* criando clientes*/
CREATE TABLE clientes
	(id_cliente INTeger PRIMARY KEY autoincrement NOT NULL,
	nm_cliente VARCHAR(50) NOT NULL,
	cpf VARCHAR(8) UNIQUE NOT NULL,
	telefone CHAR(11) NOT NULL,
	cep CHAR(8) NOT NULL,
	nr_residencia VARCHAR(50) NOT NULL,
    	bairro VARCHAR(30) NOT NULL,
	municipio VARCHAR(30) NOT NULL,
    	uf CHAR(2) NOT NULL);
    


/*inserindo dados em pet*/
insert into pets values (10, 'Peach', 'dog', 'M', 'pinscher', 'black', 4)
insert into pets values (20, 'Marie', 'cat', 'F', 'persian', 'white', 4)
insert into pets values (30, 'Romeo', 'dog', 'M', 'srd', 'black and white', 4)
insert into pets values (40, 'Crowley', 'cat', 'M', 'sphynx', '04/08/2017', 'pinkish', 3)
insert into pets values (50, 'Candy', 'dog', 'F', 'fila', '28/05/2022', 'tiger', 3)
insert into pets values (60, 'Calisto', 'cat', 'F', 'srd', '12/01/2018', 'black', 0)
insert into pets values (70, 'Phoenix', 'cat', 'M', 'sphynx', '20/08/2021', 'caramel', 1)
insert into pets values (80, 'Lolla', 'dog', 'F', 'shihtzu', '18/09/2023', 'white', 2)

/*inserindo dados em cliente*/
insert into clientes values (0, 'Anya', '01010101077', '77900000000', '00000000','00','New York City', 'Brooklyn', 'NY')
insert into clientes values (1, 'James', '18181818188', '88911111111', '11111111', '63', 'New York City', 'Manhattan', 'NY')
insert into clientes values (2, 'Sophie','29292929299', '77922222222', '22222222', '89', 'New York City', 'Staten Island', 'NY')
insert into clientes values (3, 'Sadie', '36363636366', '77933333333', '33333333', '45', 'New York City', 'Queens', 'NY')
insert into clientes values (4, 'Evan', '45454545455', '77944444444', '44444444', '26', 'New York City', 'Brooklyn', 'NY')
