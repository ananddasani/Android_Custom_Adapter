# Android_Custom_Adapter
Android App Using Custom ArrayAdapter &amp; ListView


# Code

#### MainActivity.java
```
String[] arr = {"item1", "item2", "item3", "item4", "item5", "item6", "item7", "item8", "item9", "item10"};
ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView  = findViewById(R.id.listView);

        MyAdapter ma = new MyAdapter(MainActivity.this, R.layout.my_custom_layout, arr);
        listView.setAdapter(ma);

        //set item click listener in custom adapter file before rendering(returning) view
    }
```

#### MyAdapter.java
```
  public class MyAdapter extends ArrayAdapter {

    private String[] arr;
    private Context context;

    public MyAdapter(@NonNull Context context, int resource, @NonNull String[] arr) {
        super(context, resource, arr);
        this.arr = arr;
        this.context = context;
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return arr[position];
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //first create your own layout (file)

        //Inflate your custom layout to find id of views in it
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.my_custom_layout, parent,false);

        TextView tv = convertView.findViewById(R.id.textView);
        tv.setText(getItem(position));

        //set on click listener before rendering view
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You Clicked item " + (position + 1), Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
```

# App Highlight

<img src="app_images/Custom Adapter Code.png" width="1000" /><br>

<img src="app_images/Custom Adapter App1.png" width="300" /><br>

<img src="app_images/Custom Adapter App2.png" width="300" /><br>
