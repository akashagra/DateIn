package com.example.avma1997.datein;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    CallbackManager callbackManager;
    String id,firstName,lastName,gender,fullname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        callbackManager = CallbackManager.Factory.create();
        LoginButton loginButton = (LoginButton)findViewById(R.id.facebook_login_button);
        loginButton.setReadPermissions(Arrays.asList("user_location","user_likes","user_photos","user_about_me"));

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {


            @Override
            public void onSuccess(LoginResult loginResult) {
                setFacebookData(loginResult);



            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

    }
    private void setFacebookData(LoginResult loginResult) {


        GraphRequest request = GraphRequest.newMeRequest(
                loginResult.getAccessToken(),
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {



                        // Application code
                        try {
                            Log.i("Response",response.toString());

                            id = response.getJSONObject().getString("id");
                            firstName = response.getJSONObject().getString("first_name");

                            lastName = response.getJSONObject().getString("last_name");
                            gender = response.getJSONObject().getString("gender");
                            Toast.makeText(getApplicationContext(),"Hello "+ firstName+" " + lastName,Toast.LENGTH_SHORT).show();
                            fullname=  firstName+" "+lastName;



                            Log.i("Login" + "ID", id);
                            Log.i("Login"+ "FirstName", firstName);
                            Log.i("Login" + "LastName", lastName);
                            Log.i("Login" + "Gender", gender);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
               });

        Bundle parameters = new Bundle();
//        parameters.putString("fields", "id,first_name,last_name,gender");
        request.setParameters(parameters);
        request.executeAsync();



    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


            callbackManager.onActivityResult(requestCode, resultCode, data);
        Intent i=new Intent(getApplicationContext(),MatchActivity.class);
        startActivity(i);





    }
}
