package com.example.demo.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.enitities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private List<AddressDto> addresses;
    private ProfileDto profile;
    private List<ProductDto> wishlist;

    public static UserDto fromWithDetails(User user) {
        if (user == null)
            return null;
        List<AddressDto> addresses = user.getAddresses() == null
                ? List.of()
                : user.getAddresses().stream()
                        .map(AddressDto::from)
                        .filter(dto -> dto != null)
                        .collect(Collectors.toList());
        List<ProductDto> wishlist = user.getWishlist() == null
                ? List.of()
                : user.getWishlist().stream()
                        .map(ProductDto::from)
                        .filter(dto -> dto != null)
                        .collect(Collectors.toList());
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                addresses,
                ProfileDto.from(user.getProfile()),
                wishlist);
    }
}
