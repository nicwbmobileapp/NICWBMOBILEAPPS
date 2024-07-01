package com.example.icds;

// File: src/main/java/com/example/myapp/forms/icds_inspection_form.kt
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class awc_infrastructural_profile1 : AppCompatActivity() {

    val layoutManagers = mutableListOf<RecyclerView.LayoutManager>()
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.awc_infrastructural_profile1)
        // Initialize views
        rgSakshamAnganwadi = findViewById(R.id.rgSakshamAnganwadi)
        rgHealthCentreDistance = findViewById(R.id.rgHealthCentreDistance)
        rgAWWPosition = findViewById(R.id.rgAWWPosition)
        rgAWHPosition = findViewById(R.id.rgAWHPosition)
        rgAWCMainCharge = findViewById(R.id.rgAWCMainCharge)
        rgLandRegistered = findViewById(R.id.rgLandRegistered)

        etProjectName = findViewById(R.id.etProjectName)
        etAWCName = findViewById(R.id.etAWCName)
        etAWCCode = findViewById(R.id.etAWCCode)
        etMobileNumber = findViewById(R.id.etMobileNumber)
        etLandAvailable = findViewById(R.id.etLandAvailable)
        etConstructionDate = findViewById(R.id.etConstructionDate)

        spinnerGramPanchayat = findViewById(R.id.spinnerGramPanchayat)
        spinnerBuildingOwnership = findViewById(R.id.spinnerBuildingOwnership)
        spinnerBuildingType = findViewById(R.id.spinnerBuildingType)
        spinnerScheme = findViewById(R.id.spinnerScheme)
        spinnerBuildingModel = findViewById(R.id.spinnerBuildingModel)
        spinnerDrinkingWater = findViewById(R.id.spinnerDrinkingWater)


        val myButton: Button = findViewById(R.id.btnSubmit)
        myButton.setOnClickListener {
            // Your action code here
            // For example, you could show a toast message
            Toast.makeText(this@awc_infrastructural_profile1, "Button Clicked!", Toast.LENGTH_SHORT)
                .show()
        }

        val myNextButton: Button = findViewById(R.id.btnNext)
        myNextButton.setOnClickListener {
            // Your action code here
            // For example, you could show a toast message
            Toast.makeText(this@awc_infrastructural_profile1, "Button Next!", Toast.LENGTH_SHORT)
                .show()
            // Collect and store data
            DataHolder.DataMap["rgSakshamAnganwadi"] = getSelectedRadioText(rgSakshamAnganwadi)
            DataHolder.DataMap["rgHealthCentreDistance"] = getSelectedRadioText(rgHealthCentreDistance)
            DataHolder.DataMap["rgAWWPosition"] = getSelectedRadioText(rgAWWPosition)
            DataHolder.DataMap["rgAWHPosition"] = getSelectedRadioText(rgAWHPosition)
            DataHolder.DataMap["rgAWCMainCharge"] = getSelectedRadioText(rgAWCMainCharge)
            DataHolder.DataMap["rgLandRegistered"] = getSelectedRadioText(rgLandRegistered)
            DataHolder.DataMap["etProjectName"] = etProjectName.text.toString()
            DataHolder.DataMap["etAWCName"] = etAWCName.text.toString()
            DataHolder.DataMap["etAWCCode"] = etAWCCode.text.toString()
            DataHolder.DataMap["etMobileNumber"] = etMobileNumber.text.toString()
            DataHolder.DataMap["etLandAvailable"] = etLandAvailable.text.toString()
            DataHolder.DataMap["etConstructionDate"] = etConstructionDate.text.toString()
            DataHolder.DataMap["spinnerGramPanchayat"] = spinnerGramPanchayat.selectedItem.toString()
            DataHolder.DataMap["spinnerBuildingOwnership"] = spinnerBuildingOwnership.selectedItem.toString()
            DataHolder.DataMap["spinnerBuildingType"] = spinnerBuildingType.selectedItem.toString()
            DataHolder.DataMap["spinnerScheme"] = spinnerScheme.selectedItem.toString()
            DataHolder.DataMap["spinnerBuildingModel"] = spinnerBuildingModel.selectedItem.toString()
            DataHolder.DataMap["spinnerDrinkingWater"] = spinnerDrinkingWater.selectedItem.toString()
for((key,value)in DataHolder.DataMap){
    Log.d("Details","$key:$value")
}
// Create toast message
            val toastMessage = """
                Saksham Anganwadi: ${getSelectedRadioText(rgSakshamAnganwadi)}
                Project Name: ${etProjectName.text}
                Gram Panchayat: ${spinnerGramPanchayat.selectedItem}
                Health Centre Distance: ${getSelectedRadioText(rgHealthCentreDistance)}
                AWC Name: ${etAWCName.text}
                AWC Code: ${etAWCCode.text}
                Mobile Number: ${etMobileNumber.text}
                Building Ownership: ${spinnerBuildingOwnership.selectedItem}
                Building Type: ${spinnerBuildingType.selectedItem}
                Land Available: ${etLandAvailable.text}
                Land Registered: ${getSelectedRadioText(rgLandRegistered)}
                Scheme: ${spinnerScheme.selectedItem}
                Construction Date: ${etConstructionDate.text}
                Building Model: ${spinnerBuildingModel.selectedItem}
                Drinking Water: ${spinnerDrinkingWater.selectedItem}
            """.trimIndent()
            Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show()
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


            // for retrofit

           // layoutManagers.
          //  add(RecyclerView.LayoutManager(rgSakshamAnganwadi,rbSakshamYes,rbSakshamNo,etProjectName,spinnerGramPanchayat,rgHealthCentreDistance,rbLessThan500Mtrs,rbMoreThan500Mtrs,rbMoreThan1Kms,etAWCName, etAWCCode,rgAWWPosition,rbAWWYes,rbAWWNo,rgAWHPosition,rbAWHYes,rbAWHNo,rgAWCMainCharge,rbAWCMainChargeYes,rbAWCMainChargeNo,etMobileNumber,spinnerBuildingOwnership, spinnerBuildingType,etLandAvailable,rgLandRegistered,rbLandRegisteredYes,rbLandRegisteredNo,spinnerScheme,etConstructionDate,spinnerBuildingModel,spinnerDrinkingWater))

            // traversing next activity
            val intent = Intent(this, awc_infrastructural_profile2::class.java)
            startActivity(intent)


        }


    }
    private fun getSelectedRadioText(radioGroup: RadioGroup): String {
        val selectedId = radioGroup.checkedRadioButtonId
        return if (selectedId != -1) {
            findViewById<RadioButton>(selectedId).text.toString()
        } else {
            "None"
        }
    }
}

