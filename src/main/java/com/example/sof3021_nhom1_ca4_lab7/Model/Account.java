package com.example.sof3021_nhom1_ca4_lab7.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String username;
    private String password;
    private boolean admin;
}
