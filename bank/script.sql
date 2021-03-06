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


INSERT INTO `bank`.`bank` (`id`, `address`, `bank`, `bankCode`, `email`, `fax`, `name`, `phone`, `pib`, `web`, `swift`, `racun`) VALUES ('1', 'Bulevar Kralaj Petra 18', b'1', 'UCB', 'uni@uni.com', '253-784-234', 'Unicredit Bank', '064566789', '11', 'www.unicredit.com', '11111111', '553456789876543212');
INSERT INTO `bank`.`bank` (`id`, `address`, `bank`, `bankCode`, `email`, `fax`, `name`, `phone`, `pib`, `web`, `swift`, `racun`) VALUES ('2', 'Bulevar Oslobodjenja 24', b'1', 'IB', 'intesa@insta.com', '44444', 'Instesa Bank', '066333444', '22', 'www.intesa.com', '22222222', '552345678987656565');
INSERT INTO `bank`.`bank` (`id`, `address`, `bank`, `bankCode`, `email`, `fax`, `name`, `phone`, `pib`, `racun`, `swift`, `web`) VALUES ('3', 'Laze Teleckog 5', b'1', 'NB', 'nasa@nasa', '323-545-786', 'Nasa Banka', '0698435522', '33', '555989898989812345', '55555555', 'www.nasa.com');
INSERT INTO `bank`.`bank` (`id`, `address`, `bank`, `bankCode`, `email`, `fax`, `name`, `phone`, `pib`, `racun`, `swift`, `web`) VALUES ('4', 'Trifkovicev Trg 7', b'1', 'SGB', 'societe@societe', '323-372-323', 'Societe Generale Bank', '0612537788', '44', '556984532654194639', '66666666', 'www.societe.com');


INSERT INTO `bank`.`client` (`client_id`, `address`, `addressForStatements`, `email`, `emailStatements`, `fax`, `jmbg`, `name`, `phone`, `pib`, `typeOfClient`, `residence_id`) VALUES ('1', 'Milovana Jelica 15', 'adressStatement1', 'naovis@gmai.com', b'1', '25223', '1004995830255', 'Naovis', '069782145', '11', 'pravno lice', '1');
INSERT INTO `bank`.`client` (`client_id`, `address`, `addressForStatements`, `email`, `emailStatements`, `fax`, `jmbg`, `name`, `phone`, `pib`, `typeOfClient`, `residence_id`) VALUES ('2', 'Marka Markovica 15', 'adressStatement2', 'nis@nis.com', b'1', '44423', '7888996542', 'NIS', '7894562', '22', 'pravno lice', '2');
INSERT INTO `bank`.`client` (`client_id`, `address`, `addressForStatements`, `email`, `emailStatements`, `fax`, `jmbg`, `name`, `phone`, `typeOfClient`, `residence_id`) VALUES ('3', 'Janka Cmelika 12', 'adresaStamenta3', 'pera@pera', b'1', '023711456', '1004995830266', 'Pera Peric', '060123456', 'fizicko lice', '3');
INSERT INTO `bank`.`client` (`client_id`, `address`, `addressForStatements`, `email`, `emailStatements`, `fax`, `jmbg`, `name`, `phone`, `pib`, `typeOfClient`, `residence_id`) VALUES ('4', 'Brace Ribnikar 13', 'adressStatement5', 'simpo@simpo', b'1', '34567', '1265787654345', 'Simpo', '0607856633', '44', 'pravno lice', '1');
INSERT INTO `bank`.`client` (`client_id`, `address`, `addressForStatements`, `email`, `emailStatements`, `fax`, `jmbg`, `name`, `phone`, `pib`, `typeOfClient`, `residence_id`) VALUES ('5', 'Dr Sime Milosevica 34', 'adressStatement6', 'ftn@ftn', b'1', '59845', '8745985632547', 'Fakultet tehnickih nauka', '0632156633', '55', 'pravno lice', '1');
INSERT INTO `bank`.`client` (`client_id`, `address`, `addressForStatements`, `email`, `emailStatements`, `fax`, `jmbg`, `name`, `phone`, `pib`, `typeOfClient`, `residence_id`) VALUES ('6', 'Bulevar Oslobodjenja 76', 'adressStatement7', 'mercator@mercator', b'1', '94847', '7543363724515', 'Mercator', '0657854427', '66', 'pravno lice', '1');



INSERT INTO `bank`.`bankaccount` (`id`, `accountNumber`, `dateOfOpening`, `money`, `valid`, `bank_id`, `client_client_id`, `currency_currency_id`) VALUES ('1', '552787843787856669', '2018-08-05', '5500', b'1', '2', '2', '2');
INSERT INTO `bank`.`bankaccount` (`id`, `accountNumber`, `dateOfOpening`, `money`, `valid`, `bank_id`, `client_client_id`, `currency_currency_id`) VALUES ('2', '553987633546212332', '2018-08-05', '2000', b'1', '1', '3', '3');
INSERT INTO `bank`.`bankaccount` (`id`, `accountNumber`, `dateOfOpening`, `money`, `valid`, `bank_id`, `client_client_id`, `currency_currency_id`) VALUES ('3', '555123456789874563', '2018-08-05', '12000', b'1', '3', '1', '1');
INSERT INTO `bank`.`bankaccount` (`id`, `accountNumber`, `dateOfOpening`, `money`, `valid`, `bank_id`, `client_client_id`, `currency_currency_id`) VALUES ('4', '555123456789888845', '2018-08-05', '7000', b'1', '3', '5', '1');
INSERT INTO `bank`.`bankaccount` (`id`, `accountNumber`, `dateOfOpening`, `money`, `valid`, `bank_id`, `client_client_id`, `currency_currency_id`) VALUES ('5', '555356776543122145', '2018-08-05', '39000', b'1', '3', '6', '1');
INSERT INTO `bank`.`bankaccount` (`id`, `accountNumber`, `dateOfOpening`, `money`, `valid`, `bank_id`, `client_client_id`, `currency_currency_id`) VALUES ('6', '556899654321354532', '2018-08-05', '11500', b'1', '4', '4', '1');


INSERT INTO `bank`.`dailyaccountbalance` (`id`, `newState`, `previousState`, `trafficDate`, `trafficToBenefit`, `trafficToTheBurden`, `legalEntityAccount_id`) VALUES ('1', '3500.5', '2700.3', '2006-07-12', '2200.5', '1115.5', '1');
INSERT INTO `bank`.`dailyaccountbalance` (`id`, `newState`, `previousState`, `trafficDate`, `trafficToBenefit`, `trafficToTheBurden`, `legalEntityAccount_id`) VALUES ('2', '2222.2', '1212.4', '2007-07-12', '558.3', '968.5', '2');
INSERT INTO `bank`.`dailyaccountbalance` (`id`, `newState`, `previousState`, `trafficDate`, `trafficToBenefit`, `trafficToTheBurden`, `legalEntityAccount_id`) VALUES ('3', '78965.5', '33522.5', '2008-07-12', '28396.5', '14259.3', '3');
INSERT INTO `bank`.`dailyaccountbalance` (`id`, `newState`, `previousState`, `trafficDate`, `trafficToBenefit`, `trafficToTheBurden`, `legalEntityAccount_id`) VALUES ('4', '13456.0', '67656.9', '2009-07-12', '12345.8', '45678.9', '4');
INSERT INTO `bank`.`dailyaccountbalance` (`id`, `newState`, `previousState`, `trafficDate`, `trafficToBenefit`, `trafficToTheBurden`, `legalEntityAccount_id`) VALUES ('5', '145.8', '987.9', '2010-07-12', '678.9', '456.9', '5');


INSERT INTO `bank`.`paymenttype` (`id`, `code`, `nameOfPaymentType`) VALUES ('1', 'CSH', 'cash');
INSERT INTO `bank`.`paymenttype` (`id`, `code`, `nameOfPaymentType`) VALUES ('2', 'MCD', 'mastercard');



--INSERT INTO `bank`.`bankaccount` (`id`, `accountNumber`, `dateOfOpening`, `money`, `valid`, `bank_id`, `client_client_id`, `currency_currency_id`) VALUES ('1', '554123456789555555', '2006-07-12', '1000', b'1', '1', '1', '1');
--INSERT INTO `bank`.`bankaccount` (`id`, `accountNumber`, `dateOfOpening`, `money`, `valid`, `bank_id`, `client_client_id`, `currency_currency_id`) VALUES ('2', '553123456789555552', '2008-07-12', '2000', b'1', '1', '1', '2');
--INSERT INTO `bank`.`bankaccount` (`id`, `accountNumber`, `dateOfOpening`, `money`, `valid`, `bank_id`, `client_client_id`, `currency_currency_id`) VALUES ('3', '555123456789555553', '2010-10-10', '3000', b'1', '1', '3', '3');
--INSERT INTO `bank`.`bankaccount` (`id`, `accountNumber`, `dateOfOpening`, `money`, `valid`, `bank_id`, `client_client_id`, `currency_currency_id`) VALUES ('4', '555123456789555554', '2012-12-12', '4000', b'1', '2', '1', '2');
--INSERT INTO `bank`.`bankaccount` (`id`, `accountNumber`, `dateOfOpening`, `money`, `valid`, `bank_id`, `client_client_id`, `currency_currency_id`) VALUES ('5', '555123456789555555', '2013-04-13', '5000', b'1', '1', '2', '2');


--INSERT INTO `bank`.`analyticsofstatements`(`itemNumber`, `accountCreditor`, `creditor_recipient`, `currencyDate`, `dateOfReceipt`, `debtorAccount`, `debtor_originator`, `emergency`, `modelApproval`, `modelAssigments`, `purposeOfPayment`,
--`referenceNumberAssigments`, `referenceNumberCreditor`, `status`, `sum`, `typeOfMistake`, `dailyAccountBalance_id`, `paymentCurrency_currency_id`, `paymentType_id`, `place_id` )
--VALUES ('1', '4', 'Naovis', '2018-07-10', '2018-07-10', '234-1234-234','Cubric i minimum pet sinova,Inc', b'0', '15', '97', 'Isplata oko aplikacije preduzeca', 
--'987-446-587', '4654-6216', '0', '8000', '1', '1', '1', '1', '1');


--INSERT INTO `bank`.`analyticsofstatements` (`itemNumber`, `accountCreditor`, `creditor_recipient`, `currencyDate`, `dateOfReceipt`, `debtorAccount`, `debtor_originator`, `emergency`, `modelApproval`, `modelAssigments`, `purposeOfPayment`, `referenceNumberAssigments`, `referenceNumberCreditor`, `status`, `sum`, `typeOfMistake`, `dailyAccountBalance_id`, `paymentCurrency_currency_id`) VALUES ('1', '454545454545454', 'stjepan', '2008-07-12', '2008-07-15', '5959595999595', 'mirko', b'1', '1', '1', 'prijava ispita', '5555555', '66666', 'a', '1567.9', '1', '1', '1');
--INSERT INTO `bank`.`analyticsofstatements` (`itemNumber`, `accountCreditor`, `creditor_recipient`, `currencyDate`, `dateOfReceipt`, `debtorAccount`, `debtor_originator`, `emergency`, `modelApproval`, `modelAssigments`, `purposeOfPayment`, `referenceNumberAssigments`, `referenceNumberCreditor`, `status`, `sum`, `typeOfMistake`, `dailyAccountBalance_id`, `paymentCurrency_currency_id`) VALUES ('2', '22222222222', 'misko', '2008-07-12', '2008-07-28', '12121212121121', 'branja', b'0', '1', '1', 'stanarina', '323233232', '3232232323', 'a', '4343', '1', '2', '1');
--INSERT INTO `bank`.`analyticsofstatements` (`itemNumber`, `accountCreditor`, `creditor_recipient`, `currencyDate`, `dateOfReceipt`, `debtorAccount`, `debtor_originator`, `emergency`, `modelApproval`, `modelAssigments`, `purposeOfPayment`, `referenceNumberAssigments`, `referenceNumberCreditor`, `status`, `sum`, `typeOfMistake`, `dailyAccountBalance_id`, `paymentCurrency_currency_id`) VALUES ('3', '445445457888', 'bobaz', '2008-07-17', '2008-07-19', '212124333433', 'roki', b'1', '1', '1', 'plata', '434343', '4343444', 'a', '23232', '1', '3', '1');
--INSERT INTO `bank`.`analyticsofstatements` (`itemNumber`, `accountCreditor`, `creditor_recipient`, `currencyDate`, `dateOfReceipt`, `debtorAccount`, `debtor_originator`, `emergency`, `modelApproval`, `modelAssigments`, `purposeOfPayment`, `referenceNumberAssigments`, `referenceNumberCreditor`, `status`, `sum`, `typeOfMistake`, `dailyAccountBalance_id`, `paymentCurrency_currency_id`) VALUES ('4', '767677666', 'bajko', '2008-07-5', '2008-07-11', '343443434343', 'baka', b'0', '1', '1', 'pozajmica', '7778878', '65665', 'b', '11234', '1', '4', '2');

--INSERT INTO `bank`.`analyticsofstatements`(`itemNumber`, `accountCreditor`, `creditor_recipient`, `currencyDate`, `dateOfReceipt`, `debtorAccount`, `debtor_originator`, `emergency`, `modelApproval`, `modelAssigments`, `purposeOfPayment`,
--`referenceNumberAssigments`, `referenceNumberCreditor`, `status`, `sum`, `typeOfMistake`, `dailyAccountBalance_id`, `paymentCurrency_currency_id`, `paymentType_id`, `place_id` )
--VALUES ('1', '4', 'Naovis', '2018-07-10', '2018-07-10', '234-1234-234','Cubric i minimum pet sinova,Inc', b'0', NULL, '97', 'Isplata oko aplikacije preduzeca', 
--NULL, NULL, NULL, '8000', NULL, NULL, '2', NULL, '1')


UPDATE `bank`.`bankaccount` SET `accountNumber`='552123456789555555', `dateOfOpening`='2008-04-13 00:00:00', `money`='150000', `client_client_id`='4' WHERE `id`='6';
UPDATE `bank`.`bankaccount` SET `accountNumber`='555123456789555555', `dateOfOpening`='2013-04-13 00:00:00', `money`='5000', `client_client_id`='2' WHERE `id`='5';
UPDATE `bank`.`bankaccount` SET `accountNumber`='555123456789555554', `dateOfOpening`='2012-12-12 00:00:00', `money`='0', `bank_id`='2', `client_client_id`='1', `currency_currency_id`='2' WHERE `id`='4';
UPDATE `bank`.`bankaccount` SET `accountNumber`='555123456789555553', `dateOfOpening`='2010-10-10 00:00:00', `money`='3000', `bank_id`='1', `client_client_id`='3', `currency_currency_id`='3' WHERE `id`='3';
UPDATE `bank`.`bankaccount` SET `accountNumber`='555123456789555552', `dateOfOpening`='2008-07-12 00:00:00', `money`='0', `client_client_id`='1', `currency_currency_id`='2' WHERE `id`='2';
UPDATE `bank`.`bankaccount` SET `accountNumber`='554123456789555555', `dateOfOpening`='2006-07-12 00:00:00', `money`='1000', `bank_id`='1', `client_client_id`='1', `currency_currency_id`='1' WHERE `id`='1';

