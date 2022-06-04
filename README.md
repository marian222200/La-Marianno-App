# La Marianno

A prototype app for an imaginary pizza place

![image](https://user-images.githubusercontent.com/30511514/172006878-db7b0fe1-86b8-4e72-ad6f-eb6fadf5b3b8.png)


## App contents
All the functionalities inside this app. Everything codded here were mainly learned from [Android Developers website](https://developer.android.com/courses/kotlin-android-fundamentals/overview "Android Kotlin Fundamentals") and YouTube Android Kotlin tutorials. 

### Navigation Drawer


The  navigation menu of the app. Used to navigate from one fragment to another. The layout is composed from the nav_header_main2.xml and the activity_main2_drawer.xml. The functional code can be found in the MainActivity.kt. More info can be found here: [Fragments and Navigation](https://developer.android.com/codelabs/kotlin-android-training-create-and-add-fragment?index=..%2F..android-kotlin-fundamentals "Android Developers - Navigation").

![image](https://user-images.githubusercontent.com/30511514/172007585-59d43852-3966-4629-ada1-af8bce8d8559.png)

### RecyclerView


The RecyclerView it is used when you have a list of objects alike (a list of pizza names), reusing the same layout items to use less memory. The layout for the list can be found in fragment_gallery.xml and the layout for an item can be found in item_layout.xml. The RecyclerView is used inside the Gallery fragment and it is used to display a list of pizza. The RecyclerView adapter can be found in RecyclerAdapter.kt. To it is is given a list of items to be displayed and he does it inside the gallery_fragment.xml layout. More info about it can be found here: [RecyclerView](https://developer.android.com/codelabs/kotlin-android-training-recyclerview-fundamentals?index=..%2F..android-kotlin-fundamentals "Android Developers - RecylcerView").

![image](https://user-images.githubusercontent.com/30511514/172007664-73ff6396-349b-4a28-bf99-439b22ee3f1a.png)

### Search Bar


Inside the Gallery fragment there is an widget called searchView that it is used to implement the basic search function inside the pizza names list. Every time something is written inside the search bar the recyclerView is updated and the list of pizza that is shown gets updated. For more info about searchView widget visit the reference page here: [SearchView Widget](https://developer.android.com/reference/kotlin/android/widget/SearchView "Android Developers Reference - SearchView").


![image](https://user-images.githubusercontent.com/30511514/172007726-83222b18-7bde-4d3d-8ab3-9b3a5ec95bb8.png)

![image](https://user-images.githubusercontent.com/30511514/172007765-b31ce463-c332-4b9d-b189-d9f51604ec05.png)

![image](https://user-images.githubusercontent.com/30511514/172007781-a36a9772-f02d-4582-99dc-39628631749b.png)
