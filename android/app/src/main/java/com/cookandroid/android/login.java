package com.cookandroid.android;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.kakao.auth.AuthType;
import com.kakao.auth.Session;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;

import com.cookandroid.android.retrofit.User;
import com.cookandroid.android.retrofit.UserApi;
//import com.kakao.sdk.user.UserApiClient;
import com.nhn.android.naverlogin.OAuthLogin;
import com.nhn.android.naverlogin.OAuthLoginHandler;
import com.squareup.moshi.Moshi;

import java.security.MessageDigest;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class login extends AppCompatActivity {

//    private View loginButton, logoutButton;
//    private TextView nickName;
//    private ImageView profileImage;

    private final String TAG = getClass().getSimpleName();

    Button btnSignIn, btnGoSignUp;
    EditText signInId, signInPw;
    private ImageView close;
    private Button btn_custom_login;
    Button naver_login;

    OAuthLogin mOAuthLoginModule;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mContext = getApplicationContext();

        naver_login = findViewById(R.id.naver_login);


        close = (ImageView) findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        signInId = (EditText) findViewById(R.id.signInId);
        signInPw = (EditText) findViewById(R.id.signInPw);


        btnGoSignUp = (Button) findViewById(R.id.btnGoSignUp);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);

        btnGoSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });

        btn_custom_login = (Button) findViewById(R.id.btn_custom_login);
        btn_custom_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Session session = Session.getCurrentSession();
                session.addCallback(new SessionCallback());
                session.open(AuthType.KAKAO_LOGIN_ALL, login.this);
            }
        });

        naver_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOAuthLoginModule = OAuthLogin.getInstance();
                mOAuthLoginModule.init(
                        mContext
                        ,getString(R.string.naver_client_id)
                        ,getString(R.string.naver_client_secret)
                        ,getString(R.string.naver_client_name)
                );

                @SuppressLint("HandlerLeak")
                OAuthLoginHandler mOAuthLoginHandler = new OAuthLoginHandler() {
                    @Override
                    public void run(boolean success) {
                        if (success) {
                            String accessToken = mOAuthLoginModule.getAccessToken(mContext);
                            String refreshToken = mOAuthLoginModule.getRefreshToken(mContext);
                            long expiresAt = mOAuthLoginModule.getExpiresAt(mContext);
                            String tokenType = mOAuthLoginModule.getTokenType(mContext);

                            Log.i("LoginData","accessToken : "+ accessToken);
                            Log.i("LoginData","refreshToken : "+ refreshToken);
                            Log.i("LoginData","expiresAt : "+ expiresAt);
                            Log.i("LoginData","tokenType : "+ tokenType);

                        } else {
                            String errorCode = mOAuthLoginModule
                                    .getLastErrorCode(mContext).getCode();
                            String errorDesc = mOAuthLoginModule.getLastErrorDesc(mContext);
                            Toast.makeText(mContext, "errorCode:" + errorCode
                                    + ", errorDesc:" + errorDesc, Toast.LENGTH_SHORT).show();
                        }
                    };
                };

                mOAuthLoginModule.startOauthLoginActivity(login.this, mOAuthLoginHandler);
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = signInId.getText().toString();
                String pw = signInPw.getText().toString();

                User loginInfo = new User();
                loginInfo.setUserId(id);
                loginInfo.setUserPw(pw);

                Moshi moshi = new Moshi.Builder().build();

                String json = moshi.adapter(User.class).indent("  ").toJson(loginInfo);
                System.out.println(json);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.0.8:9000/user/")
                        .addConverterFactory(MoshiConverterFactory.create(moshi))
                        .build();


                UserApi api = retrofit.create(UserApi.class);

                Call<Boolean> call = api.chkUser(loginInfo);
                call.enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        if (response.isSuccessful()) {
                            boolean userExists = response.body();
                            if (userExists) {
                                Intent intent = new Intent(getApplicationContext(), LoginSuccess.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), "아이디 혹은 비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Log.d(TAG, "Status Code : " + response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        Log.d(TAG, "Fail msg : " + t.getMessage());
                        Toast.makeText(getApplicationContext(), "서버 연결에 실패했습니다", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

}