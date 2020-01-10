package com.example.foodkatajzia;

public class MemberK {
    private String Resturant;
    private String ResturantComment;
    private Integer RestStar;




    public MemberK() {
    }

    public String getResturantComment() {
        return ResturantComment;
    }
    public Integer getRestStar(){
        return RestStar;
    }
    public String getResturant(){
        return Resturant;
    }

    public void setResturantComment(String resturantComment) {
        ResturantComment = resturantComment;
    }



    public void setResturant(String resturant) {

        Resturant = resturant;
    }
    public void setRestStar(int restStar) {

        RestStar = restStar;
    }

}
