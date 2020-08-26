package com.example.myworkpoint;

public class ListShow {
    private String mTime;
    private String mShow;
    private String mTimeStart;
    private String mTimeEnd;
    private String mAM;

    public ListShow(String time , String show, String time_start , String time_end, String am){
        mTime = time;
        mShow = show;
        mTimeStart = time_start;
        mTimeEnd = time_end;
        mAM = am;
    }


    public String getTime(){
        return mTime;
    }

    public String getShow(){
        return mShow;
    }

    public String getTimeStart(){
        return mTimeStart;
    }
    public String getTimeEnd(){
        return mTimeEnd;
    }
    public String getAM(){ return mAM; }

}
