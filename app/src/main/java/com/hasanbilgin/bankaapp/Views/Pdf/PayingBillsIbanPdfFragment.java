package com.hasanbilgin.bankaapp.Views.Pdf;
import androidx.lifecycle.ViewModelProvider;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.pdf.PdfDocument;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.hasanbilgin.bankaapp.R;
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
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(210, 200, 1).create();
        PdfDocument.Page page = myPdfDocument.startPage(pageInfo);
        Canvas canvas = page.getCanvas();

        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bankaimage); //Resmi tanımlamak
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(originalBitmap, 20, 20, false); // 200x200 boyutuna ölçeklendir
        canvas.drawBitmap(resizedBitmap, 10, 10, myPaint);
        //yazı ortalanması
        myPaint.setTextAlign(Paint.Align.CENTER);
        //yazı sizesi
        myPaint.setTextSize(12.0f);
        canvas.drawText("DEKONT", pageInfo.getPageWidth() / 2, 30, myPaint);

        //ilk kare
        canvas.drawLine(2, 40, 104, 40, myPaint);
        canvas.drawLine(2, 80, 104, 80, myPaint);
        canvas.drawLine(2, 40, 2, 80, myPaint);
        canvas.drawLine(104, 40, 104, 80, myPaint);

        //ikinci kare
        canvas.drawLine(106, 40, 208, 40, myPaint);
        canvas.drawLine(106, 80, 208, 80, myPaint);
        canvas.drawLine(106, 40, 106, 80, myPaint);
        canvas.drawLine(208, 40, 208, 80, myPaint);

        //ilk kare verileri
        myPaint.setTextSize(4.5f);
        myPaint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText("Şube Adı", 4, 45, myPaint);
        canvas.drawText("Tc Kimlik numarası /", 4, 53, myPaint);
        canvas.drawText("Vergi Kimlik Numarası", 4, 58, myPaint);
        canvas.drawText("İşlem Tarihi", 4, 66, myPaint);
        canvas.drawText("İşlem Yeri", 4, 76, myPaint);

        canvas.drawText(": Banka App Şubesi", 55, 45, myPaint);
        canvas.drawText(": 2182377****", 55, 55, myPaint);
        canvas.drawText(": 17.06.2023 18:30", 55, 66, myPaint);
        canvas.drawText(": Banka App Cep Şube", 55, 76, myPaint);

        //ikinci kare verileri
        canvas.drawText("Sayın Hasan Bilgin", 108, 45, myPaint);
        canvas.drawText("Muratpaşa Mah. Gülay Sok. No:27 D:2", 108, 55, myPaint);
        canvas.drawText("İstanbul BAYRAMPAŞA", 108, 77, myPaint);

        //3.kare
        canvas.drawLine(2, 82, 208, 82, myPaint);
        canvas.drawLine(2, 112, 208, 112, myPaint);
        canvas.drawLine(2, 82, 2, 112, myPaint);
        canvas.drawLine(208, 82, 208, 112, myPaint);

        //3.kare verileri
        canvas.drawText("Aşağıda hesabınızdan/kredi kartınızdan gerçekleştirilen işlemin detayları yer almaktadır.", 4, 87, myPaint);
        canvas.drawText("Hesap", 4, 97, myPaint);
        canvas.drawText("İban", 30, 97, myPaint);
        canvas.drawText("Açıklama", 85, 97, myPaint);
        canvas.drawText("Tutar", 175, 97, myPaint);
        canvas.drawText("Birim", 197, 97, myPaint);

        canvas.drawText("Vadesiz TL", 4, 107, myPaint);
        canvas.drawText("TR01 2345 6789 0123 4567 8901", 30, 107, myPaint);
        canvas.drawText("Hasan bilgin , EFT (FAST) Esra bilgine", 85, 107, myPaint);
        canvas.drawText("11925,44", 175, 107, myPaint);
        canvas.drawText("TL", 197, 107, myPaint);

        //4.kare
        canvas.drawLine(2, 114, 208, 114, myPaint);
        canvas.drawLine(2, 160, 208, 160, myPaint);
        canvas.drawLine(2, 114, 2, 160, myPaint);
        canvas.drawLine(208, 114, 208, 160, myPaint);

        //4.kare verileri
        canvas.drawText("Aşağıda hesabınızdan/kredi kartınızdan gerçekleştirilen işlemin detayları yer almaktadır.", 4, 120, myPaint);
        canvas.drawText("ALICI VE IBAN", 4, 125, myPaint);
        canvas.drawText(": Hasan Bilgin " + " TR98 7654 3210 9876 6543 2109", 54, 125, myPaint);
        canvas.drawText("ALICI BANKA", 4, 130, myPaint);
        canvas.drawText(": Türkiye Cumhuriyet Ziraat Bankası", 54, 130, myPaint);
        canvas.drawText("EFT TUTARI VE ÜCRETİ", 4, 135, myPaint);
        canvas.drawText(": 11925,44" + " TL" + "   0 TL", 54, 135, myPaint);
        canvas.drawText("GÖNDERİCİ VE IBAN", 4, 140, myPaint);
        canvas.drawText(": Hasan Bilgin" + " " + "TR01 2345 6789 0123 4567 8901", 54, 140, myPaint);
        canvas.drawText("AÇIKLAMA", 4, 145, myPaint);
        canvas.drawText(": Bireysel Ödeme", 54, 145, myPaint);
        canvas.drawText("GÖNDERİCİ BANKA", 4, 150, myPaint);
        canvas.drawText(": ENPARA", 54, 150, myPaint);
        canvas.drawText("Fiş No", 150, 155, myPaint);
        canvas.drawText("20241231235959000001", 165, 155, myPaint);

        myPdfDocument.finishPage(page);
        //20241231235959000001_ENPAR dinamik gelcek
        File file = new File(getContext().getExternalFilesDir("/"), "20241231235959000001_ENPARA.pdf");

        try {
            FileOutputStream fos = new FileOutputStream(file);
            myPdfDocument.writeTo(fos);
            myPdfDocument.close();
            fos.close();
            binding.pdfView.fromFile(file).load();
            Toast.makeText(getContext(), "Pdf Kaydedildi", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void save() {

//        binding.saveButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                Toast.makeText(getContext(), "Kaydetme işlemi Başarılı", Toast.LENGTH_SHORT).show();
//            }
//        });


    }


}