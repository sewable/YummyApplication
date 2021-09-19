package com.yummy.blog.user.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserForm {

    @NotNull(message = "Username is required")
    @NotEmpty(message = "Username cannot be empty")
    private String username;

    @NotNull(message = "Password is required")
    @NotEmpty(message = "Password cannot be empty")
    @Pattern(regexp = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$",
            message = "Password must contain: at least 1 uppercase letter, at least 1 lowercase letter, at least 1 number or 1 special character")
    @Size(min = 8, max = 16, message = "Password must be between 8 and 16 characters")
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
