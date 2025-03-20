package org.example.relations.Controller;

import org.example.relations.Dto.DtoCustomer;
import org.example.relations.Dto.DtoCustomerIU;
import org.example.relations.Service.CustomerServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rest/api/customer")
public class CustomerControllerimpl implements İcustomerController{

    @Autowired
    private CustomerServiceimpl customerServiceimpl;

    @GetMapping(path = "/list/{id}")
    @Override
    public DtoCustomer getCustomerbyid(@PathVariable(name = "id") Long id) {
        return customerServiceimpl.getCustomerbyid(id);
    }

    @PostMapping(path = "/save")
    @Override
    public DtoCustomer saveCustomer(@RequestBody DtoCustomerIU customer) {
        return customerServiceimpl.saveCustomer(customer);
    }

    @GetMapping(path = "/list")
    @Override
    public List<DtoCustomer> getallcustomerbyid() {
        return customerServiceimpl.getallcustomerbyid();
    }

    @PutMapping("/update/{id}")
    @Override
    public DtoCustomer updateCustomer(@PathVariable(name = "id") Long id,@RequestBody DtoCustomerIU customerIU) {
        return customerServiceimpl.updateCustomer(id, customerIU);
    }


}
