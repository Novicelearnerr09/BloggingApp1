package com.sayaliblog.blogappapis.payloads;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private  Integer id;

    @NotEmpty
    @Size(min=4, message = "Username must be min of 4 characters !!" )
        private  String name;

    @Email(message = "Email address is not valid !!")
    private  String email;

    @NotEmpty
    @Size(min=3, max=10, message="Password must be min of 3 chars and max of 10 char!!")
   // @Pattern(regexp = "^(?=.*[0-9])(=.*[a-z])(=.*[A-Z])(?=.*[@$]).{3,10}$", message="Password must be btw 3 -10char, atleast one upper, lower, number, special character")
    @Pattern(regexp = "^[0-9]{10}$", message="password should be in number , with 10 digit")
    private  String password;
    @NotNull
    private  String about;
}
