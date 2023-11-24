package com.example.freshcatch;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class ProdukAdapter extends RecyclerView.Adapter<ProdukAdapter.ViewHolder> {

    private List<ProdukModels> produkList;
    private Context context;

    public ProdukAdapter(List<ProdukModels> produkList, Context context) {
        this.produkList = produkList;
        this.context = context;
    }
    public void setProdukList(List<ProdukModels> produkList) {
        this.produkList = produkList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_produk, parent, false);
        return new ViewHolder(view);
    }

    // Update the decodeBase64 method
    private Bitmap decodeBase64(String base64String) {
        // Remove the data URI prefix if present
        String base64Data = base64String.substring(base64String.indexOf(",") + 1);

        byte[] decodedBytes = Base64.decode(base64Data, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
    }


    // Update the onBindViewHolder method
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProdukModels produk = produkList.get(position);

        holder.productName.setText(produk.getNama_produk());
        holder.productPrice.setText("Rp" + produk.getHarga());

        // Decode Base64 string to Bitmap
        Bitmap decodedImage = decodeBase64(produk.getGambar());

        // Set the decoded Bitmap to the ImageView
        holder.productImage.setImageBitmap(decodedImage);

        holder.buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event, you can start the DetailProduk activity here
                ProdukModels clickedProduk = produkList.get(holder.getAdapterPosition());
                showProductDetails(clickedProduk);
            }
        });
    }


    private void showProductDetails(ProdukModels clickedProduk) {
        Intent intent = new Intent(context, DetailProduk.class);
        intent.putExtra("productId", clickedProduk.getId());
        intent.putExtra("productName", clickedProduk.getNama_produk());
        intent.putExtra("productPrice", clickedProduk.getHarga());
        intent.putExtra("productImage", clickedProduk.getGambar());
        intent.putExtra("productDescription", clickedProduk.getDeskripsi());
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return produkList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView productName;
        TextView productPrice;
        Button buyButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.productImage);
            productName = itemView.findViewById(R.id.productName);
            productPrice = itemView.findViewById(R.id.productPrice);
            buyButton = itemView.findViewById(R.id.cartButton);
        }
    }
    public void filterList(List<ProdukModels> filteredList) {
        produkList = filteredList;
        notifyDataSetChanged();
    }
}
