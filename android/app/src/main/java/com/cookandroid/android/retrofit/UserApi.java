package com.cookandroid.android.retrofit;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

public interface UserApi {
    @POST("signin")
    Call<Boolean> postUser(@Body User user);

//    1
//    @Multipart
//    @POST("insertProcess.do")
//    Call<Boolean> createUser(@PartMap HashMap<String, RequestBody> data);

    @POST("membership")
    Call<Boolean> createUser(@Body User user);
//
//    @Multipart
//    @POST("insertProcess.do")
//    Call<Boolean> createUser(@PartMap HashMap<String, RequestBody> fields);

    @POST("chkUserAndroid")
    Call<Boolean> chkUser(@Body User user);
}
