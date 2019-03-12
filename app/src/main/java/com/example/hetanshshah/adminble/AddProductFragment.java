package com.example.hetanshshah.adminble;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import static com.example.hetanshshah.adminble.database.Constants.*;

public class AddProductFragment extends Fragment {
    EditText productName,productDetails,beaconId;
    String strproductname,strproductdetails,strbeaconid;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_add_product, container, false);
        productName=view.findViewById(R.id.product_name);
        productDetails=view.findViewById(R.id.product_details);
        beaconId=view.findViewById(R.id.beacon_id);
        view.findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strbeaconid=beaconId.getText().toString();
                strproductdetails=productDetails.getText().toString();
                strproductname=productName.getText().toString();
                if(validate(strproductname,strproductdetails,strbeaconid)){
                    ContentValues contentValues=new ContentValues();
                    contentValues.put(BEACON_ID,strbeaconid);
                    contentValues.put(PRODUCT_NAME,strproductname);
                    contentValues.put(PRODUCT_DETAILS,strproductdetails);
                    getContext().getContentResolver().insert(CONTENT_PRODUCT,contentValues);
                }
            }
        });
        return view;
    }
    public boolean validate(String productName,String productDetails,String beaconId){
        if (productName.isEmpty()){
            Toast.makeText(getContext(), "Enter Product Name", Toast.LENGTH_SHORT).show();
            return false;
        }else if (productDetails.isEmpty()){
            Toast.makeText(getContext(), "Enter Product Name", Toast.LENGTH_SHORT).show();
            return false;
        }else if (beaconId.isEmpty()){
            Toast.makeText(getContext(), "Enter Product Name", Toast.LENGTH_SHORT).show();
            return false;
        }else{
            return true;
        }
    }
}
