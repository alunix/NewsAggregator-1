package com.ua.art.newsaggregator.navigation;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.ua.art.newsaggregator.R;
import com.ua.art.newsaggregator.service_http.ListNewsView;
import com.ua.art.newsaggregator.model.BaseSourse;

import java.util.ArrayList;
import java.util.Random;

public class ButtonAddTable extends ActionBarActivity implements View.OnClickListener {
    private ArrayList<SuperButton> buttonViewsArr = new ArrayList<>();
    // add Base to News
    private BaseSourse baseSourse = new BaseSourse();
    private Button button_SelectSours;

    //TODO you just have to download again (when the coup add button)
    //@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_modules);

        TableLayout tableLayout = (TableLayout) findViewById(R.id.TableLayout_SelectSours);
        button_SelectSours = (Button) findViewById(R.id.btnNextSelectResource);
        ArrayList<TableRow> tableRowsArr = new ArrayList<>();
        button_SelectSours.setOnClickListener(this);

        int columns = 4;


        // To add TableRow in TableLayout
        newTableRow(baseSourse.selectSourceArr, tableRowsArr, columns);

        addButton(baseSourse.selectSourceArr, columns);
        for (Button elemBtn : buttonViewsArr) {                          // Listener button
            elemBtn.setOnClickListener(this);
        }

        addBtnToRowsArrPARAM(baseSourse.selectSourceArr, tableRowsArr, columns);

        addRowsToTable(tableLayout, tableRowsArr);
    }

    // To add TableRow in TableLayout
    private void newTableRow(ArrayList<String[]> baseSourse, ArrayList<TableRow> tableRowsArr, int columns) {
        int tempIdSize = (int) Math.floor(baseSourse.size() / columns);
        if (baseSourse.size() % columns != 0)       // Quantity TableRow
            tempIdSize += 1;
        for (int i = 0; i < tempIdSize; i++) {
            tableRowsArr.add(new TableRow(this));
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void addButton(ArrayList<String[]> selectSourceArr, int columns) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int btnPadding = 1;
        int widthPixDisplay = (int) displayMetrics.widthPixels / columns;
        widthPixDisplay -= btnPadding;

        for (String[] elem : selectSourceArr) {
            //Button btnArrList = new Button(this);
            SuperButton btnArrList = new SuperButton(this);
            Random random = new Random();
            btnArrList.setId(random.hashCode());
            btnArrList.setWidth(widthPixDisplay);
            btnArrList.setHeight(widthPixDisplay);
            buttonViewsArr.add(btnArrList);

            btnArrList.setText(elem[1].toString()); //Set to any meaningful text
            btnArrList.setTextSize(10);
            btnArrList.setTextColor(Color.parseColor("#ffffff"));

            Drawable image = getResources().getDrawable(Integer.parseInt(elem[3]));
            btnArrList.setBackground(image);
            boolean pressedBtn;
            if (elem[4] == "true") pressedBtn = true;
            else pressedBtn = false;
            btnArrList.setSuperPressureBtn(pressedBtn);
        }
    }


    private void addBtnToRowsArrPARAM(ArrayList<String[]> baseSourse, ArrayList<TableRow> tableRowsArr, int columns) {
        int idSizeSourceArr = 0;
        for (TableRow elemRow : tableRowsArr) {
            for (int i = 0; i < columns; i++, idSizeSourceArr++) {
                if (idSizeSourceArr >= baseSourse.size())
                    return;
                elemRow.addView(buttonViewsArr.get(idSizeSourceArr)); //Attach TextView to its parent (row)
                TableRow.LayoutParams params =
                        (TableRow.LayoutParams) buttonViewsArr.get(idSizeSourceArr).getLayoutParams();
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

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnNextSelectResource) {
            Intent intent = new Intent(this, ListNewsView.class);
            startActivity(intent);
        }

        for (SuperButton elem : buttonViewsArr) {

            if (v.getId() == elem.getId()) {
                Random random = new Random();
                button_SelectSours.setBackgroundColor(random.nextInt());
                //elem.getClipBounds()
                if (elem.getSuperPressureBtn() == false) {
                    Drawable image = getResources().getDrawable(Integer.parseInt(baseSourse.selectSourceArr.get(buttonViewsArr.indexOf(elem))[2]));
                    elem.setBackground(image);
                    elem.setSuperPressureBtn(true);
                } else {
                    Drawable image = getResources().getDrawable(Integer.parseInt(baseSourse.selectSourceArr.get(buttonViewsArr.indexOf(elem))[3]));
                    elem.setBackground(image);
                    elem.setSuperPressureBtn(false);
                }
            }
        }
    }
}
