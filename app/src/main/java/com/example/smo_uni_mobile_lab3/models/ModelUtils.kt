package com.example.smo_uni_mobile_lab3.models

fun fakeData(): List<IListItem> {
    return listOf(
        PostBuilder().id(1)
            .title("Kotlin Builder Pattern")
            .content("Learn how to use the builder pattern in Kotlin.")
            .imageUrl("https://example.com/images/kotlin-builder.jpg")
            .userId(101)
            .build(),

        UserBuilder().id(1)
            .firstName("John")
            .lastName("Doe")
            .email("john.doe@example.com")
            .phone("123-456-7890")
            .build(),

        PostBuilder().id(2)
            .title("Jetpack Compose Basics")
            .content("Understanding the foundations of Jetpack Compose for UI development.")
            .imageUrl("https://example.com/images/jetpack-compose.jpg")
            .userId(102)
            .build(),

        UserBuilder().id(2)
            .firstName("Jane")
            .lastName("Smith")
            .email("jane.smith@example.com")
            .phone("234-567-8901")
            .build(),

        PostBuilder().id(3)
            .title("Exploring Coroutines")
            .content("Learn how coroutines simplify asynchronous programming in Kotlin.")
            .imageUrl("https://example.com/images/coroutines.jpg")
            .userId(103)
            .build(),

        PostBuilder().id(4)
            .title("Dependency Injection in Android")
            .content("How to use Dagger and Hilt for dependency injection in Android projects.")
            .imageUrl("https://example.com/images/di.jpg")
            .userId(104)
            .build(),

        PostBuilder().id(5)
            .title("Working with APIs in Kotlin")
            .content("Fetch and handle API data in Kotlin with Retrofit and Ktor.")
            .imageUrl("https://example.com/images/api-integration.jpg")
            .userId(105)
            .build(),

        UserBuilder().id(3)
            .firstName("Alice")
            .lastName("Johnson")
            .email("alice.johnson@example.com")
            .phone("345-678-9012")
            .build(),

        UserBuilder().id(4)
            .firstName("Bob")
            .lastName("Brown")
            .email("bob.brown@example.com")
            .phone("456-789-0123")
            .build(),

        UserBuilder().id(5)
            .firstName("Charlie")
            .lastName("Davis")
            .email("charlie.davis@example.com")
            .phone("567-890-1234")
            .build(),

        PostBuilder().id(6)
            .title("State Management in Compose")
            .content("Understand state management techniques in Jetpack Compose.")
            .imageUrl("https://example.com/images/state-management.jpg")
            .userId(106)
            .build(),

        PostBuilder().id(7)
            .title("Testing in Android")
            .content("Best practices for writing unit and UI tests in Android apps.")
            .imageUrl("https://example.com/images/testing.jpg")
            .userId(107)
            .build(),

        PostBuilder().id(8)
            .title("LiveData vs Flow")
            .content("Comparison of LiveData and Kotlin Flow for reactive programming.")
            .imageUrl("https://example.com/images/livedata-flow.jpg")
            .userId(108)
            .build(),

        PostBuilder().id(9)
            .title("Database Persistence with Room")
            .content("Using Room to manage local SQLite databases in Android.")
            .imageUrl("https://example.com/images/room.jpg")
            .userId(109)
            .build(),

        PostBuilder().id(10)
            .title("Compose Navigation")
            .content("Implementing navigation between screens in Jetpack Compose.")
            .imageUrl("https://example.com/images/navigation.jpg")
            .userId(110)
            .build()
    )
}

fun tripleFakeData(): List<IListItem> {
    return fakeData().plus(fakeData()).plus(fakeData())
}

fun fakeUsers(): List<User> {
    return listOf(
        UserBuilder()
            .firstName("John")
            .lastName("Doe")
            .email("john.doe@example.com")
            .phone("123-456-7890")
            .build(),
        UserBuilder()
            .firstName("Jane")
            .lastName("Smith")
            .email("jane.smith@example.com")
            .phone("234-567-8901")
            .build(),
        UserBuilder()
            .firstName("Alice")
            .lastName("Johnson")
            .email("alice.johnson@example.com")
            .phone("345-678-9012")
            .build(),
        UserBuilder()
            .firstName("Bob")
            .lastName("Brown")
            .email("bob.brown@example.com")
            .phone("456-789-0123")
            .build(),
        UserBuilder()
            .firstName("Charlie")
            .lastName("Davis")
            .email("charlie.davis@example.com")
            .phone("567-890-1234")
            .build()
    )
}

fun fakePosts(users: List<User>): List<Post> {
    return listOf(
        PostBuilder()
            .title("Kotlin Builder Pattern")
            .content("Learn how to use the builder pattern in Kotlin.")
            .imageUrl("https://example.com/images/kotlin-builder.jpg")
            .userId(users.random().id)
            .build(),
        PostBuilder()
            .title("Jetpack Compose Basics")
            .content("Understanding the foundations of Jetpack Compose for UI development.")
            .imageUrl("https://example.com/images/jetpack-compose.jpg")
            .userId(users.random().id)
            .build(),
        PostBuilder()
            .title("Exploring Coroutines")
            .content("Learn how coroutines simplify asynchronous programming in Kotlin.")
            .imageUrl("https://example.com/images/coroutines.jpg")
            .userId(users.random().id)
            .build(),
        PostBuilder()
            .title("Dependency Injection in Android")
            .content("How to use Dagger and Hilt for dependency injection in Android projects.")
            .imageUrl("https://example.com/images/di.jpg")
            .userId(users.random().id)
            .build(),
        PostBuilder()
            .title("Working with APIs in Kotlin")
            .content("Fetch and handle API data in Kotlin with Retrofit and Ktor.")
            .imageUrl("https://example.com/images/api-integration.jpg")
            .userId(users.random().id)
            .build(),
        PostBuilder()
            .title("State Management in Compose")
            .content("Understand state management techniques in Jetpack Compose.")
            .imageUrl("https://example.com/images/state-management.jpg")
            .userId(users.random().id)
            .build(),
        PostBuilder()
            .title("Testing in Android")
            .content("Best practices for writing unit and UI tests in Android apps.")
            .imageUrl("https://example.com/images/testing.jpg")
            .userId(users.random().id)
            .build(),
        PostBuilder()
            .title("LiveData vs Flow")
            .content("Comparison of LiveData and Kotlin Flow for reactive programming.")
            .imageUrl("https://example.com/images/livedata-flow.jpg")
            .userId(users.random().id)
            .build(),
        PostBuilder()
            .title("Database Persistence with Room")
            .content("Using Room to manage local SQLite databases in Android.")
            .imageUrl("https://example.com/images/room.jpg")
            .userId(users.random().id)
            .build(),
        PostBuilder()
            .title("Compose Navigation")
            .content("Implementing navigation between screens in Jetpack Compose.")
            .imageUrl("https://example.com/images/navigation.jpg")
            .userId(users.random().id)
            .build()
    )
}
