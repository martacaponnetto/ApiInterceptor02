package com.example.Api_Interceptor.Middleware2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Month {
    private int monthNumber;
    private String englishName;
    private String italianName;
    private String germanName;
}
