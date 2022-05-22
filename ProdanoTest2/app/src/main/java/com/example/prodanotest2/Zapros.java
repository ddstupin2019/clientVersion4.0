package com.example.prodanotest2;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface Zapros {
    @GET("getStavka")
    Call<ArrayList<Integer>> getStavka(@Query("id") int id);

    @GET("getNedCol")
    Call<ArrayList<Integer>> getNedCol(@Query("id") int id);

    @GET("getMoneyCol")
    Call<ArrayList<Integer>> getMoneyCol(@Query("id") int id);

    @DELETE("deleteIgra")
    Call<ArrayList<Integer>> deleteIgra(@Query("id") int id);

    @GET("getStatus")
    Call<Boolean> getStatus(@Query("id") int id);

    @GET("getMonColDlylud")
    Call<ArrayList<Integer>> getMonColDlylud(@Query("id") int id);

    @GET("getNumPlayer")
    Call<Integer> getNumPlayer(@Query("id") int id);

    @GET("getPlayerShod")
    Call<ArrayList<Integer>> getPlayerShod(@Query("id") int id);

    @GET("setNedColPlayer")
    Call<Integer> setNedColPlayer(@Body String param);

    @PUT("createPlayer")
    Call<ArrayList<Integer>> addPlayer(@Body String param);

    @PUT("setStavka")
    Call<Integer> setStavka(@Body String param);

    @PUT("setMonColDlylud")
    Call<Integer> setMonColDlylud(@Body String param);

    @PUT("setBalance")
    Call<Integer> setBalance(@Body String param);





}
