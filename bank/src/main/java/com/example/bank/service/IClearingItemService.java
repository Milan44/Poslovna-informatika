package com.example.bank.service;

import com.example.bank.model.Clearing;
import com.example.bank.model.ClearingItem;

public interface IClearingItemService {

	boolean save(ClearingItem ci);
}
