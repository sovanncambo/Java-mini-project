package model.dto;

import java.time.LocalDate;

public record StudentRequesDto(
        String fullName,
        String gender,
        LocalDate dateOfBirth
) {

}
