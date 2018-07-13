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

INSERT INTO `bank`.`analyticsofstatements`(`itemNumber`, `accountCreditor`, `creditor_recipient`, `currencyDate`, `dateOfReceipt`, `debtorAccount`, `debtor_originator`, `emergency`, `modelApproval`, `modelAssigments`, `purposeOfPayment`,
`referenceNumberAssigments`, `referenceNumberCreditor`, `status`, `sum`, `typeOfMistake`, `dailyAccountBalance_id`, `paymentCurrency_currency_id`, `paymentType_id`, `place_id` )
VALUES ('1', '4', 'Naovis', '2018-07-10', '2018-07-10', '234-1234-234','Cubric i minimum pet sinova,Inc', b'0', NULL, '97', 'Isplata oko aplikacije preduzeca', 
NULL, NULL, NULL, '8000', NULL, NULL, '2', NULL, '1')







