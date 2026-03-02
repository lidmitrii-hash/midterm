package org.example.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentRequest {
    private String firstName;
    private String lastName;
    private String email;
    private ProfileData profile;

    @Data
    public static class ProfileData {
        private String address;
        private String phone;
        private LocalDate birthDate;
    }
}
