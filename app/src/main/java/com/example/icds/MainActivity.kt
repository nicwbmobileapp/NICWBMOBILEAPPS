package com.example.icds

/*class MainActivity : ComponentActivity() {
override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_main)
      enableEdgeToEdge()
      setContent {
          ICDSTheme {
              Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                  Greeting(
                      name = "Android",
                      modifier = Modifier.padding(innerPadding)
                  )
              }
          }
      }
  }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Text(
      text = "Hello $name!",
      modifier = modifier
  )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  ICDSTheme {
      Greeting("Android")
  }*/



import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject;


class MainActivity : AppCompatActivity() {

        // on below line we are creating
        // variable for email and password edit text.
        lateinit var emailEdt: EditText
        lateinit var pwdEdt: EditText

        // on below line we are creating
        // a variable for our button.
        lateinit var loginBtn: Button

        // on below line we are creating
        // a variable for shared preferences.
        lateinit var sharedPreferences: SharedPreferences

        // on below line we are creating a variable
        // for prefs key and email key and pwd key.
        var PREFS_KEY = "prefs"
        var EMAIL_KEY = "email"
        var PWD_KEY = "pwd"

        // on below line we are creating a
        // variable for email and password.
        var email = ""
        var pwd = ""


        // text and other fields for awc_infrastructural_profile1

        // UI components of awc_infrastructural_profile1

        private lateinit var rgSakshamAnganwadi: RadioGroup
        private lateinit var rbSakshamYes: RadioButton
        private lateinit var rbSakshamNo: RadioButton
        private lateinit var etProjectName: EditText
        private lateinit var spinnerGramPanchayat: Spinner
        private lateinit var rgHealthCentreDistance: RadioGroup
        private lateinit var rbLessThan500Mtrs: RadioButton
        private lateinit var rbMoreThan500Mtrs: RadioButton
        private lateinit var rbMoreThan1Kms: RadioButton
        private lateinit var etAWCName: EditText
        private lateinit var etAWCCode: EditText
        private lateinit var rgAWWPosition: RadioGroup
        private lateinit var rbAWWYes: RadioButton
        private lateinit var rbAWWNo: RadioButton
        private lateinit var rgAWHPosition: RadioGroup
        private lateinit var rbAWHYes: RadioButton
        private lateinit var rbAWHNo: RadioButton
        private lateinit var rgAWCMainCharge: RadioGroup
        private lateinit var rbAWCMainChargeYes: RadioButton
        private lateinit var rbAWCMainChargeNo: RadioButton
        private lateinit var etMobileNumber: EditText
        private lateinit var spinnerBuildingOwnership: Spinner
        private lateinit var spinnerBuildingType: Spinner
        private lateinit var etLandAvailable: EditText
        private lateinit var rgLandRegistered: RadioGroup
        private lateinit var rbLandRegisteredYes: RadioButton
        private lateinit var rbLandRegisteredNo: RadioButton
        private lateinit var spinnerScheme: Spinner
        private lateinit var etConstructionDate: EditText
        private lateinit var spinnerBuildingModel: Spinner
        private lateinit var spinnerDrinkingWater: Spinner
        private lateinit var btnSubmit: Button

        val jsonObject = JSONObject() // for json object creation

        // End Of UI components of awc_infrastructural_profile1





        //database helper class

        private lateinit var dbHelper: DatabaseHelper

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.awc_infrastructural_profile1)

            // checking internet connection

            if (NetworkUtils.isNetworkAvailable(this)) {
                // Proceed with network operations
               // fetchDataFromServer()
            } else {
                // Handle no internet connection
                Toast.makeText(this, "No internet connection", Toast.LENGTH_SHORT).show()
                return
            }




            // Initialize UI components of awc_infrastructural_profile1
            rgSakshamAnganwadi = findViewById(R.id.rgSakshamAnganwadi)
            rbSakshamYes = findViewById(R.id.rbSakshamYes)
            rbSakshamNo = findViewById(R.id.rbSakshamNo)
            etProjectName = findViewById(R.id.etProjectName)
            spinnerGramPanchayat = findViewById(R.id.spinnerGramPanchayat)
            rgHealthCentreDistance = findViewById(R.id.rgHealthCentreDistance)
            rbLessThan500Mtrs = findViewById(R.id.rbLessThan500Mtrs)
            rbMoreThan500Mtrs = findViewById(R.id.rbMoreThan500Mtrs)
            rbMoreThan1Kms = findViewById(R.id.rbMoreThan1Kms)
            etAWCName = findViewById(R.id.etAWCName)
            etAWCCode = findViewById(R.id.etAWCCode)
            rgAWWPosition = findViewById(R.id.rgAWWPosition)
            rbAWWYes = findViewById(R.id.rbAWWYes)
            rbAWWNo = findViewById(R.id.rbAWWNo)
            rgAWHPosition = findViewById(R.id.rgAWHPosition)
            rbAWHYes = findViewById(R.id.rbAWHYes)
            rbAWHNo = findViewById(R.id.rbAWHNo)
            rgAWCMainCharge = findViewById(R.id.rgAWCMainCharge)
            rbAWCMainChargeYes = findViewById(R.id.rbAWCMainChargeYes)
            rbAWCMainChargeNo = findViewById(R.id.rbAWCMainChargeNo)
            etMobileNumber = findViewById(R.id.etMobileNumber)
            spinnerBuildingOwnership = findViewById(R.id.spinnerBuildingOwnership)
            spinnerBuildingType = findViewById(R.id.spinnerBuildingType)
            etLandAvailable = findViewById(R.id.etLandAvailable)
            rgLandRegistered = findViewById(R.id.rgLandRegistered)
            rbLandRegisteredYes = findViewById(R.id.rbLandRegisteredYes)
            rbLandRegisteredNo = findViewById(R.id.rbLandRegisteredNo)
            spinnerScheme = findViewById(R.id.spinnerScheme)
            etConstructionDate = findViewById(R.id.etConstructionDate)
            spinnerBuildingModel = findViewById(R.id.spinnerBuildingModel)
            spinnerDrinkingWater = findViewById(R.id.spinnerDrinkingWater)
            btnSubmit = findViewById(R.id.btnSubmit)
           /* val submitButton: Button = findViewById(R.id.submitButton)
            submitButton.setOnClickListener {
                // Handle button click
            }*/
            // End Of Initialize UI components of awc_infrastructural_profile1

            // Set up the submit button click listener

           btnSubmit.setOnClickListener {
                print("Entered !!")
                insertdataAwcInfrastructuralProfile1()

               // push jsondata through retrofit



            }

        }

        // Getting values for awc_infrastructural_profile1

        public fun insertdataAwcInfrastructuralProfile1() {
            // Retrieve values from UI components
            val sakshamAnganwadiSelectedId = rgSakshamAnganwadi.checkedRadioButtonId
            val sakshamAnganwadiSelection = when (sakshamAnganwadiSelectedId) {
                R.id.rbSakshamYes -> "Yes"
                R.id.rbSakshamNo -> "No"
                else -> ""
            }

            val projectName = etProjectName.text.toString()
            val gramPanchayat = spinnerGramPanchayat.selectedItem.toString()

            val healthCentreDistanceSelectedId = rgHealthCentreDistance.checkedRadioButtonId
            val healthCentreDistance = when (healthCentreDistanceSelectedId) {
                R.id.rbLessThan500Mtrs -> "<500 Mtrs"
                R.id.rbMoreThan500Mtrs -> ">500 Mtrs"
                R.id.rbMoreThan1Kms -> ">1 Kms"
                else -> ""
            }

            val awcName = etAWCName.text.toString()
            val awcCode = etAWCCode.text.toString()

            val awwPositionSelectedId = rgAWWPosition.checkedRadioButtonId
            val awwPosition = when (awwPositionSelectedId) {
                R.id.rbAWWYes -> "Yes"
                R.id.rbAWWNo -> "No"
                else -> ""
            }

            val awhPositionSelectedId = rgAWHPosition.checkedRadioButtonId
            val awhPosition = when (awhPositionSelectedId) {
                R.id.rbAWHYes -> "Yes"
                R.id.rbAWHNo -> "No"
                else -> ""
            }

            val awcMainChargeSelectedId = rgAWCMainCharge.checkedRadioButtonId
            val awcMainCharge = when (awcMainChargeSelectedId) {
                R.id.rbAWCMainChargeYes -> "Yes"
                R.id.rbAWCMainChargeNo -> "No"
                else -> ""
            }

            val mobileNumber = etMobileNumber.text.toString()
            val buildingOwnership = spinnerBuildingOwnership.selectedItem.toString()
            val buildingType = spinnerBuildingType.selectedItem.toString()
            val landAvailable = etLandAvailable.text.toString()
            val landRegisteredSelectedId = rgLandRegistered.checkedRadioButtonId
            val landRegistered = when (landRegisteredSelectedId) {
                R.id.rbLandRegisteredYes -> "Yes"
                R.id.rbLandRegisteredNo -> "No"
                else -> ""
            }

            val scheme = spinnerScheme.selectedItem.toString()
            val constructionDate = etConstructionDate.text.toString()
            val buildingModel = spinnerBuildingModel.selectedItem.toString()
            val drinkingWater = spinnerDrinkingWater.selectedItem.toString()

            // Now you have all the values from the UI components, you can proceed with further processing (e.g., validation, database operations)


            // Convert the parsed data to JSON
            converter();
        }
                private fun converter() {

                // val jsonObject = JSONObject()

                 jsonObject.put("rgSakshamAnganwadi",rgSakshamAnganwadi)
                 jsonObject.put("rbSakshamYes",rbSakshamYes)
                 jsonObject.put("rbSakshamNo",rbSakshamNo)
                 jsonObject.put("etProjectName",etProjectName)
                 jsonObject.put("spinnerGramPanchayat",spinnerGramPanchayat)
                 jsonObject.put("rgHealthCentreDistance",rgHealthCentreDistance)
                 jsonObject.put("rbLessThan500Mtrs",rbLessThan500Mtrs)
                 jsonObject.put("rbMoreThan500Mtrs",rbMoreThan500Mtrs)
                 jsonObject.put("rbMoreThan1Kms",rbMoreThan1Kms)
                 jsonObject.put("rgAWCMainCharge",rgAWCMainCharge)
                 jsonObject.put("rbAWCMainChargeYes",rbSakshamYes)
                 jsonObject.put("rbAWCMainChargeNo",rbSakshamNo)
                 jsonObject.put("etMobileNumber",etProjectName)
                 jsonObject.put("spinnerBuildingOwnership",spinnerGramPanchayat)
                 jsonObject.put("spinnerBuildingType",spinnerBuildingType)
                 jsonObject.put("etLandAvailable",etLandAvailable)
                 jsonObject.put("rgLandRegistered",rgLandRegistered)
                 jsonObject.put("rbLandRegisteredYes",rbLandRegisteredYes)
                 jsonObject.put("rbLandRegisteredNo",rbLandRegisteredNo)
                 jsonObject.put("spinnerScheme",spinnerScheme)
                 jsonObject.put("etConstructionDate",etConstructionDate)
                 jsonObject.put("spinnerBuildingModel",spinnerBuildingModel)
                 jsonObject.put("spinnerDrinkingWater",spinnerDrinkingWater)
                 jsonObject.put("rbLandRegisteredYes",rbLandRegisteredYes)
            }




                    /*


                    jsonObject.put(btnSubmit = findViewById(R.id.btnSubmit)*/

            //System.out.println(jsonObject.ptoString())


            // Print the JSON string            println(jsonString)


            // end of parsing


            // Example: Display a toast message with the retrieved values
           /* val message = "Saksham Anganwadi: $sakshamAnganwadiSelection\n" +
                    "Project Name: $projectName\n" +
                    "Gram Panchayat: $gramPanchayat\n" +
                    "Health Centre Distance: $healthCentreDistance\n" +
                    "AWC Name: $awcName\n" +
                    "AWC Code: $awcCode\n" +
                    "AWW Position: $awwPosition\n" +
                    "AWH Position: $awhPosition\n" +
                    "AWC Main Charge: $awcMainCharge\n" +
                    "Mobile Number: $mobileNumber\n" +
                    "Building Ownership: $buildingOwnership\n" +
                    "Building Type: $buildingType\n" +
                    "Land Available: $landAvailable\n" +
                    "Land Registered: $landRegistered\n" +
                    "Scheme: $scheme\n" +
                    "Construction Date: $constructionDate\n" +
                    "Building Model: $buildingModel\n" +
                    "Drinking Water: $drinkingWater"
            System.out.println("message is ::"+message)
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()*/
       // }


            // on below line we are initializing
            // our email and pwd edit text
           /* emailEdt = findViewById(R.id.idEdtEmail)
            pwdEdt = findViewById(R.id.idEdtPassword)*-/

            // on below line we are initializing
            // our login button with id.
            loginBtn = findViewById(R.id.idBtnLogin)

            // on below line we are initializing our shared preferences.
            sharedPreferences = getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)

            // on below line we are getting data from
            // our shared prefs and setting it to email.
            email = sharedPreferences.getString(EMAIL_KEY, "").toString()

            // on below line we are getting data from
            // shared prefs and setting it to pwd.
            pwd = sharedPreferences.getString(PWD_KEY, "").toString()

            // on below line we are adding on click listener for our login button.
            loginBtn.setOnClickListener {
                // on below line we are checking if email and pwd txt is empty or not.
                if (TextUtils.isEmpty(emailEdt.text.toString()) && TextUtils.isEmpty(pwdEdt.text.toString())) {

                    // if email and pwd edit text is empty we are displaying a toast message
                    Toast.makeText(this, "Please Enter Email and Password", Toast.LENGTH_SHORT).show();

                } else {
                    // on below line we are creating variable for editor
                    // of shared prefs and initializing it.
                    val editor: SharedPreferences.Editor = sharedPreferences.edit()

                    // on below line we are adding our email and
                    // pwd to shared prefs to save them.
                    editor.putString(EMAIL_KEY, emailEdt.text.toString())
                    editor.putString(PWD_KEY, pwdEdt.text.toString())

                    // on below line we are applying
                    // changes to our shared prefs.
                    editor.apply()

                    // on below line we are opening our intent as main activity 2
                    val i = Intent(this@MainActivity, MainActivity::class.java)

                    // on below line we are
                    // starting our activity.
                    startActivity(i)

                    // on below line we are calling
                    // finish to close our activity.
                    finish()
                }
            }
        }*/

        // on below line we are calling on start method.
        override fun onStart() {
            super.onStart()
            // in this method we are checking if email and pwd are not empty.
           /* if (!email.equals("") && !pwd.equals("")) {
                // if email and pwd is not empty we
                // are opening our main 2 activity on below line.
                val i = Intent(this@MainActivity, MainActivity::class.java)

                // on below line we are calling start
                // activity method to start our activity.
                startActivity(i)

                // on below line we are calling
                // finish to finish our main activity.
                finish()
            }*/
            val i = Intent(this@MainActivity, awc_infrastructural_profile1::class.java)
            startActivity(i)

            // on below line we are calling
            // finish to finish our main activity.
            finish()
        }
    }

