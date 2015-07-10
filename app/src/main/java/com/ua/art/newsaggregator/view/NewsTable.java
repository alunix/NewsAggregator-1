package com.ua.art.newsaggregator.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.ua.art.newsaggregator.model.News;

public class NewsTable {

    private Context mContext;
    private LinearLayout buttons_layout;
    private static final int COLUMNS = 3;
    private int counter = 0;

    public NewsTable(Context mContext, LinearLayout linearLayout) {
        this.mContext = mContext;
        buttons_layout = linearLayout;
    }

    public void createTable() {
        buttons_layout.removeAllViewsInLayout();
        setParamsForLayout(buttons_layout);

        ScrollView scrollView = new ScrollView(mContext);
        buttons_layout.addView(scrollView);

        TableLayout tableLayout = new TableLayout(mContext);
        //tableLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        tableLayout.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        tableLayout.setWeightSum(4);

        double newsCount = (double) News.values().length;
        for (int i = 0; i < Math.ceil(newsCount / COLUMNS); i++) {
            tableLayout.addView(prepareRow());
        }
        scrollView.addView(tableLayout);
    }

    private void setParamsForLayout(LinearLayout linearLayout) {
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
    }

    private View prepareRow() {
        TableRow row = new TableRow(mContext);
        row.setGravity(Gravity.CENTER_HORIZONTAL);
        row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f));
        for (int j = 0; j < COLUMNS; j++, counter++) {
            if (counter < News.values().length) {
                //row.setPadding(0, 0, 10, 0);
                row.addView(prepareButton(News.values()[counter]));
            }
        }
        return row;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private View prepareButton(final News news) {
        final Button button = new Button(mContext);
        button.setText(mContext.getString(news.getRuResource()));
        int width = (mContext.getResources().getDisplayMetrics().widthPixels / COLUMNS)-20;
        button.setWidth(width);
        button.setHeight(width);

        button.setBackground(mContext.getResources().getDrawable(news.getImgResourceClicked()));
        //button.setPadding(10, 10, 10, 10);

        LinearLayout.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(4, 4, 4, 4);

        //layoutParams.span = 1;
        //layoutParams.setMargins(3, 3, 3, 3);
        layoutParams.width = TableRow.LayoutParams.WRAP_CONTENT;
        layoutParams.height = TableRow.LayoutParams.WRAP_CONTENT;
        layoutParams.gravity = 9;

        button.setLayoutParams(layoutParams);
        button.setTag(news.getRuResource());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (news.isClicked()) {
                    news.setClicked(false);
                } else {
                    news.setClicked(true);
                }
                button.setBackground(mContext.getResources().getDrawable(getImgResourceOnClick(news)));
            }
        });
        return button;
    }

    public int getImgResourceOnClick(News news) {
        return news.isClicked() ? news.getImgResourceClicked() : news.getImgResourceUnclicked();
    }


//    private ArrayList<SuperButton> buttonViewsArr = new ArrayList<>();
//    // add Base to News
// //   private BaseSourse baseSourse = new BaseSourse();
//    private Button button_SelectSours;
//
//    //TODO you just have to download again (when the coup add button)
//    //@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.selection_modules);
//
//        TableLayout tableLayout = (TableLayout) findViewById(R.id.TableLayout_SelectSours);
//        button_SelectSours = (Button) findViewById(R.id.btnNextSelectResource);
//        ArrayList<TableRow> tableRowsArr = new ArrayList<>();
//        button_SelectSours.setOnClickListener(this);
//
//        int columns = 4;
//        newTableRow(baseSourse.selectSourceArr, tableRowsArr, columns);
//
//        addButton(baseSourse.selectSourceArr, columns);
//        for (Button elemBtn : buttonViewsArr) {                          // Listener button
//            elemBtn.setOnClickListener(this);
//        }
//
//        addBtnToRowsArrPARAM(baseSourse.selectSourceArr, tableRowsArr, columns);
//
//        addRowsToTable(tableLayout, tableRowsArr);
//    }
//
//    // To add TableRow in TableLayout
//    private void newTableRow(ArrayList<String[]> baseSourse, ArrayList<TableRow> tableRowsArr, int columns) {
//        int tempIdSize = (int) Math.floor(baseSourse.size() / columns);
//        if (baseSourse.size() % columns != 0)       // Quantity TableRow
//            tempIdSize += 1;
//        for (int i = 0; i < tempIdSize; i++) {
//            tableRowsArr.add(new TableRow(this));
//        }
//    }
//
//    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
//    private void addButton(ArrayList<String[]> selectSourceArr, int columns) {
//        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
//        int btnPadding = 1;
//        int widthPixDisplay = (int) displayMetrics.widthPixels / columns;
//        widthPixDisplay -= btnPadding;
//
//        for (String[] elem : selectSourceArr) {
//            //Button btnArrList = new Button(this);
//            SuperButton btnArrList = new SuperButton(this);
//            Random random = new Random();
//            btnArrList.setId(random.hashCode());
//            btnArrList.setWidth(widthPixDisplay);
//            btnArrList.setHeight(widthPixDisplay);
//            buttonViewsArr.add(btnArrList);
//
//            btnArrList.setText(elem[1].toString()); //Set to any meaningful text
//            btnArrList.setTextSize(10);
//            btnArrList.setTextColor(Color.parseColor("#ffffff"));
//
//            Drawable image = getResources().getDrawable(Integer.parseInt(elem[3]));
//            btnArrList.setBackground(image);
//            boolean pressedBtn;
//            if (elem[4] == "true") pressedBtn = true;
//            else pressedBtn = false;
//            btnArrList.setSuperPressureBtn(pressedBtn);
//        }
//    }
//
//
//    private void addBtnToRowsArrPARAM(ArrayList<String[]> baseSourse, ArrayList<TableRow> tableRowsArr, int columns) {
//        int idSizeSourceArr = 0;
//        for (TableRow elemRow : tableRowsArr) {
//            for (int i = 0; i < columns; i++, idSizeSourceArr++) {
//                if (idSizeSourceArr >= baseSourse.size())
//                    return;
//                elemRow.addView(buttonViewsArr.get(idSizeSourceArr)); //Attach TextView to its parent (row)
//                TableRow.LayoutParams params =
//                        (TableRow.LayoutParams) buttonViewsArr.get(idSizeSourceArr).getLayoutParams();
//                params.column = i;
//                params.span = 1;
//                params.setMargins(3, 3, 3, 3);
//                params.width = TableRow.LayoutParams.WRAP_CONTENT;
//                params.height = TableRow.LayoutParams.WRAP_CONTENT;
//                params.gravity = 9;
//            }
//        }
//    }
//
//    private void addRowsToTable(TableLayout tableLayout, ArrayList<TableRow> tableRowsArr) {
//        for (TableRow elemRow : tableRowsArr) {
//            tableLayout.addView(elemRow,
//                    new TableLayout.LayoutParams
//                            (TableRow.LayoutParams.WRAP_CONTENT,
//                                    TableRow.LayoutParams.WRAP_CONTENT));
//        }
//    }
//
//    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
//    @Override
//    public void onClick(View v) {
//        if (v.getId() == R.id.btnNextSelectResource) {
//            Intent intent = new Intent(this, NewsListView.class);
//            startActivity(intent);
//        }
//
//        for (SuperButton elem : buttonViewsArr) {
//
//            if (v.getId() == elem.getId()) {
//                Random random = new Random();
//                button_SelectSours.setBackgroundColor(random.nextInt());
//                //elem.getClipBounds()
//                if (elem.getSuperPressureBtn() == false) {
//                    Drawable image = getResources().getDrawable(Integer.parseInt(baseSourse.selectSourceArr.get(buttonViewsArr.indexOf(elem))[2]));
//                    elem.setBackground(image);
//                    elem.setSuperPressureBtn(true);
//                } else {
//                    Drawable image = getResources().getDrawable(Integer.parseInt(baseSourse.selectSourceArr.get(buttonViewsArr.indexOf(elem))[3]));
//                    elem.setBackground(image);
//                    elem.setSuperPressureBtn(false);
//                }
//            }
//        }
//    }
}
