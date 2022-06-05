# La Marianno

A prototype app for an imaginary pizza place

![image](https://user-images.githubusercontent.com/30511514/172006878-db7b0fe1-86b8-4e72-ad6f-eb6fadf5b3b8.png)


## App contents
All the functionalities inside this app. Everything codded here was mainly learned from [Android Developers website](https://developer.android.com/courses/kotlin-android-fundamentals/overview "Android Kotlin Fundamentals") and YouTube Android Kotlin tutorials. 

### Navigation Drawer


The  navigation menu of the app. Used to navigate from one fragment to another. The layout is composed from the nav_header_main2.xml and the activity_main2_drawer.xml. The functional code can be found in the MainActivity.kt. More info can be found here: [Fragments and Navigation](https://developer.android.com/codelabs/kotlin-android-training-create-and-add-fragment?index=..%2F..android-kotlin-fundamentals "Android Developers - Navigation").

![image](https://user-images.githubusercontent.com/30511514/172007585-59d43852-3966-4629-ada1-af8bce8d8559.png)

### RecyclerView


The RecyclerView it is used when you have a list of objects alike (a list of pizza names), reusing the same layout items to use less memory. The layout for the list can be found in fragment_gallery.xml and the layout for an item can be found in item_layout.xml. The RecyclerView is used inside the Gallery fragment and it is used to display a list of pizza. The RecyclerView adapter can be found in RecyclerAdapter.kt. To it is is given a list of items to be displayed and he does it inside the gallery_fragment.xml layout. More info about it can be found here: [RecyclerView](https://developer.android.com/codelabs/kotlin-android-training-recyclerview-fundamentals?index=..%2F..android-kotlin-fundamentals "Android Developers - RecylcerView").

![image](https://user-images.githubusercontent.com/30511514/172007664-73ff6396-349b-4a28-bf99-439b22ee3f1a.png)

### Search Bar


Inside the Gallery fragment there is an widget called searchView that it is used to implement the basic search function inside the pizza names list. Every time something is written inside the search bar the recyclerView is updated and the list of pizza that is shown gets updated. For more info about searchView widget visit the reference page here: [SearchView Widget](https://developer.android.com/reference/kotlin/android/widget/SearchView "Android Developers Reference - SearchView").

![image](https://user-images.githubusercontent.com/30511514/172007726-83222b18-7bde-4d3d-8ab3-9b3a5ec95bb8.png)

### Share


Inside the RecyclerAdapter, whenever an item is inflated into the layout, an on click event listener is added to that item. Whenever you click an item the share option is shown inside the app. Inside the code we sent an intent with the action SEND and the type text/plain. After that we call startActivity of that intent. Fore more info check this page here: [Sharing simple data](https://developer.android.com/training/sharing "Android Developers training - Sharing simple data").

![image](https://user-images.githubusercontent.com/30511514/172007765-b31ce463-c332-4b9d-b189-d9f51604ec05.png)

### Camera activity


The last function implemented inside this app is the ability to take a picture inside the Camera fragment. The first thing I had to do was to add the permission to use the camera inside the AndroidManifest.xml file. After that, the camera fragment has a button that when you click on it an intent is created with the action IMAGE_CAPTURE, and, after we check if the device has an avabile camera (some phones may not have), we start an activity with that intent and with a request code that is random, but must be kept for later inside a variable. After that we wait for the activity to return a result (the request code of that activity has to be the same random number as before), and the camera activity successfully returned a picture we get the image as bitmap and we show it above the button in camera fragment layout. More info about camera activity can be found here: [Take photos](https://developer.android.com/training/camera/photobasics "Android Developers training - camera - photo basics"). 

![image](https://user-images.githubusercontent.com/30511514/172007781-a36a9772-f02d-4582-99dc-39628631749b.png)
