package com.wth.testapp;

import android.os.AsyncTask;
import android.util.Log;

import com.wth.testapp.Api.ApiService;
import com.wth.testapp.Api.Client;
import com.wth.testapp.Model.Person;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.wth.testapp.MainActivity.pd;

public class FetchData extends AsyncTask<String, Void, List<Person>> {
    private final MyAdapter adapter;
    public List<String> tokens;
    public List<Person> personList;
    public static final String[] mails = {
            "utanis@viita-concept.com",
            "mtarhan@viita-concept.com",
            "akoroglu@viita-concept.com",
            "scomert@viita-concept.com",
            "ecoskun1@viita-concept.com",
            "esakut@viita-concept.com",
            "ddincer@viita-concept.com",
            "hkocak1@viita-concept.com"
    };

    public FetchData(MyAdapter adapter) {
        this.adapter = adapter;
        tokens =  new ArrayList<>();
    }

    public void generate() {
        personList = new ArrayList<>();
        for (int i = 0; i < mails.length; i++) {
            personList.add(new Person());
            tokens.add("");
        }
        for (int i = 0; i < mails.length; i++) {
            createTokens(i);
        }
        for (int i = 0; i < mails.length; i++) {
            try {
                createPerson(tokens.get(i), i);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void createTokens(final int i) {
        Client client = new Client();
        final ApiService apiService = client.getClient().create(ApiService.class);
        String json = "{\n" +
                "  \"credentials\" : {\n" +
                "    \"identifier\": \"" + mails[i] + "\",\n" +
                "      \"password\":\"12345678\"},\n" +
                "  \n" +
                "  \"deviceCommand\" : {\n" +
                "    \"deviceId\" :\"0\", \n" +
                "    \"deviceType\":\"Android\",\n" +
                "    \"osVersion\":\"10.3.3\",\n" +
                "    \"appVersion\": \"1.0.0\",\n" +
                "    \"model\":\"Note 4\",\n" +
                "    \"language\":\"tr-tr\"\n" +
                "  }\n" +
                "}\n";

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);
        apiService.LoginService(requestBody).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String s = String.valueOf(response.headers().get("x-auth-token"));

                try {
                    Person personOverview = new Person();
                    JSONObject jsonObject = new JSONObject(response.body().string());
                    JSONObject user = jsonObject.getJSONObject("user");
                    personOverview.setId(user.getInt("id"));
                    JSONObject userSettings = jsonObject.getJSONObject("settings").getJSONObject("userSettings");
                    personOverview.setFirstName(userSettings.getString("firstName"));
                    personOverview.setLastName(userSettings.getString("lastName"));
                    personOverview.setDateOfBirth(userSettings.getString("dateOfBirth"));
                    personOverview.setWeight(userSettings.getDouble("weight"));
                    personOverview.setHeight(userSettings.getDouble("height"));
                    personOverview.setGender(userSettings.getString("gender"));
                    personOverview.setUserMission(userSettings.getString("userMission"));
                    personOverview.setSleepGoalStart(userSettings.getString("sleepGoalStart"));
                    personOverview.setSleepGoalEnd(userSettings.getString("sleepGoalEnd"));
                    personOverview.setStepsGoal(userSettings.getInt("stepsGoal"));
                    personOverview.setCaloriesGoal(userSettings.getInt("caloriesGoal"));
                    personList.add(i, personOverview);
                    Log.v("HATA", "04");
//                    createPerson(s, i);
                    tokens.add(s);
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
            Log.v("HATA", "01");
            }

        });


    }

    public void createPerson(String token, final int i) throws IOException {
        if(personList.size()>i){
            Map<String, String> map = new HashMap();
            map.put("X-Auth-Token", token);
            Client client = new Client();
            ApiService apiService = client.getClient().create(ApiService.class);
            Call<Person> calll = apiService.PERSON_CALL(map);
            calll.enqueue(new Callback<Person>() {
                @Override
                public void onResponse(Call<Person> call, Response<Person> response) {
                    try{
                        Person person = response.body();
                        personList.get(i).setActivities(person.getActivities());
                        personList.get(i).setCalories(person.getCalories());
                        personList.get(i).setRegeneration(person.getRegeneration());
                        personList.get(i).setSleep(person.getSleep());
                        personList.get(i).setSteps(person.getSteps());
                        personList.get(i).setWater(person.getWater());
                        personList.get(i).setStress(person.getStress());
                    }
                    catch (Exception e){
                        Log.v("HATA", "03");
                    }
                }
                @Override
                public void onFailure(Call<Person> call, Throwable t) {
                    Log.v("HATA", "02");
                }
            });
        }


    }

    public List<Person> getPersonList() {
        return personList;
    }

    @Override
    protected List<Person> doInBackground(String... strings) {
        generate();
        return personList;
    }

    @Override
    protected void onPostExecute(List<Person> people) {
        super.onPostExecute(people);
        adapter.refreshData(people);
        pd.dismiss();

    }
}
