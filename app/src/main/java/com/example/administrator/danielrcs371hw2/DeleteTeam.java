package com.example.administrator.danielrcs371hw2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Iterator;
import java.util.Map;


public class DeleteTeam extends ActionBarActivity {

    public Button[] teams;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_team);
        viewTeams();

    }
    public void viewTeams()
    {
        teams = new Button[15];

        teams[0] = (Button)this.findViewById(R.id.DT1);
        teams[1] = (Button)this.findViewById(R.id.DT2);
        teams[2] = (Button)this.findViewById(R.id.DT3);
        teams[3] = (Button)this.findViewById(R.id.DT4);
        teams[4] = (Button)this.findViewById(R.id.DT5);
        teams[5] = (Button)this.findViewById(R.id.DT6);
        teams[6] = (Button)this.findViewById(R.id.DT7);
        teams[7] = (Button)this.findViewById(R.id.DT8);
        teams[8] = (Button)this.findViewById(R.id.DT9);
        teams[9] = (Button)this.findViewById(R.id.DT10);
        teams[10] = (Button)this.findViewById(R.id.DT11);
        teams[11] = (Button)this.findViewById(R.id.DT12);
        teams[12] = (Button)this.findViewById(R.id.DT13);
        teams[13] = (Button)this.findViewById(R.id.DT14);
        teams[14] = (Button)this.findViewById(R.id.DT15);

        MainActivity.TeamData.viewTeams(this, teams);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_delete_team, menu);
        return true;
    }

    public void deleteTeam(View view)
    {
        Button selected = (Button)view;
        Iterator<Map.Entry<String, TeamRoster>> iter = MainActivity.TeamData.rosterDatabase.entrySet().iterator();
        while (iter.hasNext())
        {
            Map.Entry<String, TeamRoster> entry = iter.next();
            //If the value of the entry equals the text of the EditText field
            if (entry.getValue().teamName.equals(selected.getText().toString()))
            {
                //Remove the object
                iter.remove();
            }

        }
        viewTeams();
    }
    public void backToMain(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
