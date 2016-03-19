# Udacity_Gradle
Used Gradle to build a joke-telling app that has a free and paid flavors. The app consists of four modules:

- A Java library that provides jokes
- A Google Cloud Endpoints (GCE) project that serves those jokes
- An Android Library containing an activity for displaying jokes
- An Android app that fetches jokes from the GCE module and passes them to the Android Library for display

Free version has an interstitial ad which is shown after the user hits the button, and before the joke is shown.

While the joke is being retrieved a loading indicator is shown.

Gradle test task launches the GCE local development server, runs all tests and shuts the server down again.
