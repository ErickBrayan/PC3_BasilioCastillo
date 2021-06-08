package com.example.pc3_moviles.api;

import com.example.pc3_moviles.entity.Sala;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ServiceSalaApi {
    @POST ("sala")
    public abstract Call<Sala> insertaSala(@Body  Sala sala);

    @GET("sala")
    public abstract Call<List<Sala>> lisataSala();
}
