
package com.wth.testapp.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "activities",
    "calories",
    "regeneration",
    "sleep",
    "steps",
    "stress",
    "water"
})
public class Person implements Cloneable{
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

    private double BMI;
    private int age;
    private boolean isSleepGoalReached;
    private boolean isStepGoalReached;
    private boolean isCaloriGoalReached;
    private boolean isOverallReached;
    private String status;

    private int weeklyAverageStep;
    private int weeklyAverageCalori;
    private  int weeklyAvarageSleep;



    public boolean isStepGoalReached() {
        return isStepGoalReached;
    }



    public double getBMI() {
        BMI = (weight*weight)/(height/100);
        return BMI;
    }

    public void setBMI(double BMI) {
        this.BMI = BMI;
    }

    public int getAge() {
        return 2018-Integer.parseInt(dateOfBirth.substring(0,3));
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSleepGoalReached() {
        Random random = new Random();
        int rNumber = random.nextInt(6);
        rNumber = rNumber + 5;
        double sleep = Integer.parseInt(sleepGoalEnd.substring(0,1)) + 24 - Integer.parseInt(sleepGoalStart.substring(0,1));

        if(sleep<rNumber){
            return  false;
        }else{
            return true;
        }
    }

    public void setSleepGoalReached(boolean sleepGoalReached) {
        isSleepGoalReached = sleepGoalReached;
    }

    public boolean isStepGoalReached(int i) {

        if(getTotalStep(i)>stepsGoal){
            return true;
        }
        else{
            return false;
        }
    }

    public void setStepGoalReached(boolean stepGoalReached) {
        isStepGoalReached = stepGoalReached;
    }

    public boolean isCaloriGoalReached(int i) {
        if(getTotalCalori(i)>caloriesGoal){
            return true;
        }
        else{
            return false;
        }
    }

    public void setCaloriGoalReached(boolean caloriGoalReached) {
        isCaloriGoalReached = caloriGoalReached;
    }

    public boolean isOverallReached(int i) {
        if(isCaloriGoalReached(i)&&isSleepGoalReached&&isStepGoalReached(i)){
            return true;
        }else{
          return  false;
        }
    }

    public void setOverallReached(boolean overallReached) {
        isOverallReached = overallReached;
    }

    public String getStatus() {
        String result = "";
        int sleepStatus = 0;
        int stepStatus = 0;
        int caloriStatus = 0;
        int overviewStatus = 0;
        for(int i=0; i<7; i++){
            if(isStepGoalReached(i)){
                stepStatus++;
            }
            if(!isSleepGoalReached){
                sleepStatus ++;
            }
            if(isCaloriGoalReached){
                caloriStatus++;
            }
            if(isOverallReached(i)){
                overviewStatus++;
            }
        }
        if(sleepStatus>=5){
            result = result + "Owl";
        }
        if(caloriStatus>=5){
            result = result + "Elephant";
        }
        if(stepStatus>=5){
            result = result + "Rabbit";
        }
        if(overviewStatus>=5){
            result = result + "Lion";
        }
        return result;


    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getWeeklyAverageStep() {
        int total = 0;
        for(int i=0; i<getSteps().size(); i++){
            total = total + getTotalStep(i);
        }
        return total/getSteps().size();
    }

    public void setWeeklyAverageStep(int averageStep) {
        this.weeklyAverageStep = averageStep;
    }

    public int getWeeklyAverageCalori() {
        int total = 0;
        for(int i=0; i<getCalories().size(); i++){
            total = total + getTotalCalori(i);
        }
        return total/getCalories().size();
    }

    public void setWeeklyAverageCalori(int averageCalori) {
        this.weeklyAverageCalori = averageCalori;
    }

    public int getWeeklyAvarageSleep() {
        Random random = new Random();
        int sleepTime = random.nextInt(55);
        sleepTime = sleepTime + 25;
        return sleepTime;
    }

    public void setWeeklyAvarageSleep(int avarageSleep) {
        this.weeklyAvarageSleep = avarageSleep;
    }

    public int getTotalStep(int i) {
        List dailySteps = steps.get(i).getValues();
        int tStep = 0;
        for(int j=0; j<dailySteps.size(); j++){
            tStep = tStep + (int)dailySteps.get(j);
        }
        return tStep;
    }

    public void setTotalStep(int totalStep) {
            this.totalStep = totalStep;
    }

    public int getTotalSleep() {
        return totalSleep;
    }

    public void setTotalSleep(int totalSleep) {
        this.totalSleep = totalSleep;
    }

    public int getTotalCalori(int i) {
        List dailyCalories = steps.get(i).getValues();
        int tCalories = 0;
        for(int j=0; j<dailyCalories.size(); j++){
            tCalories = tCalories + (int)dailyCalories.get(j);
        }
        return tCalories;
    }

    public void setTotalCalori(int totalCalori) {
        this.totalCalori = totalCalori;
    }

    public static Person getTempPerson() {
        return tempPerson;
    }

    public static void setTempPerson(Person tempPerson) {
        Person.tempPerson = tempPerson;
    }


    private int totalStep;
    private int totalSleep;
    private int totalCalori;




    private static Person tempPerson = new Person();



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



    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("activities")
    private List<Object> activities = null;
    @JsonProperty("calories")
    private List<Calory> calories = null;
    @JsonProperty("regeneration")
    private List<Regeneration> regeneration = null;
    @JsonProperty("sleep")
    private List<Object> sleep = null;
    @JsonProperty("steps")
    private List<Step> steps = null;
    @JsonProperty("stress")
    private List<Stress> stress = null;
    @JsonProperty("water")
    private List<Object> water = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("activities")
    public List<Object> getActivities() {
        return activities;
    }

    @JsonProperty("activities")
    public void setActivities(List<Object> activities) {
        this.activities = activities;
    }

    @JsonProperty("calories")
    public List<Calory> getCalories() {
        return calories;
    }

    @JsonProperty("calories")
    public void setCalories(List<Calory> calories) {
        this.calories = calories;
    }

    @JsonProperty("regeneration")
    public List<Regeneration> getRegeneration() {
        return regeneration;
    }

    @JsonProperty("regeneration")
    public void setRegeneration(List<Regeneration> regeneration) {
        this.regeneration = regeneration;
    }

    @JsonProperty("sleep")
    public List<Object> getSleep() {
        return sleep;
    }

    @JsonProperty("sleep")
    public void setSleep(List<Object> sleep) {
        this.sleep = sleep;
    }

    @JsonProperty("steps")
    public List<Step> getSteps() {
        return steps;
    }

    @JsonProperty("steps")
    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    @JsonProperty("stress")
    public List<Stress> getStress() {
        return stress;
    }

    @JsonProperty("stress")
    public void setStress(List<Stress> stress) {
        this.stress = stress;
    }

    @JsonProperty("water")
    public List<Object> getWater() {
        return water;
    }

    @JsonProperty("water")
    public void setWater(List<Object> water) {
        this.water = water;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }



}
