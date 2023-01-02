package com.wismo.demo;

import com.wismo.demo.entity.Customer;
import com.wismo.demo.entity.Item;
import com.wismo.demo.entity.Sale;
import com.wismo.demo.repository.CustomerRepository;
import com.wismo.demo.repository.ItemRepository;
import com.wismo.demo.repository.SaleRepository;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiApplicationTests {
    
    @Autowired
    private SaleRepository saleRepo;
    
    @Autowired
    private ItemRepository itemRepo;
    
    @Autowired 
    private CustomerRepository customerRepo;
    

	@Test
	void contextLoads() {
            saleRepo.deleteAll();
            customerRepo.deleteAll();
            itemRepo.deleteAll();
            
            Optional<Customer> oCustomer;
            List<Customer> customers = new ArrayList<>();
            List<Item> items = new ArrayList<>();
            Sale sales = new Sale();
            
            List<Customer> customerSaved = new ArrayList<>();
            List<Item> itemsSaved = new ArrayList<>();
            Sale saleSaved = new Sale();
            
            Item item1 = new Item();
            Item item2 = new Item();
            Item item3 = new Item();
            
            customers.add(Customer.builder().name("Cliente1").email("cliente1@gmail.com").phone("650938473").active(Boolean.TRUE).build());
            items.add(Item.builder().name("Item1").price(10.10F).active(Boolean.TRUE).build());
            items.add(Item.builder().name("Item2").price(20.20F).active(Boolean.TRUE).build());
            items.add(Item.builder().name("Item3").price(30.30F).active(Boolean.TRUE).build());
//            sale1 = Sale.builder().total_sale(Float.MAX_VALUE)

            
            System.out.println("1- Grabando los objetos");
            System.out.println("==============================");
            customerRepo.saveAll(customers);
            itemRepo.saveAll(items);
            
            System.out.println("Leyendo los objetos grabados");
            System.out.println("==============================");
            System.out.println(customerRepo.findAll().toString());
            System.out.println(itemRepo.findAll().toString());
            
            
            System.out.println("Crear el objeto items");
            System.out.println("==============================");
            itemsSaved = itemRepo.findAll();
            float total_venta = 0;
            
            for (int i = 0; i < itemsSaved.size(); i++) {
                total_venta += itemsSaved.get(i).getPrice();
            }
            
            
            System.out.println(total_venta);
            
            System.out.println("Crear objeto de Ventas");
            customerSaved = customerRepo.findAll();
            System.out.println("Cliente: " + customerSaved.get(0));
            
            sales = (Sale.builder()
                    .total_sale(total_venta)
                    .sale_date(Date.valueOf(LocalDate.now()))
                    .customer(customerSaved.get(0))
                    .items(itemsSaved)
                    .build());
            
            System.out.println("Venta creada  "+ sales);
            
            saleRepo.save(sales);
//            
            System.out.println("Leyendo el objeto de ventas grabado");
            List<Sale> saleAux = saleRepo.findAll();
            saleAux.get(0).getItems().size();
            System.out.println(saleAux.get(0).getItems().toString());
            
	}

}
