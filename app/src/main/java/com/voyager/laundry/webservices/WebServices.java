package com.voyager.laundry.webservices;

import android.support.annotation.Nullable;


import com.voyager.laundry.registerpage.model.UserDetails;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface WebServices {
    //@GET("driver/getDriver/")
   // Call<MainClass> doGetUserList(@Query("page") String page);
    //http://10.1.1.18/sayara/user/booking/--pickup_loc: 9.731235,76.355463 -- user_id 89



    @FormUrlEncoded
    @POST("register/")
    public Call<UserDetails> registerUser(@Nullable @Field("name") String name,
                                          @Nullable @Field("password") String password,
                                          @Nullable @Field("email") String email,
                                          @Nullable @Field("phone") String phone,
                                          @Nullable @Field("country") String country,
                                          @Nullable @Field("city") String city);
    @FormUrlEncoded
    @POST("login/")
    public Call<UserDetails> loginUser(@Nullable @Field("email") String email,
                                       @Nullable @Field("password") String passwd,
                                       @Nullable @Field("token") String fireBaseToken);

    @FormUrlEncoded
    @POST("updateProfile/")
    Call<UserDetails> updateProfile(@Nullable @Field("name") String name,
                                    @Nullable @Field("userID") int id,
                                    @Nullable @Field("password") String password,
                                    @Nullable @Field("phone") String phone,
                                    @Nullable @Field("country") String country,
                                    @Nullable @Field("city") String city);
    @FormUrlEncoded
    @POST("updateProfile/")
    Call<UserDetails> updateProfilePass(@Nullable @Field("password") String name,
                                        @Nullable @Field("user_id") int id);
    @FormUrlEncoded
    @POST("updateProfile/")
    Call<UserDetails> updateProfileName(@Nullable @Field("name") String name,
                                        @Nullable @Field("user_id") int id,
                                        @Nullable @Field("password") String password,
                                        @Nullable @Field("city") String city);
    @FormUrlEncoded
    @POST("updateProfile/")
    Call<UserDetails> updateProfilePhno(@Nullable @Field("phone") String name,
                                        @Nullable @Field("user_id") int id);
    @FormUrlEncoded
    @POST("updateProfile/")
    Call<UserDetails> updateProfileCity(@Nullable @Field("city") String name,
                                        @Nullable @Field("user_id") int id);



}
