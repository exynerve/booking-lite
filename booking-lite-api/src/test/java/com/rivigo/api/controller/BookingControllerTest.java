/*
package com.rivigo.api.controller;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void bookingWithValidCityAndDate() throws Exception{
        JSONObject request = new JSONObject();
        request.put("sourceCity","Mumbai");
        request.put("destinationCity","Delhi");
        request.put("dateOfPickUp","2021-02-10");

        mockMvc.perform(MockMvcRequestBuilders.post("/booking-api/booking")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(String.valueOf(request))
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isCreated());
    }

    @Test
    public void bookingWithNoVehicle() throws Exception{
        JSONObject request = new JSONObject();
        request.put("sourceCity","Test-1");
        request.put("destinationCity","Test-2");
        request.put("dateOfPickUp","2021-02-10");

        mockMvc.perform(MockMvcRequestBuilders.post("/booking-api/booking")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(String.valueOf(request))
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    public void bookingWithInvalidCity() throws Exception{
        JSONObject request = new JSONObject();
        request.put("sourceCity","Hyderabad");
        request.put("destinationCity","Dehradun");
        request.put("dateOfPickUp","2021-02-10");

        mockMvc.perform(MockMvcRequestBuilders.post("/booking-api/booking")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(String.valueOf(request))
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    public void bookingWithInvalidDate() throws Exception{

        JSONObject request = new JSONObject();
        request.put("sourceCity","Delhi");
        request.put("destinationCity","Bangalore");
        request.put("dateOfPickUp","2019-02-10");

        mockMvc.perform(MockMvcRequestBuilders.post("/booking-api/booking")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(String.valueOf(request))
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isNotAcceptable());
    }

    @Test
    public void bookingWithInvalidDateFormat() throws Exception{
        JSONObject request = new JSONObject();
        request.put("sourceCity","Delhi");
        request.put("destinationCity","Bangalore");
        request.put("dateOfPickUp","Hello-world");

        mockMvc.perform(MockMvcRequestBuilders.post("/booking-api/booking")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(String.valueOf(request))
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isNotAcceptable());
    }


}
*/
