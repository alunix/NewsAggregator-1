package com.ua.art.newsaggregator;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;

public class ButtonAddTable extends ActionBarActivity implements View.OnClickListener {
    public ArrayList<Button> buttonViewsArr_SelectSours = new ArrayList<>();

    //TODO you just have to download again (when the coup add button)
    //@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_modules);

        TableLayout tableLayout = (TableLayout) findViewById(R.id.TableLayout_SelectSours);
        Button button_SelectSours = (Button) findViewById(R.id.btnNextSelectResource);
        ArrayList<TableRow> tableRowsArr = new ArrayList<>();
        button_SelectSours.setOnClickListener(this);
        int columns = 4;

        // add Base to News
        BaseSourse baseSourse = new BaseSourse();
        // To add TableRow in TableLayout
        newTableRow(baseSourse.selectSourceArr, tableRowsArr, columns);

        addButton(baseSourse.selectSourceArr, columns);

        addBtnToRowsArrPARAM(baseSourse.selectSourceArr, tableRowsArr, columns);

        addRowsToTable(tableLayout, tableRowsArr);
    }

    // To add TableRow in TableLayout
    private void newTableRow(ArrayList<String[]> baseSourse, ArrayList<TableRow> tableRowsArr, int columns) {
        int tempIdSize = (int) Math.floor(baseSourse.size() / columns);
        if (baseSourse.size() % columns != 0)       // Quantity TableRow / количество TableRow
            tempIdSize += 1;
        for (int i = 0; i < tempIdSize; i++) {
            tableRowsArr.add(new TableRow(this));
        }
    }

    private void addButton(ArrayList<String[]> selectSourceArr, int columns) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int btnPadding = 1;
        int widthPixDisplay = (int) displayMetrics.widthPixels / columns;
        widthPixDisplay -= btnPadding;

        for (String[] elem : selectSourceArr) {
            Button btnArrList = new Button(this);
            //btnArrList.setLayoutParams(new LinearLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,  ActionBar.LayoutParams.WRAP_CONTENT, 2));
            btnArrList.setWidth(widthPixDisplay);
            btnArrList.setHeight(widthPixDisplay);
            buttonViewsArr_SelectSours.add(btnArrList);
            btnArrList.setText(elem[1]); //Set to any meaningful text
            btnArrList.setTextSize(10);
            btnArrList.setBackgroundColor(Color.GREEN);
            //btnArrList.setPadding(btnPadding, btnPadding+5, btnPadding, btnPadding);
        }
    }

    private void addBtnToRowsArrPARAM(ArrayList<String[]> baseSourse, ArrayList<TableRow> tableRowsArr, int columns) {
        int idSizeSourceArr = 0;
        for (TableRow elemRow : tableRowsArr) {
            for (int i = 0; i < columns; i++, idSizeSourceArr++) {
                if (idSizeSourceArr >= baseSourse.size())
                    return;
                elemRow.addView(buttonViewsArr_SelectSours.get(idSizeSourceArr)); //Attach TextView to its parent (row)
                TableRow.LayoutParams params =
                        (TableRow.LayoutParams) buttonViewsArr_SelectSours.get(idSizeSourceArr).getLayoutParams();
                params.column = i;
                params.span = 1;
                params.setMargins(3, 3, 3, 3);
                params.width = TableRow.LayoutParams.WRAP_CONTENT;
                params.height = TableRow.LayoutParams.WRAP_CONTENT;
                params.gravity = 9;
            }
        }
    }

    private void addRowsToTable(TableLayout tableLayout, ArrayList<TableRow> tableRowsArr) {
        for (TableRow elemRow : tableRowsArr) {
            tableLayout.addView(elemRow,
                    new TableLayout.LayoutParams
                            (TableRow.LayoutParams.WRAP_CONTENT,
                                    TableRow.LayoutParams.WRAP_CONTENT));
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnNextSelectResource) {
            Intent intent = new Intent(this, ListNewsView.class);
            startActivity(intent);
        }
    }
}
