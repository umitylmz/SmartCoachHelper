package com.wth.testapp.Model;

public class PersonOverview {
    private int id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private double weight;
    private double height;
    private String gender;
    private String userMission;
    private String sleepGoalStart;
    private String sleepGoalEnd;
    private int stepsGoal;
    private int caloriesGoal;




    @Override
    public String toString() {
        if(firstName==null) return "Null";
        return firstName+" "+lastName;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserMission() {
        return userMission;
    }

    public void setUserMission(String userMission) {
        this.userMission = userMission;
    }

    public String getSleepGoalStart() {
        return sleepGoalStart;
    }

    public void setSleepGoalStart(String sleepGoalStart) {
        this.sleepGoalStart = sleepGoalStart;
    }

    public String getSleepGoalEnd() {
        return sleepGoalEnd;
    }

    public void setSleepGoalEnd(String sleepGoalEnd) {
        this.sleepGoalEnd = sleepGoalEnd;
    }

    public int getStepsGoal() {
        return stepsGoal;
    }

    public void setStepsGoal(int stepsGoal) {
        this.stepsGoal = stepsGoal;
    }

    public int getCaloriesGoal() {
        return caloriesGoal;
    }

    public void setCaloriesGoal(int caloriesGoal) {
        this.caloriesGoal = caloriesGoal;
    }


}
