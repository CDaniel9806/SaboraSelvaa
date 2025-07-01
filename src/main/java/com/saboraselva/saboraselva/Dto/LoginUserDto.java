package com.saboraselva.saboraselva.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class LoginUserDto {
    
    public String username;
    public String password;
}
