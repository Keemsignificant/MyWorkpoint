package com.example.myworkpoint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mList;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txt_show = findViewById(R.id.show);
        TextView txt_now_show = findViewById(R.id.time_show);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
        String dateTime = simpleDateFormat.format(calendar.getTime());
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("hh:mm:a");
        String time = simpleDateFormat1.format(calendar.getTime());


        String url_live = "https://www.dailymotion.com/embed/video/x6g9qjj?autoplay=1";
        WebView mwebview = findViewById(R.id.web_vid);
        mwebview.setWebViewClient(new WebViewClient());
        WebSettings webSettings = mwebview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mwebview.loadUrl(url_live);

        ImageView footer = findViewById(R.id.footer);
        footer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();

            }
        });

        if (dateTime.contentEquals("Monday") || dateTime.contains("จันทร์")) {
            //วันจันทร์
            ArrayList<ListShow> listshow = new ArrayList<>();
            listshow.add(new ListShow("00:25 - 01:20", "พระพุทธเจ้า มหาศาสดาโลก", "12:25:AM", "01:20", "AM"));
            listshow.add(new ListShow("01:20 - 01:35", "ตลก 6 ฉาก", "01:20", "01:35", "AM"));

            listshow.add(new ListShow("01:35 - 02:00", "High Shopping", "01:35", "02:00", "AM"));

            listshow.add(new ListShow("02:00 - 03:00", "ไซอิ๋ว อภินิหารลิงเทวดา", "02:00", "03:00", "AM"));

            listshow.add(new ListShow("03:00 - 03:25", "High Shopping", "03:00", "03:25", "AM"));

            listshow.add(new ListShow("03:25 - 04:15", "คดีสีชมพู", "03:25", "04:15", "AM"));

            listshow.add(new ListShow("04:20 - 04:35", "ลูกทุ่งไมค์ทองคำ", "04:20", "04:35", "AM"));

            listshow.add(new ListShow("04:35 - 05:00", "High Shopping", "04:35", "05:00", "AM"));

            listshow.add(new ListShow("05:00 - 09:00", "ข่าวเวิร์คพอยท์", "05:00", "09:00", "AM"));

            listshow.add(new ListShow("09:00 - 09:30", "พ่อบ้านงานเข้า", "09:00", "09:30", "AM"));

            listshow.add(new ListShow("09:30 - 10:20", "นักร้องสองไมค์", "09:30", "10:20", "AM"));

            listshow.add(new ListShow("10:30 - 11:00", "ก่อนบ่ายคลายเครียด", "10:30", "11:00", "AM"));

            listshow.add(new ListShow("11:00 - 12:00", "ข่าวเวิร์คพอยท์", "11:00", "12:00", "AM"));

            listshow.add(new ListShow("12:00 - 01:00", "ชิงร้อยชิงล้าน ว้าว ว้าว ว้าว", "12:00", "01:00", "PM"));

            listshow.add(new ListShow("01:15 - 02:00", "ปัญญา ปันสุข", "01:15", "02:00", "PM"));

            listshow.add(new ListShow("02:15 - 03:15", "SUPER 10 ซูเปอร์เท็น", "02:15", "03:15", "PM"));

            listshow.add(new ListShow("03:30 - 03:50", "กินได้ก็กิน", "03:30", "03:50", "PM"));

            listshow.add(new ListShow("04:00 - 04:45", "ชิงร้อยชิงล้าน ว้าว ว้าว ว้าว", "04:00", "04:45", "PM"));

            listshow.add(new ListShow("04:45 - 06:00", "บรรจงชงข่าว", "04:45", "06:00", "PM"));

            listshow.add(new ListShow("06:00 - 07:00", "ไมค์หมดหนี้ นักร้องนำโชค", "06:00", "07:00", "PM"));

            listshow.add(new ListShow("07:00 - 08:00", "ปัญญา ปันสุข", "07:00", "08:00", "PM"));

            listshow.add(new ListShow("08:00 - 08:15", "ข่าวในพระราชสำนัก", "08:00", "08:15", "PM"));

            listshow.add(new ListShow("08:15 - 09:30", "4EVE Girl Group Star", "08:15", "09:30", "PM"));

            listshow.add(new ListShow("09:30 - 10:30", "ชิงร้อยชิงล้าน ว้าว ว้าว ว้าว", "09:30", "10:30", "PM"));

            listshow.add(new ListShow("10:30 - 11:30", "สดจากที่จริง", "10:30", "11:30", "PM"));

            listshow.add(new ListShow("11:30 - 11:40", "High Shopping", "11:30", "11:40", "PM"));

            listshow.add(new ListShow("11:40 - 12:00", "ลูกทุ่งไมค์ทองคำ", "11:40", "12:00", "PM"));

            mList = findViewById(R.id.list);
            mList.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(this);
            mAdapter = new MyAdapter(listshow);
            mList.setAdapter(mAdapter);

            for(ListShow object : listshow){
                if(time.contains(object.getAM()) && time.compareTo(object.getTimeStart()) > 0){
                    txt_show.setText("" + object.getShow() );
                    txt_now_show.setText("ทุกวันจันทร์" + " " + object.getTime()  + " " + object.getAM());
                }
            }

/*
            for(ListShow object : listshow){
                if(time.contains(object.getAM()) && time.compareTo(object.getTimeStart()) > 0){
                    if ((time.compareTo(object.getTimeStart()) > 0)){
                        txt_show.setText("" + object.getShow());
                        txt_now_show.setText("ทุกวันจันทร์" + " " + object.getTime()  + " " + object.getAM());
                        continue;
                    }
                    else if (time.compareTo(object.getTimeStart()) == 0){
                        txt_show.setText("" + object.getShow() + " ");
                        txt_now_show.setText("ทุกวันจันทร์" + " " + object.getTime()  + " " + object.getAM());
                        continue;
                    }
                    else if (time.compareTo(object.getTimeStart()) < 0){
                        txt_show.setText("" + object.getShow());
                        txt_now_show.setText("ทุกวันจันทร์" + " " + object.getTime()  + " " + object.getAM());
                        continue;
                    }
                }

            }

 */


        }
        else if (dateTime.contentEquals("Tuesday") || dateTime.contains("อังคาร")) {
            //วันอังคาร
            ArrayList<ListShow> listshow = new ArrayList<>();

            listshow.add(new ListShow("00:25 - 01:35", "ชิงร้อยชิงล้าน ว้าว ว้าว ว้าว", "12:25:AM", "01:35", "AM"));
            listshow.add(new ListShow("01:35 - 02:00", "High Shopping", "01:35", "02:00", "AM"));
            listshow.add(new ListShow("02:00 - 03:00", "เวทีทอง", "02:00", "03:00", "AM"));
            listshow.add(new ListShow("03:00 - 03:25", "High Shopping", "03:00", "03:25", "AM"));
            listshow.add(new ListShow("03:25 - 04:15", "หน้ากากนางเอก", "03:25", "04:15", "AM"));
            listshow.add(new ListShow("04:20 - 04:35", "ลูกทุ่งไมค์ทองคำ", "04:20", "04:35", "AM"));
            listshow.add(new ListShow("04:35 - 05:00", "High Shopping", "04:35", "05:00", "AM"));
            listshow.add(new ListShow("05:00 - 09:00", "ข่าวเวิร์คพอยท์", "05:00", "09:00", "AM"));
            listshow.add(new ListShow("09:00 - 09:30", "พ่อบ้านงานเข้า", "09:00", "09:30", "AM"));
            listshow.add(new ListShow("09:30 - 10:20", "นักร้องสองไมค์", "09:00", "09:30", "AM"));
            listshow.add(new ListShow("10:30 - 11:00", "ก่อนบ่ายคลายเครียด", "10:30", "11:00", "AM"));
            listshow.add(new ListShow("11:00 - 12:00", "ข่าวเวิร์คพอยท์", "11:00", "12:00", "AM"));
            listshow.add(new ListShow("12:00 - 01:00", "ชิงร้อยชิงล้าน ว้าว ว้าว ว้าว", "12:00:PM", "01:00", "PM"));
            listshow.add(new ListShow("01:15 - 02:00", "ปัญญา ปันสุข", "01:15", "02:00", "PM"));
            listshow.add(new ListShow("02:15 - 03:15", "SUPER100 อัจฉริยะเกินร้อย", "02:15", "03:15", "PM"));
            listshow.add(new ListShow("03:30 - 04:00", "COOKING GURU", "03:30", "4:00", "PM"));
            listshow.add(new ListShow("04:00 - 04:45", "ชิงร้อยชิงล้าน ว้าว ว้าว ว้าว", "04:00", "04:45", "PM"));
            listshow.add(new ListShow("04:45 - 06:00", "บรรจงชงข่าว", "04:45", "06:00", "PM"));
            listshow.add(new ListShow("06:00 - 07:00", "ไมค์หมดหนี้ นักร้องนำโชค", "06:00", "07:00", "PM"));
            listshow.add(new ListShow("07:00 - 08:00", "ปัญญา ปันสุข", "07:00", "08:00", "PM"));
            listshow.add(new ListShow("08:00 - 08:15", "ข่าวในพระราชสำนัก", "08:00", "08:15", "PM"));
            listshow.add(new ListShow("08:15 - 09:15", "ยืนหนึ่ง", "08:15", "09:15", "PM"));
            listshow.add(new ListShow("09:15 - 10:30", "ซูเปอร์หม่ำ", "09:15", "10:30", "PM"));
            listshow.add(new ListShow("10:30 - 11:30", "สดจากที่จริง", "10:30", "11:30", "PM"));
            listshow.add(new ListShow("11:30 - 11:40", "High Shopping", "11:30", "11:40", "PM"));
            listshow.add(new ListShow("11:40 - 12:00", "ลูกทุ่งไมค์ทองคำ", "11:40", "12:00", "PM"));

            //txt_show.setText(""+object.getShow());
            //txt_now_show.setText("ทุกวันจันทร์"+ " "+object.getTime()+" น." );

            mList = findViewById(R.id.list);
            mList.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(this);
            mAdapter = new MyAdapter(listshow);
            mList.setAdapter(mAdapter);


            for(ListShow object : listshow){
                if(time.contains(object.getAM()) && time.compareTo(object.getTimeStart()) > 0){
                    txt_show.setText("" + object.getShow() );
                    txt_now_show.setText("ทุกวันอังคาร" + " " + object.getTime()  + " " + object.getAM());
                }
            }

        }
        else if (dateTime.contentEquals("Wednesday") || dateTime.contains("พุธ")) {
//วันพุธ
            ArrayList<ListShow> listshow = new ArrayList<>();
            listshow.add(new ListShow("00:00 - 00:25", "High Shopping", "12:00:AM", "12:25:AM", "AM"));
            listshow.add(new ListShow("00:25 - 01:35", "ชิงร้อยชิงล้าน ว้าว ว้าว ว้าว", "12:25:AM", "01:35", "AM"));
            listshow.add(new ListShow("01:35 - 02:00", "High Shopping", "01:35", "02:00", "AM"));
            listshow.add(new ListShow("02:00 - 03:00", "ยืนหนึ่ง", "02:00", "03:00", "AM"));
            listshow.add(new ListShow("03:00 - 03:25", "High Shopping", "03:00", "03:25", "AM"));
            listshow.add(new ListShow("03:25 - 04:15", "แรงชัง", "03:25", "04:15", "AM"));
            listshow.add(new ListShow("04:20 - 04:35", "ลูกทุ่งไมค์ทองคำ", "04:20", "04:35", "AM"));
            listshow.add(new ListShow("04:35 - 05:00", "High Shopping", "04:35", "05:00", "AM"));
            listshow.add(new ListShow("05:00 - 09:00", "ข่าวเวิร์คพอยท์", "05:00", "09:00", "AM"));
            listshow.add(new ListShow("09:00 - 09:30", "พ่อบ้านงานเข้า", "09:00", "09:30", "AM"));
            listshow.add(new ListShow("09:30 - 10:20", "นักร้องสองไมค์", "09:30", "10:20", "AM"));
            listshow.add(new ListShow("10:30 - 11:00", "ก่อนบ่ายคลายเครียด", "10:30", "11:00", "AM"));
            listshow.add(new ListShow("11:00 - 12:00", "ข่าวเวิร์คพอยท์", "11:00", "12:00", "AM"));
            listshow.add(new ListShow("12:00 - 01:00", "ชิงร้อยชิงล้าน ว้าว ว้าว ว้าว", "12:00:PM", "01:00", "PM"));
            listshow.add(new ListShow("01:15 - 02:00", "ปัญญา ปันสุข", "01:15", "02:00", "PM"));
            listshow.add(new ListShow("02:15 - 03:15", "ยืนหนึ่ง", "02:15", "03:15", "PM"));
            listshow.add(new ListShow("03:30 - 04:00", "Food Fight ศึกครัวเดียวกัน", "03:30", "04:00", "PM"));
            listshow.add(new ListShow("04:00 - 04:45", "ชิงร้อยชิงล้าน ว้าว ว้าว ว้าว", "04:00", "04:45", "PM"));
            listshow.add(new ListShow("04:45 - 06:00", "บรรจงชงข่าว", "04:45", "06:00", "PM"));
            listshow.add(new ListShow("06:00 - 07:00", "ไมค์หมดหนี้ นักร้องนำโชค", "06:00", "07:00", "PM"));
            listshow.add(new ListShow("07:00 - 08:00", "ปัญญา ปันสุข", "07:00", "08:00", "PM"));
            listshow.add(new ListShow("08:00 - 08:15", "ข่าวในพระราชสำนัก", "08:00", "08:15", "PM"));
            listshow.add(new ListShow("08:15 - 09:45", "I can see your voice thailand", "08:15", "09:45", "PM"));
            listshow.add(new ListShow("09:45 - 10:30", "คนอวดผี", "09:45", "10:30", "PM"));
            listshow.add(new ListShow("10:30 - 11:30", "ชสดจากที่จริง", "10:30", "11:30", "PM"));
            listshow.add(new ListShow("11:30 - 11:40", "High Shopping", "11:30", "11:40", "PM"));
            listshow.add(new ListShow("11:40 - 12:00", "ลูกทุ่งไมค์ทองคำ", "11:40:PM", "12:40:AM", "PM"));

            mList = findViewById(R.id.list);
            mList.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(this);
            mAdapter = new MyAdapter(listshow);
            mList.setAdapter(mAdapter);

            for(ListShow object : listshow){
                if(time.contains(object.getAM()) && time.compareTo(object.getTimeStart()) > 0){
                    txt_show.setText("" + object.getShow() );
                    txt_now_show.setText("ทุกวันพุธ" + " " + object.getTime()  + " " + object.getAM());
                }
                /*
                else if(object.getAM().contentEquals("AM") && time.compareTo(object.getTimeStart()) > 0){
                    txt_show.setText("" + object.getShow() );
                    txt_now_show.setText("ทุกวันพุธ" + " " + object.getTime()  + " " + object.getAM());
                }
                else if(object.getAM().contentEquals("PM") && time.compareTo(object.getTimeStart()) > 0){
                    txt_show.setText("" + object.getShow() );
                    txt_now_show.setText("ทุกวันพุธ" + " " + object.getTime()  + " " + object.getAM());
                }

                 */
            }

        }
        else if (dateTime.contentEquals("Thursday")|| dateTime.contains("พฤหัสบดี")) {
            //วันพฤหัส
            ArrayList<ListShow> listshow = new ArrayList<>();
            listshow.add(new ListShow("00:25 - 01:35", "ชิงร้อยชิงล้าน ว้าว ว้าว ว้าว", "12:25:AM", "01:35", "AM"));
            listshow.add(new ListShow("01:35 - 02:00", "High Shopping", "01:35", "02:00", "AM"));
            listshow.add(new ListShow("02:00 - 03:00", "ซูเปอร์หม่ำ", "02:00", "03:00", "AM"));
            listshow.add(new ListShow("03:00 - 03:25", "High Shopping", "03:00", "03:25", "AM"));
            listshow.add(new ListShow("03:25 - 04:15", "ยุทธการสลัดนอ", "03:25", "04:15", "AM"));
            listshow.add(new ListShow("04:15 - 04:35", "ลูกทุ่งไมค์ทองคำ", "04:15", "04:35", "AM"));
            listshow.add(new ListShow("04:35 - 05:00", "High Shopping", "04:35", "05:00", "AM"));
            listshow.add(new ListShow("05:00 - 09:00", "ข่าวเวิร์คพอยท์", "05:00", "09:00", "AM"));
            listshow.add(new ListShow("09:00 - 09:30", "พ่อบ้านงานเข้า", "09:00", "09:30", "AM"));
            listshow.add(new ListShow("09:30 - 10:20", "นักร้องสองไมค์", "09:30", "10:20", "AM"));
            listshow.add(new ListShow("11:00 - 12:00", "ข่าวเวิร์คพอยท์", "11:00", "12:00", "AM"));
            listshow.add(new ListShow("12:00 - 01:00", "ชิงร้อยชิงล้าน ว้าว ว้าว ว้าว", "12:00:PM", "01:00", "PM"));
            listshow.add(new ListShow("01:15 - 02:00", "ปัญญา ปันสุข", "01:15", "02:00", "PM"));
            listshow.add(new ListShow("02:15 - 03:15", "ซูเปอร์หม่ำ", "02:15", "03:15", "PM"));
            listshow.add(new ListShow("03:30 - 04:00", "อดเปรี้ยวกินหวาน", "03:30", "04:00", "PM"));
            listshow.add(new ListShow("04:00 - 04:45", "ชิงร้อยชิงล้าน ว้าว ว้าว ว้าว", "04:00", "04:45", "PM"));
            listshow.add(new ListShow("04:45 - 06:00", "บรรจงชงข่าว", "04:45", "06:00", "PM"));
            listshow.add(new ListShow("06:00 - 07:00", "ไมค์หมดหนี้ นักร้องนำโชค", "06:00", "07:00", "PM"));
            listshow.add(new ListShow("07:00 - 08:00", "ปัญญา ปันสุข", "07:00", "08:00", "PM"));
            listshow.add(new ListShow("08:00 - 08:15", "ข่าวในพระราชสำนัก", "08:00", "08:15", "PM"));
            listshow.add(new ListShow("08:15 - 09:45", "THE MASK ลูกไทย", "08:15", "09:45", "PM"));
            listshow.add(new ListShow("09:45 - 10:30", "ปากสว่าง", "09:45", "10:30", "PM"));
            listshow.add(new ListShow("10:30 - 11:30", "สดจากที่จริง", "10:30", "11:30", "PM"));
            listshow.add(new ListShow("11:30 - 11:40", "High Shopping", "11:30", "11:40", "PM"));
            listshow.add(new ListShow("11:40 - 12:00", "ลูกทุ่งไมค์ทองคำ", "11:40:PM", "12:00", "PM"));

            mList = findViewById(R.id.list);
            mList.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(this);
            mAdapter = new MyAdapter(listshow);
            mList.setAdapter(mAdapter);

            for(ListShow object : listshow){
                if(time.contains(object.getAM()) && time.compareTo(object.getTimeStart()) > 0){
                    txt_show.setText("" + object.getShow() );
                    txt_now_show.setText("ทุกวันพฤหัสบดี" + " " + object.getTime()  + " " + object.getAM());
                }
                /*
                else if(object.getAM().contentEquals("AM") && time.compareTo(object.getTimeStart()) > 0){
                    txt_show.setText("" + object.getShow() );
                    txt_now_show.setText("ทุกวันพฤหัสบดี" + " " + object.getTime()  + " " + object.getAM());
                }
                else if(object.getAM().contentEquals("PM") && time.compareTo(object.getTimeStart()) > 0){
                    txt_show.setText("" + object.getShow() );
                    txt_now_show.setText("ทุกวันพฤหัสบดี" + " " + object.getTime()  + " " + object.getAM());
                }

                 */
            }
        }
        else if (dateTime.contentEquals("Friday")|| dateTime.contains("ศุกร์")) {
//วันศุกร์
            ArrayList<ListShow> listshow = new ArrayList<>();
            listshow.add(new ListShow("00:25 - 01:35", "ชิงร้อยชิงล้าน ว้าว ว้าว ว้าว", "12:25:AM", "01:35", "AM"));
            listshow.add(new ListShow("01:35 - 02:00", "High Shopping", "01:35", "02:00", "AM"));
            listshow.add(new ListShow("02:00 - 03:00", "หกฉากครับจารย์", "02:00", "03:00", "AM"));
            listshow.add(new ListShow("03:00 - 03:25", "High Shopping", "03:00", "03:25", "AM"));
            listshow.add(new ListShow("03:25 - 04:20", "เกมริษยา", "03:25", "04:20", "AM"));
            listshow.add(new ListShow("04:20 - 04:35", "ลูกทุ่งไมค์ทองคำ", "04:20", "04:35", "AM"));
            listshow.add(new ListShow("04:35 - 05:00", "High Shopping", "04:35", "05:00", "AM"));
            listshow.add(new ListShow("05:00 - 09:00", "ข่าวเวิร์คพอยท์", "05:00", "09:00", "AM"));
            listshow.add(new ListShow("09:00 - 09:30", "พ่อบ้านงานเข้า", "09:00", "09:30", "AM"));
            listshow.add(new ListShow("09:30 - 10:20", "นักร้องสองไมค์", "09:30", "10:20", "AM"));
            listshow.add(new ListShow("10:30 - 11:00", "ก่อนบ่ายคลายเครียด", "10:30", "11:00", "AM"));
            listshow.add(new ListShow("11:00 - 12:00", "ข่าวเวิร์คพอยท์", "11:00", "12:00", "AM"));
            listshow.add(new ListShow("12:00 - 01:00", "ชิงร้อยชิงล้าน ว้าว ว้าว ว้าว", "12:00:PM", "01:00", "PM"));
            listshow.add(new ListShow("01:15 - 02:00", "ปัญญา ปันสุข", "01:15", "02:00", "PM"));
            listshow.add(new ListShow("02:15 - 03:15", "เพลงเอก", "02:15", "03:15", "PM"));
            listshow.add(new ListShow("03:30 - 04:00", "เต็มปาก เต็มคำ", "03:30", "04:00", "PM"));
            listshow.add(new ListShow("04:00 - 04:45", "ชิงร้อยชิงล้าน ว้าว ว้าว ว้าว", "04:00", "04:45", "PM"));
            listshow.add(new ListShow("04:45 - 06:00", "บรรจงชงข่าว", "04:45", "06:00", "PM"));
            listshow.add(new ListShow("06:00 - 07:00", "ไมค์หมดหนี้ นักร้องนำโชค", "06:00", "07:00", "PM"));
            listshow.add(new ListShow("07:00 - 08:00", "ปัญญา ปันสุข", "07:00", "08:00", "PM"));
            listshow.add(new ListShow("08:00 - 08:15", "ข่าวในพระราชสำนัก", "08:00", "08:15", "PM"));
            listshow.add(new ListShow("08:15 - 09:15", "โต๊ะนี้มีจอง (WHO IS MY CHEF)", "08:15", "09:15", "PM"));
            listshow.add(new ListShow("09:15 - 10:15", "หกฉากครับจารย์", "09:15", "10:15", "PM"));
            listshow.add(new ListShow("10:15 - 11:30", "ความจริงติ่งข่าว", "10:15", "11:30", "PM"));
            listshow.add(new ListShow("11:30 - 11:40", "High Shopping", "11:30", "11:40", "PM"));
            listshow.add(new ListShow("11:40 - 12:00", "ลูกทุ่งไมค์ทองคำ", "11:40:PM", "12:00", "PM"));

            mList = findViewById(R.id.list);
            mList.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(this);
            mAdapter = new MyAdapter(listshow);
            mList.setAdapter(mAdapter);

            for(ListShow object : listshow){
                if(time.contains(object.getAM()) && time.compareTo(object.getTimeStart()) > 0){
                    txt_show.setText("" + object.getShow() );
                    txt_now_show.setText("ทุกวันศุกร์" + " " + object.getTime()  + " " + object.getAM());
                }
            }


        }
        else if (dateTime.contentEquals("Saturday")|| dateTime.contains("เสาร์")) {
            //วันเสาร์
            ArrayList<ListShow> listshow = new ArrayList<>();
            listshow.add(new ListShow("00:25 - 01:35", "ชิงร้อยชิงล้าน ว้าว ว้าว ว้าว", "12:25:AM", "01:35", "AM"));
            listshow.add(new ListShow("01:35 - 02:00", "High Shopping", "01:35", "02:00", "AM"));
            listshow.add(new ListShow("02:00 - 03:00", "จำอวดหน้าจอ", "02:00", "03:00", "AM"));
            listshow.add(new ListShow("03:00 - 03:25", "High Shopping", "03:00", "03:25", "AM"));
            listshow.add(new ListShow("03:25 - 04:15", "7 วันจองเวร 2", "03:25", "04:15", "AM"));
            listshow.add(new ListShow("04:15 - 04:35", "ลูกทุ่งไมค์ทองคำ", "04:15", "04:35", "AM"));
            listshow.add(new ListShow("04:35 - 05:00", "High Shopping", "04:35", "05:00", "AM"));
            listshow.add(new ListShow("05:00 - 08:40", "ข่าวเวิร์คพอยท์", "05:00", "08:40", "AM"));
            listshow.add(new ListShow("08:40 - 09:10", "หนีเที่ยวกัน", "08:40", "09:10", "AM"));
            listshow.add(new ListShow("09:10 - 10:00", "อายุน้อย ร้อยล้าน", "09:10", "10:00", "AM"));
            listshow.add(new ListShow("10:00 - 10:45", "Lady Plaza", "10:00", "10:45", "AM"));
            listshow.add(new ListShow("10:45 - 11:15", "นักร้องสองไมค์", "10:45", "11:15", "AM"));
            listshow.add(new ListShow("11:15 - 12:15", "ตลก 6 ฉาก", "11:15", "12:15", "AM"));
            listshow.add(new ListShow("12:15 - 01:15", "123 Ranking Show", "12:15:PM", "01:15", "PM"));
            listshow.add(new ListShow("01:15 - 02:15", "โต๊ะนี้มีจอง (WHO IS MY CHEF)", "01:15", "02:15", "PM"));
            listshow.add(new ListShow("02:15 - 02:45", "The Big Kitchen เดอะบิ๊ก คิทเช่น", "02:15", "02:45", "PM"));
            listshow.add(new ListShow("02:45 - 04:00", "ซูเปอร์หม่ำ", "02:45", "04:00", "PM"));
            listshow.add(new ListShow("04:00 - 04:45", "ชงข่าววันเสาร์", "04:00", "04:45", "PM"));
            listshow.add(new ListShow("04:50 - 05:50", "SUPER 10 ซูเปอร์เท็น", "04:50", "05:50", "PM"));
            listshow.add(new ListShow("06:00 - 08:00", "ไมค์ทองคำ 3 ฤดู", "06:00", "08:00", "PM"));
            listshow.add(new ListShow("08:00 - 08:15", "ข่าวในพระราชสำนัก", "08:00", "08:15", "PM"));
            listshow.add(new ListShow("08:15 - 09:15", "เพลงเอก", "08:15", "09:15", "PM"));
            listshow.add(new ListShow("09:25 - 11:00", "I Can See Your Voice Thailand", "09:25", "11:00", "PM"));
            listshow.add(new ListShow("11:40 - 12:00", "4EVE Girl Group Star", "11:40:PM", "12:00", "PM"));

            mList = findViewById(R.id.list);
            mList.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(this);
            mAdapter = new MyAdapter(listshow);
            mList.setAdapter(mAdapter);

            for(ListShow object : listshow){
                if(time.contains(object.getAM()) && time.compareTo(object.getTimeStart()) > 0){
                    txt_show.setText("" + object.getShow() );
                    txt_now_show.setText("ทุกวันเสาร์" + " " + object.getTime()  + " " + object.getAM());
                }
            }


        }
        else if (dateTime.contentEquals("Sunday")|| dateTime.contains("อาทิตย์")) {
            //วันเอาทิตย์
            ArrayList<ListShow> listshow = new ArrayList<>();

            listshow.add(new ListShow("00:25 - 01:20", "พระพุทธเจ้ามหาศาสดาโลก", "12:25:AM", "01:20", "AM"));
            listshow.add(new ListShow("01:20 - 01:35", "ตลก6ฉาก", "01:20", "01:35", "AM"));
            listshow.add(new ListShow("01:35 - 02:00", "High Shopping", "01:35", "02:00", "AM"));
            listshow.add(new ListShow("02:00 - 03:00", "ไซอิ๋ว อภินิหารลิงเทวดา", "02:00", "03:00", "AM"));
            listshow.add(new ListShow("03:00 - 03:25", "High Shopping", "03:00", "03:25", "AM"));
            listshow.add(new ListShow("03:25 - 04:20", "จ่าเริง เซิ้งยับ", "03:25", "04:20", "AM"));
            listshow.add(new ListShow("04:20 - 04:35", "ลูกทุ่งไมค์ทองคำ", "04:20", "04:35", "AM"));
            listshow.add(new ListShow("04:35 - 05:00", "High Shopping", "04:35", "05:00", "AM"));
            listshow.add(new ListShow("05:00 - 08:00", "ข่าวเวิร์คพอยท์", "05:00", "08:00", "AM"));
            listshow.add(new ListShow("08:00 - 08:30", "ณัชชา แอนด์ เดอะแก๊ง", "08:00", "08:30", "AM"));
            listshow.add(new ListShow("08:30 - 09:00", "ร้านเด็ดประเทศไทย", "08:30", "09:00", "AM"));
            listshow.add(new ListShow("09:00 - 10:00", "คุณพระช่วย", "09:00", "10:00", "AM"));
            listshow.add(new ListShow("10:00 - 10:45", "Lady Plaza", "10:00", "10:45", "AM"));
            listshow.add(new ListShow("10:45 - 11:15", "นักร้องสองไมค์", "10:45", "11:15", "AM"));
            listshow.add(new ListShow("11:15 - 12:15", "หกฉากครับจารย์", "11:15", "12:15", "AM"));
            listshow.add(new ListShow("12:15 - 01:15", "ระเบิดเถิดเทิงซอยข้าใครอย่าแตะ", "12:15:PM", "01:15", "PM"));
            listshow.add(new ListShow("01:15 - 02:15", "เวทีทอง", "01:15", "02:15", "PM"));
            listshow.add(new ListShow("02:15 - 03:45", "ชิงร้อยชิงล้าน ว้าว ว้าว ว้าว", "02:15", "03:45", "PM"));
            listshow.add(new ListShow("03:45 - 04:50", "จำอวดหน้าจอ", "03:45", "04:50", "PM"));
            listshow.add(new ListShow("04:50 - 06:00", "SUPER100 อัจฉริยะเกินร้อย", "04:50", "06:00", "PM"));
            listshow.add(new ListShow("06:00 - 08:00", "เพชรตัดเพชร ศึก 300", "06:00", "08:00", "PM"));
            listshow.add(new ListShow("08:00 - 08:15", "ข่าวในพระราชสำนัก", "08:00", "08:15", "PM"));
            listshow.add(new ListShow("08:15 - 09:30", "นักร้องสองไมค์", "08:15", "09:30", "PM"));
            listshow.add(new ListShow("09:30 - 11:00", "The Mask ลูกไทย", "09:30", "11:00", "PM"));
            listshow.add(new ListShow("11:00 - 12:00", "เวทีทอง", "11:00", "12:00", "PM"));
            mList = findViewById(R.id.list);
            mList.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(this);
            mAdapter = new MyAdapter(listshow);
            mList.setAdapter(mAdapter);

            for(ListShow object : listshow){
                if(time.contains(object.getAM()) && time.compareTo(object.getTimeStart()) > 0){
                    txt_show.setText("" + object.getShow() );
                    txt_now_show.setText("ทุกวันเสาร์" + " " + object.getTime()  + " " + object.getAM());
                }
            }

        }
    }
    public void openActivity2(){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }
}