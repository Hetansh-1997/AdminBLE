package com.example.hetanshshah.adminble;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import static com.example.hetanshshah.adminble.database.Constants.*;

public class ViewProductFragment extends Fragment {
    TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_products, container, false);
        Cursor cursor=getContext().getContentResolver().query(CONTENT_PRODUCT,null,null,null,null);
        cursor.moveToFirst();
        if (cursor.getCount()>0) {
            TableLayout tableLayout = view.findViewById(R.id.tablelayout);
            tableLayout.setStretchAllColumns(true);
            TableRow tableRow=new TableRow(getContext());
            textView = new TextView(getContext());
            textView.setText("Product Name");
            tableRow.addView(textView ,new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
            textView = new TextView(getContext());
            textView.setText("Product Details");
            tableRow.addView(textView);
            textView = new TextView(getContext());
            textView.setText("Beacon Id");
            tableRow.addView(textView);
            tableLayout.addView(tableRow, 0);
            for (int i = 1;i<=cursor.getCount(); i++) {
                tableRow = new TableRow(getContext());
                textView = new TextView(getContext());
                textView.setText(cursor.getString(cursor.getColumnIndex(PRODUCT_NAME)));
                tableRow.addView(textView ,new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
                textView = new TextView(getContext());
                textView.setText(cursor.getString(cursor.getColumnIndex(PRODUCT_DETAILS)));
                tableRow.addView(textView);
                textView = new TextView(getContext());
                textView.setText(cursor.getString(cursor.getColumnIndex(BEACON_ID)));
                tableRow.addView(textView);
                tableLayout.addView(tableRow, i);
                cursor.moveToNext();
            }
        }
        return view;
    }
}
