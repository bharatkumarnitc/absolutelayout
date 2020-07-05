package com.example.absolutelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.absolutelayout.validation.emailValidation;
import static com.example.absolutelayout.validation.getRandomNumberString;
import static com.example.absolutelayout.validation.mobileValidation;

public class MainActivity extends AppCompatActivity {
    EditText Fname, Lname, Email, Mobile,otpet,etoldpass,etnewpass,etrepass;
    Button emailverifybtn,otpsendbtn,otpverifybtn,btnsavepass;
    TextView emailstatus, mobilestatus,otpmessagetv,tvpassmsg,tvoldpass,tvnewpass,tvrepass,tvforetpass,tvchngpass;
    String FirstName, LastName, stremail,mnumber,otp,old,newpass,repass;
    ImageView imgemail, imagemobile;
    String pass="bharat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fname = (EditText) findViewById(R.id.fname);
        Lname = (EditText) findViewById(R.id.lname);
        Email = (EditText) findViewById(R.id.email);
        Mobile = (EditText) findViewById(R.id.mobile);

        etoldpass=(EditText)findViewById(R.id.etoldpass);
        etnewpass=(EditText)findViewById(R.id.etnewpass);
        etrepass=(EditText)findViewById(R.id.etrepasss);

        otpet=(EditText)findViewById(R.id.otpet);

        imgemail = (ImageView) findViewById(R.id.imagestatusemail);
        imagemobile = (ImageView) findViewById(R.id.imagestatusmobile);


        emailstatus = (TextView) findViewById(R.id.txtviewstatusemail);
        mobilestatus = (TextView) findViewById(R.id.txtviewstatusmobile);

        tvpassmsg=(TextView)findViewById(R.id.passmgs);
        tvoldpass=(TextView)findViewById(R.id.passoldmsg);
        tvnewpass=(TextView)findViewById(R.id.passnewmsg);
        tvrepass=(TextView)findViewById(R.id.passremsg);
        tvforetpass=(TextView)findViewById(R.id.forgetpass);
        tvchngpass=(TextView)findViewById(R.id.changepass);

        otpmessagetv=(TextView)findViewById(R.id.otpmessage);


        emailverifybtn = (Button) findViewById(R.id.emailbtnsend);
        btnsavepass=(Button)findViewById(R.id.passsubmitbtn);
        otpsendbtn=(Button)findViewById(R.id.otpsendbt);
        otpverifybtn=(Button)findViewById(R.id.otpverify);

        emailstatus.setText("PENDING");
        emailstatus.setTextColor(getResources().getColor(R.color.itmcolor));
        imgemail.setImageResource(R.drawable.time);

        mobilestatus.setText("PENDING");
        mobilestatus.setTextColor(getResources().getColor(R.color.itmcolor));
        imagemobile.setImageResource(R.drawable.time);


        emailverifybtn.setVisibility(View.GONE);

        otpsendbtn.setVisibility(View.GONE);
        otpverifybtn.setVisibility(View.GONE);
        otpet.setVisibility(View.GONE);
        otpmessagetv.setVisibility(View.GONE);

        etoldpass.setVisibility(View.GONE);
        etnewpass.setVisibility(View.GONE);
        etrepass.setVisibility(View.GONE);

        tvpassmsg.setVisibility(View.GONE);
        tvoldpass.setVisibility(View.GONE);
        tvnewpass.setVisibility(View.GONE);
        tvrepass.setVisibility(View.GONE);
        tvforetpass.setVisibility(View.GONE);
        tvchngpass.setVisibility(View.GONE);


        btnsavepass.setVisibility(View.GONE);

        validation();
    }

    public void validation() {

        btnsavepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                old=etoldpass.getText().toString();
                newpass=etnewpass.getText().toString();
                repass=etrepass.getText().toString();

                if(old.isEmpty())
                {
                    etoldpass.setError("Please Enter the password");
                }
                else if(newpass.isEmpty())
                {
                    etnewpass.setError("Please Enter the password");
                }
                else if(repass.isEmpty())
                {
                    etrepass.setError("Please Enter the password");
                }
                else if(newpass.length()<8)
                {
                    etnewpass.setError("Password Contains at least 8 digit");

                }
                else if(repass.length()<8)
                {
                    etrepass.setError("Password Contains at least 8 digit");
                }
                else if(!old.contains(pass))
                {
                    etoldpass.setError("Enter the Same Password");

                }
                else if(old.contains(newpass))
                {
                    etnewpass.setError("Use different password");
                }
               else if(!newpass.contains(repass))
                {
                    etrepass.setError("EnterSame Password");
                }
                else
                {
                    pass=newpass;
                    etoldpass.setVisibility(View.GONE);
                    etnewpass.setVisibility(View.GONE);
                    etrepass.setVisibility(View.GONE);

                    tvpassmsg.setVisibility(View.GONE);
                    tvoldpass.setVisibility(View.GONE);
                    tvnewpass.setVisibility(View.GONE);
                    tvrepass.setVisibility(View.GONE);
                    tvforetpass.setVisibility(View.GONE);


                    btnsavepass.setVisibility(View.GONE);
                    tvchngpass.setVisibility(View.VISIBLE);
                }



            }
        });

        Fname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                FirstName = charSequence.toString();
                if (FirstName.isEmpty()) {
                    Fname.setError("Please Enter the First Name");

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        Lname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

                LastName = Lname.getText().toString();
                if (LastName.isEmpty()) {
                    Lname.setError("Please Enter the Last Name");
                }
            }
        });

        Email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                tvchngpass.setVisibility(View.VISIBLE);

                stremail = charSequence.toString();

                if (stremail.isEmpty()) {

                    emailverifybtn.setVisibility(View.GONE);
                    Email.setError("Please Enter Email");
                } else if (!emailValidation(stremail)) {
                    emailverifybtn.setVisibility(View.GONE);
                    Email.setError("Please Enter your valid Email!");

                } else {
                    emailverifybtn.setVisibility(View.VISIBLE);

                    emailverification();


                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        tvchngpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvpassmsg.setVisibility(View.VISIBLE);
                etoldpass.setVisibility(View.VISIBLE);
                etnewpass.setVisibility(View.VISIBLE);
                etrepass.setVisibility(View.VISIBLE);

                tvoldpass.setVisibility(View.VISIBLE);
                tvnewpass.setVisibility(View.VISIBLE);
                tvrepass.setVisibility(View.VISIBLE);

                tvchngpass.setVisibility(View.GONE);
                btnsavepass.setVisibility(View.VISIBLE);
                tvforetpass.setVisibility(View.VISIBLE);


            }
        });


        Mobile.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                mnumber=charSequence.toString();
                if(mnumber.isEmpty())
                {
                    otpsendbtn.setVisibility(View.GONE);
                    Mobile.setError("Please Enter the Mobile Number");
                }

                else if(!mobileValidation(mnumber))
                {
                    otpsendbtn.setVisibility(View.GONE);
                    Mobile.setError("Please Enter the Valid Mobile Number");
                }
                else
                {
                    if(mnumber.length()==10)
                    {
                        mobileverification();
                    }
                    else
                    { otpsendbtn.setVisibility(View.GONE);
                        Mobile.setError("Please Enter the Valid Mobile Number");

                    }




                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }

    public void emailverification() {
        emailverifybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailstatus.setText("VERIFIED");
                emailstatus.setTextColor(getResources().getColor(R.color.itm2));
                imgemail.setImageResource(R.drawable.clickright);
                emailverifybtn.setVisibility(View.GONE);
                Email.setEnabled(false);


            }
        });

    }


    public void mobileverification()
    {
        otpsendbtn.setVisibility(View.VISIBLE);

        otpsendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mobile.setEnabled(false);
                otpsendbtn.setVisibility(View.GONE);

                otpverifybtn.setVisibility(View.VISIBLE);
                otpet.setVisibility(View.VISIBLE);
                otpmessagetv.setVisibility(View.VISIBLE);

                otp=getRandomNumberString();
                Toast.makeText(getApplicationContext(),otp,Toast.LENGTH_LONG).show();

                otpverifybtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        if(otpet.getText().toString().isEmpty())
                        {
                            otpet.setError("Please Enter the Valid");
                        }
                        else if(!otpet.getText().toString().contains(otp))
                        {
                            otpet.setError("Enter the Correct Otp");
                        }
                        else
                        {
                            otpverifybtn.setVisibility(View.GONE);
                            otpet.setVisibility(View.GONE);
                            otpmessagetv.setVisibility(View.GONE);
                            Toast.makeText(getApplicationContext(),"otp Verify",Toast.LENGTH_LONG).show();
                            mobilestatus.setText("VERIFIED");
                            mobilestatus.setTextColor(getResources().getColor(R.color.itm2));
                            imagemobile.setImageResource(R.drawable.clickright);

                        }
                    }
                });




            }
        });


    }

}