package com.hasanbilgin.bankaapp.Views.Pdf;

import androidx.lifecycle.ViewModelProvider;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hasanbilgin.bankaapp.Adapters.SectionsPagerHomePageAdapter;
import com.hasanbilgin.bankaapp.R;
import com.hasanbilgin.bankaapp.Views.Login.LoginHome.LoginViewModel;
import com.hasanbilgin.bankaapp.databinding.FragmentLoginBinding;
import com.hasanbilgin.bankaapp.databinding.FragmentPayingBillsIbanPdfBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PayingBillsIbanPdfFragment extends Fragment {

    private PayingBillsIbanPdfViewModel viewModel;
    private FragmentPayingBillsIbanPdfBinding binding;

    public static PayingBillsIbanPdfFragment newInstance() {
        return new PayingBillsIbanPdfFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(PayingBillsIbanPdfViewModel.class);
        binding = FragmentPayingBillsIbanPdfBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createPDF();
    }


    private void createPDF() {


        //PdfDocument -> import com.github.barteksc.pdfviewer.PDFView; kütüphanesi
        PdfDocument myPdfDocument = new PdfDocument();
        Paint myPaint = new Paint();
//        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(250, 400, 1).create();
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(250, 400, 1).create();
        PdfDocument.Page page = myPdfDocument.startPage(pageInfo);
        Canvas canvas = page.getCanvas();

        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.vb); //Resmi tanımlamak
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(originalBitmap, 30, 30, true); // 200x200 boyutuna ölçeklendir
        canvas.drawBitmap(resizedBitmap, 10, 10, myPaint);

        String[] informationArray = new String[]{"Name", "Company Name", "Address", "Phone", "Email"};
        //yazı ortalanması
        myPaint.setTextAlign(Paint.Align.CENTER);
        //yazı sizesi
        myPaint.setTextSize(12.0f);
        canvas.drawText("DEKONT", pageInfo.getPageWidth() / 2, 30, myPaint);

//        myPaint.setTextSize(6.0f);
//        //yazı rengi
//        myPaint.setColor(Color.rgb(122, 119, 119));
//        canvas.drawText("Street No. 15, Bharat Magar, Haryana", pageInfo.getPageWidth() / 2, 40, myPaint);

        myPaint.setTextAlign(Paint.Align.LEFT);
        myPaint.setTextSize(9.0f);
        myPaint.setColor(Color.rgb(122, 119, 119));
//        canvas.drawText("Customer Information", 10, 70, myPaint);

        int startXPosition = 10;
        int endXPosition = pageInfo.getPageWidth() - 10;
        int startYPosition = 100;
        myPaint.setStrokeWidth(0.8f);
        for (int i = 0; i < 5; i++) {
            canvas.drawText(informationArray[i], startXPosition, startYPosition, myPaint);
            canvas.drawLine(startXPosition, startYPosition + 3, endXPosition, startYPosition + 3, myPaint);
            startYPosition += 20;
        }
        //5 alanın dikey çizgi çizimi
        canvas.drawLine(80, 92, 80, 190, myPaint);
        //kalın çizim için
        myPaint.setStyle(Paint.Style.STROKE);
        //et kalınlığı
        myPaint.setStrokeWidth(2);
        //dikdörtgen çizmi
        canvas.drawRect(10, 200, pageInfo.getPageWidth() - 10, 300, myPaint);
        //ara çizgiler
        canvas.drawLine(85, 200, 85, 300, myPaint);
        canvas.drawLine(163, 200, 163, 300, myPaint);
        //setlemesi için 0lıyor
        myPaint.setStrokeWidth(0);
        //yatay full çizgi için
        myPaint.setStyle(Paint.Style.FILL);
        canvas.drawText("Photo", 35, 250, myPaint);
        canvas.drawText("Photo", 110, 250, myPaint);
        canvas.drawText("Photo", 190, 250, myPaint);
        canvas.drawText("Note", 10, 320, myPaint);
        canvas.drawLine(35, 325, pageInfo.getPageWidth() - 10, 325, myPaint);
        canvas.drawLine(10, 345, pageInfo.getPageWidth() - 10, 345, myPaint);
        canvas.drawLine(10, 365, pageInfo.getPageWidth() - 10, 365, myPaint);

        myPdfDocument.finishPage(page);
        File file = new File(getContext().getExternalFilesDir("/"), "openPDF.pdf");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            myPdfDocument.writeTo(fos);
            myPdfDocument.close();
            fos.close();
            binding.pdfView.fromFile(file).load();
        } catch (IOException e) {
            e.printStackTrace();
        }

// PDF dökümanını oluştur

    }


}