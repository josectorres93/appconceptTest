# appconceptTest
Arquitecture
Architecture Pattern: MVVM (Model-View-ViewModel)

Model: Represents the data and business logic layer. In this case, the Album class and the repository (AlbumRepository) manage the data and the interactions with the remote and local data sources (API and database).
View: The UI layer which is responsible for displaying the data to the user. In this case, the Composables (AlbumListScreen, AlbumItem) are responsible for displaying the list of albums and handling the UI elements.
ViewModel: Acts as a middle layer that manages the state and interacts with the repository to fetch data. In this case, the AlbumViewModel contains the logic for loading albums, managing the loading state, and exposing the data to the UI layer via LiveData.
Justification for MVVM:

MVVM provides a clear separation of concerns, which helps in managing and testing the application’s logic. The view layer is decoupled from the business logic, which results in easier maintenance and readability.
LiveData allows for the observation of changes in data, making it ideal for building dynamic UIs that react to changes in state (e.g., loading status and album data).
Architecture Components:

ViewModel: Manages UI-related data lifecycle-consciously and is used for data fetching and state management.
Repository: Acts as an abstraction layer over the data sources (Remote API and Local Database).
Database: Local storage using Room, enabling offline persistence and efficient data management.

Design patterns

Singleton 
Is used to ensure that a class has only one instance throughout the application's lifecycle, for exemple when creating the network module
Builder
Is used when configuring the AsyncImagePainter for loading images in the AlbumItem
Observer
Is used to reactively update the UI based on changes in the data.
Dependency Injection
For dependency injection its used Hilt instead of dagger or koin because it simplifies the setup and usage of dependency injection in Android apps by automating much of the boilerplate code required in plain Dagger. For instance, you no longer need to manually define @Component interfaces or handle Subcomponents in Hilt. 

Libs
Room - simplifies the chores of database setup, configuration, and interactions with the app.
Retrofit - simplifies integrating RESTful services 
Coil - helps avoid the complexities of handling image loading manually by focusing on efficiently loading and caching images
Compose - leverages a highly optimized rendering engine, which can result in better UI performance and efficiency compared to XML views
