package com.example.demo.dtos;

import com.example.demo.enitities.Profile;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDto {
    private Long id;
    private String bio;
    private int loyaltyPoints;

    public static ProfileDto from(Profile profile) {
        if (profile == null) return null;
        return new ProfileDto(profile.getId(), profile.getBio(), profile.getLoyaltyPoints());
    }
}
