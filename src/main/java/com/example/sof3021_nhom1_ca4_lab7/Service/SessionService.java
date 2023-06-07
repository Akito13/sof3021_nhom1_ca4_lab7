package com.example.sof3021_nhom1_ca4_lab7.Service;

public interface SessionService {
    public Object get(String key); //Get theo key trả về type
    public void set(String key, Object value); //set key là string, type tùy ý
}
