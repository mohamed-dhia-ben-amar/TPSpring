package com.example.esprit.tpspring.Services;

import com.example.esprit.tpspring.Entities.Stock;

import java.util.List;

public interface IStockService {
    List<Stock> retrieveAllStocks();
    Stock addStock(Stock s);
    Stock updateStock(Stock u);
    Stock retrieveStock(Long id);
    String retrieveStatusStock();
}
