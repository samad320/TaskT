package com.app.tasks;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class InsertStoreItemActivity extends AppCompatActivity {

    private EditText storeItemNameEditText;
    private EditText itemMRPEditText;
    private EditText sellingPriceEditText;
    private Button insertButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_store_item);

        storeItemNameEditText = findViewById(R.id.editTextStoreItemName);
        itemMRPEditText = findViewById(R.id.editTextItemMRP);
        sellingPriceEditText = findViewById(R.id.editTextSellingPrice);
        insertButton = findViewById(R.id.buttonInsert);

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertStoreItem();
            }
        });
    }

    private void insertStoreItem() {
        String storeItemName = storeItemNameEditText.getText().toString();
        float itemMRP = Float.parseFloat(itemMRPEditText.getText().toString());
        float sellingPrice = Float.parseFloat(sellingPriceEditText.getText().toString());


        JSONObject formData = new JSONObject();
        try {
            formData.put("uid", 0);
            formData.put("store_uid", 180);
            formData.put("store_cat_id", 1);
            formData.put("store_item_Name", storeItemName);
            formData.put("item_MRP", itemMRP);
            formData.put("selling_price", sellingPrice);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        new InsertStoreItemTask().execute(formData.toString());
    }

    private class InsertStoreItemTask extends AsyncTask<String, Void, Boolean> {

        @Override
        protected Boolean doInBackground(String... params) {
            try {
                URL url = new URL("http://mapi.grataeshop.com:8091/api/Category/InsertStoreItem");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("XApiKey", "1");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setDoOutput(true);

                OutputStream os = connection.getOutputStream();
                byte[] input = params[0].getBytes("utf-8");
                os.write(input, 0, input.length);

                int responseCode = connection.getResponseCode();

                os.flush();
                os.close();

                return responseCode >= 200 && responseCode < 300;

            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean success) {
            if (success) {
                Toast.makeText(InsertStoreItemActivity.this, "Item inserted successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(InsertStoreItemActivity.this, "Error inserting item", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
