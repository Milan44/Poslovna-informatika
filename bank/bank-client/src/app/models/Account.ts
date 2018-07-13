import { Client } from './Client';
import { Bank } from './Bank';
import { Currency } from './Currency';

export class Account{

    public id: string;
    public accountNumber: string;
    public valid: boolean;
    public money: number;
    public client: Client;
    public bank: Bank;
    public currency: Currency;

    constructor(){}
}