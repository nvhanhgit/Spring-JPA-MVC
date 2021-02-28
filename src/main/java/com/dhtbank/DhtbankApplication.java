package com.dhtbank;

import com.dhtbank.model.Customer;
import com.dhtbank.service.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DhtbankApplication {

    public static void main(String[] args) {
        SpringApplication.run(DhtbankApplication.class, args);
//        ggtgApplicationContext applicationContext = SpringApplication.run(DhtbankApplication.class, args);
//        CustomerService customerService = applicationContext.getBean(CustomerService.class);
//        Customer customer = new Customer();
//        customer.setMa("KH3");
//        customer.setCmt("0123456789");
//        customer.setDiaChi("Ha Noi");
//        customer.setTen("Nguyen Van C");
//        customer.setNgaySinh("12/09/1998");
//        customerService.saveCustomer(customer);

    }

}
