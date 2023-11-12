package com.cg.model.dto;

import com.cg.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.Valid;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerCreReqDTO implements Validator{
    private String fullName;
    private String email;
    private String phone;
    @Valid
    private  LocationRegionCreReqDTO locationRegionCreReqDTO;

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        CustomerCreReqDTO customerCreReqDTO = (CustomerCreReqDTO) o;
        String fullName = customerCreReqDTO.fullName;
        String address = customerCreReqDTO.email;

        if(fullName.length() < 3){
            errors.rejectValue("fullName", "fullName.length", "Tên phải có ít nhất là 3 ký tự");
            return;
        }
                if (!address.contains("@")||!address.contains(".com")) {
            errors.rejectValue("address", "address.contains", "Địa chỉ email không hợp lệ");
        }
    }
    public Customer toCustomer(){
        return new Customer().setFullName(fullName)
                .setEmail(email)
                .setPhone(phone)
                .setLocationRegion(locationRegionCreReqDTO.toLocationRegion());
    }
}
