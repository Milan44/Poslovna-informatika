INSERT INTO `bank`.`country` (`country_id`, `country_code`, `name`) VALUES ('1', '100', 'Serbia');
INSERT INTO `bank`.`country` (`country_id`, `country_code`, `name`) VALUES ('2', '200', 'Spanish');
INSERT INTO `bank`.`country` (`country_id`, `country_code`, `name`) VALUES ('3', '300', 'German');
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


INSERT INTO `bank`.`bank` (`id`, `address`, `bank`, `bankCode`, `email`, `fax`, `name`, `phone`, `pib`, `web`) VALUES ('1', 'Bulevar Kralaj Petra 18', b'1', 'UCB', 'uni@uni.com', '253-784-234', 'Unicredit Bank', '064566789', '11', 'www.unicredit.com');
INSERT INTO `bank`.`bank` (`id`, `address`, `bank`, `bankCode`, `email`, `fax`, `name`, `phone`, `pib`, `web`) VALUES ('2', 'Bulevar Oslobodjenja 24', b'1', 'IB', 'intesa@insta.com', '44444', 'Instesa Bank', '066333444', '22', 'www.intesa.com');


INSERT INTO `bank`.`client` (`client_id`, `address`, `addressForStatements`, `email`, `emailStatements`, `fax`, `jmbg`, `name`, `phone`, `pib`, `typeOfClient`, `residence_id`) VALUES ('1', 'Milovana Jelica 15', 'adressStatement1', 'naovis@gmai.com', b'1', '25223', '1004995830255', 'Naovis', '069782145', '11', 'pravno lice', '1');
INSERT INTO `bank`.`client` (`client_id`, `address`, `addressForStatements`, `email`, `emailStatements`, `fax`, `jmbg`, `name`, `phone`, `pib`, `typeOfClient`, `residence_id`) VALUES ('2', 'Marka Markovica 15', 'adressStatement2', 'nis@nis.com', b'1', '44423', '7888996542', 'NIS', '7894562', '22', 'pravno lice', '2');
INSERT INTO `bank`.`client` (`client_id`, `address`, `addressForStatements`, `email`, `emailStatements`, `fax`, `jmbg`, `name`, `phone`, `typeOfClient`, `residence_id`) VALUES ('3', 'Janka Cmelika 12', 'adresaStamenta3', 'pera@pera', b'1', '023711456', '1004995830266', 'Pera Peric', '060123456', 'fizicko lice', '3');


INSERT INTO `bank`.`bankaccount` (`id`, `accountNumber`, `dateOfOpening`, `money`, `valid`, `bank_id`, `client_client_id`, `currency_currency_id`) VALUES ('1', '1', '2006-07-12', '1000', b'1', '1', '1', '1');
INSERT INTO `bank`.`bankaccount` (`id`, `accountNumber`, `dateOfOpening`, `money`, `valid`, `bank_id`, `client_client_id`, `currency_currency_id`) VALUES ('2', '2', '2008-07-12', '2000', b'1', '1', '1', '2');
INSERT INTO `bank`.`bankaccount` (`id`, `accountNumber`, `dateOfOpening`, `money`, `valid`, `bank_id`, `client_client_id`, `currency_currency_id`) VALUES ('3', '3', '2010-10-10', '3000', b'1', '1', '3', '3');
INSERT INTO `bank`.`bankaccount` (`id`, `accountNumber`, `dateOfOpening`, `money`, `valid`, `bank_id`, `client_client_id`, `currency_currency_id`) VALUES ('4', '4', '2012-12-12', '4000', b'1', '2', '1', '2');
INSERT INTO `bank`.`bankaccount` (`id`, `accountNumber`, `dateOfOpening`, `money`, `valid`, `bank_id`, `client_client_id`, `currency_currency_id`) VALUES ('5', '5', '2013-04-13', '5000', b'1', '1', '2', '2');