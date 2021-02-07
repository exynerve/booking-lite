package com.rivigo.service.config;

import java.util.Random;


public class VehicleNumberGenerator {
    private final String SALTNUMBERS = "0123456789";
    private final String SALTCHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String generator(){
        StringBuilder vehicleNumber = new StringBuilder();
        Random random = new Random();
        int index;
        while(vehicleNumber.length()<2){
            index = random.nextInt(Integer.SIZE-1) % SALTCHARACTERS.length();
            vehicleNumber.append(SALTCHARACTERS.charAt(index));
        }
        vehicleNumber.append(' ');
        while(vehicleNumber.length()<5){
            index = random.nextInt(Integer.SIZE-1) % SALTNUMBERS.length();
            vehicleNumber.append(SALTNUMBERS.charAt(index));
        }
        vehicleNumber.append(' ');
        while(vehicleNumber.length()<8){
            index = random.nextInt(Integer.SIZE-1) % SALTCHARACTERS.length();
            vehicleNumber.append(SALTCHARACTERS.charAt(index));
        }
        vehicleNumber.append(' ');
        while(vehicleNumber.length()<13){
            index = random.nextInt(Integer.SIZE-1) % SALTNUMBERS.length();
            vehicleNumber.append(SALTNUMBERS.charAt(index));
        }

        return vehicleNumber.toString();
    }
}
