package com.example.esprit.tpspring.Controllers;

import com.example.esprit.tpspring.Entities.Stock;
import com.example.esprit.tpspring.Services.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stock")
public class StockRestController {


    @Autowired
    IStockService iStockService;

    @GetMapping("/getAll")
    public List<Stock> retrieveAllStocks()
    {
        return iStockService.retrieveAllStocks();
    }

    @PostMapping("/add") //http://localhost:8080/etudiant/add
    public Stock addStock (@RequestBody Stock c)
    {
        return  iStockService.addStock(c);
    }

    @PostMapping("/update")
    public Stock updateStock(@RequestBody Stock c)
    {
        return  iStockService.updateStock(c);
    }

    @GetMapping("/getOne/{idC}")
    public Stock retrieveStock(@PathVariable(value = "idC") long idStock)
    {
        return iStockService.retrieveStock(idStock);
    }

}
