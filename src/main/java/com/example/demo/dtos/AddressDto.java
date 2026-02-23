package com.example.demo.dtos;

import com.example.demo.enitities.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private Long id;
    private String street;
    private String city;

    public static AddressDto from(Address address) {
        if (address == null) return null;
        return new AddressDto(address.getId(), address.getStreet(), address.getCity());
    }
}
