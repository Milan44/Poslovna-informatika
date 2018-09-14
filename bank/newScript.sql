INSERT INTO `bank`.`user` (`id`, `email`, `password`) VALUES ('1', 'baka@baka', '9403076d15b643fa4abbd4cab9a89cca09c97a2361d91d7f4c00a655dfc98bdada39b9e1b007349bfb4430395b1eef37d5afe10036edb1a96383480694431bd6');

INSERT INTO `bank`.`country` (`country_id`, `country_code`, `name`) VALUES ('1', '100', 'Serbia');
INSERT INTO `bank`.`country` (`country_id`, `country_code`, `name`) VALUES ('2', '200', 'Spain');
INSERT INTO `bank`.`country` (`country_id`, `country_code`, `name`) VALUES ('3', '300', 'Germany');
INSERT INTO `bank`.`country` (`country_id`, `country_code`, `name`) VALUES ('4', '400', 'Italy');
INSERT INTO `bank`.`country` (`country_id`, `country_code`, `name`) VALUES ('5', '500', 'France');


INSERT INTO `bank`.`place` (`id`, `name`, `pttNumber`, `country_country_id`) VALUES ('1', 'Belgrade', '101', '1');
INSERT INTO `bank`.`place` (`id`, `name`, `pttNumber`, `country_country_id`) VALUES ('2', 'Barcelona', '202', '2');
INSERT INTO `bank`.`place` (`id`, `name`, `pttNumber`, `country_country_id`) VALUES ('3', 'Munich', '303', '3');
INSERT INTO `bank`.`place` (`id`, `name`, `pttNumber`, `country_country_id`) VALUES ('4', 'Rome', '404', '4');
INSERT INTO `bank`.`place` (`id`, `name`, `pttNumber`, `country_country_id`) VALUES ('5', 'Paris', '505', '5');

INSERT INTO `bank`.`currency` (`currency_id`, `domicilna`, `name`, `official_code`, `country_country_id`) VALUES ('1', b'1', 'Dinar', 'RSD', '1');
INSERT INTO `bank`.`currency` (`currency_id`, `domicilna`, `name`, `official_code`, `country_country_id`) VALUES ('2', b'0', 'Euro', '€', '2');
INSERT INTO `bank`.`currency` (`currency_id`, `domicilna`, `name`, `official_code`, `country_country_id`) VALUES ('3', b'1', 'Dolar', '$', '3');


INSERT INTO `bank`.`bank` (`id`, `address`, `bank`, `bankCode`, `email`, `fax`, `name`, `phone`, `pib`, `web`, `swift`, `racun`) VALUES ('101', 'Bulevar Kralaj Petra 18', b'1', 'UCB', 'uni@uni.com', '253-784-234', 'Unicredit Bank', '064566789', '11', 'www.unicredit.com', '11111111', '553456789876543212');
INSERT INTO `bank`.`bank` (`id`, `address`, `bank`, `bankCode`, `email`, `fax`, `name`, `phone`, `pib`, `web`, `swift`, `racun`) VALUES ('102', 'Bulevar Oslobodjenja 24', b'1', 'IB', 'intesa@insta.com', '44444', 'Instesa Bank', '066333444', '22', 'www.intesa.com', '22222222', '552345678987656565');
INSERT INTO `bank`.`bank` (`id`, `address`, `bank`, `bankCode`, `email`, `fax`, `name`, `phone`, `pib`, `racun`, `swift`, `web`) VALUES ('103', 'Laze Teleckog 5', b'1', 'NB', 'nasa@nasa', '323-545-786', 'Nasa Banka', '0698435522', '33', '555989898989812345', '55555555', 'www.nasa.com');
INSERT INTO `bank`.`bank` (`id`, `address`, `bank`, `bankCode`, `email`, `fax`, `name`, `phone`, `pib`, `racun`, `swift`, `web`) VALUES ('104', 'Trifkovicev Trg 7', b'1', 'SGB', 'societe@societe', '323-372-323', 'Societe Generale Bank', '0612537788', '44', '556984532654194639', '66666666', 'www.societe.com');


INSERT INTO `bank`.`client` (`client_id`, `address`, `addressForStatements`, `email`, `emailStatements`, `fax`, `jmbg`, `name`, `phone`, `pib`, `typeOfClient`, `residence_id`) VALUES ('101', 'Milovana Jelica 15', 'adressStatement1', 'naovis@gmai.com', b'1', '25223', '1004995830255', 'Naovis', '069782145', '11', 'pravno lice', '1');
INSERT INTO `bank`.`client` (`client_id`, `address`, `addressForStatements`, `email`, `emailStatements`, `fax`, `jmbg`, `name`, `phone`, `pib`, `typeOfClient`, `residence_id`) VALUES ('102', 'Marka Markovica 15', 'adressStatement2', 'nis@nis.com', b'1', '44423', '7888996542', 'NIS', '7894562', '22', 'pravno lice', '2');
INSERT INTO `bank`.`client` (`client_id`, `address`, `addressForStatements`, `email`, `emailStatements`, `fax`, `jmbg`, `name`, `phone`, `typeOfClient`, `residence_id`) VALUES ('103', 'Janka Cmelika 12', 'adresaStamenta3', 'pera@pera', b'1', '023711456', '1004995830266', 'Pera Peric', '060123456', 'fizicko lice', '3');
INSERT INTO `bank`.`client` (`client_id`, `address`, `addressForStatements`, `email`, `emailStatements`, `fax`, `jmbg`, `name`, `phone`, `pib`, `typeOfClient`, `residence_id`) VALUES ('104', 'Brace Ribnikar 13', 'adressStatement5', 'simpo@simpo', b'1', '34567', '1265787654345', 'Simpo', '0607856633', '44', 'pravno lice', '1');
INSERT INTO `bank`.`client` (`client_id`, `address`, `addressForStatements`, `email`, `emailStatements`, `fax`, `jmbg`, `name`, `phone`, `pib`, `typeOfClient`, `residence_id`) VALUES ('105', 'Dr Sime Milosevica 34', 'adressStatement6', 'ftn@ftn', b'1', '59845', '8745985632547', 'Fakultet tehnickih nauka', '0632156633', '55', 'pravno lice', '1');
INSERT INTO `bank`.`client` (`client_id`, `address`, `addressForStatements`, `email`, `emailStatements`, `fax`, `jmbg`, `name`, `phone`, `pib`, `typeOfClient`, `residence_id`) VALUES ('106', 'Bulevar Oslobodjenja 76', 'adressStatement7', 'mercator@mercator', b'1', '94847', '7543363724515', 'Mercator', '0657854427', '66', 'pravno lice', '1');



INSERT INTO `bank`.`bankaccount` (`id`, `accountNumber`, `dateOfOpening`, `money`, `valid`, `bank_id`, `client_client_id`, `currency_currency_id`) VALUES ('101', '552787843787856669', '2018-08-05', '0', b'1', '103', '102', '2');
INSERT INTO `bank`.`bankaccount` (`id`, `accountNumber`, `dateOfOpening`, `money`, `valid`, `bank_id`, `client_client_id`, `currency_currency_id`) VALUES ('102', '553987633546212332', '2018-08-05', '0', b'1', '101', '103', '3');
INSERT INTO `bank`.`bankaccount` (`id`, `accountNumber`, `dateOfOpening`, `money`, `valid`, `bank_id`, `client_client_id`, `currency_currency_id`) VALUES ('103', '555123456789874563', '2018-08-05', '0', b'1', '103', '101', '1');
INSERT INTO `bank`.`bankaccount` (`id`, `accountNumber`, `dateOfOpening`, `money`, `valid`, `bank_id`, `client_client_id`, `currency_currency_id`) VALUES ('104', '555123456789888845', '2018-08-05', '0', b'1', '103', '105', '1');
INSERT INTO `bank`.`bankaccount` (`id`, `accountNumber`, `dateOfOpening`, `money`, `valid`, `bank_id`, `client_client_id`, `currency_currency_id`) VALUES ('105', '555356776543122145', '2018-08-05', '0', b'1', '103', '106', '1');
INSERT INTO `bank`.`bankaccount` (`id`, `accountNumber`, `dateOfOpening`, `money`, `valid`, `bank_id`, `client_client_id`, `currency_currency_id`) VALUES ('106', '556899654321354532', '2018-08-05', '0', b'1', '104', '104', '1');


INSERT INTO `bank`.`paymenttype` (`id`, `code`, `nameOfPaymentType`) VALUES ('1', 'CSH', 'cash');
INSERT INTO `bank`.`paymenttype` (`id`, `code`, `nameOfPaymentType`) VALUES ('2', 'MCD', 'mastercard');


UPDATE `bank`.`bankaccount` SET `accountNumber`='552123456789555555', `dateOfOpening`='2008-04-13 00:00:00', `money`='0', `client_client_id`='104' WHERE `id`='106';
UPDATE `bank`.`bankaccount` SET `accountNumber`='555123456789555555', `dateOfOpening`='2013-04-13 00:00:00', `money`='0', `client_client_id`='102' WHERE `id`='105';
UPDATE `bank`.`bankaccount` SET `accountNumber`='555123456789555554', `dateOfOpening`='2012-12-12 00:00:00', `money`='0', `bank_id`='103', `client_client_id`='101', `currency_currency_id`='2' WHERE `id`='104';
UPDATE `bank`.`bankaccount` SET `accountNumber`='555123456789555553', `dateOfOpening`='2010-10-10 00:00:00', `money`='0', `bank_id`='103', `client_client_id`='103', `currency_currency_id`='3' WHERE `id`='103';
UPDATE `bank`.`bankaccount` SET `accountNumber`='555123456789555552', `dateOfOpening`='2008-07-12 00:00:00', `money`='0', `client_client_id`='101', `currency_currency_id`='2' WHERE `id`='102';
UPDATE `bank`.`bankaccount` SET `accountNumber`='554123456789555555', `dateOfOpening`='2006-07-12 00:00:00', `money`='0', `bank_id`='101', `client_client_id`='101', `currency_currency_id`='1' WHERE `id`='101';

