package model.dto;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record StudentResponDto(
        Long id,
        String fullName,
        String gender,
        LocalDate datOfBirth
) {


}
