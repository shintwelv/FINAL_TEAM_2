package com.cookandroid.android;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cookandroid.android.retrofit.User;
import com.cookandroid.android.retrofit.UserApi;
import com.squareup.moshi.Moshi;

import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class SignUpActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();

    RadioGroup btn_group;
    RadioButton r_btn1, r_btn2;
    Button btnCancel, btnSignUp;
    EditText idInput, pwInput, nameInput, nickNameInput, birthdayInput, emailInput, phonNumberInput, addressInput1, addressInput2;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        r_btn1 = (RadioButton) findViewById(R.id.r_btn1);
        r_btn2 = (RadioButton) findViewById(R.id.r_btn2);
        idInput = (EditText) findViewById(R.id.idInput);
        pwInput = (EditText) findViewById(R.id.pwInput);
        nameInput = (EditText) findViewById(R.id.nameInput);
        btn_group = (RadioGroup) findViewById(R.id.btn_group);
        nickNameInput = (EditText) findViewById(R.id.nickNameInput);
        birthdayInput = (EditText) findViewById(R.id.birthdayInput);
        emailInput = (EditText) findViewById(R.id.emailInput);
        phonNumberInput = (EditText) findViewById(R.id.birthdayInput);
        addressInput1 = (EditText) findViewById(R.id.addressInput1);
        addressInput2 = (EditText) findViewById(R.id.addressInput2);

        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);

        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        btn_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.r_btn1) {
                    gender = r_btn1.getText().toString();

                } else if (i == R.id.r_btn2) {
                    gender = r_btn2.getText().toString();

                }
            }
        });


        btnSignUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String id = idInput.getText().toString();
                String pw = pwInput.getText().toString();
                String name = nameInput.getText().toString();
                String nickName = nickNameInput.getText().toString();
                String email = emailInput.getText().toString();
                String phonNumber = phonNumberInput.getText().toString();
                String address1 = addressInput1.getText().toString();
                String address2 = addressInput2.getText().toString();

                User signUpInfo = new User();
                signUpInfo.setUserId(id);
                signUpInfo.setUserPw(pw);
                signUpInfo.setUserName(name);
                signUpInfo.setNickName(nickName);
                signUpInfo.setGender(gender);
                signUpInfo.setEmail(email);
                signUpInfo.setPhoneNumber(phonNumber);
                signUpInfo.setUserBasicAddress(address1);
                signUpInfo.setUserDetailAddress(address2);


                Moshi moshi = new Moshi.Builder().build();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.0.8:9000/user/")
                        .addConverterFactory(MoshiConverterFactory.create(moshi))
                        .build();

                UserApi api = retrofit.create(UserApi.class);

//                Call<Boolean> call = api.chkUser(signUpInfo);
                Call<Boolean> call = api.createUser(signUpInfo);
                call.enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        boolean signUpSuccess = response.body();

                        if (signUpSuccess) {
                            Intent intent = new Intent(getApplicationContext(), SignUpSuccess.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), "회원가입에 실패하였습니다", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        Log.d(TAG, "Fail msg : " + t.getMessage());
                        Toast.makeText(getApplicationContext(), "회원가입에 실패하였습니다", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}