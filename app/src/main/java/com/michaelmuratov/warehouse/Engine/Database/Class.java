package com.michaelmuratov.warehouse.Engine.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


@Entity
public class Class {
    @ColumnInfo(name = "section")
    private String Section;
    //@ColumnInfo(name = "times")
    //private String Times;
    @ColumnInfo(name = "prof")
    private String Prof;
    //@ColumnInfo(name = "locations")
    //private String[] Locations;
    @ColumnInfo(name = "capacity")
    private int Capacity;
    @ColumnInfo(name = "students")
    private int Students;
    @ColumnInfo(name = "type")
    private String Type;

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "first_name")
    private String firstName;

    @ColumnInfo(name = "last_name")
    private String lastName;

    int getUid(){
        return uid;
    }

    void setUid(int uid){
        this.uid = uid;
    }

    String getFirstName(){
        return firstName;
    }

    void setFirstName(String firstName){
        this.firstName = firstName;
    }

    String getLastName(){
        return lastName;
    }

    void setLastName(String lastName){
        this.lastName = firstName;
    }



    public void setSection(String Section){
        this.Section = Section;
    }

    public String getSection() {
        return Section;
    }
    /*
        public void setTime(String[] Times){
            this.Times = Times;
        }

        public String[] getTime(){
            return Times;
        }


        public void setLocations(String[] Locations){
            this.Locations = Locations;
        }

        public String[] getLocations(){
            return Locations;
        }
    */
    public void setProf(String Prof){
        this.Prof = Prof;
    }

    String getProf(){
        return Prof;
    }

    public void setCapacity(int Capacity){
        this.Capacity = Capacity;
    }

    int getCapacity(){
        return Capacity;
    }

    public void setStudents(int Students){
        this.Students = Students;
    }

    int getStudents(){
        return Students;
    }

    public void setType(String Type){
        this.Type = Type;
    }

    public String getType(){
        return Type;
    }

    @Override
    public String toString() {
        long startTime = System.nanoTime();
        StringBuilder builder = new StringBuilder();
        builder.append("Lecture: ").append(Section).append("\n");
        builder.append("Prof: ").append(Prof).append("\n");
        builder.append("Times: ");
        /*for(int i = 0; i < Times.length; i++){
            if(i!=0){
                builder.append("\t\t\t\t\t\t\t");
            }
            builder.append(Times[i]).append("\n");
        }
        builder.append("Locations: ");
        for(int i = 0; i < Locations.length; i++){
            if(i!=0){
                builder.append("\t\t\t\t\t\t\t\t\t\t");
            }
            builder.append(Locations[i]).append("\n");
        }*/
        builder.append("Capacity: ").append(String.valueOf(Capacity)).append("\n");
        builder.append("Students: ").append(String.valueOf(Students)).append("\n");
        builder.append("Type: ").append(Type).append("\n");
        /*
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        Log.d("DURATION",""+duration);
        */
        return  builder.toString();
    }
}
